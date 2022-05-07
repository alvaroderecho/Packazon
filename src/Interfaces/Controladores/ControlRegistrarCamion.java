package Interfaces.Controladores;

import java.awt.event.*;
import Interfaces.vistas.*;
import Reparto.TipoCamion;
import Usuarios.Operario;


public class ControlRegistrarCamion implements ActionListener{
    private RegistrarCamionPanel vista;
	private Ventana frame;

    public ControlRegistrarCamion(Ventana frame) {
		this.frame = frame;
		this.vista = frame.getGetVistaRegistrarCamionPanel();
	}

    @Override
	public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getBackButton()) {
            this.frame.mostrarPanel("consultarCamionesPanel"); 
        } else if (e.getSource() == vista.getRegisterButton()) {
            if (Operario.getCamionByPlate(vista.getMatricula()) == null) {
                Operario.registrar_camion(vista.getMatricula(), (int)vista.getMaxPeso().getValue(), TipoCamion.getValor(vista.getTipoCamion()));
            }
            this.frame.getGetVistaConsultarCamionesPanel().check();
            this.frame.mostrarPanel("consultarCamionesPanel"); 
        }
    }
}
