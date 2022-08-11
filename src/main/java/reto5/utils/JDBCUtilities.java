package reto5.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Clase de realiza la conexion a la base de datos y la retorna
public class JDBCUtilities {
    private static final String UBICACION_BD = "ProyectosConstruccion.db";
    
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:sqlite:" + UBICACION_BD;
        return DriverManager.getConnection(url);
    }
}
