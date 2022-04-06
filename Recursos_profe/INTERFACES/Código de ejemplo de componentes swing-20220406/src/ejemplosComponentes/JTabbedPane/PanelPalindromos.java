package ejemplosComponentes.JTabbedPane;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PanelPalindromos extends JPanel implements ActionListener {
	private JLabel etiqueta;
	private JTextField campo;
	private JButton boton;
	private JFrame ventana;
	
	public PanelPalindromos(JFrame ventana, String etiquetaCampo, 
			                                String etiquetaBoton) {
		this.setLayout(new FlowLayout());
		this.ventana = ventana;
		this.etiqueta = new JLabel(etiquetaCampo);
		this.campo = new JTextField(10);
		this.boton = new JButton(etiquetaBoton);
		
		// asociar acciones a componentes
		boton.addActionListener( this );
		
		// a�adir componentes al panel
		this.add(etiqueta);
		this.add(campo);
		this.add(boton);
	}

// OJO esto viola el patron MVC. Si la comprobaci�n de palindromo es parte
// de la funcionalidad del MODELO de la aplicaci�n, NO DEBE HACERSE en
// la VISTA sino que el CONTROLADOR asociado con ella es quien debe
// invocar al MODELO para realizar dicha funcionalidad.
	public void actionPerformed(ActionEvent ev) {
      String mensaje;
      String texto = campo.getText();
	  if ( texto.equals(   new StringBuilder( texto ).reverse().toString()) )
           mensaje = "Yes, " + texto + " es pal�ndromo";
      else mensaje = "No es pal�dromo. Try again ...";
	  JOptionPane.showMessageDialog(ventana, mensaje);
	}
    
	public void limpiaCampos() { this.campo.setText(""); };
}
