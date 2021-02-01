/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t_clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author propietario
 */
public class ConectaBD {
      
    String driver;
    String sgdb;
    String url;
    String puerto;
    String bbdd;
    String usuario;
    String password;
    Connection conexion;
    Statement st;
    
    
    
    public void conecta(){
      

         
        try {
            
            
            
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConectaBD.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            //Conecto con la base de datos gestionbancaria
            conexion = DriverManager.getConnection(
                    "jdbc:mysql: //localhost:3306/TICKETING",
                    "root", "");
            boolean valid = conexion.isValid(50000);
            System.out.println(valid ? "TEST OK" : "TEST FAIL");
        } catch (SQLException ex) {
            Logger.getLogger(ConectaBD.class.getName()).log(Level.SEVERE, null, ex);
        }
 } 
    
  
    
    public Connection getConexion(){
        return conexion;
    }
    }

