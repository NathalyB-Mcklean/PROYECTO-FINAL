package Grafico;

import Logica.Libro;
import Logica.Recomendaciones;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inicio extends JPanel {

    public JButton btnPerfil;
    public JTextField textFieldBusqueda;
    public JButton btnBuscar;
    public JComboBox<String> comboBoxCategorias;
    public JButton btnFiltrar;
    public JPanel panelRecomendaciones;
    public CardLayout cardLayout;
    public JPanel panelPrincipal;

    public Inicio(CardLayout cardLayout, JPanel panelPrincipal) {
        this.cardLayout = cardLayout;
        this.panelPrincipal = panelPrincipal;

        setBackground(new Color(40, 54, 82)); // Color #283652
        setLayout(null); // Usar absolute layout

        // Inicializar componentes y cargar recomendaciones iniciales
        inicializarComponentes();
        cargarRecomendaciones(Recomendaciones.obtenerLibros());
    }

    public void inicializarComponentes() {
        // Botón Perfil
        btnPerfil = new JButton("Perfil");
        btnPerfil.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
        btnPerfil.setForeground(new Color(0, 0, 0));
        btnPerfil.setBackground(new Color(0x445E91));
        btnPerfil.setBounds(647, 17, 133, 30);
        btnPerfil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelPrincipal, "Perfil");
            }
        });

        add(btnPerfil);

        // Barra de búsqueda y botón Buscar
        textFieldBusqueda = new JTextField();
        textFieldBusqueda.setPreferredSize(new Dimension(400, 30));
        textFieldBusqueda.setBounds(20, 17, 400, 30);
        add(textFieldBusqueda);

        btnBuscar = new JButton("Buscar");
        btnBuscar.setFont(new Font("Yu Gothic", Font.PLAIN, 11));
        btnBuscar.setBounds(427, 17, 80, 30);
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para buscar libros según el texto ingresado en textFieldBusqueda
                buscarLibros(textFieldBusqueda.getText());
            }
        });
        add(btnBuscar);

        // Combo Box Categorías y botón Filtrar
        comboBoxCategorias = new JComboBox<>(new String[]{"Todos", "Ficción", "No ficción", "Literatura infantil", "Ciencia ficción", "Romance"});
        comboBoxCategorias.setModel(new DefaultComboBoxModel(new String[] {"Todos", "Ficción", "Clásicos", "Romance", "Novela Gótica", "Terror psicológico", "Historia"}));
        comboBoxCategorias.setFont(new Font("Yu Gothic", Font.PLAIN, 11));
        comboBoxCategorias.setBounds(20, 70, 150, 30);
        add(comboBoxCategorias);

        btnFiltrar = new JButton("Filtrar");
        btnFiltrar.setFont(new Font("Yu Gothic", Font.PLAIN, 11));
        btnFiltrar.setBounds(180, 70, 80, 30);
        btnFiltrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para filtrar libros por categoría seleccionada en comboBoxCategorias
                String categoriaSeleccionada = (String) comboBoxCategorias.getSelectedItem();
                filtrarLibros(categoriaSeleccionada);
            }
        });
        add(btnFiltrar);

        // Panel central con recomendaciones
        panelRecomendaciones = new JPanel();
        panelRecomendaciones.setLayout(new BoxLayout(panelRecomendaciones, BoxLayout.Y_AXIS));
        JScrollPane scrollRecomendaciones = new JScrollPane(panelRecomendaciones);
        scrollRecomendaciones.setBounds(20, 120, 760, 420);
        add(scrollRecomendaciones);
    }

    // Método para cargar recomendaciones de libros
    public void cargarRecomendaciones(Libro[] libros) {
        panelRecomendaciones.removeAll();
        if (libros.length == 0) {
            JLabel lblNoResultados = new JLabel("No se encontraron libros.");
            lblNoResultados.setForeground(Color.BLACK);
            lblNoResultados.setFont(new Font("Yu Gothic", Font.PLAIN, 18));
            lblNoResultados.setHorizontalAlignment(SwingConstants.CENTER);
            panelRecomendaciones.add(lblNoResultados);
        } else {
            for (Libro libro : libros) {
                JPanel panelLibro = new JPanel(new BorderLayout());
                panelLibro.setBorder(new EmptyBorder(10, 10, 10, 10));
                JLabel lblTitulo = new JLabel(libro.getTitulo());
                panelLibro.add(lblTitulo, BorderLayout.NORTH);
                JTextArea areaTexto = new JTextArea(libro.getDescripcion());
                areaTexto.setWrapStyleWord(true);
                areaTexto.setLineWrap(true);
                areaTexto.setEditable(false);
                JScrollPane scrollPane = new JScrollPane(areaTexto);
                panelLibro.add(scrollPane, BorderLayout.CENTER);
                JButton btnDetalles = new JButton("Ver detalles");

                // Acción para ver detalles del libro
                btnDetalles.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Detalles detallesPanel = new Detalles(libro, cardLayout, panelPrincipal);
                        panelPrincipal.add(detallesPanel, "Detalles");

                        cardLayout.show(panelPrincipal, "Detalles");
                    }
                });
                panelLibro.add(btnDetalles, BorderLayout.SOUTH);
                panelRecomendaciones.add(panelLibro);
            }
        }
        panelRecomendaciones.revalidate();
        panelRecomendaciones.repaint();
    }

    public void filtrarLibros(String categoriaSeleccionada) {
        Libro[] librosFiltrados = Recomendaciones.filtrarPorCategoria(Recomendaciones.obtenerLibros(), categoriaSeleccionada);
        cargarRecomendaciones(librosFiltrados);
    }

    public void buscarLibros(String textoBusqueda) {
        Libro[] librosEncontrados = Recomendaciones.buscarPorTexto(Recomendaciones.obtenerLibros(), textoBusqueda);
        cargarRecomendaciones(librosEncontrados);
    }

    public static void main(String[] args) {
        // Ejemplo de uso del JPanel Inicio
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame();
                frame.setSize(800, 600);
                frame.getContentPane().setLayout(new BorderLayout());

                JPanel panelPrincipal = new JPanel(new CardLayout());
                panelPrincipal.add(new Inicio((CardLayout) panelPrincipal.getLayout(), panelPrincipal), "Inicio");

                frame.getContentPane().add(panelPrincipal, BorderLayout.CENTER);
                frame.setVisible(true);
            }
        });
    }
}
