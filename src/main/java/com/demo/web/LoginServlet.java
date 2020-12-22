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
       String paramApodo = req.getParameter("apodo");
       String paramContraseña = req.getParameter("contrasena");
       
       boolean valido = true;
       String jspAMostrar = null;
       
       String mensajeApodo = null;
       String mensajeContraseña = null;
       String mensajeException = null;
       
       // VALIDAR
       if(paramApodo == null || paramApodo.trim().length() == 0){
           mensajeApodo = "Debe indicar un apodo";
           valido = false;
       }
       
       if(paramContraseña == null || paramContraseña.trim().length() == 0){
           mensajeContraseña = "Debe indicar un contraseña";
           valido = false;
       }
       
       if(mensajeApodo == null || mensajeContraseña == null){
           HttpSession sesion = req.getSession();
           LoginService servicio = new LoginService();
           try {
               servicio.logIn(paramApodo, paramContraseña, sesion);
           } catch (LoginException ex) {
               mensajeException = ex.getMessage();
               valido = false;
           }
       }
        
       if(valido){
           jspAMostrar = "ListaTareaPorUsuario.jsp";
       } else {
           jspAMostrar = "Login.jsp";
           req.setAttribute("mensajeApodo", mensajeApodo);
           req.setAttribute("mensajeContraseña", mensajeContraseña);
           req.setAttribute("mensajeException", mensajeException);
       }
       
       RequestDispatcher rd = req.getRequestDispatcher(jspAMostrar);
       rd.forward(req, resp);
       
    }
    
}
