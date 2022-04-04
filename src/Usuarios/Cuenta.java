package Usuarios;

import java.text.Normalizer;
/**
 * Clase cuenta
 * @author Joseba Arranz
 * @author Alvaro Derecho
 * @author Salah
 */
public class Cuenta {
    
    protected String nombre_usuario;
    protected String contrasenia;
    
    /**
     * constructor
     * @param Nombre_usuario
     * @param Password
     */
    public Cuenta(String Nombre_usuario, String Password) {
    
        this.nombre_usuario = Nombre_usuario;
        this.contrasenia = Password;
    }

    /**
     * 
     * @param Nombre
     */
    public void SetNombreUsuario(String Nombre) {
        if(Nombre==null) return;
        this.nombre_usuario = Nombre;
    }

     /**
      * 
      * @param Password
      */
     public void SetContrasenia(String Password) {
        if(Password==null) return;
        this.contrasenia = Password;

    }
    /**
     * 
     * @return
     */
    public String GetNombreUsuario() {
        return this.nombre_usuario;
    }

    /**
     * 
     * @return
     */
    public String GetContrasenia() {
        return this.contrasenia;
    }



    /**
     * Devuelve true si el usuario y contraseña son correctos
     * @param Nombre
     * @param Password
     * @return
     */
    public boolean loguearse(String Nombre, String Password){
        if(this.nombre_usuario !=Nombre ||  this.contrasenia != Password) return false;

        return true;
    }

}