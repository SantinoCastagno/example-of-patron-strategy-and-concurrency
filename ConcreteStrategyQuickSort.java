

import java.util.LinkedList;


/*
 * @authors Santino Castagno & Mariano Conchillo
 */
public class ConcreteStrategyQuickSort implements Strategy {

    @Override
    public void sortMyList(LinkedList[] values, int opcion) {
        sortForQuick(values, 0, values.length - 1, opcion);
    }

    private static void sortForQuick(LinkedList[] values, int low, int high, int opcion) {
        if (low < high) {
            int pi = partition(values, low, high, opcion);
            sortForQuick(values, low, pi - 1, opcion);
            sortForQuick(values, pi + 1, high, opcion);
        }
    }

    private static int partition(LinkedList values[], int low, int high, int opcion) {
        //Elegimos como pivote el ultimo elemento
        LinkedList pivot = values[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            // Si el elemento actual es menor o igual al pivote
            if ((int) values[j].get(opcion) <= (int) pivot.get(opcion)) {
                i++;
                // Intercambiamos arr[i] y arr[j]
                LinkedList temp = values[i];
                values[i] = values[j];
                values[j] = temp;
            }
        }
        // Intercambiamos arr[i+1] y arr[high]
        LinkedList temp = values[i + 1];
        values[i + 1] = values[high];
        values[high] = temp;

        return i + 1;
    }

}
