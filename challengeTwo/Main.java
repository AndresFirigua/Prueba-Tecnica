package challengeTwo;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int[] potencias = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 100000000};
        int nCondicion = 66, nCantidad, n, cant = 0, cifras = 0, b = 0;
        int auxiliar[] = new int[9];

        // Entrada array en orden ascendente
        System.out.println("Ingrese cantidad de numeros del array: ");
        nCantidad = entrada.nextInt();
        int[] numeros = new int[nCantidad];
        for (int i = 0; i < nCantidad; i++) {
            System.out.println("Ingrese el digito: " + (i) + " : ");
            numeros[i] = entrada.nextInt();
        }

        //Elementos al cuadrado:
        int[] resultante = new int[nCantidad];
        for (int i = 0; i < nCantidad; i++) {
            resultante[i] = numeros[i] * numeros[i];
        }

        // Eliminar de array resultante los números iguales o mayores de 66
        for (int j = 0; j < nCantidad; j++) {
            n = resultante[j];
            cant = 0;
            cifras = 0;

            while (n != 0) {
                n = n / 10;
                cifras++;
            }

            for (int i = 0; i < 9; i++) { // Se obtiene cada uno de los valores de unidades, decenas, centenas, unidades de mil...
                auxiliar[i] = (resultante[j] / potencias[i]) % 10;
                if (resultante[j] >= nCondicion) {
                    auxiliar[i] = -1;
                    //System.out.println(auxiliar[i]);
                    cant++;
                }else if (resultante[j] * resultante[j] == 0) {
                    auxiliar[i] = auxiliar[i];
                    cant++;
                }
            }
            resultante[j] = 0;
            for (int i = 0; i < 9; i++) {
                if (auxiliar[i] > -1) {
                    resultante[j] = resultante[j] + auxiliar[i] * potencias[b];
                    b++;
                }
            }
            if (cifras == cant) {
                resultante[j] = -1;
            }
            b = 0;
        }

        // Filtrar el array resultante
        int validCount = 0;
        for (int i = 0; i < nCantidad; i++) {
            if (resultante[i] != -1) {
                validCount++;
            }
        }

        int[] filtrado = new int[validCount];
        int index = 0;
        for (int i = 0; i < nCantidad; i++) {
            if (resultante[i] != -1) {
                filtrado[index++] = resultante[i];
            }
        }

        // Ordenar el array resultante (burbuja)
        for (int i = 0; i < validCount - 1; i++) {
            for (int j = 0; j < validCount - 1 - i; j++) {
                if (filtrado[j] > filtrado[j + 1]) {
                    int temp = filtrado[j];
                    filtrado[j] = filtrado[j + 1];
                    filtrado[j + 1] = temp;
                }
            }
        }

        // Mostrar el array resultante usando un ciclo for
        System.out.print("[");
        for (int i = 0; i < filtrado.length; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(filtrado[i]);
        }
        System.out.println("]"); 
    }
}
