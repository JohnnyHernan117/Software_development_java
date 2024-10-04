/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.createnewuniversity;
/**
 *
 * @author johnn
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class University {
    private String univName;
    private ArrayList<Advisor> advList;
    private ArrayList<Student> freshmanStudList;
    private ArrayList<Student> sophomoreStudList;
    private ArrayList<Student> juniorStudList;
    private ArrayList<Student> seniorStudList;

    // Default constructor
    public University() {
        this.univName = "unknown";
        advList = new ArrayList<>();
        freshmanStudList = new ArrayList<>();
        sophomoreStudList = new ArrayList<>();
        juniorStudList = new ArrayList<>();
        seniorStudList = new ArrayList<>();
    }

    // Constructor with university name
    public University(String univName) {
        this();
        this.univName = univName;
    }

    // Getter and setter for university name
    public String getUnivName() {
        return univName;
    }

    public void setUnivName(String name) {
        this.univName = name;
    }

    // Hire advisors from a file
    public void hireAdvisors() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter the name of the input file with advisor's name and department: ");
        String fileName = keyboard.nextLine();

        try {
            Scanner fileScanner = new Scanner(new File(fileName));
            while (fileScanner.hasNextLine()) {
                String advisorName = fileScanner.nextLine();
                String department = fileScanner.nextLine();
                Advisor advisor = new Advisor(advisorName, department);
                advList.add(advisor);
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }

    // Admit students from a file
    public void admitStudents() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter the name of the input file with student's name and year: ");
        String fileName = keyboard.nextLine();

        try {
            Scanner fileScanner = new Scanner(new File(fileName));
            int advisorIndex = 0;
            while (fileScanner.hasNextLine()) {
                String studentName = fileScanner.nextLine();
                String studentYear = fileScanner.nextLine();

                // Get the next advisor in round-robin fashion
                Advisor advisor = advList.get(advisorIndex % advList.size());
                advisorIndex++;

                // Admit the student based on the year
                Student student = new Student(studentName, advisor, studentYear);
                switch (studentYear) {
                    case "Freshman":
                        freshmanStudList.add(student);
                        break;
                    case "Sophomore":
                        sophomoreStudList.add(student);
                        break;
                    case "Junior":
                        juniorStudList.add(student);
                        break;
                    case "Senior":
                        seniorStudList.add(student);
                        break;
                    default:
                        System.out.println(studentName + " has an illegal student year: " + studentYear + " Rejected entry");
                        break;
                }
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }

    // Print university community
    public void printUniversityCommunity() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter the name of the output file for the University: ");
        String fileName = keyboard.nextLine();

        try {
            for (Advisor advisor : advList) {
                System.out.println(advisor + ":");
                for (int i = 0; i < advisor.getNumStudentsInAdvisorList(); i++) {
                    System.out.println(advisor.getStudentFromAdvisorList(i));
                }
            }
            System.out.println("\nFreshmen:");
            for (Student s : freshmanStudList) {
                System.out.println(s);
            }
            System.out.println("\nSophomores:");
            for (Student s : sophomoreStudList) {
                System.out.println(s);
            }
            System.out.println("\nJuniors:");
            for (Student s : juniorStudList) {
                System.out.println(s);
            }
            System.out.println("\nSeniors:");
            for (Student s : seniorStudList) {
                System.out.println(s);
            }
        } catch (Exception e) {
            System.out.println("Error printing community");
        }
    }
}
