package Reparto;
import java.util.*;
/**
 * Clase camion
 * @author Joseba Arranz
 * @author Alvaro Derecho
 * @author Salah
 */
public class Camion {

    private String matricula;
    private boolean alta = true;
    private boolean estropeado = false;
    private int peso_max;
    private TipoCamion tipo;
    private List<Paquete> paquetes;
/**
 * constructor de la clase camión
 * @param matricula
 * @param alta
 * @param peso_max
 * @param tipo
 */
    public Camion (String matricula, int peso_max, TipoCamion tipo){
        this.matricula = matricula;
        this.peso_max = peso_max;
        this.tipo = tipo;
        this.paquetes = new ArrayList<Paquete>();
    }
    /**
     *devuelve la matricula
     * @return matricula
     */
    public String getMatricula (){
        return this.matricula;
    }
    /**
     * añade la matricula 
     * @param matricula
     */
    public void setMatricula(String matricula){
        this.matricula = matricula;
    }
    /**
     * devuelve el estado de alta
     * @return
     */
    public boolean getAlta (){
        return this.alta;
    }
    /**
     * set alta
     */
    public void setAlta(){
        this.alta = true;
    }
    /**
     * set baja
     */
    public void setBaja(){
        this.alta = false;
    }
    /**
     * devuelve si esta estropeado
     * @return
     */
    public boolean getEstropeado(){
        return this.estropeado;
    }
    /**
     * Cambia el estado a estropeado
     */
    public void setEstropeado(){
        this.estropeado = true;
    }
    /**
     * cambia el estado a no estropeado
     */
    public void setNoEstropeado(){
        this.estropeado = false;
    }
    /**
     * set peso maximo 
     * @param p
     */
    public void setPesoMax(int p){
        this.peso_max = p;
    }
    /**
     * devuelve el peso maximo
     * @return
     */
    public int getPesoMax(){
        return this.peso_max;
    }
    /**
     * devuelve el tipo de camión
     * @return
     */
    public TipoCamion getTipocCamion(){
        return this.tipo;
    }
    /**
     * cambia el tipo de camion
     * @param t
     */
    public void setTipoCamion(TipoCamion t){
        this.tipo = t;
    } 
    /**
     * Devuelve el peso de todos los paquetes del camion
     * @return
     */
    public int getPesoActual(){
        int peso = 0;
        for (Paquete p: paquetes){
            peso += p.getPeso();
        }
        return peso;
    }
    /**
     * Devuelve el peso restante del camion
     * @return
     */
    public int getPesoRestante(){
        int peso_restante = this.peso_max - this.getPesoActual();
        return peso_restante;
    }
    /**
     * Añade un paquete al camion
     * @param p
     */
    public void addPaqueteCamion(Paquete p){
        this.paquetes.add(p);
    }
    /**
     * Devuelve la string a imprimir
     * @return
     */
    @Override
    public String toString(){
        return "Camion "+this.getMatricula().toString() + this.paquetes.toString();
    }
}