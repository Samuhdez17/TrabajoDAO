package service;

import dao.autor.AutorDAO;
import dao.libro.LibroDAO;
import dao.libro_autor.LibroAutorDAO;
import dao.prestamo.PrestamoDAO;
import dao.usuario.UsuarioDAO;
import model.Libro;

import java.util.List;

public class BibliotecaService {
    /*
    TODO: Implementar todos los metodos de los DAO's para que se usen en Main
     */
    private LibroDAO libroDAO;
    private AutorDAO autorDAO;
    private LibroAutorDAO libroAutorDAO;
    private PrestamoDAO prestamoDAO;
    private UsuarioDAO usuarioDAO;

    public BibliotecaService(LibroDAO libroDAO, AutorDAO autorDAO, LibroAutorDAO libroAutorDAO, PrestamoDAO prestamoDAO, UsuarioDAO usuarioDAO) {
        this.libroDAO = libroDAO;
        this.autorDAO = autorDAO;
        this.libroAutorDAO = libroAutorDAO;
        this.prestamoDAO = prestamoDAO;
        this.usuarioDAO = usuarioDAO;

    }
    public void registrarLibro(String titulo) {
        try {
            Libro libro = new Libro(0, titulo);
            libroDAO.addLibro(libro);
        } catch (Exception e) {
            System.err.println("Error al registrar libro: " + e.getMessage());
        }
    }

    public List<Libro> listarLibros() {
        try {
            return libroDAO.getAllLibros();
        } catch (Exception e) {
            System.err.println("Error al listar libros: " + e.getMessage());
            return List.of();
        }
    }

    public void cambiarTitulo(int id, String nuevoTitulo) {
        try {
            Libro libro = libroDAO.getLibroById(id);
            if (libro != null) {
                libro.setTitulo(nuevoTitulo);
                libroDAO.updateLibro(libro);
            } else {
                System.out.println("Service: No se encontró el libro con id=" + id);
            }
        } catch (Exception e) {
            System.err.println("Error al actualizar libro: " + e.getMessage());
        }
    }

    public void eliminarLibro(int id) {
        try {
            libroDAO.deleteLibro(id);
        } catch (Exception e) {
            System.err.println("Error al eliminar libro: " + e.getMessage());
        }
    }
}
