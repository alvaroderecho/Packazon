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
public  class Sistema implements Serializable{


    private static Sistema sist = null;

    //cuentas disponibles
    private ArrayList<Cuenta> cuentas;
    

    //array de los operarios
    private ArrayList<Operario> operarios;

    //array de los clientes
    private ArrayList<Cliente> clientes;

    //array de los pedidos
    private ArrayList<Pedido> pedidos;

    //array de los repartidores
    private ArrayList<Repartidor> repartidores;

    //array de camiones 
    private ArrayList<Camion> camiones;

    //array de lotes
    private ArrayList<Lote> lotes;

    //array de paquetes
    private ArrayList<Paquete> paquetes;

    private ArrayList<Factura> facturas;

    private ArrayList<Producto> productos;

    private ArrayList<PlanRepartoPorCamion> planRepartoPorCamion;



    /**
     * Constructor de la clase sistema
     */
    private Sistema() {
        
        this.operarios = new ArrayList<Operario>();
        this.clientes = new ArrayList<Cliente>();
        this.cuentas = new ArrayList<Cuenta>();
        this.pedidos = new ArrayList<Pedido>();
        this.camiones = new ArrayList<Camion>();
        this.lotes = new ArrayList<Lote>();
        this.paquetes = new ArrayList<Paquete>();
        this.facturas = new ArrayList<Factura>();
        this.productos = new ArrayList<Producto>();



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
        if(this.cuentas.contains(c) == true || c == null ) return Status.ERROR;
        //se añade la cuenta al array de cuentas
        this.cuentas.add(c);
        return Status.OK;

    }

    /* Metodo para borrar cuentas*/

    public Status rmvCuenta(Cuenta c){
        //compruebo que la cuenta exista y que no sea null
        if(this.cuentas.contains(c) == false || c == null ) return Status.ERROR;
        //borro la cuenta del array de cuentas
		this.cuentas.remove(c); 
		return Status.OK;
    }

    /* Metodo para añadir operarios */

    public Status addOperario(Operario o) {

        if(this.operarios.contains(o)==true || o == null) return Status.ERROR;
        //añado operario al array de operarios
        this.operarios.add(o);
        return Status.OK;

    }

    public Status rmvOperario(Operario o){

        //compruebo que el operario exista y que no sea null
        if(this.operarios.contains(o) == false || o == null ) return Status.ERROR;
        //borro la cuenta del array de cuentas
		this.cuentas.remove(o); 
		return Status.OK;

    }
    
    public Status addCliente(Cliente c) {

        //Compruebo que el cliente no exista y que sea correcto
        if(this.clientes.contains(c)==true|| c==null) return Status.ERROR;

        this.clientes.add(c);
        return Status.OK;
    }

    public Status rmvCliente(Cliente c){

        //compruebo que el cliente exista y que no sea null
        if(this.clientes.contains(c) == false || c == null ) return Status.ERROR;
        //borro la cuenta del array de clientes
		this.cuentas.remove(c); 
		return Status.OK;

    }
    public Status addPedido(Pedido p ){
        //compruebo que el pedido no este ya y que sea correcto
        if(this.pedidos.contains(p) ==true||p == null) return Status.ERROR;
        this.pedidos.add(p);
        return Status.OK;

    }

    public Status rmvPedido(Pedido p){

        //compruebo que el pedido no exista y que no sea null
        if(this.pedidos.contains(p) == false || p == null ) return Status.ERROR;
        //borro la cuenta del array de clientes
		this.pedidos.remove(p); 
		return Status.OK;

    }

    public Status addRepartidor(Repartidor r){

        //compruebo que el repartidor no exista y que no sea null
        if(this.repartidores.contains(r) == true|| r == null) return Status.ERROR;
        
        this.repartidores.add(r);
        return Status.OK;

    }

    public Status rmvRepartidor(Repartidor r){

        //compruebo que el repartidor exista y que no sea null
        if(this.repartidores.contains(r) == false|| r == null) return Status.ERROR;

        this.repartidores.remove(r);
        return Status.OK;

    }

    public Status addCamion(Camion c){

        //compruebo que el camion no este en la lista
        if(this.camiones.contains(c)==true|| c == null) return Status.ERROR;

        this.camiones.add(c);
        return Status.OK;

    }

    public Status rmvCamion(Camion c) {

        //compruebo que el camion este en la lista y que no sea null
        if(this.camiones.contains(c) ==false|| c == null) return Status.ERROR;

        this.camiones.remove(c);
        return Status.OK;

    }

    public Status addLote(Lote l) {

        //compruebo que el lote no este ya en el array de lotes
        if(this.lotes.contains(l) == true || l == null) return Status.ERROR;

             this.lotes.add(l);
            return Status.OK;
        
    }


    public Status rmvLote(Lote l) {

        if(this.lotes.contains(l) == false || l == null) return Status.ERROR;

        this.lotes.remove(l);
        return Status.OK;

    }

    public Status addPaquete(Paquete pa) {

        if(this.paquetes.contains(pa)==true || pa == null) return Status.ERROR;

        this.paquetes.add(pa);
        return Status.OK;
    }

    public Status rmvPaquete(Paquete p) {

        if(this.lotes.contains(p) == false || p == null) return Status.ERROR;

        this.lotes.remove(p);
        return Status.OK;

    }

    public Status addFactura(Factura f) {

        if(this.facturas.contains(f)==true || f == null) return Status.ERROR;

        this.facturas.add(f);
        return Status.OK;
    }

    public Status rmvFactura(Factura f) {

        if(this.facturas.contains(f) == false || f == null) return Status.ERROR;

        this.facturas.remove(f);
        return Status.OK;

    }

    public Status addProducto(Producto p) {

        if(this.productos.contains(p)==true || p == null) return Status.ERROR;

        this.productos.add(p);
        return Status.OK;
    }

    public Status rmvProducto(Producto p) {

        if(this.productos.contains(p) == false || p == null) return Status.ERROR;

        this.productos.remove(p);
        return Status.OK;

    }

    public Status addPlanDeReparto(PlanRepartoPorCamion pl) {

        if(this.planRepartoPorCamion.contains(pl)==true || pl == null) return Status.ERROR;

        this.planRepartoPorCamion.add(pl);
        return Status.OK;
    }

    public Status rmvPlanDeReparto(PlanRepartoPorCamion pl) {

        if(this.planRepartoPorCamion.contains(pl)==true || pl== null) return Status.ERROR;

        this.planRepartoPorCamion.add(pl);
        return Status.OK;
    }



    
	/**
	 * Metodo que guarda el programa en lenguaje binario en un fichero
	 */
    public void guardaPrograma(){

		try{
			FileOutputStream f = new FileOutputStream("./data/system.data");
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
		
		FileInputStream f = new FileInputStream("./data/system.data");
		ObjectInputStream o = new ObjectInputStream(f);
		Sistema.sist = (Sistema)o.readObject();
		o.close();
			
	}

    public static void vaciarSistema() {
		Sistema sistem = Sistema.getInstance();
		sistem.camiones.clear();
		sistem.clientes.clear();
		sistem.cuentas.clear();
		sistem.facturas.clear();
		sistem.lotes.clear();
		sistem.operarios.clear();
        sistem.paquetes.clear();
		sistem.pedidos.clear();
        sistem.repartidores.clear();
	}






	}




