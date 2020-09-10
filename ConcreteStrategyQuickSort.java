package ejercicioPatronStrategy;

/*
 * @authors Santino Castagno & Mariano Conchillo
*/

public class ConcreteStrategyQuickSort {

    public static void sortMyList(int[] a) {
        sortForQuick(a, 0, a.length - 1);
    }

    private static void sortForQuick(int[] a, int low, int high) {
        if (low < high) {
            int pi = partition(a, low, high);

            sortForQuick(a, low, pi - 1);
            sortForQuick(a, pi + 1, high);
        }
    }

    private static int partition(int a[], int low, int high) {
        int pivot = a[high]; // Elegimos como pivote al último elemento
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            // Si el elemento actual es menor o igual al pivote
            if (a[j] <= pivot) {
                i++;
                // Intercambiamos arr[i] y arr[j]
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        // Intercambiamos arr[i+1] y arr[high]
        int temp = a[i + 1];
        a[i + 1] = a[high];
        a[high] = temp;

        return i + 1;
    }

}
