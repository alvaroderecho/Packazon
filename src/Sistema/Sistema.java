package Sistema;

import Usuarios.*;
import Reparto.*;
import Productos.*;
import java.util.*;

/**
 * Clase Sistema
 * @author Joseba Arranz
 * @author Alvaro Derecho
 * @author Salah
 */
public final class Sistema {
    private static VariablesGlobales variables;    /**Se carga en fichero */
    private static List<Cliente> cuentas = new ArrayList<Cliente>();

    public static void addCliente(Cliente c) {
        if (c!= null)
            Sistema.cuentas.add(c);
    }

    public static List<Cliente> getClientes() {
        return Sistema.cuentas;
    }

}
