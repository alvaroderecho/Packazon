package sources;

public class Camion {

    private String matricula;
    private boolean alta;
    private boolean estropeado;
    private Integer peso_max;
    private TipoCamion tipo;

    public Camion (String matricula, boolean alta, boolean estropeado, Integer peso_max, TipoCamion tipo){
        this.matricula = matricula;
        this.alta = alta;
        this.estropeado = estropeado;
        this.peso_max = peso_max;
        this.tipo = tipo;

    }
    public String getMatricula (){
        return this.matricula;
    }
    public void setMatricula(String matricula){
        this.matricula = matricula;
    }
    public boolean getAlta (){
        return this.alta;
    }
    public void setAlta(boolean alta){
        this.alta = alta;
    }
    public boolean getEstropeado(){
        return this.estropeado;
    }
    public void setEstropeado(boolean estropeado){
        this.estropeado = estropeado;
    }
    public void setPesoMax(Integer p){
        this.peso_max = p;
    }
    public Integer getPesoMax(){
        return this.peso_max;
    }
    public TipoCamion getTipocCamion(){
        return this.tipo;
    }
    public void setTipoCamion(TipoCamion t){
        this.tipo = t;
    }
}
