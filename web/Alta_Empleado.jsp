<%-- 
    Document   : Alta_Empleado
    Created on : 26 ene. 2021, 17:41:19
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alta Empleados</title>
    </head>
    <body>
        <h1>Alta Empleados</h1>
        <form id="peticion" name="peticion" action="AltaEmpleado" method="get">
            <Table>
                <TR>
                    <TD>Nombre:</Td> <Td><input type="text" id="nombre" name="nombre" size="30"required><br></td>
                </TR
                <TR>
                    <TD>Userid:</Td> <Td> <input type="text"  id="userid" name="userid" size="30" required><br></td>
                </TR>
                <TR>
                    <TD>Contraseña:</Td> <Td><input type="text" id="pwd" name="pwd" size="30"required><br></td>
                </TR>
                             
                <TR>
                    <TD>Tipo Usuario:</Td>
                    <Td><select name="tipo_usuario" id="tipo_usuario">
                    <option value="A">Administrador</option>
                    <option value="E">Empleado</option>
                </select><br></td>
                </TR>
                <tr>
                
                </tr>

                <TR>
                    <TD>Nivel Soporte:</Td> <Td><input type="number" id="nivel_soporte" name="nivel_soporte" min="1" max="3" value="1" size="30"required><br></td>
                </TR>
            </table>

            <br>
            <br>
            <br>

            <input type="submit" value="Registrar alta">
        </form>	

        <br><a href="MenuAdmin.jsp">MENU PRINCIPAL</A>
    </body>
</html>
