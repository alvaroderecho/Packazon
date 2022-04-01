package Productos;

import es.uam.eps.padsof.invoices.IInvoiceInfo;
import es.uam.eps.padsof.invoices.IProductInfo;

public abstract class Producto implements IProductInfo{
    private int unidades;
    private double peso;
    private Integer id;
    private EstadoProducto estado = EstadoProducto.ALMACEN;
    private boolean asegurado;
    private double precio_extra = 0;
    private double volumen;
    private String descript;


    public Producto(int units, double weight, int identifier, boolean secured, String descri, double vol) {
        if (units <=0 || weight <=0 || id < 0)
            return;
        this.unidades = units;
        this.peso = weight;
        this.id = identifier;
        this.asegurado = secured;
        this.volumen = vol;
        this.descript = descri;
    }

    
    public String getDescription() {
        return this.descript;
    }

    public String getPriceDetails() {
        /**Poner ifs */
        return this.unidades + "units" + this.precio_extra;
    }

    public double getPrice() {
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
    public Integer getUnidades() {
        return this.unidades;
    }

    public void setUnidades(Integer uni) {
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

    public EstadoProducto getEstadoProducto(){
        return this.estado;
    }

}
