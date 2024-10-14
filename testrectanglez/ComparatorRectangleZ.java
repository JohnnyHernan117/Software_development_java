/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testrectanglez;
/**
 *
 * @author johnn
 */
import java.util.Comparator;

public class ComparatorRectangleZ implements Comparator <RectangleZ>{
    @Override
    public int compare(RectangleZ R1, RectangleZ R2)
    {
        int areaDiff = R2.calArea() - R1.calArea();
        if(areaDiff != 0)
            return areaDiff;
        
        int lengthDiff = R2.getLength() - R1.getLength();
        if(lengthDiff != 0)
            return lengthDiff;
        
        int widthDiff = R2.getWidth() - R1.getWidth();
        if(widthDiff != 0)
            return widthDiff;
        
        return R1.getName().compareTo(R2.getName());
    }
}
