package Logica;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

public class Libro {
    // Atributos de la clase Libro
    private static Libro[] libros = {
        new Libro("Cien años de soledad", "Gabriel García Márquez", "Una obra maestra de Gabriel García Márquez que narra la historia de la familia Buendía a lo largo de varias generaciones en el pueblo ficticio de Macondo. Con un estilo mágico-realista, el autor explora temas como la soledad, la violencia y el poder del mito.", "Ficción", "C:\\Users\\natha\\git\\PROYECTO-FINAL\\Proyecto Final - Abrego, Bonilla, Branford, Joseph\\Imágenes\\Portada de libros\\1.png"),
        new Libro("El Principito", "Antoine de Saint-Exupéry", "Una novela corta y la obra más famosa de Antoine de Saint-Exupéry. A través de la historia de un joven príncipe que viaja de planeta en planeta, se exploran profundas lecciones sobre la vida, el amor, la amistad y la pérdida.", "Ficción", "C:\\Users\\natha\\git\\PROYECTO-FINAL\\Proyecto Final - Abrego, Bonilla, Branford, Joseph\\Imágenes\\Portada de libros\\2.jpg"),
        // ... (otros libros)
        new Libro("La Iliada", "Homero", "Un poema épico atribuido a Homero que narra la Guerra de Troya y sigue las hazañas de los héroes griegos, especialmente Aquiles. La obra es fundamental en la literatura clásica y explora temas de honor, destino y la naturaleza de los dioses.", "Clásicos", "C:\\Users\\natha\\git\\PROYECTO-FINAL\\Proyecto Final - Abrego, Bonilla, Branford, Joseph\\Imágenes\\Portada de libros\\25.jpeg")
    };

    private String titulo;
    private String autor;
    private String descripcion;
    private String categoria;
    private String portada; // Nuevo atributo para la portada del libro
    private boolean leido; // Atributo para indicar si el libro ha sido leído

    // Constructor de la clase Libro
    public Libro(String titulo, String autor, String descripcion, String categoria, String portada) {
        this.titulo = titulo;
        this.autor = autor;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.portada = portada; // Inicializa el nuevo atributo portada
        this.leido = false; // Por defecto, ningún libro se marca como leído al inicio
    }

    // Getters y setters para los atributos
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    public boolean isLeido() {
        return leido;
    }

    public void setLeido(boolean leido) {
        this.leido = leido;
    }

    // Método estático para obtener todos los libros
    public static Libro[] obtenerLibros() {
        return libros;
    }

    // Método para obtener libros filtrados por categoría
    public static List<Libro> obtenerLibrosPorCategoria(String categoria) {
        List<Libro> librosFiltrados = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.getCategoria().equalsIgnoreCase(categoria)) {
                librosFiltrados.add(libro);
            }
        }
        return librosFiltrados;
    }

    public ImageIcon getPortadaIcon() {
        return new ImageIcon(portada);
    }
}
