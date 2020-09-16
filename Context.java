

import java.util.LinkedList;


/**
 *
 * @authors Santino Castagno & Mariano Conchillo
 */
public class Context {
    private Strategy formaDeOrdenar;

    //Constructor definido explicitamente para que el contexto tenga una estrategia de manera obligatoria.
    public Context(Strategy primerEstrategia){
        formaDeOrdenar = primerEstrategia;
    }
    
    public void setStrategy(Strategy nuevaFormaDeOrdenar){
       this.formaDeOrdenar = nuevaFormaDeOrdenar; 
    }
    
    public void exeStrategy(LinkedList[] paises, int opcion){
        formaDeOrdenar.sortMyList(paises, opcion);
    }
}
