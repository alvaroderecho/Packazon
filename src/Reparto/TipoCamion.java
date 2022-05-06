package Reparto;
/**
 * Clase tipo enum para los tipos de camiones
 * @author Joseba Arranz
 * @author Alvaro Derecho
 * @author Salah
 */
public enum TipoCamion {
    ESTANDAR, ESPECIAL, CONGELADOS, REFRIGERADOS;
    /**
     * Devuelve un valor segun el tipo
     * @param num
     * @return
     */
    public static TipoCamion getValor(int num) {
        if (num==0) return ESTANDAR;
        else if (num == 1) return ESPECIAL;
        else if (num == 2) return CONGELADOS;
        else return REFRIGERADOS;
    }
}
