package ejercicioPatronStrategy;

/*
 * @authors Santino Castagno & Mariano Conchillo
*/

public class ConcreteStrategyBubbleSort implements Strategy{

    @Override
    public void sortMyList(int[] values) {
        int longitud = values.length;
        for (int i = 0; i < longitud - 1; i++) {
            for (int j = 0; j < longitud - i - 1; j++) {
                if (values[j] > values[j + 1]) {
                    int temp = values[j];
                    values[j] = values[j + 1];
                    values[j + 1] = temp;
                }
            }
        }
    }
}
