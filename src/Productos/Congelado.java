package Productos;
/**
 * Clase productos congelados
 * @author Joseba Arranz
 * @author Alvaro Derecho
 * @author Salah
 */
public class Congelado extends Alimentario{
    /**
     * Constructor
     * @param units
     * @param weight
     * @param identifier
     * @param secured
     * @param descri
     * @param vol
     */
    public Congelado(int units, double weight, int identifier, boolean secured,String descri, double vol) {
        super(units, weight, identifier, secured, descri, vol);
    }
    @Override
    public boolean isCongelado(){
        return true;
    }
}
