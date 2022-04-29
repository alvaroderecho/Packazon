
package Usuarios;
/**
 * Clase cliente no registrado
 * @author Joseba Arranz
 * @author Alvaro Derecho
 * @author Salah
 */
public class ClienteNoRegistrado{
/**
 * Llama al constructor de la clase cliente y crea uno nuevo
 * @param Nombre_usuario
 * @param Contraseña
 * @param nombre_empresa
 * @param Cif
 * @param direc_fact
 * @param email
 * @param Num_tarjeta
 * @return
 */
public static Cliente registrarse(String Nombre_usuario, String Contraseña, String nombre_empresa, String Cif, String direc_fact, String email, String Num_tarjeta) {

    Cliente NewCliente = new Cliente(nombre_empresa, Cif, direc_fact, email, Num_tarjeta, Nombre_usuario, Contraseña);
    
    return NewCliente;
}
}