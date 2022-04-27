package Interfaces.vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.border.EmptyBorder;
 
public class LoginPanel extends JPanel{
 
    final JLabel userLabel = new JLabel("Username");
    final JLabel passwordLabel = new JLabel("Contraseña");
    final JTextField userTextField = new JTextField();
    final JPasswordField passwordField = new JPasswordField();
    final JButton loginButton = new JButton("LOGIN");
    final JButton resetButton = new JButton("CLEAR");
    final JCheckBox showPassword = new JCheckBox("Mostrar");
    final private JButton botonRegister = new JButton("Registrarse");  /*Mismo eventListener en todos los q vuelvan */

    final JPanel userPanel = new JPanel();
    final JPanel passPanel = new JPanel();
    final JPanel logPanel = new JPanel();
    final JPanel panelBtnRegister = new JPanel();

    final String[] cuenta = {"Cliente", "Repartidor", "Operario"};
    final JLabel cuentaLabel = new JLabel("Selecciona tu tipo de cuenta: ");
    final JComboBox<String> combo = new JComboBox<String>(cuenta);
    final JPanel cuentaPanel = new JPanel();

	JLabel packazon;
 
 
    LoginPanel() {
        createPic();
        setLayoutManager();
        setLocationAndSize();
        addComponents();
        addActionEvent();
 
    }

    public void createPic() {
        packazon = Ventana.createPic();
    }
 
    public void setLayoutManager() {
		setLayout(new GridLayout(7, 1, 0, 0));
    }
 
    public void setLocationAndSize() {
        packazon.setPreferredSize(new Dimension(150, 30));
        userLabel.setPreferredSize(new Dimension(100, 30));
        passwordLabel.setPreferredSize(new Dimension(100, 30));
        userTextField.setPreferredSize(new Dimension(150, 30));
        passwordField.setPreferredSize(new Dimension(150, 30));
        showPassword.setPreferredSize(new Dimension(150, 30));
        loginButton.setPreferredSize(new Dimension(100, 30));
        resetButton.setPreferredSize(new Dimension(100, 30));
        userPanel.setBorder(new EmptyBorder(0, 0, 0, 95));
        passPanel.setBorder(new EmptyBorder(0, 57, 0, 0));
        combo.setSelectedIndex(1);
    }
 
    public void addComponents() {
        /**usuario */
        userPanel.add(userLabel);
        userPanel.add(userTextField);
        /**contraseña */
        passPanel.add(passwordLabel);
        passPanel.add(passwordField);
        passPanel.add(showPassword);

        /**Tipo de cuenta */
        cuentaPanel.add(cuentaLabel);
        cuentaPanel.add(combo);

        /**botones */
        logPanel.add(loginButton);
        logPanel.add(resetButton);
        panelBtnRegister.add(botonRegister);

        this.add(packazon);
        this.add(userPanel);
        this.add(passPanel);
        this.add(cuentaPanel);
        this.add(logPanel);
        this.add(panelBtnRegister);
    }
 
    public void addActionEvent() {
        resetButton.addActionListener(event -> clearButton());
        showPassword.addActionListener(event -> showPasswordFunction());
    }

    public void clearButton() {
        userTextField.setText("");
        passwordField.setText("");
    }

    public void showPasswordFunction() {
        if (showPassword.isSelected()) {
            passwordField.setEchoChar((char) 0);
        } else {
            passwordField.setEchoChar('*');
        }
    }
 
	public void setControlador(ActionListener c) {  
		loginButton.addActionListener(c);
	}

    public String getTipoCuenta() {
        return (String)combo.getSelectedItem();
    }

    public String getUser() {
        return userTextField.getText();
    }

    public String getPassword() {
        return new String(passwordField.getPassword());
    }
}
