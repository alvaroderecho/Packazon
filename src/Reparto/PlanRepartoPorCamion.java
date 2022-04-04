package Reparto;

import java.util.*;
import Usuarios.Repartidor;
/**
 * Clase plan de reparto por camión
 * @author Joseba Arranz
 * @author Alvaro Derecho
 * @author Salah
 */
public class PlanRepartoPorCamion {

    private Repartidor repartidor;
    private Camion camion;
    private List<Paquete> paquetes;


    public PlanRepartoPorCamion planDeRepartoPorCamion() {

        for (Paquete p : this.paquetes) {
            if (p.getFallido() == false) {
                //se incluye en el plan
            }
        }

        return null;
    }

    /**
     * devuelve el repartidor
     * @return
     */
    public Repartidor getRepartidor() {
        return this.repartidor;
    }
    
    /**
     * devuelve el camion
     * @return
     */
    public Camion getCamion() {
        return this.camion;
    }
}
