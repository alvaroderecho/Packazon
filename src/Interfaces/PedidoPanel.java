package Interfaces;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Productos.Pedido;

public class PedidoPanel extends JPanel{
  	final private JLabel direcc_Destino = new JLabel("Dirección de destino: ");
	  final private JTextField Destino_campo = new JTextField("Av de la Sierra", 25);
    final private JPanel dest = new JPanel();
    final private JPanel destL = new JPanel();
    final private JLabel Urgente = new JLabel("Urgente: ");
    final private JCheckBox esUrgente = new JCheckBox();
    final private JPanel urgentPannel = new JPanel();
    final private JButton boton = new JButton("Añadir Producto");
    final private JPanel button = new JPanel();


    public PedidoPanel() {
      setLayoutManager();
      addComponents();
    }


    private void setLayoutManager() {
      setLayout(new GridLayout(4, 1, 0, 0));
    }

    private void addComponents() {
      /**Dirección de destino */
      destL.add(direcc_Destino);
      this.add(destL);
      dest.add(Destino_campo);
      this.add(dest);

      /**Urgente */
      urgentPannel.add(Urgente);
      urgentPannel.add(esUrgente);
      this.add(urgentPannel);
      button.add(boton);
      this.add(button);
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
