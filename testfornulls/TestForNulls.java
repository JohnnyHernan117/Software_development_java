/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.testfornulls;
import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author johnn
 */
public class TestForNulls {
    public  static boolean hasNoNulls(ArrayList<?> list)
    {
        for(Object element : list)
            if(element == null)
                return false;
        return true;
    }

    public static void main(String[] args) {
        Random randy = new Random(5);
        ArrayList<Integer> intArrayList = new ArrayList<>();
        for(int i = 0; i < 9; ++i)
            intArrayList.add(5 + randy.nextInt(11));
        
        System.out.println("it is " + hasNoNulls(intArrayList) + " that intArrayL has no null value");
        intArrayList.add(null);
        System.out.println("It is " + hasNoNulls(intArrayList) + " that intArrayL has no null value");
        System.out.println(intArrayList);
        
        ArrayList<String> stringArrayList = new ArrayList<>();
        for(int i = 0; i < 6; ++i)
            stringArrayList.add("wxy" + (9 + randy.nextInt(19)));
        
        System.out.println("It is " + hasNoNulls(stringArrayList) + " that stringArrayL has no null value");
        
        stringArrayList.add(3, null);
        System.out.println("It is " + hasNoNulls(stringArrayList) + " that stringArraL has no null value");
        
        System.out.println(stringArrayList);
        
        
    }
}
