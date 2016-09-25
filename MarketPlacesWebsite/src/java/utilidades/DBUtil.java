package utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBUtil {
    private static Connection conexion;
    
    public static Connection getConexion(){
        conexion = null;
        try {
            //  Carga el driver de la base de datos
            Class.forName("oracle.jdbc.OracleDriver");
            System.out.println("Driver de ORACLE cargado");
            
            String nombreUsuario ="MKPLDBA";
            String password ="12345";
            String url= "jdbc:oracle:thin:@localhost:1521:XE";
            
            conexion = DriverManager.getConnection(url,nombreUsuario, password);
            System.out.println("Conexión establecida");
        } catch (ClassNotFoundException ex) {
            System.out.println("Clase no encontrada");
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            System.out.println("Excepción: " + ex.getMessage());
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conexion;
    } 
}
