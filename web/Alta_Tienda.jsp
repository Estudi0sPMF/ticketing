<%-- 
    Document   : Alta_Tienda
    Created on : 26 ene. 2021, 21:35:08
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alta tienda</title>
    </head>
    <body>
        <h1>Alta Tiendas</h1>
        <form id="peticion" name="peticion" action="AltaTienda" method="get">
            <Table>
                <TR>

                <TR>
                    <TD>Nombre:</Td> <Td><input type="text" id="nombre" name="nombre" size="30"required><br></td>
                </TR>
                <TR>
                    <TD>Telefono:</Td> <Td><input type="text" id="telefono" name="telefono" size="30"required><br></td>
                </TR>
                <TR>
                    <TD>Direccion:</Td> <Td><input type="text" id="direccion" name="direccion" size="30"required><br></td>
                </TR>
                <TD>Userid:</Td> <Td> <input type="text"  id="userid" name="userid" size="30" required><br></td>
                </TR>
                <TD>Contraseña:</Td> <Td><input type="text" id="pwd" name="pwd" size="30"required><br></td>

            </table>

            <br>
            <br>
            <br>

            <input type="submit" value="Registrar alta">
        </form>	

        <br><a href="MenuAdmin.jsp">MENU PRINCIPAL</A>
    </body>
</html>
