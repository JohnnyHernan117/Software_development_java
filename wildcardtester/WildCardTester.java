/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.wildcardtester;
import java.util.ArrayList;
/**
 *
 * @author johnn
 */
public class WildCardTester {
    public static void addBird(ArrayList<? super Parrot> list, String name)
    {
        list.add(new Parrot(name));
        System.out.println("Birdie named " + name + " was added");
    }
    
    public static void deleteBird(ArrayList<? extends Bird> list, String name)
    {
        list.removeIf(bird -> bird.getName().equals(name));
        System.out.println("Birdie named " + name + " was removed");
    }
    
    public static void printAll(ArrayList<?> list)
    {
        for(Object item : list)
            System.out.print(item + " ");
        System.out.println();
    }
    
    public static void main(String[] args) {
        ArrayList<Pet> petList = new ArrayList<>();
        ArrayList<Parrot> parrotList = new ArrayList<>();
        
        addBird(petList, "Tweety");
        addBird(parrotList, "Talkie");
        addBird(parrotList, "Polly");
        addBird(parrotList, "Echo");
        
        System.out.println("The list of Pets:");
        printAll(petList);
        
        System.out.println("The list of Parrots");
        printAll(parrotList);
        
        deleteBird(parrotList, "Talkie");
        
        System.out.println("The list of Parrots after a deletion of the first Parrot in the list:");
        printAll(parrotList);
    }
}
