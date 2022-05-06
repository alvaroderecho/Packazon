package Usuarios;
import Productos.*;
import java.util.*;
import Sistema.Sistema;
/**
 * Clase cliente
 * @author Joseba Arranz
 * @author Alvaro Derecho
 * @author Salah
 */
public class Cliente extends Cuenta{
    
    private String Nombre_empresa;
    private String Cif;
    private String Direc_fact;
    private String Email;
    private String Num_tarjeta;
    private List <Pedido> pedidos = new ArrayList<Pedido>(); 


/**
 * Constructor
 * @param nombre_empresa
 * @param Cif
 * @param direc_fact
 * @param email
 * @param Num_tarjeta
 * @param Nombre_usuario
 * @param Contrasenia
 */
public Cliente(String nombre_empresa, String Cif, String direc_fact, String email, String Num_tarjeta, String Nombre_usuario, String Contrasenia) {
        super(Nombre_usuario, Contrasenia);
        this.Nombre_empresa = nombre_empresa;
        this.Cif = Cif;
        this.Direc_fact = direc_fact;
        this.Email = email;
        this.Num_tarjeta = Num_tarjeta;
        Sistema.addCliente(this);
    }

/**
 * Devuelve el nombre de la empresa
 * @return
 */
public String getNombreEmpresa() {
    
    return this.Nombre_empresa;
}
/**
 * Modifica el nombre de la empresa
 * @param nombre
 */
public void setNombreEmpresa(String nombre) {
    if(nombre==null) return;
    this.Nombre_empresa = nombre;
    return;
}
/**
 * devuelve el CIF
 * @return
 */
public String getCif() {

    return this.Cif;
}
/**
 * set cif
 * @param Cif
 */
public void setCif(String Cif) {
    if(Cif==null) return;
    this.Cif = Cif;
    return;
}
/**
 * 
 * @return
 */
public String getDirec_fact() {
    

    return this.Direc_fact;
}

/**
 * 
 * @param Direc_fact
 */
public void setDirec_fact(String Direc_fact) {
    
    if(Direc_fact == null) return;
    this.Direc_fact = Direc_fact;

    return;
}

/**
 * 
 * @return
 */
public String getEmail() {
    return this.Email;
}

/**
 * 
 * @param Email
 */
public void setEmail(String Email) {
    if(Email==null) return;
    this.Email = Email;
    return;

}

/**
 * 
 * @return
 */
public String getNumTarjeta() {
    

    return this.Num_tarjeta;
}


/**
 * 
 * @param Num_tarjeta
 */
public void setNumTarjeta(String Num_tarjeta) {
    if(Num_tarjeta == null) return;
    this.Num_tarjeta = Num_tarjeta;
    return;
}
/**
 * consulta el estado del pedido, si esta entregado devuelve true, lo contrario si no lo esta
 * @param p
 * @return
 */
public EstadoPedido consultarEstado(Pedido p) {

    if(p == null) return EstadoPedido.NO_ENTREGADO;

    for (Pedido ped: this.pedidos) {
        if (ped == p) {
            return ped.estadoPedido();
        }
    }
    return EstadoPedido.NO_ENTREGADO;
}

public EstadoProducto consultarEstadoProducto(Pedido p, Producto pr) {

    if(p == null || pr == null) return EstadoProducto.ALMACEN;

    if(p.estadoPedido() == EstadoPedido.ENTREGADO ) return EstadoProducto.ENTREGADO;

    else {
        for (Producto pro: p.getProductos()) {
            if (pro == pr) {
                return pro.getEstadoProducto();
            }
        }
    }
    return EstadoProducto.ALMACEN;
}



/**
 * Cambiar el perfil
 * @param Nombre_usuario
 * @param Contrasenia
 */
public void EditarPerfil(String nombre_empresa, String direc_fact, String email, String num_tarjeta, String Nombre_usuario, String Contrasenia){
    SetNombreUsuario(Nombre_usuario);
    SetContrasenia(Contrasenia);
    this.Nombre_empresa = nombre_empresa;
    this.Direc_fact = direc_fact;
    this.Email = email;
    this.Num_tarjeta = num_tarjeta;
    return;

}

/**
 * devuelve la factura de un pedido
 * @param p
 * @return
 */
public Factura getFactura(Pedido p) {

    if(p == null) return null;

    return p.getFactura();
}


/**
 * añade un pedido al array
 * @param p
 */
public void addPedido(Pedido p) {
    if (p!=null) {
        this.pedidos.add(p);
    }
}
}
