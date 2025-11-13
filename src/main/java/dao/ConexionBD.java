package dao;

import java.sql.*;

public class ConexionBD {
	private static final String URL = "jdbc:mysql://localhost:3306/biblioteca";
	private static String USER = "root";
	private static String PASSWORD = "a";

	private static Connection conexion;

    public ConexionBD(String usuario, String contra) {
        USER = usuario;
        PASSWORD = contra;
        try {
            conectar();
        } catch (SQLException ex) {
            System.err.println("Error al conectar con la base de datos: " + ex);
        }
    }

    public static Connection getConexion() {
        return conexion;
    }

    private void conectar() throws SQLException {
		 conexion = DriverManager.getConnection(URL, USER, PASSWORD);
	}

	public void desconectar() {
		try {
			if (conexion != null){
				conexion.close();
			}
		} catch (Exception error){
			System.out.println("Error porducido al desconectar la base de datos: " + error);
		}
	}
}