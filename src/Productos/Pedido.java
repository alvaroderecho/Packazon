package Productos;

import java.time.LocalDate;
import java.util.*;


import Usuarios.*;
import es.uam.eps.padsof.invoices.IInvoiceInfo;

import es.uam.eps.padsof.invoices.InvoiceSystem;
import es.uam.eps.padsof.invoices.NonExistentFileException;
import es.uam.eps.padsof.invoices.UnsupportedImageTypeException;
import es.uam.eps.padsof.telecard.FailedInternetConnectionException;
import es.uam.eps.padsof.telecard.InvalidCardNumberException;
import es.uam.eps.padsof.telecard.OrderRejectedException;
import es.uam.eps.padsof.telecard.TeleChargeAndPaySystem;

/**
 * Clase pedido
 * @author Joseba Arranz
 * @author Alvaro Derecho
 * @author Salah
 */
public class Pedido implements IInvoiceInfo{

    private Cliente c;
    private int id;
    private String dirr_entreg;
    private LocalDate fecha_pedido;
    private boolean urgente;
    private EstadoPedido estado_pedido = EstadoPedido.NO_ENTREGADO;
    private boolean pedido_cobrado = false;
    private boolean pedido_finalizado = false;
    private double precio_total = 0;
    private Factura factura_p;
    private double discount = 0;

    private int ids_lotes = 1;

    private List<Producto> prods = new ArrayList<Producto>();

    private List<Lote> lotes = new ArrayList<Lote>();
    /**
     * Constructor
     * @param urgent
     * @param id
     * @param dirr_entrega
     */
    public Pedido(boolean urgent, int id, String dirr_entrega) {
        this.id = id;
        this.urgente = urgent;
        this.dirr_entreg = dirr_entrega;
    }
    /**
     * asigna un cliente al pedido
     * @param c
     */
    public void set_cliente(Cliente c){
        this.c  = c;
    }
    /**
     * asigna un id al pedido
     * @param id
     */
    public void setId(int id){
        this.id = id;
    }
    /**
     * Calcula el precio de un pedido y lo añade al precio total
     */
    public void calcularPrecioPedido() {
        double precio_tot = 0;
        int unid_total = 0;
        for (Producto p : this.prods) {
            precio_tot += p.getPrice();
            unid_total += p.getUnidades();
        }

        if (unid_total >= 100) {
            this.discount = precio_tot * 0.10;
            precio_tot = 0.90 * precio_tot;
        }

        this.precio_total = precio_tot;
        return;
    }
    /**
     * Cobra el pedido al cliente
     */
    public void cobrarPedido() {
        this.calcularPrecioPedido(); /** Se guarda en this.precio_total */

        if (!TeleChargeAndPaySystem.isValidCardNumber(this.c.getNumTarjeta()))
            return;
        try {
            TeleChargeAndPaySystem.charge(this.c.getNumTarjeta(), "Pedido", this.precio_total);
        } catch (InvalidCardNumberException i) {
            // TODO: handle exception
            i.printStackTrace();
            // Incorrecto número de tarjeta
        } catch (FailedInternetConnectionException f) {
            // TODO: handle exception
            f.printStackTrace();
            // Conexión errónea
        } catch (OrderRejectedException o) {
            // TODO: handle exception
            o.printStackTrace();
            // Rechazada
        }

        this.pedido_cobrado = true;
    }
    /**
     * Finaliza el pedido actualizando la fecha
     */
    public void finalizarPedido() {
        if (!this.pedido_cobrado) {
            return;
        }

        /** Fecha del pedido */
        ModifiableDate.setToday();
        this.fecha_pedido = ModifiableDate.getModifiableDate();

        /*Hacer factura */
        this.factura_p = new Factura(this.precio_total, this.dirr_entreg, this.c.getDirec_fact(),
                this.c.getNumTarjeta());
             
        try {
            InvoiceSystem.createInvoice(this, "./");
        }
        catch(NonExistentFileException n) {
            n.printStackTrace();
        }
        catch (UnsupportedImageTypeException u) {
            u.printStackTrace();
        }

        this.pedido_finalizado = true;
        this.c.addPedido(this);
        
    }
    /**
     * Devuelve el estado del pedido
     * @return
     */
    public EstadoPedido estadoPedido() {
        return this.estado_pedido;
    }
    /**
     * Crea un producto según el tipo que le indiques
     * @param units
     * @param weight
     * @param identifier
     * @param secured
     * @param descri
     * @param vol
     * @param tipo
     * @return
     */
    public static Producto createProducto(int units, double weight, int identifier, boolean secured, String descri,
            double vol, TipoProducto tipo) {
        Producto p;

        if (tipo == TipoProducto.ESTANDAR) {
            if (weight >= 30)
                return null;
            p = new Estandar(units, weight, identifier, secured, descri, vol);
        }
        else if (tipo == TipoProducto.FRAGIL) {
            if (weight >= 20)
                return null;
            p = new Fragil(units, weight, identifier, secured, descri, vol);
        }
        else if (tipo == TipoProducto.ALIMENTARIO) {
            if (weight >= 30)
                return null;
            p = new Alimentario(units, weight, identifier, secured, descri, vol);
        }
        else if (tipo == TipoProducto.REFRIGERADO) {
            if (weight >= 30)
                return null;
            p = new Refrigerado(units, weight, identifier, secured, descri, vol);
        }
        else if (tipo == TipoProducto.CONGELADO) {
            if (weight >= 30)
                return null;
            p = new Congelado(units, weight, identifier, secured, descri, vol);
        }
        else {
            if (weight >= 30)
                return null;
            p = new Liquido(units, weight, identifier, secured, descri, vol);
        }
        return p;
    }
    /**
     * Añade un producto a un pedido
     * @param units
     * @param weight
     * @param identifier
     * @param secured
     * @param descri
     * @param vol
     * @param tipo
     */
    public void addProductoPedido(int units, double weight, int identifier, boolean secured, String descri, double vol,
            TipoProducto tipo) {
        Producto p = Pedido.createProducto(units, weight, identifier, secured, descri, vol, tipo);
        if (p != null)
            this.prods.add(p);
    }

