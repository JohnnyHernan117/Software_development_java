/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.stimulatepark;

/**
 *
 * @author johnn
 */
import java.util.ArrayList;
import java.util.Random;
import java.io.PrintWriter;
import java.io.IOException;

public class AmusementPark {
    private String parkName;
    private int numAttraction;
    private ArrayList<Attraction> alAttraction;
    
    public AmusementPark()
    {
        setParkName("");
    }
    
    public AmusementPark(String name, int numAttraction)
    {
        this.alAttraction = new ArrayList<>();
        setParkName(name);
        setNumAttraction(numAttraction);
        createAttraction(numAttraction);
    }
    
    public void setParkName(String name) { this.parkName = name; }
    public void setNumAttraction(int numAttraction) { this.numAttraction = numAttraction; }
    public void createAttraction(int numAttraction)
    {
        Random randy = new Random(9);
        for(int i = 0; i < numAttraction; ++i)
        {
            int ratePerMinute = 10 + randy.nextInt(10);//22 and 14
            alAttraction.add(new Attraction(ratePerMinute));
        }
    }

    public void runThePark(int duration)
    {
        Random randyX = new Random(17);
        int initialRider = 31 * (randyX.nextInt(10) + 5);
        
        for(int j = 0; j < initialRider; ++j)
        {
            int attractionIndex = randyX.nextInt(numAttraction);
            Attraction attraction = alAttraction.get(attractionIndex);
            if(j % 7 <= 3)
            {
                attraction.addRiderFastLine(new FastRider(0));
                 System.out.println("Added fast rider to attraction " + attraction.getAttractionID());
            }
            else
            {
                attraction.addRiderNormalLine(new NormalRider(0));
                System.out.println("Added normal rider to attraction " + attraction.getAttractionID());
            }
        }
        for(int minute =  1; minute <= duration; ++minute)
        {
            int newRider = 55 * (randyX.nextInt(10) + 5);
            for(int j = 0; j < initialRider; ++j)
            {
                int attractionIndex = randyX.nextInt(numAttraction);
                Attraction attraction = alAttraction.get(attractionIndex);
                if(j % 7 <= 3)
                {
                    attraction.addRiderFastLine(new FastRider(minute));
                    System.out.println("Added fast rider to attraction " + attraction.getAttractionID() + " at minute " + minute);
                }
                else
                {
                    attraction.addRiderNormalLine(new NormalRider(minute));
                    System.out.println("Added normal rider to attraction " + attraction.getAttractionID() + " at minute " + minute);
                }
            }
            for(Attraction attraction : alAttraction)
            {
                attraction.processRider(minute);
            }
        }
    }
    
    public void printParkStatistics(String fileName)
    {
        try
        {
            PrintWriter writer = new PrintWriter(fileName);
            writer.printf("The Statistics for %s\n\n", parkName);

            writer.printf("The Total Gate for Fast Riders is %.2f\n", FastRider.getTotalGate());
            writer.printf("The Total Gate for Normal Riders is %.2f\n\n", NormalRider.getTotalGate());
            
            for(Attraction attraction : alAttraction)
            {
                writer.printf("The Number Of Fast Riders Still On Line For %s is %d\n", attraction.getAttractionID(), attraction.getAlFastLineSize());
                writer.printf("The Number Of Normal Riders Still On Line For %s is %d\n", attraction.getAttractionID(), attraction.getAlNormalLineSize());
            }
            writer.close();
        }
        catch(IOException e)
        {
            System.out.println("Error writing to file: " + fileName);
        }
    }
    
    public String getParkName() { return parkName; }
    public int getNumAttraction() { return numAttraction; }
}
