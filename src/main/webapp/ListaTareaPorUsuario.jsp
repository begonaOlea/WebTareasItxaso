<%@page import="com.demo.producto.Estados"%>
<%@page import="com.demo.servicios.DB"%>
<%@page import="java.util.Collection"%>
<%@page import="com.demo.producto.Tareas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> TAREA USUARIO </title>
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
                <th> ESTADO </th>
                <th> ID USUARIO </th>
                <th> EN PROCESO </th>
            </tr>
            <% for (Tareas t : lista) {
                    if (t.getEstado() == Estados.TODO) {
                        %>
            <tr>
                <td> <%= t.getIDTarea()%>  </td>
                <td> <%= t.getDescripcion()%></td>
                <td> <%= t.getEstado().getValor()%> </td>
                <td> <%= t.getIDUsuario()%></td>
                <td> CREA UN SERVLET </td>
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
                <th> ESTADO </th>
                <th> ID USUARIO </th>
            </tr>
            <% for (Tareas t : lista) {
                    if (t.getEstado() == Estados.INPROGRESS) {%>
            <tr>
                <td> <%= t.getIDTarea()%>  </td>
                <td> <%= t.getDescripcion()%></td>
                <td> <%= t.getEstado().getValor()%> </td>
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
                <th> ESTADO </th>
                <th> ID USUARIO </th>
            </tr>
            <% for (Tareas t : lista) {
                if (t.getEstado() == Estados.DONE) {%>
            <tr>
                <td> <%= t.getIDTarea()%>  </td>
                <td> <%= t.getDescripcion()%></td>
                <td> <%= t.getEstado().getValor()%> </td>
                <td> <%= t.getIDUsuario()%></td>
            </tr>
            <% }
                }%>
        </table>
    </body>
</html>
