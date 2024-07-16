package Grafico;

import Logica.Libro;

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

        // Botón Cerrar Sesión
        btnCerrarSesion = new JButton("Cerrar Sesión");
        btnCerrarSesion.setFont(new Font("Arial", Font.PLAIN, 14));
        btnCerrarSesion.setForeground(new Color(0, 0, 0));
        btnCerrarSesion.setBackground(new Color(0xFF6347)); // Color naranja
        btnCerrarSesion.setBounds(20, 20, 120, 30);
        btnCerrarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para cerrar sesión
                cardLayout.show(panelPrincipal, "iniciarSesion"); // Volver a la pantalla de inicio de sesión
            }
        });
        add(btnCerrarSesion);

        // Botón Leídos
        btnLeidos = new JButton("Leídos");
        btnLeidos.setFont(new Font("Arial", Font.PLAIN, 14));
        btnLeidos.setForeground(new Color(0, 0, 0));
        btnLeidos.setBackground(new Color(0x32CD32)); // Color verde
        btnLeidos.setBounds(160, 20, 120, 30);
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
        textFieldBusqueda.setBounds(300, 20, 400, 30);
        add(textFieldBusqueda);

        btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(710, 20, 80, 30);
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
        comboBoxCategorias.setBounds(20, 70, 150, 30);
        add(comboBoxCategorias);

        btnFiltrar = new JButton("Filtrar");
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

        // Cargar recomendaciones iniciales desde Libro.obtenerLibros()
        cargarRecomendaciones(Libro.obtenerLibros());
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

    // Método para mostrar libros marcados como leídos
    private void mostrarLibrosLeidos() {
        // Lógica para obtener libros marcados como leídos
        // Supongamos que tenemos una forma de marcar libros como leídos en la clase Libro
        // Por ahora, utilizaremos una simulación
        Libro[] librosLeidos = filtrarLibrosPorEstado(true); // Obtener libros marcados como leídos
        cargarRecomendaciones(librosLeidos);
    }

    // Método para filtrar libros por categoría
    private void filtrarLibros(String categoriaSeleccionada) {
        Libro[] librosFiltrados;
        if (categoriaSeleccionada.equals("Todos")) {
            librosFiltrados = Libro.obtenerLibros();
        } else {
            // Lógica para filtrar libros por categoría
            librosFiltrados = filtrarPorCategoria(Libro.obtenerLibros(), categoriaSeleccionada);
        }
        cargarRecomendaciones(librosFiltrados);
    }

    // Método para filtrar libros por categoría específica
    private Libro[] filtrarPorCategoria(Libro[] libros, String categoria) {
        // Implementa la lógica para filtrar libros por la categoría especificada
        // Este es un ejemplo simulado
        // Supongamos que cada libro tiene una categoría asignada
        // Aquí implementarías la lógica real según tus necesidades
        return libros;
    }

    // Método para buscar libros por texto ingresado
    private void buscarLibros(String textoBusqueda) {
        // Lógica para buscar libros según el texto ingresado
        // Este es un ejemplo simulado
        // Supongamos que queremos buscar por título o descripción
        Libro[] librosEncontrados = buscarPorTexto(Libro.obtenerLibros(), textoBusqueda);
        cargarRecomendaciones(librosEncontrados);
    }

    // Método para buscar libros por texto en título o descripción
    private Libro[] buscarPorTexto(Libro[] libros, String textoBusqueda) {
        // Implementa la lógica para buscar libros por el texto ingresado
        // Este es un ejemplo simulado
        // Supongamos que queremos buscar por título o descripción
        // Aquí implementarías la lógica real según tus necesidades
        return libros;
    }
}
