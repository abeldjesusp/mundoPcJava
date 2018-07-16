package mundopc.datos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import mundopc.domain.Bocina;

public class DBBocinas implements iDataBase{
    private Connection connBocina;
    private final String SQL_INSERT = 
            "INSERT INTO Bocinas(marca,tipo_salida,precio) VALUES(?,?,?)";
    private final String SQL_UPDATE = 
            "UPDATE  Bocinas SET marca=?,tipo_salida=?,precio=? WHERE id_bocina=?";
    private final String SQL_DELETE = 
            "DELETE FROM Bocinas WHERE id_bocina=?";
    private final String SQL_SELECT = 
            "SELECT * FROM Bocinas OREDER BY id_bocina";
   
    public DBBocinas(){}
  
    public DBBocinas(Connection connBocina){
        this.connBocina = connBocina;
    }

    @Override
    public int insert(Object obj) throws SQLException {
        Bocina bocina = (Bocina)obj;
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try{
            conn = (connBocina != null) ? this.connBocina : Conexion.getConnectoin();
            stmt = conn.prepareStatement(SQL_INSERT);
            int index = 1;
            stmt.setString(index++, bocina.getMarca());
            stmt.setString(index++, bocina.getTipoSalida());
            stmt.setFloat(index, bocina.getPrecio());            
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados : " + rows);
        }finally{
            Conexion.close(stmt);
            if(connBocina == null)
                Conexion.close(conn);
        }        
        return rows;
    }

    @Override
    public int update(Object obj) throws SQLException {
        Bocina bocina = (Bocina)obj;
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try{
            conn = (connBocina != null) ? this.connBocina : Conexion.getConnectoin();
            stmt = conn.prepareStatement(SQL_UPDATE);
            int index = 1;
            stmt.setString(index++, bocina.getMarca());
            stmt.setString(index++, bocina.getTipoSalida());
            stmt.setFloat(index, bocina.getPrecio());            
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizados : " + rows);
            
        }finally{
            Conexion.close(stmt);
            if(connBocina == null)
                Conexion.close(conn);
        }
        return rows;
    }

    @Override
    public int delete(Object obj) throws SQLException {
         Bocina bocina = (Bocina)obj;
         Connection conn = null;
         PreparedStatement stmt = null;
         int rows = 0;
         
         try{
             conn = (this.connBocina != null) ? this.connBocina : Conexion.getConnectoin();
             stmt = conn.prepareStatement(SQL_DELETE);
             stmt.setInt(1, bocina.getIdBocina());
             rows = stmt.executeUpdate();
             System.out.println("Registros eliminados : " + rows);
         }finally{
             Conexion.close(stmt);
             if(this.connBocina == null)
                 Conexion.close(conn);
         }
         
         return rows;
    }

    @Override
    public List<Object> select() throws SQLException {
         Bocina bocina = null;
         List<Object> bocinas = new ArrayList<Object>();
         Connection conn = null;
         PreparedStatement stmt = null;
         ResultSet rs = null;
         
         try{
             conn = (this.connBocina != null) ? this.connBocina : Conexion.getConnectoin();
             stmt = conn.prepareStatement(SQL_SELECT);
             rs = stmt.executeQuery();
             while(rs.next()){
                 int id_bocina = rs.getInt(1);
                 String marca = rs.getString(2);
                 String tipo = rs.getString(3);
                 float precio = rs.getFloat(4);
                 
                 bocina = new Bocina(id_bocina,marca,tipo,precio);
                 bocinas.add(bocina);
             }
         }finally{
             Conexion.close(rs);
             Conexion.close(stmt);
             if(this.connBocina == null)
                 Conexion.close(conn);
         }
         
         return bocinas;
    }
    
}
