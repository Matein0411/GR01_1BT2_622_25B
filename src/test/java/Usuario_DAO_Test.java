
import org.junit.jupiter.api.*;
import org.modelo.Usuario;
import org.dao.Usuario_DAO;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Usuario_DAO_Test {

    private Usuario_DAO usuarioDAO;

    @BeforeEach
    void setUp() {
        usuarioDAO = new Usuario_DAO();
    }

    @Test
    void testGuardarYListar() {
        // Crear un nuevo usuario
        Usuario usuario = new Usuario();
        usuario.setNombre("Juan");
        usuario.setEmail("juan@example.com");

        // Guardar el usuario
        usuarioDAO.guardar(usuario);

        // Listar usuarios y verificar que el usuario guardado esté presente
        List<Usuario> usuarios = usuarioDAO.listar();
        assertNotNull(usuarios);
        assertFalse(usuarios.isEmpty());
        assertTrue(usuarios.stream().anyMatch(u -> u.getNombre().equals("Juan") && u.getEmail().equals("juan@example.com")));
    }
}