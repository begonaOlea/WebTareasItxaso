package com.demo.web;

import com.demo.servicios.DB;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "TodoAInprogress", urlPatterns = {"/todo-inprogress"})
public class TodoAInprogress extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // ATRIBUTOS
           String paramIdTarea = req.getParameter("id");
                      
           boolean valido = true;
           int id = 0;
           
           String mensajeIdTarea = null;
           
           if(paramIdTarea == null || paramIdTarea.trim().length() == 0){
               mensajeIdTarea = "Debe seleccionar un ID valido.";
               valido = false;
           }
           
           if(mensajeIdTarea == null){
               id = Integer.parseInt(paramIdTarea);
               DB.TodoAInprocess(id);
           }
           
        RequestDispatcher rd = req.getRequestDispatcher("ListaTareaPorUsuario.jsp");
        req.setAttribute("mensajeIdTarea", mensajeIdTarea);
        rd.forward(req, resp);
    }
    
}
