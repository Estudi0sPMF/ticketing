<%-- 
    Document   : Detalle_TK
    Created on : 28 ene. 2021, 11:13:52
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
        <title>manejo ticket</title>
    </head>
    <body>

        <h1> Mantenimiento Ticket</h1>
        <br>
        <br>


        <table border="1">

            <tr>
                <th>Fecha apertura</th>
                <Th>Nº ticket</th>
                <Th>Id Tienda</Th>
                <Th>Nivel</th>
                <th>Tipo Incidencia</th>
                <th>Descripcion</th>
            </tr>
            <tr>
                <TD><%= sesion.getAttribute("det_fecha")%></TD>

                <td><%=(Integer) sesion.getAttribute("det_idticket")%></TD>   

                <TD><%=(Integer) sesion.getAttribute("det_idtienda")%></TD>  
              
                <TD><%=(Integer) sesion.getAttribute("det_nivel")%></TD>

                <td><%=(String) sesion.getAttribute("det_tipoinci")%></td>

                <TD><%=(String) sesion.getAttribute("det_descripcion")%></TD>  

            </tr>
        </table>
                <table>
                <TH>Solución:</TH>
               
                <Form id="solucion" name="solucion" action="CierraTicket" method="get">
                    <TR><TD><textarea name="descripcion_solucion" cols="30" rows="10"></textarea></TD></TR>       
                    <TR><td><input type="submit" name="botoncerrar" value="Solucionado" ></td></TR>
                 </Form>
                </table>
        <Table>
            <tr>
                <td>
                    <form id="manejotk" name="escalar" action="EscalaTicket" method="get">
                        <input type="submit" name="botonescalar" value="Escalar" >
                    </form>
                </td>
               
            </tr>
        </Table>


</body>
</html>
