package Productos;

public class Fragil extends Producto{
    public Fragil(int units, double weight, int identifier, boolean secured,String descri, double vol) {
        super(units, weight, identifier, secured, descri, vol);
        this.setPrecioExtra(2);
        if (secured)
            this.setPrecioExtra(5);
    }
}
