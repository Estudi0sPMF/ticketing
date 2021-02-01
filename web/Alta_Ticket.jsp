<%-- 
    Document   : Alta_Ticket
    Created on : 27 ene. 2021, 11:26:00
    Author     : HP
--%>

<%@page session="true"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession sesion = request.getSession();

%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alta ticket</title>
    </head>
    <body>
        <h1>Alta Ticket</h1>

        <table border="1">
            <tr>
                <td rowspan="2"><b>TIENDA:</b></td>
                <td><b>ID</b></td>
                <td><B>NOMBRE</B></td>
                <td><B>TELEFONO</B></td>
            </tr>
            <tr>
                <TD><%=(Integer) sesion.getAttribute("idtienda")%></TD>
                <TD><%=(String) sesion.getAttribute("nombre")%></TD>
                <TD><%=(String) sesion.getAttribute("telefono")%></TD>
            </tr>
        </table>
        <br>
        <br>
        <br>
        <form id="altaticket" name="altaticket" action="AltaTicket" method="get">
            <Table border="1">

                <TR>
                    <TD><B>TIPO INCIDENCIA:</B></Td>
                    <Td><select name="tipo_incidencia" id="tipo_incidencia">
                            <option value="HW">Hardware</option>
                            <option value="SO">Sistema Operativo</option>
                            <option value="APP">Fallo Aplicación</option>
                            <option value="USO">Formacion</option>
                        </select><br></td>

                </TR>
                
                <tr>
                    <td><B>DESCRIPCIÓN:</B></td>
                    <td><textarea name="descripcion_problema" cols="30" rows="10">Escriba una breve descripción del problema</textarea>
                </tr>


            </table>

            <br>
            <br>
            <br>

            <input type="submit" value="Registrar alta">
        </form>	

        <br><a href="index.jsp">SIGN OFF</A>
    </body>
</html>
