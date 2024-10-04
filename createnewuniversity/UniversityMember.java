/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.createnewuniversity;
/**
 *
 * @author johnn
 */
public class UniversityMember {
    private String memberName;

    public UniversityMember() {
        setMemberName("Unknown");
    }

    public UniversityMember(String name) {
        setMemberName(name);
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String name) {
        this.memberName = name;
    }

    @Override
    public String toString() {
        return memberName;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        UniversityMember that = (UniversityMember) obj;
        return memberName.equals(that.memberName);
    }
}
