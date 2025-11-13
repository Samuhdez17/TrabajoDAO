package dao.libro_autor;


import java.util.List;

public interface LibroAutorDAO {
    void addLibroAutor(LibroAutorDAO libroAutor) throws Exception;
    List<LibroAutorDAO> getAll() throws Exception;
    LibroAutorDAO getAutorById(int id) throws Exception;
    LibroAutorDAO getLibroById(int id) throws Exception;
    void deleteAutor(int id) throws Exception;
}
