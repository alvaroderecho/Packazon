package Sistema;


import Productos.TipoProducto;
import Reparto.TipoCamion;
import Usuarios.Cliente;
import Usuarios.Operario;

public class PruebaEmpaquetado {
    public static void main(String[] args){
        System.out.println("hasta aqui va bien");
        Operario op = new Operario("Joseba", "1234");
        Cliente c = new Cliente("Packazon","53853085", "calle constitucion", "salah@gmail.com", "2000 3333 4444 5555","SalahSenhaji","contrasena1234");
        op.addCliente(c);
        op.registrar_camion("1", 1000, TipoCamion.CONGELADOS);
        op.registrar_camion("2", 1000, TipoCamion.ESTANDAR);
        op.registrar_camion("3", 1000, TipoCamion.REFRIGERADOS);
        op.darAltaCamion("1");
        op.darAltaCamion("2");
        op.darAltaCamion("3");
        op.darAltaPedido("UAM", "53853085", false);
        op.darAltaPedido("UAM", "53853085", false);
        op.addLotePedido(0);
       
        op.addLoteLotePedido(0, 1);
        op.addProductLotePedido(0,1, 1, 20, 1, false, "producto3", 10, TipoProducto.ALIMENTARIO);
        op.addProductLotePedido(0,1, 1, 20, 1, false, "producto4", 10, TipoProducto.ALIMENTARIO);
        op.addProductoLoteLotePedido(0, 1, 100,  1, 20, 1, false, "producto5", 10, TipoProducto.ESTANDAR);
        op.addProductoPedido(0, 5, 10, false, "producto1", 10, TipoProducto.ESTANDAR);
        op.addProductoPedido(1, 1, 20, false, "producto2", 10, TipoProducto.ESTANDAR);
        op.addProductoPedido(1, 10, 4, false, "producto_fragil1", 10, TipoProducto.FRAGIL);
        op.addProductoPedido(1, 1, 20, false, "producto congelado", 10, TipoProducto.CONGELADO);
        op.addProductoPedido(1, 1, 20, false, "producto refrigerado", 10, TipoProducto.REFRIGERADO);

        op.realizarEmpaquetado();
        System.out.println(op.toString());
        op.darAltaPedido("UAM1", "53853085", false);
        op.addProductoPedido(2, 5, 10, false, "producto6", 10, TipoProducto.ESTANDAR);
        op.realizarEmpaquetado();
        System.out.println(op.toString());
        op.planDeReparto();
        System.out.println(op.toString());
    }
}
