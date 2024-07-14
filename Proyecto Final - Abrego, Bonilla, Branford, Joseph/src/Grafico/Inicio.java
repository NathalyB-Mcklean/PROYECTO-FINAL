package Grafico;

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

    public Inicio(CardLayout cardLayout, JPanel panelPrincipal) {
        setBackground(new Color(240, 240, 240)); // Color de fondo

        // Diseño de la página con BorderLayout
        setLayout(new BorderLayout());

        // Panel superior con botones y barra de búsqueda
        JPanel panelSuperior = new JPanel();
        panelSuperior.setBackground(new Color(40, 54, 82)); // Color #283652
        add(panelSuperior, BorderLayout.NORTH);

        // Botón Cerrar Sesión
        btnCerrarSesion = new JButton("Cerrar Sesión");
        btnCerrarSesion.setFont(new Font("Arial", Font.PLAIN, 14));
        btnCerrarSesion.setForeground(new Color(0, 0, 0));
        btnCerrarSesion.setBackground(new Color(0xFF6347)); // Color naranja
        btnCerrarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para cerrar sesión
                cardLayout.show(panelPrincipal, "IniciarSesion");
            }
        });
        panelSuperior.add(btnCerrarSesion);

        // Botón Leídos
        btnLeidos = new JButton("Leídos");
        btnLeidos.setFont(new Font("Arial", Font.PLAIN, 14));
        btnLeidos.setForeground(new Color(0, 0, 0));
        btnLeidos.setBackground(new Color(0x32CD32)); // Color verde
        // Agregar lógica para manejar los libros leídos
        panelSuperior.add(btnLeidos);

        // Barra de búsqueda y botón Buscar
        JPanel panelBusqueda = new JPanel(new BorderLayout());
        panelSuperior.add(panelBusqueda);

        textFieldBusqueda = new JTextField();
        textFieldBusqueda.setPreferredSize(new Dimension(400, 30));
        panelBusqueda.add(textFieldBusqueda, BorderLayout.WEST);

        btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para buscar libros según el texto ingresado en textFieldBusqueda
                buscarLibros(textFieldBusqueda.getText());
            }
        });
        panelBusqueda.add(btnBuscar, BorderLayout.EAST);

        // Combo Box Categorías y botón Filtrar
        JPanel panelFiltrar = new JPanel();
        panelFiltrar.setLayout(new BoxLayout(panelFiltrar, BoxLayout.X_AXIS));
        panelSuperior.add(panelFiltrar);

        String[] categorias = {"Todos", "Ficción", "No ficción", "Literatura infantil", "Ciencia ficción", "Romance"};
        comboBoxCategorias = new JComboBox<>(categorias);
        panelFiltrar.add(comboBoxCategorias);

        btnFiltrar = new JButton("Filtrar");
        btnFiltrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para filtrar libros por categoría seleccionada en comboBoxCategorias
                String categoriaSeleccionada = (String) comboBoxCategorias.getSelectedItem();
                filtrarLibros(categoriaSeleccionada);
            }
        });
        panelFiltrar.add(btnFiltrar);

        // Panel central con recomendaciones
        JPanel panelCentral = new JPanel(new BorderLayout());
        add(panelCentral, BorderLayout.CENTER);

        panelRecomendaciones = new JPanel();
        panelRecomendaciones.setLayout(new BoxLayout(panelRecomendaciones, BoxLayout.Y_AXIS));
        JScrollPane scrollRecomendaciones = new JScrollPane(panelRecomendaciones);
        panelCentral.add(scrollRecomendaciones, BorderLayout.CENTER);

        // Simulación de recomendaciones iniciales
        cargarRecomendacionesIniciales();
    }

    // Método para simular la búsqueda de libros
    private void buscarLibros(String textoBusqueda) {
        // Simulación de búsqueda de libros
        JOptionPane.showMessageDialog(this, "Simulación de búsqueda: " + textoBusqueda, "Búsqueda", JOptionPane.INFORMATION_MESSAGE);
    }

    // Método para simular el filtrado de libros por categoría
    private void filtrarLibros(String categoria) {
        // Simulación de filtrado de libros por categoría
        JOptionPane.showMessageDialog(this, "Simulación de filtrado por categoría: " + categoria, "Filtrar", JOptionPane.INFORMATION_MESSAGE);
    }

    // Método para simular la carga inicial de recomendaciones
    private void cargarRecomendacionesIniciales() {
        // Simulación de recomendaciones iniciales
        for (int i = 1; i <= 10; i++) {
            JPanel panelLibro = new JPanel(new BorderLayout());
            panelLibro.setBorder(new EmptyBorder(10, 10, 10, 10));
            JLabel lblTitulo = new JLabel("Libro " + i);
            panelLibro.add(lblTitulo, BorderLayout.NORTH);
            JTextArea areaTexto = new JTextArea("Descripción del libro " + i);
            areaTexto.setWrapStyleWord(true);
            areaTexto.setLineWrap(true);
            areaTexto.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(areaTexto);
            panelLibro.add(scrollPane, BorderLayout.CENTER);
            JButton btnDetalles = new JButton("Ver detalles");

            // Variable final para acceder a i dentro del ActionListener
            final int libroIndex = i;

            btnDetalles.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Lógica para mostrar detalles del libro (simulado)
                    JOptionPane.showMessageDialog(panelLibro, "Simulación de detalles del libro " + libroIndex, "Detalles", JOptionPane.INFORMATION_MESSAGE);
                }
            });
            panelLibro.add(btnDetalles, BorderLayout.SOUTH);
            panelRecomendaciones.add(panelLibro);
        }
        panelRecomendaciones.revalidate();
        panelRecomendaciones.repaint();
    }

    public static void main(String[] args) {
        // Ejemplo básico para probar la página de inicio
        JFrame frame = new JFrame("Página de Inicio");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Simulación de usuario logueado
        CardLayout cardLayout = new CardLayout();
        JPanel panelPrincipal = new JPanel(cardLayout);

        // Mostrar el panel de inicio
        cardLayout.addLayoutComponent(new Inicio(cardLayout, panelPrincipal), "Inicio");
        cardLayout.show(panelPrincipal, "Inicio");

        frame.getContentPane().add(panelPrincipal);
        frame.setVisible(true);
    }
}
