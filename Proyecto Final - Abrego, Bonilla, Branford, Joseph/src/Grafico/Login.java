package Grafico;

import java.awt.Font;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import Logica.Usuario;

import javax.swing.JButton;

public class Login extends JPanel {

    private JTextField textFieldUsuario;
    private JTextField textFieldContraseña;
    private Usuario[] usuarios; // Arreglo para almacenar usuarios (simulación)

    public Login(CardLayout cardLayout, JPanel panelPrincipal, Usuario[] usuarios) {
        setBackground(new Color(204, 204, 255));
        setLayout(null);
        
        this.usuarios = usuarios; // Inicializar el arreglo de usuarios

        JLabel lblNewLabel = new JLabel("INICIO DE SESIÓN");
        lblNewLabel.setFont(new Font("Yu Gothic", Font.BOLD, 20));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(366, 84, 208, 32);
        add(lblNewLabel);

        textFieldUsuario = new JTextField();
        textFieldUsuario.setBounds(348, 173, 421, 26);
        add(textFieldUsuario);
        textFieldUsuario.setColumns(10);

        JLabel lblNombreDeUsuario = new JLabel("Usuario:");
        lblNombreDeUsuario.setHorizontalAlignment(SwingConstants.CENTER);
        lblNombreDeUsuario.setFont(new Font("Yu Gothic", Font.BOLD, 20));
        lblNombreDeUsuario.setBounds(191, 172, 125, 32);
        add(lblNombreDeUsuario);

        textFieldContraseña = new JTextField();
        textFieldContraseña.setColumns(10);
        textFieldContraseña.setBounds(348, 256, 421, 26);
        add(textFieldContraseña);

        JLabel lblContraseña = new JLabel("Contraseña:");
        lblContraseña.setHorizontalAlignment(SwingConstants.CENTER);
        lblContraseña.setFont(new Font("Yu Gothic", Font.BOLD, 20));
        lblContraseña.setBounds(164, 255, 208, 32);
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
                    JOptionPane.showMessageDialog(Login.this, "Usuario o contraseña incorrectos", "Error de inicio de sesión", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnIngresar.setFont(new Font("Yu Gothic", Font.PLAIN, 11));
        btnIngresar.setBounds(409, 330, 125, 23);
        add(btnIngresar);
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
