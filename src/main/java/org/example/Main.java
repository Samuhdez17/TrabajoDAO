package org.example;

import dao.ConexionBD;
import java.util.Scanner;

public class Main {
    private static final Scanner ENTRADA = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("========== ACCESO A LA BASE DE DATOS ==========");
        System.out.print("Indica el usuario: ");
        String usuario = ENTRADA.nextLine();
        System.out.println();

        System.out.print("Indica la contraseña: ");
        String password = ENTRADA.nextLine();
        System.out.println();

        ConexionBD conexionBD = new ConexionBD(usuario, password);
        System.out.println("Bienvenido a la base de datos");
    }
}
