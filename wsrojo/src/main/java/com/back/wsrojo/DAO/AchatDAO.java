/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.back.wsrojo.DAO;

import com.back.wsrojo.connect.Postgres;
import com.back.wsrojo.model.Achat;
import com.back.wsrojo.model.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Toavina Raza
 */
public class AchatDAO {
    
    public static Achat getByID(int id) throws Exception{
        Connection con = null;
        PreparedStatement stmt = null;
        Achat a = new Achat();
        String query = "Select * from achat where id=?";
        try
        {
            con = Postgres.connect();
            stmt = con.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                a.setId(rs.getInt("id"));
              a.setDateachat(rs.getDate("dateachat"));
              a.setId_car(rs.getInt("id_car"));
              a.setId_user(rs.getInt("id_user"));
                
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
        return a;
    }
    
    public static ArrayList<Achat> getAll(Connection con) throws Exception{
        PreparedStatement stmt = null;
        ArrayList<Achat> achats = new ArrayList<>();
        
        try
        {
            con = Postgres.connect();
            stmt = con.prepareStatement("Select * from achat");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
              Achat a = new Achat();
              a.setId(rs.getInt("id"));
              a.setDateachat(rs.getDate("dateachat"));
              a.setId_car(rs.getInt("id_car"));
              a.setId_user(rs.getInt("id_user"));
              
              achats.add(a);
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
        return achats;
    }
    
    public static void save(Achat a) throws Exception{
        Connection con = null;
        PreparedStatement stmt = null;
        try
        {
            con = Postgres.connect();
            stmt = con.prepareStatement("INSERT INTO achat(dateachat,id_car,id_user) values (?,?,?)");
            stmt.setDate(1, a.getDateachat());
            stmt.setInt(2, a.getId_car());
            stmt.setInt(3, a.getId_user());
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
    public static void update(Achat a) throws Exception{
        Connection con = null;
        PreparedStatement stmt = null;
        try
        {
            con = Postgres.connect();
            stmt = con.prepareStatement("UPDATE achat set dateachat=?,id_car=?,id_user=? WHERE id=?");
            stmt.setDate(1, a.getDateachat());
            stmt.setInt(2, a.getId_car());
            stmt.setInt(3, a.getId_user());
            stmt.setInt(4, a.getId());

            // Execute the update statement
            int affectedRows = stmt.executeUpdate();

            // Check if any rows were affected
            if (affectedRows > 0) {
                System.out.println("Achat updated successfully!");
            } else {
                System.out.println("No Achat were updated.");
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
            stmt = con.prepareStatement("DELETE FROM achat WHERE id = ?");
            stmt.setInt(1, id);

            // Execute the update statement
            int affectedRows = stmt.executeUpdate();

            // Check if any rows were affected
            if (affectedRows > 0) {
                System.out.println("Achat deleted successfully!");
            } else {
                System.out.println("No Achat were deleted.");
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
