
package Usuarios;
public class ClienteNoRegistrado{
    
public Cliente registrarse(String Nombre_usuario, String Contraseña, String nombre_empresa, String Cif, String direc_fact, String email, String Num_tarjeta) {

    Cliente NewCliente = new Cliente(nombre_empresa, Cif, direc_fact, email, Num_tarjeta, Nombre_usuario, Contraseña);
    
    return NewCliente;
}
}