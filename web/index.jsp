<%-- 
    Document   : index
    Created on : 26 ene. 2021, 13:24:16
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login empleado</title>
    </head>
    <body>
                       <Table align=center>
<TR>

<TD align=center><h1>Gestión de Tickets - Tienda</H1></TD>
</TR>
<tr>
    <td><input type="image" name="equipo_remedio" src="IMG/Equipo_remedios.png"></td>
</tr>
</Table>

<form id="login" name="login" action="ValidaTienda" method="post">
<Table>
<TR>
<TD>TIENDA:</TD> <TD> <input type="text" id="userid" name="userid" size="30" required><br></td>
</TR>
<TR>
<TD>PASSWORD:</TD><TD><input type="password" id="password" name="password" size="30" required><br></td>
</TR>

</table>
<br>
<br>
<br>

<input type="submit" value="Enter">
    </body>
</html>
