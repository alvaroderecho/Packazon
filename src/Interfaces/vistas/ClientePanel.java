package Interfaces.vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.swing.JPanel;
import javax.imageio.ImageIO;


public class ClientePanel extends JPanel{
	JLabel packazon;
	JLabel cliente;
    final JPanel packTitle = new JPanel();
    final JPanel clienteTitle = new JPanel();
    final private JButton botonPedidos = new JButton("Ver estado de mis pedidos");
    final JPanel panelBtnPedidos = new JPanel();
    final private JButton botonPerfil = new JButton("Editar mi perfil");
    final JPanel panelBtnPerfil = new JPanel();
    final private JButton botonVolver = new JButton("Volver");  /*Mismo eventListener en todos los q vuelvan */
    final JPanel panelBtnVolver = new JPanel();

    public ClientePanel() {
        createPic();
        setLayoutManager();
        setLocationAndSize();
        addComponents();

    }
    
    public void createPic() {
        try {
            packazon = Ventana.createPic();
            cliente = new JLabel(new ImageIcon(ImageIO.read(new File("src/Interfaces/figuras/Cliente.png"))));

        }catch(IOException i) {
            i.printStackTrace();
        }
    }

    private void setLayoutManager() {
		setLayout(new GridLayout(7, 1, 0, 0));
	}

    private void setLocationAndSize() {
        packazon.setPreferredSize(new Dimension(150,30));
        cliente.setPreferredSize(new Dimension(150,40));
    }

    private void addComponents() {
        packTitle.add(packazon);
        clienteTitle.add(cliente);
        panelBtnPerfil.add(botonPerfil);
        panelBtnPedidos.add(botonPedidos);
        panelBtnVolver.add(botonVolver);
        this.add(packTitle);
        this.add(clienteTitle);
        this.add(panelBtnPerfil);
        this.add(panelBtnPedidos);
        this.add(panelBtnVolver);
    }

    public void setControlador(ActionListener c) {  
		botonVolver.addActionListener(c);
	}

    public JButton getBackButton() {
        return botonVolver;
    }
 
}
