/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ordenamientoaleatorio;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Estudiante
 */
public class OrdenamientoAleatorio {

    public static void main(String[] args) {
        int[] tamaños = {100, 500, 1000, 5000, 10000};
        
        for (int tamaño : tamaños) {
            double[] arreglo = generarArregloAleatorio(tamaño);
            
            System.out.println("Tamaño del arreglo: " + tamaño);
            System.out.println("Método de Burbuja:");
            long tiempoBurbuja = medirTiempo(() -> burbuja(arreglo.clone()));
            System.out.println("Tiempo de ejecución: " + tiempoBurbuja + " nanosegundos");
            
            System.out.println("Método de Inserción:");
            long tiempoInsercion = medirTiempo(() -> insercion(arreglo.clone()));
            System.out.println("Tiempo de ejecución: " + tiempoInsercion + " nanosegundos");
            
            System.out.println("Método de Selección:");
            long tiempoSeleccion = medirTiempo(() -> seleccion(arreglo.clone()));
            System.out.println("Tiempo de ejecución: " + tiempoSeleccion + " nanosegundos");
            
            System.out.println("Método de MergeSort:");
            long tiempoMergeSort = medirTiempo(() -> mergeSort(arreglo.clone(), 0, arreglo.length - 1));
            System.out.println("Tiempo de ejecución: " + tiempoMergeSort + " nanosegundos");
            
            System.out.println();
        }
    }
    
    public static double[] generarArregloAleatorio(int tamaño) {
        double[] arreglo = new double[tamaño];
        Random rand = new Random();
        
        for (int i = 0; i < tamaño; i++) {
            arreglo[i] = rand.nextDouble();
        }
        
        return arreglo;
    }
    
    public static void burbuja(double[] arreglo) {
        int n = arreglo.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arreglo[j] > arreglo[j + 1]) {
                    // Intercambia arreglo[j] y arreglo[j+1]
                    double temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                }
            }
        }
    }
    
    public static void insercion(double[] arreglo) {
        int n = arreglo.length;
        for (int i = 1; i < n; i++) {
            double key = arreglo[i];
            int j = i - 1;
            
            while (j >= 0 && arreglo[j] > key) {
                arreglo[j + 1] = arreglo[j];
                j = j - 1;
            }
            
            arreglo[j + 1] = key;
        }
    }
    
    public static void seleccion(double[] arreglo) {
        int n = arreglo.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arreglo[j] < arreglo[minIdx]) {
                    minIdx = j;
                }
            }
            
            double temp = arreglo[minIdx];
            arreglo[minIdx] = arreglo[i];
            arreglo[i] = temp;
        }
    }
    
    public static void mergeSort(double[] arreglo, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(arreglo, l, m);
            mergeSort(arreglo, m + 1, r);
            merge(arreglo, l, m, r);
        }
    }
    
    public static void merge(double[] arreglo, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        
        double[] L = Arrays.copyOfRange(arreglo, l, l + n1);
        double[] R = Arrays.copyOfRange(arreglo, m + 1, m + 1 + n2);
        
        int i = 0, j = 0, k = l;
        
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arreglo[k] = L[i];
                i++;
            } else {
                arreglo[k] = R[j];
                j++;
            }
            k++;
        }
        
        while (i < n1) {
            arreglo[k] = L[i];
            i++;
            k++;
        }
        
        while (j < n2) {
            arreglo[k] = R[j];
            j++;
            k++;
        }
    }
    
    public static long medirTiempo(Runnable runnable) {
        long inicio = System.nanoTime();
        runnable.run();
        long fin = System.nanoTime();
        return fin - inicio;
    }
}
