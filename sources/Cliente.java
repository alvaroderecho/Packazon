
package sources;
public class Cliente {
    
    private String nombre_empresa;
    private String Cif;
    private String direc_fact;
    private String email;
    private String Num_tarjeta;


public Cliente(String nombre_empresa, String Cif, String direc_fact, String email, String Num_tarjeta) {
    
        this.nombre_empresa = nombre_empresa;
        this.Cif = Cif;
        this.direc_fact = direc_fact;
        this.email = email;
        this.Num_tarjeta = Num_tarjeta;
        
    
    }
}