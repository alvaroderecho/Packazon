package Interfaces.Controladores;

import java.awt.event.*;
import Interfaces.vistas.*;
import Sistema.Sistema;
import Usuarios.Cliente;

public class ControlEditarPerfil implements ActionListener {
    private EditarPerfilPanel vista;
    private Ventana frame;

    public ControlEditarPerfil(Ventana frame) {
        this.frame = frame;
        this.vista = frame.getGetVistEditarPerfilPanel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getSaveButton()) {
            String user = vista.getUser(), password = vista.getPassword(),
                    empresa = vista.getEmpresa(), facturacion = vista.getFact(), email = vista.getEmail(),
                    numTarjeta = vista.getTarjeta(), cif = vista.getCliente().getCif();
            
            Sistema.modifyClient(vista.getCliente(), empresa, facturacion, email, numTarjeta, user, password);
            Cliente ccif = Sistema.getClientByCIF(cif);
            if (ccif != null) this.frame.getGetVistaClientePanel().setCliente(ccif);
            this.frame.mostrarPanel("clientePanel");
        } else if (e.getSource() == vista.getBackButton()) {
            this.frame.mostrarPanel("clientePanel");
        }
    }
}
