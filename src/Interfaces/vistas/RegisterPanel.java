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
    final private JTextField tarjetaCampo = new JTextField("XXXX-YYYY-ZZZZ-WWWW", 12);


    final JPanel userPanel = new JPanel();
    final JPanel passPanelValidar = new JPanel();

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
		setLayout(new GridLayout(7, 1, 0, 0));
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
        /**Botón de registrarse */
        registerPanel.add(resetButton);
        registerPanel.add(register);
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
	}
 
    public JButton getRegisterButton() {
        return this.register;
    }

    
}
