package com.demo.web;

import com.demo.servicios.DB;
import java.io.IOException;
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
        String paramEstado = req.getParameter("nuevoEstado");
        
        int id = 0;
        boolean valido = true;

        String mensajeId = null;
        String mensajeEstado = null;
        String mensajeException = null;

        // VALIDAR
        if (paramId == null || paramId.trim().length() == 0) {
            mensajeId = "Debe seleccionar un ID valido.";
            valido = false;
        }

        if (paramEstado == null || paramEstado.trim().length() == 0) {
            mensajeEstado = "Debe seleccionar el estado al que cambiar.";
            valido = false;
        }

        if(mensajeEstado == null || mensajeId == null){
            id = Integer.parseInt(paramId);
            switch(paramEstado){
                case "hacer":
                    DB.CambiarEstado(id, paramEstado);
                case "enproceso":
                    DB.CambiarEstado(id, paramEstado);
                case "hecho":
                    DB.CambiarEstado(id, paramEstado);
            }
            
        }
        
        if (! valido){
            req.setAttribute("mensajeId", mensajeId);
            req.setAttribute("mensajeEstado", mensajeEstado);
        }
        
        RequestDispatcher rd = req.getRequestDispatcher("ListaTareaPorUsuario.jsp");
        rd.forward(req, resp);
    }
}
