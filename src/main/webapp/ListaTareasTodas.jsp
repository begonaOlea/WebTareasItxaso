<%@page import="com.demo.servicios.*"%>
<%@page import="com.demo.producto.*"%>
<%@page import="java.util.Collection"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <title> TAREAS COMUNES </title>
    </head>
    <body>
        <%@include file="WEB-INF/vista/cabecera.jspf" %>
        <%@include file="WEB-INF/vista/menu.jspf" %>
        <%
            Collection<Tareas> lista = DB.getAllTareas();
        %>
        <h1 style="text-align: center"> TAREAS POR HACER </h1>
        <table class="table table-hover" >
            <tr>
                <th> ID TAREA </th>
                <th> DESCRIPCION </th>
                <th> ID USUARIO </th>
            </tr>
            <% for (Tareas t : lista) {
                    if (t.getEstado() == Estados.TODO) {%>
            <tr>
                <td> <%= t.getIDTarea()%>  </td>
                <td> <%= t.getDescripcion()%></td>
                <td> <%= t.getIDUsuario()%></td>
            </tr>
            <% }
                }%>
        </table>
        </br></br>
        <h1 style="text-align: center"> TAREAS EN PROCESO </h1>
        <table class="table table-hover" >
            <tr>
                <th> ID TAREA </th>
                <th> DESCRIPCION </th>
                <th> ID USUARIO </th>
            </tr>
            <% for (Tareas t : lista) {
                    if (t.getEstado() == Estados.INPROGRESS) {%>
            <tr>
                <td> <%= t.getIDTarea()%>  </td>
                <td> <%= t.getDescripcion()%></td>
                <td> <%= t.getIDUsuario()%></td>
            </tr>
            <% }
                }%>
        </table>
        </br></br>
        <h1 style="text-align: center"> TAREAS FINALIZADAS </h1>
        <table class="table table-hover" >
            <tr>
                <th> ID TAREA </th>
                <th> DESCRIPCION </th>
                <th> ID USUARIO </th>
            </tr>
            <% for (Tareas t : lista) {
                if (t.getEstado() == Estados.DONE) {%>
            <tr>
                <td> <%= t.getIDTarea()%>  </td>
                <td> <%= t.getDescripcion()%></td>
                <td> <%= t.getIDUsuario()%></td>
            </tr>
            <% }
                }%>
        </table>
        <hr>
        <a href="NuevaTarea.jsp" class="btn btn-primary"> NUEVA TAREA </a>
    </body>
</html>
