package TestsJunit;
import Productos.Pedido;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import Usuarios.Cliente;


public class TestCliente {
    Cliente c;
    Pedido p;
    @Test
    public void constructorCliente1() {
        c = new Cliente("Packazon","53853085", "calle constitucion", "salah@gmail.com", "2000 3333 4444 5555","SalahSenhaji","contrasena1234");

        assertEquals("Packazon", c.getNombreEmpresa());

    }

    @Test
    public void constructorCliente2() {
        c = new Cliente("Packazon","53853085", "calle constitucion", "salah@gmail.com", "2000 3333 4444 5555","SalahSenhaji","contrasena1234");

        assertEquals("53853085", c.getCif());
        assertEquals("calle constitucion", c.getDirec_fact());
        assertEquals("salah@gmail.com", c.getEmail());
        assertEquals("2000 3333 4444 5555", c.getNumTarjeta());
       
        
    }
    @Test
    public void EditarPerfil() {

    c = new Cliente("Packazon","53853085", "calle constitucion", "salah@gmail.com", "2000 3333 4444 5555","SalahSenhaji","contrasena1234");

    c.EditarPerfil("SalahSenhaji", "contrasena1234");
    assertEquals(c.GetNombreUsuario(), "SalahSenhaji");
    assertEquals(c.GetContrasenia(), "contrasena1234");


    }
   

    @Test 
    public void consultarEstado() {
        c = new Cliente("Packazon","53853085", "calle constitucion", "salah@gmail.com", "2000 3333 4444 5555","SalahSenhaji","contrasena1234");
        p = new Pedido (false,1,"UAM");
        

        assertEquals(false, c.consultarEstado(p));
    }

   /* @Test
    public void getFactura() {
    
        p = new Pedido ("calle","2314",true,"calleeee",11343);

        assertEquals(    ,p.getFactura());

    */

}
