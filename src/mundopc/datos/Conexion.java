package mundopc.datos;

import java.sql.*;

public class Conexion {
    private static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String CONNECTIONSTRING = 
                "jdbc:sqlserver://LAPTOP-6CG2O0PG:1433;"
                + "database=mundoPc;"
                + "integratedSecurity=true;";
    
    public static synchronized Connection getConnectoin() throws SQLException{
        try{
            Class.forName(JDBC_DRIVER);
        }catch(Exception sql){
            System.out.println("Fallo! al tratar de cargar el driver");
            sql.printStackTrace();            
        }        
        return DriverManager.getConnection(CONNECTIONSTRING);
    }
    
    public static void close(ResultSet rs){
        try{
            if(rs != null)
                rs.close();
        }catch(SQLException sqle){
            sqle.printStackTrace();
        }
    }
    
    public static void close(PreparedStatement stmt){
        try{
            if(stmt != null)
                stmt.close();
        }catch(SQLException sqle){
            sqle.printStackTrace();
        }
    }
    
    public static void close(Connection conn){
        try{
            if(conn != null)
                conn.close();
        }catch(SQLException sqle){
            sqle.printStackTrace();
        }
    }
}
