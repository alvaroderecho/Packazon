package Interfaces.vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Sistema.Sistema;
import Reparto.Camion;
import javax.swing.table.*;
import javax.swing.border.EmptyBorder;

public class ConsultarCamionesPanel extends JPanel{
    private JLabel packazon;
    final private JButton botonVolver = new JButton("Volver");  /*Mismo eventListener en todos los q vuelvan */
    final private JPanel panelBtnVolver = new JPanel();
    final private JButton botonRegistrar = new JButton("Registrar Camión");
    final private JPanel panelRegistrar = new JPanel();
    final private JLabel lista = new JLabel("Lista de camiones:");
    final private Object[] titulos = {"Camiones", "Estado"/*, "Alta/Baja"*/};
    private DefaultTableModel modeloTabla = new DefaultTableModel(1, titulos.length);
    private JTable tabla;
    final private JPanel tablaPanel = new JPanel();
    private JScrollPane scroll;
    final private JPanel listaPanel = new JPanel();

    public ConsultarCamionesPanel() {
        createPic();
        setLayoutManager();
        setLocationAndSize();
        check();
        addComponents();

    }

    public void check() {
        if (Sistema.getCamiones().isEmpty()) {
            listaPanel.setVisible(false);
            tablaPanel.setVisible(false);
        } else {
            modeloTabla.setRowCount(0);
            listaPanel.setVisible(true);
            tablaPanel.setVisible(true);
            for (Camion c: Sistema.getCamiones()) {
                Object[] fila = {c.getMatricula(), c.getAlta()};
                modeloTabla.addRow(fila);
            }
        }
    }

    private void createPic() {
        packazon = Ventana.createPic();
    }

     
    public void setLayoutManager() {
		setLayout(new GridLayout(5, 1, 0, 0));
    }

    public void setLocationAndSize() {
        lista.setBorder(new EmptyBorder(0,0,0,60));
        modeloTabla.setColumnIdentifiers(titulos);
        tabla = new JTable(modeloTabla);
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabla.setPreferredScrollableViewportSize(new Dimension(400, 60));
        scroll = new JScrollPane(tabla);
    }

    public void addActionEvent() {
    }

    public void addComponents() {
        this.add(packazon);
        panelRegistrar.add(botonRegistrar);
        this.add(panelRegistrar);
        listaPanel.add(lista);
        this.add(listaPanel);
        tablaPanel.add(scroll);
        this.add(tablaPanel);
        panelBtnVolver.add(botonVolver);
        this.add(panelBtnVolver);
    }

    public void setControlador(ActionListener c) {  
		botonVolver.addActionListener(c);
        botonRegistrar.addActionListener(c);
	}

    public JButton getBackButton() {
        return botonVolver;
    }

    public JButton getRegistrar() {
        return botonRegistrar;
    }
}
