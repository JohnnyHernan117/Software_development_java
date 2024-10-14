/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.testrectanglez;
/**
 *
 * @author johnn
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TestRectangleZ {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        ArrayList<RectangleZ> myRect = new ArrayList<>();
        
        System.out.println("Please enter a seed for the Random Number:");
        int seed = keyboard.nextInt();
        
        Random randy = new Random(seed);
        
        RectangleZ tempRect;
        for(int i = 0; i < 100; ++i)
        {
            int length = 1 + randy.nextInt(10);
            int width = 1 + randy.nextInt(5);
            tempRect = new RectangleZ(length, width);
            myRect.add(tempRect);
        }
        
        Collections.sort(myRect, new ComparatorRectangleZ());
        
        System.out.println("Please enter name of file to write to:");
        String fileName = keyboard.next();
        
        try
        {
            PrintWriter writer = new PrintWriter(new FileWriter(fileName));
            writer.printf("%-12s %-6s %-7s %-5s%n", "Name", "Area", "Length", "Width");
            
            for(RectangleZ rect : myRect)
            {
                writer.printf("%-12s %-6d %-7d %-5d%n", rect.getName(), rect.calArea(), rect.getLength(), rect.getWidth());
            }
            writer.close();
        }
        catch(IOException e)
        {
            System.out.println("Error opening " + fileName);
        }
    }
}
