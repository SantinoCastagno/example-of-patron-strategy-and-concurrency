package ejercicioPatronStrategy;

import java.util.Scanner;

/**
 *
 * @authors Santino Castagno & Mariano Conchillo
 */
public class Client {

    static public final int TAM = 20000;

    public static void main(String[] args) {
        Context context = new Context();
        boolean opcionInvalida = true;
        Scanner sc = new Scanner(System.in);
        int[] listaEstatica = new int[TAM];
        long tComienzo, tFinal;

        System.out.println("Cargando arreglo con numeros aleatorios...");
        for (int i = 0; i < TAM; i++) {
            listaEstatica[i] = (int) (Math.random() * 100000);
        }
        System.out.println("Lista recien horneada\n"+listaEstaticaToString(listaEstatica));
        do {
            //Se le permite elegir la opción al user.
            System.out.println("¿Que algoritmo de ordenamiento desea utilizar?\n1.BubbleSort\n2.QuickSort");
            switch (sc.nextInt()) {
                case 1:
                    context.setStrategy(new ConcreteStrategyBubbleSort());
                    opcionInvalida = false;
                    break;
                case 2:
                    context.setStrategy(new ConcreteStrategyQuickSort());
                    opcionInvalida = false;
                    break;
                default:
                    System.out.println("Opcion invalida.");
                    break;
            }
        } while (opcionInvalida);
        tComienzo = System.currentTimeMillis();
        context.exeStrategy(listaEstatica);
        tFinal = System.currentTimeMillis();
        
        System.out.println("Lista luego de ordenar\n"+listaEstaticaToString(listaEstatica));
        System.out.println("El metodo de ordenamiento tardo: " + (tFinal- tComienzo) + " ms en ordenar");
    }

    public static String listaEstaticaToString(int[] values) {
        int tamArray = values.length;
        String listaEnTexto = "";

        for (int i = 0; i < tamArray; i++) {
            listaEnTexto += "["+values[i]+"]";
        }
        return listaEnTexto;
    }
}
