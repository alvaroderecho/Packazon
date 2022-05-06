package Interfaces.vistas;

import javax.swing.*;
import java.io.*;

import Interfaces.Controladores.*;
import javax.imageio.ImageIO;
import java.awt.*;

public class Ventana extends JFrame {
	/**Vistas */
	private LoginPanel loginPanel = new LoginPanel();
	private ClientePanel clientePanel = new ClientePanel();
	private RepartidorPanel repartidorPanel = new RepartidorPanel();
	private OperarioPanel operarioPanel = new OperarioPanel();
	private PedidoPanel pedidoPanel = new PedidoPanel();
	private ProductPanel productPanel = new ProductPanel();
	private RegisterPanel registerPanel = new RegisterPanel();
	private TasasPanel tasasPanel = new TasasPanel();
	private EditarPerfilPanel editarPerfilPanel = new EditarPerfilPanel();
	private ConsultarRepartidoresPanel consultarRepartidoresPanel = new ConsultarRepartidoresPanel();
	private RegistrarRepartidorPanel registrarRepartidorPanel = new RegistrarRepartidorPanel();
	private ConsultarCamionesPanel consultarCamionesPanel = new ConsultarCamionesPanel();
	private RegistrarCamionPanel registrarCamionPanel = new RegistrarCamionPanel();

	/**Controladores */
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
	private ControlRegistrarRepartidor contRegistrarRepartidor;
	private ControlConsultarCamiones contConsultarCamiones;
	private ControlRegistrarCamion contRegistrarCamion;

	private JPanel contentPane;
	
	public Ventana() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(475, 500);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout());

		/**Añadimos todas las vistas */
		contentPane.add(loginPanel, "loginPanel");
		contentPane.add(clientePanel, "clientePanel");
		contentPane.add(repartidorPanel, "repartidorPanel");
		contentPane.add(operarioPanel, "operarioPanel");
		contentPane.add(pedidoPanel, "pedidoPanel");
		contentPane.add(productPanel, "productPanel");
		contentPane.add(registerPanel, "registerPanel");
		contentPane.add(tasasPanel, "tasasPanel");
		contentPane.add(editarPerfilPanel, "editarPerfilPanel");
		contentPane.add(consultarRepartidoresPanel, "consultarRepartidoresPanel");
		contentPane.add(consultarCamionesPanel, "consultarCamionesPanel");
		contentPane.add(registrarRepartidorPanel, "registrarRepartidorPanel");
		contentPane.add(registrarCamionPanel, "registrarCamionPanel");
	}

	public void setControlador(Controlador controlador) {
	 	this.contLogin = controlador.getControlLogin();
	 	loginPanel.setControlador(contLogin);
		this.contCliente = controlador.getControlCliente();
		clientePanel.setControlador(contCliente);
		this.contRepartidor = controlador.getControlRepartidor();
		repartidorPanel.setControlador(contRepartidor);
		this.contOperario = controlador.getControloOperario();
		operarioPanel.setControlador(contOperario);
		this.contPedido = controlador.getControloPedido();
		pedidoPanel.setControlador(contPedido);
		this.contProduct = controlador.getControlProduct();
		productPanel.setControlador(contProduct);
		this.contRegister = controlador.getControlRegister();
		registerPanel.setControlador(contRegister);
		this.contTasas = controlador.getControlTasas();
		tasasPanel.setControlador(contTasas);
		this.contEditarPerfil = controlador.getControlEditarPerfil();
		editarPerfilPanel.setControlador(contEditarPerfil);
		this.contConsultarRepartidores = controlador.getControlConsultarRepartidores();
		consultarRepartidoresPanel.setControlador(contConsultarRepartidores);
		this.contConsultarCamiones = controlador.getControlConsultarCamiones();
		consultarCamionesPanel.setControlador(contConsultarCamiones);
		this.contRegistrarRepartidor = controlador.getControlRegistrarRepartidor();
		registrarRepartidorPanel.setControlador(contRegistrarRepartidor);
		this.contRegistrarCamion = controlador.getControlRegistrarCamion();
		registrarCamionPanel.setControlador(contRegistrarCamion);
	}

	public LoginPanel getGetVistaLoginPanel() {
		return this.loginPanel;
	}

	public ClientePanel getGetVistaClientePanel() {
		return this.clientePanel;
	}

	public RepartidorPanel getGetVistaRepartidorPanel() {
		return this.repartidorPanel;
	}

	public OperarioPanel getGetVistaOperarioPanel() {
		return this.operarioPanel;
	}

	public PedidoPanel getGetVistaPedidoPanel() {
		return this.pedidoPanel;
	}

	public ProductPanel getGetVistaProductPanel() {
		return this.productPanel;
	}

	public RegisterPanel getGetVistaRegisterPanel() {
		return this.registerPanel;
	}

	public TasasPanel getGetVistaTasasPanel() {
		return this.tasasPanel;
	}

	public EditarPerfilPanel getGetVistEditarPerfilPanel() {
		return this.editarPerfilPanel;
	}

	public ConsultarRepartidoresPanel getGetVistaConsultarRepartidoresPanel() {
		return this.consultarRepartidoresPanel;
	}

	public ConsultarCamionesPanel getGetVistaConsultarCamionesPanel() {
		return this.consultarCamionesPanel;
	}

	public RegistrarRepartidorPanel getGetVistaRegistrarRepartidorPanel() {
		return this.registrarRepartidorPanel;
	}

	public RegistrarCamionPanel getGetVistaRegistrarCamionPanel() {
		return this.registrarCamionPanel;
	}
	
	
	public void mostrarPanel(String carta) {
		CardLayout l = (CardLayout)contentPane.getLayout();
		l.show(contentPane, carta);
	}

	public static JLabel createPic() {
		try {
             return new JLabel(new ImageIcon(ImageIO.read(new File("src/Interfaces/figuras/logo.png"))));

        }catch(IOException i) {
            i.printStackTrace();
			return null;
        }
	}

}
