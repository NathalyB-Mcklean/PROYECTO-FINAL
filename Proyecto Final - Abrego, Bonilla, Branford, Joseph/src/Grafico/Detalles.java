package Grafico;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Logica.Libro;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Detalles extends JPanel {
    public JButton btnMarcarLeido;
    public JLabel lblLibroSeleccionado;
    public JTextArea textAreaResena;
    public JScrollPane scrollPaneResena;
    public JPanel panelCalificacion;
    public JButton[] btnCalificar;
    public JLabel lblPortada;
    public JTextArea textAreaComentario;
    public JButton btnPublicarComentario;
    public JTextArea textAreaComentariosPublicados;
    public JScrollPane scrollPaneComentariosPublicados;

    public boolean leido = false;
    public int calificacion;
    public ArrayList<String> comentarios;

    public CardLayout cardLayout;
    public JPanel panelPrincipal;

    public String tituloLibro;

    public Detalles(Libro libro, CardLayout cardLayout, JPanel panelPrincipal) {
        this.cardLayout = cardLayout;
        this.panelPrincipal = panelPrincipal;
        this.tituloLibro = libro.getTitulo();

        setBackground(new Color(0x283652)); // Color de fondo #283652
        setLayout(null); // Usar Absolute Layout

        // Botón Por Leer / Leído
        btnMarcarLeido = new JButton("Por Leer");
        btnMarcarLeido.setFont(new Font("Arial", Font.PLAIN, 14));
        btnMarcarLeido.setForeground(Color.BLACK);
        btnMarcarLeido.setBackground(new Color(0x445E91));
        btnMarcarLeido.setBounds(160, 15, 120, 30);
        btnMarcarLeido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
        add(btnMarcarLeido);

        // Botón Regresar
        JButton btnRegresar = new JButton("Regresar");
        btnRegresar.setForeground(Color.BLACK);
        btnRegresar.setFont(new Font("Arial", Font.PLAIN, 14));
        btnRegresar.setBackground(new Color(68, 94, 145));
        btnRegresar.setBounds(20, 15, 120, 30);
        btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelPrincipal, "inicio");
            }
        });
        add(btnRegresar);

        // Etiqueta para mostrar el libro seleccionado
        lblLibroSeleccionado = new JLabel(libro.getTitulo());
        lblLibroSeleccionado.setFont(new Font("Arial", Font.BOLD, 18));
        lblLibroSeleccionado.setForeground(Color.WHITE);
        lblLibroSeleccionado.setBounds(20, 60, 760, 30);
        add(lblLibroSeleccionado);

        // Redimensionar la imagen de la portada
        ImageIcon portadaIcon = libro.getPortadaIcon();
        Image portadaImage = portadaIcon.getImage().getScaledInstance(200, 250, Image.SCALE_SMOOTH);
        lblPortada = new JLabel(new ImageIcon(portadaImage));
        lblPortada.setBounds(20, 100, 171, 220);
        add(lblPortada);

        // Panel para la sección de reseña
        JLabel lblResena = new JLabel("Reseña:");
        lblResena.setFont(new Font("Arial", Font.PLAIN, 14));
        lblResena.setForeground(Color.WHITE);
        lblResena.setBounds(240, 100, 520, 20);
        add(lblResena);

        textAreaResena = new JTextArea(libro.getDescripcion());
        textAreaResena.setLineWrap(true);
        textAreaResena.setWrapStyleWord(true);
        textAreaResena.setEditable(false);
        scrollPaneResena = new JScrollPane(textAreaResena);
        scrollPaneResena.setBounds(240, 120, 520, 200);
        add(scrollPaneResena);

        // Panel para la sección de calificación
        panelCalificacion = new JPanel();
        panelCalificacion.setBackground(new Color(0x283652)); // Color de fondo #283652
        panelCalificacion.setBorder(new EmptyBorder(10, 10, 10, 10));
        panelCalificacion.setBounds(240, 330, 520, 80);
        panelCalificacion.setLayout(new FlowLayout());

        // Etiqueta "Calificación"
        JLabel lblCalificacion = new JLabel("Calificación:");
        lblCalificacion.setFont(new Font("Arial", Font.PLAIN, 14));
        lblCalificacion.setForeground(Color.WHITE);
        panelCalificacion.add(lblCalificacion);

        // Botones para calificar por estrellas
        btnCalificar = new JButton[5];
        for (int i = 0; i < btnCalificar.length; i++) {
            btnCalificar[i] = new JButton("");
            btnCalificar[i].setFont(new Font("Arial", Font.BOLD, 20));
            btnCalificar[i].setForeground(Color.BLACK);
            btnCalificar[i].setBackground(new Color(0xCCCCCC)); // Color inicial
            btnCalificar[i].setPreferredSize(new Dimension(40, 40));
            final int index = i;
            btnCalificar[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    calificacion = index + 1;
                    BookData.getInstance().setCalificacion(tituloLibro, calificacion); // Actualiza con tu método para guardar la calificación
                    updateRatingButtons();
                }
            });
            panelCalificacion.add(btnCalificar[i]);
        }

        add(panelCalificacion);

        // Panel para la sección de comentarios
        JLabel lblComentarios = new JLabel("Comentarios:");
        lblComentarios.setFont(new Font("Arial", Font.PLAIN, 14));
        lblComentarios.setForeground(Color.WHITE);
        lblComentarios.setBounds(20, 410, 760, 20);
        add(lblComentarios);

        textAreaComentario = new JTextArea(3, 20);
        textAreaComentario.setLineWrap(true);
        textAreaComentario.setWrapStyleWord(true);
        textAreaComentario.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        JScrollPane scrollPaneComentario = new JScrollPane(textAreaComentario);
        scrollPaneComentario.setBounds(20, 430, 520, 50);
        add(scrollPaneComentario);

        // Botón para publicar comentarios
        btnPublicarComentario = new JButton("Publicar");
        btnPublicarComentario.setFont(new Font("Arial", Font.PLAIN, 14));
        btnPublicarComentario.setBounds(550, 430, 100, 50);
        btnPublicarComentario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String comentario = textAreaComentario.getText().trim();
                if (!comentario.isEmpty()) {
                    BookData.getInstance().addComentario(tituloLibro, comentario); // Actualiza con tu método para guardar comentarios
                    textAreaComentario.setText("");
                    actualizarComentarios();
                }
            }
        });
        add(btnPublicarComentario);

        textAreaComentariosPublicados = new JTextArea();
        textAreaComentariosPublicados.setLineWrap(true);
        textAreaComentariosPublicados.setWrapStyleWord(true);
        textAreaComentariosPublicados.setEditable(false);
        textAreaComentariosPublicados.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        scrollPaneComentariosPublicados = new JScrollPane(textAreaComentariosPublicados);
        scrollPaneComentariosPublicados.setBounds(20, 490, 760, 100);
        add(scrollPaneComentariosPublicados);

        // Inicializar botones de calificación y comentarios
        cargarDatos();
        updateRatingButtons();
        actualizarComentarios();
    }

    // Método para cargar datos
    public void cargarDatos() {
        comentarios = BookData.getInstance().getComentarios(tituloLibro); // Actualiza con tu método para obtener comentarios
        calificacion = BookData.getInstance().getCalificacion(tituloLibro); // Actualiza con tu método para obtener calificación
    }

    // Método para actualizar los botones de calificación
    public void updateRatingButtons() {
        for (int i = 0; i < btnCalificar.length; i++) {
            if (i < calificacion) {
                btnCalificar[i].setBackground(new Color(0xFFFF00)); // Color amarillo para estrellas seleccionadas
            } else {
                btnCalificar[i].setBackground(new Color(0xCCCCCC)); // Color gris para estrellas no seleccionadas
            }
        }
    }

    // Método para actualizar los comentarios publicados
    public void actualizarComentarios() {
        ArrayList<String> comentarios = BookData.getInstance().getComentarios(tituloLibro);
        StringBuilder comentariosTexto = new StringBuilder();
        for (String comentario : comentarios) {
            comentariosTexto.append(comentario).append("\n");
        }
        textAreaComentariosPublicados.setText(comentariosTexto.toString());
    }
}
