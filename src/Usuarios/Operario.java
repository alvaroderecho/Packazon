package Usuarios;

import Reparto.*;
import Sistema.Sistema;

import java.util.*;

import Productos.*;

/**
 * Clase Usuario
 * 
 * @author Joseba Arranz
 * @author Alvaro Derecho
 * @author Salah
 */
public class Operario extends Cuenta {

    private VariablesGlobales var;
    private List<Camion> camiones = new ArrayList<Camion>();
    private List<Repartidor> repartidores = new ArrayList<Repartidor>();
    private List<Pedido> pedidos = new ArrayList<Pedido>();
    private List<Paquete> paquetes = new ArrayList<Paquete>();

    private static int n_pedido = 0;
    private static int n_producto = 0;

    /**
     * Constructor
     * 
     * @param nombre_usuario
     * @param password
     */
    public Operario(String nombre_usuario, String password) {
        super(nombre_usuario, password);
    }

    /**
     * Devuelve el atributo de las variables globales
     * 
     * @return
     */
    public VariablesGlobales getVar() {
        return this.var;
    }

    /**
     * 
     * @return
     */
    public int get_n_pedido() {
        return this.n_pedido;
    }

    /**
     * Cambia el maximo de codigos postales
     * 
     * @param max
     */
    public void modificar_max_codpost(int max) {
        if (max > 0) {
            this.var.set_max_cod_post(max);
        }
        /** update */
    }

    /**
     * Cambia el máximo de entregas fallidas
     * 
     * @param max
     */
    public void modificar_max_entregas_fallidas(int max) {
        if (max >= 0)
            this.var.set_max_entregas_fallidas(max);
    }

    /**
     * Cambia el maximo de volumen por producto
     * 
     * @param max
     */
    public void modificar_max_volumen_prod(double max) {
        if (max > 0)
            this.var.set_max_volumen_prod(max);
        ;
    }

    /**
     * Cambia el descuento
     * 
     * @param max
     */
    public void modificar_descuento(double max) {
        if (max > 0)
            this.var.set_descuento(max);
    }

    /**
     * Cambia la tasa de los productos alimentarios
     * 
     * @param max
     */
    public void modificar_tasa_alim(double max) {
        this.var.set_tasa_alim(max);
    }

    /**
     * Cambia la tasa de los productos fragiles
     * 
     * @param max
     */
    public void modificar_tasa_frag(double max) {
        this.var.set_tasa_frag(max);
    }

    /**
     * Cambia la tasa de los productos asegurados
     * 
     * @param max
     */
    public void modificar_tasa_aseg(double max) {
        this.var.set_tasa_aseg(max);
    }

    /**
     * Registra un nuevo camión
     * 
     * @param matricula
     * @param peso_max
     * @param tipo
     */
    public void registrar_camion(String matricula, int peso_max, TipoCamion tipo) {
        if (matricula != null && peso_max >= 0) {
            Camion c = new Camion(matricula, peso_max, tipo);
            this.camiones.add(c);
        }
    }

    /**
     * Busca un camión por la matricula
     * 
     * @param matricula
     * @return
     */
    private Camion getCamionByPlate(String matricula) {
        for (Camion c : this.camiones) {
            if (c.getMatricula() == matricula)
                return c;
        }
        return null;
    }

    /**
     * Da de alta un camion
     * 
     * @param matricula
     */
    public void darAltaCamion(String matricula) {
        Camion c = getCamionByPlate(matricula);
        if (c != null) {
            c.setAlta();
        }
    }

    /**
     * Da de baja un camion
     * 
     * @param matricula
     */
    public void darBajaCamion(String matricula) {
        Camion c = getCamionByPlate(matricula);
        if (c != null) {
            c.setBaja();
        }
    }

    /**
     * Consulta si un camión esta estropeado
     * 
     * @param matricula
     * @return
     */
    public boolean consultarCamionEstropeado(String matricula) {
        Camion c = getCamionByPlate(matricula);
        if (c != null) {
            return c.getEstropeado();
        }
        return false;
    }

    /**
     * Cambia el estado de un camión a estropeado
     * 
     * @param matricula
     */
    public void setCamionEstropeado(String matricula) {
        Camion c = getCamionByPlate(matricula);
        if (c != null) {
            c.setEstropeado();
        }
    }

    /**
     * Cambia el estado de un camión a no estropeado
     * 
     * @param matricula
     */
    public void setCamionNoEstropeado(String matricula) {
        Camion c = getCamionByPlate(matricula);
        if (c != null) {
            c.setNoEstropeado();
        }
    }

    /** REFERENTE A REPARTIDORES */

    /**
     * Registra un repartidor nuevo
     * 
     * @param num_telef
     */
    public void registrarRepartidor(String num_telef) {
        if (num_telef != null) {
            Repartidor r = new Repartidor(num_telef);
            this.repartidores.add(r);
        }
    }

