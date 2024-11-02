/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.quinttypetest;
/**
 *
 * @author johnn
 */
public class QuintTypeTest {

    public static void main(String[] args) {
        QuintType<Integer, Character, String, Boolean, Double> quintType =
            new QuintType<>(1, 'B', "twenty", false, 1.93);
        
        System.out.println("Original QuintType: " + quintType);
        
        quintType.setF(25);
        quintType.setS('H');
        quintType.setT("fifty");
        quintType.setU(true);
        quintType.setV(9.17);
        
        System.out.println("Modified QuintType: " + quintType);
    }
}
