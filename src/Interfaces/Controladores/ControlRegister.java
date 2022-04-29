package Interfaces.Controladores;

import java.awt.event.*;
import Interfaces.vistas.*;

public class ControlRegister implements ActionListener{
    private RegisterPanel vista;
	private Ventana frame;

    public ControlRegister(Ventana frame) {
		this.frame = frame;
		this.vista = frame.getGetVistaRegisterPanel();
	}

    @Override
	public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getRegisterButton()) {
            this.frame.getGetVistaLoginPanel().clearButton();
            this.frame.mostrarPanel("loginPanel"); 
        }
    }   
}
