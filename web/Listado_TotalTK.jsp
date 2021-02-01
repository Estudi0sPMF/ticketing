<%-- 
    Document   : Listado_TotalTK
    Created on : 29 ene. 2021, 12:01:58
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
   ArrayList<Ticket> listadoTotalTK;
   listadoTotalTK=(ArrayList)sesion.getAttribute("ListadoTotalTK");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado Total Tickets</title>
    </head>
    <body>
         <h1>Listado Total Tickets</h1>

        <table border=1>
            <tr>
                <td><B>Nº TICKET</B></TD>
                <td><B>FECHA APERTURA</B></TD>
                <td><B>FECHA_IERRE</B></TD>
                <td><B>TIENDA</B></TD>
                <td><B>ATENDIDO POR</B></TD>
                <td><B>NIVEL</B></TD>
                <td><B>TIPO INCIDENCIA</B></TD>
                <td><B><CENTER>DESCRIPCION</CENTER></B></TD>
                <td><B><CENTER>SOLUCION</CENTER></B></TD>
                <td><b>CERRADO</b></td>
            </TR>
            <%
                for(int i=0; i<listadoTotalTK.size();i++){
                    LocalDate fechaapertura = listadoTotalTK.get(i).getF_apertura();
                    LocalDate fechacierre = listadoTotalTK.get(i).getF_cierre();
                    int idticket=listadoTotalTK.get(i).getId_ticket();
                    int idtienda= listadoTotalTK.get(i).getId_tienda();
                    int idatendido=listadoTotalTK.get(i).getId_empleado_asignado();
                    int nivel=listadoTotalTK.get(i).getNivel_asignado();
                    String tipoincidencia = listadoTotalTK.get(i).getTipo_incidencia();
                    String descproblema = listadoTotalTK.get(i).getDesc_problema();
                    String solucion = listadoTotalTK.get(i).getDesc_solucion();
                    String cerrado = listadoTotalTK.get(i).getSolucionado();
                   DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        String formatDateTimeFA = fechaapertura.format(formatter);
        String formatDateTimeFC = "";
        if (fechacierre != null)
          formatDateTimeFC = fechacierre.format(formatter);
 
        System.out.println("After : " + formatDateTimeFA); 
            %>

            <tr>
                <TD><%=idticket%></TD>
                <TD><%=formatDateTimeFA%></TD>
                <TD><%=formatDateTimeFC%></TD>
                <TD><%=idtienda%></TD>
                <TD><%=idatendido%></TD>
                <TD><%=nivel%></TD>
                <TD><%=tipoincidencia%></TD>
                <TD><%=descproblema%></TD>
                <TD><%=solucion%></TD>
                <TD><%=cerrado%></TD>
             
            </tr>

    

    <% } %>
</table>
<br>
<br>

<br>
<br>
<br>
<a href="ExportarTickets"><font face=Calibri size =3 >Exportar a Excel</font></a></li><br>
<br><a href="MenuAdmin.jsp">MENU PRINCIPAL</A>
    </body>
    </body>
</html>
