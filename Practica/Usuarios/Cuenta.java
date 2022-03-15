package Usuarios;

    public class Cuenta {
    
    protected String Nombre_usuario;
    protected String Contrasenia;
    
    //constructor de la clase cuenta
    public Cuenta(String Nombre_usuario, String Contrasenia) {
    
        this.Nombre_usuario = Nombre_usuario;
        this.Contrasenia = Contrasenia;
    }

    //funcion para añadir un nombre de usuario
    public void SetNombreUsuario(String Nombre_usuario) {
        if(Nombre_usuario==null) return;
        this.Nombre_usuario = Nombre_usuario;
    }

     //funcion para añadir una contrasenia
     public void SetContrasenia(String Contrasenia) {
        if(Contrasenia==null) return;
        this.Contrasenia = Contrasenia;

    }



//funcion para acceder al sistema 
public boolean loguearse(String Nombre_usuario, String Contrasenia){
    if(this.Nombre_usuario !=Nombre_usuario ||  this.Contrasenia != Contrasenia) return false;

    return true;
}





}