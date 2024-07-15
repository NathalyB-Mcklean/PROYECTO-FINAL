package Logica;

public class Libro {
    // Atributos de la clase Libro
    private static Libro[] libros = {
        new Libro("Cien años de soledad", "Una obra maestra de Gabriel García Márquez que narra la historia de la familia Buendía."),
        new Libro("El principito", "Una novela corta y la obra más famosa de Antoine de Saint-Exupéry."),
        new Libro("Don Quijote de la Mancha", "La obra cumbre de la literatura española escrita por Miguel de Cervantes."),
        new Libro("Harry Potter y la piedra filosofal", "El primer libro de la serie de Harry Potter escrita por J.K. Rowling."),
        new Libro("1984", "Una novela distópica de George Orwell que describe un futuro totalitario.")
        // Puedes seguir añadiendo más libros aquí
    };

    // Atributos de cada libro
    private String titulo;
    private String descripcion;

    // Constructor de la clase Libro
    public Libro(String titulo, String descripcion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    // Método estático para obtener la lista de libros
    public static Libro[] obtenerLibros() {
        return libros;
    }

    // Métodos getter y setter
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
