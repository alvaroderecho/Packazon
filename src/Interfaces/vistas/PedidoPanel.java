package Interfaces.vistas;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Productos.Pedido;

public class PedidoPanel extends JPanel{
    JLabel packazon;
  	final private JLabel direcc_Destino = new JLabel("Dirección de destino: ");
	  final private JTextField Destino_campo = new JTextField("Av de la Sierra", 15);
    final private JLabel dniCliente = new JLabel("DNI Cliente: ");
    final private JTextField dniCampo = new JTextField("XXXYYYZZZA", 10);
    final private JPanel dest = new JPanel();
    final private JLabel Urgente = new JLabel("Urgente: ");
    final private JCheckBox esUrgente = new JCheckBox();
    final private JPanel urgentPannel = new JPanel();
    final private JButton boton = new JButton("Añadir Producto");
    final private JPanel button = new JPanel();
    final private JPanel cliente = new JPanel();
    final private JButton finalizarPedido = new JButton("Finalizar Pedido");
    final private JPanel finalizarPanel = new JPanel();
    final private JButton botonVolver = new JButton("Volver");
    final private JPanel panelBtnVolver = new JPanel();


    public PedidoPanel() {
      createPic();
      setLayoutManager();
      addComponents();
    }

    private void createPic() {
      packazon = Ventana.createPic();
    }

    private void setLayoutManager() {
      setLayout(new GridLayout(8, 1, 0, 0));
    }

    private void addComponents() {
      this.add(packazon);

      /**Dirección de destino */
      dest.add(direcc_Destino);
      dest.add(Destino_campo);
      this.add(dest);

      /**DNI del cliente */
      cliente.add(dniCliente);
      cliente.add(dniCampo);
      this.add(cliente);

      /**Urgente */
      urgentPannel.add(Urgente);
      urgentPannel.add(esUrgente);
      this.add(urgentPannel);
      button.add(boton);
      this.add(button);

      /**Botones */
      finalizarPanel.add(finalizarPedido);
      this.add(finalizarPanel);
      panelBtnVolver.add(botonVolver);
      this.add(panelBtnVolver);
    }

    public void setControlador(ActionListener c) {  
      boton.addActionListener(c);
      finalizarPedido.addActionListener(c);
      botonVolver.addActionListener(c);
    }

    public JButton getBackButton() {
      return this.botonVolver;
    }

    public JButton getEndPedido() {
      return this.finalizarPedido;
    }

    public static void main(String[] args) {
    JFrame jf = new JFrame();
		PedidoPanel pf = new PedidoPanel();
    jf.add(pf);
    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jf.setSize(475, 500);
    jf.setTitle("Añadir Pedido");
    jf.setVisible(true);
	}
}