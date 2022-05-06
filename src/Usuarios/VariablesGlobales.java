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

    private static double max_volumen_prod = 30; /*Indeterminado */
    private static int max_cod_post = 100;           /*Maximo codigos postales */
    private static int max_entregas_fallidas = 3;

    private static double descuento_100_prod = 0.10;      /*Descuento que se aplica tras tener 100*/
    private static double tasa_alimentarios = 2.0;
    private static double tasa_fragiles = 2.0;
    private static double tasa_asegurados = 5.0;

    public VariablesGlobales() {}

    /**
     * Cambia el volumen maximo por producto
     * @param max
     */
    public static void set_max_volumen_prod(double max) {
        VariablesGlobales.max_volumen_prod = max;
    }
    /**
     * Cambia el maximo de entregas fallidas
     * @param max
     */
    public static void set_max_entregas_fallidas(int max) {
        VariablesGlobales.max_entregas_fallidas = max;
    }
    /**
     * Cambia el maximo de codigos postales
     * @param max
     */
    public static void set_max_cod_post(int max) {
        VariablesGlobales.max_cod_post = max;
    }
    /**
     * Cambia el descuento que se aplica a los 100 productos
     * @param max
     */
    public static void set_descuento(double max) {
        VariablesGlobales.descuento_100_prod = max;
    }
    /**
     * Cambia la tasa por producto alimentario
     * @param max
     */
    public static void set_tasa_alim(double max) {
        VariablesGlobales.tasa_alimentarios= max;
    }
    /**
     * Cambia la tasa por producto fragil
     * @param max
     */
    public static void set_tasa_frag(double max) {
        VariablesGlobales.tasa_fragiles = max;
    }
    /** 
     * Cambia la tasa por asegurados
     * @param max
     */
    public static void set_tasa_aseg(double max) {
        VariablesGlobales.tasa_asegurados = max;
    }
    /**
     * Devuelve el maximo de codigos postales
     * @return
     */
    public static int getMaxCodPost(){
        return VariablesGlobales.max_cod_post;
    }  
    /**
     * Devuelve la tasa por asegurados
     * @return
     */
    public static double getTasaAseg(){
        return VariablesGlobales.tasa_asegurados;
    }
    /**
     * Devuelve la tasa por fragil
     * @return
     */
    public static double getTasaFrag(){
        return VariablesGlobales.tasa_fragiles;
    }
    /**
     * Devuelve la tasa por alimentario
     * @return
     */
    public static double getTasaAlim(){
        return VariablesGlobales.tasa_alimentarios;
    }
    /**
     * Devuelve el maximo de volumen por producto
     * @return
     */
    public static double getMaxVolum() {
        return VariablesGlobales.max_volumen_prod;
    }
    /**
     * Devuelve el descuento a los 100 productos
     * @return
     */
    public static double getDescuento() {
        return VariablesGlobales.descuento_100_prod;
    }
    /**
     * Devuelve el maximo de entregas fallidas
     * @return
     */
    public static int getEntregasFallidas() {
        return VariablesGlobales.max_entregas_fallidas;
    }
}
