package Grafico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;

import Logica.Libro;

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
}
//hola