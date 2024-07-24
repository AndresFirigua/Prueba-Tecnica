package challengeTwo;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Proceso elevar cada elemento al cuadrado y dejarlo en orden ascendente,
        //si es mayor a su equivalente numero de 2,3,4 cifras eliminar del array,
        //
        
        Scanner entrada = new Scanner(System.in);
        int[] potencias = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 100000000};
        int numeros[], nCondicion = 6, resultante[], nCantidad,n,cant=0,cifras=0,b=0;
        int auxiliar[] = new int[9];
        
        //Entrada array en orden ascendente
        System.out.println("Ingrese cantidad de numeros del array: ");
        nCantidad=entrada.nextInt();
        numeros = new int[nCantidad];
        for (int i = 0; i < nCantidad; i++) {
            System.out.println("Ingrese el digito: " + (i) + " : ");
            numeros[i]= entrada.nextInt();
        }

        resultante = new int[nCantidad];
        for (int i = 0; i < nCantidad; i++) {
            resultante[i] = numeros[i]*numeros[i];
            System.out.println(resultante[i]);
        }
        //eliminar de array resultante los numeros iguales o mayores de 7
        for (int j = 0; j < nCantidad; j++) {
            n = resultante[j];
            cant=0;
            cifras=0;

            while (n!=0) {
                n=n/10;
                cifras++;
            }

            for (int i = 0; i < 9; i++) { // Se obtiene cada uno de los valores de unidades, decenas, centenas, unidades de mil...
                auxiliar[i] = (resultante[j] / potencias[i]) % 10;
                System.out.println("El numero: " + auxiliar[i]);
                if (resultante[j] >= 66){
                    // auxiliar[i] = (resultante[j] / resultante[j]);
                    auxiliar[i] = -1;
                    // System.out.println(auxiliar[i]);
                    cant++; 
                }               
            }                       
            resultante[j]=0;
            for(int i=0; i<9;i++){               
                if (auxiliar[i]>-1){
                    //restaurar los elementos del array a como estaban
                    resultante[j]=resultante[j]+auxiliar[i]*potencias[b];
                    b++;
                }
            }           
            if(cifras==cant){
                resultante[j]=-1;
            }                     
            b=0;
        }
        for (int i = nCantidad - 1; i >= 0; i--) {
            if(resultante[i]!=-1 && resultante[i]!=0){
                System.out.print(resultante[i] + " ");
            }           
        }  
        // for (int i = 0; i < auxiliar.length; i++) {
        //     if (auxiliar[i]>0) {
        //         System.out.print(auxiliar[i] + " ");
        //     }
        // }
        // System.out.println(Arrays.toString(resultante));
    }
}
