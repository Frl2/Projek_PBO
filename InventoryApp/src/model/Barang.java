/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Farrel
 */
public class Barang {
    private int id;
    private String nama;
    private int jumlah;
    private String lokasi;

    public Barang(int id, String nama, int jumlah, String lokasi) {
        this.id = id;
        this.nama = nama;
        this.jumlah = jumlah;
        this.lokasi = lokasi;
    }

    public int getId() { return id; }
    public String getNama() { return nama; }
    public int getJumlah() { return jumlah; }
    public String getLokasi() { return lokasi; }

    public void setNama(String nama) { this.nama = nama; }
    public void setJumlah(int jumlah) { this.jumlah = jumlah; }
    public void setLokasi(String lokasi) { this.lokasi = lokasi; }
}
