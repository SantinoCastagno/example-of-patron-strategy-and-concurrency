



import java.util.LinkedList;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * @authors Santino Castagno & Mariano Conchillo
 */
public class Client {

    public static void main(String[] args) {

        // Creamos una instancia de Covid que nos retornará el arreglo de países.
        Covid covid = new Covid();
        // Obtenemos todos los países con sus respectivos datos.
        Country[] countries = covid.getCountries();

        // Creamos un arreglo de listas con los datos que nos interesan
        LinkedList[] datosImportantes = cargarLista(countries);

        System.out.println("----------\nCOVID-19\n----------");

        // LLamamos al menú inicial
        int opcion = menuInicial();

        while (opcion != 7) {
            switch (opcion) {
                case 1:
                    ordenarConcurrentemente(datosImportantes, 1);
                    break;
                case 2:
                    ordenarConcurrentemente(datosImportantes, 2);
                    break;
                case 3:
                    ordenarConcurrentemente(datosImportantes, 3);
                    break;
                case 4:
                    ordenarConcurrentemente(datosImportantes, 4);
                    break;
                case 5:
                    ordenarConcurrentemente(datosImportantes, 5);
                    break;
                case 6:
                    ordenarConcurrentemente(datosImportantes, 6);
                    break;
            }
            opcion = menuInicial();
        }

    }

    public static int menuInicial() {

        Scanner sc = new Scanner(System.in);
        System.out.println("¿Sobre qué datos quiere ordenar?");
        System.out.println("1- Nuevos confirmados");
        System.out.println("2- Total confirmados");
        System.out.println("3- Nuevas muertes");
        System.out.println("4- Total muertes");
        System.out.println("5- Nuevos recuperados");
        System.out.println("6- Total recuperados");
        System.out.println("7- SALIR");
        int opcion = sc.nextInt();

        return opcion;
    }

    public static void ordenarConcurrentemente(LinkedList[] datosImportantes, int opc) {

        // Clonamos el array datosImportantes para que cada método de ordenamiento lo utilice
        LinkedList[] lista1 = datosImportantes.clone();
        LinkedList[] lista2 = datosImportantes.clone();
        LinkedList[] lista3 = datosImportantes.clone();

        // Utilizaremos 3 hilos para los 3 métodos de ordenamiento respectivamente
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(3);

        System.out.println("\nEl arreglo se ordenará con 3 métodos diferentes (para comparar la eficiencia de cada uno): ");
        System.out.println("1. Método Burbuja");
        System.out.println("2. Método Burbuja Mejorado");
        System.out.println("3. Método QuickSort\n");

        //Ambos burbujas utilizan el mismo metodo
        GenericTask metodoBurbuja = new GenericTask("Burbuja", lista1, new Context(new ConcreteStrategyBubbleSort()), opc);
        GenericTask metodoBurbujaMejorado = new GenericTask("Burbuja mejorado", lista2, new Context(new ConcreteStrategyBubbleSortOpt()), opc);
        GenericTask metodoQuickSort = new GenericTask("Quicksort", lista3, new Context(new ConcreteStrategyQuickSort()), opc);

        ScheduledFuture<Integer> scheduleBurbuja = ses.schedule(metodoBurbuja, 2, TimeUnit.SECONDS);
        ScheduledFuture<Integer> scheduleBurbujaMej = ses.schedule(metodoBurbujaMejorado, 2, TimeUnit.SECONDS);
        ScheduledFuture<Integer> scheduleQuickSort = ses.schedule(metodoQuickSort, 2, TimeUnit.SECONDS);

        try {
            System.out.println("Método QuickSort tardó: " + scheduleQuickSort.get() + " ns");
            System.out.println("Método Burbuja Mejorado tardó: " + scheduleBurbujaMej.get() + " ns");
            System.out.println("Método Burbuja tardó: " + scheduleBurbuja.get() + " ns\n");
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        ses.shutdown();
        
        mostrar(lista1,opc);
    }

    // Pasamos como parámetro el arreglo que contiene a todos los países con sus datos.
    public static LinkedList[] cargarLista(Country[] countries) {

        LinkedList paisActual;
        // Creamos un nuevo arreglo que contendrá los datos con los que nosotros queremos trabajar.
        LinkedList[] datosImportantes = new LinkedList[countries.length];

        for (int i = 0; i < countries.length; i++) {
            Country country = countries[i];
            paisActual = new LinkedList();
            paisActual.add(country.getCountry());
            paisActual.add(country.getNewConfirmed());
            paisActual.add(country.getTotalConfirmed());
            paisActual.add(country.getNewDeaths());
            paisActual.add(country.getTotalDeaths());
            paisActual.add(country.getNewRecovered());
            paisActual.add(country.getTotalRecovered());
            paisActual.add(country.getDate());
            datosImportantes[i] = paisActual;
        }

        return datosImportantes;
    }
    
    public static void mostrar(LinkedList[] lista, int opc) {
        
        StringBuilder mejores = new StringBuilder("------------------------------\nTop 20 países en mejor estado\n------------------------------\n");
        StringBuilder peores = new StringBuilder("------------------------------\nTop 20 países en peor estado\n------------------------------\n");
        
        int longitud = lista.length-1;
        
        for(int i=0; i<20; i++) {
            mejores.append(lista[i].get(7)+"\t"+lista[i].get(opc)+"\t"+lista[i].get(0)+"\n");
            peores.append(lista[longitud-i].get(7)+"\t"+lista[longitud-i].get(opc)+"\t"+lista[longitud-i].get(0)+"\n");
        }
        System.out.println(mejores.toString());
        System.out.println(peores.toString());
        
        
    }
}
