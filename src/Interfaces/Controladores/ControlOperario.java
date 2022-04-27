package Interfaces.Controladores;

import java.awt.event.*;
import Interfaces.vistas.*;

public class ControlOperario implements ActionListener{
    private OperarioPanel vista;
	private Ventana frame;

    public ControlOperario(Ventana frame) {
		this.frame = frame;
		this.vista = frame.getGetVistaOperarioPanel();
	}

    @Override
	public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getBackButton()) {
            this.frame.getGetVistaLoginPanel().clearButton();
            this.frame.mostrarPanel("loginPanel");
        } 
        else if (e.getSource() == vista.getAddPedidoButton()) {
            this.frame.mostrarPanel("pedidoPanel");
        }
    }


}
