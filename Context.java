package ejercicioPatronStrategy;
/**
 *
 * @authors Santino Castagno & Mariano Conchillo
 */
public class Context {
    private Strategy formaDeOrdenar;
    
    public void setStrategy(Strategy nuevaFormaDeOrdenar){
       this.formaDeOrdenar = nuevaFormaDeOrdenar; 
    }
    
    public void exeStrategy(int[] valores){
        formaDeOrdenar.sortMyList(valores);
    }
}
