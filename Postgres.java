/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.back.wsrojo.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Postgres {
    
    public static Connection connect() {
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://monorail.proxy.rlwy.net:20388/railway", "postgres", "AgBeaA36Eg4gG*-6312dC5aB16g4c-G-");
            if( conn!= null){
            System.out.println("Connected to the PostgreSQL server successfully.");
            }
            else{
                System.out.println("Connection failed");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }
}
