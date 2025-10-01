package org.web;

import java.io.IOException;
import java.util.List;

import org.dao.UsuarioDAO;
import org.modelo.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/usuarios", "/usuarios/nuevo"})
public class UsuarioServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final UsuarioDAO usuarioDAO = new UsuarioDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String path = req.getServletPath();
        if ("/usuarios/nuevo".equals(path)) {
            // mostrar formulario
            req.getRequestDispatcher("/WEB-INF/views/newUser.jsp").forward(req, resp);
            return;
        }

        List<Usuario> usuarios = usuarioDAO.listar();
        req.setAttribute("usuarios", usuarios);
        req.getRequestDispatcher("/WEB-INF/views/users.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String path = req.getServletPath();
        if ("/usuarios/nuevo".equals(path)) {
            String nombre = req.getParameter("nombre");
            String correo = req.getParameter("correo");
            String telefono = req.getParameter("telefono");

            if (nombre == null || correo == null || telefono == null) {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Faltan datos");
                return;
            }

            Usuario u = new Usuario(nombre, correo, telefono);
            usuarioDAO.guardar(u);
            resp.sendRedirect(req.getContextPath() + "/usuarios");
            return;
        }

        resp.sendError(HttpServletResponse.SC_NOT_FOUND);
    }
}
