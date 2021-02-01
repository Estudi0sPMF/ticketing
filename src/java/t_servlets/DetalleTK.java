/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t_servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import t_clases.ConectaBD;

/**
 *
 * @author HP
 */
public class DetalleTK extends HttpServlet {

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
              Connection conexion = null;
            Statement st = null;
            ResultSet rs = null;
            ConectaBD bd = new ConectaBD();
            bd.conecta();
            conexion = bd.getConexion();
            st = conexion.createStatement();

            String idticket =request.getParameter("idticket");
            System.out.println("idticket:"+idticket);
            String sql = "SELECT * from ticket where id_ticket = '"+idticket+"'";

            rs = st.executeQuery(sql);
            
                int detidticket;
                int detidtienda;
                int detnivel;
                String dettipoinci;
                String detdescripcion;
                Date detfecha;         
            
            while (rs.next()) {

                detfecha = rs.getDate("fecha_apertura");
                detidticket = rs.getInt("id_ticket");
                detidtienda = rs.getInt("id_tienda");
                detnivel=rs.getInt("nivel_asignado");
                dettipoinci = rs.getString("tipo_incidencia");
                detdescripcion = rs.getString("descripcion_problema");
       //f_apertura = LocalDate.parse( new SimpleDateFormat("yyyy-MM-dd").format(d) );                         
            
                request.getSession().setAttribute("det_fecha", detfecha);
                request.getSession().setAttribute("det_idticket", detidticket);
                request.getSession().setAttribute("det_idtienda", detidtienda);
                request.getSession().setAttribute("det_nivel", detnivel);
                request.getSession().setAttribute("det_tipoinci", dettipoinci);
                request.getSession().setAttribute("det_descripcion", detdescripcion);
                

                response.sendRedirect("Detalle_TK.jsp");
              }  
                 
            } catch (SQLException ex) {
            Logger.getLogger(DetalleTK.class.getName()).log(Level.SEVERE, null, ex);
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DetalleTK</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DetalleTK at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
