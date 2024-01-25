/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.back.wsrojo.controller;

import com.back.wsrojo.DAO.CommissionDAO;
import com.back.wsrojo.model.Achat;
import com.back.wsrojo.model.Color;
import com.back.wsrojo.model.Commission;
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
@RequestMapping("/commission")
public class CommissionController {
    
    CommissionDAO commissionDAO;
    
    @GetMapping("{id}")
    public Commission getByID(@PathVariable("id") int id)throws Exception
    {
        return commissionDAO.getByID(id);
    }
    
    @GetMapping
    public ArrayList<Commission> getAll() throws Exception{
            return commissionDAO.getAll(null);
    }
    
    @PostMapping
    public String create(@RequestBody Commission commission) throws Exception{
        commissionDAO.save(commission);
        return "Commission Created Successfully";
    }
    
    @PutMapping
    public String update(@RequestBody Commission commission) throws Exception
    {
        commissionDAO.update(commission);
        return "Commission Updated Successfully";
    }   
    
    @DeleteMapping("{id}")
    public String delete(@PathVariable("id") int id) throws Exception
    {
        commissionDAO.delete(id);
        return "Commission Deleted Successfully";
    }   
}
