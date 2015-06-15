package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class PanelIngreso extends JPanel implements ActionListener{
	
	private static final long serialVersionUID = -5330361553046124052L;
	private JTextField tfUsuario;
	private JPasswordField pfContrasena;
	private JButton btnIngresar;

	public PanelIngreso() {
		
		setLayout(null);
		setVisible(true);
		
		JLabel titulo = new JLabel("Redis Connect");
		titulo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		titulo.setBounds(202, 55, 168, 33);
		add(titulo);
		
		JLabel lblUsuario = new JLabel("Usuario: ");
		lblUsuario.setBounds(118, 133, 67, 14);
		add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(96, 192, 89, 14);
		add(lblContrasea);
		
		tfUsuario = new JTextField();
		tfUsuario.setBounds(195, 130, 155, 20);
		add(tfUsuario);
		tfUsuario.setColumns(10);
		
		pfContrasena = new JPasswordField();
		pfContrasena.setBounds(195, 189, 155, 20);
		add(pfContrasena);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(this);
		btnIngresar.setBounds(229, 256, 89, 23);
		add(btnIngresar);
	}

	
	
	@SuppressWarnings("deprecation")
	private boolean comprobarCondiciones(){
		
		if (tfUsuario.getText().isEmpty()){
			
			JOptionPane.showMessageDialog(null,"Por favor ingrese usuario","Error" ,JOptionPane.ERROR_MESSAGE);	
			return false;
		}
			
		if (pfContrasena.getText().isEmpty()){
			
			JOptionPane.showMessageDialog(null,"Por favor ingrese contraseña","Error" ,JOptionPane.ERROR_MESSAGE);	
			return false;
		}
		
		return true;
		
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
		Object evento = e.getSource();
		
		
		if (evento == btnIngresar){
			
			if (comprobarCondiciones()){
				
				System.out.println("Tela");
			}
		}
		
	}
}
