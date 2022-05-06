package Interfaces.Controladores;

import java.awt.event.*;
import Interfaces.vistas.*;


public class ControlConsultarRepartidores implements ActionListener{
    private ConsultarRepartidoresPanel vista;
	private Ventana frame;

    public ControlConsultarRepartidores(Ventana frame) {
		this.frame = frame;
		this.vista = frame.getGetVistaConsultarRepartidoresPanel();
	}

    @Override
	public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getBackButton()) {
            this.frame.mostrarPanel("operarioPanel"); 
        }
    }
}
