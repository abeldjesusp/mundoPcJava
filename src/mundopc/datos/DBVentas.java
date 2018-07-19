package mundopc.datos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import mundopc.domain.*;
import java.util.Date;

public class DBVentas implements iDataBase{
    private Connection connVentas;
    private final String SQL_INSERT = 
            "INSERT INTO Ventas(codigo_venta,id_computadora1,totalDeVenta,fecha) VALUES(?,?,?,?)";
    private final String SQL_UPDATE = 
            "UPDATE  Ventas SET id_computadora1=?, totalDeVenta=? WHERE id_venta=?";
    private final String SQL_DELETE = 
            "DELETE FROM Ventas WHERE id_venta=?";
    private final String SQL_SELECT = 
            "SELECT Ventas.id_venta,\n" +
                "Ventas.codigo_venta,\n" +
                "Computadoras.id_computadora,\n" +
                "Computadoras.codigo_computadora,\n" +
                "Teclados.id_teclado, Teclados.marca, Teclados.tipo_entrada, Teclados.precio,\n" +
                "Ratones.id_raton, Ratones.marca, Ratones.tipo_entrada, Ratones.precio,\n" +
                "Bocinas.id_bocina, Bocinas.marca, Bocinas.tipo_salida, Bocinas.precio,\n" +
                "Monitores.id_monitor, Monitores.marca, Monitores.tipo_salida,Monitores.tamano, Monitores.precio,\n" +
                "Computadoras.precioTotal,\n" +
                "Ventas.totalDeVenta,\n" +
                "Ventas.fecha\n" +
            "FROM Ventas\n" +
                "JOIN Computadoras\n" +
                "ON Ventas.id_computadora1 =	Computadoras.id_computadora	\n" +
                "JOIN Teclados\n" +
                "ON Computadoras.id_teclado1 = Teclados.id_teclado\n" +
                "JOIN Ratones\n" +
                "ON Computadoras.id_raton1 = Ratones.id_raton \n" +
                "JOIN Bocinas\n" +
                "ON Computadoras.id_bocina1 = Bocinas.id_bocina\n" +
                "JOIN Monitores\n" +
                "ON Computadoras.id_monitor1 = Monitores.id_monitor\n" +
            "ORDER BY id_venta";
   
    public DBVentas(){}
  
    public DBVentas(Connection connVentas){
        this.connVentas = connVentas;
    }

    @Override
    public int insert(Object obj) throws SQLException {
        Venta venta = (Venta)obj;
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try{
            conn = (connVentas != null) ? this.connVentas : Conexion.getConnectoin();
            stmt = conn.prepareStatement(SQL_INSERT);
            
            int index = 1;
            stmt.setString(index++, venta.getCodigo_venta());
            stmt.setInt(index++, venta.getComputadora().getIdComputadora());
            stmt.setFloat(index++, venta.getTotalDeVenta());
            stmt.setTimestamp(index++, new java.sql.Timestamp(venta.getFecha()));            
            
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados : " + rows);
        }finally{
            Conexion.close(stmt);
            if(connVentas == null)
                Conexion.close(conn);
        }        
        return rows;
    }

    @Override
    public int update(Object obj) throws SQLException {
        Venta venta = (Venta)obj;
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try{
            conn = (connVentas != null) ? this.connVentas : Conexion.getConnectoin();
            stmt = conn.prepareStatement(SQL_UPDATE);
            int index = 1;            
            stmt.setInt(index++, venta.getComputadora().getIdComputadora());
            stmt.setFloat(index++, venta.getTotalDeVenta());
            stmt.setInt(index, venta.getIdVenta());
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizados : " + rows);
            
        }finally{
            Conexion.close(stmt);
            if(connVentas == null)
                Conexion.close(conn);
        }
        return rows;
    }

    @Override
    public int delete(Object obj) throws SQLException {
         Venta venta = (Venta)obj;
         Connection conn = null;
         PreparedStatement stmt = null;
         int rows = 0;
         
         try{
             conn = (this.connVentas != null) ? this.connVentas : Conexion.getConnectoin();
             stmt = conn.prepareStatement(SQL_DELETE);
             stmt.setInt(1, venta.getIdVenta());            
             rows = stmt.executeUpdate();
             System.out.println("Registros eliminados : " + rows);
         }finally{
             Conexion.close(stmt);
             if(this.connVentas == null)
                 Conexion.close(conn);
         }
         
         return rows;
    }

    @Override
    public List<Object> select() throws SQLException {
         Venta venta = null;
         List<Object> ventas = new ArrayList<Object>();
         Connection conn = null;
         PreparedStatement stmt = null;
         ResultSet rs = null;
         
         try{
             conn = (this.connVentas != null) ? this.connVentas : Conexion.getConnectoin();
             stmt = conn.prepareStatement(SQL_SELECT);
             rs = stmt.executeQuery();
             while(rs.next()){
                 int idVenta = rs.getInt(1);
                 String codigoVenta = rs.getString(2);
                 
                 int id_computadora = rs.getInt(3);                 
                 String codigoComputadora = rs.getString(4);
                 //Creando objeto teclado
                 int id_teclado = rs.getInt(5);
                 String marcaTeclado = rs.getString(6);
                 String tipoTeclado = rs.getString(7);
                 float precioTeclado = rs.getFloat(8);
                 Teclado objTeclado = new Teclado(id_teclado,marcaTeclado,tipoTeclado,precioTeclado);
                 
                 //Creando objeto Raton
                 int id_raton = rs.getInt(9);
                 String marcaRaton = rs.getString(10);
                 String tipoRaton = rs.getString(11);
                 float precioRaton = rs.getFloat(12);                 
                 Raton objRaton = new Raton(id_raton,marcaRaton,tipoRaton,precioRaton);
                 
                 //Creando objeto Bocinas
                 int id_bocina = rs.getInt(13);
                 String marcaBocina = rs.getString(14);
                 String tipoBocina = rs.getString(15);
                 float precioBocina = rs.getFloat(16);                 
                 Bocina objBocina = new Bocina(id_bocina,marcaBocina,tipoBocina,precioBocina);
                 
                  //Creando objeto Monitor
                 int id_monitor = rs.getInt(17);
                 String marcaMonitor = rs.getString(18);
                 String tipoMonitor = rs.getString(19);
                 float tamanoMonitor = rs.getFloat(20);
                 float precioMonitor = rs.getFloat(21);                 
                 Monitor objMonitor = new Monitor(id_monitor,marcaMonitor,tipoMonitor,tamanoMonitor,precioMonitor);
                 
                 float precioTotalCompu = rs.getFloat(22);
                 
                 float totalDeVenta = rs.getFloat(23);
                 Date ventaFecha = (Date)rs.getDate(24);
                 
                 //Creando objeto computadora
                 Computadora computadora = new Computadora(
                                    id_computadora,
                                    codigoComputadora,
                                    objTeclado,
                                    objBocina,
                                    objRaton,
                                    objMonitor,
                                    precioTotalCompu);
                 
                 venta = new Venta(idVenta,codigoVenta,computadora,totalDeVenta,ventaFecha);
                 ventas.add(venta);
             }
         }finally{
             Conexion.close(rs);
             Conexion.close(stmt);
             if(this.connVentas == null)
                 Conexion.close(conn);
         }
         
         return ventas;
    }
    
}
