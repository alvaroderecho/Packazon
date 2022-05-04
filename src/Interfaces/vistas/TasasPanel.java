package Interfaces.vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Sistema.Sistema;
import Usuarios.VariablesGlobales;

public class TasasPanel extends JPanel{
    JLabel packazon;
    final JPanel packTitle = new JPanel();
    final private JLabel maxCP = new JLabel("Max códigos post:");      /**Maximos codigos postales */
	final private JSpinner maxCpcampo = new JSpinner(new SpinnerNumberModel(VariablesGlobales.getMaxCodPost(),1,1000,1));
    final private JLabel maxEF = new JLabel("Max entregas fallidas:");      /**Maximas entregas fallidas */
    final private JSpinner maxEFCampo = new JSpinner(new SpinnerNumberModel(VariablesGlobales.getEntregasFallidas(),1,10,1));
    final private JLabel maxVolum = new JLabel("Max Volumen:");             /**Max volumen */
	final private JSpinner maxVolumenCampo = new JSpinner(new SpinnerNumberModel(VariablesGlobales.getMaxVolum(),0.1,50.0,0.1));
    final private JLabel discount = new JLabel("Descuento +100 prods");      /**Descuento +100pprods */
    final private JSpinner discountCampo = new JSpinner(new SpinnerNumberModel(VariablesGlobales.getDescuento(),0.0,1.0,0.1));
    final private JLabel tasaAlim = new JLabel("Tasa alimentarios:");      /**Tasa alim */
    final private JSpinner tasaAlimCampo = new JSpinner(new SpinnerNumberModel(VariablesGlobales.getTasaAlim(),0.0,50.0,0.1));
    final private JLabel tasaFrag = new JLabel("Tasa frágiles:");      /**Tasa frag */
    final private JSpinner tasaFragCampo = new JSpinner(new SpinnerNumberModel(VariablesGlobales.getTasaFrag(),0.0,50.0,0.1));
    final private JLabel tasaAsegu = new JLabel("Tasa asegurados:");      /**Tasa asegu */
    final private JSpinner tasaAseguCampo = new JSpinner(new SpinnerNumberModel(VariablesGlobales.getTasaAseg(),0.0,50.0,0.1));

    final private JPanel fila1 = new JPanel();
    final private JPanel fila2 = new JPanel();
    final private JPanel fila3 = new JPanel();
    final private JPanel fila4 = new JPanel();

    final private JButton botonVolver = new JButton("Volver");  /*Mismo eventListener en todos los q vuelvan */
    final JPanel panelBtnVolver = new JPanel();

    public TasasPanel() {
        createPic();
        setLayoutManager();
        setLocationAndSize();
        addComponents();
    }

    public void createPic() {
        packazon = Ventana.createPic();
    }

    private void setLayoutManager() {
		setLayout(new GridLayout(6, 1, 0, 0));
	}

    private void setLocationAndSize() {
        packazon.setPreferredSize(new Dimension(150,30));
        discountCampo.setPreferredSize(new Dimension(40,25));
        maxEF.setBorder(new EmptyBorder(0,10,0,0));
        discount.setBorder(new EmptyBorder(0,10,0,0));
        tasaFrag.setBorder(new EmptyBorder(0,10,0,0));

    }

    private void addComponents() {
        packTitle.add(packazon);
        panelBtnVolver.add(botonVolver);
        this.add(packTitle);

        fila1.add(maxCP);
        fila1.add(maxCpcampo);
        fila1.add(maxEF);
        fila1.add(maxEFCampo);
        this.add(fila1);

        fila2.add(maxVolum);
        fila2.add(maxVolumenCampo);
        fila2.add(discount);
        fila2.add(discountCampo);
        this.add(fila2);

        fila3.add(tasaAlim);
        fila3.add(tasaAlimCampo);
        fila3.add(tasaFrag);
        fila3.add(tasaFragCampo);
        this.add(fila3);

        fila4.add(tasaAsegu);
        fila4.add(tasaAseguCampo);
        this.add(fila4);
        this.add(panelBtnVolver);
    }

    public void setControlador(ActionListener c) {  
		botonVolver.addActionListener(c);
	}

    public JButton getBackButton() {
        return botonVolver;
    }

    public JSpinner getMaxCodP() {
        return maxCpcampo;
    }

    public JSpinner getMaxEF() {
        return maxEFCampo;
    }

    public JSpinner getMaxVolum() {
        return maxVolumenCampo;
    }

    public JSpinner getDiscount() {
        return discountCampo;
    }

    public JSpinner getTasaAlim() {
        return tasaAlimCampo;
    }

    public JSpinner getTasaFrag() {
        return tasaFragCampo;
    }

    public JSpinner getTasaAseg() {
        return tasaAseguCampo;
    }
}
