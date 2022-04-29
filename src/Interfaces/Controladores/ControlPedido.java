package Interfaces.Controladores;

import java.awt.event.*;
import Interfaces.vistas.*;

public class ControlPedido implements ActionListener{
    private PedidoPanel vista;
	private Ventana frame;

    public ControlPedido(Ventana frame) {
		this.frame = frame;
		this.vista = frame.getGetVistaPedidoPanel();
	}

    @Override
	public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getBackButton())
            this.frame.mostrarPanel("operarioPanel"); 
        else if (e.getSource() == vista.getEndPedido()) {
            this.frame.mostrarPanel("operarioPanel"); 
        } else if (e.getSource() == vista.getAddProduct()) {
            this.frame.mostrarPanel("productPanel");
        } 
    }
}
