/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
import controller.BarangController;
import model.Barang;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.List;
/**
 *
 * @author Farrel
 */
public class BarangView extends JFrame {
    private final BarangController barangController = new BarangController();
    private final JTable table = new JTable();
    private final DefaultTableModel model = new DefaultTableModel();

    private final JTextField tfNama = new JTextField();
    private final JTextField tfJumlah = new JTextField();
    private final JTextField tfLokasi = new JTextField();

    private final JButton btnTambah = new JButton("Tambah");
    private final JButton btnUpdate = new JButton("Update");
    private final JButton btnHapus = new JButton("Hapus");
    private final JButton btnRefresh = new JButton("Tampilkan Data");

    public BarangView() {
        setTitle("Kelola Barang");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(null);

        model.addColumn("ID");
        model.addColumn("Nama Barang");
        model.addColumn("Jumlah");
        model.addColumn("Lokasi");

        table.setModel(model);
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(20, 20, 550, 150);
        add(sp);

        JLabel lblNama = new JLabel("Nama Barang:");
        lblNama.setBounds(20, 190, 100, 25);
        add(lblNama);

        tfNama.setBounds(120, 190, 150, 25);
        add(tfNama);

        JLabel lblJumlah = new JLabel("Jumlah:");
        lblJumlah.setBounds(20, 220, 100, 25);
        add(lblJumlah);

        tfJumlah.setBounds(120, 220, 150, 25);
        add(tfJumlah);

        JLabel lblLokasi = new JLabel("Lokasi:");
        lblLokasi.setBounds(20, 250, 100, 25);
        add(lblLokasi);

        tfLokasi.setBounds(120, 250, 150, 25);
        add(tfLokasi);

        btnTambah.setBounds(300, 190, 100, 25);
        add(btnTambah);

        btnUpdate.setBounds(300, 220, 100, 25);
        add(btnUpdate);

        btnHapus.setBounds(300, 250, 100, 25);
        add(btnHapus);

        btnRefresh.setBounds(420, 190, 150, 25);
        add(btnRefresh);

        btnRefresh.addActionListener(e -> tampilkanData());

        btnTambah.addActionListener(e -> {
            try {
                String nama = tfNama.getText();
                int jumlah = Integer.parseInt(tfJumlah.getText());
                String lokasi = tfLokasi.getText();

                barangController.insertBarang(new Barang(0, nama, jumlah, lokasi));
                JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan");
                tampilkanData();
                resetForm();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Jumlah harus angka");
            }
        });

        btnUpdate.addActionListener(e -> {
            int selected = table.getSelectedRow();
            if (selected >= 0) {
                try {
                    int id = (int) model.getValueAt(selected, 0);
                    String nama = tfNama.getText();
                    int jumlah = Integer.parseInt(tfJumlah.getText());
                    String lokasi = tfLokasi.getText();

                    barangController.updateBarang(new Barang(id, nama, jumlah, lokasi));
                    JOptionPane.showMessageDialog(this, "Data berhasil diupdate");
                    tampilkanData();
                    resetForm();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Jumlah harus angka");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Pilih data yang ingin diupdate");
            }
        });

        btnHapus.addActionListener(e -> {
            int selected = table.getSelectedRow();
            if (selected >= 0) {
                int id = (int) model.getValueAt(selected, 0);
                barangController.deleteBarang(id);
                JOptionPane.showMessageDialog(this, "Data berhasil dihapus");
                tampilkanData();
                resetForm();
            } else {
                JOptionPane.showMessageDialog(this, "Pilih data yang ingin dihapus");
            }
        });

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int selected = table.getSelectedRow();
                if (selected >= 0) {
                    tfNama.setText(model.getValueAt(selected, 1).toString());
                    tfJumlah.setText(model.getValueAt(selected, 2).toString());
                    tfLokasi.setText(model.getValueAt(selected, 3).toString());
                }
            }
        });

        tampilkanData();
    }

    private void tampilkanData() {
        model.setRowCount(0);
        List<Barang> list = barangController.getAllBarang();
        for (Barang b : list) {
            model.addRow(new Object[]{
                    b.getId(), b.getNama(), b.getJumlah(), b.getLokasi()
            });
        }
    }

    private void resetForm() {
        tfNama.setText("");
        tfJumlah.setText("");
        tfLokasi.setText("");
    }
}
