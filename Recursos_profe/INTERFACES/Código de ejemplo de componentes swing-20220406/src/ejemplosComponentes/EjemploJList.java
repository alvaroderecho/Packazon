package ejemplosComponentes;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class EjemploJList {

	public static void main(String[] args) {
		final JFrame ventana = new JFrame("Mi GUI");

		// obtener contenedor, asignar layout
		Container contenedor = ventana.getContentPane();
		contenedor.setLayout(new FlowLayout());

		// crear componentes
		JLabel etiqueta = new JLabel("Selecciona uno de la lista");
		 // Crear un array con los elementos de la lista
		String[] personas =  {"ana","eduardo","esther","jos�",
				              "juan","luis","mar�a","miguel","zoe"};
		        
		// Crear la lista, pasando el modelo como par�metro
		JList lista = new JList(personas);


		// asociar acciones a componentes
		lista.addListSelectionListener(
		  new ListSelectionListener() {
		    public void valueChanged(ListSelectionEvent ev) {
		    	JList localJList = (JList) ev.getSource();
		    	System.out.println( lista.getSelectedValue() );
		    	if (! ev.getValueIsAdjusting() ) {
		    	  String valorSeleccionado = 
		    			         (String) lista.getSelectedValue();
		          JOptionPane.showMessageDialog(ventana, "Seleccionaste: " 
		    			                               + valorSeleccionado);
		    	}
		    }
		  }
		);

		// Por defecto se pueden seleccionar varias filas en la lista. 
		// Para que s�lo se pueda seleccionar una, usar setSelectionMode
		lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
		        
		// Es aconsejable crear una barra de scroll para la lista,
		// por si el n�mero de elementos supera el tama�o previsto 
		JScrollPane scroll = new JScrollPane(lista);
		        
		// A�adir el scroll con la lista al panel donde se vaya a mostrar
		JPanel ejemploList = new JPanel();
		ejemploList.add(scroll);


		// a�adir componentes al contenedor
		contenedor.add(etiqueta);
		contenedor.add(ejemploList);
		ejemploList.setVisible(true);

		// mostrar ventana
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setSize(200,340);
		ventana.setVisible(true);

	}
}
