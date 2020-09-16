
import java.util.LinkedList;


/**
 *
 * @authors Santino Castagno & Mariano Conchillo
 */
public interface Strategy {
    
    // La opción es el valor elegido por el usuario que utilizaremos para reordenar la lista.
    
    public void sortMyList(LinkedList[] paises, int opcion);
}
