package Grafico;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Detalles extends JPanel {
    private JButton btnMarcarLeido;
    private JLabel lblLibroSeleccionado;
    private JTextArea textAreaResena;
    private JPanel panelResena;
    private JPanel panelCalificacion;
    private JButton[] btnCalificar;
    private JLabel lblPortada;
    private JTextArea textAreaComentario;
    private JButton btnPublicarComentario;
    private JTextArea textAreaComentariosPublicados;

    private boolean leido = false;
    private int calificacion;
    private ArrayList<String> comentarios;

    private CardLayout cardLayout;
    private JPanel panelPrincipal;

    private String tituloLibro;

    public Detalles(String tituloLibro, String descripcionLibro, ImageIcon portada, CardLayout cardLayout, JPanel panelPrincipal) {
        this.cardLayout = cardLayout;
        this.panelPrincipal = panelPrincipal;
        this.tituloLibro = tituloLibro;

        setBackground(new Color(0x283652)); // Color de fondo #283652
        setLayout(new BorderLayout());

        // Panel superior
        JPanel panelTop = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelTop.setBackground(new Color(0x283652));

        // Botón Por Leer / Leído
        btnMarcarLeido = new JButton("Por Leer");
        btnMarcarLeido.setFont(new Font("Arial", Font.PLAIN, 14));
        btnMarcarLeido.setForeground(Color.BLACK);
        btnMarcarLeido.setBackground(new Color(0x445E91));
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

        // Botón Regresar
        JButton btnRegresar = new JButton("Regresar");
        btnRegresar.setForeground(Color.BLACK);
        btnRegresar.setFont(new Font("Arial", Font.PLAIN, 14));
        btnRegresar.setBackground(new Color(68, 94, 145));
        btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelPrincipal, "inicio");
            }
        });
        panelTop.add(btnRegresar);

        add(panelTop, BorderLayout.NORTH);

        // Panel central
        JPanel panelCenter = new JPanel();
        panelCenter.setBackground(new Color(0x283652));
        panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.Y_AXIS));

        // Etiqueta para mostrar el libro seleccionado
        lblLibroSeleccionado = new JLabel(tituloLibro);
        lblLibroSeleccionado.setFont(new Font("Arial", Font.BOLD, 18));
        lblLibroSeleccionado.setForeground(Color.WHITE);
        lblLibroSeleccionado.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelCenter.add(lblLibroSeleccionado);

        // Etiqueta para la portada del libro
        lblPortada = new JLabel(portada);
        lblPortada.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelCenter.add(lblPortada);

        // Panel para la sección de reseña
        panelResena = new JPanel(new BorderLayout());
        panelResena.setBackground(new Color(0x283652)); // Color de fondo #283652
        panelResena.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Etiqueta para la sección de reseña
        JLabel lblResena = new JLabel("Reseña:");
        lblResena.setFont(new Font("Arial", Font.PLAIN, 14));
        lblResena.setForeground(Color.WHITE);
        panelResena.add(lblResena, BorderLayout.NORTH);

        // Área de texto para la reseña
        textAreaResena = new JTextArea(descripcionLibro);
        textAreaResena.setLineWrap(true);
        textAreaResena.setWrapStyleWord(true);
        textAreaResena.setEditable(false);
        JScrollPane scrollPaneResena = new JScrollPane(textAreaResena);
        panelResena.add(scrollPaneResena, BorderLayout.CENTER);

        panelCenter.add(panelResena);

        // Panel para la sección de calificación
        panelCalificacion = new JPanel();
        panelCalificacion.setBackground(new Color(0x283652)); // Color de fondo #283652
        panelCalificacion.setBorder(new EmptyBorder(10, 10, 10, 10));
        panelCalificacion.setLayout(new FlowLayout());

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
                    BookData.getInstance().setCalificacion(tituloLibro, calificacion);
                    updateRatingButtons();
                }
            });
            panelCalificacion.add(btnCalificar[i]);
        }

        panelCenter.add(panelCalificacion);

        // Panel para la sección de comentarios
        JPanel panelComentarios = new JPanel();
        panelComentarios.setBackground(new Color(0x283652)); // Color de fondo #283652
        panelComentarios.setBorder(new EmptyBorder(10, 10, 10, 10));
        panelComentarios.setLayout(new BorderLayout());

        // Área de texto para nuevos comentarios
        textAreaComentario = new JTextArea(3, 20);
        textAreaComentario.setLineWrap(true);
        textAreaComentario.setWrapStyleWord(true);
        textAreaComentario.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        JScrollPane scrollPaneComentario = new JScrollPane(textAreaComentario);
        panelComentarios.add(scrollPaneComentario, BorderLayout.NORTH);

        // Botón para publicar comentarios
        btnPublicarComentario = new JButton("Publicar Comentario");
        btnPublicarComentario.setFont(new Font("Arial", Font.PLAIN, 14));
        btnPublicarComentario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String comentario = textAreaComentario.getText().trim();
                if (!comentario.isEmpty()) {
                    BookData.getInstance().addComentario(tituloLibro, comentario);
                    textAreaComentario.setText("");
                    actualizarComentarios();
                }
            }
        });
        panelComentarios.add(btnPublicarComentario, BorderLayout.CENTER);

        // Área de texto para comentarios publicados
        textAreaComentariosPublicados = new JTextArea(10, 20);
        textAreaComentariosPublicados.setLineWrap(true);
        textAreaComentariosPublicados.setWrapStyleWord(true);
        textAreaComentariosPublicados.setEditable(false);
        textAreaComentariosPublicados.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        JScrollPane scrollPaneComentariosPublicados = new JScrollPane(textAreaComentariosPublicados);
        panelComentarios.add(scrollPaneComentariosPublicados, BorderLayout.SOUTH);

        panelCenter.add(panelComentarios);

        add(panelCenter, BorderLayout.CENTER);

        // Inicializar botones de calificación y comentarios
        cargarDatos();
        updateRatingButtons();
        actualizarComentarios();
    }

    // Método para cargar datos
    private void cargarDatos() {
        comentarios = BookData.getInstance().getComentarios(tituloLibro);
        calificacion = BookData.getInstance().getCalificacion(tituloLibro);
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

    // Método para actualizar los comentarios publicados
    private void actualizarComentarios() {
        StringBuilder comentariosTexto = new StringBuilder();
        for (String comentario : comentarios) {
            comentariosTexto.append(comentario).append("\n");
        }
        textAreaComentariosPublicados.setText(comentariosTexto.toString());
    }
}

