package Usuarios;

public class Factura {

    double PrecioTotal;
    String DireccEntrega;
    String DireccFact;
    String NumTarjeta;
    

//constructor de facturas
public Factura(Double PrecioTotal, String DireccEntrega, String DireccFact, String NumTarjeta) {
    
        this.PrecioTotal = PrecioTotal;
        this.DireccEntrega = DireccEntrega;
        this.DireccFact = DireccFact;
        this.NumTarjeta = NumTarjeta;
    
}
//funcion que devuelve el precio de la factura de un pedido
public Double getPrecioTotal(Factura f) {
     
    if(f ==null ) return null;
    return f.PrecioTotal;
}
}
