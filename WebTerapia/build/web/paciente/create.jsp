<%-- 
    Document   : create
    Created on : 14/05/2018, 10:31:34
    Author     : JAEL ARMAS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de nuevo paciente</title>
    </head>
    <body>
        <h1>Registro de nuevo paciente</h1>
        <hr>
        <form action="./paciente" method="POST">
            <label>C&eacute;dula: </label>
            <input type="text" id="cedula" name="cedula" placeholder="Ingrese su c&eacute;dula"  required />
            <br>


            <label>Nombre: </label>
            <input type="text" id="nombre" name="nombre" placeholder="Ingrese su nombre"  required />
            <br>


            <label>Fecha de Nacimiento: </label>
            <input type="date" id="fechanacimiento" name="fechanacimiento" placeholder="Ingrese su fecha de nacimiento"  required/>
            <br>

            <label>Estatura: </label>
            <input type="number" id="estatura"  min="100" max="235" name="estatura" />
            <br>

            <label>Peso: </label>
            <input type="number" id="peso"  min="32" max="275" name="peso" />
            <br>

            <button type="submit" value="save" name="command">Crear</button>
            <button type="reset" value="cancel">
                <a href="./paciente?command=list" style="text-decoration: none; color: black"/>Cancelar</a>
            </button>
        </form>
    </body>
</html>
