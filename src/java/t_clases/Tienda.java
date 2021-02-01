/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t_clases;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author HP
 */
public class Tienda {
    
    int id_tienda;
    private String nombre;
    private String telefono;
    private String direccion;
    private String userid;
    private String pwd;
    int altat;
    
    public Tienda(String nombre,String telefono,String direccion,String userid, String pwd){
        
        this.nombre=nombre;
        this.telefono=telefono;
        this.direccion=direccion;
        this.userid=userid;
        this.pwd=pwd;
       
    }
    
    public void altaTienda(String nombre,String telefono,String direccion,String userid,String pwd){
    
    Connection conexion=null;
    PreparedStatement ps=null;
    ConectaBD bd= new ConectaBD();
    bd.conecta();
    conexion=bd.getConexion();
    
    String sql = "INSERT INTO tienda(NOMBRE,TELEFONO,DIRECCION,USERID,PWD) values(?,?,?,?,?)";
    
    try {
            ps = conexion.prepareStatement(sql);

            ps.setString(1,nombre);
            ps.setString(2,telefono);
            ps.setString(3,direccion);
            ps.setString(4,userid);
            ps.setString(5,pwd);
            
            altat = ps.executeUpdate();

           

        } catch (Exception e) {
            e.printStackTrace();
            System.out.print(e);
        }

    
}

    public int getId_tienda() {
        return id_tienda;
    }

    public void setId_tienda(int id_tienda) {
        this.id_tienda = id_tienda;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getAltat() {
        return altat;
    }

    public void setAltat(int altat) {
        this.altat = altat;
    }
    
    
}
