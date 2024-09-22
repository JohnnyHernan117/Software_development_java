/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.reverseorderintegerswitharraylist;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
/**
 *
 * @author johnn
 */
public class ReverseOrderIntegersWithArrayList {

    public static void inOrder(ArrayList<Integer> list, int number)
    {
        int i = 0;
        while (i < list.size() && number < list.get(i))
        {
            i++;
        }
        list.add(i, number);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter file name:");
        String fileName = input.nextLine();
        
        ArrayList<Integer> intList = new ArrayList<>();
        
        try
        {
            Scanner fileScanner = new Scanner(new File(fileName));
            
            if(!fileScanner.hasNext())
            {
                System.out.println("File is empty");
                return;
            }
            
            while(fileScanner.hasNextInt())
            {
                int number = fileScanner.nextInt();
                inOrder(intList, number);
            }
            fileScanner.close();
            
            System.out.println("Greatest to Least - enhanced loop");
            for(int num : intList)
            {
                System.out.println(num);
            }
            
            System.out.println("Greatest to Least - iterator");
            Iterator<Integer> iterator = intList.iterator();
            while(iterator.hasNext())
            {
                System.out.println(iterator.next());
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found: " + fileName);
        }
    }
}
