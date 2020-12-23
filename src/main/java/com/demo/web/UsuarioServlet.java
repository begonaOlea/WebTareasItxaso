package com.demo.web;

import com.demo.producto.Tareas;
import com.demo.producto.Usuario;
import com.demo.servicios.DB;
import java.io.IOException;
import java.util.Collection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "UsuarioServlet", urlPatterns = {"/lista-tarea-usuario"})
public class UsuarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("usuario") == null) {
            resp.sendRedirect("Login.jsp");
        } else {
            Usuario usr = (Usuario) session.getAttribute("usuario");

            Collection<Tareas> tareasUsr = DB.getTareasPorUsuario(usr);

            req.setAttribute("lista", tareasUsr);

            RequestDispatcher rd = req.getRequestDispatcher("ListaTareaPorUsuario.jsp");
            rd.forward(req, resp);
        }
    }
}
