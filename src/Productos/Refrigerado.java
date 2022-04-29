package Productos;
/**
 * Clase productos refrigerados
 * @author Joseba Arranz
 * @author Alvaro Derecho
 * @author Salah
 */

public class Refrigerado extends Alimentario{
    /**
     * Constructor
     * @param units
     * @param weight
     * @param identifier
     * @param secured
     * @param descri
     * @param vol
     */
    public Refrigerado(int units, double weight, int identifier, boolean secured,String descri, double vol) {
        super(units, weight, identifier, secured, descri, vol);
    }
    @Override
    public boolean isRefrigerado(){
        return true;
    }
}
