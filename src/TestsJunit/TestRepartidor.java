package TestsJunit;
import static org.junit.Assert.assertEquals;
import org.junit.Test;


import Productos.*;
import Reparto.Paquete;
import Reparto.TipoPaquete;
import Usuarios.Repartidor;

import  java.util.*;
public class TestRepartidor {
    private Repartidor r;
    
    @Test
    public void constructorRepartidor1(){
        r = new Repartidor("900000000", "hla", "pass");
        assertEquals("900000000",r.getNumTelef());
    }
    @Test
    public void constructorRepartidor2(){
        r = new Repartidor("900000000", "hla", "pass");
        assertEquals(true, r.getAlta());
    }
    @Test
    public void MarcarPaqueteEntregado(){
        List<Producto> prods = new ArrayList<Producto>();
        prods.add(Pedido.createProducto(5, 10, 1, false, "hola", 20, TipoProducto.ALIMENTARIO));
        Paquete p = new Paquete("Avenida Valdelasfuente", 50, prods,TipoPaquete.ALIMENTARIO);
        r = new Repartidor("900000000", "hla", "pass");

        r.MarcarPaqueteEntregado(p);
        assertEquals(true, p.getEntregado());
        for (Producto pr:p.getProductos()){
        assertEquals(EstadoProducto.ENTREGADO, pr.getEstadoProducto());
        }    
    }
    @Test
    public void MarcarPaqueteNoEntregado(){
        List<Producto> prods = new ArrayList<Producto>();
        prods.add(Pedido.createProducto(5, 10, 1, false, "hola", 20, TipoProducto.ALIMENTARIO));
        Paquete p = new Paquete("Avenida Valdelasfuente", 50, prods,TipoPaquete.ALIMENTARIO);
        r = new Repartidor("900000000", "hla", "pass");
        int nuevasEntregas = 1;

        r.MarcarPaqueteNoEntregado(p);
        assertEquals(false, p.getEntregado());
        assertEquals(nuevasEntregas, p.getNumEntregasFallidas());
    }
    
}
