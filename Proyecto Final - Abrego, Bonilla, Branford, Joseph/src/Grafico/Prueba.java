package Grafico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Prueba {
    private JFrame frame;
    private JPanel panelContenedor;
    private CardLayout cardLayout;

    public Prueba() {
        frame = new JFrame("Registro e Inicio de Sesión");
        panelContenedor = new JPanel();
        cardLayout = new CardLayout();

        panelContenedor.setLayout(cardLayout);

        JPanel panelRegistro = crearPanelRegistro();
        JPanel panelInicioSesion = crearPanelInicioSesion();

        panelContenedor.add(panelRegistro, "Registro");
        panelContenedor.add(panelInicioSesion, "InicioSesion");

        cardLayout.show(panelContenedor, "Registro");

        frame.add(panelContenedor);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }

    private JPanel crearPanelRegistro() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        JLabel labelNombre = new JLabel("Nombre:");
        JTextField textNombre = new JTextField();

        JLabel labelCorreo = new JLabel("Correo:");
        JTextField textCorreo = new JTextField();

        JLabel labelContrasena = new JLabel("Contraseña:");
        JPasswordField textContrasena = new JPasswordField();

        JButton btnRegistrarse = new JButton("Registrarse");
        JButton btnIniciarSesion = new JButton("Iniciar Sesión");

        btnRegistrarse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí agregamos la lógica de registro
                // Si el registro es exitoso, mostramos la pantalla de inicio de sesión
                cardLayout.show(panelContenedor, "InicioSesion");
            }
        });

        btnIniciarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelContenedor, "InicioSesion");
            }
        });

        panel.add(labelNombre);
        panel.add(textNombre);
        panel.add(labelCorreo);
        panel.add(textCorreo);
        panel.add(labelContrasena);
        panel.add(textContrasena);
        panel.add(btnRegistrarse);
        panel.add(btnIniciarSesion);

        return panel;
    }

    private JPanel crearPanelInicioSesion() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel labelCorreo = new JLabel("Correo:");
        JTextField textCorreo = new JTextField();

        JLabel labelContrasena = new JLabel("Contraseña:");
        JPasswordField textContrasena = new JPasswordField();

        JButton btnIniciarSesion = new JButton("Iniciar Sesión");

        btnIniciarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí agregamos la lógica de inicio de sesión
            }
        });

        panel.add(labelCorreo);
        panel.add(textCorreo);
        panel.add(labelContrasena);
        panel.add(textContrasena);
        panel.add(new JLabel()); // Espacio vacío
        panel.add(btnIniciarSesion);

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Prueba();
            }
        });
    }
}
