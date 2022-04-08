package Interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;

//USAR BoxLayout

public class Ejemplo1 {

	public static void main(String[] args) {

		try {
			JFrame ventana = new JFrame("Ejemplo1");
			JPanel panel = new JPanel();
			panel.setBounds(50, 50, 250, 250);
			BufferedImage titulo = ImageIO.read(new File("src/Interfaces/figuras/logo.png"));
			JLabel pic = new JLabel(new ImageIcon(titulo));
			panel.add(pic);
			ventana.add(panel);
			// obtener contenedor, asignar layout
			Container contenedor = ventana.getContentPane();
			contenedor.setLayout(null);
			// crear componentes
			JLabel etiqueta = new JLabel("Nombre");
			final JTextField campo = new JTextField(10);
			JButton boton = new JButton("Haz click");
			// asociar acciones a componentes
			boton.addActionListener(
					new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							JOptionPane.showMessageDialog(null, campo.getText());
						}
					});
			// aniadir componentes al contenedor
			contenedor.add(etiqueta);
			contenedor.add(campo);
			contenedor.add(boton);
			contenedor.setBounds(50, 100, 250, 250);

			// mostrar ventana
			ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			ventana.setExtendedState(JFrame.MAXIMIZED_BOTH); // Pantalla completa
			ventana.setVisible(true);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
