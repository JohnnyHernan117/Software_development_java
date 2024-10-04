/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bigbang;

import java.util.Scanner;
/**
 *
 * @author johnn
 */
public class BigBang {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        
        System.out.println("Please enter the name of the solar system: ");
        String solarSystemName = userInput.nextLine();
        
        System.out.println("Please enter the name of the sun: ");
        String sunName = userInput.nextLine();
        
        SolarSystem solarSystem = new SolarSystem(solarSystemName, sunName);
        System.out.println(solarSystem);
        
        if(solarSystem.getNumPlanets() > 1)
        {
            Planet firstPlanet = solarSystem.getPlanet(0);
            boolean foundMatch = false;
            
            for(int i = 1; i < solarSystem.getNumPlanets(); i++)
            {
                Planet otherPlanet = solarSystem.getPlanet(i);
                if(firstPlanet.equals(otherPlanet))
                {
                    System.out.println(otherPlanet.toString() + " equals the first planet in the ArrayList");
                    foundMatch = true;
                }
            }
            if(!foundMatch)
            {
                System.out.println("There is no planet that matches the first planet");
                
            }
            else
            {
                System.out.println("There are no planets to compare");
            }
        }
    }
}
