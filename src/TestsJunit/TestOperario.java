package TestsJunit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import Productos.Lote;
import Productos.Estandar;
import Productos.Pedido;
import Productos.Producto;
import Productos.TipoProducto;
import Reparto.Camion;
import Reparto.TipoCamion;
import Usuarios.Cliente;
import Usuarios.Operario;
import Usuarios.VariablesGlobales;

public class TestOperario {
    
    private Operario op;
    private Camion camion;
    private Cliente cliente;
    private Pedido pedido;
    private Producto producto;
    private Lote lote;

    @Test
    public void constructor(){
        op = new Operario("PADSOF", "1234");
        assertEquals("PADSOF", op.GetNombreUsuario());
        assertEquals("1234", op.GetContrasenia());
    }

    @Test
    public void consultarCamionEstropeado(){
        boolean flag;
        op = new Operario("PADSOF", "1234");
        op.registrar_camion("1234WQR", 1000, TipoCamion.ESTANDAR);
        flag = op.consultarCamionEstropeado("1234WQR");
        assertEquals(false, flag);
    }

    @Test 
    public void consultarEstadoRepartidor1(){
        boolean flag;
        op = new Operario("PADSOF", "1234");
        op.registrarRepartidor("1234567890");
        flag = op.consultarEstadoRepartidor("1234567890");
        assertEquals(true, flag);
    }
    @Test 
    public void consultarEstadoRepartidor2(){
        boolean flag;
        op = new Operario("PADSOF", "1234");
        op.registrarRepartidor("1234567890");
        op.darBajaRepartidor("1234567890");
        flag = op.consultarEstadoRepartidor("1234567890");
        assertEquals(false, flag);
    }
    // @Test
    // public void darAltaPedido(){
    //     op = new Operario("PADSOF", "1234");
    //     cliente = new Cliente("Packazon","53853085", "calle constitucion", "salah@gmail.com", "2000 3333 4444 5555","SalahSenhaji","contrasena1234");
    //     int id_pedido = op.get_n_pedido();
    //     op.darAltaPedido("Escuela politecnica", cliente, true);
    //     pedido = new Pedido(true, id_pedido,"Escuela politecnica" );
    //     assertEquals(pedido.getDirecEntrega(), op.getPedidoById(id_pedido).getDirecEntrega());
    // }
    // @Test
    // public void addProductoPedido(){
    //     op = new Operario("PADSOF", "1234");
    //     cliente = new Cliente("Packazon","53853085", "calle constitucion", "salah@gmail.com", "2000 3333 4444 5555","SalahSenhaji","contrasena1234");
    //     int id_pedido = op.get_n_pedido();
    //     op.darAltaPedido("Escuela politecnica", cliente, true);
    //     op.addProductoPedido(id_pedido, 3, 5, 1, false, "PADSOF1", 10, TipoProducto.ESTANDAR);
    //     producto = new Estandar(3, 5, 1, false, "PADSOF1", 10);

    //     assertEquals(producto.getDescription(), op.getPedidoById(id_pedido).getProductobyId(1).getDescription());
    // }

    // @Test
    // public void addLotePedido(){
    //     op = new Operario("PADSOF", "1234");
    //     cliente = new Cliente("Packazon","53853085", "calle constitucion", "salah@gmail.com", "2000 3333 4444 5555","SalahSenhaji","contrasena1234");
    //     int id_pedido = op.get_n_pedido();
    //     op.darAltaPedido("Escuela politecnica", cliente, true);
    //     lote = new Lote(1);
    //     op.addLotePedido(id_pedido);
    //     assertEquals(lote.getId(), op.getLotePedidoById(id_pedido, 1).getId());
    // }

    // @Test
    // public void addProductLote(){
    //     op = new Operario("PADSOF", "1234");
    //     cliente = new Cliente("Packazon","53853085", "calle constitucion", "salah@gmail.com", "2000 3333 4444 5555","SalahSenhaji","contrasena1234");
    //     int id_pedido = op.get_n_pedido();
    //     op.darAltaPedido("Escuela politecnica", cliente, true);
    //     lote = new Lote(1);
    //     op.addLotePedido(id_pedido);
    //     int id_lote = op.getLotePedidoById(id_pedido, 1).getId();
    //     op.addProductLotePedido(id_pedido, id_lote, 3, 5, 1, false, "PADSOF1", 10, TipoProducto.ESTANDAR);
    //     producto = new Estandar(3, 5, 1, false, "PADSOF1", 10);

    //     assertEquals(producto.getId(), op.getLotePedidoById(id_pedido, id_lote).getProductobyId(1).getId());
    // }

    // @Test 
    // public void addLoteLote(){
    //     op = new Operario("PADSOF", "1234");
    //     cliente = new Cliente("Packazon","53853085", "calle constitucion", "salah@gmail.com", "2000 3333 4444 5555","SalahSenhaji","contrasena1234");
    //     int id_pedido = op.get_n_pedido();
    //     op.darAltaPedido("Escuela politecnica", cliente, true);
    //     lote = new Lote((1*100)+0);
    //     op.addLotePedido(id_pedido);
    //     op.addLoteLotePedido(id_pedido, op.getLotePedidoById(id_pedido, 1).getId());
    //     int id_lote = op.getLotePedidoById(id_pedido, (1*100)+0).getId();
    //     assertEquals(lote.getId(), op.getLotePedidoById(id_pedido, id_lote).getId());
    // }

    
}
