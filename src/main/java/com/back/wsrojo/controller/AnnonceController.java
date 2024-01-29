/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.back.wsrojo.controller;

import com.back.wsrojo.DAO.AnnonceDAO;
import com.back.wsrojo.model.Achat;
import com.back.wsrojo.model.Annonce;
import com.back.wsrojo.model.Color;
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
@RequestMapping("/annonce")
public class AnnonceController {
    
    AnnonceDAO annonceDAO;
    
    @GetMapping("{id}")
    public Annonce getByID(@PathVariable("id") int id)throws Exception
    {
        return annonceDAO.getByID(id);
    }
    
    @GetMapping
    public ArrayList<Annonce> getAll() throws Exception{
            return annonceDAO.getAll(null);
    }
    
    @PostMapping
    public String create(@RequestBody Annonce annonce) throws Exception{
        annonceDAO.save(annonce);
        return "Annonce Created Successfully";
    }
    
    @PutMapping
    public String update(@RequestBody Annonce annonce) throws Exception
    {
        annonceDAO.update(annonce);
        return "Annonce Updated Successfully";
    }   
    
    @DeleteMapping("{id}")
    public String delete(@PathVariable("id") int id) throws Exception
    {
        annonceDAO.delete(id);
        return "Annonce Deleted Successfully";
    }   
}
