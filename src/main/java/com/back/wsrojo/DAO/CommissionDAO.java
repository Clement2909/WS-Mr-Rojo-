/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.back.wsrojo.DAO;

import com.back.wsrojo.connect.Postgres;
import com.back.wsrojo.model.Brand;
import com.back.wsrojo.model.Color;
import com.back.wsrojo.model.Commission;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Toavina Raza
 */
public class CommissionDAO {
    
    public static Commission getByID(int id) throws Exception{
        Connection con = null;
        PreparedStatement stmt = null;
        Commission c = new Commission();
        String query = "Select * from commission where id=?";
        try
        {
            con = Postgres.connect();
            stmt = con.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
              c.setId(rs.getInt("id"));
              c.setId_category(rs.getInt("id_category"));
              c.setPrixpourcentage(rs.getFloat("prixpourcentage"));
                
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
    
    public static ArrayList<Commission> getAll(Connection con) throws Exception{
        PreparedStatement stmt = null;
        ArrayList<Commission> commissions = new ArrayList<>();
        
        try
        {
            con = Postgres.connect();
            stmt = con.prepareStatement("Select * from commission");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
              Commission c = new Commission();
              c.setId(rs.getInt("id"));
              c.setId_category(rs.getInt("id_category"));
              c.setPrixpourcentage(rs.getFloat("prixpourcentage"));
              commissions.add(c);
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
        return commissions;
    }
    
    public static void save(Commission c) throws Exception{
        Connection con = null;
        PreparedStatement stmt = null;
        try
        {
            con = Postgres.connect();
            stmt = con.prepareStatement("INSERT INTO commission(id_category,prixpourcentage) values (?,?)");
            stmt.setInt(1, c.getId_category());
            stmt.setFloat(2, c.getPrixpourcentage());
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
    
    public static void update(Commission c) throws Exception{
        Connection con = null;
        PreparedStatement stmt = null;
        try
        {
            con = Postgres.connect();
            stmt = con.prepareStatement("UPDATE commission set id_category=?,prixpourcentage=? WHERE id=?");
            stmt.setInt(1, c.getId_category());
            stmt.setFloat(2, c.getPrixpourcentage());
            stmt.setInt(3, c.getId());

            // Execute the update statement
            int affectedRows = stmt.executeUpdate();

            // Check if any rows were affected
            if (affectedRows > 0) {
                System.out.println("Commission updated successfully!");
            } else {
                System.out.println("No Commission were updated.");
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
            stmt = con.prepareStatement("DELETE FROM commission WHERE id = ?");
            stmt.setInt(1, id);

            // Execute the update statement
            int affectedRows = stmt.executeUpdate();

            // Check if any rows were affected
            if (affectedRows > 0) {
                System.out.println("Commission deleted successfully!");
            } else {
                System.out.println("No Commission were deleted.");
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
