package Grafico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registro extends JPanel {

    private JTextField textFieldNombre;
    private JTextField textFieldCorreo;
    private JPasswordField passwordField;

    private CardLayout cardLayout;
    private JPanel panelPrincipal;

    public Registro(CardLayout cardLayout, JPanel panelPrincipal) {
        super();
        this.cardLayout = cardLayout;
        this.panelPrincipal = panelPrincipal;
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        setLayout(null); // Establecer AbsoluteLayout

        // Etiquetas y campos de texto
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
        lblNombre.setBounds(50, 50, 100, 30);
        add(lblNombre);

        textFieldNombre = new JTextField();
        textFieldNombre.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
        textFieldNombre.setBounds(160, 50, 200, 30);
        add(textFieldNombre);

        JLabel lblCorreo = new JLabel("Correo:");
        lblCorreo.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
        lblCorreo.setBounds(50, 100, 100, 30);
        add(lblCorreo);

        textFieldCorreo = new JTextField();
        textFieldCorreo.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
        textFieldCorreo.setBounds(160, 100, 200, 30);
        add(textFieldCorreo);

        JLabel lblContraseña = new JLabel("Contraseña:");
        lblContraseña.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
        lblContraseña.setBounds(50, 150, 100, 30);
        add(lblContraseña);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
        passwordField.setBounds(160, 150, 200, 30);
        add(passwordField);

        // Botón Registrarse
        JButton btnRegistrarse = new JButton("Registrarse");
        btnRegistrarse.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
        btnRegistrarse.setBounds(160, 200, 120, 30);
        btnRegistrarse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarUsuario();
            }
        });
        add(btnRegistrarse);

        // Botón Iniciar Sesión
        JButton btnIniciarSesion = new JButton("Iniciar Sesión");
        btnIniciarSesion.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
        btnIniciarSesion.setBounds(300, 200, 120, 30);
        btnIniciarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirPaginaInicioSesion();
            }
        });
        add(btnIniciarSesion);
    }

    private void registrarUsuario() {
        String nombre = textFieldNombre.getText().trim();
        String correo = textFieldCorreo.getText().trim();
        String contraseña = new String(passwordField.getPassword());

        if (nombre.isEmpty() || correo.isEmpty() || contraseña.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (contraseña.length() < 5) {
            JOptionPane.showMessageDialog(this, "La contraseña debe tener al menos 5 caracteres", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Simulando registro exitoso
        JOptionPane.showMessageDialog(this, "Usuario registrado exitosamente", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);

        // Cambiar al panel de inicio de sesión
        cardLayout.show(panelPrincipal, "Login");
    }

    private void abrirPaginaInicioSesion() {
        cardLayout.show(panelPrincipal, "Login"); // Cambiar al panel de inicio de sesión
    }
}
