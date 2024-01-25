/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.back.wsrojo.controller;

import com.back.wsrojo.DAO.MagasinDAO;
import com.back.wsrojo.model.Achat;
import com.back.wsrojo.model.Color;
import com.back.wsrojo.model.Commission;
import com.back.wsrojo.model.Magasin;
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
@RequestMapping("/magasin")
public class MagasinController {
    
    MagasinDAO magasinDAO;
    
    @GetMapping("{id}")
    public Magasin getByID(@PathVariable("id") int id)throws Exception
    {
        return magasinDAO.getByID(id);
    }
    
    @GetMapping
    public ArrayList<Magasin> getAll() throws Exception{
            return magasinDAO.getAll(null);
    }
    
    @PostMapping
    public String create(@RequestBody Magasin magasin) throws Exception{
        magasinDAO.save(magasin);
        return "Magasin Created Successfully";
    }
    
    @PutMapping
    public String update(@RequestBody Magasin magasin) throws Exception
    {
        magasinDAO.update(magasin);
        return "Magasin Updated Successfully";
    }   
    
    @DeleteMapping("{id}")
    public String delete(@PathVariable("id") int id) throws Exception
    {
        magasinDAO.delete(id);
        return "Magasin Deleted Successfully";
    }   
}
