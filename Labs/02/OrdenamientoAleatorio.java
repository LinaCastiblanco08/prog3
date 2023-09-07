
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Lina Castiblanco
 */
public class OrdenamientoAleatorio {
    public static void main(String[] args) {
        int[] tamaños = {100, 500, 1000, 5000, 10000};

        System.out.println("Tamaño del arreglo | Burbuja | Inserción | Selección | Mergesort");
        System.out.println("-------------------|---------|-----------|-----------|-----------");

        for (int tamaño : tamaños) {
            double[] arreglo = generarArregloAleatorio(tamaño);

            double[] copiaBurbuja = arreglo.clone();
            long tiempoBurbuja = ordenarBurbuja(copiaBurbuja);

            double[] copiaInsercion = arreglo.clone();
            long tiempoInsercion = ordenarInsercion(copiaInsercion);

            double[] copiaSeleccion = arreglo.clone();
            long tiempoSeleccion = ordenarSeleccion(copiaSeleccion);

            double[] copiaMergesort = arreglo.clone();
            long tiempoMergesort = ordenarMergesort(copiaMergesort);

            System.out.printf("%16d | %7d | %9d | %9d | %9d%n",
                    tamaño, tiempoBurbuja, tiempoInsercion, tiempoSeleccion, tiempoMergesort);
        }
    }

    public static double[] generarArregloAleatorio(int tamaño) {
        double[] arreglo = new double[tamaño];
        Random random = new Random();
        for (int i = 0; i < tamaño; i++) {
            arreglo[i] = random.nextDouble();
        }
        return arreglo;
    }

    public static long ordenarBurbuja(double[] arreglo) {
        long startTime = System.nanoTime();
        int n = arreglo.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arreglo[j] > arreglo[j + 1]) {
                    double temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                }
            }
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    public static long ordenarInsercion(double[] arreglo) {
        long startTime = System.nanoTime();
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
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    public static long ordenarSeleccion(double[] arreglo) {
        long startTime = System.nanoTime();
        int n = arreglo.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arreglo[j] < arreglo[minIndex]) {
                    minIndex = j;
                }
            }
            double temp = arreglo[minIndex];
            arreglo[minIndex] = arreglo[i];
            arreglo[i] = temp;
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    public static long ordenarMergesort(double[] arreglo) {
        long startTime = System.nanoTime();
        mergesort(arreglo, 0, arreglo.length - 1);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    private static void mergesort(double[] arreglo, int izquierda, int derecha) {
        if (izquierda < derecha) {
            int medio = (izquierda + derecha) / 2;
            mergesort(arreglo, izquierda, medio);
            mergesort(arreglo, medio + 1, derecha);
            fusionar(arreglo, izquierda, medio, derecha);
        }
    }

    private static void fusionar(double[] arreglo, int izquierda, int medio, int derecha) {
        int n1 = medio - izquierda + 1;
        int n2 = derecha - medio;

        double[] izq = new double[n1];
        double[] der = new double[n2];

        for (int i = 0; i < n1; i++) {
            izq[i] = arreglo[izquierda + i];
        }
        for (int j = 0; j < n2; j++) {
            der[j] = arreglo[medio + 1 + j];
        }

        int i = 0, j = 0;
        int k = izquierda;
        while (i < n1 && j < n2) {
            if (izq[i] <= der[j]) {
                arreglo[k] = izq[i];
                i++;
            } else {
                arreglo[k] = der[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arreglo[k] = izq[i];
            i++;
            k++;
        }

        while (j < n2) {
            arreglo[k] = der[j];
            j++;
            k++;
        }
    }
}
