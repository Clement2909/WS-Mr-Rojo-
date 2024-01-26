/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.back.wsrojo.DAO;

import com.back.wsrojo.connect.Postgres;
import com.back.wsrojo.model.Category;
import com.back.wsrojo.model.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Toavina Raza
 */
public class ColorDAO {
    public static Color getByID(int id) throws Exception{
        Connection con = null;
        PreparedStatement stmt = null;
        Color c = new Color();
        String query = "Select * from color where id=?";
        try
        {
            con = Postgres.connect();
            stmt = con.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
              c.setId(rs.getInt("id"));
              c.setColor(rs.getString("color"));
                
            }
            
        }
        catch (Exception e)
        { 
            throw new Exception("erreur"+e.getMessage());
        }
        finally{
            if (stmt != null) stmt.close();
            if (con != null) con.close();
        }
        return c;
    }
    
    public static ArrayList<Color> getAll(Connection con) throws Exception{
        PreparedStatement stmt = null;
        ArrayList<Color> colors = new ArrayList<>();
        
        try
        {
            con = Postgres.connect();
            stmt = con.prepareStatement("Select * from color");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
              Color c = new Color();
              c.setId(rs.getInt("id"));
              c.setColor(rs.getString("color"));
              colors.add(c);
            }
            
        }
        catch (Exception e)
        { 
            throw new Exception("erreur"+e.getMessage());
        }
         finally{
            if (stmt != null) stmt.close();
            if (con != null) con.close();
        }
        return colors;
    }
    
    public static void save(Color c) throws Exception{
        Connection con = null;
        PreparedStatement stmt = null;
        try
        {
            con = Postgres.connect();
            stmt = con.prepareStatement("INSERT INTO color(color) values (?)");
            stmt.setString(1, c.getColor());
            stmt.executeUpdate();
            
        }
        catch (Exception e)
        { 
            throw new Exception("erreur"+e.getMessage());
        }
        finally{
            if (stmt != null) stmt.close();
            if (con != null) con.close();
        }
        
    }
    
    public static void update(Color c) throws Exception{
        Connection con = null;
        PreparedStatement stmt = null;
        try
        {
            con = Postgres.connect();
            stmt = con.prepareStatement("UPDATE color set color=? WHERE id=?");
            stmt.setString(1, c.getColor());
            stmt.setInt(2, c.getId());

            // Execute the update statement
            int affectedRows = stmt.executeUpdate();

            // Check if any rows were affected
            if (affectedRows > 0) {
                System.out.println("Color updated successfully!");
            } else {
                System.out.println("No Color were updated.");
            }
            
        }
        catch (Exception e)
        { 
            throw new Exception("erreur"+e.getMessage());
        }
        finally{
            if (stmt != null) stmt.close();
            if (con != null) con.close();
        }
    }
    
    public static void delete(int id) throws Exception{
        Connection con = null;
        PreparedStatement stmt = null;
        try
        {
            con = Postgres.connect();
            stmt = con.prepareStatement("DELETE FROM color WHERE id = ?");
            stmt.setInt(1, id);

            // Execute the update statement
            int affectedRows = stmt.executeUpdate();

            // Check if any rows were affected
            if (affectedRows > 0) {
                System.out.println("Color deleted successfully!");
            } else {
                System.out.println("No Color were deleted.");
            }
            
        }
        catch (Exception e)
        { 
            throw new Exception("erreur"+e.getMessage());
        }
        finally{
            if (stmt != null) stmt.close();
            if (con != null) con.close();
        }
        
    }
}
