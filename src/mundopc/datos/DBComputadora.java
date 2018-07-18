package mundopc.datos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import mundopc.domain.*;

public class DBComputadora implements iDataBase{
    private Connection connComputadora;
    private final String SQL_INSERT = 
            "INSERT INTO Computadoras(codigo_computadora,id_teclado1,id_bocina1,id_raton1,id_monitor1,precioTotal) VALUES(?,?,?,?,?,?)";
    private final String SQL_UPDATE = 
            "UPDATE  Computadoras SET id_teclado1=?,id_bocina1=?,id_raton1=?,id_monitor1=?,precioTotal=? WHERE id_computadora=?";
    private final String SQL_DELETE = 
            "DELETE FROM Computadoras WHERE id_computadora=?";
    private final String SQL_SELECT = 
            "SELECT Computadoras.id_computadora,\n" +
"                   Computadoras.codigo_computadora,\n" +
"                   Teclados.id_teclado, Teclados.marca, Teclados.tipo_entrada, Teclados.precio,\n" +
"                   Ratones.id_raton, Ratones.marca, Ratones.tipo_entrada, Ratones.precio,\n" +
"                   Bocinas.id_bocina, Bocinas.marca, Bocinas.tipo_salida, Bocinas.precio,\n" +
"                   Monitores.id_monitor, Monitores.marca, Monitores.tipo_salida,Monitores.tamano, Monitores.precio,\n" +
"                   Computadoras.precioTotal\n" +
"            FROM Computadoras\n" +
"                JOIN Teclados\n" +
"                ON Computadoras.id_teclado1 = Teclados.id_teclado\n" +
"                JOIN Ratones\n" +
"                ON Computadoras.id_raton1 = Ratones.id_raton \n" +
"                JOIN Bocinas\n" +
"                ON Computadoras.id_bocina1 = Bocinas.id_bocina\n" +
"                JOIN Monitores\n" +
"                ON Computadoras.id_monitor1 = Monitores.id_monitor\n" +
"            ORDER BY id_computadora";
   
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
            stmt.setString(index++, computadora.getCodigo_computadora());
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
         List<Object> computadoras = new ArrayList<Object>();
         Connection conn = null;
         PreparedStatement stmt = null;
         ResultSet rs = null;
         
         try{
             conn = (this.connComputadora != null) ? this.connComputadora : Conexion.getConnectoin();
             stmt = conn.prepareStatement(SQL_SELECT);
             rs = stmt.executeQuery();
             while(rs.next()){        
                 int id_computadora = rs.getInt(1);
                 String codigoComputadora = rs.getString(2);
                 //Creando objeto teclado
                 int id_teclado = rs.getInt(3);
                 String marcaTeclado = rs.getString(4);
                 String tipoTeclado = rs.getString(5);
                 float precioTeclado = rs.getFloat(6);
                 Teclado objTeclado = new Teclado(id_teclado,marcaTeclado,tipoTeclado,precioTeclado);
                 
                 //Creando objeto Raton
                 int id_raton = rs.getInt(7);
                 String marcaRaton = rs.getString(8);
                 String tipoRaton = rs.getString(9);
                 float precioRaton = rs.getFloat(10);                 
                 Raton objRaton = new Raton(id_raton,marcaRaton,tipoRaton,precioRaton);
                 
                 //Creando objeto Bocinas
                 int id_bocina = rs.getInt(11);
                 String marcaBocina = rs.getString(12);
                 String tipoBocina = rs.getString(13);
                 float precioBocina = rs.getFloat(14);                 
                 Bocina objBocina = new Bocina(id_bocina,marcaBocina,tipoBocina,precioBocina);
                 
                  //Creando objeto Monitor
                 int id_monitor = rs.getInt(15);
                 String marcaMonitor = rs.getString(16);
                 String tipoMonitor = rs.getString(17);
                 float tamanoMonitor = rs.getFloat(18);
                 float precioMonitor = rs.getFloat(19);                 
                 Monitor objMonitor = new Monitor(id_monitor,marcaMonitor,tipoMonitor,tamanoMonitor,precioMonitor);
                 
                 float precioTotalCompu = rs.getFloat(20);
                 
                 //Creando objeto computadora
                 computadora = new Computadora(
                                    id_computadora,
                                    codigoComputadora,
                                    objTeclado,
                                    objBocina,
                                    objRaton,
                                    objMonitor,
                                    precioTotalCompu);
                 computadoras.add(computadora);
             }
         }finally{
             Conexion.close(rs);
             Conexion.close(stmt);
             if(this.connComputadora == null)
                 Conexion.close(conn);
         }
         
         return computadoras;
    }
    
}
