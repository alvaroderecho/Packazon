package Interfaces.vistas;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Login {
    public static void main(String[] a) {
        LoginPanel pan = new LoginPanel();
        JFrame jf = new JFrame();
        jf.add(pan);
        jf.setTitle("Packazon");
        jf.setVisible(true);
        jf.setSize(475, 500);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Pantalla completa

    }
}
