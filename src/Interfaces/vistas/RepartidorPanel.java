package Interfaces.vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.swing.JPanel;
import javax.imageio.ImageIO;

public class RepartidorPanel extends JPanel{
    private JLabel packazon;
	private JLabel repartidor;
    final private JPanel packTitle = new JPanel();
    final private JPanel repartidorTitle = new JPanel();
    final private JButton botonReparto = new JButton("Consultar plan de reparto");
    final private JPanel panelBtnReparto = new JPanel();
    final private JButton botonPaquetes = new JButton("Estado de los paquetes");
    final private JPanel panelBtnPaquetes = new JPanel();
    final private JButton botonVolver = new JButton("Volver");  /*Mismo eventListener en todos los q vuelvan */
    final private JPanel panelBtnVolver = new JPanel();




    public RepartidorPanel() {
        createPic();
        setLayoutManager();
        setLocationAndSize();
        addComponents();

    }


    public void createPic() {
        try {
            packazon = Ventana.createPic();
            repartidor = new JLabel(new ImageIcon(ImageIO.read(new File("src/Interfaces/figuras/Repartidor.png"))));

        }catch(IOException i) {
            i.printStackTrace();
        }
    }

    private void setLayoutManager() {
		setLayout(new GridLayout(7, 1, 0, 0));
	}

    private void setLocationAndSize() {
        packazon.setPreferredSize(new Dimension(150,30));
        repartidor.setPreferredSize(new Dimension(150,40));
    }


    private void addComponents() {
        packTitle.add(packazon);
        repartidorTitle.add(repartidor);
        panelBtnReparto.add(botonReparto);
        panelBtnPaquetes.add(botonPaquetes);
        panelBtnVolver.add(botonVolver);
        this.add(packTitle);
        this.add(repartidorTitle);
        this.add(panelBtnReparto);
        this.add(panelBtnPaquetes);
        this.add(panelBtnVolver);

    }

    public void setControlador(ActionListener c) {  
		botonVolver.addActionListener(c);
	}

    public JButton getBackButton() {
        return botonVolver;
    }
}
