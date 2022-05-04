package Interfaces.Controladores;

import java.awt.event.*;
import Interfaces.vistas.*;
import Usuarios.VariablesGlobales;


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
            VariablesGlobales.set_max_cod_post((int)vista.getMaxCodP().getValue());
            VariablesGlobales.set_max_entregas_fallidas((int)vista.getMaxEF().getValue());

            VariablesGlobales.set_max_volumen_prod((double)vista.getMaxVolum().getValue());
            VariablesGlobales.set_descuento((double)vista.getDiscount().getValue());
            
            VariablesGlobales.set_tasa_alim((double)vista.getTasaAlim().getValue());
            VariablesGlobales.set_tasa_frag((double)vista.getTasaFrag().getValue());
            VariablesGlobales.set_tasa_aseg((double)vista.getTasaAseg().getValue());
            this.frame.mostrarPanel("operarioPanel"); 
        }
    }
}
