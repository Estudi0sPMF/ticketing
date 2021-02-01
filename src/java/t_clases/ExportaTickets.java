/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t_clases;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author HP
 */
public class ExportaTickets {
  
    public void export() {
    
 
        String excelFilePath = "C:\\xampp\\tomcat\\webapps\\excel\\Listado_Tickets.xlsx";
 
        try {
            
            Connection conexion = null;
            PreparedStatement ps;
            String sql = "SELECT * FROM ticket";
            ConectaBD bd = new ConectaBD();
            bd.conecta();
            conexion=bd.getConexion();
            
            ps = conexion.prepareStatement(sql);
            
            ResultSet result = ps.executeQuery();
           
        
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Tickets");
 
            writeHeaderLine(sheet);
 
            writeDataLines(result, workbook, sheet);
 
            FileOutputStream outputStream = new FileOutputStream(excelFilePath);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
            
 
            ps.close();
 
        } catch (SQLException e) {
            System.out.println("Datababse error:");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("File IO error:");
            e.printStackTrace();
        }
    }
 
    private void writeHeaderLine(XSSFSheet sheet) {
 
        Row headerRow = sheet.createRow(0);
 
        Cell headerCell = headerRow.createCell(0);
        headerCell.setCellValue("Id Ticket");
 
        headerCell = headerRow.createCell(1);
        headerCell.setCellValue("Fecha Apertura");
 
        headerCell = headerRow.createCell(2);
        headerCell.setCellValue("Fecha Cierre");
 
        headerCell = headerRow.createCell(3);
        headerCell.setCellValue("Id Tienda");
 
        headerCell = headerRow.createCell(4);
        headerCell.setCellValue("Id Empleado Asignado");
        
        headerCell = headerRow.createCell(5);
        headerCell.setCellValue("Nivel");
        
        headerCell = headerRow.createCell(6);
        headerCell.setCellValue("Tipo Incidencia");
        
        headerCell = headerRow.createCell(7);
        headerCell.setCellValue("Descripción");
        
        headerCell = headerRow.createCell(8);
        headerCell.setCellValue("Solución");
        
        headerCell = headerRow.createCell(9);
        headerCell.setCellValue("Cerrado");
         
        
    }
 
    private void writeDataLines(ResultSet result, XSSFWorkbook workbook,
            XSSFSheet sheet) throws SQLException {
        int rowCount = 1;
 
        while (result.next()) {
            int id_ticket = result.getInt("id_ticket");
            Date f_apertura = result.getDate("fecha_apertura");
            Date f_cierre = result.getDate("Fecha_cierre");
            int id_tienda = result.getInt("id_tienda");
            int id_empleado=result.getInt("id_empleado_asignado");
            int nivel = result.getInt("nivel_asignado");
            String tipoIncidencia = result.getString("tipo_incidencia");
            String descripcion = result.getString("descripcion_problema");
            String solucion = result.getString("descripcion_solucion");
            String cerrado = result.getString("solucionado");
 
            Row row = sheet.createRow(rowCount++);
 
            int columnCount = 0;
            Cell cell = row.createCell(columnCount++);
            cell.setCellValue(id_ticket);
 
            cell = row.createCell(columnCount++);
            CellStyle cellStyle = workbook.createCellStyle();
            CreationHelper creationHelper = workbook.getCreationHelper();
            cellStyle.setDataFormat(creationHelper.createDataFormat().getFormat("dd-MM-yyyy"));
            cell.setCellStyle(cellStyle);
            cell.setCellValue(f_apertura);
 
            cell = row.createCell(columnCount++);
            cellStyle = workbook.createCellStyle();
            creationHelper = workbook.getCreationHelper();
            cellStyle.setDataFormat(creationHelper.createDataFormat().getFormat("dd-MM-yyyy"));
            cell.setCellStyle(cellStyle);
            cell.setCellValue(f_cierre);
            
            
 
            
            cell = row.createCell(columnCount++);
            cell.setCellValue(id_tienda);
            
            cell = row.createCell(columnCount++);
            cell.setCellValue(id_empleado);
            
            cell = row.createCell(columnCount++);
            cell.setCellValue(nivel);
            
            cell = row.createCell(columnCount++);
            cell.setCellValue(tipoIncidencia);
            
            cell = row.createCell(columnCount++);
            cell.setCellValue(descripcion);
            
            cell = row.createCell(columnCount++);
            cell.setCellValue(solucion);
 
            cell = row.createCell(columnCount);
            cell.setCellValue(cerrado);
 
        }
    }    
    
    
    
}
