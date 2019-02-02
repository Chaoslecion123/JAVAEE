<%-- 
    Document   : index
    Created on : 30/01/2019, 11:41:00 AM
    Author     : fernando
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Formulario</h1>
        <form action="validar" method="POST">
            <input type="text" name="nombre" placeholder="Nombre de Usuario"/>
            <input type="password" name="pass" placeholder="Contraseña de usuario"/>
            <input type="submit" value="Iniciar Sesion"/>
            
        </form>
    </body>
</html>
