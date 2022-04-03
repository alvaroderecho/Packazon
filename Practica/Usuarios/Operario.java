package Usuarios;

import Reparto.*;
import Sistema.*;
import java.util.*;

import Productos.*;

public class Operario extends Cuenta{    

    private VariablesGlobales var;
    private List<Camion> camiones = new ArrayList<Camion>();
    private List<Repartidor> repartidores = new ArrayList<Repartidor>();
    private List<Pedido> pedidos = new ArrayList<Pedido>();

    private int n_pedido = 0;

    
    public Operario(String nombre_usuario, String password) {
        super(nombre_usuario, password);
    }

    public VariablesGlobales getVar(){
        return this.var;
    }
    public int get_n_pedido(){
        return this.n_pedido;
    }
    public void modificar_max_codpost(int max) {
        if (max >0) {
            this.var.set_max_cod_post(max);
        }
        /**update */
    }

    public void modificar_max_entregas_fallidas(int max) {
        if (max >=0)
        this.var.set_max_entregas_fallidas(max);
    }

    public void modificar_max_volumen_prod(double max) {
        if (max>0)
        this.var.set_max_volumen_prod(max);;
    }

    public void modificar_descuento(double max) {
        if (max>0)
            this.var.set_descuento(max);
    }

    public void modificar_tasa_alim(double max) {
        this.var.set_tasa_alim(max);
    }

    public void modificar_tasa_frag(double max) {
        this.var.set_tasa_frag(max);
    }

    public void modificar_tasa_aseg(double max) {
        this.var.set_tasa_aseg(max);
    }

    public void registrar_camion(String matricula, int peso_max, TipoCamion tipo) {
        if (matricula != null && peso_max >= 0) {
            Camion c = new Camion(matricula, peso_max, tipo);
            this.camiones.add(c);
        }
    }

    private Camion getCamionByPlate(String matricula) {
        for (Camion c: this.camiones) {
            if (c.getMatricula() == matricula)
                return c;
        }
        return null;
    }

    public void darAltaCamion(String matricula) {
        Camion c = getCamionByPlate(matricula);
        if (c!= null) {
            c.setAlta();
        }
    }

    public void darBajaCamion(String matricula) {
        Camion c = getCamionByPlate(matricula);
        if (c!= null) {
            c.setBaja();
        }
    }

    /**
     * 
     * @param matricula
     * @return
     */
    public boolean consultarCamionEstropeado(String matricula) {
        Camion c = getCamionByPlate(matricula);
        if (c!= null) {
            return c.getEstropeado();
        }
        return false;
    }

    /**
     * 
     * @param matricula
     */
    public void setCamionEstropeado(String matricula) {
        Camion c = getCamionByPlate(matricula);
        if (c!= null) {
            c.setEstropeado();
        }
    }

    /**
     * 
     * @param matricula
     */
    public void setCamionNoEstropeado(String matricula) {
        Camion c = getCamionByPlate(matricula);
        if (c!= null) {
            c.setNoEstropeado();
        }
    }


    /**REFERENTE A REPARTIDORES */
    public void registrarRepartidor(String num_telef) {
        if (num_telef != null) {
            Repartidor r = new Repartidor(num_telef);
            this.repartidores.add(r);
        }
    }

    public Repartidor getRepartidorByTelef(String num_telef) {
        for (Repartidor r: this.repartidores) {
            if (r.getNumTelef() == num_telef)
                return r;
        }
        return null;
    }
    public void darAltaRepartidor(String num_telef) {
        Repartidor r = getRepartidorByTelef(num_telef);
        if (r!= null) {
            r.setAlta();
        }
    }

    public void darBajaRepartidor(String num_telef) {
        Repartidor r = getRepartidorByTelef(num_telef);
        if (r!= null) {
            r.setBaja();
        }
    }

    public boolean consultarEstadoRepartidor(String num_telef) {
        Repartidor r = getRepartidorByTelef(num_telef);
        if (r!=null) {
            return r.getAlta();
        }
        return false;
    }
    

    /**REFERENTE A PEDIDOS */
    public void darAltaPedido(String dir_entr,Cliente c, boolean urgent) {

        if (dir_entr != null && c != null) {
            Pedido p = new Pedido(urgent,this.n_pedido,dir_entr);
            p.set_cliente(c);
            this.pedidos.add(p);
            this.n_pedido++;
            
        }
    }

    public Pedido getPedidoById(int id) {
        if (id >= 0)  {
            for (Pedido p: this.pedidos) {
                if (p.getID() == id) {
                    return p;
                }
            }
        }
        return null;
    }

    public void addProductoPedido(int id_pedido, int units, double weight, int identifier, boolean secured, String descri, double vol, TipoProducto tipo) {
        Pedido p = getPedidoById(id_pedido);
        if (p!= null) {
            p.addProductoPedido(units, weight, identifier, secured, descri, vol, tipo);
        }
    }

    public void  addLotePedido(int id_pedido) {
        Pedido p = getPedidoById(id_pedido);
        if (p!=null) {
            p.addLote();
        }
    }

    public Lote getLotePedidoById(int id_pedido, int id_lote) {
        Pedido p = getPedidoById(id_pedido);
        if (p != null) {
            return p.getLotebyId(id_lote);
        }
        return null;
    }

    public void addLoteLotePedido(int id_pedido, int id_lote) {
        Lote l = getLotePedidoById(id_pedido, id_lote);
        if (l!=null) {
            l.addLoteLote();
        }
    }

    public void addProductLotePedido(int id_pedido, int id_lote,  int units, double weight, int identifier, boolean secured, String descri, double vol, TipoProducto tipo) {
        Lote l = getLotePedidoById(id_pedido, id_lote);
        l.addProductLote(units, weight, identifier, secured, descri, vol, tipo);
    }

}
