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

public class Advisor extends UniversityMember{ 
    private String department;
    private ArrayList<Student> advStudentList;

    public Advisor() {
        super();
        setDepartment("unknown");
        this.advStudentList = new ArrayList<>();
    }

    public Advisor(String name, String department) {
        super(name);
        setDepartment(department);
        this.advStudentList = new ArrayList<>();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void addStudentToAdvisor(Student student) {
        advStudentList.add(student);
    }

    public Student getStudentFromAdvisorList(int index) {
        if (index >= 0 && index < advStudentList.size()) {
            return advStudentList.get(index);
        }
        return null;
    }

    public int getNumStudentsInAdvisorList() {
        return advStudentList.size();
    }

    @Override
    public String toString() {
        return super.toString() + " from " + department + " department";
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        Advisor advisor = (Advisor) obj;
        return department.equals(advisor.department);
    }
}
