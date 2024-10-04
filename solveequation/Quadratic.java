/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.solveequation;
/**
 *
 * @author johnn
 */
public class Quadratic {
     private int a, b, c; 
    private String comment; 
    public Quadratic(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
        setComment();
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
        setComment();
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
        setComment();
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
        setComment();
    }

    public String getComment() {
        return comment;
    }

    private int discriminant() {
        return b * b - 4 * a * c;
    }

    private void setComment() {
        if (a == 0) {
            comment = "Linear equation: one real root";
        } else if (discriminant() == 0) {
            comment = "Quadratic with one real root";
        } else if (discriminant() > 0) {
            comment = "Two distinct real roots";
        } else {
            comment = "Two distinct complex roots";
        }
    }

    public ComplexPair solveQuadratic() {
        Complex firstRoot, secondRoot;
        int discrim = discriminant();

        if (a == 0) {
            // Linear case: ax + b = 0 -> x = -c / b
            firstRoot = new Complex(-c / (double) b, 0);
            return new ComplexPair(firstRoot, firstRoot);
        } else if (discrim == 0) {
            // One real root
            firstRoot = new Complex(-b / (2.0 * a), 0);
            return new ComplexPair(firstRoot, firstRoot);
        } else if (discrim > 0) {
            // Two distinct real roots
            firstRoot = new Complex((-b + Math.sqrt(discrim)) / (2 * a), 0);
            secondRoot = new Complex((-b - Math.sqrt(discrim)) / (2 * a), 0);
            return new ComplexPair(firstRoot, secondRoot);
        } else {
            // Two complex roots
            firstRoot = new Complex(-b / (2.0 * a), Math.sqrt(-discrim) / (2 * a));
            secondRoot = new Complex(-b / (2.0 * a), -Math.sqrt(-discrim) / (2 * a));
            return new ComplexPair(firstRoot, secondRoot);
        }
    }

    @Override
    public String toString() {
        StringBuilder equation = new StringBuilder();
        if (a != 0) {
            equation.append(a).append("x^2 ");
        }
        if (b != 0) {
            if (b > 0) equation.append("+ ").append(b).append("x ");
            else equation.append("- ").append(-b).append("x ");
        }
        if (c != 0) {
            if (c > 0) equation.append("+ ").append(c);
            else equation.append("- ").append(-c);
        }
        return equation.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Quadratic quadratic = (Quadratic) obj;
        return a == quadratic.a && b == quadratic.b && c == quadratic.c;
    }
}
