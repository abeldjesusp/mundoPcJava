package mundopc.datos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import mundopc.domain.Monitor;

public class DBMonitor implements iDataBase{
    private Connection connMonitor;
    private final String SQL_INSERT = 
            "INSERT INTO Monitores(marca,tipo_salida,tamano,precio) VALUES(?,?,?,?)";
    private final String SQL_UPDATE = 
            "UPDATE  Monitores SET marca=?,tipo_salida=?,tamano=?,precio=? WHERE id_monitor=?";
    private final String SQL_DELETE = 
            "DELETE FROM Monitores WHERE id_monitor=?";
    private final String SQL_SELECT = 
            "SELECT * FROM Monitores OREDER BY id_monitor";
   
    public DBMonitor(){}
  
    public DBMonitor(Connection connMonitor){
        this.connMonitor = connMonitor;
    }

    @Override
    public int insert(Object obj) throws SQLException {
        Monitor monitor = (Monitor)obj;
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try{
            conn = (connMonitor != null) ? this.connMonitor : Conexion.getConnectoin();
            stmt = conn.prepareStatement(SQL_INSERT);
            int index = 1;
            stmt.setString(index++, monitor.getMarca());
            stmt.setString(index++, monitor.getTipoSalida());
            stmt.setFloat(index++, monitor.getTamano());
            stmt.setFloat(index, monitor.getPrecio());            
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados : " + rows);
        }finally{
            Conexion.close(stmt);
            if(connMonitor == null)
                Conexion.close(conn);
        }        
        return rows;
    }

    @Override
    public int update(Object obj) throws SQLException {
        Monitor monitor = (Monitor)obj;
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try{
            conn = (connMonitor != null) ? this.connMonitor : Conexion.getConnectoin();
            stmt = conn.prepareStatement(SQL_UPDATE);
            int index = 1;
            stmt.setString(index++, monitor.getMarca());
            stmt.setString(index++, monitor.getTipoSalida());
            stmt.setFloat(index++, monitor.getTamano());
            stmt.setFloat(index, monitor.getPrecio());            
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizados : " + rows);
            
        }finally{
            Conexion.close(stmt);
            if(connMonitor == null)
                Conexion.close(conn);
        }
        return rows;
    }

    @Override
    public int delete(Object obj) throws SQLException {
         Monitor monitor = (Monitor)obj;
         Connection conn = null;
         PreparedStatement stmt = null;
         int rows = 0;
         
         try{
             conn = (this.connMonitor != null) ? this.connMonitor : Conexion.getConnectoin();
             stmt = conn.prepareStatement(SQL_DELETE);
             stmt.setInt(1, monitor.getIdMonitor());
             rows = stmt.executeUpdate();
             System.out.println("Registros eliminados : " + rows);
         }finally{
             Conexion.close(stmt);
             if(this.connMonitor == null)
                 Conexion.close(conn);
         }
         
         return rows;
    }

    @Override
    public List<Object> select() throws SQLException {
         Monitor monitor = null;
         List<Object> monitores = new ArrayList<Object>();
         Connection conn = null;
         PreparedStatement stmt = null;
         ResultSet rs = null;
         
         try{
             conn = (this.connMonitor != null) ? this.connMonitor : Conexion.getConnectoin();
             stmt = conn.prepareStatement(SQL_SELECT);
             rs = stmt.executeQuery();
             while(rs.next()){
                 int id_monitor = rs.getInt(1);
                 String marca = rs.getString(2);
                 String tipo = rs.getString(3);
                 float tamano = rs.getFloat(4);
                 float precio = rs.getFloat(5);
                 
                 monitor = new Monitor(id_monitor,marca,tipo,tamano,precio);
                 monitores.add(monitor);
             }
         }finally{
             Conexion.close(rs);
             Conexion.close(stmt);
             if(this.connMonitor == null)
                 Conexion.close(conn);
         }
         
         return monitores;
    }
    
}
