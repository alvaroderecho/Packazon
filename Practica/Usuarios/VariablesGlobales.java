package Usuarios;
public class VariablesGlobales {    

    /**HACER 
     * STATIC
     */

    private double max_volumen_prod;
    private int max_cod_post;           /*Maximo codigos postales */
    private int max_entregas_fallidas;

    private double descuento_100_prod;      /*Descuento que se aplica tras tener 100*/
    private double tasa_alimentarios;
    private double tasa_fragiles;
    private double tasa_asegurados;

    public VariablesGlobales(double volumen, int codpost, int entrega, double dcto, double alim, double frag, double aseg) {
        this.max_volumen_prod = volumen;
        this.max_entregas_fallidas = entrega;
        this.max_cod_post = codpost;
        this.descuento_100_prod = dcto;
        this.tasa_alimentarios = alim;
        this.tasa_asegurados = frag;
        this.tasa_asegurados = aseg;
    }


    public void set_max_volumen_prod(double max) {
        this.max_volumen_prod = max;
    }

    public void set_max_entregas_fallidas(int max) {
        this.max_entregas_fallidas = max;
    }

    public void set_max_cod_post(int max) {
        this.max_cod_post = max;
    }
    
    public void set_descuento(double max) {
        this.descuento_100_prod = max;
    }

    public void set_tasa_alim(double max) {
        this.tasa_alimentarios = max;
    }

    public void set_tasa_frag(double max) {
        this.tasa_fragiles = max;
    }

    public void set_tasa_aseg(double max) {
        this.tasa_asegurados = max;
    }
    public int get_max_cod_post(){
        return this.max_cod_post;
    }
    public double get_tasa_aseg(){
        return this.tasa_asegurados;
    }
    public double get_tasa_frag(){
        return this.tasa_fragiles;
    }
    public double get_tasa_alim(){
        return this.tasa_alimentarios;
    }
}
