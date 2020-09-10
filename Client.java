package ejercicioPatronStrategy;

import java.util.Scanner;

/**
 *
 * @authors Santino Castagno & Mariano Conchillo
 */
public class Client {
    static public final int TAM = 10000;
    
    public static void main(String[] args) {
        Context context = new Context();
        boolean opcionInvalida = true;
        Scanner sc = new Scanner(System.in);
        int[] listaEstatica = new int[TAM];
        long tComienzo, tFinal;

        do {
            //Se le permite elegir la opción al user.
            System.out.println("¿Que algoritmo de ordenamiento desea utilizar?\n1.BubbleSort\n2.QuickSort");
            switch (sc.nextInt()){
                case 1:
                    context.setStrategy(new ConcreteStrategyBubbleSort());
                    break;
                case 2:
                    context.setStrategy(new ConcreteStrategyQuickSort());
                    break;
                default:
                    System.out.println("Opcion invalida.");
                    break;
            }
        } while (opcionInvalida);
        
        for (int i = 0; i < TAM; i++) {
            listaEstatica[i] = (int) (Math.random()*100000);
        }
        
       
        tComienzo = System.currentTimeMillis()*1000;
        context.exeStrategy(listaEstatica); 
        tFinal = System.currentTimeMillis()*1000;
        System.out.println(listaEstatica);
        
    }
}
