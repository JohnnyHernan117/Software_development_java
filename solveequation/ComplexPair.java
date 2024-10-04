/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.solveequation;
/**
 *
 * @author johnn
 */
public class ComplexPair {
    private Complex first;
    private Complex second;
    
    public ComplexPair(Complex first, Complex second)
    {
        setFirst(first);
        setSecond(second);
    }
    
    public void setFirst(Complex first) { this.first = first; }
    public void setSecond(Complex second) { this.second = second; }
    public Complex getFirst() { return first; }
    public Complex getSecond() { return second; }
    
    
    @Override
    public String toString()
    {
        return "first: " + first.toString() + "; second: " + second.toString();
    }
}
