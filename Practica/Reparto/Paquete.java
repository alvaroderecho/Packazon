package Reparto;

import java.util.ArrayList;
import java.util.List;

import Productos.Producto;

public class Paquete {

    private boolean entregado; 
    private String destino;
    private double peso;
    private Integer num_entregas_fallido;
    private List<Producto> productos;
    
    public Paquete (boolean entregado, String destino, double peso,Integer num_entregas_fallidas){
        this.entregado = entregado;
        this.destino = destino;
        this.num_entregas_fallido = num_entregas_fallidas;
        this.peso = peso;
        this.productos = new ArrayList<Producto>();
    }

    public boolean getEntregado(){
        return this.entregado;
    }

    public String getDestino(){
        return this.destino;
    }

    public double getPeso(){
        return this.peso;
    }

    public Integer getNumEntregasFallidas(){
        return this.num_entregas_fallido;
    }

    public void setEntregado(boolean e){
        this.entregado = e;
    }

    public void setDestino(String d){
        this.destino = d;
    }

    public void setPeso(double p){
        this.peso = p;
    }
    public void addPeso(double p){
        this.peso += p;
    }

    public void setNumEntregasFallidas(Integer n){
        this.num_entregas_fallido = n;
    }

    public double calcularPeso (Paquete p){
        
        for (Producto pr:productos){
            p.addPeso(pr.getPeso());
           
        return p.getPeso();
    }



















}