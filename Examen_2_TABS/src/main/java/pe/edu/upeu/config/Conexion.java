package pe.edu.upeu.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String DRIVER = "oracle.jdbc.OracleDriver";
    private static final String USER = "C##exalp1";
    private static final String PASS = "123";
    
    private static Connection c = null;
    public static Connection getConexion(){
    	    try {
                Class.forName(DRIVER);
                if(c==null){
                    c = DriverManager.getConnection(URL, USER, PASS);
                }
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("Error Conexion: "+e);
            }
            return c;        
    }
   public static void cerrar() throws SQLException {
      if (c != null) {
         c.close();
      }
   }
}
