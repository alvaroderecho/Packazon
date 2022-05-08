package Interfaces.Controladores;

import Interfaces.vistas.*;

public class Controlador {
	
	private ControlLogin contLogin;
	private ControlCliente contCliente;
	private ControlRepartidor contRepartidor;
	private ControlOperario contOperario;
	private ControlPedido contPedido;
	private ControlProduct contProduct;
	private ControlRegister contRegister;
	private ControlTasas contTasas;
	private ControlEditarPerfil contEditarPerfil;
	private ControlConsultarRepartidores contConsultarRepartidores;
	private ControlConsultarCamiones contConsultarCamiones;
	private ControlRegistrarRepartidor contRegistrarRepartidor;
	private ControlRegistrarCamion contRegistrarCamion;
	private ControlVerPedidos contVerPedidos;

	private Ventana frame;

	public Controlador(Ventana frame) {
		this.frame = frame;
		this.contLogin = new ControlLogin(frame);
		this.contCliente = new ControlCliente(frame);
		this.contRepartidor = new ControlRepartidor(frame);
		this.contOperario = new ControlOperario(frame);
		this.contPedido = new ControlPedido(frame);
		this.contProduct = new ControlProduct(frame);
		this.contRegister = new ControlRegister(frame);
		this.contTasas = new ControlTasas(frame);
		this.contEditarPerfil = new ControlEditarPerfil(frame);
		this.contConsultarRepartidores = new ControlConsultarRepartidores(frame);
		this.contConsultarCamiones = new ControlConsultarCamiones(frame);
		this.contRegistrarRepartidor = new ControlRegistrarRepartidor(frame);
		this.contRegistrarCamion = new ControlRegistrarCamion(frame);
		this.contVerPedidos = new ControlVerPedidos(frame);
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

	public ControlProduct getControlProduct() {
		return this.contProduct;
	}

	public ControlRegister getControlRegister() {
		return this.contRegister;
	}

	public ControlTasas getControlTasas() {
		return this.contTasas;
	}

	public ControlEditarPerfil getControlEditarPerfil() {
		return this.contEditarPerfil;
	}

	public ControlConsultarRepartidores getControlConsultarRepartidores() {
		return this.contConsultarRepartidores;
	}

	public ControlConsultarCamiones getControlConsultarCamiones() {
		return this.contConsultarCamiones;
	}

	public ControlRegistrarRepartidor getControlRegistrarRepartidor() {
		return this.contRegistrarRepartidor;
	}

	public ControlRegistrarCamion getControlRegistrarCamion() {
		return this.contRegistrarCamion;
	}

	public ControlVerPedidos getControlVerPedidos() {
		return this.contVerPedidos;
	}
}
