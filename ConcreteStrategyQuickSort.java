package ejercicioPatronStrategy;

/*
 * @authors Santino Castagno & Mariano Conchillo
*/

public class ConcreteStrategyQuickSort implements Strategy{

    @Override
    public void sortMyList(int[] values) {
        sortForQuick(values, 0, values.length - 1);
    }

    private static void sortForQuick(int[] values, int low, int high) {
        if (low < high) {
            int pi = partition(values, low, high);

            sortForQuick(values, low, pi - 1);
            sortForQuick(values, pi + 1, high);
        }
    }

    private static int partition(int values[], int low, int high) {
        int pivot = values[high]; // Elegimos como pivote al último elemento
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            // Si el elemento actual es menor o igual al pivote
            if (values[j] <= pivot) {
                i++;
                // Intercambiamos arr[i] y arr[j]
                int temp = values[i];
                values[i] = values[j];
                values[j] = temp;
            }
        }
        // Intercambiamos arr[i+1] y arr[high]
        int temp = values[i + 1];
        values[i + 1] = values[high];
        values[high] = temp;

        return i + 1;
    }

}
