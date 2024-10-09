/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testportfoliomanager;

/**
 *
 * @author johnn
 */
public class Stock extends Investment {
    private double pricePerShare;
    private double numSharesOwned;
    private double dividendsEarnedToDate;
    
    public Stock()
    {
        super();
    }
    public Stock(String name, double pricePerShare, double numSharesOwned)
    {
        super("Stock", name);
        this.setPricePerShare(pricePerShare);
        this.setNumSharesOwned(numSharesOwned);
        this.setInvestmentValue(pricePerShare * numSharesOwned);
    }
    
    public double getPricePerShare() { return pricePerShare; }
    public double getNumSharesOwned() { return numSharesOwned; }
    public double getDividendsEarnedToDate() { return dividendsEarnedToDate; }
    
    public void setPricePerShare(double pricePerShare) { this.pricePerShare = pricePerShare; }
    public void setNumSharesOwned(double numSharesOwned) { this.numSharesOwned = numSharesOwned; }
    public void setDividendsEarnedToDate(double dividendsEarnedToDate) { this.dividendsEarnedToDate = dividendsEarnedToDate; }
    public void calcStockTotalInvestmentValue(double priceChangePercent, double dividendPercent)
    {
        double priceChange = (pricePerShare * priceChangePercent) / 100.0;
        pricePerShare += priceChange;
        
        double currentTotalDividend = (pricePerShare * numSharesOwned) * (dividendPercent / 100.0);
        dividendsEarnedToDate += currentTotalDividend;
        
        numSharesOwned += currentTotalDividend/pricePerShare;
        double newInvestmentValue = numSharesOwned * pricePerShare;
        
        setInvestmentValue(newInvestmentValue);
    }
    
    @Override
    public String toString()
    {
       return super.toString() + "\nPrice Per Share: $ " + getPricePerShare() + " Number of Shares: " + getNumSharesOwned() + "\n";
    }
}
