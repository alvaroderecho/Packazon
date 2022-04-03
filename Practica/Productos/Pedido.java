package Productos;

import java.time.LocalDate;
import java.util.*;

//import javax.print.attribute.intSyntax;
import javax.print.attribute.IntegerSyntax;
import Usuarios.*;
import es.uam.eps.padsof.invoices.IInvoiceInfo;
import es.uam.eps.padsof.invoices.IProductInfo;
import es.uam.eps.padsof.invoices.InvoiceSystem;
import es.uam.eps.padsof.invoices.NonExistentFileException;
import es.uam.eps.padsof.invoices.UnsupportedImageTypeException;
import es.uam.eps.padsof.telecard.FailedInternetConnectionException;
import es.uam.eps.padsof.telecard.InvalidCardNumberException;
import es.uam.eps.padsof.telecard.OrderRejectedException;
import es.uam.eps.padsof.telecard.TeleChargeAndPaySystem;

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

    public Pedido(Cliente c, boolean urgent, int id, String dirr_entrega) {
        this.id = id;
        this.urgente = urgent;
        this.dirr_entreg = dirr_entrega;
        this.c = c;
    }

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

        
    }

    public EstadoPedido estadoPedido() {
        return this.estado_pedido;
    }

    public static Producto createProducto(int units, double weight, int identifier, boolean secured, String descri,
            double vol, TipoProducto tipo) {
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

    public void addProductoPedido(int units, double weight, int identifier, boolean secured, String descri, double vol,
            TipoProducto tipo) {
        Producto p = Pedido.createProducto(units, weight, identifier, secured, descri, vol, tipo);
        if (p != null)
            this.prods.add(p);
    }

    /** Getters y Setters */

    public String getDirecEntrega() {
        return this.dirr_entreg;
    }

    public void addLote() {
        Lote l = new Lote(this.ids_lotes);
        this.lotes.add(l);
        this.ids_lotes++;
    }

    public Factura getFactura() {
        return this.factura_p;
    }

    public int getID() {
        return this.id;
    }

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

}