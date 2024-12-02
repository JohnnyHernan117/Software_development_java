/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.startpackagedeliverycenter;

/**
 *
 * @author johnn
 */
public class LargePackage extends Package{
    private String packageSize;
    
    public LargePackage(int arrivalTime) {
        super(arrivalTime);
        setPackageSize();
    }
    
    @Override
    public void setPackageSize() { this.packageSize = "Large"; }
    @Override
    public String getPackageSize() { return this.packageSize; }
    
    @Override
    public String toString() {
        return "The Large size package with priority " + this.getPriority() + 
               " with ID " + this.getPackageID() + " waited " + this.getWaitTime()+ 
               " minutes before start of delivery.";
    }
}
