/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bigbang;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author johnn
 */
public class SolarSystem {
    private String solSystemName;
    private Sun sol;
    private ArrayList<Planet> planetList;
    
    public SolarSystem()
    {
        setSolarSystemName("Unknown");
        sol = new Sun();
        planetList = new ArrayList<>();
    }
    
    public SolarSystem(String solarSystemName, String sunName)
    {
        setSolarSystemName(solarSystemName);
        sol = new Sun(sunName);
        planetList = new ArrayList<>();
        createPlanet();
    }
    
    public void setSolarSystemName(String name){ this.solSystemName = name; }
    public String getSolarSystemName(){ return solSystemName; }
    
    @Override
    public String toString()
    {
        StringBuilder result = new StringBuilder("The name of this solar system is " + getSolarSystemName() + "\n" + sol.toString() + "\n");
        for(Planet planet : planetList)
        {
            result.append(planet.toString()).append("\n");
        }
        return result.toString();
    }
    
    public void createPlanet()
    {
        Scanner userInput = new Scanner(System.in);
        System.out.print("Please enter file to read inplanet list from: ");
        String inputFileName = userInput.nextLine();
        
        try
        {
            Scanner inputFile = new Scanner(new File(inputFileName));
            while(inputFile.hasNextLine())
            {
                String planetName = inputFile.nextLine();
                Planet planet = new Planet(planetName);
                planetList.add(planet);
            }
            inputFile.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found");
        }
    }
    
    public int getNumPlanets(){ return planetList.size(); }
    
    public Planet getPlanet(int index)
    {
        if(index < 0 || index >= planetList.size())
        {
            System.out.println("Planet doesn't exist");
            return null;
        }
        return planetList.get(index);
    }
}
