/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.testportfoliomanager;

/**
 *
 * @author johnn
 */
import java.util.Scanner;

public class TestPortfolioManager {

    public static void main(String[] args) {
        Scanner keyboard= new Scanner(System.in);
        
        System.out.println("Pleaser enter the name of the portfolio: ");
        String portfolioName = keyboard.nextLine();
        
        System.out.println("Please enter a seed to use to create a Random object in the portfolio:");
        int seed = keyboard.nextInt();

        keyboard.nextLine();
        
        Portfolio portfolio = new Portfolio(portfolioName, seed);
        portfolio.initializePortfolio();
        
        System.out.print("Please enter the number of months to model: ");
        int months = keyboard.nextInt();
        portfolio.modelPortfolio(months);
        
        portfolio.generatePortfolioReport(months);
        
        System.out.println("Portfolio modeling complete. Report generated in ");
    }
}
