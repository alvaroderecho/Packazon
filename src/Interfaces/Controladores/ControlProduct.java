package Interfaces.Controladores;

import java.awt.event.*;
import Interfaces.vistas.*;
import Productos.*;
import javax.swing.*;


public class ControlProduct implements ActionListener {
    private ProductPanel vista;
    private Ventana frame;

    public ControlProduct(Ventana frame) {
        this.frame = frame;
        this.vista = frame.getGetVistaProductPanel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getBotonAddProduct()) {
            Boolean asegu = vista.getAsegurado().isSelected();
            String salida = "Producto ";
            TipoProducto tp = TipoProducto.ESTANDAR;

            if (vista.getOpcion1().isSelected()) {
                salida += vista.getOpcion1().getText();
                tp = TipoProducto.ESTANDAR;
            }
            if (vista.getOpcion2().isSelected()) {
                salida += vista.getOpcion2().getText();
                tp = TipoProducto.FRAGIL;
            }
            if (vista.getOpcion3().isSelected()) {
                salida += vista.getOpcion3().getText();
                tp = TipoProducto.ALIMENTARIO;
            }
            if (vista.getOpcion4().isSelected()) {
                salida += vista.getOpcion4().getText();
                tp = TipoProducto.REFRIGERADO;
            }
            if (vista.getOpcion5().isSelected()) {
                salida += vista.getOpcion5().getText();
                tp = TipoProducto.CONGELADO;
            }
            if (vista.getOpcion6().isSelected()) {
                salida += vista.getOpcion6().getText();
                if (asegu)
                    salida += " asegurado";
                tp = TipoProducto.LIQUIDO;
            }
            Producto p = Pedido.createProducto((int) vista.getUnidades().getValue(), (double) vista.getPeso().getValue(), 1,
                    asegu, vista.getDescription().getText(), (double) vista.getVolumen().getValue(), tp);
            JOptionPane.showMessageDialog(vista, p.toString() + salida);
            frame.mostrarPanel("pedidoPanel");
        }
    }
}
