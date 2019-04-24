<%-- 
    Document   : factura
    Created on : 02-mar-2019, 20:56:54
    Author     : FAMILIA NOVOA
--%>

<%@page import="VO.ProcesoVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.ProcesoDAO"%>
<%@page import="VO.UsuarioVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       
        <h1>Su factura</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>Nombre</th>
                    <th>Id</th>
                    <th>Telefono</th>
                    <th>Email</th>
                    <th>Servicio</th>
                    <th>Numeroequipos</th>
                    <th>Numerodias</th>
                    <th>Diasadicionales</th>
                    <th>Valoralquiler</th>
                    <th>valordiasdicionales</th>
                    <th>Descuentos</th>
                    <th>ValorDomicilio</th>
                    <th>Total a pagar</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                   
                    <td><%= request.getAttribute("nombre") %></td>
                    <td><%= request.getAttribute("id")%></td>
                    <td><%= request.getAttribute("telefono")%></td>
                    <td><%= request.getAttribute("email")%></td>
                    <td><%= request.getAttribute("servicio")%></td>
                    <td><%= request.getAttribute("numeroequipos")%></td>
                    <td><%= request.getAttribute("numerodias")%></td>
                    <td><%= request.getAttribute("numerodiasadicionales")%></td>
                    <td><%= request.getAttribute("valoralquiler")%></td>
                    <td><%= request.getAttribute("valordiasadicionales")%></td>
                    <td><%= request.getAttribute("descuentos")%></td>
                    <td><%= request.getAttribute("valordomicilio")%></td>
                    <td><%= request.getAttribute("totalapagar")%></td>
                   
                </tr>
            </tbody>
        </table>

    </body>
</html>
