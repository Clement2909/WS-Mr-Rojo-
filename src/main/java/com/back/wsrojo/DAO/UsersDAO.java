/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.back.wsrojo.DAO;

import com.back.wsrojo.connect.Postgres;
import com.back.wsrojo.model.Brand;
import com.back.wsrojo.model.Magasin;
import com.back.wsrojo.model.Users;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Toavina Raza
 */
public class UsersDAO {
    
    public static Users getByID(int id) throws Exception{
        Connection con = null;
        PreparedStatement stmt = null;
        Users u = new Users();
        String query = "Select * from users where id=?";
        try
        {
            con = Postgres.connect();
            stmt = con.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
              u.setId(rs.getInt("id"));
              u.setLogin(rs.getString("login"));
              u.setPwd(rs.getString("pwd"));
                
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
        return u;
    }
    
    public static ArrayList<Users> getAll(Connection con) throws Exception{
        PreparedStatement stmt = null;
        ArrayList<Users> users = new ArrayList<>();
        
        try
        {
            con = Postgres.connect();
            stmt = con.prepareStatement("Select * from users");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
              Users u = new Users();
              u.setId(rs.getInt("id"));
              u.setLogin(rs.getString("login"));
              u.setPwd(rs.getString("pwd"));
              users.add(u);
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
        return users;
    }
    
    public static void save(Users u) throws Exception{
        Connection con = null;
        PreparedStatement stmt = null;
        try
        {
            con = Postgres.connect();
            stmt = con.prepareStatement("INSERT INTO users(login,pwd) values (?,?)");
            stmt.setString(1, u.getLogin());
            stmt.setString(2, u.getPwd());
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
    
    public static void update(Users u) throws Exception{
        Connection con = null;
        PreparedStatement stmt = null;
        try
        {
            con = Postgres.connect();
            stmt = con.prepareStatement("UPDATE users set login=?,pwd=? WHERE id=?");
            stmt.setString(1, u.getLogin());
            stmt.setString(2, u.getPwd());
            stmt.setInt(3, u.getId());

            // Execute the update statement
            int affectedRows = stmt.executeUpdate();

            // Check if any rows were affected
            if (affectedRows > 0) {
                System.out.println("Users updated successfully!");
            } else {
                System.out.println("No Users were updated.");
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
            stmt = con.prepareStatement("DELETE FROM users WHERE id = ?");
            stmt.setInt(1, id);

            // Execute the update statement
            int affectedRows = stmt.executeUpdate();

            // Check if any rows were affected
            if (affectedRows > 0) {
                System.out.println("User deleted successfully!");
            } else {
                System.out.println("No User were deleted.");
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
