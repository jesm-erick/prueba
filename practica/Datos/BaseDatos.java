package Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDatos {
    public static Connection connectSQLite() {
        Connection conexion = null;
        try {
            Class.forName("org.sqlite.JDBC");
            String dbURL = "jdbc:sqlite:jhon.db?foreign_keys=on;maxconnection=1";
            conexion = DriverManager.getConnection(dbURL); 
            System.out.println("ok conexión" );    
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error en la conexión" + e);
        }
        return conexion;
    }

    
}
