package Grafico;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Detalles extends JPanel {
    private JButton btnMarcarLeido;
    private JLabel lblLibroSeleccionado;
    private JTextArea textAreaResena;
    private JPanel panelResena;
    private JPanel panelCalificacion;
    private JButton[] btnCalificar;
    private JLabel lblPortada;

    private boolean leido = false;
    private int calificacion = 0;

    private CardLayout cardLayout;
    private JPanel panelPrincipal;

    public Detalles(String tituloLibro, String descripcionLibro, ImageIcon portada, CardLayout cardLayout, JPanel panelPrincipal) {
        this.cardLayout = cardLayout;
        this.panelPrincipal = panelPrincipal;

        setBackground(new Color(0x283652)); // Color de fondo #283652
        setLayout(new BorderLayout());

        JPanel panelTop = new JPanel(null);
        panelTop.setPreferredSize(new Dimension(800, 60));
        panelTop.setBackground(new Color(0x283652));

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
                    btnMar

