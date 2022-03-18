package Productos;

import java.util.*;

public class Lote {
    private boolean fragil;
    private boolean alim;
    private boolean std;

    private List <Producto> prods = new ArrayList<Producto>();

    private List <Lote> lotes = new ArrayList<Lote>();

    public Lote() {
        this.alim = false;
        this.fragil = false;
        this.std = false;
    }

    
    public void addProductLote(int units, double weight, int identifier, boolean secured, String descri, double vol, TipoProducto tipo) {
        
        if ((this.alim == true && tipo == TipoProducto.ESTANDAR) || (this.std == true && tipo == TipoProducto.ALIMENTARIO) ) {
            /**Dentro de un mismo lote no se pueden juntar productos alimentarios con estándares */
            return;
        }
        
        Producto p = Pedido.createProducto(units, weight, identifier, secured, descri, vol, tipo);
        if (p!=null) {

            if (tipo == TipoProducto.FRAGIL)
                /**Si el lote contiene un producto frágil, el lote será frágil */
                this.fragil = true;

            else if (tipo == TipoProducto.ALIMENTARIO)
                this.alim = true;
            else if (tipo == TipoProducto.ESTANDAR)
                this.std = true;

            this.prods.add(p);
        }
    }

    public void addLoteLote() {
        Lote l = new Lote();
        this.lotes.add(l);
    }
}
