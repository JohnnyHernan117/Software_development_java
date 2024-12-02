/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.startpackagedeliverycenter;

/**
 *
 * @author johnn
 */
public class DeliveryTruck {
    private static int deliveryTruckIDCounter = 0;
    private int deliveryTruckIDNumber;
    private int totalPackagesDeliveredByDeliveryTruck;
    private int timeRemainingForCurrentPackageDelivery;
    private Package assignedPackage;
    
    public DeliveryTruck() {
        setDeliveryTruckIDNumber();
    }
    
    public int getDeliveryTruckIDNumber() { return deliveryTruckIDNumber; }
    public int getTotalPackagesDeliveredByDeliveryTruck() { return totalPackagesDeliveredByDeliveryTruck; }
    public int getTimeRemainingForCurrentPackageDelivery() { return timeRemainingForCurrentPackageDelivery; }
    public void setAssignedPackage(Package assignedPackage) { this.assignedPackage = assignedPackage; }
    public void setTimeRemainingForCurrentPackageDelivery(int time) { this.timeRemainingForCurrentPackageDelivery = time; }
    private void setDeliveryTruckIDNumber() {
        deliveryTruckIDCounter++;
        this.deliveryTruckIDNumber = deliveryTruckIDCounter;
    }
    public void decrementTimeRemainingForCurrentPackageDelivery() {
        if (this.timeRemainingForCurrentPackageDelivery > 0)
            this.timeRemainingForCurrentPackageDelivery--;
    }
    public Package removeAssignedPackage() {
        Package tempPackage = getAssignedPackage();
        setAssignedPackage(null);
        this.totalPackagesDeliveredByDeliveryTruck++;
        return tempPackage;
    }
    public Package getAssignedPackage() { return assignedPackage; }
    
    @Override
    public String toString() {
        return "Delivery Truck " + this.getDeliveryTruckIDNumber() + 
               " delivered " + this.getTotalPackagesDeliveredByDeliveryTruck() + " packages.";
    }
}
