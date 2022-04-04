package Productos;
/**
 * Clase productos alimentarios
 * @author Joseba Arranz
 * @author Alvaro Derecho
 * @author Salah
 */
public class Alimentario extends Producto{
    /**
     * Constructor
     * @param units
     * @param weight
     * @param identifier
     * @param secured
     * @param descri
     * @param vol
     */
    public Alimentario(int units, double weight, int identifier, boolean secured,String descri, double vol) {
        super(units, weight, identifier, secured, descri, vol);
        this.setPrecioExtra(2);
    }
}