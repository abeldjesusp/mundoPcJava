package mundopc.datos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import mundopc.domain.Raton;

public class DBRaton implements iDataBase{
    private Connection connRaton;
    private final String SQL_INSERT = 
            "INSERT INTO Ratones(marca,tipo_entrada,precio) VALUES(?,?,?)";
    private final String SQL_UPDATE = 
            "UPDATE  Ratones SET marca=?,tipo_entrada=?,precio=? WHERE id_raton=?";
    private final String SQL_DELETE = 
            "DELETE FROM Ratones WHERE id_raton=?";
    private final String SQL_SELECT = 
            "SELECT * FROM Ratones ORDER BY id_raton";
   
    public DBRaton(){}
  
    public DBRaton(Connection connRaton){
        this.connRaton = connRaton;
    }

    @Override
    public int insert(Object obj) throws SQLException {
        Raton raton = (Raton)obj;
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try{
            conn = (connRaton != null) ? this.connRaton : Conexion.getConnectoin();
            stmt = conn.prepareStatement(SQL_INSERT);
            int index = 1;
            stmt.setString(index++, raton.getMarca());
            stmt.setString(index++, raton.getTipoEntrada());
            stmt.setFloat(index, raton.getPrecio());            
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados : " + rows);
        }finally{
            Conexion.close(stmt);
            if(connRaton == null)
                Conexion.close(conn);
        }        
        return rows;
    }

    @Override
    public int update(Object obj) throws SQLException {
        Raton raton = (Raton)obj;
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try{
            conn = (connRaton != null) ? this.connRaton : Conexion.getConnectoin();
            stmt = conn.prepareStatement(SQL_UPDATE);
            int index = 1;
            stmt.setString(index++, raton.getMarca());
            stmt.setString(index++, raton.getTipoEntrada());
            stmt.setFloat(index++, raton.getPrecio()); 
            stmt.setInt(index, raton.getIdRaton()); 
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizados : " + rows);
            
        }finally{
            Conexion.close(stmt);
            if(connRaton == null)
                Conexion.close(conn);
        }
        return rows;
    }

    @Override
    public int delete(Object obj) throws SQLException {
         Raton raton = (Raton)obj;
         Connection conn = null;
         PreparedStatement stmt = null;
         int rows = 0;
         
         try{
             conn = (this.connRaton != null) ? this.connRaton : Conexion.getConnectoin();
             stmt = conn.prepareStatement(SQL_DELETE);
             stmt.setInt(1, raton.getIdRaton());
             rows = stmt.executeUpdate();
             System.out.println("Registros eliminados : " + rows);
         }finally{
             Conexion.close(stmt);
             if(this.connRaton == null)
                 Conexion.close(conn);
         }
         
         return rows;
    }

    @Override
    public List<Object> select() throws SQLException {
         Raton raton = null;
         List<Object> ratones = new ArrayList<Object>();
         Connection conn = null;
         PreparedStatement stmt = null;
         ResultSet rs = null;
         
         try{
             conn = (this.connRaton != null) ? this.connRaton : Conexion.getConnectoin();
             stmt = conn.prepareStatement(SQL_SELECT);
             rs = stmt.executeQuery();
             while(rs.next()){
                 int id_raton = rs.getInt(1);
                 String marca = rs.getString(2);
                 String tipo = rs.getString(3);
                 float precio = rs.getFloat(4);
                 
                 raton = new Raton(id_raton,marca,tipo,precio);
                 ratones.add(raton);
             }
         }finally{
             Conexion.close(rs);
             Conexion.close(stmt);
             if(this.connRaton == null)
                 Conexion.close(conn);
         }
         
         return ratones;
    }
    
}
