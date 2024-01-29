/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.back.wsrojo.controller;

import com.back.wsrojo.DAO.AchatDAO;
import com.back.wsrojo.model.Achat;
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
@RequestMapping("/achat")
public class AchatController {
    
    AchatDAO achatDAO;

    @GetMapping("{id}")
    public Achat getByID(@PathVariable("id") int id)throws Exception
    {
        return achatDAO.getByID(id);
    }
    
    @GetMapping
    public ArrayList<Achat> getAll() throws Exception{
            return achatDAO.getAll(null);
    }
    
    @PostMapping
    public String create(@RequestBody Achat achat) throws Exception{
        achatDAO.save(achat);
        return "Achat Created Successfully";
    }
    
    @PutMapping
    public String update(@RequestBody Achat achat) throws Exception
    {
        achatDAO.update(achat);
        return "Achat Updated Successfully";
    }   
    
    @DeleteMapping("{id}")
    public String delete(@PathVariable("id") int id) throws Exception
    {
        achatDAO.delete(id);
        return "Achat Deleted Successfully";
    }   
}
