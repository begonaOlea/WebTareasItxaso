<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <title> NUEVA TAREA </title>
    </head>
    <body>
        <body>
        <%@include file="WEB-INF/vista/cabecera.jspf" %>
        <%@include file="WEB-INF/vista/menu.jspf" %>
        <h1 style="text-align: center"> AÑADIR NUEVA TAREA </h1>         
        <form action="nueva-tarea" method="post">
            <div class="row">
                <div class="col">
                    <label for='idTar'> ID Tarea:  </label>
                    <input type='number' class="form-control" id='idTar' name="idTar" placeholder="${requestScope.mensajeIdTar}" /> </br>
                </div>
            </div>
            <div class="row">
                <div class="col"> 
                    <label for='descripcion'> Descripcion:  </label>
                    <input type='text' class="form-control" id='descripcion' name="descripcion" placeholder="${requestScope.mensajeDescripcion}"/> </br>
                </div>
                </div>
            <div class="row">    
                <div class="col"> 
                    <label for='idUsr'> ID Usuario:  </label>
                    <input type='number' class="form-control" id='idUsr' name="idUsr" placeholder="${requestScope.mensajeIdUsr}"/> </br>
                </div>
            </div>
            <button type='submit' class="btn btn-primary"> Añadir tarea </button>
        </form>
    </body>
</html>
