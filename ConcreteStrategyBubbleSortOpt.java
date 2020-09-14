/**
 ** @authors Santino Castagno & Mariano Conchillo
*/

public class ConcreteStrategyBubbleSortOpt implements Strategy {

    @Override
    public void sortMyList(int[] values) {
        final int TAM = values.length;
        int temp = 0;
        boolean swapped;

        for (int i = 0; i < TAM - 1; i++) {
            swapped = false;
            for (int j = 0; j < (TAM - i - 1); j++) {
                if (values[j] > values[j + 1]) {
                    // swapping elements
                    temp = values[j];
                    values[j] = values[j + 1];
                    values[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }


}
