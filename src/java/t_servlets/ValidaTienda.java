/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t_servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import t_clases.ConectaBD;

/**
 *
 * @author HP
 */
public class ValidaTienda extends HttpServlet {

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
        
        HttpSession sesion = request.getSession();
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            
            String password = "";
            String nombre = "";
            int idtienda = 0;
            String userid= "";
            String telefono= "";

           
            
            ResultSet rs = null;
            PreparedStatement ps = null;
            

            ConectaBD bd = new ConectaBD();
            bd.conecta();
            bd.getConexion();

            String miusuario = request.getParameter("userid");
            String mipwd = request.getParameter("password");
            
            Connection conexion=bd.getConexion();

           
            String sql = "SELECT id_tienda,nombre,telefono from tienda where userid=? and pwd=?";

            try {
                ps= conexion.prepareStatement(sql);
                
                ps.setString(1, miusuario);
                ps.setString(2, mipwd);
                
                System.out.println(sql);
                
                rs = ps.executeQuery();
                while (rs.next()) {
                    idtienda = rs.getInt("id_tienda");
                    nombre = rs.getString("nombre");
                    telefono= rs.getString("telefono");
                    
                    //meto valores recuperados en la sesion
                    sesion.setAttribute("idtienda", idtienda);
                    sesion.setAttribute("nombre",nombre);
                    sesion.setAttribute("telefono",telefono);
                    
                    System.out.println( idtienda+" "+nombre+" "+telefono);

                }

                if (idtienda >0 ) {
                    response.sendRedirect("Alta_Ticket.jsp");
                } else{
                    response.sendRedirect("ErrorTienda.jsp");
                }
            } catch (Exception e) {
                out.println(e);
            }
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ValidaTienda</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ValidaTienda at " + request.getContextPath() + "</h1>");
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
