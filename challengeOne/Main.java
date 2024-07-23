package challengeOne;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner entradaDatos= new Scanner(System.in);
        // int[] numeros= {1, 2, 3, 4, 5, 6};
        int numeros[], resultado[], nCantidad, aux;
        System.out.println("Digite tamaño de array: ");
        nCantidad = entradaDatos.nextInt();
        
        numeros = new int[nCantidad];

        for (int i = 0; i < nCantidad; i++) {
            System.out.println((i+1) + " Digite un numero: ");
            numeros[i] = entradaDatos.nextInt();
        }
        resultado = new int[nCantidad];
        aux= (nCantidad-1);

        System.out.println("El arreglo original es: ");
        System.out.println(Arrays.toString(numeros));

        for (int i = 0; i < numeros.length; i++) {
            if(numeros[aux] == 6){
                resultado[i]= 0;
            }else{
                resultado[i]= numeros[aux];
            }
            aux--;
        }
        System.out.println("El arreglo invertido es: ");
        System.out.println(Arrays.toString(resultado));
    }
}