package org.dao;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public abstract class BaseDAO<T> {
    private static final SessionFactory factory = new Configuration().configure().buildSessionFactory();
    private final Class<T> entityClass;

    protected BaseDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected void executeInTransaction(Consumer<Session> operation) {
        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                operation.accept(session);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                throw e;
            }
        }
    }

    protected <R> R executeQuery(Function<Session, R> query) {
        try (Session session = factory.openSession()) {
            return query.apply(session);
        }
    }

    // Métodos CRUD
    public void guardar(T entity) {
        executeInTransaction(session -> session.persist(entity));
    }

    public List<T> listar() {
        return executeQuery(session ->
                session.createQuery("FROM " + entityClass.getSimpleName(), entityClass).list()
        );
    }

    public void borrar(Long id) {
        executeInTransaction(session -> {
            T entity = session.get(entityClass, id);
            if (entity != null) {
                session.remove(entity);
            }
        });
    }

    public void actualizar(T entity) {
        executeInTransaction(session -> session.merge(entity));
    }

    public T buscarPorId(Long id) {
        return executeQuery(session -> session.get(entityClass, id));
    }

    public static void cerrarFactory() {
        if (factory != null && !factory.isClosed()) {
            factory.close();
        }
    }
}
