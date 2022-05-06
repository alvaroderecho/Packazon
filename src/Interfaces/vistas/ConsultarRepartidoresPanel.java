package Interfaces.vistas;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import Sistema.Sistema;
import Usuarios.*;

public class ConsultarRepartidoresPanel extends JPanel{
    private JLabel packazon;
    final private JButton botonVolver = new JButton("Volver");  /*Mismo eventListener en todos los q vuelvan */
    final private JPanel panelBtnVolver = new JPanel();
    final private JButton botonRegistrar = new JButton("Registrar Repartidor");
    final private JPanel panelRegistrar = new JPanel();
    final private String[] titulos = {"Repartidores", "Estado", "Contacto", "Alta/Baja"};
    final private Object[][] vacio = {};
    private DefaultTableModel modeloTabla = new DefaultTableModel(vacio, titulos);
    private JTable tabla = new JTable(modeloTabla);
    final private JPanel tablaPanel = new JPanel();

    public ConsultarRepartidoresPanel() {
        check();
        createPic();
        setLayoutManager();
        setLocationAndSize();
        addComponents();
    }

    public void check() {
        if (Sistema.getRepartidores().isEmpty()) {
            tablaPanel.setVisible(false);
        } else {
            modeloTabla.setRowCount(0);
            tablaPanel.setVisible(true);
            for (Repartidor r: Sistema.getRepartidores()) {
                Object[] fila = {r.GetNombreUsuario(), r.getAlta(), r.getNumTelef(), "hola"};
                modeloTabla.addRow(fila);
            }
        }
    }

    private void createPic() {
        packazon = Ventana.createPic();
    }

     
    public void setLayoutManager() {
		setLayout(new GridLayout(9, 1, 0, 0));
    }

    public void setLocationAndSize() {
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    }

    public void addActionEvent() {
    }

    public void addComponents() {
        this.add(packazon);
        panelRegistrar.add(botonRegistrar);
        this.add(panelRegistrar);
        tablaPanel.add(tabla);
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
