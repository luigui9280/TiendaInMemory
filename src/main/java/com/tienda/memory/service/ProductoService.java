/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nayke
 */
package com.tienda.memory.service;

import com.tienda.memory.exception.ProductoNotFoundException;
import com.tienda.memory.model.Producto;
import com.tienda.memory.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {
    
     @Autowired
    private ProductoRepository repository;
    
    public List<Producto> getAllProductos() {
        return repository.findAll();
    }
    
    public Producto getProductoById(Long id) {
        Producto producto = repository.findById(id);
        if(producto == null) {
            throw new ProductoNotFoundException(id);
        }
        return producto;
    }
    
    public Producto createProducto(Producto producto) {
        return repository.save(producto);
    }
    
    public void deleteProducto(Long id) {
        repository.deleteById(id);
    }
}
