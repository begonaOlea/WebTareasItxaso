package com.demo.web;

import com.demo.excepciones.DBException;
import com.demo.producto.Estados;
import com.demo.producto.Tareas;
import com.demo.servicios.DB;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "NuevaTareaServlet", urlPatterns = {"/nueva-tarea"})
public class NuevaTareaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // ATRIBUTOS
        String paramIdTar = req.getParameter("idTar");
        String paramDescripcion = req.getParameter("descripcion");
        String paramIdUsr = req.getParameter("idUsr");

        String jspAMostrar = "";
        int idTar = 0;
        int idUsr = 0;
        boolean valido = true;

        String mensajeIdTar = null;
        String mensajeDescripcion = null;
        String mensajeIdUsr = null;
        String mensajeException = null;

        // VALIDAR
        if (paramIdTar == null || paramIdTar.trim().length() == 0) {
            mensajeIdTar = "Debe indicar el ID de la tarea";
            valido = false;
        }

        if (paramDescripcion == null || paramDescripcion.trim().length() == 0) {
            mensajeDescripcion = "Debe indicar una descripcion.";
            valido = false;
        }

        if (paramIdUsr == null || paramIdUsr.trim().length() == 0) {
            mensajeIdUsr = "Debe indicar el ID del usuario.";
            valido = false;
        }

        if (mensajeIdTar == null || mensajeDescripcion == null || mensajeIdUsr == null) {
            idTar = Integer.parseInt(paramIdTar);
            idUsr = Integer.parseInt(paramIdUsr);
            Tareas tarea = new Tareas(idTar, paramDescripcion, Estados.TODO, idUsr);
            try {
                DB.altaTarea(tarea);
            } catch (DBException ex) {
                mensajeException = ex.getMessage();
            }
        }

        if (valido) {
            jspAMostrar = "ListaTareasTodas.jsp";
        } else {
            jspAMostrar = "NuevaTarea.jsp";
            req.setAttribute("mensajeIdTar", mensajeIdTar);
            req.setAttribute("mensajeDescripcion", mensajeDescripcion);
            req.setAttribute("paramIdUsr", paramIdUsr);
            req.setAttribute("mensajeException", mensajeException);
        }

        RequestDispatcher rd = req.getRequestDispatcher(jspAMostrar);
        rd.forward(req, resp);
    }
}
