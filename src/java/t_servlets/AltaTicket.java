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
public class AltaTicket extends HttpServlet {

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
            LocalDate f_cierre = null;
            int id_empleado_asignado = 0;
            int nivel_asignado =0;
            String tipo_incidencia= null;
            String desc_problema = null;
            String desc_solucion = null;
            String solucionado = null;
         
            
                   int idtienda = (Integer)request.getSession().getAttribute("idtienda");
                   String tipoIncidencia=request.getParameter("tipo_incidencia");
                   String descripcionProblema = request.getParameter("descripcion_problema");
                   System.out.println(tipoIncidencia + ""+ descripcionProblema);
                   
           Ticket Tk= new Ticket(f_apertura,f_cierre,idtienda,id_empleado_asignado,nivel_asignado,tipoIncidencia,descripcionProblema,desc_solucion,solucionado);
            
           Tk.altaTicket(f_apertura,f_cierre,idtienda,id_empleado_asignado,nivel_asignado,tipoIncidencia,descripcionProblema,desc_solucion,solucionado);
           int altatk= Tk.getAltatk();
           if (altatk > 0) {
               response.sendRedirect("ExitoRegistroTicket.jsp"); 
            }else{
               response.sendRedirect("ErrorRegistroTicket.jsp");
            }
            
            
            
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AltaTicket</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AltaTicket at " + request.getContextPath() + "</h1>");
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
