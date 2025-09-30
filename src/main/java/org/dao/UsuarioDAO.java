package org.dao;

import org.modelo.Usuario;

public class UsuarioDAO extends BaseDAO<Usuario> {
    public UsuarioDAO() {
        super(Usuario.class);
    }

    public Usuario buscarPorCorreo(String correo) {
        return executeQuery(session ->
                session.createQuery("FROM Usuario u WHERE u.correo = :correo", Usuario.class)
                        .setParameter("correo", correo)
                        .uniqueResult()
        );
    }
}
