package Usuarios;

import Productos.*;
import Reparto.Paquete;

import java.util.*;
/**
 * Clase repartidor
 * @author Joseba Arranz
 * @author Alvaro Derecho
 * @author Salah
 */
public class Repartidor extends Cuenta{
    private String NumTelefono;
    private Boolean Alta = true;
    private List<Paquete> paquetes = new ArrayList<Paquete>();

    /**
     * constructor
     * @param NumTelefono
     */
    public Repartidor(String NumTelefono, String username, String password) {
        super(username, password);
        this.NumTelefono = NumTelefono;
    }
    /**
     * Marca un paquete como entregado y cambia el estado de todos los productos
     * @param p
     * @return
     */
    public Boolean MarcarPaqueteEntregado(Paquete p) {
        p.setEntregado(true);

        p.cambiarEstadoProductos(EstadoProducto.ENTREGADO);
        return true;
    }
    /**
     * Marca un paquete como no entregado y cambia el estado de todos los productos
     * @param p
     * @return
     */
    public Boolean MarcarPaqueteNoEntregado(Paquete p) {
        p.setEntregado(false);
        p.addEntregaFallida();
        return true;
    }
    /**
     * 
     */
    public void setAlta() {
        this.Alta = true;
    }
    /**
     * 
     */
    public void setBaja() {
        this.Alta = false;
    }
    /**
     * 
     * @return
     */
    public String getNumTelef() {
        return this.NumTelefono;
    }
    /**
     * 
     * @return
     */
    public boolean getAlta() {
        return this.Alta;
    }
}
