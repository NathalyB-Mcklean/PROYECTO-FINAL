package Logica;

public class Main {
    public static void main(String[] args) {
        Usuario usuario = new Usuario(1, "Juan Perez", "Calle Falsa 123", "555-1234", "juan@example.com", "password123");
        Libro libro = new Libro(1, "El Quijote", "Novela", "Editorial Ejemplo", "1234567890");

        // Usuario registra y inicia sesión
        usuario.registrar();
        boolean loginExitoso = usuario.iniciarSesion("juan@example.com", "password123");

        if (loginExitoso) {
            System.out.println("Inicio de sesión exitoso");

            // Usuario recomienda y opina sobre un libro
            usuario.recomendarLibro(libro, 5);
            usuario.opinarSobreLibro(libro, "Excelente libro!", 5);
        } else {
            System.out.println("Credenciales incorrectas");
        }
    }
}
