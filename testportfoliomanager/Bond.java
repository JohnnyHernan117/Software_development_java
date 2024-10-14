/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testportfoliomanager;

/**
 *
 * @author johnn
 */
public class Bond extends Investment{
    private double pricePerBond;
    private double annualReturnPercentage;
    private double monthlyRate;
    private double cashEarnedToDate;
    private int numBondsOwned;
    
    public Bond()
    {
        super();
    }
    public Bond(String name, double pricePerBond, double annualReturnPercentage, int numBondsOwned)
    {
        super("Bond", name);
        setPricePerBond(pricePerBond);
        setNumBondsOwned(numBondsOwned);
        setAnnualReturnPercentage(annualReturnPercentage);
        
        setInvestmentValue(getPricePerBond() * getNumBondsOwned());
    }
    
    public double getCashEarnedToDate() { return cashEarnedToDate; }
    public double getPricePerBond() { return pricePerBond; }
    public double getAnnualReturnPercentage () { return annualReturnPercentage; }
    public int getNumBondsOwned() { return numBondsOwned; }
    
    public void setPricePerBond(double pricePerBond) { this.pricePerBond = pricePerBond; }
    public void setNumBondsOwned(int numBondsOwned) { this.numBondsOwned = numBondsOwned; }
    public void setAnnualReturnPercentage(double annualReturnPercentage) 
    { 
        this.annualReturnPercentage = annualReturnPercentage; 
        this.monthlyRate = annualReturnPercentage / 100.0 / 12.0;
    }
    public void calcBondTotalInvestmentValue()
    {
        cashEarnedToDate += (pricePerBond * numBondsOwned * monthlyRate);
        setInvestmentValue((pricePerBond * numBondsOwned) + cashEarnedToDate);
    }
    
    @Override
    public String toString()
    {
        return super.toString() + " " + getPricePerBond() + " " + getNumBondsOwned() + " " + getAnnualReturnPercentage();
    }
}
