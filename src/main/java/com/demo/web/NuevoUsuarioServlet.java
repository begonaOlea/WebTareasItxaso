package com.demo.web;

import com.demo.excepciones.DBException;
import com.demo.producto.Estados;
import com.demo.producto.Tareas;
import com.demo.producto.Usuario;
import com.demo.servicios.DB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "NuevoUsuarioServlet", urlPatterns = {"/nuevo-usuario"})
public class NuevoUsuarioServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // ATRIBUTOS
        String paramId = req.getParameter("id");
        String paramUsuario = req.getParameter("usuario");
        String paramNombre = req.getParameter("nombre");
        String paramApellido = req.getParameter("apellido");
        String paramContraseña = req.getParameter("contrasena");

        String jspAMostrar = "";
        int id = 0;
        boolean valido = true;

        String mensajeId = null;
        String mensajeUsuario = null;
        String mensajeNombre = null;
        String mensajeApellido = null;
        String mensajeContraseña = null;
        String mensajeException = null;

        // VALIDAR
        if (paramId == null || paramId.trim().length() == 0) {
            mensajeId = "Debe indicar el ID";
            valido = false;
        }

        if (paramUsuario == null || paramUsuario.trim().length() == 0) {
            mensajeUsuario = "Debe indicar el usuario.";
            valido = false;
        }

        if (paramNombre == null || paramNombre.trim().length() == 0) {
            mensajeNombre = "Debe indicar el nombre.";
            valido = false;
        }

        if (paramApellido == null || paramApellido.trim().length() == 0) {
            mensajeApellido = "Debe indicar el apellido.";
            valido = false;
        }
        if (paramContraseña == null || paramContraseña.trim().length() == 0) {
            mensajeContraseña = "Debe indicar la contraseña.";
            valido = false;
        }

        if (mensajeId == null || mensajeUsuario == null || mensajeNombre == null || mensajeApellido == null || mensajeContraseña == null) {
            id = Integer.parseInt(paramId);
            Usuario usr = new Usuario(id, paramUsuario, paramNombre, paramApellido, paramContraseña);
            try {
                DB.altaUsuario(usr);
            } catch (DBException ex) {
                mensajeException = ex.getMessage();
            }
        }

        if (valido) {
            jspAMostrar = "ListaTareasTodas.jsp";
        } else {
            jspAMostrar = "NuevaUsuario.jsp";
            req.setAttribute("mensajeId", mensajeId);
            req.setAttribute("mensajeUsuario", mensajeUsuario);
            req.setAttribute("mensajeNombre", mensajeNombre);
            req.setAttribute("mensajeApellido", mensajeApellido);
            req.setAttribute("mensajeContraseña", mensajeContraseña);
            req.setAttribute("mensajeException", mensajeException);
        }

        RequestDispatcher rd = req.getRequestDispatcher(jspAMostrar);
        rd.forward(req, resp);
    }
    
}
