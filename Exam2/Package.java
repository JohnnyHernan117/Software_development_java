/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.startpackagedeliverycenter;
import java.util.Random;

/**
 *
 * @author johnn
 */
public abstract class Package {
    static int packageIDCounter = 0;
    static Random randy = new Random(5);
    int priority;
    int packageArrivalTime;
    int startDeliveryTime;
    int deliveryDuration;
    int waitTime;
    int totalTime; 
    String packageID;
    DeliveryTruck deliveryTruck;
    
    public Package(int packageArrivalTime) {
        setPriority();
        setPackageID();
        setPackageArrivalTime(packageArrivalTime);
    }
    
    public int getPriority() { return priority; }
    public int getPackageArrivalTime() { return packageArrivalTime; }
    public int getStartDeliveryTime() { return startDeliveryTime; }
    public int getDeliveryDuration() { return deliveryDuration; }
    public int getWaitTime() { return waitTime; }
    public int getTotalTime() { return totalTime; }
    public int getDeliveryTruckIDNumber() {
        if (deliveryTruck != null) 
            return deliveryTruck.getDeliveryTruckIDNumber();
        else 
            return -1;
    }
    public void setPriority() { this.priority = randy.nextInt(1, 51); }
    public void setPackageArrivalTime(int arrivalTime) { this.packageArrivalTime = arrivalTime; }
    public void setDeliveryTruck(DeliveryTruck deliveryTruck) { this.deliveryTruck = deliveryTruck; }
    public void setTotalTime(int endTime) { this.totalTime = endTime - this.packageArrivalTime; }
    public void setDeliveryDuration(int duration) { this.deliveryDuration = duration; }  
    public void setStartDeliveryTime(int startTime) {
        this.startDeliveryTime = startTime;
        this.waitTime = startDeliveryTime - this.packageArrivalTime; 
    }
    public void setPackageID() {
        packageIDCounter++;
        this.packageID = "Package" + packageIDCounter; 
    }
    public abstract void setPackageSize();
    public abstract String getPackageSize();
    public String getPackageID() { return packageID; }
}
