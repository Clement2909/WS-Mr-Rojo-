/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.back.wsrojo.controller;

import com.back.wsrojo.DAO.CarDAO;
import com.back.wsrojo.model.Achat;
import com.back.wsrojo.model.Annonce;
import com.back.wsrojo.model.Car;
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
@RequestMapping("/car")
public class CarController {
    
    CarDAO carDAO;
    
    @GetMapping("{id}")
    public Car getByID(@PathVariable("id") int id)throws Exception
    {
        return carDAO.getByID(id);
    }
    
    @GetMapping
    public ArrayList<Car> getAll() throws Exception{
            return carDAO.getAll(null);
    }
    
    @PostMapping
    public String create(@RequestBody Car car) throws Exception{
        carDAO.save(car);
        return "Car Created Successfully";
    }
    
    @PutMapping
    public String update(@RequestBody Car car) throws Exception
    {
        carDAO.update(car);
        return "Car Updated Successfully";
    }   
    
    @DeleteMapping("{id}")
    public String delete(@PathVariable("id") int id) throws Exception
    {
        carDAO.delete(id);
        return "Car Deleted Successfully";
    }   
    
}
