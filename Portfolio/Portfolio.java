/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testportfoliomanager;

/**
 *
 * @author johnn
 */
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class Portfolio {
    private String portfolioName;
    private ArrayList<Investment> portfolioInvestments;
    private Random randy;
    
    public Portfolio()
    {
        setPortfolioName("none");
    }
    public Portfolio(String portfolioName, int seed)
    {
        setPortfolioName(portfolioName);
        this.portfolioInvestments = new ArrayList<>();
        this.randy = new Random(seed);
    }
    
    public Scanner keyboard = new Scanner(System.in);
    
    public String getPortfolioName() { return portfolioName; }
    public void setPortfolioName(String portfolioName) { this.portfolioName = portfolioName; }
    public void initializePortfolio()
    {
        System.out.println("Please enter the name of the file to read the portfolio from: ");
        String inputFileName = keyboard.nextLine();
        
        try
        {
            Scanner readFile = new Scanner(new File(inputFileName));
            while(readFile.hasNextLine())
            {
                String type = readFile.next();
                
                switch(type)
                {
                    case "Stock":
                        String stockName = readFile.next();
                        double pricePerShare = readFile.nextDouble();
                        double numSharesOwned = readFile.nextDouble();
                        Stock stock = new Stock(stockName, pricePerShare, numSharesOwned);
                        portfolioInvestments.add(stock);
                        break;
                        
                    case "Bond":
                        String bondName = readFile.next();
                        double pricePerBond = readFile.nextDouble();
                        int numBondsOwned = readFile.nextInt();
                        double annualReturnPercentage = readFile.nextDouble();
                        Bond bond = new Bond(bondName, pricePerBond, annualReturnPercentage, numBondsOwned);
                        portfolioInvestments.add(bond);
                        break;
                        
                    case "SavingsAccount":
                        String savingsName = readFile.next();
                        String accountNumber = readFile.next();
                        double initialDeposit = readFile.nextDouble();
                        double annualInterestRate = readFile.nextDouble();
                        SavingsAccount savingsAccount = new SavingsAccount(savingsName, accountNumber, initialDeposit, annualInterestRate);
                        portfolioInvestments.add(savingsAccount);
                        break;
                        
                    case "CheckingAccount":
                        String name = readFile.next();
                        String checkingAccountNumber = readFile.next();
                        double checkingInitialDeposit = readFile.nextDouble();
                        double annualInterestRatePercent = readFile.nextDouble();
                        double minimumCheckFreeBalance = readFile.nextDouble();
                        double checkCharge = readFile.nextDouble();
                        CheckingAccount checkingAccount = new CheckingAccount(name, checkingAccountNumber, checkingInitialDeposit, annualInterestRatePercent, minimumCheckFreeBalance, checkCharge);
                        portfolioInvestments.add(checkingAccount);
                        break;
                }
            }
            readFile.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("file not found " + inputFileName);
        }
    }
    public void modelPortfolio(int months)
    {
        for (int month = 1; month <= months; month++) 
        {
            for (Investment investment : portfolioInvestments) 
            {
                if (investment instanceof Stock) 
                {
                    Stock stockItem = (Stock) investment;

                    if (month % 3 == 0) 
                    { 
                        double priceChangePercent = (randy.nextInt(16) - 5);
                        double dividendPercent = (randy.nextInt(6));
                        stockItem.calcStockTotalInvestmentValue(priceChangePercent, dividendPercent);
                    }
                } else if (investment instanceof Bond) 
                {
                    Bond bondItem = (Bond) investment;
                    bondItem.calcBondTotalInvestmentValue(); 
                } else if (investment instanceof SavingsAccount) 
                {
                    SavingsAccount savingsItem = (SavingsAccount) investment;

                    for (int i = 0; i < 3; i++) 
                    {  
                        double transaction = (randy.nextInt(1601) - 600);
                        if (transaction >= 0) 
                        {
                            savingsItem.makeDeposit(transaction);
                        } 
                        else 
                        {
                            savingsItem.makeWithdrawal(-transaction);
                        }
                    }
                    savingsItem.calcValue();  
                } 
                else if (investment instanceof CheckingAccount) 
                {
                    CheckingAccount checkingItem = (CheckingAccount) investment;

                    double deposit = (randy.nextInt(1001) + 500);
                    checkingItem.makeDeposit(deposit);

                    for (int i = 0; i < 4; i++) 
                    {
                        double checkValue = randy.nextInt(291) + 10;
                        checkingItem.writeCheck(checkValue);
                    }

                    checkingItem.calcValue(); 
                }
            }
        }
    }
    
    public void generatePortfolioReport(int month)
    {
        System.out.print("Please enter the name of the file to write the portfolio report to: ");
        String outputFileName = keyboard.next();
        
        try
        {
            PrintWriter writer = new PrintWriter(outputFileName);
            writer.printf("Results of the portfolio %s over %s months\n", portfolioName,month );
            
            double totalPortfolioValue = 0.0;
            for(Investment investment : portfolioInvestments)
            {
                if(investment instanceof Stock)
                {
                    Stock stock = (Stock) investment;
                    writer.printf("Investment: Stock Name: %s\n", stock.getName());
                    writer.printf("Price Per Share: $%.2f Number Of Shares: %.2f\n", stock.getPricePerShare(), stock.getNumSharesOwned());
                    writer.printf("Current Value: $%.2f Investment Earnings to date: %.2f\n\n", stock.getInvestmentValue(), stock.getDividendsEarnedToDate());
                }
                else if(investment instanceof Bond)
                {
                    Bond bond = (Bond) investment;
                    writer.printf("Investment: Bond Name: %s\n", bond.getName());
                    writer.printf("Price Per Bond: $%.2f Number Of Bonds: %d\n", bond.getPricePerBond(), bond.getNumBondsOwned());
                    writer.printf("Current Value: $%.2f Cash On Hand To Date: %.2f\n\n", bond.getInvestmentValue(), bond.getCashEarnedToDate());
                }
                else if(investment instanceof SavingsAccount)
                {
                    SavingsAccount savingsAccount = (SavingsAccount) investment;
                    writer.printf("Investment: SavingsAccount Name: %s Account Number: %s\n", savingsAccount.getName(), savingsAccount.getAccountNumber());
                    writer.printf("Current Value: $%.2f Interest Earned: $%.2f\n\n", savingsAccount.getInvestmentValue(), savingsAccount.getTotalInterestEarned());
                }
                else if(investment instanceof CheckingAccount)
                {
                    CheckingAccount checkingAccount = (CheckingAccount) investment;
                    writer.printf("Investment: CheckingAccount Name: %s Account Number: %s\n", checkingAccount.getName(), checkingAccount.getAccountNumber());
                    writer.printf("Minimum For Free Checking: $%.2f Check Charge: $%.2f\n", checkingAccount.getMinimumCheckFreeBalance(), checkingAccount.getCheckCharge());
                    writer.printf("Current Value: $%.2f Interest Earned: $%.2f Check Charges: $%.2f\n\n", checkingAccount.getInvestmentValue(), checkingAccount.getTotalInterestEarned(), checkingAccount.getTotalCheckCharges());
                }
                totalPortfolioValue += investment.getInvestmentValue();
            }
            writer.printf("The total value of all the investments is $%.2f\n", totalPortfolioValue);
            writer.close();
        }
        catch(IOException e)
        {
            System.out.println("Could not create file " + outputFileName);
        }
    }
     
}
