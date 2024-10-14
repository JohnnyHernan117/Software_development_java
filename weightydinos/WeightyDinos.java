/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.weightydinos;
/**
 *
 * @author johnn
 */
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

public class WeightyDinos {

    public static void main(String[] args) {
        ArrayList<Dinosaur> dinoList = new ArrayList<>();
        Random randy = new Random(4);
        
        for(int i = 0; i < 12; ++i)
        {
            int randomWeight = 50000 + randy.nextInt(150001);
            Dinosaur dino = new Dinosaur(randomWeight);
            dinoList.add(dino);
        }
        Collections.sort(dinoList);
        
        System.out.println("Name\tWeight");
        for(Dinosaur dino : dinoList)
        {
            System.out.println(dino);
        }
        
    }
}
