/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.operacionesmatrices;

import java.util.Scanner;

/**
 *
 * @author Lina Castiblanco
 */
public class OperacionesMatrices {
    
    public static void main(String[] args) {
        Scanner mostrar = new Scanner(System.in);
        
        System.out.print("Ingrese el número de filas de la matriz A: ");
        int rowsA = mostrar.nextInt();
        System.out.print("Ingrese el número de columnas de la matriz A: ");
        int colsA = mostrar.nextInt();
        
        double[][] matrixA = inputMatrixData(mostrar, rowsA, colsA);
        
        System.out.print("Ingrese el número de filas de la matriz B: ");
        int rowsB = mostrar.nextInt();
        System.out.print("Ingrese el número de columnas de la matriz B: ");
        int colsB = mostrar.nextInt();
        
        double[][] matrixB = inputMatrixData(mostrar, rowsB, colsB);
        
        System.out.println("\nOperaciones disponibles:");
        System.out.println("1. Suma de matrices");
        System.out.println("2. Producto de matrices");
        System.out.println("3. Producto escalar con matriz");
        System.out.println("4. Traspuesta de una matriz");
        System.out.print("Ingrese el número de la operación deseada: ");
        int choice = mostrar.nextInt();
        
        switch (choice) {
            case 1 -> {
                if (rowsA == rowsB && colsA == colsB) {
                    double[][] result = addMatrices(matrixA, matrixB);
                    printMatrix("Suma de matrices:", result);
                } else {
                    System.out.println("Las matrices deben tener la misma dimensión para sumar.");
                }
            }
                
            case 2 -> {
                if (colsA == rowsB) {
                    double[][] result = multiplyMatrices(matrixA, matrixB);
                    printMatrix("Producto de matrices:", result);
                } else {
                    System.out.println("El número de columnas de la matriz A debe ser igual al número de filas de la matriz B para la multiplicación.");
                }
            }
                
            case 3 -> {
                System.out.print("Ingrese el escalar: ");
                double scalar = mostrar.nextDouble();
                double[][] result = scalarMatrixProduct(scalar, matrixA);
                printMatrix("Producto escalar con matriz:", result);
            }
                
            case 4 -> {
                double[][] resultTransposed = transposeMatrix(matrixA);
                printMatrix("Traspuesta de la matriz:", resultTransposed);
            }
                
            default -> System.out.println("Opción no válida.");
        }
        
        mostrar.close();
    }
    
    // Método para ingresar los datos de una matriz desde la consola
    public static double[][] inputMatrixData(Scanner scanner, int rows, int cols) {
        double[][] matrix = new double[rows][cols];
        
        System.out.println("Ingrese los elementos de la matriz:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Elemento (" + (i + 1) + "," + (j + 1) + "): ");
                matrix[i][j] = scanner.nextDouble();
            }
        }
        
        return matrix;
    }
    
    // Método para sumar dos matrices
    public static double[][] addMatrices(double[][] matrixA, double[][] matrixB) {
        int rows = matrixA.length;
        int cols = matrixA[0].length;
        double[][] result = new double[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }
        
        return result;
    }
    
    // Método para multiplicar dos matrices
    public static double[][] multiplyMatrices(double[][] matrixA, double[][] matrixB) {
        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int colsB = matrixB[0].length;
        double[][] result = new double[rowsA][colsB];
        
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                double sum = 0;
                for (int k = 0; k < colsA; k++) {
                    sum += matrixA[i][k] * matrixB[k][j];
                }
                result[i][j] = sum;
            }
        }
        
        return result;
    }
    
    // Método para multiplicar una matriz por un escalar
    public static double[][] scalarMatrixProduct(double scalar, double[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        double[][] result = new double[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = scalar * matrix[i][j];
            }
        }
        
        return result;
    }
    
    // Método para calcular la traspuesta de una matriz
    public static double[][] transposeMatrix(double[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        double[][] result = new double[cols][rows];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        
        return result;
    }
    
    // Método para imprimir una matriz en la consola
    public static void printMatrix(String label, double[][] matrix) {
        System.out.println(label);
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}