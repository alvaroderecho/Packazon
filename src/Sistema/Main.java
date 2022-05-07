package Sistema;
import Usuarios.*;
import Reparto.*;
import Productos.*;
import java.util.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * Clase que demuestra la funcionalidad básica de la aplicacion
 * @author Joseba Arranz
 * @author Alvaro Derecho
 * @author Salah
 */
public  class Main {
    private static Sistema sist;
    TipoCamion tp;
    private List <Pedido> pedidos = new ArrayList<Pedido>(); 
    /**
	 * Funcion main que comprueba toda la funcionalidad de la aplicacion
	 * @param args: Argumentos a pasar en la funcion
	 */

    public static void main(String[] args) {
		System.out.println("<<<<<<<<<<<<<<<<<<<CARGA DEL SISTEMA>>>>>>>>>>>>>>>");
		System.out.println("Leyendo la clase sistema en binario...\n");
		
        sist = Sistema.getInstance();

        System.out.println("Informacion leida: "); 
		System.out.println(sist);
		Sistema.vaciarSistema();

        

		System.out.println("\n\n<<<<<<<<<<<<<<<<<<<ANYADIR Y BORRAR CAMPOS>>>>>>>>>>>>>>>");
        

        //añadid productos
        //se crea array para añadir productos


        Lote lo = new Lote(12);
        System.out.println("creando lote...");
        System.out.println("Añadir productos al lote");
        ArrayList<Producto> productos = new ArrayList<Producto>();

        //se crea un producto refrigerado
        Refrigerado r = new Refrigerado(12, 10, 14, true, "descri", 12.5);
        sist.addProducto(r);
        lo.addProductLote(12, 10.0, 14, true, "descri", 12.5, TipoProducto.REFRIGERADO);
        System.out.println("Creando un producto de tipo refrigerado...");
        System.out.println("obteniendo la descripcion del producto");
        System.out.println(r.getDescription());
        System.out.println("obteniendo los detalles del precio");
        System.out.println( r.getPriceDetails());


        //se crea un producto congelado
        
        Congelado c = new Congelado(1114, 40, 01, true, "congelado", 11);
        sist.addProducto(c);
        System.out.println("Creando un producto congelado...");
        System.out.println("obteniendo la descripcion del producto congelado");
        System.out.println(c.getDescription());
        System.out.println("obteniendo los detalles del precio");
        System.out.println( r.getPriceDetails());
        

        //se crea un producto liquido
        Liquido l = new Liquido(1114, 20, 04, true, "liquido", 11);
        sist.addProducto(l);
        System.out.println("Creando un producto liquido...");
        System.out.println(l.getDescription());
        System.out.println("obteniendo los detalles del precio");
        System.out.println( r.getPriceDetails());
        

        //se crea un producto alimentario
        Alimentario al = new Alimentario(123,  26, 25 , false, "prueba alimentario", 90);
        sist.addProducto(al);
        System.out.println("Creando un producto alimentario...");
        System.out.println(al.getDescription());
        System.out.println("obteniendo los detalles del precio");
        System.out.println( al.getPriceDetails());

        //se crea un producto fragil
        Fragil fr= new Fragil(114, 20, 04, true, "fragil", 11);
        System.out.println("Creando un producto fragil...");

        sist.addProducto(fr);
        System.out.println("Creando un producto alimentario...");
        System.out.println(fr.getDescription());
        System.out.println("obteniendo los detalles del precio");
        System.out.println( fr.getPriceDetails());

       //creamos un lote de productos
      



        //crear un paquete
        Paquete pq = new Paquete("calle ..", 20, productos,TipoPaquete.NOALIMENTARIO);
        sist.addPaquete(pq);
        System.out.println("Creando un paquete...");
         //se crea pedido
         Pedido p = new Pedido(true, 3, "nuevoPedido");
         sist.addPedido(p);
         
         
 


        //se crea un camion para congelador
         Camion ca = new Camion("2342", 2,TipoCamion.CONGELADOS);
         //se añade el camion al array
         sist.addCamion(ca);

        //se crea un camion estandar
        Camion ca2 = new Camion("1252", 2,TipoCamion.ESTANDAR);
        ca2.setAlta();
        //se añade el camion al array
        sist.addCamion(ca2);



        //se crea un camion especial
        Camion ca3 = new Camion("2854", 2,TipoCamion.ESPECIAL);
        //se añade el camion al array
        sist.addCamion(ca3);


        //  PlanRepartoPorCamion pl = new PlanRepartoPorCamion();
        //  sist.addPlanDeReparto(pl);



         //crear un Cliente
        System.out.println("Creando un cliente ...");

        Cliente cl = new Cliente("Converse", "5434", "calle constitucion", "converse@gmail.com", "5434", "converse_sa", "contra1234");
		System.out.println("Creando un cliente...");
        sist.addCliente(cl);
        System.out.println("Consultando el estado dl pedido");
        cl.consultarEstado(p);
        cl.consultarEstadoProducto(p, fr);

        //crear un operario
        Operario op = new Operario("Juan_pd", "contra1234");
        System.out.println("Creando un operario...");
        System.out.println("Consultando el estado del camion: ");
        System.out.println("El estado del camion es: "+ op.consultarCamionEstropeado("2342") );
        System.out.println("el estado del repartidor es: "+op.consultarEstadoRepartidor("633346328"));
     
        //Crear un Repartidor
        Repartidor re = new Repartidor("633346328", "hla", "pass");
        System.out.println("Creando un Repartidor");

        re.MarcarPaqueteEntregado(pq);
        System.out.println("El paquete ha sido entregado correctamente");
        
        cl.getFactura(p);
        System.out.println("La factura se ha generado correctamente");




        System.out.println("\n\n<<<<<<<<<<<<<<<<<<<GUARDADO DEL PROGRAMA>>>>>>>>>>>>>>>");
        System.out.println("Guardando el sistema en un fichero en binario...");
        sist.guardaPrograma();
        System.out.println("Sistema guardado correctamente. Finalizando programa...");
    }
   

}