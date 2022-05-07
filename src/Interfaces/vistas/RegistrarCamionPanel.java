package Interfaces.vistas;

import javax.swing.*;

import Reparto.TipoCamion;

import java.awt.*;
import java.awt.event.*;

public class RegistrarCamionPanel extends JPanel{
    
    final private JButton resetButton = new JButton("CLEAR");
    final private JButton register = new JButton("Registrar");
    final private JPanel registerPanel = new JPanel();

    final private JButton botonVolver = new JButton("Volver");
    final private JLabel matricula = new JLabel("Matrícula");
    final private JTextField matriculaCampo = new JTextField("0000XX", 7);
    final private JLabel maxPeso = new JLabel("Peso máximo:");      /**Maximos codigos postales */
	final private JSpinner maxPesoCampo = new JSpinner(new SpinnerNumberModel(1000,500,15000,50));

    final String[] tipoCamion = {"Estandar", "Especial", "Congelados", "Refrigerados"};
    final JLabel tipoCamionLabel = new JLabel("Seleccione el tipo de camión: ");
    final JComboBox<String> combo = new JComboBox<String>(tipoCamion);
    final JPanel tipoCamionPanel = new JPanel();

    final JPanel userPanel = new JPanel();
    final JPanel matriculaPanel = new JPanel();


	private JLabel packazon;

    RegistrarCamionPanel() {
        createPic();
        setLayoutManager();
        setLocationAndSize();
        addComponents();
        addActionEvent(); 
    }

    private void createPic() {
        packazon = Ventana.createPic();
    }

     
    public void setLayoutManager() {
		setLayout(new GridLayout(6, 1, 0, 0));
    }

    public void setLocationAndSize() {
    }

    public void addComponents() {
        this.add(packazon);
        matriculaPanel.add(matricula);
        matriculaPanel.add(matriculaCampo);
        matriculaPanel.add(maxPeso);
        matriculaPanel.add(maxPesoCampo);
        this.add(matriculaPanel);
        /**Tipocamion */
        tipoCamionPanel.add(tipoCamionLabel);
        tipoCamionPanel.add(combo);
        this.add(tipoCamionPanel);
        /**Botón de registrarse */
        registerPanel.add(resetButton);
        registerPanel.add(register);
        registerPanel.add(botonVolver);
        this.add(registerPanel);
    }

    public void addActionEvent() {
        resetButton.addActionListener(event -> clearButton());
    }

    public void clearButton() {

    }


    public void setControlador(ActionListener c) {  
		register.addActionListener(c);
        botonVolver.addActionListener(c);
	}
 
    public JButton getRegisterButton() {
        return this.register;
    }

    /**GETTERS */
    public String getMatricula() {
        return matriculaCampo.getText();
    }

    public JSpinner getMaxPeso() {
        return maxPesoCampo;
    }

    public JButton getBackButton() {
        return botonVolver;
    }

    public int getTipoCamion() {
        return combo.getSelectedIndex();
    }

    public void reset() {
        matriculaCampo.setText("0000XX");
        maxPesoCampo.setValue(1000);
        combo.setSelectedIndex(0);
    }
}
