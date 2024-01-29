/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.back.wsrojo.controller;

import com.back.wsrojo.DAO.ColorDAO;
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
@RequestMapping("/color")
public class ColorController {
    
    ColorDAO colorDAO;
    
    @GetMapping("{id}")
    public Color getByID(@PathVariable("id") int id)throws Exception
    {
        return colorDAO.getByID(id);
    }
    
    @GetMapping
    public ArrayList<Color> getAll() throws Exception{
            return colorDAO.getAll(null);
    }
    
    @PostMapping
    public String create(@RequestBody Color color) throws Exception{
        colorDAO.save(color);
        return "Color Created Successfully";
    }
    
    @PutMapping
    public String update(@RequestBody Color color) throws Exception
    {
        colorDAO.update(color);
        return "Color Updated Successfully";
    }   
    
    @DeleteMapping("{id}")
    public String delete(@PathVariable("id") int id) throws Exception
    {
        colorDAO.delete(id);
        return "Color Deleted Successfully";
    }   
    
}
