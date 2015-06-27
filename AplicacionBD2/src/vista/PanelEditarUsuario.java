package vista;

import java.awt.Color;
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

public class PanelEditarUsuario extends JPanel implements ActionListener {

	private static final long serialVersionUID = -6330104928514128414L;
	private JTextField tfConfirmar;
	private JTextField tfContrasena;
	private JButton btnIngresar;
    private String usuario;
    private JTextField tfUsuario;
    private JTextField tfContrase�aActual;
	
	public PanelEditarUsuario(String nombreUsuario){
		
		usuario = nombreUsuario;
		setLayout(null);
		setVisible(true);
		
		JLabel titulo = new JLabel("Editar Contrase\u00F1a");
		titulo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		titulo.setBounds(177, 47, 216, 33);
		add(titulo);
		
		JLabel lblUsuario = new JLabel("Usuario: ");
		lblUsuario.setBounds(125, 115, 67, 14);
		add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(103, 205, 89, 14);
		add(lblContrasea);
		
		btnIngresar = new JButton("Guardar");
		btnIngresar.addActionListener(this);
		btnIngresar.setBounds(228, 310, 89, 23);
		add(btnIngresar);
		
		JLabel lblConfirmarContasea = new JLabel("Confirmar contase\u00F1a:");
		lblConfirmarContasea.setBounds(57, 249, 130, 14);
		add(lblConfirmarContasea);
		
		tfConfirmar = new JTextField();
		tfConfirmar.setBounds(197, 246, 155, 20);
		add(tfConfirmar);
		tfConfirmar.setColumns(10);
		
		tfContrasena = new JTextField();
		tfContrasena.setBounds(197, 202, 155, 20);
		add(tfContrasena);
		tfContrasena.setColumns(10);
		
		JLabel lblContraseaActual = new JLabel("Contrase\u00F1a actual:");
		lblContraseaActual.setBounds(73, 159, 92, 14);
		add(lblContraseaActual);
		
		tfUsuario = new JTextField();
		tfUsuario.setBounds(197, 112, 155, 20);
		add(tfUsuario);
		tfUsuario.setColumns(10);
		
		tfContrase�aActual = new JTextField();
		tfContrase�aActual.setBounds(197, 156, 155, 20);
		add(tfContrase�aActual);
		tfContrase�aActual.setColumns(10);
	}
	
	
	private boolean comprobarCondiciones(){
		
		if (tfUsuario.getText().isEmpty()){
			
			JOptionPane.showMessageDialog(null,"Por favor ingrese usuario","Error" ,JOptionPane.ERROR_MESSAGE);	
			return false;
		}
			
		if (tfContrasena.getText().isEmpty()){
			
			JOptionPane.showMessageDialog(null,"Por favor ingrese contrase�a","Error" ,JOptionPane.ERROR_MESSAGE);	
			return false;
		}
		
		if (tfConfirmar.getText().isEmpty()){
			
			JOptionPane.showMessageDialog(null,"Por favor confirme contrase�a","Error" ,JOptionPane.ERROR_MESSAGE);	
			return false;
		}
		
		
		if ( ! (tfContrasena.getText().equals(tfConfirmar.getText())) ){
			
			JOptionPane.showMessageDialog(null,"Las contrase�as no coinciden","Error" ,JOptionPane.ERROR_MESSAGE);	
			return false;
		}
		
		return true;
		
	}
	
	
	public void CargarUsuario(){
		
		Conector jedis = new Conector();
		
		tfUsuario.setText(usuario);
		//tfContrasena
		
		jedis.disconnect();
		jedis.close();
		
	}
	
	public void EditarUsuario(){
		
		Conector jedis = new Conector();
		Usuario nuevo = new Usuario(tfUsuario.getText(),tfContrasena.getText());
		
		jedis.conectar();
		System.out.println(jedis.set(nuevo.getNombre(), nuevo.getContrase�aEncriptada()));
		jedis.disconnect();
		jedis.close();
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
		Object evento = e.getSource();
		
		if (evento == btnIngresar){
			
			if (comprobarCondiciones()){
				
				EditarUsuario();		
			}
		}
	}
}
