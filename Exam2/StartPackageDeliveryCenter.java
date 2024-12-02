/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.startpackagedeliverycenter;
import java.util.Scanner;

/**
 *
 * @author johnn
 */
public class StartPackageDeliveryCenter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Please enter the name of the Package Delivery Center: ");
            String pdcName = scanner.nextLine();
  
            System.out.print("Please enter a seed value as an int: ");
            int seed = scanner.nextInt();
 
            PackageDeliveryCenter pdc = new PackageDeliveryCenter(pdcName, seed);
 
            System.out.print("Please enter the number of Delivery Trucks as an int: ");
            int numDeliveryTrucks = scanner.nextInt();
  
            pdc.initializePackageDeliveryCenter(numDeliveryTrucks);
            
            System.out.print("Please enter the number of minutes to keep Package Delivery Center operating for newly arriving Packages: ");
            int minutes = scanner.nextInt();
   
            pdc.operatePackageDeliveryCenter(minutes);
 
            System.out.print("Please enter the name of the output file: ");
            scanner.nextLine();
            String outputFileName = scanner.nextLine();
 
            pdc.generatePackageDeliveryCenterResults(outputFileName);

            System.out.println("Simulation completed successfully. Results have been saved to " + outputFileName);

        } catch (Exception e) {  
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally { 
            scanner.close();
        }
    }
}
