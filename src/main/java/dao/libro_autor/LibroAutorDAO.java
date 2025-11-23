package dao.libro_autor;


import model.Libro;

import java.sql.SQLException;
import java.util.List;

public interface LibroAutorDAO {
    void addLibroAutor(LibroAutorDAO libroAutor) throws SQLException;
    List<LibroAutorDAO> getAll() throws SQLException;
    List<Libro> getLibrosByAutor(int autor) throws SQLException;
    void deleteAutor(int autor) throws SQLException;
}
