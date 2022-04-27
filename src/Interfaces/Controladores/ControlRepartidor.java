package Interfaces.Controladores;

import java.awt.event.*;
import Interfaces.vistas.*;


public class ControlRepartidor implements ActionListener{
    private RepartidorPanel vista;
	private Ventana frame;

    public ControlRepartidor(Ventana frame) {
		this.frame = frame;
		this.vista = frame.getGetVistaRepartidorPanel();
	}

    @Override
	public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getBackButton()) {
            this.frame.getGetVistaLoginPanel().clearButton();
            this.frame.mostrarPanel("loginPanel"); 
        }
    }
}
