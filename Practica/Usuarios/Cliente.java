package Usuarios;
import Productos.EstadoPedido;
import Productos.Pedido;


public class Cliente extends Cuenta{
    
    private String Nombre_empresa;
    private String Cif;
    private String Direc_fact;
    private String Email;
    private String Num_tarjeta;


public Cliente(String nombre_empresa, String Cif, String direc_fact, String email, String Num_tarjeta, String Nombre_usuario, String Contrasenia) {
    
        super(Nombre_usuario, Contrasenia);
        this.Nombre_empresa = nombre_empresa;
        this.Cif = Cif;
        this.Direc_fact = direc_fact;
        this.Email = email;
        this.Num_tarjeta = Num_tarjeta;
        
    }

//funcion que devuelve el nombre de la empresa cliente
public String getNombreEmpresa() {
    
    return this.Nombre_empresa;
}
//funcion para ponerle nombre de empresa a un cliente
public void setNombreEmpresa(String nombre) {
    if(nombre==null) return;
    this.Nombre_empresa = nombre;
    return;
}
//funcion que devuelve el Cif de la empresa cliente
public String getCif() {

    return this.Cif;
}
//funcion para ponerle el cif a un cliente
public void setCif(String Cif) {
    if(Cif==null) return;
    this.Cif = Cif;
    return;
}

//funcion que devuelve la direccion de facturacion
public String getDirec_fact() {
    

    return this.Direc_fact;
}

//funcion para añadir direccion de facturacion a un cliente
public void setDirec_fact(String Direc_fact) {
    
    if(Direc_fact == null) return;
    this.Direc_fact = Direc_fact;

    return;
}

//funcion que devuelve el Email de la empresa
public String getEmail() {
    return this.Email;
}

//funcion para añadir un Email a un cliente
public void setEmail(String Email) {
    if(Email==null) return;
    this.Email = Email;
    return;

}

//funcion que devuelve el numero de tarjeta
public String getNumTarjeta() {
    

    return this.Num_tarjeta;
}


//funcion para añadir un numero de tarjeta
public void setNumTarjeta(String Num_tarjeta) {
    if(Num_tarjeta == null) return;
    this.Num_tarjeta = Num_tarjeta;
    return;
}
//funcion que consulta el estado de un pedido realizado por un cliente
public boolean consultarEstado(Pedido p) {

    if(p == null) return false;

    if(p.estadoPedido() ==EstadoPedido.NO_ENTREGADO ) return false;
    return true;
}



//funcion que edita el nombre de usuario y contraseña
public void EditarPerfil(String Nombre_usuario, String Contrasenia){
    super.SetNombreUsuario(nombre_usuario);
    super.SetContrasenia(contrasenia);
    return;

}

//funcion para obtener factura del pedido
public Factura getFactura(Pedido p) {

    if(p == null) return null;

    return p.getFactura();
}





}
