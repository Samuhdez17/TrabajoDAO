package dao.libro_autor;

import dao.ConexionBD;
import model.LibroAutor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LibroAutorImpl implements LibroAutorDAO {
    @Override
    public void addLibroAutor(LibroAutorDAO libroAutor) throws Exception {
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
    public List<LibroAutorDAO> getAll() throws Exception {
        String sql = "SELECT * FROM libroAutor";
        List<LibroAutorDAO> listaLibroAutor = new ArrayList<>();
        try (
                Connection conn = ConexionBD.getConexion();
                PreparedStatement ps = conn.prepareStatement(sql);
        ) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) listaLibroAutor.add(new LibroAutor(rs.getInt(1), rs.getInt(2)));
        }
        return listaLibroAutor;
    }

    @Override
    public LibroAutorDAO getAutorById(int id) throws Exception {
        return null;
    }

    @Override
    public LibroAutorDAO getLibroById(int id) throws Exception {
        return null;
    }

    @Override
    public void deleteAutor(int id) throws Exception {

    }
}
