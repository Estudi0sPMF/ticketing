<%-- 
    Document   : index1
    Created on : 27 ene. 2021, 9:00:15
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login admin</title>
    </head>
    <body>
                   <Table align=center>
<TR>

<TD align=center><h1>Gestión de Tickets - Backend </H1></TD>
</TR>
</Table>

<form id="login" name="login" action="ValidaUsuario" method="post">
<Table>
<TR>
<TD>USERID:</TD> <TD> <input type="text" id="userid" name="userid" size="30" required><br></td>
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
