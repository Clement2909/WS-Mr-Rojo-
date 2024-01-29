/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.back.wsrojo.controller;

import com.back.wsrojo.DAO.UsersDAO;
import com.back.wsrojo.model.Achat;
import com.back.wsrojo.model.Color;
import com.back.wsrojo.model.Commission;
import com.back.wsrojo.model.Users;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Toavina Raza
 */
@RestController
@RequestMapping("/users")
public class UsersController {
    
    UsersDAO usersDAO;
    
    @GetMapping("{id}")
    public Users getByID(@PathVariable("id") int id)throws Exception
    {
        return usersDAO.getByID(id);
    }
    
    @GetMapping
    public ArrayList<Users> getAll() throws Exception{
            return usersDAO.getAll(null);
    }
    
    @PostMapping
    public String create(@RequestBody Users users) throws Exception{
        usersDAO.save(users);
        return "Users Created Successfully";
    }
    
    @PutMapping
    public String update(@RequestBody Users user) throws Exception
    {
        usersDAO.update(user);
        return "User Updated Successfully";
    }   
    
    @DeleteMapping("{id}")
    public String delete(@PathVariable("id") int id) throws Exception
    {
        usersDAO.delete(id);
        return "User Deleted Successfully";
    }   

}
