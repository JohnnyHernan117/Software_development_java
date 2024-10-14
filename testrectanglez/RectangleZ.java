/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testrectanglez;
/**
 *
 * @author johnn
 */
public class RectangleZ {
    private static int rectID = 0;
    private String name;
    private int length;
    private int width;
    
    public RectangleZ()
    {
        this(0,0);
    }
    public RectangleZ(int length, int width)
    {
        setLength(length);
        setWidth(width);
        setString();
    }
    public void setString() 
    { 
        rectID++;
        this.name = "Rect" + rectID; 
    }
    public void setLength(int length) { this.length = length; }
    public void setWidth(int width) { this.width = width; }
    public int getLength() { return length; }
    public int getWidth() { return width; }
    public int calArea() { return this.length * this.width; }
    public String getName() { return name; }
    @Override
    public String toString()
    {
        return "RectangleZ " + getName() + 
                " has area " + calArea() + 
                " length " + getLength() + 
                " and width " + getWidth();
    }
}
