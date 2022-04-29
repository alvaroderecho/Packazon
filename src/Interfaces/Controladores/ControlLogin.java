package Interfaces.Controladores;

import java.awt.event.*;
import Interfaces.vistas.*;

public class ControlLogin implements ActionListener {

	private LoginPanel vista;
	private Ventana frame;

	public ControlLogin(Ventana frame) {
		this.frame = frame;
		this.vista = frame.getGetVistaLoginPanel();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// validar valores en la vista
		String tipoCuenta = vista.getTipoCuenta();
		String usuario = vista.getUser();
		String password = vista.getPassword();
		if (e.getSource() == vista.getLoginButton()) {
			if (tipoCuenta.equals("Cliente")) {
				this.frame.mostrarPanel("clientePanel");
				return;
			} else if (tipoCuenta.equals("Repartidor")) {
				this.frame.mostrarPanel("repartidorPanel");
				return;
			} else {
				if (usuario.equals("operario") && password.equals("12345"))
					this.frame.mostrarPanel("operarioPanel");
				return;
			}
		} else if (e.getSource() == vista.getRegisterButton()) {
			this.frame.mostrarPanel("registerPanel");
		}

	}
}
