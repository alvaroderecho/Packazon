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
    private double precio_total = 0;

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
        if (units <=0 || weight <=0 || id < 0 || descri == null || vol <=0)
            return;
        this.unidades = units;
        this.peso = weight;
        this.id = identifier;
        this.asegurado = secured;
        this.volumen = vol;
        this.descript = descri;
        this.precio_total = getPrice();
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

        if (unidades >= 100) {
            return this.unidades * (this.precio_extra + precio_unidad) * 0.9;
        }
        else {
            return this.unidades * (this.precio_extra + precio_unidad);
        }
        
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
    public double calcularPesoTotal(){
        return this.peso*this.unidades;
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
        this.precio_total = getPrice();
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
    /** 
     * Devuelve el precio del producto
     * @return
     */
    public double getPrecio() {
        return this.precio_total;
    }
    /**
     * Devuelve si el producto es fragil
     * @return
     */
    public boolean isFragil(){
        return false;
    }
    /**
     * Devuelve si el producto es alimentario
     * @return
     */
    public boolean isAlimentario(){
        return false;
    }
    /**
     * Devuelve si el producto es congelado
     * @return
     */
    public boolean isCongelado(){
        return false;
    }
    /**
     * Devuelve si el producto es refrigerado
     * @return
     */
    public boolean isRefrigerado(){
        return false;
    }
    /**
     * Devuelve la string a imprimir
     * @return
     */
    @Override
    public String toString() {
        return "Unidades: " + this.unidades + " , id: " + this.id + " ,description: " + this.descript + " ,peso: " + this.peso + " ,volumen: " + this.volumen + " , precio total: " + this.precio_total + " ";
    }
    // @Override
    // public String toString(){
    //     return this.descript;
    // }

}
