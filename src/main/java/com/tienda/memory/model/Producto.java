/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nayke
 */
package com.tienda.memory.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Producto {
     private Long id;
    private String nombre;
    private String categoria;
    private double precio;
    
    // Constructor sin argumentos (necesario para Spring)
    public Producto() {}
}
