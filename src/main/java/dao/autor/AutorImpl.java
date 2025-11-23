package dao.autor;

import dao.ConexionBD;
import model.Autor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AutorImpl implements AutorDAO {
    @Override
    public void addAutor(Autor autor) {
        String sql = "INSERT INTO autor (nombre) VALUES (?)";
        try (
                Connection conn = ConexionBD.getConexion();
                PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        ) {
            ps.setString(1, autor.getNombre());
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) autor.setId(rs.getInt(1));
            }
        } catch (SQLException ex) {
            throw  new RuntimeException(ex);
        }

        System.out.println("DAO: Autor insertado -> " + autor);
    }

    @Override
    public List<Autor> getAllAutores() throws SQLException {
        String sql = "SELECT id, nombre FROM autor " +
                "ORDER BY nombre";
        List<Autor> lista = new ArrayList<>();

        try (
                Connection conn = ConexionBD.getConexion();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {
            while (rs.next()) {
                lista.add(new Autor(rs.getInt("id"), rs.getString("titulo")));
            }
        }
        return lista;
    }

    @Override
    public Autor getAutorById(int id) throws SQLException {
        String sql = "SELECT id, nombre FROM autor WHERE id = ?";
        try (
                Connection conn = ConexionBD.getConexion();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Autor(rs.getInt("id"), rs.getString("titulo"));
                }
            }
        }
        return null;
    }

    @Override
    public Autor getAutorByNombre(String nombre) throws SQLException {
        String sql = "SELECT id, nombre FROM autor WHERE nombre = ?";
        try (
                Connection conn = ConexionBD.getConexion();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setString(1, nombre);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Autor(rs.getInt("id"), rs.getString("nombre"));
                }
            }
        }
        return null;
    }

    @Override
    public void updateAutor(Autor autor) throws SQLException {
        String sql = "UPDATE autor SET nombre = ? WHERE id = ?";
        try (
                Connection conn = ConexionBD.getConexion();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setString(1, autor.getNombre());
            ps.setInt(2, autor.getId());
            ps.executeUpdate();
            System.out.println("DAO: Autor actualizado -> " + autor);
        }
    }

    @Override
    public void deleteAutor(int id) throws SQLException {
        String sql = "DELETE FROM autor WHERE id = ?";
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
