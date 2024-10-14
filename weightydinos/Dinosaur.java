/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.weightydinos;
/**
 *
 * @author johnn
 */
public class Dinosaur implements Comparable <Dinosaur>{
    private static int dinoCounter = 1;
    private String dinoName;
    private int dinoWeight;
    
    public Dinosaur()
    {
        setDinoName("Barney");
    }
    public Dinosaur(int weight)
    {
        setDinoWeight(weight);
        setDinoName("DINO");
        ++dinoCounter;
    }
    public void setDinoName(String dinoName) { this.dinoName = dinoName; }
    public void setDinoWeight(int weight) { this.dinoWeight = weight; }
    public int getDinoWeight() { return dinoWeight; }
    public String getDinoName() { return dinoName; }
    @Override
    public String toString()
    {
        return getDinoName() + "\t" + getDinoWeight();
    }
    @Override
    public int compareTo(Dinosaur other)
    {
        return Integer.compare(this.getDinoWeight(), other.getDinoWeight());
    }
    
}
