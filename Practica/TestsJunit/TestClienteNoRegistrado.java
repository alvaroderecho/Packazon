package Tests_Junit;
import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class TestClienteNoRegistrado {

        Cliente c;
        @Test

        public void constructorClienteNoRegistrado1() {

            Cliente c = new Cliente("Packazon", "53854930", "calle concilio", "Salah@gmail.com", "54637", "SalahSenhaji", "contra1234");
            assertEquals("Packazon", c.getNombreEmpresa()) ;


    
        }
    
}
