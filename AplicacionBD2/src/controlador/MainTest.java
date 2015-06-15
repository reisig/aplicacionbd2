package controlador;

import javax.swing.JFrame;
import javax.swing.JPanel;

import vista.PanelIngreso;

import java.awt.BorderLayout;

public class MainTest extends JFrame {
	
	private static final long serialVersionUID = -5245463097414240758L;
	
	
	public MainTest() {
		
		
		setLocationRelativeTo(null);
		setVisible(true);
		JPanel panel = new PanelIngreso();
		getContentPane().add(panel, BorderLayout.CENTER);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		
		MainTest nuevo =  new MainTest();
		
	}
}
