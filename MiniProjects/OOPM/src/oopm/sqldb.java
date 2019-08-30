/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopm;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author yashjaveri
 */
public class sqldb {

    int c = 0;
    static Connection conn;

    public static Connection javaDb() {
        try {
            //conn = DriverManager.getConnection("jdbc:sqlite:Y:\\MiniProjects-master\\OOPM\\oopmdb.db", "root", "");
            conn = DriverManager.getConnection("jdbc:sqlite://Users/yashjaveri/Documents/MiniProjects/OOPM/oopmdb.db", "root", "");
            System.out.println("Connected!");
            return conn;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}
