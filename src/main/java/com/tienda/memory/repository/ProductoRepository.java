/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nayke
 */

package com.tienda.memory.repository;

import com.tienda.memory.model.Producto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ProductoRepository {
       private final List<Producto> productos = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong(1);
    
    public ProductoRepository() {
        // Datos de ejemplo al iniciar
        save(new Producto(null, "Laptop", "Tecnología", 1200.99));
        save(new Producto(null, "Smartphone", "Tecnología", 799.50));
    }
    
    public Producto save(Producto producto) {
        if(producto.getId() == null) {
            producto.setId(counter.getAndIncrement());
        }
        productos.add(producto);
        return producto;
    }
    
    public List<Producto> findAll() {
        return new ArrayList<>(productos);
    }
    
    public Producto findById(Long id) {
        return productos.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
    
    public void deleteById(Long id) {
        productos.removeIf(p -> p.getId().equals(id));
    }
}
