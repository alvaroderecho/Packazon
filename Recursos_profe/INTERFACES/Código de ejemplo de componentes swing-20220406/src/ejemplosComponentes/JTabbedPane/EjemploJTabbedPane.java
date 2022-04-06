package ejemplosComponentes.JTabbedPane;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class EjemploJTabbedPane {
	public static void main(String[] args) {
		final JFrame ventana = new JFrame("Ejemplo de uso de JTabbedPane");
		// obtener contenedor, asignar layout
		Container contenedor = ventana.getContentPane();
		contenedor.setLayout(new FlowLayout());

		// crear componentes
		JLabel etiqueta = new JLabel("Uso de pestañas (JTabbedPane)");
		 // Creamos un panel por cada pesta�a
		final PanelPares panelPares = 
				   new PanelPares(ventana, "Numero", "Check par");		
		final PanelPalindromos panelPalindromos = 
				   new PanelPalindromos(ventana, "Cadena", "Palíndromo?");
		        
		// Crear contenedor JTabbedPane para varios panels
		JTabbedPane pestanas = new JTabbedPane();
		pestanas.addTab("Pares",  panelPares);
		pestanas.addTab("Palíndromos",  panelPalindromos);

		// asociar acciones a componentes
		// Para acciones al cambiar de pesta�as definimos un ChangeListener
		pestanas.addChangeListener(new ChangeListener() {
		       public void stateChanged(ChangeEvent ev) { 
		    	   	 panelPares.limpiaCampos();
		    	   	 panelPalindromos.limpiaCampos();
		       }
		});

		// a�adir componentes al contenedor
		contenedor.add(etiqueta);
		contenedor.add(pestanas);

		// mostrar ventana
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setSize(360,240);
		ventana.setVisible(true);
	}
}
