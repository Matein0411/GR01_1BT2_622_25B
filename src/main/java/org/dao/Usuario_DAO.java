package org.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.modelo.Usuario;

import java.util.List;
public class Usuario_DAO {
    private static SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public void guardar(Usuario usuario){
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(usuario);
        session.getTransaction().commit();
        session.close();
    }

    public List<Usuario> listar(){
        Session session = factory.openSession();
        List<Usuario> usuarios = session.createQuery("FROM Usuario", Usuario.class).list();
        session.close();
        return usuarios;
    }
}
