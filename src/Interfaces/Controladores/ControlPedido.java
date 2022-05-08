package Interfaces.Controladores;

import java.awt.event.*;
import Interfaces.vistas.*;
import Usuarios.Operario;

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
            Operario.darAltaPedido(vista.getDestino(), vista.getCIF(), vista.isUrgent());
            Operario.addAllProducts(Operario.get_n_pedido(), vista.getProductos());
            this.frame.mostrarPanel("operarioPanel"); 
        } else if (e.getSource() == vista.getAddProduct()) {
            this.frame.getGetVistaProductPanel().reset();
            this.frame.mostrarPanel("productPanel");
            /**hay que pasar el pedido */
        } 
    }
}
