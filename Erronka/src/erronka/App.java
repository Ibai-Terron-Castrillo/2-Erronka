package erronka;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // Crear una instancia de langilea
        langilea langilea1 = new langilea("Aitor", "Auzmendi", "aitor123", "password123", "aitor@example.com", "123456789", "73628688F", 1);

        // Crear un escáner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Solicitar nombre de usuario y contraseña al usuario
        System.out.print("Introduce tu nombre de usuario: ");
        String usuario = scanner.nextLine();

        System.out.print("Introduce tu contraseña: ");
        String contrasena = scanner.nextLine();

        // Intentar iniciar sesión
        boolean inicioExitoso = langilea1.login(usuario, contrasena);

        // Si el inicio de sesión es exitoso, mostrar un mensaje
        if (inicioExitoso) {
            System.out.println("Inicio de sesión exitoso.");
        } else {
            System.out.println("Error en el inicio de sesión.");
        }

        // Cerrar el escáner
        scanner.close();
    }
}
