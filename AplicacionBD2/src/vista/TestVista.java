package vista;

import javax.swing.JFrame;

import java.awt.BorderLayout;

public class TestVista extends JFrame {
	
	private static final long serialVersionUID = -5245463097414240758L;
	
	
	public TestVista() {
	
		setVisible(true);			
		PanelProteinas panel = new PanelProteinas();
		getContentPane().add(panel, BorderLayout.CENTER);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600,400);
		setLocationRelativeTo(null);
		
	}

	public static void main(String[] args) {
		
		new TestVista();
		
	}
}
