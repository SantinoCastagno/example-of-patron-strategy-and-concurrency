package pkfinal;

import java.util.LinkedList;
import java.util.concurrent.Callable;

public class GenericTask implements Callable{

    private final String name;
    private final LinkedList[] paises;
    private final Context enfoque;
    private int opcion;

    public GenericTask(String name, LinkedList[] paises, Context enfoque, int opcion) {
        this.name = name;
        this.paises = paises;
        this.enfoque = enfoque;
        this.opcion = opcion;
    }

    @Override
    public Long call() {
        long tiempoInicio = System.nanoTime();
        enfoque.exeStrategy(paises, opcion);
        return System.nanoTime() - tiempoInicio;
    }

}
