package Interfaces.Controladores;

import java.awt.event.*;
import Interfaces.vistas.*;
import Usuarios.Operario;


public class ControlRegistrarRepartidor implements ActionListener{
    private RegistrarRepartidorPanel vista;
	private Ventana frame;

    public ControlRegistrarRepartidor(Ventana frame) {
		this.frame = frame;
		this.vista = frame.getGetVistaRegistrarRepartidorPanel();
	}

    @Override
	public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getBackButton()) {
            this.frame.getGetVistaConsultarRepartidoresPanel().check();
            this.frame.mostrarPanel("consultarRepartidoresPanel"); 
        } else if (e.getSource() == vista.getRegisterButton()) {
            Operario.registrarRepartidor(vista.getTelef(), vista.getUser(), vista.getPassword());
            this.frame.getGetVistaConsultarRepartidoresPanel().check();
            this.frame.mostrarPanel("consultarRepartidoresPanel"); 
        }
    }
}
