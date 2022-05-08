package Interfaces.vistas;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import Productos.Producto;
import java.util.List;

public class PedidoPanel extends JPanel{
    JLabel packazon;
  	final private JLabel direcc_Destino = new JLabel("Dirección de destino: ");
	  final private JTextField Destino_campo = new JTextField("Av de la Sierra", 15);
    final private JLabel cifCliente = new JLabel("CIF Cliente: ");
    final private JTextField cifCampo = new JTextField("XXXYYYZZZA", 10);
    final private JPanel dest = new JPanel();
    final private JLabel Urgente = new JLabel("Urgente: ");
    final private JCheckBox esUrgente = new JCheckBox();
    final private JPanel urgentPannel = new JPanel();
    final private JButton botonAddProduct = new JButton("Añadir Producto");
    final private JButton botonAddLote = new JButton("Añadir Lote");
    final private JPanel button = new JPanel();
    final private JPanel cliente = new JPanel();
    final private JButton finalizarPedido = new JButton("Finalizar Pedido");
    final private JPanel finalizarPanel = new JPanel();
    final private JButton botonVolver = new JButton("Volver");
    final private JPanel panelBtnVolver = new JPanel();

    private List<Producto> products = new ArrayList<>();

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
      cliente.add(cifCliente);
      cliente.add(cifCampo);
      this.add(cliente);

      /**Urgente */
      urgentPannel.add(Urgente);
      urgentPannel.add(esUrgente);
      this.add(urgentPannel);
      button.add(botonAddProduct);
      button.add(botonAddLote);
      this.add(button);

      /**Botones */
      finalizarPanel.add(finalizarPedido);
      this.add(finalizarPanel);
      panelBtnVolver.add(botonVolver);
      this.add(panelBtnVolver);
    }

    public void setControlador(ActionListener c) {  
      botonAddProduct.addActionListener(c);
      finalizarPedido.addActionListener(c);
      botonVolver.addActionListener(c);
    }

    public JButton getBackButton() {
      return this.botonVolver;
    }

    public JButton getEndPedido() {
      return this.finalizarPedido;
    }

    public JButton getAddProduct() {
      return this.botonAddProduct;
    }

    public JButton getAddLote() {
      return this.botonAddLote;
    }

    public String getDestino() {
      return Destino_campo.getText();
    }

    public String getCIF() {
      return cifCampo.getText();
    }

    public boolean isUrgent() {
      return esUrgente.isSelected();
    }

    public void addProduct(Producto p) {
      if (p!=null)
        products.add(p);
    }
	
    public List<Producto> getProductos() {
      return this.products;
    }
}