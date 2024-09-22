/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.polling;
import java.util.Scanner;
import java.io.*;
/**
 *
 * @author johnn
 */
public class Polling {
    public static int findMinCause(double[] average)
    {      
        int min = 0;
        for(int i = 1; i < average.length; ++i)
        {
            if(average[i] < average[min])
            {
                min = i;
            }
        }
        return min;
    }
    public static int findMaxCause(double[] average)
    {
        int max = 0;
        for(int i = 1; i < average.length; ++i)
        {
            if(average[i] > average[max])
            {
                max = i;
            }
        }
        return max;
    }
    public static void reportResults(String[] causesList, int[][] pollResults, double[] average, int[] causesSum)
    {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter output File Name:");
        String outputFileName = userInput.nextLine();
        
        try
        {
            PrintWriter outputFile = new PrintWriter(outputFileName);
            outputFile.println("Causes:\t\t\tRatings:\t\t\tAverage:");
            
            for(int i = 0; i < causesList.length; ++i)
            {
                outputFile.printf("%-20s", causesList[i]);
                for(int j = 0; j < pollResults[i].length; ++j)
                {
                    outputFile.printf("%8d", pollResults[i][j]);
                }
                outputFile.printf("%20.2f\n", average[i]);
            }
            
            int max = findMaxCause(average);
            int min = findMinCause(average);
            
            outputFile.printf("\nHighest rated cause: %s with an average of %.2f\n", causesList[max], average[max]);
            outputFile.printf("\nLowest rated cause: %s with an average of %.2f\n", causesList[min], average[min]);
            
            outputFile.close();
        }    
        catch(FileNotFoundException e)
        {
            System.out.println("Error writing output to file");
        }
    }
        
    public static double[] calcAverage(int[] causesSum, int numPolled)
    {
        double[] average = new double[5];
        for(int i = 0; i < 5; ++i)
        {
            average[i] = (double) causesSum[i] / numPolled;
        }
        return average;
    }
    
    public static int[] calcCausesSums(int[][] pollResult)
    {
        int[] causesSum = new int[5];
        for(int causes = 0; causes < pollResult.length; ++causes)
        {
            int sum = 0;
            for(int rating = 0; rating < pollResult[causes].length; ++rating)
            {
                sum += pollResult[causes][rating];
            }
            causesSum[causes] = sum;
        }
        return causesSum;
    }
    
    public static int[][] performSurvey(String[] causeList, int numPolled)
    {
        int[][] pollResults = new int[causeList.length][numPolled];
        Scanner input = new Scanner(System.in);
        
        for(int person = 0; person < numPolled; ++person)
        {
            for(int causes = 0; causes < causeList.length; ++causes)
            {
                int rating = 0;
                do{
                    System.out.println("Enter importance ranking for " + causeList[causes]);
                    rating = input.nextInt();
                    if(rating < 1 || rating > 10)
                    {
                        System.out.println("Invalid rating. Rate must be within 1-10");
                    }
                }while(rating < 1 || rating > 10); 
                
                pollResults[causes][person] = rating;
            }
        }
        return pollResults;
    }
    
    public static String[] readCauses()
    {
       String[] causeList = new String[5];
        try
        {
            Scanner userInput = new Scanner(System.in);
            System.out.println("Please enter name of the file to read causesfrom: ");
            String inputFileName = userInput.nextLine();
            Scanner inputFile = new Scanner(new File(inputFileName));
            
            for(int i = 0; i < causeList.length; ++i )
            {
                if(inputFile.hasNextLine())
                {
                    causeList[i] = inputFile.nextLine();
                }
            }
            inputFile.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Input file not found");
        }
        return causeList;
    }
    
    public static void main(String[] args) {
        String[] causeList = readCauses();
                
        Scanner input = new Scanner(System.in);      
        System.out.println("Enter the number of people to be pollled: ");
        int numPolled = input.nextInt();
        
        int[][] pollResult = performSurvey(causeList, numPolled);
        
        int[] causesSum = calcCausesSums(pollResult);
        
        double[] averageForCauses = calcAverage(causesSum, numPolled);
        
        reportResults(causeList, pollResult, averageForCauses, causesSum);
    }
}