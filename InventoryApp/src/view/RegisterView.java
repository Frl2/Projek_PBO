/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
import controller.RegisterController;
import model.Staff;
import model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author Farrel
 */
public class RegisterView extends JFrame {
    private final JTextField tfNama = new JTextField();
    private final JTextField tfJabatan = new JTextField();
    private final JTextField tfNoTelp = new JTextField();

    private final JTextField tfUsername = new JTextField();
    private final JPasswordField pfPassword = new JPasswordField();

    private final JButton btnRegister = new JButton("Register");

    private final RegisterController registerController = new RegisterController();

    public RegisterView() {
        setTitle("Register User");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(350, 350);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblNama = new JLabel("Nama Staff:");
        lblNama.setBounds(20, 20, 100, 25);
        add(lblNama);
        tfNama.setBounds(120, 20, 180, 25);
        add(tfNama);

        JLabel lblJabatan = new JLabel("Jabatan:");
        lblJabatan.setBounds(20, 60, 100, 25);
        add(lblJabatan);
        tfJabatan.setBounds(120, 60, 180, 25);
        add(tfJabatan);

        JLabel lblNoTelp = new JLabel("No. Telp:");
        lblNoTelp.setBounds(20, 100, 100, 25);
        add(lblNoTelp);
        tfNoTelp.setBounds(120, 100, 180, 25);
        add(tfNoTelp);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(20, 140, 100, 25);
        add(lblUsername);
        tfUsername.setBounds(120, 140, 180, 25);
        add(tfUsername);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(20, 180, 100, 25);
        add(lblPassword);
        pfPassword.setBounds(120, 180, 180, 25);
        add(pfPassword);

        btnRegister.setBounds(120, 230, 100, 30);
        add(btnRegister);

        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = tfNama.getText();
                String jabatan = tfJabatan.getText();
                String noTelp = tfNoTelp.getText();
                String username = tfUsername.getText();
                String password = new String(pfPassword.getPassword());

                if (nama.isEmpty() || jabatan.isEmpty() || noTelp.isEmpty() || username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(RegisterView.this, "Semua field harus diisi!");
                    return;
                }

                boolean success = registerController.registerUser(nama, jabatan, noTelp, username, password);
                if (success) {
                    JOptionPane.showMessageDialog(RegisterView.this, "Registrasi berhasil! Silakan login.");
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(RegisterView.this, "Gagal registrasi. Username mungkin sudah dipakai.");
                }
            }
        });
    }
}
