/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.startpackagedeliverycenter;

/**
 *
 * @author johnn
 */
public class SmallPackage extends Package{
    private String packageSize;
    
    public SmallPackage(int arrivalTime) {
        super(arrivalTime);
        setPackageSize();
    }
    
    @Override
    public String getPackageSize() {
        return this.packageSize;
    }
    @Override
    public void setPackageSize() {
        this.packageSize = "Small";
    }
    @Override
    public String toString() {
        return "The Small size package with priority " + this.getPriority() + 
               " with ID " + this.getPackageID() + " waited " + this.getWaitTime() + 
               " minutes before start of delivery.";
    }
}
