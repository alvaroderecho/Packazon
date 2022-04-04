package Usuarios;
/**
 * Clase Variables globales
 * @author Joseba Arranz
 * @author Alvaro Derecho
 * @author Salah
 */
public class VariablesGlobales {    

    /**HACER 
     * STATIC
     */

    private static double max_volumen_prod; /*Indeterminado */
    private static int max_cod_post;           /*Maximo codigos postales */
    private static int max_entregas_fallidas = 3;

    private static double descuento_100_prod = 0.10;      /*Descuento que se aplica tras tener 100*/
    private static double tasa_alimentarios = 2.0;
    private static double tasa_fragiles = 2.0;
    private static double tasa_asegurados = 5.0;

    public VariablesGlobales() {}


    void set_max_volumen_prod(double max) {
        VariablesGlobales.max_volumen_prod = max;
    }

    void set_max_entregas_fallidas(int max) {
        VariablesGlobales.max_entregas_fallidas = max;
    }

    void set_max_cod_post(int max) {
        VariablesGlobales.max_cod_post = max;
    }
    
    void set_descuento(double max) {
        VariablesGlobales.descuento_100_prod = max;
    }

    void set_tasa_alim(double max) {
        VariablesGlobales.tasa_alimentarios= max;
    }

    void set_tasa_frag(double max) {
        VariablesGlobales.tasa_fragiles = max;
    }

    void set_tasa_aseg(double max) {
        VariablesGlobales.tasa_asegurados = max;
    }
    public static int getMaxCodPost(){
        return VariablesGlobales.max_cod_post;
    }
    public static double getTasaAseg(){
        return VariablesGlobales.tasa_asegurados;
    }
    public static double getTasaFrag(){
        return VariablesGlobales.tasa_fragiles;
    }
    public static double getTasaAlim(){
        return VariablesGlobales.tasa_alimentarios;
    }
    public static double getMaxVolum() {
        return VariablesGlobales.max_volumen_prod;
    }
    public static double getDescuento() {
        return VariablesGlobales.descuento_100_prod;
    }
    public static int getEntregasFallidas() {
        return VariablesGlobales.max_entregas_fallidas;
    }
}
