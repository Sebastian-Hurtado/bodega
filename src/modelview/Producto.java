/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelview;

import java.util.Date;

/**
 *
 * @author Sebas
 */
public abstract class Producto {
    protected String name;
    protected Double price; 
    protected int stock;
    
    
    public Producto(String name,Double price,int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        
        
    }
}
