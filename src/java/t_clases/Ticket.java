/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t_clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class Ticket {
    
    int id_ticket;
    private LocalDate f_apertura;
    private LocalDate f_cierre;
    private int id_tienda;
    private String tienda;
    private int id_empleado_asignado;
    private int nivel_asignado;
    private String tipo_incidencia;
    private String desc_problema; 
    private String desc_solucion;
    private String solucionado="N";
    private int altatk;
    private int cierratk;
    private int escalatk;
    
    

public Ticket(int id_ticket,LocalDate f_apertura,LocalDate f_cierre, int id_tienda, int id_empleado_asignado, int nivel_asignado,String tipo_incidencia,String desc_problema,String desc_solucion,String solucionado){
    this.id_ticket=id_ticket;
    this.f_apertura=f_apertura;
    this.f_cierre=f_cierre;
    this.id_tienda=id_tienda;
    this.id_empleado_asignado=id_empleado_asignado;
    this.nivel_asignado=nivel_asignado;
    this.tipo_incidencia=tipo_incidencia;
    this.desc_problema=desc_problema;
    this.desc_solucion=desc_solucion;
    this.solucionado=solucionado;
    
}
    
public Ticket(LocalDate f_apertura,LocalDate f_cierre, int id_tienda, int id_empleado_asignado, int nivel_asignado,String tipo_incidencia,String desc_problema,String desc_solucion,String solucionado){
    
    this.f_apertura=f_apertura;
    this.f_cierre=f_cierre;
    this.id_tienda=id_tienda;
    this.id_empleado_asignado=id_empleado_asignado;
    this.nivel_asignado=nivel_asignado;
    this.tipo_incidencia=tipo_incidencia;
    this.desc_problema=desc_problema;
    this.desc_solucion=desc_solucion;
    this.solucionado=solucionado;
    
}

public Ticket(LocalDate f_apertura,int id_ticket, String tienda,int nivel,String tipo_incidencia,String desc_problema){
    this.f_apertura=f_apertura;
    this.id_ticket=id_ticket;
    this.tienda=tienda;
    this.nivel_asignado=nivel;
    this.tipo_incidencia=tipo_incidencia;
    this.desc_problema= desc_problema;
}


public Ticket(){
    
}


  
 public void altaTicket(LocalDate f_apertura,LocalDate f_cierre, int id_tienda, int id_empleado_asignado, int nivel_asignado,String tipo_incidencia,String desc_problema,String desc_solucion,String solucionado){
    
    Connection conexion=null;
    PreparedStatement ps=null;
    ConectaBD bd= new ConectaBD();
    bd.conecta();
    conexion=bd.getConexion();
    f_apertura=LocalDate.now();
    
    
    String sql = "INSERT INTO ticket(fecha_apertura,fecha_cierre,id_tienda,id_empleado_asignado,nivel_asignado, tipo_incidencia, descripcion_problema,descripcion_solucion,solucionado) values(?,null,?,null,'1',?,?,' ','N')";
    
    try {
            ps = conexion.prepareStatement(sql);

            ps.setObject(1,f_apertura);
            ps.setInt(2,id_tienda);
            ps.setString(3,tipo_incidencia);
            ps.setString(4,desc_problema);
           
            
            altatk = ps.executeUpdate();

           

        } catch (Exception e) {
            e.printStackTrace();
            System.out.print(e);
        }

    
}
 
 public void cerrarTicket(int id_ticket,int id_empleado,String desc_solucion,String solucionado){
     
    Connection conexion=null;
    PreparedStatement ps=null;
    ConectaBD bd= new ConectaBD();
    bd.conecta();
    conexion=bd.getConexion();
    f_cierre=LocalDate.now();
    solucionado="Y";
    
    
    
    
    
    String sql = "UPDATE ticket SET \n" +
                                    "fecha_cierre=?,\n" +
                                    "id_empleado_asignado=?,\n" +
                                    "descripcion_solucion =?, \n" +
                                    "solucionado =?\n" +
                                    "WHERE id_ticket=?";
    
    try {
            ps = conexion.prepareStatement(sql);

            ps.setObject(1,f_cierre);
            ps.setInt(2,id_empleado);
            ps.setString(3,desc_solucion);
            ps.setString(4,solucionado);
            ps.setInt(5, id_ticket);
           
            
            cierratk = ps.executeUpdate();

           

        } catch (Exception e) {
            e.printStackTrace();
            System.out.print(e);
        }

     
 }
 
 public void escalarTicket(int id_ticket,int nivel){
     
     
    Connection conexion=null;
    PreparedStatement ps=null;
    ConectaBD bd= new ConectaBD();
    bd.conecta();
    conexion=bd.getConexion();
    nivel = nivel+1;
    
    String sql = "UPDATE ticket SET nivel_asignado=? WHERE id_ticket=?";
                                     
                                    
    
    try {
            ps = conexion.prepareStatement(sql);

            ps.setInt(1,nivel);
            ps.setInt(2, id_ticket);
            
           
            
            escalatk = ps.executeUpdate();

           

        } catch (Exception e) {
            e.printStackTrace();
            System.out.print(e);
        }

 }
 
 public ArrayList listaTicketNOA(){
     
    Connection conexion = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    ArrayList<Ticket> listadoTicketNOA;
    listadoTicketNOA= new ArrayList();
    
    try{
        ConectaBD bd = new ConectaBD();
        bd.conecta();
        conexion=bd.getConexion();
       
        
        String sql = "SELECT tk.ID_TICKET,ta.ID_TIENDA,ta.NOMBRE,tk.NIVEL_ASIGNADO,tk.FECHA_APERTURA,ta.NOMBRE,tk.TIPO_INCIDENCIA,tk.DESCRIPCION_PROBLEMA\n" +
                     "from ticket tk INNER JOIN tienda ta \n" +
                     "ON tk.ID_TIENDA= ta.ID_TIENDA\n" +
                     "WHERE tk.SOLUCIONADO=?";
        
        ps = conexion.prepareStatement(sql);
         
         ps.setString(1,solucionado);
         
         rs = ps.executeQuery();
Date d;

            while (rs.next()) {

                id_ticket=rs.getInt("tk.id_ticket");
                id_tienda=rs.getInt("ta.id_tienda");
                nivel_asignado=rs.getInt("nivel_asignado");
               //  f_apertura = (LocalDate)rs.getObject("tk.fecha_apertura");
                d = rs.getDate("tk.fecha_apertura");
                String tienda = rs.getString("ta.nombre");
                tipo_incidencia =rs.getString("tk.tipo_incidencia");
                desc_problema =rs.getString("tk.descripcion_problema");
                 System.out.println(d);
                 f_apertura = LocalDate.parse( new SimpleDateFormat("yyyy-MM-dd").format(d) );
                 
                System.out.println(f_apertura);
                System.out.println(id_ticket);
                listadoTicketNOA.add(new Ticket(f_apertura,id_ticket,tienda,nivel_asignado,tipo_incidencia,desc_problema));

            }
        } catch (SQLException ex) {
            Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null, ex);
        }
   
     return listadoTicketNOA;
 }
 public ArrayList listaTotalTickets(){
     
     Connection conexion = null;
    Statement st = null;
    ResultSet rs = null;
    ArrayList<Ticket> listadoTotalTK;
    listadoTotalTK= new ArrayList();
    
    try{
        ConectaBD bd = new ConectaBD();
        bd.conecta();
        conexion=bd.getConexion();
        st = conexion.createStatement();
        
        String sql = "Select * from ticket";
        
         rs = st.executeQuery(sql);
Date fa;
Date fc;

            while (rs.next()) {

                id_ticket=rs.getInt("id_ticket");
                id_tienda=rs.getInt("id_tienda");
                id_empleado_asignado=rs.getInt("id_empleado_asignado");
                nivel_asignado=rs.getInt("nivel_asignado");
               //  f_apertura = (LocalDate)rs.getObject("tk.fecha_apertura");
                fa = rs.getDate("fecha_apertura");
                fc = rs.getDate("fecha_cierre");
                                
                tipo_incidencia =rs.getString("tipo_incidencia");
                desc_problema =rs.getString("descripcion_problema");
                desc_solucion=rs.getString("descripcion_solucion");
                solucionado =rs.getString("solucionado");
                 System.out.println(fa);
                 f_apertura = LocalDate.parse( new SimpleDateFormat("yyyy-MM-dd").format(fa) );
               if (fc != null)
                   f_cierre = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(fc) );
               else
                   f_cierre = null; 
                System.out.println(f_apertura);
                System.out.println(id_ticket);
                listadoTotalTK.add(new Ticket( id_ticket,f_apertura, f_cierre, id_tienda,  id_empleado_asignado,  nivel_asignado,tipo_incidencia, desc_problema, desc_solucion, solucionado));

            }
        } catch (SQLException ex) {
            Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null, ex);
        }
     
     return listadoTotalTK;
 }

    public int getId_ticket() { 
        return id_ticket;
    }

    public void setId_ticket(int id_ticket) {
        this.id_ticket = id_ticket;
    }

    public LocalDate getF_apertura() {
        return f_apertura;
    }

    public void setF_apertura(LocalDate f_apertura) {
        this.f_apertura = f_apertura;
    }

    public LocalDate getF_cierre() {
        return f_cierre;
    }

    public void setF_cierre(LocalDate f_cierre) {
        this.f_cierre = f_cierre;
    }

    public int getId_tienda() {
        return id_tienda;
    }

    public void setId_tienda(int id_tienda) {
        this.id_tienda = id_tienda;
    }

    public int getId_empleado_asignado() {
        return id_empleado_asignado;
    }

    public void setId_empleado_asignado(int id_empleado_asignado) {
        this.id_empleado_asignado = id_empleado_asignado;
    }

    public int getNivel_asignado() {
        return nivel_asignado;
    }

    public void setNivel_asignado(int nivel_asignado) {
        this.nivel_asignado = nivel_asignado;
    }

    public String getTipo_incidencia() {
        return tipo_incidencia;
    }

    public void setTipo_incidencia(String tipo_incidencia) {
        this.tipo_incidencia = tipo_incidencia;
    }

    public String getDesc_problema() {
        return desc_problema;
    }

    public void setDesc_problema(String desc_problema) {
        this.desc_problema = desc_problema;
    }

    public String getDesc_solucion() {
        return desc_solucion;
    }

    public void setDesc_solucion(String desc_solucion) {
        this.desc_solucion = desc_solucion;
    }

    public String getSolucionado() {
        return solucionado;
    }

    public void setSolucionado(String solucionado) {
        this.solucionado = solucionado;
    }

    public int getAltatk() {
        return altatk;
    }

    public void setAltatk(int altatk) {
        this.altatk = altatk;
    }
    
    public int getcierratk() {
        return cierratk;
    }

    public void setcierratk(int cierratk) {
        this.cierratk = cierratk;
    } 
    
     public int getescalatk() {
        return escalatk;
    }

    public void setescalatk(int escalatk) {
        this.escalatk = escalatk;
    } 

    public String getTienda() {
        return tienda;
    }

    public void setTienda(String tienda) {
        this.tienda = tienda;
    }
    
    
}
