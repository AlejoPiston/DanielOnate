<%-- 
    Document   : list
    Created on : 14/05/2018, 9:47:56
    Author     : JAEL ARMAS JSP + JSTL
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de pacientes</title>
    </head>
    <body>
        <h1>Listado de pacientes</h1>
        <hr>
        <table border="1">
            <thead>
                <tr>
                    <th>C&eacute;dula: </th>
                    <th>Nombre: </th>
                    <th>Fecha de Nacimiento: </th>
                    <th>Estatura: </th>
                    <th>Peso: </th>
                    <th>Edad: </th>
                    <th>
                        <a href="./paciente?command=create">Agregar</a>
                    </th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items = "${pacientes}" var="pac">
                    <tr>
                        <td>${pac.getCedula()}</td>
                        <td>${pac.getNombre()}</td>
                        <td>${pac.getNacimiento()}</td>
                        <td>${pac.getAltura()}</td>
                        <td>${pac.getPeso()}</td>
                        <td>${pac.getEdad()}</td>
                        <td>
                            <a href="./paciente?command=edit&id=${pac.getPacienteid()}">Editar</a> | 
                            <a href="./paciente?command=find&id=${pac.getPacienteid()}">Ver</a> | 
                            <a href="./paciente?command=delete&id=${pac.getPacienteid()}">Borrar</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <button type="reset" value="cancel">
            <a href="./terapia?command=list" style="text-decoration: none; color: black">Listado de terapias</a>
        </button>
    </body>
</html>
