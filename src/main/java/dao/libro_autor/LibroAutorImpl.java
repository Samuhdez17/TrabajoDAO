package dao.libro_autor;

import dao.ConexionBD;
import model.Libro;
import model.LibroAutor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LibroAutorImpl implements LibroAutorDAO {
    @Override
    public void addLibroAutor(LibroAutor libroAutor) throws SQLException {
        String sql = "INSERT INTO libroAutor (idLibro, idAutor) VALUES (?,?)";
        try (
                Connection conn = ConexionBD.getConexion();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setInt(1, libroAutor.getIdLibro());
            ps.setInt(2, libroAutor.getIdAutor());
            ps.executeUpdate();
            System.out.printf("DAO: Relación insertada -> Libro = %d ; Autor = %d\n", libroAutor.getIdLibro(), libroAutor.getIdAutor());
        }
    }

    @Override
    public List<Libro> getLibrosByAutor(int id) throws SQLException {
        String sql = "SELECT id, titulo, isb FROM libro l " +
                "JOIN libroAutor la ON l.id = la.idLibro " +
                "JOIN autor a ON la.idAutor = a.id " +
                "WHERE idAutor = ?";
        List<Libro> listaLibros = new ArrayList<>();

        try (
                Connection conn = ConexionBD.getConexion();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) listaLibros.add(new Libro(rs.getInt("id"), rs.getString("titulo"), rs.getString("isbn")));
        }

        return listaLibros;
    }

    @Override
    public void deleteAutor(int id) throws SQLException {
        String sql = "DELETE FROM libroAutor WHERE idAutor = ?";

        try (
                Connection conn = ConexionBD.getConexion();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.printf("DAO: Autor eliminado -> id = %d\n", id);
        }
    }
}
