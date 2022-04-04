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

    private boolean entregado; 
    private String destino;
    private double peso;
    private int num_entregas_fallido;
    private List<Producto> productos;
    /**
     * Constructor
     * @param entregado
     * @param destino
     * @param peso
     * @param num_entregas_fallidas
     */
    public Paquete (boolean entregado, String destino, double peso,int num_entregas_fallidas){
        this.entregado = entregado;
        this.destino = destino;
        this.num_entregas_fallido = num_entregas_fallidas;
        this.peso = peso;
        this.productos = new ArrayList<Producto>();
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
     * @param p
     */
    public void addPeso(double p){
        this.peso += p;
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
    public double calcularPeso (Paquete p){
        
        for (Producto pr:productos){
            p.addPeso(pr.getPeso());
        }
        return p.getPeso();
    
    }


}