package Productos;
/**
 * Clase productos fragiles
 * @author Joseba Arranz
 * @author Alvaro Derecho
 * @author Salah
 */

public class Fragil extends Producto{

    /**
     * Constructor
     * @param units
     * @param weight
     * @param identifier
     * @param secured
     * @param descri
     * @param vol
     */
    public Fragil(int units, double weight, int identifier, boolean secured,String descri, double vol) {
        super(units, weight, identifier, secured, descri, vol);
        this.setPrecioExtra(2);

        if (secured)        /**Si está asegurado */
            this.setPrecioExtra(5);
    }
}
