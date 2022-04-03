package Reparto;
import java.util.*;
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
     *
     * @return matricula
     */
    public String getMatricula (){
        return this.matricula;
    }
    public void setMatricula(String matricula){
        this.matricula = matricula;
    }
    public boolean getAlta (){
        return this.alta;
    }
    public void setAlta(){
        this.alta = true;
    }
    public void setBaja(){
        this.alta = false;
    }
    public boolean getEstropeado(){
        return this.estropeado;
    }
    public void setEstropeado(){
        this.estropeado = true;
    }
    public void setNoEstropeado(){
        this.estropeado = false;
    }
    public void setPesoMax(int p){
        this.peso_max = p;
    }
    public int getPesoMax(){
        return this.peso_max;
    }
    public TipoCamion getTipocCamion(){
        return this.tipo;
    }
    public void setTipoCamion(TipoCamion t){
        this.tipo = t;
    }
}