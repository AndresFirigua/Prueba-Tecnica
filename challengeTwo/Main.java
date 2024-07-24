package challengeTwo;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int nCondicion=6 , nCantidad;
        int nCondicion2=nCondicion*10+nCondicion;
        boolean primero = true;

        // Entrada array en orden ascendente
        System.out.println("condicion 2: "+nCondicion2);
        System.out.println("Ingrese cantidad de numeros del array: ");
        nCantidad = entrada.nextInt();
        int[] numeros = new int[nCantidad];
        for (int i = 0; i < nCantidad; i++) {
            System.out.println("Ingrese el digito: " + (i) + " : ");
            numeros[i] = entrada.nextInt();
        }

        int[] resultante = new int[nCantidad];
        for (int i = 0; i < nCantidad; i++) {   
            resultante[i] = numeros[i] * numeros[i];
            if(resultante[i]>=nCondicion2){
                resultante[i]=-1;
            }
        }

        //Ordenar resultante(Burbuja)
        for (int i = 0; i < nCantidad; i++) {
            for (int j = 0; j < nCantidad - i - 1; j++) {
                if (resultante[j] > resultante[j + 1]) {
                    int tmp = resultante[j + 1];
                    resultante[j + 1] = resultante[j];
                    resultante[j] = tmp;
                }
            }
        }
        
        //Mostrado de resultado
        System.out.print("[");
        for(int i=0;i<nCantidad;i++){
            if(resultante[i]!=-1){
                if (!primero) {
                    System.out.print(", ");
                }
                System.out.print(resultante[i]);
                primero = false;
            }
        }
        System.out.println("]");
    }
}
