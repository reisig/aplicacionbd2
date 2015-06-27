package vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.JPasswordField;

public class PanelEditarUsuario extends JPanel implements ActionListener {

	private static final long serialVersionUID = -6330104928514128414L;
	private JPasswordField pfConfirmar;
	private JPasswordField pfContrasenaNueva;
	private JButton btnIngresar;
    private String usuario;
    private JTextField tfUsuario;
    private JTextField tfContraseñaActual;
	
	public PanelEditarUsuario(String nombreUsuario){
		
		usuario = nombreUsuario;
		CargarUsuario();
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
		
		JLabel lblConfirmarContrasena = new JLabel("Confirmar contase\u00F1a:");
		lblConfirmarContrasena.setBounds(57, 249, 130, 14);
		add(lblConfirmarContrasena);
		
		pfConfirmar = new JPasswordField();
		pfConfirmar.setBounds(197, 246, 155, 20);
		add(pfConfirmar);
		pfConfirmar.setColumns(10);
		
		pfContrasenaNueva = new JPasswordField();
		pfContrasenaNueva.setBounds(197, 202, 155, 20);
		add(pfContrasenaNueva);
		pfContrasenaNueva.setColumns(10);
		
		JLabel lblContraseaActual = new JLabel("Contrase\u00F1a actual:");
		lblContraseaActual.setBounds(73, 159, 92, 14);
		add(lblContraseaActual);
		
		tfUsuario = new JTextField();
		tfUsuario.setEditable(false);
		tfUsuario.setBounds(197, 112, 155, 20);
		add(tfUsuario);
		tfUsuario.setColumns(10);
		
		tfContraseñaActual = new JTextField();
		tfContraseñaActual.setEditable(false);
		tfContraseñaActual.setBounds(197, 156, 155, 20);
		add(tfContraseñaActual);
		tfContraseñaActual.setColumns(10);
	}
	
	
	private boolean comprobarCondiciones(){
		
		if (tfUsuario.getText().isEmpty()){
			
			JOptionPane.showMessageDialog(null,"Por favor ingrese usuario","Error" ,JOptionPane.ERROR_MESSAGE);	
			return false;
		}
			
		if (String.valueOf(pfContrasenaNueva.getPassword()).isEmpty()){
			
			JOptionPane.showMessageDialog(null,"Por favor ingrese contraseña","Error" ,JOptionPane.ERROR_MESSAGE);	
			return false;
		}
		
		if (String.valueOf((pfConfirmar.getPassword())).isEmpty()){
			
			JOptionPane.showMessageDialog(null,"Por favor confirme contraseña","Error" ,JOptionPane.ERROR_MESSAGE);	
			return false;
		}
		
		
		if ( ! (String.valueOf(pfContrasenaNueva.getPassword()).equals(String.valueOf(pfConfirmar.getPassword())))){
			
			JOptionPane.showMessageDialog(null,"Las contraseñas no coinciden","Error" ,JOptionPane.ERROR_MESSAGE);	
			return false;
		}
		
		return true;
		
	}
	
	public void limpiar() {
		
		pfContrasenaNueva.setText("");
		pfConfirmar.setText("");
	}
	
	
	private void CargarUsuario(){
		
		tfUsuario.setText(usuario);
		tfContraseñaActual.setText("contraseñaActual"); //obtener la contraseña de la bd
		
	}
	
	private void EditarContrasena(){
		
		System.out.println(usuario);
		String.valueOf(pfContrasenaNueva.getPassword());
		String.valueOf(pfConfirmar.getPassword());
		
		JOptionPane.showMessageDialog(null,"Contraseña cambiada correctamente","Información" ,JOptionPane.INFORMATION_MESSAGE);	
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
		Object evento = e.getSource();
		
		if (evento == btnIngresar){
			
			if (comprobarCondiciones()){
				
				EditarContrasena();		
				limpiar();
				CargarUsuario();
			}
		}
	}
}
