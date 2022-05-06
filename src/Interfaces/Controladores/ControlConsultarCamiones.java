package Interfaces.Controladores;

import java.awt.event.*;
import Interfaces.vistas.*;


public class ControlConsultarCamiones implements ActionListener{
    private ConsultarCamionesPanel vista;
	private Ventana frame;

    public ControlConsultarCamiones(Ventana frame) {
		this.frame = frame;
		this.vista = frame.getGetVistaConsultarCamionesPanel();
	}

    @Override
	public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getBackButton()) {
            this.frame.mostrarPanel("operarioPanel"); 
        }
    }
}
