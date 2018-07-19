package mundopc.datos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import mundopc.domain.Teclado;

public class DBTeclado implements iDataBase{
    private Connection connTeclado;
    private final String SQL_INSERT = 
            "INSERT INTO Teclados(marca,tipo_entrada,precio) VALUES(?,?,?)";
    private final String SQL_UPDATE = 
            "UPDATE  Teclados SET marca=?,tipo_entrada=?,precio=? WHERE id_teclado=?";
    private final String SQL_DELETE = 
            "DELETE FROM Teclados WHERE id_teclado=?";
    private final String SQL_SELECT = 
            "SELECT * FROM Teclados ORDER BY id_teclado";
   
    public DBTeclado(){}
  
    public DBTeclado(Connection connTeclado){
        this.connTeclado = connTeclado;
    }

    @Override
    public int insert(Object obj) throws SQLException {
        Teclado teclado = (Teclado)obj;
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try{
            conn = (connTeclado != null) ? this.connTeclado : Conexion.getConnectoin();
            stmt = conn.prepareStatement(SQL_INSERT);
            int index = 1;
            stmt.setString(index++, teclado.getMarca());
            stmt.setString(index++, teclado.getTipoEntrada());
            stmt.setFloat(index, teclado.getPrecio());            
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados : " + rows);
        }finally{
            Conexion.close(stmt);
            if(connTeclado == null)
                Conexion.close(conn);
        }        
        return rows;
    }

    @Override
    public int update(Object obj) throws SQLException {
        Teclado teclado = (Teclado)obj;
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try{
            conn = (connTeclado != null) ? this.connTeclado : Conexion.getConnectoin();
            stmt = conn.prepareStatement(SQL_UPDATE);
            int index = 1;
            stmt.setString(index++, teclado.getMarca());
            stmt.setString(index++, teclado.getTipoEntrada());
            stmt.setFloat(index++, teclado.getPrecio());
            stmt.setInt(index, teclado.getIdTeclado());
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizados : " + rows);
            
        }finally{
            Conexion.close(stmt);
            if(connTeclado == null)
                Conexion.close(conn);
        }
        return rows;
    }

    @Override
    public int delete(Object obj) throws SQLException {
         Teclado teclado = (Teclado)obj;
         Connection conn = null;
         PreparedStatement stmt = null;
         int rows = 0;
         
         try{
             conn = (this.connTeclado != null) ? this.connTeclado : Conexion.getConnectoin();
             stmt = conn.prepareStatement(SQL_DELETE);
             stmt.setInt(1, teclado.getIdTeclado());
             rows = stmt.executeUpdate();
             System.out.println("Registros eliminados : " + rows);
         }finally{
             Conexion.close(stmt);
             if(this.connTeclado == null)
                 Conexion.close(conn);
         }
         
         return rows;
    }

    @Override
    public List<Object> select() throws SQLException {
         Teclado teclado = null;
         List<Object> teclados = new ArrayList<Object>();
         Connection conn = null;
         PreparedStatement stmt = null;
         ResultSet rs = null;
         
         try{
             conn = (this.connTeclado != null) ? this.connTeclado : Conexion.getConnectoin();
             stmt = conn.prepareStatement(SQL_SELECT);
             rs = stmt.executeQuery();
             while(rs.next()){
                 int id_teclado = rs.getInt(1);
                 String marca = rs.getString(2);
                 String tipo = rs.getString(3);
                 float precio = rs.getFloat(4);
                 
                 teclado = new Teclado(id_teclado,marca,tipo,precio);
                 teclados.add(teclado);
             }
         }finally{
             Conexion.close(rs);
             Conexion.close(stmt);
             if(this.connTeclado == null)
                 Conexion.close(conn);
         }
         
         return teclados;
    }
    
}
