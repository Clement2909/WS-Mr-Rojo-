/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.back.wsrojo.DAO;

import com.back.wsrojo.connect.Postgres;
import com.back.wsrojo.model.Achat;
import com.back.wsrojo.model.Annonce;
import com.back.wsrojo.model.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Toavina Raza
 */
public class AnnonceDAO {
    
    public static Annonce getByID(int id) throws Exception{
        Connection con = null;
        PreparedStatement stmt = null;
        Annonce a = new Annonce();
        String query = "Select * from annonce where id=?";
        try
        {
            con = Postgres.connect();
            stmt = con.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
              a.setId(rs.getInt("id"));
              a.setId_car(rs.getInt("id_car"));
              a.setDatepub(rs.getDate("datepub"));
              a.setPrix(rs.getFloat("prix"));
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
    
    public static ArrayList<Annonce> getAll(Connection con) throws Exception{
        PreparedStatement stmt = null;
        ArrayList<Annonce> annonces = new ArrayList<>();
        
        try
        {
            con = Postgres.connect();
            stmt = con.prepareStatement("Select * from annonce");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
              Annonce a = new Annonce();
              a.setId(rs.getInt("id"));
              a.setId_car(rs.getInt("id_car"));
              a.setDatepub(rs.getDate("datepub"));
              a.setPrix(rs.getFloat("prix"));
              a.setId_user(rs.getInt("id_user"));
              
              annonces.add(a);
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
        return annonces;
    }
    
    public static void save(Annonce a) throws Exception{
        Connection con = null;
        PreparedStatement stmt = null;
        try
        {
            con = Postgres.connect();
            stmt = con.prepareStatement("INSERT INTO annonce(id_car,datepub,prix,id_user) values (?,?,?,?)");
            stmt.setInt(1, a.getId_car());
            stmt.setDate(2, a.getDatepub());
            stmt.setFloat(3,a.getPrix());
            stmt.setInt(4, a.getId_user());
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
    public static void update(Annonce a) throws Exception{
        Connection con = null;
        PreparedStatement stmt = null;
        try
        {
            con = Postgres.connect();
            stmt = con.prepareStatement("UPDATE annonce set id_car=?,datepub=?,prix=?,id_user=? WHERE id=?");
            stmt.setInt(1, a.getId_car());
            stmt.setDate(2, a.getDatepub());
            stmt.setFloat(3, a.getPrix());
            stmt.setInt(4, a.getId_user());
            stmt.setInt(5, a.getId());

            // Execute the update statement
            int affectedRows = stmt.executeUpdate();

            // Check if any rows were affected
            if (affectedRows > 0) {
                System.out.println("Annonce updated successfully!");
            } else {
                System.out.println("No Annonce were updated.");
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
