package ejemplosComponentes.JTabbedPane;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PanelPares extends JPanel implements ActionListener {
	private JLabel etiqueta;
	private JTextField campo;
	private JButton boton;
	private JFrame ventana;
	
	public PanelPares(JFrame ventana, String etiquetaCampo, 
			                          String etiquetaBoton) {
		this.ventana = ventana;	
		this.etiqueta = new JLabel(etiquetaCampo);
		this.campo = new JTextField(10);
		this.boton = new JButton(etiquetaBoton);
		
		// asociar acciones a componentes
		boton.addActionListener( this );
		
		// asignar Layout Manager y a�adir componentes 
		this.setLayout(new BorderLayout() );
		this.add(etiqueta, BorderLayout.WEST);
		this.add(campo, BorderLayout.CENTER);
		JPanel botonPanel = new JPanel(); botonPanel.add(boton);
		this.add(botonPanel, BorderLayout.SOUTH);	
	}


// OJO esto viola el patron MVC. Si la comprobaci�n de paridad es parte
// de la funcionalidad del MODELO de la aplicaci�n, NO DEBE HACERSE en 
// la VISTA sino que el CONTROLADOR asociado con ella es quien debe
// invocar al MODELO para realizar dicha funcionalidad.
	@Override
	public void actionPerformed(ActionEvent ev) {
	  String mensaje = "";
	  try {
	    Integer num = Integer.parseInt( this.campo.getText() );
		if ( num % 2 == 0 )
		  mensaje = "S�, " + num + " es par";
	    else mensaje = "El n�mero " + num + " no es par";
	  } catch (NumberFormatException e) {
		  mensaje = this.campo.getText() 
				   + "No se ha introducido un n�mero entero v�lido";
	  } finally {
		  JOptionPane.showMessageDialog(ventana, mensaje);
	  }
	}
	
	public void limpiaCampos() { this.campo.setText(""); }

}
