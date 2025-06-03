/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import db.DBConnection;

import java.sql.*;
/**
 *
 * @author Farrel
 */
public class RegisterController {

    public boolean registerUser(String nama, String jabatan, String noTelp, String username, String password) {
        String insertStaffSQL = "INSERT INTO staff (nama, jabatan, no_telp) VALUES (?, ?, ?)";
        String insertUserSQL = "INSERT INTO user (username, password, id_staff) VALUES (?, ?, ?)";

        Connection conn = null;
        PreparedStatement psStaff = null;
        PreparedStatement psUser = null;
        ResultSet generatedKeys = null;

        try {
            conn = DBConnection.getConnection();
            conn.setAutoCommit(false); // transaksi manual

            // Insert staff dulu
            psStaff = conn.prepareStatement(insertStaffSQL, Statement.RETURN_GENERATED_KEYS);
            psStaff.setString(1, nama);
            psStaff.setString(2, jabatan);
            psStaff.setString(3, noTelp);
            int affectedRows = psStaff.executeUpdate();

            if (affectedRows == 0) {
                conn.rollback();
                return false;
            }

            generatedKeys = psStaff.getGeneratedKeys();
            if (generatedKeys.next()) {
                int idStaff = generatedKeys.getInt(1);

                // Insert user terkait staff
                psUser = conn.prepareStatement(insertUserSQL);
                psUser.setString(1, username);
                psUser.setString(2, password);
                psUser.setInt(3, idStaff);
                psUser.executeUpdate();

                conn.commit();
                return true;
            } else {
                conn.rollback();
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return false;
        } finally {
            try {
                if (generatedKeys != null) generatedKeys.close();
                if (psStaff != null) psStaff.close();
                if (psUser != null) psUser.close();
                if (conn != null) conn.setAutoCommit(true);
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
