/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */  
package com.mycompany.url;
import java.io.*;
import java.util.Scanner;
/**
 *
 * @author johnn
 */
public class URL {
    public static String extractName(String url)
    {
        String[] parts = url.split("\\.");
        if(parts.length > 1)
        {
            return parts[1];
        }
        return "";
    }
    public static void main(String[] args) {
        String inputFileName = "urlInput.txt";
        String outputFileName = "urlOutput.txt";
        
      try
      { 
          Scanner inputFile = new Scanner(new File(inputFileName));
          PrintWriter outputFile = new PrintWriter(outputFileName);
          
          while(inputFile.hasNextLine())
          {
              String url = inputFile.nextLine();
              String extractedName = extractName(url);
              outputFile.printf("Original URL: %s, Extracted Name: %s%n", url, extractedName);
          }
          outputFile.close();
          inputFile.close();
          
          System.out.println("Process complete!");
      }
      catch(FileNotFoundException e)
      {
          System.out.println("Input File not found " + inputFileName);
      }
    }
}
