package Grafico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Logica.Usuario;

public class Perfil extends JPanel {

   
    public Perfil(String nombreUsuario, String correo, String contraseña, CardLayout cardLayout, JPanel panelPrincipal) {
        setLayout(null); // Usar Absolute Layout
        setBackground(new Color(44, 54, 82)); // Fondo general

        // Etiqueta de bienvenida
        JLabel lblNombreUsuario = new JLabel("Bienvenide, " + nombreUsuario);
        lblNombreUsuario.setForeground(Color.WHITE);
        lblNombreUsuario.setFont(new Font("Arial", Font.BOLD, 20));
        lblNombreUsuario.setBounds(267, 126, 300, 30);
        add(lblNombreUsuario);
        
        JLabel imagenIzquierda = new JLabel(new ImageIcon(new ImageIcon("C:\\Users\\natha\\git\\PROYECTO-FINAL\\Proyecto Final - Abrego, Bonilla, Branford, Joseph\\Imágenes\\Bookstore (350 x 350 px) (2).png").getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
        imagenIzquierda.setBounds(185, -104, 400, 372); // Ajustar tamaño y posición
        add(imagenIzquierda);
        
        // Mostrar correo
        JLabel lblCorreo = new JLabel("Correo: " + correo);
        lblCorreo.setForeground(Color.WHITE);
        lblCorreo.setFont(new Font("Arial", Font.PLAIN, 16));
        lblCorreo.setBounds(314, 156, 300, 30);
        add(lblCorreo);

        

        // Panel izquierdo con botones
        JPanel panelIzquierdo = new JPanel();
        panelIzquierdo.setLayout(new GridLayout(2, 1, 10, 10));
        panelIzquierdo.setBackground(new Color(52, 73, 94)); // Color de fondo #34495e
        panelIzquierdo.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        panelIzquierdo.setBounds(314, 221, 150, 100); // Establecer los límites del panel izquierdo

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
        lblQueDeseasRealizar.setBounds(324, 197, 400, 30);
        add(lblQueDeseasRealizar);
    }

    public Perfil(Usuario usuario, CardLayout cardLayout, JPanel panelPrincipal) {
        this(usuario.getNombre(), usuario.getCorreo(), usuario.getContraseña(), cardLayout, panelPrincipal);
    }
}
