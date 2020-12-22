package com.demo.web;

import java.io.IOException;
import java.io.PrintWriter;
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
       
       String mensajeApodo = null;
       String mensajeContraseña = null;
       
       // VALIDAR
       if(paramApodo == null || paramApodo.trim().length() == 0){
           mensajeApodo = "Debe indicar un apodo";
       }
       
       if(paramContraseña == null || paramContraseña.trim().length() == 0){
           mensajeContraseña = "Debe indicar un contraseña";
       }
       
       if(mensajeApodo == null || mensajeContraseña == null){
           HttpSession sesion = req.getSession();
       }
        
    }
    
}
