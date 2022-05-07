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

    private List<Camion> camiones = new ArrayList<Camion>();
    private List<Repartidor> repartidores = new ArrayList<Repartidor>();
    private List<Pedido> pedidos = new ArrayList<Pedido>();
    private List<Paquete> paquetes = new ArrayList<Paquete>();
    private List<Cliente> clientes= new ArrayList<Cliente>();
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
     * 
     * @return
     */
    public static int get_n_pedido() {
        return Operario.n_pedido;
    }

    /**
     * Cambia el maximo de codigos postales
     * 
     * @param max
     */
    public static void modificar_max_codpost(int max) {
        if (max > 0) {
            VariablesGlobales.set_max_cod_post(max);
        }
        /** update */
    }

    /**
     * Cambia el máximo de entregas fallidas
     * 
     * @param max
     */
    public static void modificar_max_entregas_fallidas(int max) {
        if (max >= 0)
            VariablesGlobales.set_max_entregas_fallidas(max);
    }

    /**
     * Cambia el maximo de volumen por producto
     * 
     * @param max
     */
    public static void modificar_max_volumen_prod(double max) {
        if (max > 0)
            VariablesGlobales.set_max_volumen_prod(max);
        ;
    }

    /**
     * Cambia el descuento
     * 
     * @param max
     */
    public static void modificar_descuento(double max) {
        if (max > 0)
            VariablesGlobales.set_descuento(max);
    }

    /**
     * Cambia la tasa de los productos alimentarios
     * 
     * @param max
     */
    public static void modificar_tasa_alim(double max) {
        VariablesGlobales.set_tasa_alim(max);
    }

    /**
     * Cambia la tasa de los productos fragiles
     * 
     * @param max
     */
    public static void modificar_tasa_frag(double max) {
        VariablesGlobales.set_tasa_frag(max);
    }

    /**
     * Cambia la tasa de los productos asegurados
     * 
     * @param max
     */
    public static void modificar_tasa_aseg(double max) {
        VariablesGlobales.set_tasa_aseg(max);
    }

    /**
     * Registra un nuevo camión
     * 
     * @param matricula
     * @param peso_max
     * @param tipo
     */
    public static void registrar_camion(String matricula, int peso_max, TipoCamion tipo) {
        if (matricula != null && peso_max >= 0) {
            Camion c = new Camion(matricula, peso_max, tipo);
            Sistema.addCamion(c);
        }
    }

    /**
     * Busca un camión por la matricula
     * 
     * @param matricula
     * @return
     */
    public static Camion getCamionByPlate(String matricula) {
        for (Camion c : Sistema.getCamiones()) {
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
    public static void darAltaCamion(String matricula) {
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
    public static void darBajaCamion(String matricula) {
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
    public static boolean consultarCamionEstropeado(String matricula) {
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
    public static void setCamionEstropeado(String matricula) {
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
    public static void setCamionNoEstropeado(String matricula) {
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
    public static void registrarRepartidor(String num_telef, String nombre_usuario, String password) {
        if (num_telef != null) {
            Repartidor r = new Repartidor(num_telef, nombre_usuario, password);
            Sistema.addRepartidor(r);
        }
    }

    /**
     * Busca un repartidor por su numero de telefono
     * 
     * @param num_telef
     * @return
     */
    public static Repartidor getRepartidorByTelef(String num_telef) {
        for (Repartidor r : Sistema.getRepartidores()) {
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
    public static void darAltaRepartidor(String num_telef) {
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
    public static void darBajaRepartidor(String num_telef) {
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
    public static boolean consultarEstadoRepartidor(String num_telef) {
        Repartidor r = getRepartidorByTelef(num_telef);
        if (r != null) {
            return r.getAlta();
        }
        return false;
    }

    public static Cliente getClientebyCIF(String CIF) {
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
    public static void darAltaPedido(String dir_entr, String CIF, boolean urgent) {

        /**
         * Tenemos que meter el CIF del cliente, y buscar ese cliente entre un array de
         * clientes
         */

        if (dir_entr != null && CIF != null) {
            Cliente c = getClientebyCIF(CIF);
            if (c != null) {
                Pedido p = new Pedido(urgent, Operario.n_pedido, dir_entr);
                p.set_cliente(c);
                Sistema.getPedidos().add(p);
                Operario.n_pedido++;
            }
        }
    }

    /**
     * Busca un pedido por su id
     * 
     * @param id
     * @return
     */
    public static Pedido getPedidoById(int id) {
        if (id >= 0) {
            for (Pedido p : Sistema.getPedidos()) {
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
    public static void addProductoPedido(int id_pedido, int units, double weight, boolean secured,
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
    public static void addLotePedido(int id_pedido) {
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
    public static Lote getLotePedidoById(int id_pedido, int id_lote) {
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
    public static void addLoteLotePedido(int id_pedido, int id_lote) {
        Lote l = getLotePedidoById(id_pedido, id_lote);
        if (l != null) {
            l.addLoteLote();
        }
    }
    /**
     * Añade un cliente
     * @param c
     */
    public static void addCliente(Cliente c) {
        if (c!= null)
            Sistema.getClientes().add(c);
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
    public static void addProductLotePedido(int id_pedido, int id_lote, int units, double weight, int identifier,
            boolean secured, String descri, double vol, TipoProducto tipo) {
        Lote l = getLotePedidoById(id_pedido, id_lote);
        l.addProductLote(units, weight, identifier, secured, descri, vol, tipo);
    }
    /**
     * Añade un producto a un lote dentro de otro lote dentro de un pedido
     * @param id_pedido
     * @param id_lote
     * @param id_lote_interno
     * @param units
     * @param weight
     * @param identifier
     * @param secured
     * @param descri
     * @param vol
     * @param tipo
     */
    public static void addProductoLoteLotePedido(int id_pedido, int id_lote,int id_lote_interno, int units, double weight, int identifier,
    boolean secured, String descri, double vol, TipoProducto tipo){
        Lote l = getLotePedidoById(id_pedido, id_lote);
        Lote in = l.getLotebyId(id_lote_interno);
        in.addProductLote(units, weight, identifier, secured, descri, vol, tipo);
    }
    /**
     * Algoritmo que realiza el empaquetado de los productos en al almacen
     */
    public static void realizarEmpaquetado() {
        String direccion;
        int flag_na = 1, flag_a = 1, flag_peso_correcto = 0,flag_r = 1,flag_c = 1;
        int indice_p;
        List<Paquete> paquetes_lote = new ArrayList<Paquete>();
        List<Producto> producto = new ArrayList<Producto>();
        List<Producto> producto_fragil = new ArrayList<Producto>();
        List<Producto> productos_alimentarios = new ArrayList<Producto>();
        List<Producto> productos_alimentarios_cogelados = new ArrayList<Producto>();
        List<Producto> productos_alimentarios_refrigerados = new ArrayList<Producto>();
        double peso = 0, peso_alimentarios = 0,peso_alimentarios_congelados = 0,peso_alimentarios_refrigerados = 0;
        for (Pedido p : Sistema.getPedidos()) {
            peso = 0;
            direccion = p.getDirecEntrega();
            for (Producto pr : p.getProductos()) {
                if (pr.isFragil()) {
                    if (pr.calcularPesoTotal() <= 60) {
                        producto_fragil.add(pr);
                        Paquete paquete_fragil = new Paquete(direccion, pr.getPeso(), producto_fragil,
                                TipoPaquete.FRAGIL);
                        producto_fragil.clear();
                        Sistema.getPaquetes().add(paquete_fragil);
                    }
                }

                else if (pr.isAlimentario()) {
                    /*si el producto es alimentario y congelado*/ 
                    if (pr.isCongelado()){
                        indice_p = Operario.buscarPaqueteConHueco(TipoPaquete.ALIMENTARIO_CONGELADO, direccion, pr.calcularPesoTotal());
                        if (indice_p != -1) {
                        
                            Sistema.getPaquetes().get(indice_p).addProductoPaquete(pr);
                        } else {
                            peso_alimentarios_congelados += pr.calcularPesoTotal();
                            if (peso_alimentarios_congelados < 60) {
                                productos_alimentarios_cogelados.add(pr);
                                flag_c = 0;
                                flag_peso_correcto = 1;
                            } else if (peso_alimentarios_congelados == 60) {
                                Paquete paquete_alimentario_congelado = new Paquete(direccion, peso_alimentarios_congelados,
                                        productos_alimentarios, TipoPaquete.ALIMENTARIO_CONGELADO);
                                productos_alimentarios_cogelados.clear();
                                Sistema.getPaquetes().add(paquete_alimentario_congelado);
                                
                                peso_alimentarios_congelados = 0;
                                flag_c = 1;
                                flag_peso_correcto = 0;
                            } else if (peso_alimentarios_congelados > 60 & flag_peso_correcto == 1) {
                                peso_alimentarios_congelados = peso_alimentarios_congelados - pr.calcularPesoTotal();
                                Paquete paquete_alimentario_congelado = new Paquete(direccion, peso_alimentarios_congelados,
                                        productos_alimentarios_cogelados, TipoPaquete.ALIMENTARIO_CONGELADO);
                                productos_alimentarios_cogelados.clear();
                                Sistema.getPaquetes().add(paquete_alimentario_congelado);
                                
                                peso_alimentarios_congelados = 0;
                                productos_alimentarios_cogelados.add(pr);
                                flag_c = 1;
                                flag_peso_correcto = 0;
                                peso_alimentarios_congelados += pr.calcularPesoTotal();
                            }
                        }
                    }
                    else if (pr.isRefrigerado()){
                        indice_p = Operario.buscarPaqueteConHueco(TipoPaquete.ALIMENTARIO_REFRIGERADO, direccion, pr.calcularPesoTotal());
                        if (indice_p != -1) {
                        
                            Sistema.getPaquetes().get(indice_p).addProductoPaquete(pr);
                        } else {
                            peso_alimentarios_refrigerados += pr.calcularPesoTotal();
                            if (peso_alimentarios_refrigerados < 60) {
                                productos_alimentarios_refrigerados.add(pr);
                                flag_r = 0;
                                flag_peso_correcto = 1;
                            } else if (peso_alimentarios_refrigerados == 60) {
                                Paquete paquete_alimentario_refrigerado = new Paquete(direccion, peso_alimentarios_refrigerados ,
                                        productos_alimentarios_refrigerados, TipoPaquete.ALIMENTARIO_REFRIGERADO);
                                productos_alimentarios_refrigerados.clear();
                                Sistema.getPaquetes().add(paquete_alimentario_refrigerado);
                                
                                peso_alimentarios_refrigerados = 0;
                                flag_r = 1;
                                flag_peso_correcto = 0;
                            } else if (peso_alimentarios_refrigerados > 60 & flag_peso_correcto == 1) {
                                peso_alimentarios_refrigerados = peso_alimentarios_refrigerados - pr.calcularPesoTotal();
                                Paquete paquete_alimentario_refrigerado = new Paquete(direccion, peso_alimentarios_refrigerados,
                                        productos_alimentarios_refrigerados, TipoPaquete.ALIMENTARIO_REFRIGERADO);
                                productos_alimentarios_refrigerados.clear();
                                Sistema.getPaquetes().add(paquete_alimentario_refrigerado);
                                
                                peso_alimentarios_refrigerados = 0;
                                productos_alimentarios_refrigerados.add(pr);
                                flag_r = 1;
                                flag_peso_correcto = 0;
                                peso_alimentarios_refrigerados += pr.calcularPesoTotal();
                            }
                        }
                    }
                    else {
                    indice_p = Operario.buscarPaqueteConHueco(TipoPaquete.ALIMENTARIO, direccion, pr.calcularPesoTotal());
                    if (indice_p != -1) {
                        
                        Sistema.getPaquetes().get(indice_p).addProductoPaquete(pr);
                    } else {
                        peso_alimentarios += pr.calcularPesoTotal();
                        if (peso_alimentarios < 60) {
                            productos_alimentarios.add(pr);
                            flag_a = 0;
                            flag_peso_correcto = 1;
                        } else if (peso_alimentarios == 60) {
                            Paquete paquete_alimentario = new Paquete(direccion, peso_alimentarios,
                                    productos_alimentarios, TipoPaquete.ALIMENTARIO);
                            productos_alimentarios.clear();
                            Sistema.getPaquetes().add(paquete_alimentario);
                            
                            peso_alimentarios = 0;
                            flag_a = 1;
                            flag_peso_correcto = 0;
                        } else if (peso_alimentarios > 60 & flag_peso_correcto == 1) {
                            peso_alimentarios = peso_alimentarios - pr.calcularPesoTotal();
                            Paquete paquete_alimentario = new Paquete(direccion, peso_alimentarios,
                                    productos_alimentarios, TipoPaquete.ALIMENTARIO);
                            productos_alimentarios.clear();
                            Sistema.getPaquetes().add(paquete_alimentario);
                            
                            peso_alimentarios = 0;
                            productos_alimentarios.add(pr);
                            flag_a = 1;
                            flag_peso_correcto = 0;
                            peso_alimentarios += pr.calcularPesoTotal();
                        }
                    }
                }

                }

                else if (pr.isAlimentario() == false) {
                    indice_p = Operario.buscarPaqueteConHueco(TipoPaquete.NOALIMENTARIO, direccion, pr.calcularPesoTotal());
                    if (indice_p != -1) {
                        Sistema.getPaquetes().get(indice_p).addProductoPaquete(pr);
                        flag_na = 1;
                    } else {
                        peso += pr.calcularPesoTotal();
                        if (peso < 60) {
                            producto.add(pr);
                            flag_na = 0;
                            flag_peso_correcto = 1;
                        }

                        else if (peso == 60) {
                            Paquete paquete = new Paquete(direccion, peso, producto, TipoPaquete.NOALIMENTARIO);
                            producto.clear();
                            Sistema.getPaquetes().add(paquete);
                            peso = 0;
                            flag_na = 1;
                            flag_peso_correcto = 0;
                        } else if (peso > 60 & flag_peso_correcto == 1) {
                            peso = peso - pr.calcularPesoTotal();
                            Paquete paquete = new Paquete(direccion, peso, producto, TipoPaquete.NOALIMENTARIO);
                            producto.clear();
                            Sistema.getPaquetes().add(paquete);
                            peso = 0;
                            flag_na = 1;
                            flag_peso_correcto = 0;
                            producto.add(pr);
                            peso += pr.calcularPesoTotal();

                        }
                    }
                }

            }
            if (flag_na == 0) {
                Paquete paquete = new Paquete(direccion, peso, producto, TipoPaquete.NOALIMENTARIO);
                producto.clear();
                Sistema.getPaquetes().add(paquete);
                peso = 0;
            }
            if (flag_a == 0) {
                Paquete paquete_alimentario = new Paquete(direccion, peso_alimentarios, productos_alimentarios,
                        TipoPaquete.ALIMENTARIO);
                productos_alimentarios.clear();
                Sistema.getPaquetes().add(paquete_alimentario);
                peso_alimentarios = 0;
            }
            if (flag_r == 0) {
                Paquete paquete_alimentario_refrigerado = new Paquete(direccion, peso_alimentarios_refrigerados, productos_alimentarios_refrigerados,
                        TipoPaquete.ALIMENTARIO_REFRIGERADO);
                productos_alimentarios_refrigerados.clear();
                Sistema.getPaquetes().add(paquete_alimentario_refrigerado);
                peso_alimentarios_refrigerados = 0;
            }
            if (flag_c == 0) {
                Paquete paquete_alimentario_conglelados = new Paquete(direccion, peso_alimentarios_congelados, productos_alimentarios_cogelados,
                        TipoPaquete.ALIMENTARIO_CONGELADO);
                productos_alimentarios_cogelados.clear();
                Sistema.getPaquetes().add(paquete_alimentario_conglelados);
                peso_alimentarios_congelados = 0;
            }
            for (Lote l : p.getLotes()) {
                paquetes_lote = l.crearPaquetesLote(direccion);
                Sistema.getPaquetes().addAll(paquetes_lote);
                paquetes_lote.clear();
            }

        }
        Sistema.getPedidos().clear();
    }
    /**
     * Busca un paquete en el array de paquetes que tenga hueco y que cumpla las condiciones impuestas
     * @param tipo
     * @param direccion
     * @param peso
     * @return
     */
    public static int buscarPaqueteConHueco(TipoPaquete tipo, String direccion, double peso) {
        int indice = 0;
        for (Paquete pa : Sistema.getPaquetes()) {
            if (pa.getTipoPaquete() == tipo && pa.getDestino() == direccion && pa.getPesoRestante() >= peso) {
                return indice;
            }
            indice++;
        }
        return -1;
    }
    /**
     * Devuelve la string a imprimir
     * @return 
     */
    
    public static String toStringPlan() {
        return "\n" + "Lista paquetes:" + Sistema.getPaquetes().toString() +"\n" + "Plan de Reparto:" + Sistema.getCamiones().toString();
    }
    /**
     * Algoritmo que realiza el plan de reparto
     */
    public static void planDeReparto(){
        int index_c = 0;

        for (Paquete p : Sistema.getPaquetes()){

            if (p.getTipoPaquete() == TipoPaquete.ALIMENTARIO_CONGELADO){
                index_c = buscarCamionCongeladoConHueco(p.getPeso());
                if (index_c != -1){
                    Sistema.getCamiones().get(index_c).addPaqueteCamion(p);
                }
            }
            else if(p.getTipoPaquete() == TipoPaquete.ALIMENTARIO_REFRIGERADO){
                index_c = buscarCamionRefrigeradoConHueco(p.getPeso());
                if (index_c != -1){
                    Sistema.getCamiones().get(index_c).addPaqueteCamion(p);
                }
            }
            else{
                index_c = buscarCamionEstandarConHueco(p.getPeso());
                if (index_c != -1){
                    Sistema.getCamiones().get(index_c).addPaqueteCamion(p);
                }
            }





        }
    }
    /**
     * Busca un camion congelado con hueco
     * @param peso
     * @return
     */
    public static int buscarCamionCongeladoConHueco(double peso){
        int indice = 0;

        for (Camion c: Sistema.getCamiones()){
            if (c.getTipocCamion() == TipoCamion.CONGELADOS && c.getPesoRestante() >= peso){
                return indice;
            }
            indice++;
        }
        return -1;
    }
    /**
     * Busca un camión refrigerado con hueco
     * @param peso
     * @return
     */
    public static int buscarCamionRefrigeradoConHueco(double peso){
        int indice = 0;

        for (Camion c: Sistema.getCamiones()){
            if (c.getTipocCamion() == TipoCamion.REFRIGERADOS  && c.getPesoRestante() >= peso){
                return indice;
            }
            indice++;
        }
        return -1;
    }
    /**
     * Busca un camion estandar con hueco
     * @param peso
     * @return
     */
    public static int buscarCamionEstandarConHueco(double peso){
        int indice = 0;

        for (Camion c: Sistema.getCamiones()){
            if (c.getTipocCamion() == TipoCamion.ESTANDAR  && c.getPesoRestante() >= peso){
                return indice;
            }
            indice++;
        }
        return -1;
    }
    /**
     * Busca un camion especial con hueco
     * @param peso
     * @return
     */
    public static int buscarCamionEspecialConHueco(double peso){
        int indice = 0;

        for (Camion c: Sistema.getCamiones()){
            if (c.getTipocCamion() == TipoCamion.ESPECIAL  && c.getPesoRestante() >= peso){
                return indice;
            }
            indice++;
        }
        return -1;
    }
    /**
     * Devuelve la lista de clientes
     * @return
     */
    public static List<Cliente> getClientes(){
        return Sistema.getClientes();
    }

}
