package TestsJunit;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import Usuarios.Cuenta;
public class TestCuenta {
    Cuenta c;
    @Test
    public void constructorCuenta1() {
    c = new Cuenta("SalahSenhaji", "contra1234");
    assertEquals("SalahSenhaji", c.GetNombreUsuario());
    assertEquals("contra1234", c.GetContrasenia());
    
    }   

    @Test
    public void loguearse() {
    Cuenta c = new Cuenta("Salah","contra1234");

    assertEquals("Salah", c.GetNombreUsuario());
    assertEquals("contra1234", c.GetContrasenia());

    }
    
    



}

    

