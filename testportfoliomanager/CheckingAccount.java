/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testportfoliomanager;

/**
 *
 * @author johnn
 */
public class CheckingAccount extends BankAccount {
    private double annualInterestRatePercent;
    private double monthlyRate;
    private double totalInterestEarned;
    private double minimumCheckFreeBalance;
    private double checkCharge;
    private double totalCheckCharges;
    
    public CheckingAccount()
    {
        super();
    }
    public CheckingAccount(String name, String accountNumber, double initialDeposit, double annualInterestRatePercent, double minimumCheckFreeBalance, double checkCharge)
    {
        super("CheckingAccount", name, accountNumber);
        setInvestmentValue(initialDeposit);
        setAnnualInterestRatePercent(annualInterestRatePercent);
        setMinimumCheckFreeBalance(minimumCheckFreeBalance);
        setCheckCharge(checkCharge);
    }
    
    public void setTotalInterestEarned(double totalInterestEarned) { this.totalInterestEarned = totalInterestEarned; }
    public void setMinimumCheckFreeBalance(double minimumCheckFreeBalance) { this.minimumCheckFreeBalance = minimumCheckFreeBalance; }
    public void setCheckCharge(double checkCharge) { this.checkCharge = checkCharge; }
    public void setTotalCheckCharges(double totalCheckCharges) { this.totalCheckCharges = totalCheckCharges; }
    public void setAnnualInterestRatePercent(double annualInterestRatePercent) 
    { 
        this.annualInterestRatePercent = annualInterestRatePercent; 
        this.monthlyRate = getAnnualInterestRatePercent() / 100.0 / 12.0;
    }
    public void makeDeposit(double deposit)
    {
        setInvestmentValue(getInvestmentValue() + deposit);
    }
    public void writeCheck(double checkValue)
    {
        if(getInvestmentValue() < checkValue)
        {
            System.out.println("insufficient funds");
        }
        else if(getInvestmentValue() >= getMinimumCheckFreeBalance())
        {
            setInvestmentValue(getInvestmentValue() - checkValue);
        }
        else
        {
            setInvestmentValue(getInvestmentValue() - checkValue - getCheckCharge());
            setTotalCheckCharges(getTotalCheckCharges() + getCheckCharge());
        }
    }
    public void calcValue()
    {
        if(getInvestmentValue() >= getMinimumCheckFreeBalance())
        {
            double interest = getInvestmentValue() * monthlyRate;
            setTotalInterestEarned(getTotalInterestEarned() + interest);
            setInvestmentValue(getInvestmentValue() + interest);
        }
    }
    
    public double getAnnualInterestRatePercent() { return annualInterestRatePercent; }
    public double getTotalInterestEarned() { return totalInterestEarned; }
    public double getMinimumCheckFreeBalance() { return minimumCheckFreeBalance; }
    public double getCheckCharge() { return checkCharge; }
    public double getTotalCheckCharges() { return totalCheckCharges; }
    
    @Override
    public String toString()
    {
        return super.toString() + "Current Value: $" + getInvestmentValue() + " Interest Earned: $" + getTotalInterestEarned() + 
                " Check Charges: " + getCheckCharge();
    }
}
