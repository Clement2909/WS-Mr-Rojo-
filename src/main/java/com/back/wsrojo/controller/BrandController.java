/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.back.wsrojo.controller;

import com.back.wsrojo.DAO.BrandDAO;
import com.back.wsrojo.model.Achat;
import com.back.wsrojo.model.Annonce;
import com.back.wsrojo.model.Brand;
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
@RequestMapping("/brand")
public class BrandController {
    
    BrandDAO brandDAO;
    
    @GetMapping("{id}")
    public Brand getByID(@PathVariable("id") int id)throws Exception
    {
        return brandDAO.getByID(id);
    }
    
    @GetMapping
    public ArrayList<Brand> getAll() throws Exception{
            return brandDAO.getAll(null);
    }
    
    @PostMapping
    public String create(@RequestBody Brand brand) throws Exception{
        brandDAO.save(brand);
        return "Brand Created Successfully";
    }
    
    @PutMapping
    public String update(@RequestBody Brand brand) throws Exception
    {
        brandDAO.update(brand);
        return "Brand Updated Successfully";
    }   
    
    @DeleteMapping("{id}")
    public String delete(@PathVariable("id") int id) throws Exception
    {
        brandDAO.delete(id);
        return "Brand Deleted Successfully";
    }   
}
