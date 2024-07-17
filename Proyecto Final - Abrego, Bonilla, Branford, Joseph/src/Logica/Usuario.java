package Grafico;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import Logica.Usuario;

public class IniciarSesion extends JPanel {

    private JTextField textFieldUsuario;
    private JPasswordField passwordField;

    public IniciarSesion(CardLayout cardLayout, JPanel panelPrincipal) {
        setBackground(new Color(0x202A40)); // Fondo similar al de Registro
        setLayout(null);

        JLabel lblNewLabel = new JLabel("INICIO DE SESIÓN");
        lblNewLabel.setFont(new Font("Yu Gothic", Font.PLAIN, 20));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(339, 170, 208, 32);
        lblNewLabel.setForeground(Color.WHITE);
        add(lblNewLabel);

        textFieldUsuario = new JTextField();
        textFieldUsuario.setBounds(250, 256, 421, 26);
        add(textFieldUsuario);
        textFieldUsuario.setColumns(10);

        JLabel lblNombreDeUsuario = new JLabel("Usuario:");
        lblNombreDeUsuario.setHorizontalAlignment(SwingConstants.CENTER);
        lblNombreDeUsuario.setFont(new Font("Yu Gothic", Font.PLAIN, 20));
        lblNombreDeUsuario.setBounds(113, 255, 125, 32);
        lblNombreDeUsuario.setForeground(Color.WHITE);
        add(lblNombreDeUsuario);

        passwordField = new JPasswordField();
        passwordField.setBounds(250, 341, 421, 26);
        add(passwordField);

        JLabel lblContraseña = new JLabel("Contraseña:");
        lblContraseña.setHorizontalAlignment(SwingConstants.CENTER);
        lblContraseña.setFont(new Font("Yu Gothic", Font.PLAIN, 20));
        lblContraseña.setBounds(56, 340, 208, 32);
        lblContraseña.setForeground(Color.WHITE);
        add(lblContraseña);

        JButton btnIngresar = new JButton("Ingresar");
        btnIngresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String usuario = textFieldUsuario.getText().trim();
                String contraseña = new String(passwordField.getPassword());

                Usuario usuarioValidado = Usuario.validarCredenciales(usuario, contraseña);
                if (usuarioValidado != null) {
                    cardLayout.show(panelPrincipal, "inicio"); // Cambiar al panel "inicio" cuando las credenciales sean correctas
                } else {
                    JOptionPane.showMessageDialog(IniciarSesion.this, "Usuario o contraseña incorrectos", "Error de inicio de sesión", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnIngresar.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
        btnIngresar.setBounds(376, 407, 125, 30);
        add(btnIngresar);

       /* try {
            BufferedImage originalImage = ImageIO.read(new File("C:\\Users\\natha\\git\\PROYECTO-FINAL\\Proyecto Final - Abrego, Bonilla, Branford, Joseph\\Imágenes\\Bookstore (350 x 350 px) (2).png"));
            JLabel lblImagen = new JLabel(new ImageIcon(originalImage));
            lblImagen.setBounds(315, 11, 283, 183);
            add(lblImagen);
        } catch (IOException e) {
            e.printStackTrace();
        } */

        // Botón de Registrarse
        JButton btnRegistrarse = new JButton("Registrarse");
        btnRegistrarse.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
        btnRegistrarse.setBounds(376, 482, 125, 30);
        btnRegistrarse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelPrincipal, "registro");
            }
        });
        add(btnRegistrarse);

        JLabel lblanNoTienes = new JLabel("¿Aún no tienes una cuenta?");
        lblanNoTienes.setHorizontalAlignment(SwingConstants.CENTER);
        lblanNoTienes.setForeground(Color.WHITE);
        lblanNoTienes.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
        lblanNoTienes.setBounds(339, 448, 208, 32);
        add(lblanNoTienes);
    }
}