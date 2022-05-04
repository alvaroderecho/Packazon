package Interfaces.vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.swing.JPanel;
import javax.imageio.ImageIO;

public class OperarioPanel extends JPanel{
    JLabel packazon;
    JLabel operario;

    final JPanel packTitle = new JPanel();
    final JPanel operarioTitle = new JPanel();
    final private JButton botonPedido = new JButton("Dar de alta un pedido");
    final private JButton botonReparto = new JButton("Plan de reparto");
    final private JButton botonRepartidores = new JButton("Consultar Repartidores");
    final private JButton botonCamiones = new JButton("Consultar Camiones");
    final private JButton botonTasas = new JButton("Modificar tasas y máximos");
    final private JButton botonEstadisticas = new JButton("Consultar Estadísticas");

    final JPanel fila1 = new JPanel();
    final JPanel fila2 = new JPanel();
    final JPanel fila3 = new JPanel();

    final private JButton botonVolver = new JButton("Volver");  /*Mismo eventListener en todos los q vuelvan */
    final JPanel panelBtnVolver = new JPanel();

    public OperarioPanel() {
        createPic();
        setLayoutManager();
        setLocationAndSize();
        addComponents();
    }

    public void createPic() {
        try {
            packazon = Ventana.createPic();
            operario = new JLabel(new ImageIcon(ImageIO.read(new File("src/Interfaces/figuras/Operario.png"))));

        }catch(IOException i) {
            i.printStackTrace();
        }
    }

    private void setLayoutManager() {
		setLayout(new GridLayout(6, 1, 0, 0));
	}

    private void setLocationAndSize() {
        packazon.setPreferredSize(new Dimension(150,30));
        operario.setPreferredSize(new Dimension(150,40));
        
    }

    private void addComponents() {
        packTitle.add(packazon);
        operarioTitle.add(operario);
        /**botones */
        fila1.add(botonPedido);
        fila1.add(botonReparto);
        fila2.add(botonRepartidores);
        fila2.add(botonCamiones);
        fila3.add(botonTasas);
        fila3.add(botonEstadisticas);

        panelBtnVolver.add(botonVolver);

        /**Añadimos paneles */
        this.add(packTitle);
        this.add(operarioTitle);
        this.add(fila1);
        this.add(fila2);
        this.add(fila3);
        this.add(panelBtnVolver);

    }

    public void setControlador(ActionListener c) {  
		botonVolver.addActionListener(c);
        botonPedido.addActionListener(c);
        botonCamiones.addActionListener(c);
        botonEstadisticas.addActionListener(c);
        botonRepartidores.addActionListener(c);
        botonReparto.addActionListener(c);
        botonTasas.addActionListener(c);
	}

    public JButton getBackButton() {
        return botonVolver;
    }

    public JButton getAddPedidoButton() {
        return botonPedido;
    }

    public JButton getTasasButton() {
        return botonTasas;
    }

    public JButton getPlanReparto() {
        return botonReparto;
    }

    public JButton getCamiones() {
        return botonCamiones;
    }

    public JButton getRepartidores() {
        return botonRepartidores;
    }

    public JButton getEstadisticas() {
        return botonEstadisticas;
    }
}
