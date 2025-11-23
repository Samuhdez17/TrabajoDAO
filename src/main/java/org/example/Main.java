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
    private static final String MENU_PRINCIPAL = """
            ========= MENU PRINCIPAL =========
            1.  Acceder al menu autor
            2.  Acceder al menu libro
            3.  Acceder al menu préstamo
            4.  Acceder al menu usuario
            0.  Salir
            """;

    private static final String MENU_AUTOR = """
            ========= MENU AUTOR =========
            1. Registrar autor
            2. Listar autores
            3. Actualizar autor
            4. Borrar autor
            0. Salir al menu principal
            """;

    private static final String MENU_LIBRO = """
            ========= MENU LIBRO =========
            1. Registrar libro
            2. Listar libros
            3. Listar libros por autor
            4. Actualizar libro
            5. Borrar libro
            0. Salir al menu principal
            """;

    private static final String MENU_PRESTAMO = """
            ========= MENU PRÉSTAMO =========
            1. Registrar préstamo
            2. Listar préstamos
            3. Listar préstamos atrasados
            4. Borrar préstamo
            0. Salir al menu principal
            """;

    private static final String MENU_USUARIO = """
            ========= MENU USUARIO =========
            1. Registrar usuario
            2. Listar usuarios
            3. Actualizar usuario
            4. Borrar usuario
            0. Salir al menu principal
            """;

    private static final Scanner ENTRADA = new Scanner(System.in);
    public static void main(String[] args) {
        AutorDAO autorDAO = new AutorImpl();
        LibroDAO libroDAO = new LibroImpl();
        LibroAutorDAO libroAutorDAO = new LibroAutorImpl();
        PrestamoDAO prestamoDAO = new PrestamoImpl();
        UsuarioDAO usuarioDAO = new UsuarioImpl();
        BibliotecaService servicio = new BibliotecaService(libroDAO, autorDAO, libroAutorDAO, prestamoDAO, usuarioDAO);
        int opcion = -1;
        while (opcion != 0) {
            System.out.println(MENU_PRINCIPAL);
            opcion = ENTRADA.nextInt();

            switch (opcion) {
                case 1 -> {
                    opcion = -1;
                    while (opcion != 0) {
                        System.out.println(MENU_AUTOR);
                        opcion = ENTRADA.nextInt();
                        switch (opcion) { // TODO: EN CADA CASE INICIALIZA OPCION A -1. EN TODOS LOS SWITCH QUE HAY DEBAJO IGUAL!!
                        }
                    }
                }
                case 2 -> {
                    opcion = -1;
                    while (opcion != 0) {
                        System.out.println(MENU_LIBRO);
                        opcion = ENTRADA.nextInt();
                        switch (opcion) {
                        }
                    }
                }

                case 3 -> {
                    opcion = -1;
                    while (opcion != 0) {
                        System.out.println(MENU_PRESTAMO);
                        opcion = ENTRADA.nextInt();
                        switch (opcion) {
                        }
                    }
                }

                case 4 -> {
                    opcion = -1;
                    while (opcion != 0) {
                        System.out.println(MENU_USUARIO);
                        opcion = ENTRADA.nextInt();
                        switch (opcion) {
                        }
                    }
                }

                case 0 -> System.out.println("Saliendo de la base de datos...");
            }
        }
    }
}