package Grafico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Logica.Usuario;

public class Perfil extends JPanel {

    /**
     * @wbp.parser.constructor
     */
    public Perfil(String nombreUsuario, String correo, String contraseña, CardLayout cardLayout, JPanel panelPrincipal) {
        setLayout(null); // Usar Absolute Layout
        setBackground(new Color(44, 54, 82)); // Fondo general

        // Etiqueta de bienvenida
        JLabel lblNombreUsuario = new JLabel("Bienvenido, " + nombreUsuario);
        lblNombreUsuario.setForeground(Color.WHITE);
        lblNombreUsuario.setFont(new Font("Arial", Font.BOLD, 20));
        lblNombreUsuario.setBounds(365, 101, 300, 30);
        add(lblNombreUsuario);

        // Mostrar correo
        JLabel lblCorreo = new JLabel("Correo: " + correo);
        lblCorreo.setForeground(Color.WHITE);
        lblCorreo.setFont(new Font("Arial", Font.PLAIN, 16));
        lblCorreo.setBounds(400, 142, 300, 30);
        add(lblCorreo);

        // Mostrar contraseña
        JLabel lblContraseña = new JLabel("Contraseña: " + contraseña);
        lblContraseña.setForeground(Color.WHITE);
        lblContraseña.setFont(new Font("Arial", Font.PLAIN, 16));
        lblContraseña.setBounds(389, 183, 300, 30);
        add(lblContraseña);

        // Panel izquierdo con botones
        JPanel panelIzquierdo = new JPanel();
        panelIzquierdo.setLayout(new GridLayout(2, 1, 10, 10));
        panelIzquierdo.setBackground(new Color(52, 73, 94)); // Color de fondo #34495e
        panelIzquierdo.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        panelIzquierdo.setBounds(400, 252, 150, 100); // Establecer los límites del panel izquierdo

        JButton btnRegresar = new JButton("Regresar");
        btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelPrincipal, "inicio");
            }
        });
        panelIzquierdo.add(btnRegresar);

        JButton btnCerrarSesion = new JButton("Cerrar Sesión");
        btnCerrarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelPrincipal, "IniciarSesion");
            }
        });
        panelIzquierdo.add(btnCerrarSesion);

        add(panelIzquierdo);

        // Etiqueta de pregunta
        JLabel lblQueDeseasRealizar = new JLabel("¿Qué deseas realizar?");
        lblQueDeseasRealizar.setForeground(Color.WHITE);
        lblQueDeseasRealizar.setFont(new Font("Arial", Font.PLAIN, 12));
        lblQueDeseasRealizar.setBounds(411, 224, 400, 30);
        add(lblQueDeseasRealizar);
    }

    public Perfil(Usuario usuario, CardLayout cardLayout, JPanel panelPrincipal) {
        this(usuario.getNombre(), usuario.getCorreo(), usuario.getContraseña(), cardLayout, panelPrincipal);
    }
}
