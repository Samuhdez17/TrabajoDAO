package org.example;

import dao.autor.AutorDAO;
import dao.autor.AutorImpl;
import dao.libro.LibroDAO;
import dao.libro.LibroImpl;
import dao.libro_autor.LibroAutorDAO;
import dao.libro_autor.LibroAutorImpl;
import dao.prestamo.PrestamoDAO;
import dao.prestamo.PrestamoImpl;
import dao.usuario.UsuarioDAO;
import dao.usuario.UsuarioImpl;
import service.BibliotecaService;

import java.util.Scanner;

public class Main {
    private static final Scanner ENTRADA = new Scanner(System.in);
    public static void main(String[] args) {
        AutorDAO autorDAO = new AutorImpl();
        LibroDAO libroDAO = new LibroImpl();
        LibroAutorDAO libroAutorDAO = new LibroAutorImpl();
        PrestamoDAO prestamoDAO = new PrestamoImpl();
        UsuarioDAO usuarioDAO = new UsuarioImpl();
        BibliotecaService servicio = new BibliotecaService(libroDAO, autorDAO, libroAutorDAO, prestamoDAO, usuarioDAO);
        int opcion = 0;
        do {
            System.out.println("""
            =====MENÚ DAO=====
            1.  Agregar Autor
            2.  Agregar Libro
            3.  Agregar Préstamo
            4.  Agregar Usuario
            5.  Listar Autores
            6.  Listar Libros
            7.  Listar Préstamos
            8.  Listar Usuarios
            9.  Actualizar Autor
            10. Actualizar Libro
            11. Actualizar Préstamo
            12. Actualizar Usuario
            13. Borrar Autor
            14. Borrar Libro
            15. Borrar Préstamo
            16. Borrar Usuario
            0. Salir
            """);
            switch (opcion) {
                case 1 -> {}
                case 2 -> {}
                case 3 -> {}
                case 4 -> {}
                case 5 -> {}
                case 6 -> {}
                case 7 -> {}
                case 8 -> {}
                case 9 -> {}
                case 10 -> {}
                case 11 -> {}
                case 12 -> {}
                case 13 -> {}
                case 14 -> {}
                case 15 -> {}
                case 16 -> {}
                case 17 -> {}
                case 18 -> {}
                case 19 -> {}
                case 20 -> {}
                case 0 -> {}
            }
        }while (opcion != 0);
    }
}
