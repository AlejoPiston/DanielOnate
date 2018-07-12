<%-- 
    Document   : find
    Created on : 14/05/2018, 11:21:17
    Author     : labctr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Datos del Paciente</title>
    </head>
    <body>
        <h1>Est&aacute; seguro de eliminar este paciente?</h1>
        <!--<hr>-->
        <fieldset>
            <legend><h2>${paciente.getNombre()}</h2></legend>
            <span>Cedula:${paciente.getCedula()}</span>
            <br>            
            <span>Fecha de Nacimiento:${paciente.getNacimiento()}</span>
            <br>
            <span>Estaura:${paciente.getAltura()}</span>
            <br>
            <span>Peso:${paciente.getPeso()}</span>
        </fieldset>
        <form action="./paciente" method="POST">
            <input type="hidden" id="id" name="id" value="${paciente.getPacienteid()}"/>
            <input type="hidden" id="action" name="action" value="delete"/>
            <button type="submit" id="command" name="command" value="save">Borrar</button>
            <button type="reset" value="cancel">
                <a href="./paciente?command=list" style="text-decoration: none; color: black"/>Cancelar</a>
            </button>
        </form>
    </body>
</html>