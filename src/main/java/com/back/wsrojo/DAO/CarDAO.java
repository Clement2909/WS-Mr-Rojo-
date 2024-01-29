/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.back.wsrojo.DAO;

import com.back.wsrojo.connect.Postgres;
import com.back.wsrojo.model.Brand;
import com.back.wsrojo.model.Car;
import com.back.wsrojo.model.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Toavina Raza
 */
public class CarDAO {
    
    public static Car getByID(int id) throws Exception{
        Connection con = null;
        PreparedStatement stmt = null;
        Car c = new Car();
        String query = "Select * from car where id=?";
        try
        {
            con = Postgres.connect();
            stmt = con.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
              c.setId(rs.getInt("id"));
              c.setMatricule(rs.getString("matricule"));
              c.setAnneefabrication(rs.getInt("anneefabrication"));
              c.setKilometrage(rs.getInt("kilometrage"));
              c.setMoteur(rs.getString("moteur"));
              c.setTransmission(rs.getString("transmission"));
              c.setEtat(rs.getInt("etat"));
              c.setInfos(rs.getString("infos"));
              c.setId_brand(rs.getInt("id_brand;"));
              c.setId_category(rs.getInt("id_category"));
              c.setId_color(rs.getInt("id_color"));
                
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
    
    public static ArrayList<Car> getAll(Connection con) throws Exception{
        PreparedStatement stmt = null;
        ArrayList<Car> cars = new ArrayList<>();
        
        try
        {
            con = Postgres.connect();
            stmt = con.prepareStatement("Select * from car");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
              Car c = new Car();
              c.setId(rs.getInt("id"));
              c.setMatricule(rs.getString("matricule"));
              c.setAnneefabrication(rs.getInt("anneefabrication"));
              c.setKilometrage(rs.getInt("kilometrage"));
              c.setMoteur(rs.getString("moteur"));
              c.setTransmission(rs.getString("transmission"));
              c.setEtat(rs.getInt("etat"));
              c.setInfos(rs.getString("infos"));
              c.setId_brand(rs.getInt("id_brand;"));
              c.setId_category(rs.getInt("id_category"));
              c.setId_color(rs.getInt("id_color"));
              cars.add(c);
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
        return cars;
    }
    
    public static void save(Car c) throws Exception{
        Connection con = null;
        PreparedStatement stmt = null;
        try
        {
            con = Postgres.connect();
            stmt = con.prepareStatement("INSERT INTO car(matricule,anneefabrication,kilometrage,moteur,transmission,etat,infos,id_brand,id_category,id_color) values (?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, c.getMatricule());
            stmt.setInt(2, c.getAnneefabrication());
            stmt.setInt(3, c.getKilometrage());
            stmt.setString(4, c.getMoteur());
            stmt.setString(5, c.getTransmission());
            stmt.setInt(6, c.getEtat());
            stmt.setString(7, c.getInfos());
            stmt.setInt(8, c.getId_brand());
            stmt.setInt(9, c.getId_category());
            stmt.setInt(10, c.getId_color());
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
    
    public static void update(Car c) throws Exception{
        Connection con = null;
        PreparedStatement stmt = null;
        try
        {
            con = Postgres.connect();
            stmt = con.prepareStatement("UPDATE car set matricule=?,anneefabrication=?,kilometrage=?,moteur=?,transmission=?,etat=?,infos=?,id_brand=?,id_category=?,id_color=?, WHERE id=?");
            stmt.setString(1, c.getMatricule());
            stmt.setInt(2, c.getAnneefabrication());
            stmt.setInt(3, c.getKilometrage());
            stmt.setString(4, c.getMoteur());
            stmt.setString(5, c.getTransmission());
            stmt.setInt(6, c.getEtat());
            stmt.setString(7, c.getInfos());
            stmt.setInt(8, c.getId_brand());
            stmt.setInt(9, c.getId_category());
            stmt.setInt(10, c.getId_color());
            stmt.setInt(11, c.getId());

            // Execute the update statement
            int affectedRows = stmt.executeUpdate();

            // Check if any rows were affected
            if (affectedRows > 0) {
                System.out.println("Car updated successfully!");
            } else {
                System.out.println("No Car were updated.");
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
            stmt = con.prepareStatement("DELETE FROM car WHERE id = ?");
            stmt.setInt(1, id);

            // Execute the update statement
            int affectedRows = stmt.executeUpdate();

            // Check if any rows were affected
            if (affectedRows > 0) {
                System.out.println("Car deleted successfully!");
            } else {
                System.out.println("No Car were deleted.");
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
