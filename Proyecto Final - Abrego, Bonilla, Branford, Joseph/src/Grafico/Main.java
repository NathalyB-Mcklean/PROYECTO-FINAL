package Grafico;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {

    private JPanel panelPrincipal;
    private CardLayout cardLayout;

    public Main() {
        super("Página de Presentación");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        panelPrincipal = new JPanel();
        cardLayout = new CardLayout();
        panelPrincipal.setLayout(cardLayout);

        JPanel paginaPresentacion = crearPaginaPresentacion();
        panelPrincipal.add(paginaPresentacion, "presentacion");

        Registro registroPanel = new Registro(cardLayout, panelPrincipal); // Pasar CardLayout y panelPrincipal
        panelPrincipal.add(registroPanel, "registro");

        cardLayout.show(panelPrincipal, "presentacion");

        getContentPane().add(panelPrincipal);

        setVisible(true);
    }

    private JPanel crearPaginaPresentacion() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setLayout(null);

        JTextArea texto = new JTextArea();
        texto.setFont(new Font("Yu Gothic", Font.BOLD, 12));
        texto.setEditable(false);
        texto.setOpaque(false);
        texto.setAlignmentX(Component.CENTER_ALIGNMENT);
        texto.setText("             UNIVERSIDAD TECNOLÓGICA DE PANAMÁ\r\nFACULTAD DE INGENIERÍA DE SISTEMAS COMPUTACIONALES\r\n           DEPARTAMENTO DE INGENIERÍA DE SOFTWARE\r\n           LICENCIATURA EN INGENIERÍA DE SOFTWARE\r\n\r\n                                     GRUPO:\r\n                                     1SF121\r\n\r\n                                      CURSO:\r\n                 PROGRAMACIÓN DE SOFTWARE I\r\n\r\n                             PROYECTO FINAL\r\n\r\n                               FACILITADOR:\r\n                         RODRIGO YANGÜES\r\n\r\n                             ESTUDIANTES:\r\n                 Abdiel Abrego    9-765-799\r\n                 Nathaly Bonilla       8-1021-1364\r\n                 Melvin Branford  8-952-823\r\n                 Wanytchy Joseph   8-1020-1086\r\n\r\n                         FECHA DE ENTREGA:\r\n                MIÉRCOLES 17 DE JUNIO DE 2024");
        texto.setBounds(222, 11, 387, 484);
        panel.add(texto);

        BufferedImage img1 = null, img2 = null;
        try {
            img1 = ImageIO.read(new File("C:\\Users\\natha\\git\\PROYECTO-FINAL\\Proyecto Final - Abrego, Bonilla, Branford, Joseph\\Imágenes\\logo_utp-rgb_2022.png"));
            img2 = ImageIO.read(new File("C:\\Users\\natha\\git\\PROYECTO-FINAL\\Proyecto Final - Abrego, Bonilla, Branford, Joseph\\Imágenes\\5974086.png"));
            img1 = resizeImage(img1, 100, 100);
            img2 = resizeImage(img2, 100, 100);
        } catch (IOException e) {
            e.printStackTrace();
        }

        JLabel labelImagen1 = new JLabel(new ImageIcon(img1));
        labelImagen1.setBounds(50, 20, 100, 100);
        panel.add(labelImagen1);

        JLabel labelImagen2 = new JLabel(new ImageIcon(img2));
        labelImagen2.setBounds(622, 20, 100, 100);
        panel.add(labelImagen2);

        JButton btnNewButton = new JButton("Ingresar a la aplicación");
        btnNewButton.setFont(new Font("Yu Gothic", Font.PLAIN, 11));
        btnNewButton.setBounds(272, 506, 200, 23);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelPrincipal, "registro");
                
            }
        });
        panel.add(btnNewButton);

        return panel;
    }

    private BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) {
        BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, targetWidth, targetHeight, null);
        g.dispose();
        return resizedImage;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main());
    }
}
