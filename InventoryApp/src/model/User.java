/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Farrel
 */
public class User {
    private int id;
    private String username;
    private String password;
    private Staff staff;

    public User(int id, String username, String password, Staff staff) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.staff = staff;
    }

    public int getId() { return id; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public Staff getStaff() { return staff; }
}