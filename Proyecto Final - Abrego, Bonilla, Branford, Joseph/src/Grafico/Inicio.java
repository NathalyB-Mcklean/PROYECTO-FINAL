package Grafico;

import Logica.Libro;
import Logica.Recomendaciones;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Inicio extends JPanel {

    private JButton btnCerrarSesion;
    private JButton btnLeidos;
    private JTextField textFieldBusqueda;
    private JButton btnBuscar;
    private JComboBox<String> comboBoxCategorias;
    private JButton btnFiltrar;
    private JPanel panelRecomendaciones;
    private CardLayout cardLayout;
    private JPanel panelPrincipal;

    public Inicio(CardLayout cardLayout, JPanel panelPrincipal) {
        this.cardLayout = cardLayout;
        this.panelPrincipal = panelPrincipal;

        setBackground(new Color(40, 54, 82)); // Color #283652
        setLayout(null); // Usar absolute layout

        // Inicializar componentes y cargar recomendaciones iniciales
        inicializarComponentes();
        cargarRecomendaciones(Recomendaciones.obtenerLibros());
    }

    private void inicializarComponentes() {
        // Botón Cerrar Sesión
        btnCerrarSesion = new JButton("Cerrar Sesión");
        btnCerrarSesion.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
        btnCerrarSesion.setForeground(new Color(0, 0, 0));
        btnCerrarSesion.setBackground(new Color(0x445E91));
        btnCerrarSesion.setBounds(647, 17, 133, 30);
        btnCerrarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para cerrar sesión
                cardLayout.show(panelPrincipal, "IniciarSesion"); // Volver a la pantalla de inicio de sesión
            }
        });
        add(btnCerrarSesion);

        // Botón Leídos
        btnLeidos = new JButton("Leídos");
        btnLeidos.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
        btnLeidos.setForeground(new Color(0, 0, 0));
        btnLeidos.setBackground(Color.decode("#445E91"));
        btnLeidos.setBounds(517, 17, 120, 30);
        btnLeidos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para mostrar libros leídos
                mostrarLibrosLeidos();
            }
        });
        add(btnLeidos);

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
    private void cargarRecomendaciones(Libro[] libros) {
        panelRecomendaciones.removeAll();
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

            btnDetalles.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(panelLibro, "Simulación de detalles del libro: " + libro.getTitulo(), "Detalles", JOptionPane.INFORMATION_MESSAGE);
                }
            });
            panelLibro.add(btnDetalles, BorderLayout.SOUTH);
            panelRecomendaciones.add(panelLibro);
        }
        panelRecomendaciones.revalidate();
        panelRecomendaciones.repaint();
    }

    // Métodos refactorizados para utilizar Recomendaciones

    private void mostrarLibrosLeidos() {
        Libro[] librosLeidos = Recomendaciones.filtrarLibrosPorEstado(true); // Obtener libros marcados como leídos
        cargarRecomendaciones(librosLeidos);
    }

    private void filtrarLibros(String categoriaSeleccionada) {
        Libro[] librosFiltrados = Recomendaciones.filtrarPorCategoria(Recomendaciones.obtenerLibros(), categoriaSeleccionada);
        cargarRecomendaciones(librosFiltrados);
    }

    private void buscarLibros(String textoBusqueda) {
        Libro[] librosEncontrados = Recomendaciones.buscarPorTexto(Recomendaciones.obtenerLibros(), textoBusqueda);
        cargarRecomendaciones(librosEncontrados);
    }
}
