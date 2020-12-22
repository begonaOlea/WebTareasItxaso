<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title> INICIO </title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </head>
    <body>
        <%@include file="WEB-INF/vista/cabecera.jspf" %>
        <%@include file="WEB-INF/vista/menu.jspf" %>
        <h1 style="text-align: center"> INICIAR SESION </h1>         
        <form action='alta-usuario' method="post">
            <div class="row">
                <div class="col">
                    <label for='apodo'> Apodo:  </label>
                    <input type='text' class="form-control" id='apodo' name="apodo" placeholder="${requestScope.mensajeApodo}" /> </br>
                </div>
            </div>
            <div class="row">
                <div class="col"> 
                    <label for='contrasena'> Contraseña:  </label>
                    <input type='text' class="form-control" id='contrasena' name="contrasena" placeholder="${requestScope.mensajeContraseña}"/> </br>
                </div>
            </div>
            <button type='submit' class="btn btn-primary"> Iniciar sesion </button>
        </form>
    </body>
</html>