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
        <title>Registro de nueva terapia</title>
    </head>
    <body>
        <h1>Registro de nueva terapia</h1>
        <hr>
        <form action="./terapia" method="POST">
            <label>Paciente: </label>
            <select name="pacienteid" id="pacienteid">
                <option value="0">--Seleccione--</option>
                <c:forEach items="${pacientes}" var="pac">
                    <option value="${pac.getPacienteid()}">${pac.getNombre()}</option>
                </c:forEach>
            </select>
            <br>

            <label>Fecha: </label>
            <input type="date" id="fechaterapia" name="fechaterapia" placeholder="Ingrese la feha" required>
            <br>

            <label>Observaci&oacute;n: </label>
            <input type="text" id="observacion" name="observacion" placeholder="Ingrese observación"  required>
            <br>


            <label>Responsable: </label>
            <select id="responsable" name="responsable" placeholder="Seleccione responsable"  required>
                <option>--Seleccione--</option>
                <option>Luis</option>
                <option>Anita</option>
                <option>Juan</option>
                <option>Rosita</option>
            </select>
            <br>
            
            <label>Realizada: </label>
            <input type="checkbox" name="realizada" value="realizada">
            <br>

            <button type="submit" value="save" name="command">Crear</button>
            <button type="reset" value="cancel">
                <a href="./terapia?command=list" style="text-decoration: none; color: black"/>Cancelar</a>
            </button>
        </form>
    </body>
</html>
