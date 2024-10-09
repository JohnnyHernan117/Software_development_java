/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testportfoliomanager;

/**
 *
 * @author johnn
 */
public class BankAccount extends Investment{
    private String accountNumber;
    
    public BankAccount()
    {
        super();
        setAccountNumber("none");
    }
    public BankAccount(String type, String name, String accountNumber)
    {
        super(type, name);
        setAccountNumber(accountNumber);
    }
    
    public String getAccountNumber() { return accountNumber; }
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }
    
    @Override
    public String toString()
    {
        return super.toString() + " Account Number: " + getAccountNumber() + "\n";
    }
}
