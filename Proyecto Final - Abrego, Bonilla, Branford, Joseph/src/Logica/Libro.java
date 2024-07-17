package Grafico;

<<<<<<< HEAD
import javax.swing.ImageIcon;
import java.util.ArrayList;
import java.util.List;
=======
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;
>>>>>>> branch 'master' of git@github.com:NathalyB-Mcklean/PROYECTO-FINAL.git

<<<<<<< HEAD
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
=======
import Logica.Libro;
>>>>>>> branch 'master' of git@github.com:NathalyB-Mcklean/PROYECTO-FINAL.git

public class Detalles extends JFrame {

    private JButton btnCerrarSesion;
    private JButton btnMarcarLeido;
    private JLabel lblLibroSeleccionado;
    private JTextArea textAreaResena;
    private JPanel panelResena;
    private JPanel panelCalificacion;
    private JButton[] btnCalificar;
    private JLabel lblPortada;

    private boolean leido = false;
    private int calificacion = 0;

    public Detalles(String tituloLibro, String descripcionLibro, ImageIcon portada) {
        setTitle("Detalles del Libro");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600); // Tamaño del JFrame
        setLocationRelativeTo(null); // Centrar en pantalla
        getContentPane().setLayout(new BorderLayout()); // Usar BorderLayout
        getContentPane().setBackground(new Color(0x283652)); // Color de fondo #283652

        JPanel panelTop = new JPanel(null);
        panelTop.setPreferredSize(new Dimension(800, 60));
        panelTop.setBackground(new Color(0x283652));

        // Botón Cerrar Sesión
        btnCerrarSesion = new JButton("Regresar");
        btnCerrarSesion.setFont(new Font("Arial", Font.PLAIN, 14));
        btnCerrarSesion.setForeground(Color.BLACK);
        btnCerrarSesion.setBackground(new Color(0x445E91)); 
        btnCerrarSesion.setBounds(20, 15, 120, 30);
        btnCerrarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para cerrar sesión
                dispose(); // Cerrar el JFrame actual
            }
        });
        panelTop.add(btnCerrarSesion);

        // Botón Por Leer / Leído
        btnMarcarLeido = new JButton("Por Leer");
        btnMarcarLeido.setFont(new Font("Arial", Font.PLAIN, 14));
        btnMarcarLeido.setForeground(Color.BLACK);
        btnMarcarLeido.setBackground(new Color(0x445E91)); 
        btnMarcarLeido.setBounds(160, 15, 120, 30);
        btnMarcarLeido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cambiar el estado de leído
                leido = !leido;
                if (leido) {
                    btnMarcarLeido.setText("Leído");
                    btnMarcarLeido.setBackground(new Color(0x576E9C)); // Color verde
                } else {
                    btnMarcarLeido.setText("Por Leer");
                    btnMarcarLeido.setBackground(new Color(0x445E91)); // Color amarillo
                }
            }
        });
        panelTop.add(btnMarcarLeido);

        getContentPane().add(panelTop, BorderLayout.NORTH);

        JPanel panelCenter = new JPanel(null);
        panelCenter.setBackground(new Color(0x283652));

        // Etiqueta para mostrar el libro seleccionado
        lblLibroSeleccionado = new JLabel(tituloLibro);
        lblLibroSeleccionado.setFont(new Font("Arial", Font.BOLD, 18));
        lblLibroSeleccionado.setForeground(Color.WHITE);
        lblLibroSeleccionado.setBounds(20, 10, 760, 30);
        panelCenter.add(lblLibroSeleccionado);

        // Etiqueta para la portada del libro
        lblPortada = new JLabel(portada);
        lblPortada.setBounds(20, 50, 200, 300);
        panelCenter.add(lblPortada);

        // Panel para la sección de reseña
        panelResena = new JPanel(new BorderLayout());
        panelResena.setBackground(new Color(0x283652)); // Color de fondo #283652
        panelResena.setBorder(new EmptyBorder(10, 0, 10, 0));
        panelResena.setBounds(240, 50, 520, 300);

        // Etiqueta para la sección de reseña
        JLabel lblResena = new JLabel("Reseña:");
        lblResena.setFont(new Font("Arial", Font.PLAIN, 14));
        lblResena.setForeground(Color.WHITE);
        panelResena.add(lblResena, BorderLayout.NORTH);

        // Área de texto para la reseña
        textAreaResena = new JTextArea(descripcionLibro);
        textAreaResena.setLineWrap(true);
        textAreaResena.setWrapStyleWord(true);
        JScrollPane scrollPaneResena = new JScrollPane(textAreaResena);
        panelResena.add(scrollPaneResena, BorderLayout.CENTER);

        panelCenter.add(panelResena);

        // Panel para la sección de calificación
        panelCalificacion = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panelCalificacion.setBackground(new Color(0x283652)); // Color de fondo #283652
        panelCalificacion.setBorder(new EmptyBorder(10, 0, 10, 0));
        panelCalificacion.setBounds(20, 370, 740, 80);

        // Etiqueta "Calificación"
        JLabel lblCalificacion = new JLabel("Calificación:");
        lblCalificacion.setFont(new Font("Arial", Font.PLAIN, 14));
        lblCalificacion.setForeground(Color.WHITE);
        panelCalificacion.add(lblCalificacion);

        // Botones para calificar por estrellas
        btnCalificar = new JButton[5];
        for (int i = 0; i < btnCalificar.length; i++) {
            btnCalificar[i] = new JButton("★");
            btnCalificar[i].setFont(new Font("Arial", Font.BOLD, 20));
            btnCalificar[i].setForeground(Color.BLACK);
            btnCalificar[i].setBackground(new Color(0xCCCCCC)); // Color inicial
            btnCalificar[i].setPreferredSize(new Dimension(40, 40));
            final int index = i;
            btnCalificar[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Establecer calificación y actualizar los botones
                    calificacion = index + 1;
                    updateRatingButtons();
                }
            });
            panelCalificacion.add(btnCalificar[i]);
        }

        panelCenter.add(panelCalificacion);

        getContentPane().add(panelCenter, BorderLayout.CENTER);

        // Establecer visibilidad del JFrame
        setVisible(true);
    }

    // Método para actualizar los botones de calificación
    private void updateRatingButtons() {
        for (int i = 0; i < btnCalificar.length; i++) {
            if (i < calificacion) {
                btnCalificar[i].setBackground(new Color(0xFFFF00)); // Color amarillo para estrellas seleccionadas
            } else {
                btnCalificar[i].setBackground(new Color(0xCCCCCC)); // Color gris para estrellas no seleccionadas
            }
        }
    }

<<<<<<< HEAD
    public ImageIcon getPortadaIcon() {
        return new ImageIcon(portada);
    }
=======
    public static void main(String[] args) {
        // Ejemplo de uso del JFrame Detalles
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ImageIcon portada = new ImageIcon("ruta/a/la/imagen/portada.png");
                new Detalles("Cien años de soledad", "Una obra maestra de Gabriel García Márquez que narra la historia de la familia Buendía.", portada);
            }
        });
    }

	public void setLibroDetalles(Libro libro) {
		// TODO Auto-generated method stub
		
	}
>>>>>>> branch 'master' of git@github.com:NathalyB-Mcklean/PROYECTO-FINAL.git
}
