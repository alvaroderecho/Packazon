package Interfaces.vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegistrarRepartidorPanel extends JPanel{
    
    final private JButton resetButton = new JButton("CLEAR");
    final private JButton register = new JButton("Registrar");
    final private JPanel registerPanel = new JPanel();
    final private JLabel userLabel = new JLabel("Username");
    final private JLabel passwordLabel = new JLabel("Contraseña");
    final private JTextField userTextField = new JTextField(9);
    final private JPasswordField passwordField = new JPasswordField(9);
    final private JCheckBox showPassword = new JCheckBox("✓");

    final private JLabel numTelef = new JLabel("Número de Teléfono");
    final private JTextField numTelefCampo = new JTextField("6XXYYYZZZ", 9);
    final private JButton botonVolver = new JButton("Volver");

    final JPanel userPanel = new JPanel();
    final JPanel numTPanel = new JPanel();


	private JLabel packazon;

    RegistrarRepartidorPanel() {
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

        /**Usuario */
            /**usuario */
            userPanel.add(userLabel);
            userPanel.add(userTextField);
            /**contraseña */
            userPanel.add(passwordLabel);
            userPanel.add(passwordField);
            userPanel.add(showPassword);
        this.add(userPanel);
        numTPanel.add(numTelef);
        numTPanel.add(numTelefCampo);
        this.add(numTPanel);
        /**Botón de registrarse */
        registerPanel.add(resetButton);
        registerPanel.add(register);
        registerPanel.add(botonVolver);
        this.add(registerPanel);
    }

    public void addActionEvent() {
        showPassword.addActionListener(event -> showPasswordFunction());
        resetButton.addActionListener(event -> clearButton());
    }

    public void clearButton() {
        userTextField.setText("");
        passwordField.setText("");
        numTelefCampo.setText("");
    }

    public void showPasswordFunction() {
        if (showPassword.isSelected()) {
            passwordField.setEchoChar((char) 0);
        } else {
            passwordField.setEchoChar('*');
        }
    }

    public void setControlador(ActionListener c) {  
		register.addActionListener(c);
        botonVolver.addActionListener(c);
	}
 
    public JButton getRegisterButton() {
        return this.register;
    }

    /**GETTERS */
    public String getUser() {
        return userTextField.getText();
    }

    public String getPassword() {
        return new String(passwordField.getPassword());
    }

    public String getTelef() {
        return numTelefCampo.getText();
    }

    public JButton getBackButton() {
        return botonVolver;
    }

    public void reset() {
        userTextField.setText("");
        passwordField.setText("");
        numTelefCampo.setText("6XXYYYZZZ");
    }
}
