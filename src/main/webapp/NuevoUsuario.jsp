<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <title> NUEVO USUARIO </title>
    </head>
    <body>
        <%@include file="WEB-INF/vista/cabecera.jspf" %>
        <%@include file="WEB-INF/vista/menu.jspf" %>
        <h1 style="text-align: center"> INICIAR SESION </h1>         
        <form action="nuevo-usuario" method="post">
            <div class="row">
                <div class="col">
                    <label for='id'> ID:  </label>
                    <input type='number' class="form-control" id='id' name="id" placeholder="${requestScope.mensajeId}" /> </br>
                </div>
            </div>
            <div class="row">
                <div class="col"> 
                    <label for='usuario'> Usuario:  </label>
                    <input type='text' class="form-control" id='usuario' name="usuario" placeholder="${requestScope.mensajeUsuario}"/> </br>
                </div>
            </div>
            <div class="row">
                <div class="col"> 
                    <label for='nombre'> Nombre:  </label>
                    <input type='text' class="form-control" id='nombre' name="nombre" placeholder="${requestScope.mensajeNombre}"/> </br>
                </div>
            </div>
            <div class="row">
                <div class="col"> 
                    <label for='apellido'> Apellido:  </label>
                    <input type='text' class="form-control" id='apellido' name="apellido" placeholder="${requestScope.mensajeApellido}"/> </br>
                </div>
            </div>
            <div class="row">
                <div class="col"> 
                    <label for='contrasena'> Contraseña:  </label>
                    <input type='text' class="form-control" id='contrasena' name="contrasena" placeholder="${requestScope.mensajeContraseña}"/> </br>
                </div>
            </div>
            <button type='submit' class="btn btn-primary"> Añadir usuario </button>
        </form>
                
    </body>
</html>
