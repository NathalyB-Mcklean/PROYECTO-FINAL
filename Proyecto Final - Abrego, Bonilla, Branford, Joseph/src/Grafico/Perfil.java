package Grafico;

import javax.swing.*;
import Logica.Usuario;
import java.awt.*;

public class Perfil extends JPanel {
    private JLabel lblNombreUsuario;
    private JLabel lblCorreoUsuario;
    private JButton btnRegresar, btnCerrarSesion;

    public Perfil(Usuario usuario, CardLayout cardLayout, JPanel panelPrincipal) {
        setLayout(null); // Usar Absolute Layout
        setBackground(new Color(40, 54, 82)); // Fondo #283652

        // Etiqueta de bienvenida
        lblNombreUsuario = new JLabel("Bienvenido, " + usuario.getNombre());
        lblNombreUsuario.setForeground(Color.WHITE);
        lblNombreUsuario.setFont(new Font("Arial", Font.BOLD, 26));
        lblNombreUsuario.setBounds(182, 154, 400, 30);
        add(lblNombreUsuario);

        // Etiqueta de correo
        lblCorreoUsuario = new JLabel("Correo: " + usuario.getCorreo());
        lblCorreoUsuario.setForeground(Color.WHITE);
        lblCorreoUsuario.setFont(new Font("Arial", Font.PLAIN, 18));
        lblCorreoUsuario.setBounds(182, 186, 400, 30);
        add(lblCorreoUsuario);

        // Panel izquierdo con opciones
        JPanel panelIzquierdo = new JPanel();
        panelIzquierdo.setLayout(new GridLayout(2, 1, 10, 10));
        panelIzquierdo.setBackground(new Color(52, 73, 94)); // Color de fondo #34495e
        panelIzquierdo.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        panelIzquierdo.setBounds(314, 255, 150, 100); // Establecer los límites del panel izquierdo

        // Botón de Cerrar Sesión
        btnCerrarSesion = new JButton("Cerrar Sesión");
        btnCerrarSesion.addActionListener(e -> cardLayout.show(panelPrincipal, "IniciarSesion"));
        panelIzquierdo.add(btnCerrarSesion);

        // Botón de Regresar
        btnRegresar = new JButton("Regresar");
        btnRegresar.addActionListener(e -> cardLayout.show(panelPrincipal, "inicio"));
        panelIzquierdo.add(btnRegresar);

        add(panelIzquierdo);

        // Imagen o logo en el panel
        JLabel lblLogo = new JLabel(new ImageIcon("C:\\Users\\natha\\git\\PROYECTO-FINAL\\Proyecto Final - Abrego, Bonilla, Branford, Joseph\\Imágenes\\Bookstore (350 x 350 px) (2).png")); // Reemplaza con la ruta a tu logo o imagen
        lblLogo.setBounds(182, 0, 410, 184);
        add(lblLogo);

        // Etiqueta de pregunta
        JLabel lblQueDeseasRealizar = new JLabel("¿Qué deseas realizar?");
        lblQueDeseasRealizar.setForeground(Color.WHITE);
        lblQueDeseasRealizar.setFont(new Font("Arial", Font.PLAIN, 12));
        lblQueDeseasRealizar.setBounds(325, 227, 400, 30);
        add(lblQueDeseasRealizar);
    }
}
