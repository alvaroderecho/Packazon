package Usuarios;
import Productos.*;
import Reparto.Paquete;

import java.util.*;

public class Repartidor {
    String NumTelefono;
    Boolean Alta;
    List<Paquete> paquetes = new ArrayList<Paquete>() ;

//constructor de la clase repartidor
public Repartidor(String NumTelefono, Boolean Alta) {

    this.NumTelefono = NumTelefono;
    this.Alta = Alta;
    }


public Boolean MarcarPaqueteEntregado(Paquete p) { 
    p.setEntregado(true);

    p.cambiarEstadoProductos(EstadoProducto.ENTREGADO);
    return true;
}
public Boolean MarcarPaqueteNoEntregado(Paquete p) {
    p.setEntregado(false);
    p.addEntregaFallida();
    return true;
}
}
