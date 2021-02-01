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
public class Empleado {
    
    int id_empleado;
private String userid;
private String pwd;
private String nombre;
private String tipo_usuario;
private String nivel_soporte;
int altae;


public Empleado(String userid, String pwd, String nombre, String tipo_usuario,String nivel_soporte){
    
    this.userid=userid;
    this.pwd=pwd;
    this.nombre=nombre;
    this.tipo_usuario=tipo_usuario;
    this.nivel_soporte=nivel_soporte;
}

public void altaEmpleado(String userid, String pwd, String nombre, String tipo_usuario,String nivel_soporte){
    
    Connection conexion=null;
    ConectaBD bd = new ConectaBD();
    bd.conecta();
    conexion = bd.getConexion();
    
        
    String sql = "INSERT INTO empleado(userid,pwd,nombre,tipo_usuario,nivel_soporte) values(?,?,?,?,?)";
            
     try ( PreparedStatement ps = conexion.prepareStatement(sql)) {
                // Se insertan los valores en la consulta :
                ps.setString(1, userid);
                ps.setString(2, pwd);
                ps.setString(3, nombre);
                ps.setString(4, tipo_usuario);
                ps.setString(5, nivel_soporte);

                // Se invoca a executeUpdate sin parametros :
                altae = ps.executeUpdate();

               

            } catch (Exception e) {
                e.printStackTrace();
                System.out.print(e);
            }
}

public void setAltaEmpleado(int altae){
    this.altae=altae;
}

public int getAltaEmpleado(){
    return altae;
}


    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(String tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    public String getNivel_soporte() {
        return nivel_soporte;
    }

    public void setNivel_soporte(String nivel_soporte) {
        this.nivel_soporte = nivel_soporte;
    }
    
    
    
}
