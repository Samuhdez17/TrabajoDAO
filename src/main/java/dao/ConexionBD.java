package dao;

import java.sql.*;

public class ConexionBD {
	private static final String URL = "jdbc:mysql://localhost:3306/biblioteca";
	private final static String USER = "root";
	private final static String PASSWORD = "";

    public static Connection getConexion() {
        Connection conexion;
        try {
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException ex) {
            System.err.println("Error al conectar con la base de datos: ");
            throw new RuntimeException(ex);
        }

        return conexion;
    }
}