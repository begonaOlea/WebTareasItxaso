package com.demo.web;

import com.demo.servicios.DB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CambioEstadoServlet", urlPatterns = {"/cambio-estado"})
public class CambioEstadoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // PARAMETROS
        String paramId = req.getParameter("id");
        String paramActualEstado = req.getParameter("actualEstado");
        String paramNuevoEstado = req.getParameter("nuevoEstado");

        int id = 0;
        boolean valido = true;

        String mensajeId = null;
        String mensajeActualEstado = null;
        String mensajeNuevoEstado = null;
        String mensajeTodoInprogress = null;
        String mensajeException = null;

        // VALIDAR
        if (paramId == null || paramId.trim().length() == 0) {
            mensajeId = "Debe seleccionar un ID valido.";
            valido = false;
        }

        if (paramActualEstado == null || paramActualEstado.trim().length() == 0) {
            mensajeActualEstado = "Debe seleccionar el estado actual.";
            valido = false;
        }
        
        if (paramNuevoEstado == null || paramNuevoEstado.trim().length() == 0) {
            mensajeNuevoEstado = "Debe seleccionar el estado al que cambiar.";
            valido = false;
        }

        if (paramActualEstado.equals("hacer") && paramNuevoEstado.equals("enproceso")) {
            id = Integer.parseInt(paramId);
            DB.TodoAInprocess(id);
        }
        
        if (paramActualEstado.equals("hacer") && paramNuevoEstado.equals("hecho")) {
            id = Integer.parseInt(paramId);
            DB.TodoADone(id);
        }
        
        RequestDispatcher rd = req.getRequestDispatcher("ListaTareaPorUsuario.jsp");
        req.setAttribute("mensajeId", mensajeId);
        rd.forward(req, resp);
    }
}
