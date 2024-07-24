package challengeOne;

import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        int s = 6;
        int n, tamaño, b = 0,cant=0,cifras=0;
        int digitos[] = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 100000000};
        int numeros[] = new int[9];
        boolean primero = true;
        
        //Definición del tamaño del arreglo
        System.out.println("Ingrese el número de elementos del arreglo: ");
        tamaño = lectura.nextInt();
        int[] nUsuario = new int[tamaño];
        
        //Entrada de datos
        System.out.println("A continuación se ingresarán los valores del arreglo");
        for (int i = 0; i < tamaño; i++) {
            System.out.print("Ingrese el valor " + i + ": ");
            nUsuario[i] = lectura.nextInt();
            System.out.println("");
        }

        //Eliminación de dígitos
        for (int j = 0; j < tamaño; j++) {
            n = nUsuario[j];
            cant=0;
            cifras=0; 
            while(n!=0){             
                n = n/10;         
                cifras++;
            }           
            for (int i = 0; i < 9; i++) { 
                // Se obtiene cada uno de los valores de unidades, decenas, centenas, unidades de mil...
                numeros[i] = (nUsuario[j] / digitos[i]) % 10;
                if (numeros[i] >= s){
                    numeros[i] = -1;
                    cant++; 
                }               
            }                       
            nUsuario[j]=0;           
            for(int i=0; i<9;i++){               
                if (numeros[i]>-1){
                    nUsuario[j]=nUsuario[j]+numeros[i]*digitos[b];
                    b++;
                }
            }           
            if(cifras==cant){
                nUsuario[j]=-1;
            }                     
            b=0;
        }
        //Se invierte y muestra el array resultado por consola
        System.out.print("[");
        for (int i = tamaño - 1; i >= 0; i--) {
            if(nUsuario[i]!=-1){
                if (!primero) {
                    System.out.print(", ");
                }
                System.out.print(nUsuario[i]);
                primero = false;
            }
        }
        System.out.print("]");
    }
}