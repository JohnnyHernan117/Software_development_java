/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.wildcardtester;
/**
 *
 * @author johnn
 */
public class Pet {
    private String name;
    
    public Pet(String name)
    {
        setName(name);
    }
    
    public void setName(String name) { this.name = name; }
    public String getName() { return name; }
    
    @Override
    public String toString()
    {
        return getName();
    }
}
