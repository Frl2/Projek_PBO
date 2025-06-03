/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Farrel
 */
public class Staff {
    private int id;
    private String nama;
    private String noTelp;

    public Staff(int id, String nama, String jabatan, String noTelp) {
        this.id = id;
        this.nama = nama;
        this.noTelp = noTelp;
    }

    public int getId() { return id; }
    public String getNama() { return nama; }
    public String getNoTelp() { return noTelp; }
}