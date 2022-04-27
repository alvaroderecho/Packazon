package Interfaces.Main;

import java.awt.EventQueue;
import Interfaces.Controladores.*;
import Interfaces.vistas.*;

public class Main {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {						
					Ventana frame = new Ventana();
					Controlador controlador = new Controlador(frame);
					frame.setControlador(controlador);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}