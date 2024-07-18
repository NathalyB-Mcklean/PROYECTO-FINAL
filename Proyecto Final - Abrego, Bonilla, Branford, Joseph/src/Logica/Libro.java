package Logica;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class Libro {
    // Atributos de la clase Libro
    public static Libro[] libros = {

        new Libro("Cien años de soledad", "Gabriel García Márquez", "Una obra maestra de Gabriel García Márquez que narra la historia de la familia Buendía a lo largo de varias generaciones en el pueblo ficticio de Macondo. Con un estilo mágico-realista, el autor explora temas como la soledad, la violencia y el poder del mito.", "Ficción", "C:\\Users\\natha\\git\\PROYECTO-FINAL\\Proyecto Final - Abrego, Bonilla, Branford, Joseph\\Imágenes\\Portada de libros\\1.png"),
        new Libro("El principito", "Antoine de Saint-Exupéry", "Una novela corta y la obra más famosa de Antoine de Saint-Exupéry. A través de la historia de un joven príncipe que viaja de planeta en planeta, se exploran profundas lecciones sobre la vida, el amor, la amistad y la pérdida.", "Ficción", "C:\\Users\\natha\\git\\PROYECTO-FINAL\\Proyecto Final - Abrego, Bonilla, Branford, Joseph\\Imágenes\\Portada de libros\\2.jpg"),
        new Libro("Don Quijote de la Mancha", "Miguel de Cervantes", "La obra cumbre de la literatura española escrita por Miguel de Cervantes. Esta novela relata las aventuras de un hidalgo manchego que, enloquecido por la lectura de libros de caballerías, decide convertirse en un caballero andante para revivir la justicia en el mundo.", "Clásicos","C:\\Users\\natha\\git\\PROYECTO-FINAL\\Proyecto Final - Abrego, Bonilla, Branford, Joseph\\Imágenes\\Portada de libros\\3.jpeg"),
        new Libro("Harry Potter y la piedra filosofal", "J.K. Rowling", "El primer libro de la serie de Harry Potter escrita por J.K. Rowling. Este libro introduce a los lectores en el mundo mágico, siguiendo a Harry mientras descubre su herencia mágica y asiste a la Escuela de Magia y Hechicería de Hogwarts.", "Ficción","C:\\Users\\natha\\git\\PROYECTO-FINAL\\Proyecto Final - Abrego, Bonilla, Branford, Joseph\\Imágenes\\Portada de libros\\4.png"),
        new Libro("1984", "George Orwell", "Una novela distópica de George Orwell que describe un futuro totalitario. La obra explora temas como la vigilancia, el control de la información, la represión política y el poder de la propaganda en una sociedad donde el Gran Hermano lo ve todo.", "Ficción","C:\\Users\\natha\\git\\PROYECTO-FINAL\\Proyecto Final - Abrego, Bonilla, Branford, Joseph\\Imágenes\\Portada de libros\\5.jpeg"),
        new Libro("Orgullo y prejuicio", "Jane Austen", "Una novela romántica de Jane Austen que narra la vida de la familia Bennet y sus cinco hijas en la Inglaterra rural del siglo XIX. La historia se centra en las relaciones y los malentendidos entre Elizabeth Bennet y el señor Darcy.", "Romance", "C:\\Users\\natha\\git\\PROYECTO-FINAL\\Proyecto Final - Abrego, Bonilla, Branford, Joseph\\Imágenes\\Portada de libros\\6.jpeg"),
        new Libro("Matar a un ruiseñor", "Harper Lee", "Una novela clásica de la literatura estadounidense escrita por Harper Lee. Ambientada en el sur de Estados Unidos durante la Gran Depresión, la historia aborda temas de racismo, justicia y moralidad a través de los ojos de Scout Finch, una niña de seis años.", "Clásicos","C:\\Users\\natha\\git\\PROYECTO-FINAL\\Proyecto Final - Abrego, Bonilla, Branford, Joseph\\Imágenes\\Portada de libros\\7.jpeg"),
        new Libro("El gran Gatsby", "F. Scott Fitzgerald", "Una obra maestra de F. Scott Fitzgerald que explora la decadencia y el exceso del Jazz Age en Estados Unidos. La novela sigue al misterioso millonario Jay Gatsby y su obsesión por la hermosa Daisy Buchanan.", "Ficción","C:\\Users\\natha\\git\\PROYECTO-FINAL\\Proyecto Final - Abrego, Bonilla, Branford, Joseph\\Imágenes\\Portada de libros\\8.jpeg"),
        new Libro("La metamorfosis", "Franz Kafka", "Una novela corta de Franz Kafka que cuenta la historia de Gregor Samsa, un comerciante que se despierta una mañana convertido en un gigantesco insecto. La obra explora temas de alienación, culpa y la relación entre el individuo y la sociedad.", "Ficción","C:\\Users\\natha\\git\\PROYECTO-FINAL\\Proyecto Final - Abrego, Bonilla, Branford, Joseph\\Imágenes\\Portada de libros\\9.jpg"),
        new Libro("Crimen y castigo", "Fiódor Dostoyevski", "Una novela de Fiódor Dostoyevski que narra la vida de Raskolnikov, un ex estudiante que comete un asesinato y enfrenta las consecuencias psicológicas y morales de su acto. La obra profundiza en temas de culpa, redención y la lucha entre el bien y el mal.", "Clásicos","C:\\Users\\natha\\git\\PROYECTO-FINAL\\Proyecto Final - Abrego, Bonilla, Branford, Joseph\\Imágenes\\Portada de libros\\10.jpeg"),
        new Libro("Frankenstein", "Mary Shelley", "Una novela gótica de Mary Shelley que cuenta la historia de Victor Frankenstein, un científico que crea una criatura monstruosa en un experimento científico. La obra aborda temas como la ética científica, la creación y la responsabilidad.", "Novela Gótica","C:\\Users\\natha\\git\\PROYECTO-FINAL\\Proyecto Final - Abrego, Bonilla, Branford, Joseph\\Imágenes\\Portada de libros\\13.jpeg"),
        new Libro("Drácula", "Bram Stoker", "Una novela gótica de Bram Stoker que narra la historia del Conde Drácula y su intento de mudarse de Transilvania a Inglaterra para extender la maldición de los no muertos. La obra es fundamental en la literatura de vampiros.", "Novela Gótica","C:\\Users\\natha\\git\\PROYECTO-FINAL\\Proyecto Final - Abrego, Bonilla, Branford, Joseph\\Imágenes\\Portada de libros\\14.jpeg"),
        new Libro("El retrato de Dorian Gray", "Oscar Wilde", "Una novela gótica de Oscar Wilde que cuenta la historia de un joven aristócrata que desea permanecer eternamente joven. Su deseo se cumple y su retrato envejece en su lugar, mientras su vida se llena de corrupción y decadencia.", "Novela Gótica","C:\\Users\\natha\\git\\PROYECTO-FINAL\\Proyecto Final - Abrego, Bonilla, Branford, Joseph\\Imágenes\\Portada de libros\\15.jpeg"),
        new Libro("El extraño caso del Dr. Jekyll y Mr. Hyde", "Robert Louis Stevenson", "Una novela de terror psicológico de Robert Louis Stevenson que explora la dualidad de la naturaleza humana a través de la historia del Dr. Jekyll, quien crea una poción que lo transforma en el malvado Mr. Hyde.", "Terror psicológico", "C:\\Users\\natha\\git\\PROYECTO-FINAL\\Proyecto Final - Abrego, Bonilla, Branford, Joseph\\Imágenes\\Portada de libros\\16.jpg"),
        new Libro("Jane Eyre", "Charlotte Brontë", "Una novela romántica y gótica de Charlotte Brontë que narra la vida de Jane Eyre, una huérfana que se convierte en institutriz y se enamora de su empleador, el atormentado y misterioso señor Rochester.", "Romance", "C:\\Users\\natha\\git\\PROYECTO-FINAL\\Proyecto Final - Abrego, Bonilla, Branford, Joseph\\Imágenes\\Portada de libros\\17.png"),
        new Libro("Cumbres borrascosas", "Emily Brontë", "Una novela gótica y romántica de Emily Brontë que cuenta la trágica historia de amor entre Heathcliff y Catherine Earnshaw en los páramos de Yorkshire. La obra explora temas de venganza, pasión y destrucción.", "Novela Gótica","C:\\Users\\natha\\git\\PROYECTO-FINAL\\Proyecto Final - Abrego, Bonilla, Branford, Joseph\\Imágenes\\Portada de libros\\18.jpg"),
        new Libro("Los miserables", "Victor Hugo", "Una novela histórica de Victor Hugo que sigue la vida de varios personajes, principalmente Jean Valjean, un ex convicto que busca redimirse en la Francia del siglo XIX. La obra aborda temas de justicia, moralidad y redención.", "Historia","C:\\Users\\natha\\git\\PROYECTO-FINAL\\Proyecto Final - Abrego, Bonilla, Branford, Joseph\\Imágenes\\Portada de libros\\19.png"),
        new Libro("Guerra y paz", "León Tolstói", "Una novela histórica de León Tolstói que narra la vida de varias familias aristocráticas rusas durante las guerras napoleónicas. La obra explora temas de amor, guerra, poder y cambio social.", "Historia","C:\\Users\\natha\\git\\PROYECTO-FINAL\\Proyecto Final - Abrego, Bonilla, Branford, Joseph\\Imágenes\\Portada de libros\\18.jpg"),
        new Libro("Ana Karenina", "León Tolstói", "Una novela de León Tolstói que narra la trágica historia de amor entre Ana Karenina y el Conde Vronsky en la Rusia del siglo XIX. La obra aborda temas de infidelidad, pasión, y las estrictas normas sociales.", "Romance", "C:\\Users\\natha\\git\\PROYECTO-FINAL\\Proyecto Final - Abrego, Bonilla, Branford, Joseph\\Imágenes\\Portada de libros\\19.png"),
        new Libro("La casa de los espíritus", "Isabel Allende", "Una novela de Isabel Allende que mezcla realismo mágico y la historia de la familia Trueba a lo largo de varias generaciones en un país sudamericano. La obra explora temas de amor, política y revolución.", "Ficción","C:\\Users\\natha\\git\\PROYECTO-FINAL\\Proyecto Final - Abrego, Bonilla, Branford, Joseph\\Imágenes\\Portada de libros\\20.png"),
        new Libro("La sombra del viento", "Carlos Ruiz Zafón", "Una novela de Carlos Ruiz Zafón ambientada en la Barcelona de posguerra, donde un joven llamado Daniel Sempere descubre un misterioso libro que lo lleva a desentrañar oscuros secretos del pasado.", "Ficción","C:\\Users\\natha\\git\\PROYECTO-FINAL\\Proyecto Final - Abrego, Bonilla, Branford, Joseph\\Imágenes\\Portada de libros\\21.png"),
        new Libro("El nombre de la rosa", "Umberto Eco", "Una novela histórica y de misterio de Umberto Eco que sigue a un monje franciscano, Guillermo de Baskerville, y su aprendiz Adso, mientras investigan una serie de asesinatos en una abadía benedictina del siglo XIV.", "Historia","C:\\Users\\natha\\git\\PROYECTO-FINAL\\Proyecto Final - Abrego, Bonilla, Branford, Joseph\\Imágenes\\Portada de libros\\22.jpg"),
        new Libro("El amor en los tiempos del cólera", "Gabriel García Márquez", "Una novela de Gabriel García Márquez que cuenta la historia de amor entre Florentino Ariza y Fermina Daza a lo largo de más de cincuenta años. La obra explora temas de amor, pasión y la vida en el Caribe colombiano.", "Romance","C:\\Users\\natha\\git\\PROYECTO-FINAL\\Proyecto Final - Abrego, Bonilla, Branford, Joseph\\Imágenes\\Portada de libros\\23.png"),
        new Libro("La odisea", "Homero", "Un poema épico atribuido a Homero que narra el regreso a casa del héroe griego Odiseo después de la Guerra de Troya. La obra es fundamental en la literatura occidental y aborda temas como el heroísmo, la astucia y la lucha por el regreso.", "Clásicos","C:\\Users\\natha\\git\\PROYECTO-FINAL\\Proyecto Final - Abrego, Bonilla, Branford, Joseph\\Imágenes\\Portada de libros\\24.jpg"),
        new Libro("La iliada", "Homero", "Un poema épico atribuido a Homero que narra la Guerra de Troya y sigue las hazañas de los héroes griegos, especialmente Aquiles. La obra es fundamental en la literatura clásica y explora temas de honor, destino y la naturaleza de los dioses.", "Clásicos", "C:\\Users\\natha\\git\\PROYECTO-FINAL\\Proyecto Final - Abrego, Bonilla, Branford, Joseph\\Imágenes\\Portada de libros\\25.jpeg")

    };


    public String titulo;
    public String autor;
    public String descripcion;
    public String categoria;
    public String portada; // Nuevo atributo para la portada del libro

    // Constructor de la clase Libro
    public Libro(String titulo, String autor, String descripcion, String categoria, String portada) {
        this.titulo = titulo;
        this.autor = autor;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.portada = portada; // Inicializa el nuevo atributo portada
       
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