package Productos;
/**
 * Clase productos estandar
 * @author Joseba Arranz
 * @author Alvaro Derecho
 * @author Salah
 */

public class Estandar extends Producto{
    /**
     * Constructor
     * @param units
     * @param weight
     * @param identifier
     * @param secured
     * @param descri
     * @param vol
     */
    public Estandar(int units, double weight, int identifier, boolean secured,String descri, double vol) {
        super(units, weight, identifier, secured, descri, vol);
        
    }
}
