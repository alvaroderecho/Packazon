package Usuarios;
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
}
