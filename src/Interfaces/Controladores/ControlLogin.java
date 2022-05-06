package Interfaces.Controladores;

import java.awt.event.*;
import Interfaces.vistas.*;
import Sistema.Sistema;
import java.util.List;
import Usuarios.*;

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
				/**SOMOS UN CLIENTE */
				List<Cliente> clientes = Sistema.getClientes();
				for (Cliente c: clientes) {
					if (usuario.equals(c.GetNombreUsuario()) && password.equals(c.GetContrasenia())) {
						this.frame.getGetVistaClientePanel().setCliente(c);
						this.frame.mostrarPanel("clientePanel");
					}
				}
				return;
			} else if (tipoCuenta.equals("Repartidor")) {
				/**SOMOS UN REPARTIDOR */
				this.frame.mostrarPanel("repartidorPanel");
				return;
			} else {
				/**SOMOS UN OPERARIO */
				if (usuario.equals("operario") && password.equals("12345"))
					this.frame.mostrarPanel("operarioPanel");
				return;
			}
		} else if (e.getSource() == vista.getRegisterButton()) {
			this.frame.mostrarPanel("registerPanel");
		}

	}
}
