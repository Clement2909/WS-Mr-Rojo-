/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.back.wsrojo.DAO;

import com.back.wsrojo.connect.Postgres;
import com.back.wsrojo.model.Brand;
import com.back.wsrojo.model.Commission;
import com.back.wsrojo.model.Magasin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Toavina Raza
 */
public class MagasinDAO {
    
    public static Magasin getByID(int id) throws Exception{
        Connection con = null;
        PreparedStatement stmt = null;
        Magasin m = new Magasin();
        String query = "Select * from magasin where id=?";
        try
        {
            con = Postgres.connect();
            stmt = con.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
              m.setId(rs.getInt("id"));
              m.setStatus(rs.getString("status"));
              m.setId_user(rs.getInt("id_user"));
              m.setId_car(rs.getInt("id_car"));
                
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
        return m;
    }
    
    public static ArrayList<Magasin> getAll(Connection con) throws Exception{
        PreparedStatement stmt = null;
        ArrayList<Magasin> magasins = new ArrayList<>();
        
        try
        {
            con = Postgres.connect();
            stmt = con.prepareStatement("Select * from magasin");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
              Magasin m = new Magasin();
              m.setId(rs.getInt("id"));
              m.setStatus(rs.getString("status"));
              m.setId_user(rs.getInt("id_user"));
              m.setId_car(rs.getInt("id_car"));
              magasins.add(m);
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
        return magasins;
    }
    
    public static void save(Magasin m) throws Exception{
        Connection con = null;
        PreparedStatement stmt = null;
        try
        {
            con = Postgres.connect();
            stmt = con.prepareStatement("INSERT INTO magasin(status,id_user,id_car) values (?,?,?)");
            stmt.setString(1, m.getStatus());
            stmt.setInt(2, m.getId_user());
            stmt.setInt(3, m.getId_car());
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
    public static void update(Magasin m) throws Exception{
        Connection con = null;
        PreparedStatement stmt = null;
        try
        {
            con = Postgres.connect();
            stmt = con.prepareStatement("UPDATE magasin set status=?,id_user=?,id_car=? WHERE id=?");
            stmt.setString(1, m.getStatus());
            stmt.setInt(2, m.getId_user());
            stmt.setInt(3, m.getId_car());
            stmt.setInt(4, m.getId());

            // Execute the update statement
            int affectedRows = stmt.executeUpdate();

            // Check if any rows were affected
            if (affectedRows > 0) {
                System.out.println("Magasin updated successfully!");
            } else {
                System.out.println("No Magasin were updated.");
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
            stmt = con.prepareStatement("DELETE FROM magasin WHERE id = ?");
            stmt.setInt(1, id);

            // Execute the update statement
            int affectedRows = stmt.executeUpdate();

            // Check if any rows were affected
            if (affectedRows > 0) {
                System.out.println("Magasin deleted successfully!");
            } else {
                System.out.println("No Magasin were deleted.");
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
