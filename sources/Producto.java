package sources;

import sources.enums.ElementoProducto;

public abstract class Producto {
    private int unidades;
    private double peso;
    private int id;
    private ElementoProducto estado;
    private boolean asegurado;

    public Producto(int units, double weight, int identifier, boolean secured) {
        this.unidades = units;
        this.peso = weight;
        this.id = identifier;
        this.asegurado = secured;
    }

    public double calcularPrecioProducto() {
        
    }

}
