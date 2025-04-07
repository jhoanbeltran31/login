/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import logica.UsuarioDAO;
import javax.swing.*;

public class LoginFrame extends JFrame {
    private JTextField txtUsuario;
    private JPasswordField txtContraseña;
    private JButton btnLogin;

    public LoginFrame() {
        setTitle("Login");
        setSize(300, 180);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setBounds(30, 20, 80, 25);
        add(lblUsuario);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(100, 20, 150, 25);
        add(txtUsuario);

        JLabel lblContraseña = new JLabel("Contraseña:");
        lblContraseña.setBounds(30, 55, 80, 25);
        add(lblContraseña);

        txtContraseña = new JPasswordField();
        txtContraseña.setBounds(100, 55, 150, 25);
        add(txtContraseña);

        btnLogin = new JButton("Iniciar sesión");
        btnLogin.setBounds(80, 95, 120, 30);
        add(btnLogin);

        btnLogin.addActionListener(e -> {
            String usuario = txtUsuario.getText();
            String contraseña = new String(txtContraseña.getPassword());
            UsuarioDAO dao = new UsuarioDAO();
            if (dao.validarUsuario(usuario, contraseña)) {
                JOptionPane.showMessageDialog(this, "Inicio de sesión exitoso");
            } else {
                JOptionPane.showMessageDialog(this, "Credenciales incorrectas");
            }
        });
    }

    public static void main (String[] args) {
        SwingUtilities.invokeLater(() -> new LoginFrame().setVisible(true));
    }
}

