package Sistema;

import Usuarios.*;
import Reparto.*;
import Productos.*;
import java.util.*;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalTime;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Clase que demuestra la funcionalidad básica de la aplicacion
 * @author Joseba Arranz
 * @author Alvaro Derecho
 * @author Salah
 */
public class Sistema implements Serializable{


    private static Sistema sist = null;

    //cuentas disponibles
    private static ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();

    //array de los operarios
    private static ArrayList<Operario> operarios = new ArrayList<Operario>();

    //array de los clientes
    private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();

    //array de los pedidos
    private static ArrayList<Pedido> pedidos = new ArrayList<Pedido>();

    //array de los repartidores
    private static ArrayList<Repartidor> repartidores = new ArrayList<Repartidor>();

    //array de camiones 
    private static ArrayList<Camion> camiones =  new ArrayList<Camion>();

    //array de lotes
    private static ArrayList<Lote> lotes= new ArrayList<Lote>();

    //array de paquetes
    private static ArrayList<Paquete> paquetes = new ArrayList<Paquete>();

    private static ArrayList<Factura> facturas  = new ArrayList<Factura>();

    private static ArrayList<Producto> productos  = new ArrayList<Producto>();

    private static ArrayList<PlanRepartoPorCamion> planRepartoPorCamion;



    /**
     * Constructor de la clase sistema
     */
    private Sistema() {

    }

    public static Sistema getInstance() {

        if(sist ==null) {
            sist = new Sistema();
             try {
                 sist.cargaPrograma();
             }
             catch(Exception e) {
                 System.out.println("Error leyendo la clase de sistema. Creando nueva clase de sistema...");

             }

        }
        return sist;

    }

    /*Metodo que Crea una cuenta en el sistema */

	public Status addCuenta(Cuenta c){

        //compruebo que la cuenta no exista ya o que sea null
        if(Sistema.cuentas.contains(c) == true || c == null ) return Status.ERROR;
        //se añade la cuenta al array de cuentas
        Sistema.cuentas.add(c);
        return Status.OK;

    }

    /* Metodo para borrar cuentas*/

    public Status rmvCuenta(Cuenta c){
        //compruebo que la cuenta exista y que no sea null
        if(Sistema.cuentas.isEmpty()) return Status.ERROR;
        if(Sistema.cuentas.contains(c) == false || c == null ) return Status.ERROR;
        //borro la cuenta del array de cuentas
		Sistema.cuentas.remove(c); 
		return Status.OK;
    }

    /* Metodo para añadir operarios */

    public Status addOperario(Operario o) {

        if(Sistema.operarios.contains(o)==true || o == null) return Status.ERROR;
        //añado operario al array de operarios
        Sistema.operarios.add(o);
        return Status.OK;

    }

    public static Status rmvOperario(Operario o){

        //compruebo que el operario exista y que no sea null
        if(Sistema.operarios.isEmpty()) return Status.ERROR;
        if(Sistema.operarios.contains(o) == false || o == null ) return Status.ERROR;
        //borro la cuenta del array de cuentas
		Sistema.cuentas.remove(o); 
		return Status.OK;

    }
    
    public static Status addCliente(Cliente c) {

        //Compruebo que el cliente no exista y que sea correcto
        if(Sistema.clientes.contains(c)|| c==null) return Status.ERROR;

        Sistema.clientes.add(c);
        return Status.OK;
    }

    public static Status rmvCliente(Cliente c){

        //compruebo que el cliente exista y que no sea null
        if(Sistema.clientes.isEmpty()) return Status.ERROR;
        if(Sistema.clientes.contains(c) == false || c == null ) return Status.ERROR;
        //borro la cuenta del array de clientes
		Sistema.cuentas.remove(c); 
		return Status.OK;

    }

    public static List<Cliente> getClientes() {

        return Sistema.clientes;

    }
    public static List<Repartidor> getRepartidores() {

        return Sistema.repartidores;

    }
    public static List<Camion> getCamiones() {

        return Sistema.camiones;

    }

    public static Status addPedido(Pedido p ){
        //compruebo que el pedido no este ya y que sea correcto
        if(Sistema.pedidos.contains(p) ==true||p == null) return Status.ERROR;
        Sistema.pedidos.add(p);
        return Status.OK;

    }

    public Status rmvPedido(Pedido p){

        //compruebo que el pedido no exista y que no sea null
        if(Sistema.pedidos.isEmpty()) return Status.ERROR;
        if(Sistema.pedidos.contains(p) == false || p == null ) return Status.ERROR;
        //borro la cuenta del array de clientes
		Sistema.pedidos.remove(p); 
		return Status.OK;

    }

