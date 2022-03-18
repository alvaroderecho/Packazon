package Productos;

import java.util.*;
import Usuarios.*;

public class Pedido {

    private String direcc_entrega;
    private String num_tarjeta_cliente;
    private String direcc_fact;
    private Date fecha_pedido;
    private boolean urgente;
    private EstadoPedido estado_pedido;
    private boolean pedido_cobrado;
    private boolean pedido_finalizado;
    private double precio_total;
    private Factura factura_p;


    private List<Producto> prods = new ArrayList<Producto>();

    private List<Lote> lotes = new ArrayList<Lote>();

    public Pedido(String dir_entr, String num_tarj, boolean urgent, String dirrfact) {
        this.direcc_entrega = dir_entr;
        this.num_tarjeta_cliente = num_tarj;
        this.urgente = urgent;
        this.direcc_fact = dirrfact;
        this.pedido_cobrado = false;
        this.pedido_finalizado = false;
        this.precio_total = 0;
        this.estado_pedido = EstadoPedido.NO_ENTREGADO;
    }


    public void calcularPrecioPedido() {
        double precio_tot=0;
        int unid_total=0;
        for (Producto p: this.prods) {
            precio_tot+=p.calcularPrecioProducto();
            unid_total+=p.getUnidades();
        }

        if (unid_total >= 100) {
            precio_tot = 0.90 * precio_tot;
        }

        this.precio_total = precio_tot;
        return;
    }

    public void cobrarPedido(){
        this.calcularPrecioPedido();
        this.factura_p = new Factura(this.precio_total, this.direcc_entrega, this.direcc_fact,this.num_tarjeta_cliente);
        this.pedido_cobrado = true;
    }

    public void finalizarPedido(){
        this.pedido_finalizado = true;
        this.fecha_pedido = new Date();
        /*
        *
        *
        *USAR TIPO MODIFIABLE_DATE
        *
        */
    }

    public EstadoPedido estadoPedido() {
        return this.estado_pedido;
    }

    public static Producto createProducto(int units, double weight, int identifier, boolean secured, String descri, double vol, TipoProducto tipo) {
        Producto p;

        if (tipo == TipoProducto.ESTANDAR) 
            p = new Estandar(units, weight, identifier, secured, descri, vol);
        
        else if (tipo == TipoProducto.FRAGIL) 
            p = new Fragil(units, weight, identifier, secured, descri, vol);
        
        else if (tipo == TipoProducto.ALIMENTARIO) 
            p = new Alimentario(units, weight, identifier, secured, descri, vol);
        
        else if (tipo == TipoProducto.REFRIGERADO) 
            p = new Refrigerado(units, weight, identifier, secured, descri, vol);
        
        else if (tipo == TipoProducto.CONGELADO) 
            p = new Congelado(units, weight, identifier, secured, descri, vol);

        else
            p = new Liquido(units, weight, identifier, secured, descri, vol);

        return p;
    }

    public void addProductoPedido(int units, double weight, int identifier, boolean secured, String descri, double vol, TipoProducto tipo) {
        Producto p = Pedido.createProducto(units, weight, identifier, secured, descri, vol, tipo);
        if (p != null)
            this.prods.add(p);
    }

    /**Getters y Setters */

    public void setDirecEntrega(String dir) {
        this.direcc_entrega = dir;
    }

    public String getDirecEntrega() {
        return this.direcc_entrega;
    }

    public void setNumTarjetaCliente(String num) {
        this.num_tarjeta_cliente = num;
    }

    public String getNumTarjetaCliente() {
        return this.num_tarjeta_cliente;
    }

    public void addLote() {
        Lote l = new Lote();
        this.lotes.add(l);
    }

    public Factura getFactura() {
        return this.factura_p;
    }
}