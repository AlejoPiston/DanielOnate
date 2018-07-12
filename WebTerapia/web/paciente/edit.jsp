<%-- 
    Document   : edit
    Created on : 16/05/2018, 10:06:37
    Author     : JAEL ARMAS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Editar Paciente</h1>
        <hr>
        <form action="./paciente" method="POST">
            <label>C&eacute;dula: </label>
            <input type="text" id="cedula" name="cedula" placeholder="Ingrese su c&eacute;dula" value="${paciente.getCedula()}" required />
            <br>


            <label>Nombre: </label>
            <input type="text" id="nombre" name="nombre" placeholder="Ingrese su nombre" value="${paciente.getNombre()}" required />
            <br>


            <label>Fecha de Nacimiento: </label>
            <input type="date" id="fechanacimiento" name="fechanacimiento" placeholder="Ingrese su fecha de nacimiento" value="${paciente.getFecha()}" required/>
            <br>

            <label>Estatura: </label>
            <input type="number" id="estatura"  min="100" max="235" name="estatura" value="${paciente.getEstatura()}"/>
            <br>

            <label>Peso: </label>
            <input type="number" id="peso"  min="32" max="275" name="peso" value="${paciente.getPeso()}"/>
            <br>

            <input type="hidden" id="id" name="id" value="${paciente.getPacienteid()}"/>
            <input type="hidden" id="action" name="action" value="update"/>

            <button type="submit" value="save" name="command">Guardar</button>
            <button type="reset" value="cancel">
                <a href="./paciente?command=list" style="text-decoration: none; color: black">Cancelar</a>
            </button>
        </form>
    </body>
</html>
