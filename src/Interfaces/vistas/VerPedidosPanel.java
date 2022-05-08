package Interfaces.vistas;

import javax.swing.*;

import Usuarios.Cliente;
import Productos.Pedido;
import Sistema.Sistema;

import javax.swing.table.DefaultTableModel;

import java.util.ArrayList;
import java.util.List;

import java.awt.*;
import java.awt.event.*;

public class VerPedidosPanel extends JPanel{

    final private JButton botonVolver = new JButton("Volver");
    final private Object[] titulos = {"Pedido", "Destino" ,"Precio", "Productos", "Urgente"};
    private DefaultTableModel modeloTabla = new DefaultTableModel(1, titulos.length);
    private JTable tabla;
    final private JPanel tablaPanel = new JPanel();
    private JScrollPane scroll;

    final private JPanel volverPanel = new JPanel();

    private Cliente capo;

    private JLabel packazon;
    private List<Pedido> pedidos = new ArrayList<>();

    VerPedidosPanel() {
        createPic();
        setLayoutManager();
        setLocationAndSize();
        check();
        addComponents();
        addActionEvent();
 
    }

    public void check() {
            modeloTabla.setRowCount(0);
            int i = 0;
            for (Pedido p: pedidos) {
                i++;
                Object[] fila = {"Pedido " + i, p.getDirecEntrega(), p.getPrice(), p.getCantidadProds(), p.getUrgente()};
                modeloTabla.addRow(fila);
                
            }
    }

    public void setCiente(Cliente c) {
        capo = c;
        pedidos = Sistema.getPedidosByCIF(c.getCif());
    }

    public Cliente getCliente() {
        return capo;
    }

    private void createPic() {
        packazon = Ventana.createPic();
    }

     
    public void setLayoutManager() {
		setLayout(new GridLayout(9, 1, 0, 0));
    }

    public void setLocationAndSize() {
        modeloTabla.setColumnIdentifiers(titulos);
        tabla = new JTable(modeloTabla);
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabla.setPreferredScrollableViewportSize(new Dimension(400, 60));
        scroll = new JScrollPane(tabla);
    }

    public void addActionEvent() {
    }


    public void setControlador(ActionListener c) {  
        botonVolver.addActionListener(c);
	}

    public void addComponents() {
        this.add(packazon);
        tablaPanel.add(scroll);
        this.add(tablaPanel);
        volverPanel.add(botonVolver);
        this.add(volverPanel);
    }

    public JButton getBackButton() {
        return botonVolver;
    }

}
