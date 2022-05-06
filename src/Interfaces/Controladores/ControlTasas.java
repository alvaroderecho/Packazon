package Interfaces.Controladores;

import java.awt.event.*;
import Interfaces.vistas.*;
import Usuarios.*;


public class ControlTasas implements ActionListener{
    private TasasPanel vista;
	private Ventana frame;

    public ControlTasas(Ventana frame) {
		this.frame = frame;
		this.vista = frame.getGetVistaTasasPanel();
	}

    @Override
	public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getBackButton()) {
            Operario.modificar_max_codpost((int)vista.getMaxCodP().getValue());
            Operario.modificar_max_entregas_fallidas((int)vista.getMaxEF().getValue());

            Operario.modificar_max_volumen_prod((double)vista.getMaxVolum().getValue());
            Operario.modificar_descuento((double)vista.getDiscount().getValue());
            
            Operario.modificar_tasa_alim((double)vista.getTasaAlim().getValue());
            Operario.modificar_tasa_frag((double)vista.getTasaFrag().getValue());
            Operario.modificar_tasa_aseg((double)vista.getTasaAseg().getValue());
            this.frame.mostrarPanel("operarioPanel"); 
        }
    }
}
