package Productos;

import java.util.*;

public class Pedido {

    private String direcc_entrega;
    private String num_tarjeta_cliente;
    private Date fecha_pedido;
    private boolean urgente;
    private boolean pedido_cobrado;
    private boolean pedido_finalizado;


    public double calcularPrecioPedido() {
        return 0;
    }

    public void cobrarPedido(){}

    public void finalizarPedido(){}
}