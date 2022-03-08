package sources;

public class Alimentario extends Producto{
    private double precioExtra;
    
    public Alimentario(int units, double weight, int identifier, boolean secured) {
        super(units, weight, identifier, secured);
        this.precioExtra = 2;
    }

    public double calcularPrecioProducto() {
        return 0;
    }
    
}
