package Interfaces.Controladores;

import java.awt.event.*;
import Interfaces.vistas.*;


public class ControlCliente implements ActionListener{
    private ClientePanel vista;
	private Ventana frame;

    public ControlCliente(Ventana frame) {
		this.frame = frame;
		this.vista = frame.getGetVistaClientePanel();
	}

    @Override
	public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getBackButton()) {
            this.frame.getGetVistaLoginPanel().clearButton();
            this.frame.mostrarPanel("loginPanel"); 
        }
    }
}
