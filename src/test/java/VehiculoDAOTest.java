import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.dao.UsuarioDAO;
import org.dao.VehiculoDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelo.Vehiculo;

public class VehiculoDAOTest {

    private VehiculoDAO vehiculoDAO;

    @BeforeEach
    public void setUp() {
        vehiculoDAO = new VehiculoDAO();
    }

    @Test
    public void testGuardarYListar() {

        vehiculoDAO.borrar(1L);

        // Crear un nuevo vehículo
        Vehiculo vehiculo = new Vehiculo();

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        vehiculo.setUsuario(usuarioDAO.buscarPorId((long) 1));

        vehiculo.setPlaca("ABC123");
        vehiculo.setMarca("Toyota");
        vehiculo.setModelo("Corolla");
        vehiculo.setAnio(2020);

        // Guardar el vehículo
        vehiculoDAO.guardar(vehiculo);

        // Listar vehículos y verificar que el vehículo guardado esté presente
        List<Vehiculo> vehiculos = vehiculoDAO.listar();
        assertNotNull(vehiculos);
        assertFalse(vehiculos.isEmpty());
        assertTrue(vehiculos.stream().anyMatch(v -> v.getPlaca().equals("ABC123") && v.getUsuario().getId().equals(usuarioDAO.buscarPorId((long) 1).getId())));
        
    }

}
