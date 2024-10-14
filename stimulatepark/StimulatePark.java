/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.stimulatepark;

/**
 *
 * @author johnn
 */
import java.util.Scanner;

public class StimulatePark {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        
        System.out.print("Please enter the name of the Amusement Park: ");
        String parkName = keyboard.nextLine();
        
        System.out.print("Please enter the number of attractions (between 3 and 10, excluding 7): ");
        int numAttractions = keyboard.nextInt();
        
        while (numAttractions < 3 || numAttractions > 10 || numAttractions == 7) {
            System.out.print("Invalid number. Please enter again (between 3 and 10, excluding 7): ");
            numAttractions = keyboard.nextInt();
        }
        
        AmusementPark park = new AmusementPark(parkName, numAttractions);
        
        System.out.print("Please enter the duration of the simulation in minutes (minimum 60): ");
        int duration = keyboard.nextInt();
        
        while (duration < 60) {
            System.out.print("Invalid duration. Please enter again (minimum 60): ");
            duration = keyboard.nextInt();
        }
        
        park.runThePark(duration);
        
        System.out.print("Please enter the name of the output file: ");
        keyboard.nextLine();
        
        String outputFile = keyboard.nextLine();
        
        park.printParkStatistics(outputFile);
    }
}
