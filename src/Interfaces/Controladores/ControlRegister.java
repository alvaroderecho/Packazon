package Interfaces.Controladores;

import java.awt.event.*;
import Interfaces.vistas.*;
import Sistema.Sistema;
import Usuarios.Cliente;
import javax.swing.*;

public class ControlRegister implements ActionListener {
    private RegisterPanel vista;
    private Ventana frame;

    public ControlRegister(Ventana frame) {
        this.frame = frame;
        this.vista = frame.getGetVistaRegisterPanel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getRegisterButton()) {
            String user = vista.getUser(), password = vista.getPassword(),
                    passwdValidado = vista.getPasswordValidated(), empresa = vista.getEmpresa();
            String CIF = vista.getCIF(), facturacion = vista.getFact(), email = vista.getEmail(),
                    numTarjeta = vista.getTarjeta();
            if (password.equals(passwdValidado) && !password.equals("")) {
                Sistema.addCliente(new Cliente(empresa, CIF, facturacion, email, numTarjeta, user, password));
                this.frame.getGetVistaLoginPanel().clearButton();
                this.frame.mostrarPanel("loginPanel");
            } else {
                JOptionPane.showMessageDialog(vista, "Ambas contraseñas han de coincidir y deber contener caracteres.");
            }
        } else if (e.getSource() == vista.getBackButton()) {
            this.frame.getGetVistaLoginPanel().clearButton();
            this.frame.mostrarPanel("loginPanel");
        }
    }
}
