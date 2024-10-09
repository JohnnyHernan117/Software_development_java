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

public class Attraction {
    private static int attractionCounter = 0;
    private String attractionID;
    private int ratePerMinute;
    private ArrayList<NormalRider> alNormalLine;
    private ArrayList<FastRider> alFastLine;
    private ArrayList<Rider> alGotOnRide;
    
    public Attraction()
    {
        this.attractionID = "";
    }
    
    public Attraction(int ratePerMinute)
    {
        this.alFastLine = new ArrayList<>();
        this.alGotOnRide = new ArrayList<>();
        this.alNormalLine = new ArrayList<>();
        setRatePerMinute(ratePerMinute);
        setAttractionID();
    }
    
    public void setAttractionID() { this.attractionID =  "RIDE " + (++attractionCounter); }
    public void setRatePerMinute(int ratePerMinute) { this.ratePerMinute = ratePerMinute; }
    public void addRiderNormalLine(NormalRider rider) { alNormalLine.add(rider); }
    public void addRiderFastLine(FastRider rider) { alFastLine.add(rider); }
    public void addGotOnRide(Rider rider) { alGotOnRide.add(rider); }
    
    public void processRider(int minute)
    {
        int toBeProcessed = getRatePerMinute();
        
        while(toBeProcessed > 0)
        {
            if(!alFastLine.isEmpty() && toBeProcessed % 3 != 0 || !alNormalLine.isEmpty())
            {
                FastRider fastRider = removeRiderFastLine();
                if(fastRider != null)
                {
                    fastRider.setEndOnlineTime(minute);
                    addGotOnRide(fastRider);
                }
                --toBeProcessed;
            }
            else if (!alNormalLine.isEmpty())
            {
                NormalRider normalRider = removeRiderNormalLine();
                if(normalRider != null)
                {
                    normalRider.setEndOnlineTime(minute);
                    addGotOnRide(normalRider);
                }
                
                --toBeProcessed;
            }
        }
    }
    
    
    public int getRatePerMinute() { return ratePerMinute; }
    public int getAlNormalLineSize() { return alNormalLine.size(); }
    public int getAlFastLineSize() { return alFastLine.size(); }
    public int getAlGotOnRideSize() { return alGotOnRide.size(); }
    
    public String getAttractionID() { return attractionID; }
 
    public NormalRider removeRiderNormalLine()
    {
        if(!alNormalLine.isEmpty())
            return alNormalLine.remove(0);
        return null;
    }
    
    public FastRider removeRiderFastLine()
    {
        if(!alFastLine.isEmpty())
            return alFastLine.remove(0);
        return null;
    }
    
    public Rider getGotOnRide(int index) 
    {
        if(index < 0 || index > getAlGotOnRideSize())
            return alGotOnRide.get(index);
        return null;            
    }
}
