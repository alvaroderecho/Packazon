package Interfaces.Controladores;

import Interfaces.vistas.*;

public class Controlador {
	
	private ControlLogin contLogin;
	private ControlCliente contCliente;
	private ControlRepartidor contRepartidor;
	private ControlOperario contOperario;
	private ControlPedido contPedido;

	private Ventana frame;

	public Controlador(Ventana frame) {
		this.frame = frame;
		this.contLogin = new ControlLogin(frame);
		this.contCliente = new ControlCliente(frame);
		this.contRepartidor = new ControlRepartidor(frame);
		this.contOperario = new ControlOperario(frame);
		this.contPedido = new ControlPedido(frame);
	}

	public ControlLogin getControlLogin() {
		return this.contLogin;
	}

	public ControlCliente getControlCliente() {
		return this.contCliente;
	}

	public ControlRepartidor getControlRepartidor() {
		return this.contRepartidor;
	}

	public ControlOperario getControloOperario() {
		return this.contOperario;
	}

	public ControlPedido getControloPedido() {
		return this.contPedido;
	}
}
