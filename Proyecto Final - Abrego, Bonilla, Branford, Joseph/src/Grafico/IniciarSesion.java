package Grafico;

import java.awt.Font;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Logica.Usuario;

public class IniciarSesion extends JPanel {

    private JTextField textFieldUsuario;
    private JTextField textFieldContraseña;
    private Usuario[] usuarios; // Arreglo para almacenar usuarios (simulación)

    public IniciarSesion(CardLayout cardLayout, JPanel panelPrincipal, Usuario[] usuarios) {
        setBackground(new Color(0x202A40)); // Fondo similar al de Registro
        setLayout(null);
        
        this.usuarios = usuarios; // Inicializar el arreglo de usuarios

        JLabel lblNewLabel = new JLabel("INICIO DE SESIÓN");
        lblNewLabel.setFont(new Font("Yu Gothic", Font.PLAIN, 20));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(358, 177, 208, 32);
        lblNewLabel.setForeground(Color.WHITE); // Color de texto blanco
        add(lblNewLabel);

        textFieldUsuario = new JTextField();
        textFieldUsuario.setBounds(348, 256, 421, 26);
        add(textFieldUsuario);
        textFieldUsuario.setColumns(10);

        JLabel lblNombreDeUsuario = new JLabel("Usuario:");
        lblNombreDeUsuario.setHorizontalAlignment(SwingConstants.CENTER);
        lblNombreDeUsuario.setFont(new Font("Yu Gothic", Font.PLAIN, 20));
        lblNombreDeUsuario.setBounds(188, 250, 125, 32);
        lblNombreDeUsuario.setForeground(Color.WHITE); // Color de texto blanco
        add(lblNombreDeUsuario);

        textFieldContraseña = new JTextField();
        textFieldContraseña.setColumns(10);
        textFieldContraseña.setBounds(348, 341, 421, 26);
        add(textFieldContraseña);

        JLabel lblContraseña = new JLabel("Contraseña:");
        lblContraseña.setHorizontalAlignment(SwingConstants.CENTER);
        lblContraseña.setFont(new Font("Yu Gothic", Font.PLAIN, 20));
        lblContraseña.setBounds(161, 340, 208, 32);
        lblContraseña.setForeground(Color.WHITE); // Color de texto blanco
        add(lblContraseña);

        JButton btnIngresar = new JButton("Ingresar");
        btnIngresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String usuario = textFieldUsuario.getText().trim();
                String contraseña = textFieldContraseña.getText().trim();

                // Validar las credenciales
                boolean loginExitoso = validarCredenciales(usuario, contraseña);

                if (loginExitoso) {
                    // Cambiar al panel de la aplicación principal o a la página de bienvenida
                    cardLayout.show(panelPrincipal, "Bienvenida");
                } else {
                    JOptionPane.showMessageDialog(IniciarSesion.this, "Usuario o contraseña incorrectos", "Error de inicio de sesión", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnIngresar.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
        btnIngresar.setBounds(402, 428, 125, 30);
        add(btnIngresar);

        // Imagen centrada sin redimensionar
        try {
            BufferedImage originalImage = ImageIO.read(new File("C:\\Users\\natha\\git\\PROYECTO-FINAL\\Proyecto Final - Abrego, Bonilla, Branford, Joseph\\Imágenes\\Bookstore (350 x 350 px) (2).png"));
            JLabel lblImagen = new JLabel(new ImageIcon(originalImage));
            lblImagen.setBounds(315, 11, 283, 183); // Ajusta las coordenadas y tamaño según sea necesario
            add(lblImagen);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para validar las credenciales
    private boolean validarCredenciales(String usuario, String contraseña) {
        for (Usuario u : usuarios) {
            if (u != null && u.getNombre().equals(usuario) && u.getContraseña().equals(contraseña)) {
                return true; // Credenciales válidas
            }
        }
        return false; // Credenciales inválidas
    }
}
