package Productos;

import sources.enums.*;

public abstract class Producto {
    private int unidades;
    private double peso;
    private int id;
    private ElementoProducto estado;
    private boolean asegurado;
    private double precio_unidad;

    public Producto(int units, double weight, int identifier, boolean secured, double precio) {
        this.unidades = units;
        this.peso = weight;
        this.id = identifier;
        this.asegurado = secured;
        this.precio_unidad = precio;
    }

    public double calcularPrecioProducto() {
        return 0;
    }

}
