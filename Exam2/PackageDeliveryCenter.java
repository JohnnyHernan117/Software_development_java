/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.startpackagedeliverycenter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Random;
import java.io.PrintWriter;

/**
 *
 * @author johnn
 */
public class PackageDeliveryCenter {
    private Random randyX;
    private PriorityQueue<Package> pkgWaitingQ;
    private ArrayList<DeliveryTruck> deliveryTruckAvailableList;
    private ArrayList<DeliveryTruck> deliveryTruckBusyList;
    private ArrayList<Package> deliveredPackages;
    private String delivCenterName;
    private int currentTime = 0;
    
    public PackageDeliveryCenter(String name, int seed) {
        this.delivCenterName = name;
        this.randyX = new Random(seed);
        this.pkgWaitingQ = new PriorityQueue<>(new PackagePriority());
        this.deliveryTruckAvailableList = new ArrayList<>();
        this.deliveryTruckBusyList = new ArrayList<>();
        this.deliveredPackages = new ArrayList<>();
        this.currentTime = 0;
    }
    
    public void initializePackageDeliveryCenter(int numDeliveryTrucks) {
        for (int i = 0; i < numDeliveryTrucks; i++) {
            DeliveryTruck truck = new DeliveryTruck();
            deliveryTruckAvailableList.add(truck);
        }
        for (int i = 0; i < 15; i++) {
            int randGen = randyX.nextInt(1, 11);
            if (randGen <= 5)
                pkgWaitingQ.add(new SmallPackage(currentTime));
             else if (randGen <= 9) 
                pkgWaitingQ.add(new MediumPackage(currentTime));
             else 
                pkgWaitingQ.add(new LargePackage(currentTime));
        }
        this.currentTime = 1;
    }
        
    public void operatePackageDeliveryCenter(int durationOfModelArrivals) {
        int randGen;
        int deliveryDuration;
        int endArrivalsTime = currentTime + durationOfModelArrivals;
        Package tempPackage;
        DeliveryTruck tempDeliveryTruck;
        
        while (deliveredPackages.size() != Package.packageIDCounter || currentTime < endArrivalsTime) {
            if (currentTime < endArrivalsTime) {
                for (int i = 0; i < 5; i++) {
                    randGen = randyX.nextInt(1, 11);
                    if (randGen <= 4) 
                        pkgWaitingQ.add(new SmallPackage(currentTime));
                     else if (randGen <= 8) 
                        pkgWaitingQ.add(new MediumPackage(currentTime));
                     else 
                        pkgWaitingQ.add(new LargePackage(currentTime));
                }
            }
            for (int i = 0; i < deliveryTruckBusyList.size(); i++) {
                tempDeliveryTruck = deliveryTruckBusyList.get(i);
                tempDeliveryTruck.decrementTimeRemainingForCurrentPackageDelivery();
                if (tempDeliveryTruck.getTimeRemainingForCurrentPackageDelivery() == 0) {
                    tempPackage = tempDeliveryTruck.getAssignedPackage();
                    deliveredPackages.add(tempPackage);
                    tempPackage.setTotalTime(currentTime);
                    tempDeliveryTruck.removeAssignedPackage();
                    deliveryTruckBusyList.remove(i);
                    deliveryTruckAvailableList.add(tempDeliveryTruck);
                    i--;
                }
            }
            while (!deliveryTruckAvailableList.isEmpty() && !pkgWaitingQ.isEmpty()) {
                tempPackage = pkgWaitingQ.poll();
                tempPackage.setStartDeliveryTime(currentTime);
                    
                tempDeliveryTruck = deliveryTruckAvailableList.remove(0);
                deliveryTruckBusyList.add(tempDeliveryTruck);
                tempDeliveryTruck.setAssignedPackage(tempPackage);
                tempPackage.setDeliveryTruck(tempDeliveryTruck);
                    
                if (tempPackage instanceof SmallPackage)
                    deliveryDuration = randyX.nextInt(10, 16);
                else if (tempPackage instanceof MediumPackage)
                    deliveryDuration = randyX.nextInt(20, 31); 
                else 
                    deliveryDuration = randyX.nextInt(25, 41);
                
                tempPackage.setDeliveryDuration(deliveryDuration);
                tempDeliveryTruck.setTimeRemainingForCurrentPackageDelivery(deliveryDuration);
            }
            currentTime++;
        }
    }
     public void generatePackageDeliveryCenterResults(String outputFileName) throws Exception {
        PrintWriter writer = null; 
        
        try{
            
            writer = new PrintWriter(outputFileName);
            writer.println("Data For Package Delivery Center " + delivCenterName);
            writer.println("\nSummary Data by DeliveryTruck");
            
            for (DeliveryTruck truck : deliveryTruckAvailableList) {
                writer.println("Delivery Truck " + truck.getDeliveryTruckIDNumber() + " delivered " + truck.getTotalPackagesDeliveredByDeliveryTruck() + " packages");
            }
            
            double smallAvgTime = 0, mediumAvgTime = 0, largeAvgTime = 0, totalAvgTime = 0;
            int smallCount = 0, mediumCount = 0, largeCount = 0;
            
            for (Package p : deliveredPackages) {
                totalAvgTime += p.getTotalTime();
            if (p instanceof SmallPackage) {
                smallAvgTime += p.getTotalTime();
                smallCount++;
            } else if (p instanceof MediumPackage) {
                mediumAvgTime += p.getTotalTime();
                mediumCount++;
            } else if (p instanceof LargePackage) {
                largeAvgTime += p.getTotalTime();
                largeCount++;
            }
        }

        smallAvgTime /= smallCount;
        mediumAvgTime /= mediumCount;
        largeAvgTime /= largeCount;
        totalAvgTime /= deliveredPackages.size();

        writer.println("\nAverage Delivery Times");
        writer.println("The average total time for " + smallCount + " Small Packages is " + String.format("%.2f", smallAvgTime) + " minutes");
        writer.println("The average total time for " + mediumCount + " Medium Packages is " + String.format("%.2f", mediumAvgTime) + " minutes");
        writer.println("The average total time for " + largeCount + " Large Packages is " + String.format("%.2f", largeAvgTime) + " minutes");
        writer.println("The average total time for " + deliveredPackages.size() + " Total Package is " + String.format("%.2f", totalAvgTime) + " minutes");
        
        writer.println("\nDetailed Data On Package Delivery\n");
        writer.printf("%-15s%-10s%-20s%-10s%-15s%-15s%-20s%-15s%-15s\n", "PACKAGE ID", "PRIORITY", "DELIVERY TRUCK ID", "SIZE", "ARRIVAL TIME", "WAIT TIME", "START DELIVERY TIME", "DELIVERY DURATION", "TOTAL TIME");
        for (Package p : deliveredPackages) {
            writer.printf("%-15s%-10d%-20d%-10s%-15d%-15d%-20d%-15d%-15d\n", 
                          p.getPackageID(), 
                          p.getPriority(), 
                          p.getDeliveryTruckIDNumber(), 
                          p.getPackageSize(), 
                          p.getPackageArrivalTime(), 
                          p.getWaitTime(), 
                          p.getStartDeliveryTime(), 
                          p.getDeliveryDuration(),
                          p.getTotalTime());
        }

        } catch (Exception e) {
            System.err.println("An error occurred while generating the report: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }
}
