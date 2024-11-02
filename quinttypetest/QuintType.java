/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quinttypetest;
/**
 *
 * @author johnn
 */
public class QuintType<F, S, T, U, V> {
    private F first;
    private S second;
    private T third;
    private U fourth;
    private V fifth;
    
    public QuintType(F first, S second, T third, U fourth, V fifth)
    {
        setF(first);
        setS(second);
        setT(third);
        setU(fourth);
        setV(fifth);
    }
    
    public F getF() { return first; }
    public S getS() { return second; }
    public T getT() { return third; }
    public U getU() { return fourth; }
    public V getV() { return fifth; }
    
    public void setF(F first) { this.first = first; }
    public void setS(S second) { this.second = second; }
    public void setT(T third) { this.third = third; }
    public void setU(U fourth) { this.fourth = fourth; }
    public void setV(V fifth) { this.fifth = fifth; }
    
    @Override
    public String toString()
    {
        return "<" + first + ", " + second + ", " + third + ", " + fourth + ", " + fifth + ">";
    }
}
