package Interfaces.vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;

public class RegisterPanel extends JPanel{
    
    final private JButton resetButton = new JButton("CLEAR");
    final private JButton register = new JButton("Registrarse");
    final private JPanel registerPanel = new JPanel();
    final private JLabel userLabel = new JLabel("Username");
    final private JLabel passwordLabel = new JLabel("Contraseña");
    final private JTextField userTextField = new JTextField(9);
    final private JPasswordField passwordField = new JPasswordField(9);
    final private JCheckBox showPassword = new JCheckBox("✓");

    final private JLabel passwordLabelValidar = new JLabel("Validar Contraseña");
    final private JPasswordField passwordFieldValidar = new JPasswordField(9);
    final private JCheckBox showPasswordValida = new JCheckBox("✓");

    final private JLabel nombreEmpresa = new JLabel("Nombre de empresa");
    final private JTextField empresaCampo = new JTextField("Packazon", 10);
    final private JLabel CIF = new JLabel("CIF");
    final private JTextField CIFcampo = new JTextField("XXXYYYZZZA", 8);
    final private JLabel numTarjeta = new JLabel("Número de tarjeta");
    final private JTextField tarjetaCampo = new JTextField("XXXX-YYYY-ZZZZ-WWWW", 15);
    final private JLabel dirrFact = new JLabel("Dirr de facturación");
    final private JTextField factCampo = new JTextField("Av de la Sierra", 12);
    final private JLabel email = new JLabel("Correo");
    final private JTextField emailCampo = new JTextField("packazon@gmail.com", 18);
    final private JButton botonVolver = new JButton("Volver");

    final JPanel userPanel = new JPanel();
    final JPanel passPanelValidar = new JPanel();
    final JPanel nombrePanel = new JPanel();
    final JPanel tarjetaPanel = new JPanel();
    final JPanel factPanel = new JPanel();
    final JPanel emailPanel = new JPanel();


	private JLabel packazon;

    RegisterPanel() {
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
		setLayout(new GridLayout(9, 1, 0, 0));
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
            /**validar contraseña */
            passPanelValidar.add(passwordLabelValidar);
            passPanelValidar.add(passwordFieldValidar);
            passPanelValidar.add(showPasswordValida);
        this.add(userPanel);
        this.add(passPanelValidar);
        /**nombre de empresa */
        nombrePanel.add(nombreEmpresa);
        nombrePanel.add(empresaCampo);
        /**CIF */
        nombrePanel.add(CIF);
        nombrePanel.add(CIFcampo);
        this.add(nombrePanel);
        /**Dirección de Facturación */
        factPanel.add(dirrFact);
        factPanel.add(factCampo);
        this.add(factPanel);
        /**email */
        emailPanel.add(email);
        emailPanel.add(emailCampo);
        this.add(emailPanel);
        /**num tarjeta */
        tarjetaPanel.add(numTarjeta);
        tarjetaPanel.add(tarjetaCampo);
        this.add(tarjetaPanel);
       
        /**Botón de registrarse */
        registerPanel.add(resetButton);
        registerPanel.add(register);
        registerPanel.add(botonVolver);
        this.add(registerPanel);
    }

    public void addActionEvent() {
        showPassword.addActionListener(event -> showPasswordFunction());
        showPasswordValida.addActionListener(event -> showPasswordValidarFunction());
        resetButton.addActionListener(event -> clearButton());
    }

    public void clearButton() {
        userTextField.setText("");
        passwordField.setText("");
        passwordFieldValidar.setText("");
    }

    public void showPasswordFunction() {
        if (showPassword.isSelected()) {
            passwordField.setEchoChar((char) 0);
        } else {
            passwordField.setEchoChar('*');
        }
    }

    public void showPasswordValidarFunction() {
        if (showPasswordValida.isSelected()) {
            passwordFieldValidar.setEchoChar((char) 0);
        } else {
            passwordFieldValidar.setEchoChar('*');
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

    public String getPasswordValidated() {
        return new String(passwordFieldValidar.getPassword());
    }

    public String getEmpresa() {
        return empresaCampo.getText();
    }

    public String getCIF() {
        return CIFcampo.getText();
    }

    public String getFact() {
        return factCampo.getText();
    }

    public String getEmail() {
        return emailCampo.getText();
    }

    public String getTarjeta() {
        return tarjetaCampo.getText();
    }

    public JButton getBackButton() {
        return botonVolver;
    }
}
