package Productos;


import es.uam.eps.padsof.invoices.IProductInfo;
/**
 * Clase abstracta producto
 * @author Joseba Arranz
 * @author Alvaro Derecho
 * @author Salah
 */
public abstract class Producto implements IProductInfo{
    private int unidades;
    private double peso;
    private int id;
    private EstadoProducto estado = EstadoProducto.ALMACEN;
    private boolean asegurado;
    private double precio_extra = 0;
    private double volumen;
    private String descript;

    /**
     * Constructor
     * @param units
     * @param weight
     * @param identifier
     * @param secured
     * @param descri
     * @param vol
     */
    public Producto(int units, double weight, int identifier, boolean secured, String descri, double vol) {
        if (units <=0 || weight <=0 || id < 0 || descri == null)
            return;
        this.unidades = units;
        this.peso = weight;
        this.id = identifier;
        this.asegurado = secured;
        this.volumen = vol;
        this.descript = descri;
    }

    /**
     * devuelve la descripcion de un producto
     * @return
     */
    public String getDescription() {
        return this.descript;
    }

    public String getPriceDetails() {
        /**Poner ifs */
        return this.unidades + "units" + this.precio_extra;
    }
    
    /**
     * devuelve el precio de un producto contando todas las unidades
     * @return
     */
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

    /**
     * devuelve las unidades 
     * @return
     */
    public int getUnidades() {
        return this.unidades;
    }
    /**
     * devuelve el id
     * @return
     */
    public int getId(){
        return this.id;
    }
    /**
     * Añade el numero de unidades de un producto
     * @param uni
     */
    public void setUnidades(int uni) {
        this.unidades = uni;
    }
    /**
     * devuelve el peso de un producto
     * @return
     */
    public double getPeso() {
        return this.peso;
    }
    /**
     * Añade el peso de un producto
     * @param weight
     */
    public void setPeso(double weight) {
        this.peso = weight; 
    }
    /**
     * Añade el precio extra de un producto
     * @param precio
     */
    public void setPrecioExtra(double precio) {
        this.precio_extra = precio;
    }
    /**
     * devuelve el precio extra de un producto
     * @return
     */
    public double getPrecioExtra() {
        return this.precio_extra;
    }
    /**
     * Cambia el estado de un producto
     * @param tipo
     */
    public void  cambiarEstadoProducto(EstadoProducto tipo) {
        this.estado = tipo;
    }
    /**
     * devuelve el estado de un producto
     * @return
     */
    public EstadoProducto getEstadoProducto(){
        return this.estado;
    }

    /**
     * devuelve el volumen
     * @return
     */
    public double getVolumen() {
        return this.volumen;
    }

    /**
     * devuelve si está asegurado
     * @return
     */
    public boolean getAsegurado() {
        return this.asegurado;
    }

}
