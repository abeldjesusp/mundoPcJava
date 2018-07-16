package mundopc.datos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import mundopc.domain.Computadora;

public class DBComputadora implements iDataBase{
    private Connection connComputadora;
    private final String SQL_INSERT = 
            "INSERT INTO Computadoras(id_teclado1,id_bocina1,id_raton1,id_monitor1,precioTotal) VALUES(?,?,?,?,?)";
    private final String SQL_UPDATE = 
            "UPDATE  Computadoras SET id_teclado1=?,id_bocina1=?,id_raton1=?,id_monitor1=?,precioTotal=? WHERE id_computadora=?";
    private final String SQL_DELETE = 
            "DELETE FROM Computadoras WHERE id_computadora=?";
    private final String SQL_SELECT = 
            "SELECT * FROM Computadoras OREDER BY id_computadora";
   
    public DBComputadora(){}
  
    public DBComputadora(Connection connComputadora){
        this.connComputadora = connComputadora;
    }

    @Override
    public int insert(Object obj) throws SQLException {
        Computadora computadora = (Computadora)obj;
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try{
            conn = (connComputadora != null) ? this.connComputadora : Conexion.getConnectoin();
            stmt = conn.prepareStatement(SQL_INSERT);
            int index = 1;
            stmt.setInt(index++, computadora.getTeclado().getIdTeclado());
            stmt.setInt(index++, computadora.getBocina().getIdBocina());
            stmt.setInt(index++, computadora.getRaton().getIdRaton());
            stmt.setInt(index++, computadora.getMonitor().getIdMonitor());
            stmt.setFloat(index++, computadora.getPrecioTotal());
            
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados : " + rows);
        }finally{
            Conexion.close(stmt);
            if(connComputadora == null)
                Conexion.close(conn);
        }        
        return rows;
    }

    @Override
    public int update(Object obj) throws SQLException {
        Computadora computadora = (Computadora)obj;
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try{
            conn = (connComputadora != null) ? this.connComputadora : Conexion.getConnectoin();
            stmt = conn.prepareStatement(SQL_UPDATE);
            int index = 1;
            stmt.setInt(index++, computadora.getTeclado().getIdTeclado());
            stmt.setInt(index++, computadora.getBocina().getIdBocina());
            stmt.setInt(index++, computadora.getRaton().getIdRaton());
            stmt.setInt(index++, computadora.getMonitor().getIdMonitor());
            stmt.setFloat(index++, computadora.getPrecioTotal());
            
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizados : " + rows);
            
        }finally{
            Conexion.close(stmt);
            if(connComputadora == null)
                Conexion.close(conn);
        }
        return rows;
    }

    @Override
    public int delete(Object obj) throws SQLException {
         Computadora computadora = (Computadora)obj;
         Connection conn = null;
         PreparedStatement stmt = null;
         int rows = 0;
         
         try{
             conn = (this.connComputadora != null) ? this.connComputadora : Conexion.getConnectoin();
             stmt = conn.prepareStatement(SQL_DELETE);
             stmt.setInt(1, computadora.getIdComputadora());            
             rows = stmt.executeUpdate();
             System.out.println("Registros eliminados : " + rows);
         }finally{
             Conexion.close(stmt);
             if(this.connComputadora == null)
                 Conexion.close(conn);
         }
         
         return rows;
    }

    @Override
    public List<Object> select() throws SQLException {
         Computadora computadora = null;
         List<Object> ratones = new ArrayList<Object>();
         Connection conn = null;
         PreparedStatement stmt = null;
         ResultSet rs = null;
         
         try{
             conn = (this.connComputadora != null) ? this.connComputadora : Conexion.getConnectoin();
             stmt = conn.prepareStatement(SQL_SELECT);
             rs = stmt.executeQuery();
             while(rs.next()){
                 int id_teclado = rs.getInt(1);
                 
                 computadora = new Computadora();
                 ratones.add(computadora);
             }
         }finally{
             Conexion.close(rs);
             Conexion.close(stmt);
             if(this.connComputadora == null)
                 Conexion.close(conn);
         }
         
         return ratones;
    }
    
}