    /**
     * Busca un repartidor por su numero de telefono
     * 
     * @param num_telef
     * @return
     */
    public Repartidor getRepartidorByTelef(String num_telef) {
        for (Repartidor r : this.repartidores) {
            if (r.getNumTelef() == num_telef)
                return r;
        }
        return null;
    }

    /**
     * Da de alta un repartidor
     * 
     * @param num_telef
     */
    public void darAltaRepartidor(String num_telef) {
        Repartidor r = getRepartidorByTelef(num_telef);
        if (r != null) {
            r.setAlta();
        }
    }

    /**
     * Da de baja a un repartidor
     * 
     * @param num_telef
     */
    public void darBajaRepartidor(String num_telef) {
        Repartidor r = getRepartidorByTelef(num_telef);
        if (r != null) {
            r.setBaja();
        }
    }

    /**
     * Consulta el estado de un repartidor
     * 
     * @param num_telef
     * @return
     */
    public boolean consultarEstadoRepartidor(String num_telef) {
        Repartidor r = getRepartidorByTelef(num_telef);
        if (r != null) {
            return r.getAlta();
        }
        return false;
    }

    public Cliente getClientebyCIF(String CIF) {
        for (Cliente c : Sistema.getClientes()) {
            if (c.getCif() == CIF) {
                return c;
            }
        }
        return null;
    }

    /** REFERENTE A PEDIDOS */

    /**
     * Da de alta un pedido
     * 
     * @param dir_entr
     * @param c
     * @param urgent
     */
    public void darAltaPedido(String dir_entr, String CIF, boolean urgent) {

        /**
         * Tenemos que meter el CIF del cliente, y buscar ese cliente entre un array de
         * clientes
         */

        if (dir_entr != null && CIF != null) {
            Cliente c = getClientebyCIF(CIF);
            if (c != null) {
                Pedido p = new Pedido(urgent, this.n_pedido, dir_entr);
                p.set_cliente(c);
                this.pedidos.add(p);
                this.n_pedido++;
            }
        }
    }

    /**
     * Busca un pedido por su id
     * 
     * @param id
     * @return
     */
    public Pedido getPedidoById(int id) {
        if (id >= 0) {
            for (Pedido p : this.pedidos) {
                if (p.getID() == id) {
                    return p;
                }
            }
        }
        return null;
    }

    /**
     * Añade un producto a un pedido
     * 
     * @param id_pedido
     * @param units
     * @param weight
     * @param identifier
     * @param secured
     * @param descri
     * @param vol
     * @param tipo
     */
    public void addProductoPedido(int id_pedido, int units, double weight, boolean secured,
            String descri, double vol, TipoProducto tipo) {
        Pedido p = getPedidoById(id_pedido);
        if (p != null) {
            p.addProductoPedido(units, weight, Operario.n_producto, secured, descri, vol, tipo);
        }
        Operario.n_producto++;
    }

    /**
     * Añade un lote a un pedido
     * 
     * @param id_pedido
     */
    public void addLotePedido(int id_pedido) {
        Pedido p = getPedidoById(id_pedido);
        if (p != null) {
            p.addLote();
        }
    }

    /**
     * Busca un pedido segun su id y le añade un lote
     * 
     * @param id_pedido
     * @param id_lote
     * @return
     */
    public Lote getLotePedidoById(int id_pedido, int id_lote) {
        Pedido p = getPedidoById(id_pedido);
        if (p != null) {
            return p.getLotebyId(id_lote);
        }
        return null;
    }

    /**
     * Busca un lote dentro de un pedido y le añade otro lote
     * 
     * @param id_pedido
     * @param id_lote
     */
    public void addLoteLotePedido(int id_pedido, int id_lote) {
        Lote l = getLotePedidoById(id_pedido, id_lote);
        if (l != null) {
            l.addLoteLote();
        }
    }

    /**
     * Busca un lote dentro de un pedido y le añade un producto
     * 
     * @param id_pedido
     * @param id_lote
     * @param units
     * @param weight
     * @param identifier
     * @param secured
     * @param descri
     * @param vol
     * @param tipo
     */
    public void addProductLotePedido(int id_pedido, int id_lote, int units, double weight, int identifier,
            boolean secured, String descri, double vol, TipoProducto tipo) {
        Lote l = getLotePedidoById(id_pedido, id_lote);
        l.addProductLote(units, weight, identifier, secured, descri, vol, tipo);
    }

    public void realizarEmpaquetado() {
        String direccion;
        for (Pedido p : this.pedidos) {
            direccion = p.getDirecEntrega();
            if (p.getPesoTotal() < 60) {
                Paquete pa = new Paquete(p.getDirecEntrega(), p.getPesoTotal(), p.getProductos());
                this.paquetes.add(pa);
            }
        }
    }

}
