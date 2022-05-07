package Sistema;


import Productos.TipoProducto;
import Reparto.TipoCamion;
import Usuarios.Cliente;
import Usuarios.Operario;
/**
 * Prueba de empaquetado y plan de reparto
 * @author Joseba
 * @author Alvaro
 * @author Salah
 */
public class PruebaEmpaquetado {
    public static void main(String[] args){
        
        Cliente c = new Cliente("Packazon","53853085", "calle constitucion", "salah@gmail.com", "2000 3333 4444 5555","SalahSenhaji","contrasena1234");
        Sistema.addCliente(c);
        Operario.registrar_camion("1", 1000, TipoCamion.CONGELADOS);
        Operario.registrar_camion("2", 1000, TipoCamion.ESTANDAR);
        Operario.registrar_camion("3", 1000, TipoCamion.REFRIGERADOS);
        Operario.darAltaCamion("1");
        Operario.darAltaCamion("2");
        Operario.darAltaCamion("3");
        Operario.darAltaPedido("UAM", "53853085", false);
        Operario.darAltaPedido("UAM", "53853085", false);
        Operario.addLotePedido(0);
       
        Operario.addLoteLotePedido(0, 1);
        Operario.addProductLotePedido(0,1, 1, 20, 1, false, "producto3", 10, TipoProducto.ALIMENTARIO);
        Operario.addProductLotePedido(0,1, 1, 20, 1, false, "producto4", 10, TipoProducto.ALIMENTARIO);
        Operario.addProductoLoteLotePedido(0, 1, 100,  1, 20, 1, false, "producto5", 10, TipoProducto.ESTANDAR);
        Operario.addProductoPedido(0, 5, 10, false, "producto1", 10, TipoProducto.ESTANDAR);
        Operario.addProductoPedido(1, 1, 20, false, "producto2", 10, TipoProducto.ESTANDAR);
        Operario.addProductoPedido(1, 10, 4, false, "producto_fragil1", 10, TipoProducto.FRAGIL);
        Operario.addProductoPedido(1, 1, 20, false, "producto congelado", 10, TipoProducto.CONGELADO);
        Operario.addProductoPedido(1, 1, 20, false, "producto refrigerado", 10, TipoProducto.REFRIGERADO);

        Operario.realizarEmpaquetado();
        System.out.println(Operario.toStringPlan());
        Operario.darAltaPedido("UAM1", "53853085", false);
        Operario.addProductoPedido(2, 5, 10, false, "producto6", 10, TipoProducto.ESTANDAR);
        Operario.realizarEmpaquetado();
        System.out.println(Operario.toStringPlan());
        Operario.planDeReparto();
        System.out.println(Operario.toStringPlan());
    }
}
