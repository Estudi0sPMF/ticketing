<%-- 
    Document   : Listado_TicketNOA
    Created on : 27 ene. 2021, 21:29:25
    Author     : HP
--%>


<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.LocalTime"%>
<%@page import="t_clases.Ticket"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
   HttpSession sesion = request.getSession();
   sesion.getAttribute("ListadoTicketNOA");
   ArrayList<Ticket> listadoTicketNOA;
   listadoTicketNOA=(ArrayList)sesion.getAttribute("ListadoTicketNOA");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado Tickets sin asignar</title>
    </head>
    <body>
         <h1>Listado Tickets sin asignar</h1>

        <table border=1>
            <tr>
                <td><B>FECHA APERTURA</B></TD>
                <td><B>Nº TICKET</B></TD>
                <td><B>TIENDA</B></TD>
                <td><B>NIVEL</B></TD>
                <td><B>TIPO INCIDENCIA</B></TD>
                <td><B><CENTER>DESCRIPCION</CENTER></B></TD>
                <td><b>OPTION</b></td>
            </TR>
            <%
                for(int i=0; i<listadoTicketNOA.size();i++){
                    LocalDate fechaapertura = listadoTicketNOA.get(i).getF_apertura();
                    int idticket=listadoTicketNOA.get(i).getId_ticket();
                    String tienda= listadoTicketNOA.get(i).getTienda();
                    int nivel=listadoTicketNOA.get(i).getNivel_asignado();
                    String tipoincidencia = listadoTicketNOA.get(i).getTipo_incidencia();
                    String descproblema = listadoTicketNOA.get(i).getDesc_problema();
                   DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        String formatDateTime = fechaapertura.format(formatter);

        System.out.println("After : " + formatDateTime); 
            %>

            <tr>
                <TD><%=formatDateTime%></TD>
                <TD><%=idticket%></TD>
                <TD><%=tienda%></TD>
                <TD><%=nivel%></TD>
                <TD><%=tipoincidencia%></TD>
                <TD><%=descproblema%></TD>
                <TD><form id="detalletk" name="detalletk" action="DetalleTK" method="get">
                        <input type="hidden" name="idticket" value="<%=idticket%>">
                        
                        <input type="submit" value="Ver">
                        </form></TD>
                
            </tr>

    

    <% } %>
</table>
<br>
<br>

<br>
<br>
<br>
<br><a href="MenuEmpleado.jsp">MENU PRINCIPAL</A>
    </body>
</html>
