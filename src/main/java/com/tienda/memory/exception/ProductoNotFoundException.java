/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nayke
 */
package com.tienda.memory.exception;

public class ProductoNotFoundException extends RuntimeException {
    
    public ProductoNotFoundException(Long id) {
        super("No se encontró el producto con ID: " + id);
    }
}