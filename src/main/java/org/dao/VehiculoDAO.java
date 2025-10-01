package org.dao;

import org.modelo.Vehiculo;

public class VehiculoDAO extends BaseDAO<Vehiculo> {

    public VehiculoDAO() {
        super(Vehiculo.class);
    }

    public Vehiculo buscarPorPlaca(String placa) {
        return executeQuery(session ->
                session.createQuery("FROM Vehiculo v WHERE v.placa = :placa", Vehiculo.class)
                        .setParameter("placa", placa)
                        .uniqueResult()
        );
    }

}
