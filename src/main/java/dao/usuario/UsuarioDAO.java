package dao.usuario;

import model.Autor;
import model.Usuario;

import java.sql.SQLException;
import java.util.List;

public interface UsuarioDAO {
    void addUsuario(Usuario usuario) throws SQLException;
    List<Usuario> getAll() throws SQLException;
    Autor getUsuarioById(int usuario) throws SQLException;
    void updateUsuario(Usuario usuario) throws SQLException;
    void deleteUsuario(int usuario) throws SQLException;
}
