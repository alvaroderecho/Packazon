package Productos;

public class Alimentario extends Producto{
    
    public Alimentario(int units, double weight, int identifier, boolean secured,String descri, double vol) {
        super(units, weight, identifier, secured, descri, vol);
        this.setPrecioExtra(2);
    }
}