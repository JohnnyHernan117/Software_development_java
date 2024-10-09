/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testportfoliomanager;

/**
 *
 * @author johnn
 */
public class SavingsAccount extends BankAccount{
    private double annualInterestRatePercent;
    private double monthlyRate;
    private double totalInterestEarned;
    
    public SavingsAccount()
    {
        super();
    }
    
    public SavingsAccount(String name, String accountNumber, double initialDeposit, double annualInterestRatePercent)
    {
        super("SavingsAccount", name, accountNumber);
        setInvestmentValue(initialDeposit);
        setAnnualInterestRatePercent(annualInterestRatePercent);
    }
    
    public double getAnnualInterestRatePercent() { return annualInterestRatePercent; }
    public double getTotalInterestEarned() { return totalInterestEarned; }
 
    public void setAnnualInterestRatePercent(double annualInterestRatePercent) 
    { 
        this.annualInterestRatePercent = annualInterestRatePercent; 
        this.monthlyRate = annualInterestRatePercent / 100.0 / 12.0;
    }
    public void setTotalInterestEarned(double totalInterestEarned) { this.totalInterestEarned = totalInterestEarned; }
    public void makeDeposit(double deposit)
    {
        setInvestmentValue(getInvestmentValue() + deposit);
    }
    public void calcValue()
    {
        double interest = getInvestmentValue() * monthlyRate;
        totalInterestEarned += interest;
        
        setInvestmentValue(getInvestmentValue() + interest);
    }
    
    public boolean makeWithdrawal(double withdrawal)
    {
        if(getInvestmentValue() < withdrawal)
        {
            System.out.println("insufficient funds.");
            return false;
        }
        else
        {
          setInvestmentValue(getInvestmentValue() - withdrawal);
          return true;
        }
        
    }
    
    @Override
    public String toString()
    {
        return super.toString() + "Current Value: $" + getInvestmentValue() + " Interest Earned: $" + getTotalInterestEarned();
    }
}
