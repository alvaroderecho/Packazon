package Interfaces.vistas;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class ConsultarRepartidoresPanel extends JPanel{
    private JLabel packazon;
    final private JButton botonVolver = new JButton("Volver");  /*Mismo eventListener en todos los q vuelvan */
    final private JPanel panelBtnVolver = new JPanel();

    public ConsultarRepartidoresPanel() {
        createPic();
        setLayoutManager();
        setLocationAndSize();
        addComponents();

    }

    private void createPic() {
        packazon = Ventana.createPic();
    }

     
    public void setLayoutManager() {
		setLayout(new GridLayout(9, 1, 0, 0));
    }

    public void setLocationAndSize() {
    }

    public void addActionEvent() {
    }

    public void addComponents() {
        this.add(packazon);
        panelBtnVolver.add(botonVolver);
        this.add(panelBtnVolver);
    }

    public void setControlador(ActionListener c) {  
		botonVolver.addActionListener(c);
	}

    public JButton getBackButton() {
        return botonVolver;
    }
}
