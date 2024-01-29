/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.back.wsrojo.controller;

import com.back.wsrojo.DAO.VenduDAO;
import com.back.wsrojo.model.Achat;
import com.back.wsrojo.model.Color;
import com.back.wsrojo.model.Vendu;
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
@RequestMapping("/vendu")
public class VenduController {
    
    VenduDAO venduDAO;
    
    @GetMapping("{id}")
    public Vendu getByID(@PathVariable("id") int id)throws Exception
    {
        return venduDAO.getByID(id);
    }
    
    @GetMapping
    public ArrayList<Vendu> getAll() throws Exception{
            return venduDAO.getAll(null);
    }
    
    @PostMapping
    public String create(@RequestBody Vendu vendu) throws Exception{
        venduDAO.save(vendu);
        return "Vendu Created Successfully";
    }
    
    @PutMapping
    public String update(@RequestBody Vendu vendu) throws Exception
    {
        venduDAO.update(vendu);
        return "Vendu Updated Successfully";
    }   
    
    @DeleteMapping("{id}")
    public String delete(@PathVariable("id") int id) throws Exception
    {
        venduDAO.delete(id);
        return "Vendu Deleted Successfully";
    }   
}
