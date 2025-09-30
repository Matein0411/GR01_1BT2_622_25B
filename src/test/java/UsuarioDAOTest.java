package test.java;

import org.junit.jupiter.api.*;
import org.modelo.Usuario;
import org.dao.UsuarioDAO;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class UsuarioDAOTest {

    private UsuarioDAO usuarioDAO;

    @BeforeEach
    void setUp() {
        usuarioDAO = new UsuarioDAO();
    }

    @Test
    void testGuardarYListar() {
        // Crear un nuevo usuario
        Usuario usuario = new Usuario();
        usuario.setNombre("Juan");
        usuario.setTelefono("123456789");
        usuario.setCorreo("juan@example.com");

        //usuarioDAO.borrar(1L);
        // Guardar el usuario
        usuarioDAO.guardar(usuario);

        // Listar usuarios y verificar que el usuario guardado esté presente
        List<Usuario> usuarios = usuarioDAO.listar();
        assertNotNull(usuarios);
        assertFalse(usuarios.isEmpty());
        assertTrue(usuarios.stream().anyMatch(u -> u.getNombre().equals("Juan") && u.getCorreo().equals("juan@example.com")));
    }
}