package Interfaces.Controladores;

import java.awt.event.*;
import Interfaces.vistas.*;


public class ControlVerPedidos implements ActionListener{
    private VerPedidosPanel vista;
	private Ventana frame;

    public ControlVerPedidos(Ventana frame) {
		this.frame = frame;
		this.vista = frame.getGetVistaVerPedidosPanel();
	}

    @Override
	public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getBackButton()) {
            this.frame.mostrarPanel("clientePanel"); 
        }
    }
}
