package componentes;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class JTableSinModelo extends JFrame {
	
	JTable tabla; 
	
	public JTableSinModelo(String[] titulos, final Object[][] filas) {
		// obtener contenedor, asignar layout
		Container contenedor = this.getContentPane();
		contenedor.setLayout(new FlowLayout());
		
		tabla = new JTable(filas, titulos);

		// Por defecto se pueden seleccionar varias filas en la tabla. Si se
		// quiere que sólo pueda seleccionarse una, usar setSelectionMode
		tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		        
		// Podemos fijar el tamaño de la tabla 
		tabla.setPreferredScrollableViewportSize(new Dimension(500, 140));
		        
		// Es aconsejable crear una barra de scroll para la tabla,
		// por si el número de filas supera el tamaño previsto 
		JScrollPane scrollTabla = new JScrollPane(tabla);		        
		contenedor.add(scrollTabla); // contenedor.add(tabla); 
		
		tabla.setAutoCreateRowSorter(true); // permitir reordenación 
		
		// codigo equivalente al del Listene de una JList
		// PORQUE JTable lleva dentro un ListSelectionModel igual que JList
		tabla.getSelectionModel().addListSelectionListener(new ListSelectionListener () {
			public void valueChanged(ListSelectionEvent event) {
			  if (event.getValueIsAdjusting()==false) {
			  // Para saber qué fila está seleccionada, 
			  int indiceSeleccionado = event.getFirstIndex();
			  System.out.println(indiceSeleccionado + " : "
					             + filas[indiceSeleccionado][0].toString());
			}
		 }
		});

		// mostrar ventana, this JFrame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(550,240);
		setVisible(true);
	}
		
	public static void main(String[] args) throws java.io.IOException {
		  String[] titulos = { "Nombre", "Apellido", "Edad", "Saldo", "Casado" };
		  Object[][] filas = {   	
	    { "jose11", "perez", 23, 25.50, false }, { "maria", "garcia", 33, 500.25, true },
     	{ "jose01", "lopez", 13, 0.0, false },  { "marta67", "sanchez", 43, 10300, false },
     	{ "jose2", "lopez", 13, 0.0, true },    { "marta", "sanchez", 43, 10300, true },
	  	{ "jose99", "lopez", 13, 0.0, false }, { "marta122", "sanchez", 43, 10300, false },
		{ "jose00", "lopez", 13, 0.0, false }, { "marta", "sanchez", 43, 10300, true }
		  		};
		  

        new JTableSinModelo(titulos, filas);
 
	}
}