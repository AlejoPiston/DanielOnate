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
        <title>Listado de terapias</title>
    </head>
    <body>
        <h1>Listado de terapias</h1>
        <hr>
        <table border="1">
            <thead>
                <tr>
                    <th>Paciente: </th>
                    <th>Fecha: </th>
                    <th>Observaci&oacute;n: </th>
                    <th>Responsable: </th>
                    <th>Realizada: </th>
                    <th>
                        <a href="./terapia?command=create">Agregar</a>
                    </th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items = "${terapias}" var="terapia">
                    <tr>
                        <td>${terapia.getCedula()}</td>
                        <td>${terapia.getNombre()}</td>
                        <td>${terapia.getNacimiento()}</td>
                        <td>${terapia.getAltura()}</td>
                        <td>${terapia.getPeso()}</td>
                        <td>${terapia.getEdad()}</td>
                        <td>
                            <a href="./terapia?command=edit&id=${terapia.getPacienteid()}">Editar</a> | 
                            <a href="./terapia?command=find&id=${terapia.getPacienteid()}">Ver</a> | 
                            <a href="./terapia?command=delete&id=${terapia.getPacienteid()}">Borrar</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <button type="reset" value="cancel">
            <a href="./paciente?command=list" style="text-decoration: none; color: black">Listado de pacientes</a>
        </button>
    </body>
</html>
