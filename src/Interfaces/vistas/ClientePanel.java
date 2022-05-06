package Interfaces.vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.jar.JarEntry;

import javax.swing.JPanel;
import javax.imageio.ImageIO;
import Usuarios.Cliente;

public class ClientePanel extends JPanel{
	private JLabel packazon;
	private JLabel cliente;
    final private JPanel packTitle = new JPanel();
    final private JPanel clienteTitle = new JPanel();
    private JLabel nombreCliente = new JLabel();
    private JPanel nombrPanel = new JPanel();
    final private JButton botonPedidos = new JButton("Ver estado de mis pedidos");
    final private JPanel panelBtnPedidos = new JPanel();
    final private JButton botonPerfil = new JButton("Editar mi perfil");
    final private JPanel panelBtnPerfil = new JPanel();
    final private JButton botonVolver = new JButton("Volver");  /*Mismo eventListener en todos los q vuelvan */
    final private JPanel panelBtnVolver = new JPanel();

    Cliente capo;

    public ClientePanel() {
        createPic();
        setLayoutManager();
        setLocationAndSize();
        addComponents();

    }

    public void setCliente(Cliente c) {
        capo = c;
        nombreCliente.setText("Nombre: " + c.getNombreEmpresa());
    }

    public Cliente getCliente() {
        return capo;
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
        nombrPanel.add(nombreCliente);
        panelBtnPerfil.add(botonPerfil);
        panelBtnPedidos.add(botonPedidos);
        panelBtnVolver.add(botonVolver);
        this.add(packTitle);
        this.add(clienteTitle);
        this.add(nombrPanel);
        this.add(panelBtnPerfil);
        this.add(panelBtnPedidos);
        this.add(panelBtnVolver);
    }

    public void setControlador(ActionListener c) {  
		botonVolver.addActionListener(c);
        botonPedidos.addActionListener(c);
        botonPerfil.addActionListener(c);
	}

    public JButton getBackButton() {
        return botonVolver;
    }

    public JButton getPedidosButton() {
        return botonPedidos;
    }

    public JButton getPerfilButton() {
        return botonPerfil;
    }
 
}
