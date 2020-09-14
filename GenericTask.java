import javax.xml.namespace.QName;
import java.util.concurrent.Callable;

public class GenericTask implements Callable{

    private final String name;
    private final int[] arr;
    private Context enfoque;

    public GenericTask(String name, int[] arr, Context enfoque) {
        this.name = name;
        this.arr = arr;
        this.enfoque = enfoque;
    }

    @Override
    public Long call() {
        long tiempoInicio = System.currentTimeMillis();
        enfoque.exeStrategy(arr);
        System.out.println("El método "+ this.name +" terminó.");
        return System.currentTimeMillis() - tiempoInicio;
    }

}
