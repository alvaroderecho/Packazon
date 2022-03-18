package Productos;

public abstract class Producto {
    private int unidades;
    private double peso;
    private int id;
    private EstadoProducto estado;
    private boolean asegurado;
    private double precio_extra;
    private double volumen;
    private String descript;


    public Producto(int units, double weight, int identifier, boolean secured, String descri, double vol) {
        if (units <=0 || weight <=0 || id < 0)
            return;
        this.unidades = units;
        this.peso = weight;
        this.id = identifier;
        this.asegurado = secured;
        this.precio_extra = 0;
        this.volumen = vol;
        this.descript = descri;
        this.estado = EstadoProducto.ALMACEN;       /*Al incializar se encuentra en almacén*/
    }


    public double calcularPrecioProducto() {
        double precio_unidad = 0;

        /**Precio por unidad en función del peso */

        if (this.peso < 1)
            precio_unidad = 0.40;
        else if (this.peso > 5)
            precio_unidad = 1;
        else {
            precio_unidad = 0.60;
        }

        return this.unidades * (this.precio_extra + precio_unidad);
    }


    /**Getters y Setters */
    public int getUnidades() {
        return this.unidades;
    }

    public void setUnidades(int uni) {
        this.unidades = uni;
    }

    public double getPeso() {
        return this.peso;
    }

    public void setPeso(double weight) {
        this.peso = weight; 
    }

    public void setPrecioExtra(double precio) {
        this.precio_extra = precio;
    }

    public double getPrecioExtra() {
        return this.precio_extra;
    }

    public void  cambiarEstadoProducto(EstadoProducto tipo) {
        this.estado = tipo;
    }

}
