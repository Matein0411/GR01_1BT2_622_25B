package org.web;

import java.io.IOException;
import java.util.List;

import org.dao.UsuarioDAO;
import org.dao.VehiculoDAO;
import org.modelo.Usuario;
import org.modelo.Vehiculo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/vehiculos", "/vehiculos/nuevo"})
public class VehiculoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final VehiculoDAO vehiculoDAO = new VehiculoDAO();
    private final UsuarioDAO usuarioDAO = new UsuarioDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String path = req.getServletPath();
        if ("/vehiculos/nuevo".equals(path)) {
            // pasar lista de usuarios al formulario para seleccionar dueño
            List<Usuario> usuarios = usuarioDAO.listar();
            req.setAttribute("usuarios", usuarios);
            req.getRequestDispatcher("/WEB-INF/views/newVehiculo.jsp").forward(req, resp);
            return;
        }

        List<Vehiculo> vehiculos = vehiculoDAO.listar();
        req.setAttribute("vehiculos", vehiculos);
        req.getRequestDispatcher("/WEB-INF/views/vehiculos.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String path = req.getServletPath();
        if ("/vehiculos/nuevo".equals(path)) {
            String placa = req.getParameter("placa");
            String marca = req.getParameter("marca");
            String modelo = req.getParameter("modelo");
            String anioStr = req.getParameter("anio");
            String usuarioIdStr = req.getParameter("usuarioId");

            if (placa == null || usuarioIdStr == null) {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Faltan datos");
                return;
            }

            Long usuarioId = Long.parseLong(usuarioIdStr);
            Usuario u = usuarioDAO.buscarPorId(usuarioId);
            if (u == null) {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Usuario no existe");
                return;
            }

            int anio = 0;
            try {
                anio = Integer.parseInt(anioStr);
            } catch (Exception e) {
                // ignore, quedará 0
            }

            Vehiculo v = new Vehiculo(u, placa, marca, modelo, anio);
            vehiculoDAO.guardar(v);
            resp.sendRedirect(req.getContextPath() + "/vehiculos");
            return;
        }

        resp.sendError(HttpServletResponse.SC_NOT_FOUND);
    }
}
