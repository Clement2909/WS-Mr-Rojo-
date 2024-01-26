/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.back.wsrojo.DAO;

import com.back.wsrojo.connect.Postgres;
import com.back.wsrojo.model.Annonce;
import com.back.wsrojo.model.Brand;
import com.back.wsrojo.model.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Toavina Raza
 */
public class BrandDAO {
    
    public static Brand getByID(int id) throws Exception{
        Connection con = null;
        PreparedStatement stmt = null;
        Brand b = new Brand();
        String query = "Select * from brand where id=?";
        try
        {
            con = Postgres.connect();
            stmt = con.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
              b.setId(rs.getInt("id"));
              b.setBrand(rs.getString("brand"));
                
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
        return b;
    }
    
    public static ArrayList<Brand> getAll(Connection con) throws Exception{
        PreparedStatement stmt = null;
        ArrayList<Brand> brands = new ArrayList<>();
        
        try
        {
            con = Postgres.connect();
            stmt = con.prepareStatement("Select * from brand");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
              Brand b = new Brand();
              b.setId(rs.getInt("id"));
              b.setBrand(rs.getString("brand"));
              brands.add(b);
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
        return brands;
    }
    
    public static void save(Brand b) throws Exception{
        Connection con = null;
        PreparedStatement stmt = null;
        try
        {
            con = Postgres.connect();
            stmt = con.prepareStatement("INSERT INTO brand(brand) values (?)");
            stmt.setString(1, b.getBrand());
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
    public static void update(Brand b) throws Exception{
        Connection con = null;
        PreparedStatement stmt = null;
        try
        {
            con = Postgres.connect();
            stmt = con.prepareStatement("UPDATE brand set brand=? WHERE id=?");
            stmt.setString(1, b.getBrand());
            stmt.setInt(2, b.getId());

            // Execute the update statement
            int affectedRows = stmt.executeUpdate();

            // Check if any rows were affected
            if (affectedRows > 0) {
                System.out.println("Brand updated successfully!");
            } else {
                System.out.println("No Brand were updated.");
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
            stmt = con.prepareStatement("DELETE FROM annonce WHERE id = ?");
            stmt.setInt(1, id);

            // Execute the update statement
            int affectedRows = stmt.executeUpdate();

            // Check if any rows were affected
            if (affectedRows > 0) {
                System.out.println("Annonce deleted successfully!");
            } else {
                System.out.println("No Annonce were deleted.");
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
