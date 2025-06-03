/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
import controller.UserController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author Farrel
 */
public class LoginView extends JFrame {
    private final JTextField tfUsername = new JTextField();
    private final JPasswordField pfPassword = new JPasswordField();
    private final JButton btnLogin = new JButton("Login");
    private final JButton btnRegister = new JButton("Register");

    private final UserController userController = new UserController();

    public LoginView() {
        setTitle("Login");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(20, 20, 80, 25);
        add(lblUsername);

        tfUsername.setBounds(110, 20, 150, 25);
        add(tfUsername);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(20, 60, 80, 25);
        add(lblPassword);

        pfPassword.setBounds(110, 60, 150, 25);
        add(pfPassword);

        btnLogin.setBounds(40, 110, 90, 30);
        add(btnLogin);

        btnRegister.setBounds(150, 110, 90, 30);
        add(btnRegister);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = tfUsername.getText();
                String password = new String(pfPassword.getPassword());

                if (username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(LoginView.this, "Username dan password harus diisi!");
                    return;
                }

                boolean success = userController.login(username, password);
                if (success) {
                    JOptionPane.showMessageDialog(LoginView.this, "Login berhasil!");
                    dispose();
                    new BarangView().setVisible(true); // buka menu kelola barang
                } else {
                    JOptionPane.showMessageDialog(LoginView.this, "Username atau password salah!");
                }
            }
        });

        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegisterView().setVisible(true);
            }
        });
    }
}