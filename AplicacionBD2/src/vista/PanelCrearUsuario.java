package vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modelo.Usuario;
import controlador.Conector;

public class PanelCrearUsuario extends JPanel implements ActionListener {

	private static final long serialVersionUID = -4934762090157895495L;
	private JTextField tfUsuario;
	private JTextField tfConfirmar;
	private JTextField tfContrasena;
	private JButton btnIngresar;

	public PanelCrearUsuario(){
		
		setLayout(null);
		setVisible(true);
		
		JLabel titulo = new JLabel("Crear/Editar  Usuario");
		titulo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		titulo.setBounds(136, 38, 245, 33);
		add(titulo);
		
		JLabel lblUsuario = new JLabel("Usuario: ");
		lblUsuario.setBounds(125, 115, 67, 14);
		add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(103, 174, 89, 14);
		add(lblContrasea);
		
		tfUsuario = new JTextField();
		tfUsuario.setBounds(197, 112, 155, 20);
		add(tfUsuario);
		tfUsuario.setColumns(10);
		
		btnIngresar = new JButton("Guardar");
		btnIngresar.addActionListener(this);
		btnIngresar.setBounds(228, 292, 89, 23);
		add(btnIngresar);
		
		JLabel lblConfirmarContasea = new JLabel("Confirmar contase\u00F1a:");
		lblConfirmarContasea.setBounds(57, 231, 130, 14);
		add(lblConfirmarContasea);
		
		tfConfirmar = new JTextField();
		tfConfirmar.setBounds(197, 228, 155, 20);
		add(tfConfirmar);
		tfConfirmar.setColumns(10);
		
		tfContrasena = new JTextField();
		tfContrasena.setBounds(197, 171, 155, 20);
		add(tfContrasena);
		tfContrasena.setColumns(10);
	}
	
	
	private boolean comprobarCondiciones(){
		
		if (tfUsuario.getText().isEmpty()){
			
			JOptionPane.showMessageDialog(null,"Por favor ingrese usuario","Error" ,JOptionPane.ERROR_MESSAGE);	
			return false;
		}
			
		if (tfContrasena.getText().isEmpty()){
			
			JOptionPane.showMessageDialog(null,"Por favor ingrese contraseña","Error" ,JOptionPane.ERROR_MESSAGE);	
			return false;
		}
		
		if (tfConfirmar.getText().isEmpty()){
			
			JOptionPane.showMessageDialog(null,"Por favor confirme contraseña","Error" ,JOptionPane.ERROR_MESSAGE);	
			return false;
		}
		
		
		if ( ! (tfContrasena.getText().equals(tfConfirmar.getText())) ){
			
			JOptionPane.showMessageDialog(null,"Las contraseñas no coinciden","Error" ,JOptionPane.ERROR_MESSAGE);	
			return false;
		}
		
		return true;
		
	}
	
	
	public void crearUsuario(){
		
		
		Conector jedis = new Conector();
		Usuario nuevo = new Usuario(tfUsuario.getText(),tfContrasena.getText());
		
		jedis.conectar();
		System.out.println(jedis.set(nuevo.getNombre(), nuevo.getContraseñaEncriptada()));
		jedis.disconnect();
		jedis.close();
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
		Object evento = e.getSource();
		
		if (evento == btnIngresar){
			
			if (comprobarCondiciones()){
				
				crearUsuario();
				
			}
		}
	}
}
