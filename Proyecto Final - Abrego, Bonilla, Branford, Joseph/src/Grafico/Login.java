package Grafico; 

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class Login extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login frame = new Login();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Login() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 924, 498);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(204, 204, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("INICIO DE SESIÓN");
        lblNewLabel.setFont(new Font("Yu Gothic", Font.BOLD, 20));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(366, 84, 208, 32);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(348, 173, 421, 26);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel lblNombreDeUsuario = new JLabel("Usuario:");
        lblNombreDeUsuario.setHorizontalAlignment(SwingConstants.CENTER);
        lblNombreDeUsuario.setFont(new Font("Yu Gothic", Font.BOLD, 20));
        lblNombreDeUsuario.setBounds(191, 172, 125, 32);
        contentPane.add(lblNombreDeUsuario);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(348, 256, 421, 26);
        contentPane.add(textField_1);

        JLabel lblContraseña = new JLabel("Contraseña:");
        lblContraseña.setHorizontalAlignment(SwingConstants.CENTER);
        lblContraseña.setFont(new Font("Yu Gothic", Font.BOLD, 20));
        lblContraseña.setBounds(164, 255, 208, 32);
        contentPane.add(lblContraseña);

        JButton btnIngresar = new JButton("Ingresar");
        btnIngresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String usuario = textField.getText();
                String contraseña = textField_1.getText();

                String sql = "SELECT * FROM usuarios WHERE Usuario = ? AND Contraseña = ?";
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    String url = "jdbc:mysql://localhost:3306/libros";
                    String user = "root";
                    String password = "";
                    Connection con = DriverManager.getConnection(url, user, password);
                    
                    PreparedStatement pstmt = con.prepareStatement(sql);
                    pstmt.setString(1, usuario);
                    pstmt.setString(2, contraseña);
                    
                    ResultSet rs = pstmt.executeQuery();

                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "Iniciando sesión...");
                        // Aquí puedes abrir la ventana principal de tu aplicación o realizar otras acciones
                    } else {
                        JOptionPane.showMessageDialog(null, "El usuario o la contraseña ingresada es incorrecta...");
                    }

                    con.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }

            }
        });
        btnIngresar.setFont(new Font("Yu Gothic", Font.PLAIN, 11));
        btnIngresar.setBounds(409, 330, 125, 23);
        contentPane.add(btnIngresar);
    }
}
