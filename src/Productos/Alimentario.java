package Productos;
/**
 * Clase productos alimentarios
 * @author Joseba Arranz
 * @author Alvaro Derecho
 * @author Salah
 */
import Usuarios.VariablesGlobales;
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
        this.setPrecioExtra(VariablesGlobales.getTasaAlim());
    }
    /**
     * Devuelve si es alimentario
     * @return
     */
    @Override
    public boolean isAlimentario(){
        return true;
    }
    /**
     * Devuelve si es congelado
     * @return
     */
    public boolean isCongelado(){
        return false;
    }
    /**
     * Devuelve si es refirgerado
     * @return
     */
    public boolean isRefrigerado(){
        return false;
    }

}