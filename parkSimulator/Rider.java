/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.stimulatepark;

/**
 *
 * @author johnn
 */
 abstract class Rider {
    private int startOnlineTime;
    private int endOnlineTime;
    private int timeOnLine;
    
    public Rider(){}
    
    public Rider(int startOnlineTime)
    {
        setStartOnlineTime(startOnlineTime);
    }
    
    public int getStartOnlineTime() { return startOnlineTime; }
    public int getEndOnlineTime() { return endOnlineTime; }
    public int getTimeOnLine() { return timeOnLine; }
    public void setStartOnlineTime(int startOnlineTime) { this.startOnlineTime = startOnlineTime; }
    public void setEndOnlineTime(int endOnlineTime) 
    { 
        this.endOnlineTime = endOnlineTime; 
        this.timeOnLine = endOnlineTime - startOnlineTime;
    }
    
    public abstract void setTotalGate();
}
