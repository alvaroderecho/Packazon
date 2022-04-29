package Interfaces.vistas;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ProductPanel extends JPanel{
	final private JLabel descripcion = new JLabel("Descripción: ");
	final private JTextField description = new JTextField("roja y brillante", 17);
	final private JButton clear_description = new JButton("CLR");
	final private JPanel desc = new JPanel();
	final private JButton boton = new JButton("Añadir Producto");
	final private JRadioButton opcion1 = new JRadioButton("Estándar");
	final private JRadioButton opcion3 = new JRadioButton("Líquido");
	final private JRadioButton opcion2 = new JRadioButton("Alimentario");
	final private JRadioButton opcion4 = new JRadioButton("Refrigerado");
	final private JRadioButton opcion5 = new JRadioButton("Congelado");
	final private JRadioButton opcion6 = new JRadioButton("Frágil");
	final private JLabel units = new JLabel("Unidades:");
	final private JSpinner spinn = new JSpinner(new SpinnerNumberModel(1,1,10000,1));
	final private JLabel weight = new JLabel("Peso (kg):");
	final private JSpinner spinn_weight = new JSpinner(new SpinnerNumberModel(0.0,0.0,50.0,0.1));
	final private JLabel volumen = new JLabel("Volumen (cm3):");
	final private JSpinner spinn_volum = new JSpinner(new SpinnerNumberModel(0.0,0.0,50.0,0.1));
	final private ButtonGroup grupo = new ButtonGroup();
	final private JPanel spinnerPanel = new JPanel(new FlowLayout());
	final private JPanel fragil = new JPanel(new FlowLayout());
	final private JLabel asegu = new JLabel("Asegurado: ");
	final private JCheckBox asegurado = new JCheckBox();
	final private JPanel spinnGrid = new JPanel(new GridLayout());
	final private JPanel buttonPanel = new JPanel();
	final private JPanel jOpcion1 = new JPanel();
	final private JPanel jOpcion2 = new JPanel();
	final private JPanel jOpcion3 = new JPanel();
	final private JPanel jOpcion4 = new JPanel();
	final private JPanel jOpcion5 = new JPanel();

	private JLabel packazon;

	public ProductPanel() {
		createPic();
		setLayoutManager();
		setLocationAndSize();
		addComponents();
		addActionEvent();
	}

	private void createPic() {
		packazon = Ventana.createPic();
	}

	private void setLayoutManager() {
		setLayout(new GridLayout(12, 1, 0, 10));
	}

	private void setLocationAndSize() {
		spinn.setPreferredSize(new Dimension(40,25));
		spinn_weight.setPreferredSize(new Dimension(40,25));
		spinn_volum.setPreferredSize(new Dimension(40,25));
		weight.setBorder(new EmptyBorder(0,15,0,0));
		volumen.setBorder(new EmptyBorder(0,15,0,0));
		asegu.setBorder(new EmptyBorder(0, 10, 0, 0));
		asegurado.setVisible(false);
		opcion1.setSelected(true);
	}

	private void addComponents() {
		/**Descripción */
		desc.add(descripcion);
		desc.add(description);
		desc.add(clear_description);		

		/**Tipos de producto */
		grupo.add(opcion1);
		grupo.add(opcion2);
		grupo.add(opcion3);
		grupo.add(opcion4);
		grupo.add(opcion5);
		grupo.add(opcion6);
		
		/**Unidades, peso, volumen */
		spinnerPanel.add(units);
		spinnerPanel.add(spinn);
		spinnerPanel.add(weight);
		spinnerPanel.add(spinn_weight);
		spinnerPanel.add(volumen);
		spinnerPanel.add(spinn_volum);
		spinnGrid.add(spinnerPanel);
		buttonPanel.add(boton);

		/**fragil */
		fragil.add(opcion6);
		fragil.add(asegu);
		fragil.add(asegurado);

		/**Panel grande y contendor */
		jOpcion1.add(opcion1);
		jOpcion2.add(opcion2);
		jOpcion3.add(opcion3);
		jOpcion4.add(opcion4);
		jOpcion5.add(opcion5);

		this.add(packazon);
		this.add(desc);
		this.add(jOpcion1);
		this.add(jOpcion2);
		this.add(jOpcion3);
		this.add(jOpcion4);
		this.add(jOpcion5);
		this.add(fragil);
		this.add(spinnGrid);
		this.add(buttonPanel);
		// añadir componentes al contenedor
	}

	private void addActionEvent() {
		opcion1.addActionListener(event -> hideAsegurado());
		opcion2.addActionListener(event -> hideAsegurado());
		opcion3.addActionListener(event -> hideAsegurado());
		opcion4.addActionListener(event -> hideAsegurado());
		opcion5.addActionListener(event -> hideAsegurado());
		opcion6.addActionListener(event -> showAsegurado());
		clear_description.addActionListener(event -> clearDescription());
	}

	private void hideAsegurado() {
		asegurado.setVisible(false);
	}

	private void showAsegurado() {
		asegurado.setVisible(true);
	}

	private void clearDescription() {
		description.setText("");
	}

	public void setControlador(ActionListener c) {  
		boton.addActionListener(c);
	}

	public JButton getBotonAddProduct() {
		return this.boton;
	}

	public JRadioButton getOpcion1() {
		return this.opcion1;
	}

	public JRadioButton getOpcion2() {
		return this.opcion2;
	}

	public JRadioButton getOpcion3() {
		return this.opcion3;
	}

	public JRadioButton getOpcion4() {
		return this.opcion4;
	}

	public JRadioButton getOpcion5() {
		return this.opcion5;
	}

	public JRadioButton getOpcion6() {
		return this.opcion6;
	}

	public JCheckBox getAsegurado() {
		return this.asegurado;
	}

	public JTextField getDescription() {
		return this.description;
	}

	public JSpinner getUnidades() {
		return this.spinn;
	}

	public JSpinner getPeso() {
		return this.spinn_weight;
	}

	public JSpinner getVolumen() {
		return this.spinn_volum;
	}
}
