package TestsJunit;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import Productos.EstadoProducto;
import Productos.Producto;
import Reparto.Paquete;
import Usuarios.Repartidor;
public class TestRepartidor {
    private Repartidor r;
    
    @Test
    public void constructorRepartidor1(){
        r = new Repartidor("900000000");
        assertEquals("900000000",r.getNumTelef());
    }
    @Test
    public void constructorRepartidor2(){
        r = new Repartidor("900000000");
        assertEquals(false, r.getAlta());
    }
    @Test
    public void MarcarPaqueteEntregado(){
        Paquete p = new Paquete(false, "Avenida Valdelasfuentes", 30, 0);
        r = new Repartidor("900000000");

        r.MarcarPaqueteEntregado(p);
        assertEquals(true, p.getEntregado());
        for (Producto pr:p.getProductos()){
        assertEquals(EstadoProducto.ENTREGADO, pr.getEstadoProducto());
        }    
    }
    @Test
    public void MarcarPaqueteNoEntregado(){
        Paquete p = new Paquete(false, "Avenida Valdelasfuentes", 30, 0);
        r = new Repartidor("900000000");
        int nuevasEntregas = 1;

        r.MarcarPaqueteNoEntregado(p);
        assertEquals(false, p.getEntregado());
        assertEquals(nuevasEntregas, p.getNumEntregasFallidas());
    }
    
}
