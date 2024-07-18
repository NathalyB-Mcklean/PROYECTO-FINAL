package Grafico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Logica.Libro;
import Logica.Usuario;

public class Main extends JFrame {

    public JPanel panelPrincipal;
    public CardLayout cardLayout;

    public Main() {
        super("COSMOS");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        panelPrincipal = new JPanel();
        cardLayout = new CardLayout();
        panelPrincipal.setLayout(cardLayout);

        JPanel paginaPresentacion = crearPaginaPresentacion();
        panelPrincipal.add(paginaPresentacion, "presentacion");

        Registro registroPanel = new Registro(cardLayout, panelPrincipal);
        panelPrincipal.add(registroPanel, "registro");

        IniciarSesion iniciarSesionPanel = new IniciarSesion(cardLayout, panelPrincipal);
        panelPrincipal.add(iniciarSesionPanel, "IniciarSesion");

        Inicio inicioPanel = new Inicio(cardLayout, panelPrincipal);
        panelPrincipal.add(inicioPanel, "inicio");

        // Crear un objeto Usuario para ser pasado a la clase Perfil
        Usuario usuario = new Usuario("Usuario", "usuario@correo.com", "contraseña");

        Perfil perfilPanel = new Perfil(usuario, cardLayout, panelPrincipal);
        panelPrincipal.add(perfilPanel, "Perfil");

        // Obtener un libro de ejemplo
        Libro libroEjemplo = Libro.obtenerLibros()[0];
        
        Detalles detallesPanel = new Detalles(libroEjemplo, cardLayout, panelPrincipal);
        panelPrincipal.add(detallesPanel, "detalles");

        cardLayout.show(panelPrincipal, "presentacion");

        getContentPane().add(panelPrincipal);

        setVisible(true);
    }

    public JPanel crearPaginaPresentacion() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setLayout(null);

        JTextArea texto = new JTextArea();
        texto.setBackground(SystemColor.activeCaption);
        texto.setFont(new Font("Yu Gothic", Font.BOLD, 12));
        texto.setEditable(false);
        texto.setOpaque(false);
        texto.setAlignmentX(Component.CENTER_ALIGNMENT);
        texto.setText("                                              UNIVERSIDAD TECNOLÓGICA DE PANAMÁ\r\n                             FACULTAD DE INGENIERÍA DE SISTEMAS COMPUTACIONALES                                                                  DEPARTAMENTO DE INGENIERÍA DE SOFTWARE\r\n                                           LICENCIATURA EN INGENIERÍA DE SOFTWARE\r\n\r\n                                                                                   GRUPO:\r\n                                                                                    1SF121\r\n \r\n                                                                                   CURSO:\r\n                                                             PROGRAMACIÓN DE SOFTWARE I \r\n\r\n                                                                          PROYECTO FINAL\r\n\r\n                                                                              FACILITADOR:\r\n                                                                        RODRIGO YANGÜES\r\n\r\n                                                                            ESTUDIANTES:\r\n                                                                 Abdiel Abrego    9-765-799\r\n                                                              Nathaly Bonilla       8-1021-1364\r\n                                                                 Melvin Branford  8-952-823\r\n                                                              Wanytchy Joseph   8-1020-1086\r\n\r\n                                                                       FECHA DE ENTREGA:\r\n                                                             MIÉRCOLES 17 DE JUNIO DE 2024\r\n");
        texto.setBounds(138, 11, 485, 484);
        panel.add(texto);

        // Añadir las imágenes en las esquinas
        JLabel imagenEsquinaIzquierda = new JLabel(new ImageIcon(new ImageIcon("C:\\Users\\natha\\git\\PROYECTO-FINAL\\Proyecto Final - Abrego, Bonilla, Branford, Joseph\\Imágenes\\logo_utp-rgb_2022.png").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
        imagenEsquinaIzquierda.setBounds(10, 10, 100, 100);
        panel.add(imagenEsquinaIzquierda);

        JLabel imagenEsquinaDerecha = new JLabel(new ImageIcon(new ImageIcon("C:\\Users\\natha\\git\\PROYECTO-FINAL\\Proyecto Final - Abrego, Bonilla, Branford, Joseph\\Imágenes\\5974086.png").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
        imagenEsquinaDerecha.setBounds(670, 10, 100, 100);
        panel.add(imagenEsquinaDerecha);

        JButton btnNewButton = new JButton("Ingresar a la aplicación");
        btnNewButton.setFont(new Font("Yu Gothic", Font.PLAIN, 11));
        btnNewButton.setBounds(321, 506, 200, 23);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelPrincipal, "registro");
            }
        });
        panel.add(btnNewButton);

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main());
    }
}
