package Grafico;

import javax.swing.*;
import java.awt.*;

public class Perfil extends JPanel {
    private JLabel lblNombreUsuario;
    private JPanel panelInicio, panelAmigos, panelUltimosVistos, panelLeidos;
    private JList<String> listaLibros, listaAmigos;
    private JButton btnAgregarAmigo;
    private JButton btnRegresar, btnAmigos, btnUltimosVistos, btnLeidos;
    private String[] librosLeidos = {"El Alquimista", "Cien años de soledad", "1984", "Harry Potter y la piedra filosofal", "La sombra del viento"};
    private String[] amigos = {"Amigo 1", "Amigo 2", "Amigo 3", "Amigo 4"};
    private JPanel panelDerecho; // Panel para mostrar el contenido dinámico

    public Perfil(String nombreUsuario, CardLayout cardLayout, JPanel panelPrincipal) {
        setLayout(null); // Usar Absolute Layout
        setBackground(new Color(44, 62, 80)); // Fondo general

        // Etiqueta de bienvenida
        lblNombreUsuario = new JLabel("Bienvenido, " + nombreUsuario);
        lblNombreUsuario.setForeground(Color.WHITE);
        lblNombreUsuario.setFont(new Font("Arial", Font.BOLD, 20));
        lblNombreUsuario.setBounds(20, 20, 300, 30);
        add(lblNombreUsuario);

        // Panel izquierdo con opciones
        JPanel panelIzquierdo = new JPanel();
        panelIzquierdo.setLayout(new GridLayout(4, 1, 10, 10));
        panelIzquierdo.setBackground(new Color(52, 73, 94)); // Color de fondo #34495e
        panelIzquierdo.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        panelIzquierdo.setBounds(20, 110, 150, 300); // Establecer los límites del panel izquierdo

        btnAmigos = new JButton("Amigos");
        btnAmigos.addActionListener(e -> mostrarPanel(panelAmigos));
        panelIzquierdo.add(btnAmigos);

        btnUltimosVistos = new JButton("Últimos Vistos");
        btnUltimosVistos.addActionListener(e -> mostrarPanel(panelUltimosVistos));
        panelIzquierdo.add(btnUltimosVistos);

        btnLeidos = new JButton("Leídos");
        btnLeidos.addActionListener(e -> mostrarPanel(panelLeidos));
        panelIzquierdo.add(btnLeidos);

        add(panelIzquierdo);

        // Panel de contenido dinámico
        panelDerecho = new JPanel();
        panelDerecho.setBounds(200, 50, 750, 400);
        panelDerecho.setLayout(new CardLayout());
        panelDerecho.setBackground(Color.WHITE);
        add(panelDerecho);

        // Crear el panel de inicio
        panelInicio = crearPanelInicio();
        panelDerecho.add(panelInicio, "Inicio");

        // Crear los paneles dinámicos
        panelAmigos = crearPanelAmigos();
        panelDerecho.add(panelAmigos, "Amigos");

        panelUltimosVistos = crearPanelUltimosVistos();
        panelDerecho.add(panelUltimosVistos, "UltimosVistos");

        panelLeidos = crearPanelLeidos();
        panelDerecho.add(panelLeidos, "Leidos");

        // Botón de Regresar en la esquina superior derecha
        btnRegresar = new JButton("Regresar");
        btnRegresar.setBounds(880, 10, 100, 30); // Colocar el botón en la esquina superior derecha
        btnRegresar.addActionListener(e -> cardLayout.show(panelPrincipal, "Inicio"));
        add(btnRegresar);

        // Mostrar el panel de inicio por defecto
        mostrarPanel(panelInicio);
    }

    // Método para crear el panel de Inicio
    private JPanel crearPanelInicio() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);

        JLabel lblInicio = new JLabel("Bienvenido a tu perfil");
        lblInicio.setFont(new Font("Arial", Font.BOLD, 18));
        lblInicio.setBounds(20, 20, 300, 30);
        panel.add(lblInicio);

        JTextArea textoInicio = new JTextArea("Bienvenido a tu perfil.\nAquí podrías mostrar información relevante para el usuario.");
        textoInicio.setFont(new Font("Arial", Font.PLAIN, 14));
        textoInicio.setBounds(20, 60, 700, 250);
        textoInicio.setLineWrap(true);
        textoInicio.setWrapStyleWord(true);
        textoInicio.setEditable(false);
        panel.add(textoInicio);

        return panel;
    }

    // Método para crear el panel de Amigos
    private JPanel crearPanelAmigos() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);

        JLabel lblAmigos = new JLabel("Lista de Amigos");
        lblAmigos.setFont(new Font("Arial", Font.BOLD, 18));
        lblAmigos.setBounds(20, 20, 300, 30);
        panel.add(lblAmigos);

        listaAmigos = new JList<>(amigos);
        JScrollPane scrollAmigos = new JScrollPane(listaAmigos);
        scrollAmigos.setBounds(20, 60, 700, 250);
        panel.add(scrollAmigos);

        btnAgregarAmigo = new JButton("Agregar Amigo");
        btnAgregarAmigo.setFont(new Font("Arial", Font.BOLD, 14));
        btnAgregarAmigo.setBounds(20, 320, 150, 30);
        panel.add(btnAgregarAmigo);

        return panel;
    }

    // Método para crear el panel de Últimos Vistos
    private JPanel crearPanelUltimosVistos() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);

        JLabel lblUltimosVistos = new JLabel("Últimos Vistos");
        lblUltimosVistos.setFont(new Font("Arial", Font.BOLD, 18));
        lblUltimosVistos.setBounds(20, 20, 300, 30);
        panel.add(lblUltimosVistos);

        listaLibros = new JList<>(librosLeidos);
        JScrollPane scrollLibros = new JScrollPane(listaLibros);
        scrollLibros.setBounds(20, 60, 700, 250);
        panel.add(scrollLibros);

        return panel;
    }

    // Método para crear el panel de Libros Leídos
    private JPanel crearPanelLeidos() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);

        JLabel lblLeidos = new JLabel("Libros Leídos");
        lblLeidos.setFont(new Font("Arial", Font.BOLD, 18));
        lblLeidos.setBounds(20, 20, 300, 30);
        panel.add(lblLeidos);

        JTextArea textoLeidos = new JTextArea("Aquí podrías mostrar la lista de libros que el usuario ha leído.\n\nEjemplo:\n- Libro 1\n- Libro 2\n- Libro 3");
        textoLeidos.setFont(new Font("Arial", Font.PLAIN, 14));
        textoLeidos.setBounds(20, 60, 700, 250);
        textoLeidos.setLineWrap(true);
        textoLeidos.setWrapStyleWord(true);
        textoLeidos.setEditable(false);
        panel.add(textoLeidos);

        return panel;
    }

    // Método para mostrar el panel seleccionado en el lado derecho del SplitPane
    private void mostrarPanel(JPanel panel) {
        CardLayout cl = (CardLayout) panelDerecho.getLayout();
        if (panel == panelInicio) {
            cl.show(panelDerecho, "Inicio");
        } else if (panel == panelAmigos) {
            cl.show(panelDerecho, "Amigos");
        } else if (panel == panelUltimosVistos) {
            cl.show(panelDerecho, "UltimosVistos");
        } else if (panel == panelLeidos) {
            cl.show(panelDerecho, "Leidos");
        }
    }
}
