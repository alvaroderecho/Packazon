package TestsJunit;
import Productos.*;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestPedido {

    private Producto producto1,producto2;

    @Test
    public void createProductoAlimentario(){
        producto1 = Pedido.createProducto(3, 5, 1, true, "PADSOF1", 10,TipoProducto.ALIMENTARIO);
        producto2 = new Alimentario(3, 5, 1, true, "PADSOF1", 10);
        assertEquals(producto2.getId(), producto1.getId());
    }
    @Test
    public void createProductoEstandar(){
        producto1 = Pedido.createProducto(3, 5, 1, true, "PADSOF1", 10,TipoProducto.ESTANDAR);
        producto2 = new Estandar(3, 5, 1, true, "PADSOF1", 10);
        assertEquals(producto2.getId(), producto1.getId());
    }
    @Test
    public void createProductoCongelado(){
        producto1 = Pedido.createProducto(3, 5, 1, true, "PADSOF1", 10,TipoProducto.CONGELADO);
        producto2 = new Congelado(3, 5, 1, true, "PADSOF1", 10);
        assertEquals(producto2.getId(), producto1.getId());
    }
    @Test
    public void createProductoFragil(){
        producto1 = Pedido.createProducto(3, 5, 1, true, "PADSOF1", 10,TipoProducto.FRAGIL);
        producto2 = new Fragil(3, 5, 1, true, "PADSOF1", 10);
        assertEquals(producto2.getId(), producto1.getId());
    }
    @Test
    public void createProductoLiquido(){
        producto1 = Pedido.createProducto(3, 5, 1, true, "PADSOF1", 10,TipoProducto.LIQUIDO);
        producto2 = new Liquido(3, 5, 1, true, "PADSOF1", 10);
        assertEquals(producto2.getId(), producto1.getId());
    }
    @Test
    public void createProductoRefrigerado(){
        producto1 = Pedido.createProducto(3, 5, 1, true, "PADSOF1", 10,TipoProducto.REFRIGERADO);
        producto2 = new Refrigerado(3, 5, 1, true, "PADSOF1", 10);
        assertEquals(producto2.getId(), producto1.getId());
    }
}
