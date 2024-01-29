/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.back.wsrojo.controller;

import com.back.wsrojo.DAO.CategoryDAO;
import com.back.wsrojo.model.Achat;
import com.back.wsrojo.model.Car;
import com.back.wsrojo.model.Category;
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
@RequestMapping("/category")
public class CategoryController {
    
    CategoryDAO categoryDAO;
    
    @GetMapping("{id}")
    public Category getByID(@PathVariable("id") int id)throws Exception
    {
        return categoryDAO.getByID(id);
    }
    
    @GetMapping
    public ArrayList<Category> getAll() throws Exception{
            return categoryDAO.getAll(null);
    }
    
    @PostMapping
    public String create(@RequestBody Category category) throws Exception{
        categoryDAO.save(category);
        return "Category Created Successfully";
    }
    
    @PutMapping
    public String update(@RequestBody Category category) throws Exception
    {
        categoryDAO.update(category);
        return "Category Updated Successfully";
    }   
    
    @DeleteMapping("{id}")
    public String delete(@PathVariable("id") int id) throws Exception
    {
        categoryDAO.delete(id);
        return "Category Deleted Successfully";
    }   
    
}
