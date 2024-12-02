/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.startpackagedeliverycenter;
import java.util.Comparator;

/**
 *
 * @author johnn
 */
public class PackagePriority implements Comparator<Package>{
    
    @Override
    public int compare(Package p1, Package p2) {
        
        int sizeComparison = p1.getPackageSize().compareTo(p2.getPackageSize());
        if (sizeComparison != 0)
            return -sizeComparison; 
        
        if (p1.getPriority() != p2.getPriority()) 
            return p1.getPriority() - p2.getPriority();
        
        return p1.getPackageArrivalTime() - p2.getPackageArrivalTime();
    }
}
