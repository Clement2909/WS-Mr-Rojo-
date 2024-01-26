/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.back.wsrojo.DAO;

import com.back.wsrojo.connect.Postgres;
import com.back.wsrojo.model.Brand;
import com.back.wsrojo.model.Magasin;
import com.back.wsrojo.model.Vendu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Toavina Raza
 */
public class VenduDAO {
    
    public static Vendu getByID(int id) throws Exception{
        Connection con = null;
        PreparedStatement stmt = null;
        Vendu v = new Vendu();
        String query = "Select * from vendu where id=?";
        try
        {
            con = Postgres.connect();
            stmt = con.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
              v.setId(rs.getInt("id"));
              v.setId_annonce(rs.getInt("id_annonce"));
              v.setId_commission(rs.getInt("id_commission"));
              v.setDatevente(rs.getDate("datevente"));
                
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
        return v;
    }
    
    public static ArrayList<Vendu> getAll(Connection con) throws Exception{
        PreparedStatement stmt = null;
        ArrayList<Vendu> vendus = new ArrayList<>();
        
        try
        {
            con = Postgres.connect();
            stmt = con.prepareStatement("Select * from vendu");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
              Vendu v = new Vendu();
              v.setId(rs.getInt("id"));
              v.setId_annonce(rs.getInt("id_annonce"));
              v.setId_commission(rs.getInt("id_commission"));
              v.setDatevente(rs.getDate("datevente"));
              vendus.add(v);
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
        return vendus;
    }
    
    public static void save(Vendu v) throws Exception{
        Connection con = null;
        PreparedStatement stmt = null;
        try
        {
            con = Postgres.connect();
            stmt = con.prepareStatement("INSERT INTO vendu(id_annonce,id_commission,datevente) values (?,?,?)");
            stmt.setInt(1, v.getId_annonce());
            stmt.setInt(2, v.getId_commission());
            stmt.setDate(3, v.getDatevente());
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
    
    public static void update(Vendu v) throws Exception{
        Connection con = null;
        PreparedStatement stmt = null;
        try
        {
            con = Postgres.connect();
            stmt = con.prepareStatement("UPDATE vendu set id_annonce=?,id_commission=?,datevente=? WHERE id=?");
            stmt.setInt(1, v.getId_annonce());
            stmt.setInt(2, v.getId_commission());
            stmt.setDate(3, v.getDatevente());
            stmt.setInt(4, v.getId());

            // Execute the update statement
            int affectedRows = stmt.executeUpdate();

            // Check if any rows were affected
            if (affectedRows > 0) {
                System.out.println("Vendu updated successfully!");
            } else {
                System.out.println("No Vendu were updated.");
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
            stmt = con.prepareStatement("DELETE FROM vendu WHERE id = ?");
            stmt.setInt(1, id);

            // Execute the update statement
            int affectedRows = stmt.executeUpdate();

            // Check if any rows were affected
            if (affectedRows > 0) {
                System.out.println("Vendu deleted successfully!");
            } else {
                System.out.println("No Vendu were deleted.");
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
