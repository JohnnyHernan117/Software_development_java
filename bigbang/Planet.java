/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bigbang;

import java.util.Random;
/**
 *
 * @author johnn
 */
public class Planet {
    private static Random randyPlanet = new Random(9);
    private String planetName;
    private int planetTons;
    
    public Planet()
    {
        setPlanetName("Unknown");
        setPlanetTons(randyPlanet.nextInt(70000001) + 10000000);
    }
    
    public Planet(String name)
    {
        setPlanetName(name);
        setPlanetTons(randyPlanet.nextInt(70000001) + 10000000);
    }
    
    public void setPlanetName(String name){ this.planetName = name; }
    public void setPlanetTons(int tons){ this.planetTons = tons; }
    public int getPlanetTons(){ return planetTons; }
    public String getPlanetName(){ return planetName; }
    
    @Override
    public String toString(){ return "The planet named " + getPlanetName() + " weighs " + getPlanetTons() + " tons."; }
    
    @Override
    public boolean equals(Object obj)
    {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        
        Planet other = (Planet) obj;
        return planetTons == other.planetTons && planetName.equals(other.planetName);
    }
}
