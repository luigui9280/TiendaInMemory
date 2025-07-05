/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nayke
 */
package com.tienda.memory.controller;

import com.tienda.memory.model.Producto;
import com.tienda.memory.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    @Autowired
    private ProductoService productoService;
    
    @GetMapping
    public List<Producto> getAllProductos() {
        return productoService.getAllProductos();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable Long id) {
        return ResponseEntity.ok(productoService.getProductoById(id));
    }
    
    @PostMapping
    public ResponseEntity<Producto> createProducto(@RequestBody Producto producto) {
        return new ResponseEntity<>(
            productoService.createProducto(producto), 
            HttpStatus.CREATED
        );
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProducto(@PathVariable Long id) {
        productoService.deleteProducto(id);
        return ResponseEntity.noContent().build();
    }
}
