package challengeThree;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada=new Scanner(System.in);
        boolean bandera=true, bandera2=true;
        int contador=1;
        int contador2=1;
        int binario;
        int cuenta=0;
        int numero=0,numero2=0;
        
        System.out.print("Ingrese el número de monedas: ");
        System.out.println("");
        int tamaño=entrada.nextInt();
        int array[]=new int[tamaño];
        int recorrido[]=new int[tamaño];        
        
        
        for(int i=0;i<tamaño;i++){
            System.out.println("Ingrese el valor del la moneda "+(i+1));
            array[i]=entrada.nextInt();
        }
        
        for(int i=0;i<tamaño;i++){
            recorrido[i]=0;
        }
        
        Arrays.sort(array);
                
        while (bandera) {
            while (tamaño>numero&&bandera2) {
                numero=0;
                cuenta=0;
                
                binario = Integer.parseInt(Integer.toBinaryString(contador));
                
                for (int i = 0; i < tamaño; i++) {
                    recorrido[i] = (int) (binario / (Math.pow(10, i)) % 10);
                }
                
                for (int i = 0; i < tamaño; i++) {    
                    if (recorrido[i] == 1) {
                        cuenta += array[i];
                    }
                }
                
                if (cuenta == contador2) {
                    bandera2=false;
                    numero2++;
                }
                
                contador++;
                
                for(int i=0;i<tamaño;i++){
                    numero+=recorrido[i];
                }
        }
        if (numero2==0) {
            bandera = false;
        }
        cuenta = 0;
        contador = 1;
        contador2++;
        numero=0;
        bandera2=true;
        numero2=0;
        }
        
        contador2--;
        
        System.out.println("No se pueden dar vueltas de: "+contador2);
    }
}
