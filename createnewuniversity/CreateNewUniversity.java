/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.createnewuniversity;
/**
 *
 * @author johnn
 */
import java.util.Scanner;

public class CreateNewUniversity {

    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
        
        System.out.println("Please enter the University Name: ");
        String universityName = scanner.nextLine();

        University university = new University(universityName);
        
        university.hireAdvisors();
        
        university.admitStudents();
        
        university.printUniversityCommunity();
    }
}
