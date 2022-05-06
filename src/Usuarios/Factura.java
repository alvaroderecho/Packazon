package Usuarios;
import Productos.Pedido;
import java.util.Arrays;
import java.util.List;

import es.uam.eps.padsof.invoices.IInvoiceInfo;
import es.uam.eps.padsof.invoices.IProductInfo;
import es.uam.eps.padsof.invoices.InvoiceSystem;
import es.uam.eps.padsof.invoices.NonExistentFileException;
import es.uam.eps.padsof.invoices.UnsupportedImageTypeException;
/**
 * Clase Factura
 * @author Joseba Arranz
 * @author Alvaro Derecho
 * @author Salah
 */
public class Factura {

    Double PrecioTotal;
    String DireccEntrega;
    String DireccFact;
    String NumTarjeta;
    

/**
 * Constructor
 * @param PrecioTotal
 * @param DireccEntrega
 * @param DireccFact
 * @param NumTarjeta
 */
public Factura(Double PrecioTotal, String DireccEntrega, String DireccFact, String NumTarjeta) {
    
        this.PrecioTotal = PrecioTotal;
        this.DireccEntrega = DireccEntrega;
        this.DireccFact = DireccFact;
        this.NumTarjeta = NumTarjeta;
    
}
/**
 * 
 * @param f
 * @return
 */
public Double getPrecioTotal(Factura f) {
     
    if(f ==null ) return null;
    return f.PrecioTotal;
}

public void generarFactura()  throws NonExistentFileException, UnsupportedImageTypeException {
    InvoiceSystem.createInvoice( 
        new Pedido( true,  123, "calle ebro"),			    
            "./tmp/" // Output folder
          );    
}
} 