    public static Status addRepartidor(Repartidor r){

        //compruebo que el repartidor no exista y que no sea null
        if(Sistema.repartidores.contains(r) == true|| r == null) return Status.ERROR;
        
        Sistema.repartidores.add(r);
        return Status.OK;

    }

    public Status rmvRepartidor(Repartidor r){

        //compruebo que el repartidor exista y que no sea null
        if(Sistema.repartidores.isEmpty()) return Status.ERROR;
        if(Sistema.repartidores.contains(r) == false|| r == null) return Status.ERROR;

        Sistema.repartidores.remove(r);
        return Status.OK;

    }

    public static Status addCamion(Camion c){

        //compruebo que el camion no este en la lista
        if(Sistema.camiones.contains(c)==true|| c == null) return Status.ERROR;

        Sistema.camiones.add(c);
        return Status.OK;

    }

    public Status rmvCamion(Camion c) {

        //compruebo que el camion este en la lista y que no sea null
        if(Sistema.camiones.isEmpty()) return Status.ERROR;
        if(Sistema.camiones.contains(c) ==false|| c == null) return Status.ERROR;

        Sistema.camiones.remove(c);
        return Status.OK;

    }

    public Status addLote(Lote l) {

        //compruebo que el lote no este ya en el array de lotes
        if(Sistema.lotes.contains(l) == true || l == null) return Status.ERROR;

             Sistema.lotes.add(l);
            return Status.OK;
        
    }


    public Status rmvLote(Lote l) {

        if(Sistema.lotes.contains(l) == false || l == null) return Status.ERROR;

        Sistema.lotes.remove(l);
        return Status.OK;

    }

    public Status addPaquete(Paquete pa) {

        if(Sistema.paquetes.contains(pa)==true || pa == null) return Status.ERROR;

        Sistema.paquetes.add(pa);
        return Status.OK;
    }

    public Status rmvPaquete(Paquete p) {

        if(Sistema.lotes.contains(p) == false || p == null) return Status.ERROR;

        Sistema.lotes.remove(p);
        return Status.OK;

    }

    public Status addFactura(Factura f) {

        if(Sistema.facturas.contains(f)==true || f == null) return Status.ERROR;

        Sistema.facturas.add(f);
        return Status.OK;
    }

    public Status rmvFactura(Factura f) {

        if(Sistema.facturas.contains(f) == false || f == null) return Status.ERROR;

        Sistema.facturas.remove(f);
        return Status.OK;

    }

    public Status addProducto(Producto p) {

        if(Sistema.productos.contains(p)==true || p == null) return Status.ERROR;

        Sistema.productos.add(p);
        return Status.OK;
    }

    public Status rmvProducto(Producto p) {

        if(Sistema.productos.contains(p) == false || p == null) return Status.ERROR;

        Sistema.productos.remove(p);
        return Status.OK;

    }

    public Status addPlanDeReparto(PlanRepartoPorCamion pl) {

        if(Sistema.planRepartoPorCamion.contains(pl)==true || pl == null) return Status.ERROR;

        Sistema.planRepartoPorCamion.add(pl);
        return Status.OK;
    }

    public Status rmvPlanDeReparto(PlanRepartoPorCamion pl) {

        if(Sistema.planRepartoPorCamion.contains(pl)==true || pl== null) return Status.ERROR;

        Sistema.planRepartoPorCamion.add(pl);
        return Status.OK;
    }



    
	/**
	 * Metodo que guarda el programa en lenguaje binario en un fichero
	 */
    public void guardaPrograma(){

		try{
			FileOutputStream f = new FileOutputStream("src/Sistema/system.data");
			ObjectOutputStream o = new ObjectOutputStream(f);
			o.writeObject(Sistema.sist);
			o.close();
		}catch(Exception e){
			System.out.println("Error escribiendo la clase sistema como binario: " + e.getLocalizedMessage());
		}
	}

    /**
	 * Metodo que recupera el programa entero despues de haber llamado a finPrograma
	 */
	public void cargaPrograma() throws Exception{
		
		FileInputStream f = new FileInputStream("src/Sistema/system.data");
		ObjectInputStream o = new ObjectInputStream(f);
		Sistema.sist = (Sistema)o.readObject();
		o.close();
			
	}

    public static void vaciarSistema() {
	    Sistema.getInstance();
		Sistema.camiones.clear();
		Sistema.clientes.clear();
		Sistema.cuentas.clear();
		Sistema.facturas.clear();
		Sistema.lotes.clear();
		Sistema.operarios.clear();
        Sistema.paquetes.clear();
		Sistema.pedidos.clear();
        Sistema.repartidores.clear();
	}






	}




