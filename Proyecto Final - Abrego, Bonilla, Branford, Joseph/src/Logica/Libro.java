package Logica;

import javax.swing.ImageIcon;
import java.util.ArrayList;
import java.util.List;

public class Libro {
    // Atributos de la clase Libro
    private static Libro[] libros = {
            new Libro("Cien años de soledad", "Gabriel García Márquez", "Una obra maestra de Gabriel García Márquez que narra la historia de la familia Buendía a lo largo de varias generaciones en el pueblo ficticio de Macondo. Con un estilo mágico-realista, el autor explora temas como la soledad, la violencia y el poder del mito.", "Ficción", "ruta/a/la/imagen1.png"),
            new Libro("El principito", "Antoine de Saint-Exupéry", "Una novela corta y la obra más famosa de Antoine de Saint-Exupéry. A través de la historia de un joven príncipe que viaja de planeta en planeta, se exploran profundas lecciones sobre la vida, el amor, la amistad y la pérdida.", "Ficción", "ruta/a/la/imagen2.png"),
            new Libro("Don Quijote de la Mancha", "Miguel de Cervantes", "La obra cumbre de la literatura española escrita por Miguel de Cervantes. Esta novela relata las aventuras de un hidalgo manchego que, enloquecido por la lectura de libros de caballerías, decide convertirse en un caballero andante para revivir la justicia en el mundo.", "Clásicos", "ruta/a/la/imagen3.png"),
            new Libro("Harry Potter y la piedra filosofal", "J.K. Rowling", "El primer libro de la serie de Harry Potter escrita por J.K. Rowling. Este libro introduce a los lectores en el mundo mágico, siguiendo a Harry mientras descubre su herencia mágica y asiste a la Escuela de Magia y Hechicería de Hogwarts.", "Ficción", "ruta/a/la/imagen4.png"),
            new Libro("1984", "George Orwell", "Una novela distópica de George Orwell que describe un futuro totalitario. La obra explora temas como la vigilancia, el control de la información, la represión política y el poder de la propaganda en una sociedad donde el Gran Hermano lo ve todo.", "Ficción", "ruta/a/la/imagen5.png"),
            new Libro("Orgullo y prejuicio", "Jane Austen", "Una novela romántica de Jane Austen que narra la vida de la familia Bennet y sus cinco hijas en la Inglaterra rural del siglo XIX. La historia se centra en las relaciones y los malentendidos entre Elizabeth Bennet y el señor Darcy.", "Romance", "ruta/a/la/imagen6.png"),
            new Libro("Matar a un ruiseñor", "Harper Lee", "Una novela clásica de la literatura estadounidense escrita por Harper Lee. Ambientada en el sur de Estados Unidos durante la Gran Depresión, la historia aborda temas de racismo, justicia y moralidad a través de los ojos de Scout Finch, una niña de seis años.", "Clásicos", "ruta/a/la/imagen7.png"),
            new Libro("El gran Gatsby", "F. Scott Fitzgerald", "Una obra maestra de F. Scott Fitzgerald que explora la decadencia y el exceso del Jazz Age en Estados Unidos. La novela sigue al misterioso millonario Jay Gatsby y su obsesión por la hermosa Daisy Buchanan.", "Ficción", "ruta/a/la/imagen8.png"),
            new Libro("La metamorfosis", "Franz Kafka", "Una novela corta de Franz Kafka que cuenta la historia de Gregor Samsa, un comerciante que se despierta una mañana convertido en un gigantesco insecto. La obra explora temas de alienación, culpa y la relación entre el individuo y la sociedad.", "Ficción", "ruta/a/la/imagen9.png"),
            new Libro("Crimen y castigo", "Fiódor Dostoyevski", "Una novela de Fiódor Dostoyevski que narra la vida de Raskolnikov, un ex estudiante que comete un asesinato y enfrenta las consecuencias psicológicas y morales de su acto. La obra profundiza en temas de culpa, redención y la lucha entre el bien y el mal.", "Clásicos", "ruta/a/la/imagen10.png"),
            new Libro("Frankenstein", "Mary Shelley", "Una novela gótica de Mary Shelley que cuenta la historia de Victor Frankenstein, un científico que crea una criatura monstruosa en un experimento científico. La obra aborda temas como la ética científica, la creación y la responsabilidad.", "Novela Gótica", "ruta/a/la/imagen11.png"),
            new Libro("Drácula", "Bram Stoker", "Una novela gótica de Bram Stoker que narra la historia del Conde Drácula y su intento de mudarse de Transilvania a Inglaterra para extender la maldición de los no muertos. La obra es fundamental en la literatura de vampiros.", "Novela Gótica", "ruta/a/la/imagen12.png"),
            new Libro("El retrato de Dorian Gray", "Oscar Wilde", "Una novela gótica de Oscar Wilde que cuenta la historia de un joven aristócrata que desea permanecer eternamente joven. Su deseo se cumple y su retrato envejece en su lugar, mientras su vida se llena de corrupción y decadencia.", "Novela Gótica", "ruta/a/la/imagen13.png"),
            new Libro("El extraño caso del Dr. Jekyll y Mr. Hyde", "Robert Louis Stevenson", "Una novela de terror psicológico de Robert Louis Stevenson que explora la dualidad de la naturaleza humana a través de la historia del Dr. Jekyll, quien crea una poción que lo transforma en el malvado Mr. Hyde.", "Terror psicológico", "ruta/a/la/imagen14.png"),
            new Libro("Jane Eyre", "Charlotte Brontë", "Una novela romántica y gótica de Charlotte Brontë que narra la vida de Jane Eyre, una huérfana que se convierte en institutriz y se enamora de su empleador, el atormentado y misterioso señor Rochester.", "Romance", "ruta/a/la/imagen15.png"),
            new Libro("Cumbres borrascosas", "Emily Brontë", "Una novela gótica y romántica de Emily Brontë que cuenta la trágica historia de amor entre Heathcliff y Catherine Earnshaw en los páramos de Yorkshire. La obra explora temas de venganza, pasión y destrucción.", "Novela Gótica", "ruta/a/la/imagen16.png"),
            new Libro("Los miserables", "Victor Hugo", "Una novela histórica de Victor Hugo que sigue la vida de varios personajes, principalmente Jean Valjean, un ex convicto que busca redimirse en la Francia del siglo XIX. La obra aborda temas de justicia, moralidad y redención.", "Historia", "ruta/a/la/imagen17.png"),
            new Libro("Guerra y paz", "León Tolstói", "Una novela histórica de León Tolstói que narra la vida de varias familias aristocráticas rusas durante las guerras napoleónicas. La obra explora temas de amor, guerra, poder y cambio social.", "Historia", "ruta/a/la/imagen18.png"),
            new Libro("Ana Karenina", "León Tolstói", "Una novela de León Tolstói que narra la trágica historia de amor entre Ana Karenina y el Conde Vronsky en la Rusia del siglo XIX. La obra aborda temas de infidelidad, pasión, y las estrictas normas sociales.", "Romance", "ruta/a/la/imagen19.png"),
            new Libro("La casa de los espíritus", "Isabel Allende", "Una novela de Isabel Allende que mezcla realismo mágico y la historia de la familia Trueba a lo largo de varias generaciones en un país sudamericano. La obra explora temas de amor, política y revolución.", "Ficción", "ruta/a/la/imagen20.png"),
            new Libro("La sombra del viento", "Carlos Ruiz Zafón", "Una novela de Carlos Ruiz Zafón ambientada en la Barcelona de posguerra, donde un joven llamado Daniel Sempere descubre un misterioso libro que lo lleva a desentrañar oscuros secretos del pasado.", "Ficción", "ruta/a/la/imagen21.png"),
            new Libro("El nombre de la rosa", "Umberto Eco", "Una novela histórica y de misterio de Umberto Eco que sigue a un monje franciscano, Guillermo de Baskerville, y su aprendiz Adso, mientras investigan una serie de asesinatos en una abadía benedictina del siglo XIV.", "Historia", "ruta/a/la/imagen22.png"),
            new Libro("El amor en los tiempos del cólera", "Gabriel García Márquez", "Una novela de Gabriel García Márquez que narra la historia de amor entre Fermina Daza y Florentino Ariza a lo largo de varias décadas en un pueblo caribeño. La obra explora temas de amor, paciencia y destino.", "Romance", "ruta/a/la/imagen23.png"),
            new Libro("Rayuela", "Julio Cortázar", "Una novela de Julio Cortázar que sigue la vida de Horacio Oliveira y su grupo de amigos en París y Buenos Aires. La obra es conocida por su estructura no lineal y su exploración de la búsqueda del sentido de la vida.", "Ficción", "ruta/a/la/imagen24.png"),
            new Libro("El túnel", "Ernesto Sabato", "Una novela de terror psicológico de Ernesto Sabato que narra la historia de Juan Pablo Castel, un pintor que se obsesiona con una mujer llamada María y comete un crimen en nombre de su amor.", "Terror psicológico", "ruta/a/la/imagen25.png")
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
