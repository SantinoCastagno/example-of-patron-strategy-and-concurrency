

import java.util.LinkedList;

/*
 * @authors Santino Castagno & Mariano Conchillo
 */
public class ConcreteStrategyBubbleSort implements Strategy {

    @Override
    public void sortMyList(LinkedList[] paises, int opcion) {
        int longitud = paises.length;
        LinkedList temp;

        for (int i = 0; i < longitud - 1; i++) {
            for (int j = 0; j < longitud - i - 1; j++) {
                if ((int) paises[j].get(opcion) > (int) paises[j + 1].get(opcion)) {
                    temp = paises[j];
                    paises[j] = paises[j + 1];
                    paises[j + 1] = temp;
                }
            }

        }
    }
}
