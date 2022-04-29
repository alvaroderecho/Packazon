package Productos;
import Reparto.Paquete;
import Reparto.TipoPaquete;
import java.util.*;
/**
 * Clase Lotes
 * @author Joseba Arranz
 * @author Alvaro Derecho
 * @author Salah
 */
public class Lote {
    private boolean fragil = false;
    private boolean alim = false;
    private boolean std = false;

    private int id;

    private int n_lotes = 0;

    private List <Producto> prods = new ArrayList<Producto>();

    private List <Lote> lotes = new ArrayList<Lote>();
    /**
     * Constructor
     * @param identifier
     */
    public Lote(int identifier) {
        this.id = identifier;
    }
    /**
     * Busca un producto en el array por el id 
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
    /**
     * Añade un producto a un lote
     * @param units
     * @param weight
     * @param identifier
     * @param secured
     * @param descri
     * @param vol
     * @param tipo
     */
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
    /**
     * Añade un lote a un lote
     */
    public void addLoteLote() {
        Lote l = new Lote(id * 100 + n_lotes);
        this.lotes.add(l);
        this.n_lotes++;
    }
    /**
     * devuelve el id del producto
     * @return
     */
    public int getId() {
        return this.id;
    }

    /**
     * devuelve si el lote es fragil
     * @return
     */
    public boolean getFragil() {
        return this.fragil;
    }

    /**
     * Busca un lote segun un id en el array 
     * @param id_lote
     * @return
     */
    public Lote getLotebyId(int id_lote) {
        for (Lote l: this.lotes) {
            if (l.id == id_lote) {
                return l;
            }
        }
        return null;
    }
    public List<Paquete> crearPaquetesLote(String direccion){
        List<Paquete> paquetes = new ArrayList<Paquete>();
        List<Paquete> paquetes_lote_interno = new ArrayList<Paquete>();
        double peso = 0,peso_alimentarios = 0;
        int flag_a = 1,flag_na = 1,flag_peso_correcto = 0;
        
        List<Producto> productos_alimentarios = new ArrayList<Producto>();
        List<Producto> productos_no_alimentarios = new ArrayList<Producto>();
        for (Producto pr:this.prods){
            
         if (pr.isAlimentario()){
            
            peso_alimentarios+=pr.calcularPesoTotal();
            if (peso_alimentarios <= 60){
                productos_alimentarios.add(pr);
                flag_a = 0;
                flag_peso_correcto = 1;
            }
            if (peso_alimentarios == 60){
                Paquete paquete_alimentario = new Paquete(direccion, peso_alimentarios, productos_alimentarios,TipoPaquete.ALIMENTARIO);
                productos_alimentarios.clear();
                paquetes.add(paquete_alimentario);
                peso_alimentarios = 0;
                flag_a = 1;
                flag_peso_correcto = 0;
            }
            else if (peso_alimentarios > 60 & flag_peso_correcto == 1){
                peso_alimentarios = peso_alimentarios - pr.calcularPesoTotal();
                Paquete paquete_alimentario = new Paquete(direccion, peso_alimentarios, productos_alimentarios,TipoPaquete.ALIMENTARIO);
                productos_alimentarios.clear();
                paquetes.add(paquete_alimentario);
                peso_alimentarios = 0;
                productos_alimentarios.add(pr);
                flag_a = 1;
                flag_peso_correcto = 0;
                peso_alimentarios += pr.calcularPesoTotal();
            }
        
            
        }

        else if (pr.isAlimentario() == false){
            
            
            peso += pr.calcularPesoTotal();
            if(peso<=60){
            productos_no_alimentarios.add(pr);
            flag_na = 0;
            flag_peso_correcto = 1;
            }    
            
            if (peso == 60){
                Paquete paquete = new Paquete(direccion, peso,productos_no_alimentarios,TipoPaquete.NOALIMENTARIO);
                productos_no_alimentarios.clear();
                paquetes.add(paquete);
                peso = 0;
                flag_na = 1;
                flag_peso_correcto = 0;
            }
            else if (peso > 60 & flag_peso_correcto == 1){
                peso = peso - pr.calcularPesoTotal();
                Paquete paquete = new Paquete(direccion, peso,productos_no_alimentarios,TipoPaquete.NOALIMENTARIO);
                productos_no_alimentarios.clear();
                paquetes.add(paquete);
                peso = 0;
                flag_na = 1;
                flag_peso_correcto = 0;
                productos_no_alimentarios.add(pr);
                peso += pr.calcularPesoTotal();

            }
        
        }
    }
        if (flag_na == 0){
            Paquete paquete = new Paquete(direccion, peso,productos_no_alimentarios,TipoPaquete.NOALIMENTARIO);
                    productos_no_alimentarios.clear();
                    paquetes.add(paquete);
                    peso = 0;
            }
            if (flag_a == 0){
            Paquete paquete_alimentario = new Paquete(direccion, peso_alimentarios, productos_alimentarios,TipoPaquete.ALIMENTARIO);
                    productos_alimentarios.clear();
                    paquetes.add(paquete_alimentario);
                    peso_alimentarios = 0;
            }    
        for (Lote lo:this.lotes){
                paquetes_lote_interno = lo.crearPaquetesLote(direccion);
                paquetes.addAll(paquetes_lote_interno);
                paquetes_lote_interno.clear();
        }


        return paquetes;
    }
}
