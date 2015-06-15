package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class PanelIngreso extends JPanel implements ActionListener{
	public PanelIngreso() {
		
		setLayout(null);
		setVisible(true);
		
		JLabel titulo = new JLabel("Redis Connect");
		titulo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		titulo.setBounds(190, 54, 168, 33);
		add(titulo);
		
		JLabel lblUsuario = new JLabel("Usuario: ");
		lblUsuario.setBounds(83, 155, 46, 14);
		add(lblUsuario);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
