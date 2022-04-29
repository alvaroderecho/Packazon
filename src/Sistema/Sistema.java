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
public final class Sistema {        /**final significa que no puede haber clases que hereden de Sistema */
    private static VariablesGlobales variables;    /**Se carga en fichero */
    private static List<Cliente> clientes = new ArrayList<Cliente>();

    public static void addCliente(Cliente c) {
        if (c!= null)
            Sistema.clientes.add(c);
    }

    public static List<Cliente> getClientes() {
        return Sistema.clientes;
    }

}
