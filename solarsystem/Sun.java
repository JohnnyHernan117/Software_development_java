/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.solarsystem;

import java.util.Random;

/**
 *
 * @author johnn
 */
public class Sun {
    private String sunName;
    private int sunAge;
    private Random randy = new Random(12);;
    
    public Sun()
    {
        setSunName("Unknown");
        setSunAge(randy.nextInt(1000000001) + (1000000000));
    }
    
    public Sun(String name)
    {
        setSunName(name);
        setSunAge(randy.nextInt(1000000001) + (1000000000));
    }
    
    public void setSunName(String name) { this.sunName = name; }
    public void setSunAge(int age) { this.sunAge = age; }
    public int getSunAge(){ return sunAge; }  
    public String getSunName() { return sunName; }
    
    @Override
    public String toString(){ return "The sun named " + getSunName() + " is " + getSunAge() + " years old"; }
    
}
