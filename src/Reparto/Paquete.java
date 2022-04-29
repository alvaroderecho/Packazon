package Reparto;

import java.util.ArrayList;
import java.util.List;

import Productos.EstadoProducto;
import Productos.Producto;
/**
 * Clase Paquete
 * @author Joseba Arranz
 * @author Alvaro Derecho
 * @author Salah
 */
public class Paquete {

    private boolean entregado = false; 
    private boolean fallido = false; //Max entregas fallidas realizadas
    private String destino;
    private double peso;
    private TipoPaquete tipo;
    private int num_entregas_fallido = 0;
    private List<Producto> productos = new ArrayList<Producto>();
    /**
     * Constructor
     * @param destino
     * @param peso
     * @param prods
     */
    public Paquete (String destino, double peso, List<Producto> prods, TipoPaquete tipo){
        this.destino = destino;
        this.peso = peso;
        this.productos.addAll(prods);
        this.tipo = tipo;
    }
    /**
     * 
     * @return
     */
    public boolean getEntregado(){
        return this.entregado;
    }
    /**
     * 
     * @return
     */
    public String getDestino(){
        return this.destino;
    }
    /**
     * 
     * @return
     */
    public double getPeso(){
        return this.peso;
    }
    /**
     * 
     * @return
     */
    public int getNumEntregasFallidas(){
        return this.num_entregas_fallido;
    }
    /**
     * 
     * @return
     */
    public List<Producto> getProductos(){
        return this.productos;
    }
    /**
     * 
     * @param e
     */
    public void setEntregado(boolean e){
        this.entregado = e;
    }
    /**
     * 
     * @param d
     */
    public void setDestino(String d){
        this.destino = d;
    }
    /**
     * 
     * @param p
     */
    public void setPeso(double p){
        this.peso = p;
    }
    /**
     * 
     * @param n
     */
    public void setNumEntregasFallidas(int n){
        this.num_entregas_fallido = n;
    }
    /**
     * Añade una entrega fallida
     */
    public void addEntregaFallida(){
        this.num_entregas_fallido += 1;
    }
    /**
     * Cambia el estado de los productos de un paquete
     * @param e
     */
    public void cambiarEstadoProductos(EstadoProducto e){

        for (Producto p:this.productos){
            p.cambiarEstadoProducto(e);
        }
    }
    /**
     * Calcula el peso de un paquete
     * @param p
     * @return
     */

    public boolean getFallido() {
        return this.fallido;
    }

    /**
     * Añade un producto a un paquete
     * @param p
     */
    public void addProductoPaquete(Producto p){
        this.productos.add(p);
    }
    /**
     * Devuelve el peso restante del paquete
     * @return peso restante
     */
    public double getPesoRestante(){
        double peso_restante = 0;
        
        peso_restante = 60 - this.peso;

        return peso_restante;
    }
    /**
     * Devuelve el tipo de paquete
     * @return
     */
    public TipoPaquete getTipoPaquete(){
        return this.tipo;
    }

    @Override
    public String toString(){
        return "Paquete:" + this.productos.toString();
    }

}