/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t_servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import t_clases.Ticket;

/**
 *
 * @author HP
 */
public class CierraTicket extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            
            LocalDate f_apertura = null;
            LocalDate f_cierre = LocalDate.now();
            int nivel_asignado = 0;
            String tipo_incidencia= null;
            String desc_problema = null;
            String solucionado="Y";
         
                   int id_ticket = (int)request.getSession().getAttribute("det_idticket");
                   int idtienda = (int)request.getSession().getAttribute("det_idtienda");
                   int id_empleado_asignado = (int)request.getSession().getAttribute("idempleado");
                   
                   String desc_solucion = request.getParameter("descripcion_solucion");
                   System.out.println("Descripción solucion"+desc_solucion);
                   
           Ticket Tk= new Ticket(f_apertura,f_cierre,idtienda,id_empleado_asignado,nivel_asignado,tipo_incidencia,desc_problema,desc_solucion,solucionado);
            
           Tk.cerrarTicket(id_ticket,id_empleado_asignado,desc_solucion,solucionado);
           int cierratk= Tk.getcierratk();
           if (cierratk > 0) {
               response.sendRedirect("ExitoCierreTicket.jsp"); 
            }else{
               response.sendRedirect("ErrorCierreTicket.jsp");
            }
            
            
            
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CierraTicket</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CierraTicket at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
                
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
