package ejercicioPatronStrategy;

/*
 * @authors Santino Castagno & Mariano Conchillo
*/

public class ConcreteStrategyBubbleSort {

    public void sortMyList(int arr[]) {
        int longitud = arr.length;
        for (int i = 0; i < longitud - 1; i++) {
            for (int j = 0; j < longitud - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j+1] and arr[i] 
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
