/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testportfoliomanager;

/**
 *
 * @author johnn
 */
public class Investment {
    private String type;
    private String name;
    private double investmentValue;
    
    public Investment()
    {
        setName("None");
        setType("None");
    }
    public Investment(String type, String name)
    {
        setType(type);
        setName(name);
    }
    
    public String getType() { return this.type; }
    public String getName() { return this.name; }
    public double getInvestmentValue() { return this.investmentValue; }
    
    public void setType(String type) { this.type = type; }
    public void setName(String name) { this.name = name; }
    public void setInvestmentValue(double investmentValue) { this.investmentValue = investmentValue; }
    
    @Override 
    public String toString()
    {
        System.out.println(getType() + ":" + getName());
        return "Investment: " + getType() + ": Name: " + getName() + " ";
    }
}
