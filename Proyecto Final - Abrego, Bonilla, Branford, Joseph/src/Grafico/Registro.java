package Grafico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Logica.Usuario;

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
        setBackground(new Color(0x202A40)); // Fondo más claro

        // Etiquetas y campos de texto
        JLabel lblNombre = new JLabel("Usuario:");
        lblNombre.setForeground(new Color(255, 255, 255));
        lblNombre.setFont(new Font("Yu Gothic", Font.PLAIN, 16));
        lblNombre.setBounds(152, 256, 100, 30);
        add(lblNombre);

        textFieldNombre = new JTextField();
        textFieldNombre.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
        textFieldNombre.setBounds(275, 256, 346, 30);
        add(textFieldNombre);

        JLabel lblCorreo = new JLabel("Correo:");
        lblCorreo.setForeground(new Color(255, 255, 255));
        lblCorreo.setFont(new Font("Yu Gothic", Font.PLAIN, 16));
        lblCorreo.setBounds(152, 318, 100, 30);
        add(lblCorreo);

        textFieldCorreo = new JTextField();
        textFieldCorreo.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
        textFieldCorreo.setBounds(275, 318, 346, 30);
        add(textFieldCorreo);

        JLabel lblContraseña = new JLabel("Contraseña:");
        lblContraseña.setForeground(new Color(255, 255, 255));
        lblContraseña.setFont(new Font("Yu Gothic", Font.PLAIN, 16));
        lblContraseña.setBounds(152, 380, 100, 30);
        add(lblContraseña);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
        passwordField.setBounds(275, 380, 346, 30);
        add(passwordField);

        // Botón Registrarse
        JButton btnRegistrarse = new JButton("Registrarse");
        btnRegistrarse.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
        btnRegistrarse.setBounds(386, 435, 119, 30);
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
        btnIniciarSesion.setBounds(375, 501, 154, 30);
        btnIniciarSesion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelPrincipal, "IniciarSesion");
            }
        });
        add(btnIniciarSesion);

        JLabel lblRegistro = new JLabel("REGISTRO");
        lblRegistro.setForeground(new Color(255, 255, 255));
        lblRegistro.setFont(new Font("Yu Gothic", Font.PLAIN, 18));
        lblRegistro.setBounds(394, 203, 100, 30);
        add(lblRegistro);

        JLabel lblyaTienesUna = new JLabel("¿Ya tienes una cuenta?");
        lblyaTienesUna.setForeground(new Color(255, 255, 255));
        lblyaTienesUna.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
        lblyaTienesUna.setBounds(375, 476, 171, 30);
        add(lblyaTienesUna);
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

        Usuario nuevoUsuario = new Usuario(nombre, correo, contraseña);
        if (Usuario.agregarUsuario(nuevoUsuario)) {
            JOptionPane.showMessageDialog(this, "Usuario registrado exitosamente", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);
            cardLayout.show(panelPrincipal, "IniciarSesion");
        } else {
            JOptionPane.showMessageDialog(this, "El usuario ya existe o no hay espacio disponible", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
