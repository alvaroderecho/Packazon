package Productos;

import java.util.*;

public class Pedido {

    private String direcc_entrega;
    private String num_tarjeta_cliente;
    private Date fecha_pedido;
    private boolean urgente;
    private EstadoPedido estado_pedido;
    private boolean pedido_cobrado;
    private boolean pedido_finalizado;

    private List<Producto> prods = new ArrayList<Producto>();

    public Pedido(String dir_entr, String num_tarj, boolean urgent) {
        this.direcc_entrega = dir_entr;
        this.num_tarjeta_cliente = num_tarj;
        this.urgente = urgent;
        this.pedido_cobrado = false;
        this.pedido_finalizado = false;
        this.estado_pedido = EstadoPedido.NO_ENTREGADO;
    }


    public double calcularPrecioPedido() {
        double precio_total=0;
        int unid_total=0;
        for (Producto p: this.prods) {
            precio_total+=p.calcularPrecioProducto();
            unid_total+=p.getUnidades();
        }

        if (unid_total >= 100) {
            precio_total = 0.90 * precio_total;
        }

        return precio_total;
    }

    public void cobrarPedido(){
        this.pedido_cobrado = true;
    }

    public void finalizarPedido(){
        this.pedido_finalizado = true;
        this.fecha_pedido = new Date();
    }

    public EstadoPedido estadoPedido() {
        return this.estado_pedido;
    }

    public void addProducto(int units, double weight, int identifier, boolean secured, String descri, double vol, TipoProducto tipo) {
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

        this.prods.add(p);
    }
}