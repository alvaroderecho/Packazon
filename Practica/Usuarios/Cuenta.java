package Usuarios;

import java.text.Normalizer;

public class Cuenta {
    
    protected String nombre_usuario;
    protected String contrasenia;
    
    //constructor de la clase cuenta
    public Cuenta(String Nombre_usuario, String Password) {
    
        this.nombre_usuario = Nombre_usuario;
        this.contrasenia = Password;
    }

    //funcion para añadir un nombre de usuario
    public void SetNombreUsuario(String Nombre) {
        if(Nombre==null) return;
        this.nombre_usuario = Nombre;
    }

     //funcion para añadir una contrasenia
     public void SetContrasenia(String Password) {
        if(Password==null) return;
        this.contrasenia = Password;

    }



//funcion para acceder al sistema 
public boolean loguearse(String Nombre, String Password){
    if(this.nombre_usuario !=Nombre ||  this.contrasenia != Password) return false;

    return true;
}





}