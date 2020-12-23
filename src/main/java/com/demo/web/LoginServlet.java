package com.demo.web;

import com.demo.excepciones.LoginException;
import com.demo.servicios.LoginService;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         //LEER PARAMETROS
        String paramCorreo = req.getParameter("correo");
        String paramContraseña = req.getParameter("contrasena");

        boolean valido = true;
        String jspAMostrar = null;

        String mensajeCorreo = null;
        String mensajeContraseña = null;
        String mensajeException = null;

        // VALIDAR
        if (paramCorreo == null || paramCorreo.trim().length() == 0) {
            mensajeCorreo = "Debe indicar un correo.";
            valido = false;
        }

        if (paramContraseña == null || paramContraseña.trim().length() == 0) {
            mensajeContraseña = "Debe indicar una contraseña.";
            valido = false;
        }

        if (mensajeContraseña == null || mensajeCorreo == null || mensajeException == null) {
            //VALIDAR PARAMETROS
            HttpSession sesion = req.getSession();
            LoginService servicio = new LoginService();
            try {
                servicio.logIn(paramCorreo, paramContraseña, sesion);
            } catch (LoginException ex) {
                mensajeException = ex.getMessage();
            }
        }
        
        if (valido) {
            jspAMostrar = "index.jsp";
        } else {
            jspAMostrar = "login.jsp";
            req.setAttribute("mensajeCorreo", mensajeCorreo);
            req.setAttribute("mensajeContraseña", mensajeContraseña);
            req.setAttribute("mensajeException", mensajeException);
        }
        
        RequestDispatcher rd = req.getRequestDispatcher(jspAMostrar);
        rd.forward(req, resp);
    }
 
}
