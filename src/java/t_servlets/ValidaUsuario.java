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
public class ValidaUsuario extends HttpServlet {

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
            String tipousuario = "";
            int idempleado = 0;
            String userid= "";

           
            
            ResultSet rs = null;
            PreparedStatement ps = null;
            

            ConectaBD bd = new ConectaBD();
            bd.conecta();
            bd.getConexion();

            String miusuario = request.getParameter("userid");
            String mipwd = request.getParameter("password");
            sesion.setAttribute("miusuario", userid);
            sesion.setAttribute("contrasenia", password);
            Connection conexion=bd.getConexion();

           
            String sql = "SELECT tipo_usuario,id_empleado from empleado where userid=? and pwd=?";

            try {
                ps= conexion.prepareStatement(sql);
                
                ps.setString(1, miusuario);
                ps.setString(2, mipwd);

                rs = ps.executeQuery();
                while (rs.next()) {
                    idempleado = rs.getInt("id_empleado");
                    tipousuario = rs.getString("tipo_usuario");
                    //meto idagente en la sesion
                    sesion.setAttribute("idempleado", idempleado);
                   

                }

                if ("A".equals(tipousuario)) {
                    response.sendRedirect("MenuAdmin.jsp");
                } else if ("E".equals(tipousuario)) {
                    response.sendRedirect("MenuEmpleado.jsp");
                }
            } catch (Exception e) {
                out.println(e);
            }

            
            
            
            
            
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ValidaUsuario</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Usuario o pwd incorrecto </h1>");
            out.println("<a href=\"index1.jsp\"><font face=Calibri size =3 >Salir</font></a>");
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
