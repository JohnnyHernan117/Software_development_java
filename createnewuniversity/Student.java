/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.createnewuniversity;
/**
 *
 * @author johnn
 */
public class Student extends UniversityMember{
    private Advisor advisor;
    private String year;
    private int studentNumber;
    private static int IDNUMBER = 1000;

    public Student() {
        super();
        setYear("unknown");
        setAdvisor(null);
        this.studentNumber = IDNUMBER++;
    }

    public Student(String name, Advisor advisor, String year) {
        super(name);
        setAdvisor(advisor);
        setYear(year);
        this.studentNumber = IDNUMBER++;
    }

    public Advisor getAdvisor() {
        return advisor;
    }

    public void setAdvisor(Advisor advisor) {
        this.advisor = advisor;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    @Override
    public String toString() {
        return super.toString() + " is a " + getYear() + " with student number " + getStudentNumber();
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        Student student = (Student) obj;
        return year.equals(student.year) && studentNumber == student.studentNumber;
    }
}
