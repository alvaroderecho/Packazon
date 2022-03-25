package Usuarios;

import Productos.*;
import Reparto.Paquete;

import java.util.*;

public class Repartidor {
    String NumTelefono;
    Boolean Alta = false;
    List<Paquete> paquetes = new ArrayList<Paquete>();

    // constructor de la clase repartidor
    public Repartidor(String NumTelefono) {

        this.NumTelefono = NumTelefono;
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

    public void setAlta() {
        this.Alta = true;
    }

    public void setBaja() {
        this.Alta = false;
    }
}
