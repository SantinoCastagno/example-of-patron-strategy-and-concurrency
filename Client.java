
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * @authors Santino Castagno & Mariano Conchillo
 */
public class Client {

    static public final int TAM = 10000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean opcionInvalida = true;
        int[] listaEstatica = new int[TAM];
        long tComienzo, tFinal;

        // Cargamos el arreglo con números random
        cargarArreglo(listaEstatica);

        int[] lista1 = listaEstatica.clone();
        int[] lista2 = listaEstatica.clone();
        int[] lista3 = listaEstatica.clone();

        // Utilizaremos 3 hilos para los 3 métodos de ordenamiento respectivamente
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(3);

        System.out.println("El arreglo de longitud ingresada se ordenará con 3 métodos diferentes: ");
        System.out.println("1. Método Burbuja");
        System.out.println("2. Método Burbuja Mejorado");
        System.out.println("3. Método QuickSort");

        //Ambos burbujas utilizan el mismo metodo
        GenericTask metodoBurbuja = new GenericTask("Burbuja", lista1, new Context(new ConcreteStrategyBubbleSort()));
        GenericTask metodoBurbujaMejorado = new GenericTask("Burbuja mejorado", lista2, new Context(new ConcreteStrategyBubbleSortOpt()));
        GenericTask metodoQuickSort = new GenericTask("Quicksort", lista3, new Context(new ConcreteStrategyQuickSort()));

        ScheduledFuture<Integer> scheduleBurbuja = ses.schedule(metodoBurbuja, 2, TimeUnit.SECONDS);
        ScheduledFuture<Integer> scheduleBurbujaMej = ses.schedule(metodoBurbujaMejorado, 2, TimeUnit.SECONDS);
        ScheduledFuture<Integer> scheduleQuickSort = ses.schedule(metodoQuickSort, 2, TimeUnit.SECONDS);

        try {
            System.out.println("Método QuickSort tardó: " + scheduleQuickSort.get() + " ms");
            System.out.println("Método Burbuja Mejorado tardó: " + scheduleBurbujaMej.get() + " ms");
            System.out.println("Método Burbuja tardó: " + scheduleBurbuja.get() + " ms");
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        ses.shutdown();
    }

    public static String listaEstaticaToString(int[] values) {
        int tamArray = values.length;
        String listaEnTexto = "";

        for (int i = 0; i < tamArray; i++) {
            listaEnTexto += "[" + values[i] + "]";
        }
        return listaEnTexto;
    }

    // metodo para cargar el arreglo con numeros random
    public static void cargarArreglo(int[] arr) {
        Random ran = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = ran.nextInt(1001) + 1;
        }
    }
}
