package Interfaces.vistas;

import javax.swing.*;

import Usuarios.Cliente;

import java.awt.*;
import java.awt.event.*;

public class EditarPerfilPanel extends JPanel{
    
    final private JButton save = new JButton("Guardar Cambios");
    final private JPanel savePanel = new JPanel();
    final private JLabel userLabel = new JLabel("Username");
    final private JLabel passwordLabel = new JLabel("Contraseña");
    final private JTextField userTextField = new JTextField(9);
    final private JPasswordField passwordField = new JPasswordField(9);
    final private JCheckBox showPassword = new JCheckBox("✓");

    final private JLabel nombreEmpresa = new JLabel("Nombre de empresa");
    final private JTextField empresaCampo = new JTextField(12);
    final private JLabel CIF = new JLabel("CIF: ");
    final private JLabel CIFcampo = new JLabel();
    final private JLabel numTarjeta = new JLabel("Número de tarjeta");
    final private JTextField tarjetaCampo = new JTextField(15);
    final private JLabel dirrFact = new JLabel("Dirr de facturación");
    final private JTextField factCampo = new JTextField(12);
    final private JLabel email = new JLabel("Correo");
    final private JTextField emailCampo = new JTextField(18);
    final private JButton botonVolver = new JButton("Volver");

    final JPanel userPanel = new JPanel();
    final JPanel nombrePanel = new JPanel();
    final JPanel tarjetaPanel = new JPanel();
    final JPanel factPanel = new JPanel();
    final JPanel emailPanel = new JPanel();

    private Cliente capo;

    private JLabel packazon;

    EditarPerfilPanel() {
        createPic();
        setLayoutManager();
        setLocationAndSize();
        addComponents();
        addActionEvent();
 
    }

    public void setCiente(Cliente c) {
        capo = c;
        userTextField.setText(c.GetNombreUsuario());
        passwordField.setText(c.GetContrasenia());
        empresaCampo.setText(c.getNombreEmpresa());
        CIFcampo.setText(c.getCif());
        tarjetaCampo.setText(c.getNumTarjeta());
        factCampo.setText(c.getDirec_fact());
        emailCampo.setText(c.getEmail());
    }

    public Cliente getCliente() {
        return capo;
    }

    private void createPic() {
        packazon = Ventana.createPic();
    }

     
    public void setLayoutManager() {
		setLayout(new GridLayout(9, 1, 0, 0));
    }

    public void setLocationAndSize() {
        showPassword.setSelected(false);
    }

    public void addActionEvent() {
        showPassword.addActionListener(event -> showPasswordFunction());
    }

    public void showPasswordFunction() {
        if (showPassword.isSelected()) {
            passwordField.setEchoChar((char) 0);
        } else {
            passwordField.setEchoChar('*');
        }
    }

    public void setControlador(ActionListener c) {  
		save.addActionListener(c);
        botonVolver.addActionListener(c);
	}

    public void addComponents() {
        this.add(packazon);
        /**Usuario */
        userPanel.add(userLabel);
        userPanel.add(userTextField);
        /**contraseña */
        userPanel.add(passwordLabel);
        userPanel.add(passwordField);
        userPanel.add(showPassword);
        this.add(userPanel);

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

        savePanel.add(save);
        savePanel.add(botonVolver);
        this.add(savePanel);
    }

    public String getUser() {
        return userTextField.getText();
    }

    public String getPassword() {
        return new String(passwordField.getPassword());
    }

    public String getEmpresa() {
        return empresaCampo.getText();
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

    public JButton getSaveButton() {
        return save;
    }
}
