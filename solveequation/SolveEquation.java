/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.solveequation;
/**
 *
 * @author johnn
 */
public class SolveEquation {

    public static void main(String[] args) {
 
        // Test cases for quadratic equations
        Quadratic q1 = new Quadratic(0, -8, 2);
        Quadratic q2 = new Quadratic(-2, 4, -2);
        Quadratic q3 = new Quadratic(1, -3, -10);
        Quadratic q4 = new Quadratic(-1, 2, -5);
        Quadratic q5 = new Quadratic(1, 0, 9);

        // Solve each quadratic equation and print the results
        solveAndPrint(q1);
        solveAndPrint(q2);
        solveAndPrint(q3);
        solveAndPrint(q4);
        solveAndPrint(q5);
    }

    // Helper method to solve and print the quadratic equation
    public static void solveAndPrint(Quadratic q) {
        System.out.println("Quadratic equation: " + q.toString());
        System.out.println(q.getComment());
        ComplexPair solutions = q.solveQuadratic();
        System.out.println("Solutions: " + solutions.toString() + "\n");
    }
    
}
