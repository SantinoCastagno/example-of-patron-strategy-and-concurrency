

import java.util.LinkedList;

/**
 ** @authors Santino Castagno & Mariano Conchillo
 */
public class ConcreteStrategyBubbleSortOpt implements Strategy {

    @Override
    public void sortMyList(LinkedList[] values, int opcion) {
        final int TAM = values.length;
        LinkedList temp;
        boolean swapped;

        for (int i = 0; i < TAM - 1; i++) {
            swapped = false;
            for (int j = 0; j < (TAM - i - 1); j++) {
                if ((int) values[j].get(opcion) > (int) values[j + 1].get(opcion)) {
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