    /** Getters y Setters */

    /**
     * devuelve si es urgente
     * @return
     */
    public boolean getUrgente() {
        return this.urgente;
    }

    /**
     * devuelve si se ha finalizado
     * @return
     */
    public boolean getFinalizado() {
        return this.pedido_finalizado;
    }


    /**
     * devuelve la direccion de entrega
     * @return
     */
    public String getDirecEntrega() {
        return this.dirr_entreg;
    }
    /**
     * devuelve la lista de productos del pedido
     * @return
     */
    public List<Producto> getProductos(){
        return this.prods;
    }
    /**
     * añade un lote a la lista de lotes
     */
    public void addLote() {
        Lote l = new Lote(this.ids_lotes);
        this.lotes.add(l);
        this.ids_lotes++;
    }
    /**
     * devuelve la factura
     * @return
     */
    public Factura getFactura() {
        return this.factura_p;
    }
    /**
     * devuelve el id
     * @return
     */
    public int getID() {
        return this.id;
    }
    /**
     * Busca un lote en la lsita segun el id y lo devuelve
     * @param id_lote
     * @return
     */
    public Lote getLotebyId(int id_lote) {
        for (Lote l : this.lotes) {
            if (l.getId() == id_lote) {
                return l;
            }
            Lote ll = l.getLotebyId(id_lote);
            if (ll != null)
                return ll;
        }
        return null;
    }
    @Override
    public String toString(){
        return "Pedido " + this.id + this.prods.toString();
    }
    /**
     * Busca un producto en la lista según el id y lo devuelve
     * @param id
     * @return
     */
    public Producto getProductobyId(int id){
        for (Producto p : this.prods) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
    public List<Lote> getLotes(){
        return this.lotes;
    }

    public double getPesoTotal() {
        double pesototal = 0;
        for (Producto p: this.prods) {
            pesototal+=p.getPeso();
        }
        return pesototal;
    }

    /**INVOICE METHODS */

    public String getCompanyLogo () { return "./logo.png"; }

    public String getClientCif() { return this.c.getCif(); }

    public String getCompanyName() { return this.c.getNombreEmpresa(); }

    public double getDiscount() { return this.discount; }

	public double getUrgent() { return 5.0; }

	public String getOrderDate() { return this.fecha_pedido.toString(); }

    public String getOrderIdentifier() { return String.valueOf(this.id); }

    public double getPrice() { return this.precio_total; }

	// public List<IProductInfo> getProducts() { return this.prods;	}
    //NO NOS HA FUNCIONADO

}