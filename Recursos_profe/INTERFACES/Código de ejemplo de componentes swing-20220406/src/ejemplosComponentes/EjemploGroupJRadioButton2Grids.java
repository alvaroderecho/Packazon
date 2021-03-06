package ejemplosComponentes;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EjemploGroupJRadioButton2Grids {
	public static void main(String[] args) {
		final JFrame ventana = new JFrame("Ventana Ejemplo");

		// obtener contenedor, asignar layout
		Container contenedor = ventana.getContentPane();
		contenedor.setLayout(new FlowLayout());

		// crear componentes
		JLabel etiqueta = new JLabel("Selecciona UNA opcion:");
		JButton boton   = new JButton("Haz click");
		final JRadioButton opcion1 = new JRadioButton("menor de 18 a�os");
		final JRadioButton opcion2 = new JRadioButton("entre 18 y 40 a�os");
		final JRadioButton opcion3 = new JRadioButton("mayor de 40 a�os");
		opcion1.setSelected(true);
		
		// Crear un grupo para las opciones, el cual garantizar�
		// que s�lo una de las opciones est� seleccionada
		ButtonGroup grupo = new ButtonGroup();
		// A�adir las opciones al grupo
		grupo.add(opcion1);
		grupo.add(opcion2);
		grupo.add(opcion3);

		// asociar acciones a componentes
		boton.addActionListener(
		  new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		      String salida = "";
		      if (opcion1.isSelected()) salida += " seleccion " + opcion1.getText();
		      if (opcion2.isSelected()) salida += " seleccion " + opcion2.getText();
		      if (opcion3.isSelected()) salida += " seleccion " + opcion3.getText();
		      JOptionPane.showMessageDialog(ventana, salida);
		    }
		  }
		);

		// a�adir las casillas al panel donde se quieran mostrar
		JPanel ejemploRadioButton = new JPanel(new GridLayout(3,1,0,10));
		ejemploRadioButton.add(opcion1);
		ejemploRadioButton.add(opcion2);
		ejemploRadioButton.add(opcion3);

		// crear nuevo panel para etiqueta+panelJRadioButton+botonAccion
		JPanel outterPanel = new JPanel(new GridLayout(3,1,0,10));
		// a�adir componentes al outterPanel
		outterPanel.add(etiqueta);
		outterPanel.add(ejemploRadioButton);
		// outterPanel.add(boton);
	    JPanel buttonPanel = new JPanel();
		buttonPanel.add(boton);
		outterPanel.add(buttonPanel);
		
		// a�adir componentes al contenedor
		contenedor.add(outterPanel);
		ejemploRadioButton.setVisible(true);

		// mostrar ventana
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setSize(230,350);
		ventana.setVisible(true);

	}
}
