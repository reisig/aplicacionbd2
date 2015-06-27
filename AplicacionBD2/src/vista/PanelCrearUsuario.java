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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JPasswordField;

public class PanelCrearUsuario extends JPanel implements ActionListener {

	private static final long serialVersionUID = -4934762090157895495L;
	private JTextField tfUsuario;
	private JPasswordField tfConfirmar;
	private JPasswordField tfContrasena;
	private JButton btnIngresar;
	private Conector conector;

	public PanelCrearUsuario(Conector c){ 
	    	this.conector = c;
		setVisible(true);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{57, 135, 165, 0, 0};
		gridBagLayout.rowHeights = new int[]{45, 33, 34, 20, 20, 20, 44, 23, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel titulo = new JLabel("Crear Usuario");
		titulo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		GridBagConstraints gbc_titulo = new GridBagConstraints();
		gbc_titulo.gridwidth = 2;
		gbc_titulo.fill = GridBagConstraints.VERTICAL;
		gbc_titulo.insets = new Insets(0, 0, 5, 5);
		gbc_titulo.gridx = 1;
		gbc_titulo.gridy = 1;
		add(titulo, gbc_titulo);
		
		btnIngresar = new JButton("Guardar");
		btnIngresar.addActionListener(this);
		
		JLabel lblUsuario = new JLabel("Usuario: ");
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.anchor = GridBagConstraints.WEST;
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuario.gridx = 1;
		gbc_lblUsuario.gridy = 3;
		add(lblUsuario, gbc_lblUsuario);
		
		tfUsuario = new JTextField();
		GridBagConstraints gbc_tfUsuario = new GridBagConstraints();
		gbc_tfUsuario.anchor = GridBagConstraints.NORTH;
		gbc_tfUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_tfUsuario.gridx = 2;
		gbc_tfUsuario.gridy = 3;
		add(tfUsuario, gbc_tfUsuario);
		tfUsuario.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		GridBagConstraints gbc_lblContrasea = new GridBagConstraints();
		gbc_lblContrasea.anchor = GridBagConstraints.WEST;
		gbc_lblContrasea.insets = new Insets(0, 0, 5, 5);
		gbc_lblContrasea.gridx = 1;
		gbc_lblContrasea.gridy = 4;
		add(lblContrasea, gbc_lblContrasea);
		
		tfContrasena = new JPasswordField();
		GridBagConstraints gbc_tfContrasena = new GridBagConstraints();
		gbc_tfContrasena.anchor = GridBagConstraints.NORTH;
		gbc_tfContrasena.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfContrasena.insets = new Insets(0, 0, 5, 5);
		gbc_tfContrasena.gridx = 2;
		gbc_tfContrasena.gridy = 4;
		add(tfContrasena, gbc_tfContrasena);
		tfContrasena.setColumns(10);
		
		JLabel lblConfirmarContasea = new JLabel("Confirmar contase\u00F1a:");
		GridBagConstraints gbc_lblConfirmarContasea = new GridBagConstraints();
		gbc_lblConfirmarContasea.anchor = GridBagConstraints.WEST;
		gbc_lblConfirmarContasea.insets = new Insets(0, 0, 5, 5);
		gbc_lblConfirmarContasea.gridx = 1;
		gbc_lblConfirmarContasea.gridy = 5;
		add(lblConfirmarContasea, gbc_lblConfirmarContasea);
		
		tfConfirmar = new JPasswordField();
		GridBagConstraints gbc_tfConfirmar = new GridBagConstraints();
		gbc_tfConfirmar.anchor = GridBagConstraints.NORTH;
		gbc_tfConfirmar.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfConfirmar.insets = new Insets(0, 0, 5, 5);
		gbc_tfConfirmar.gridx = 2;
		gbc_tfConfirmar.gridy = 5;
		add(tfConfirmar, gbc_tfConfirmar);
		tfConfirmar.setColumns(10);
		GridBagConstraints gbc_btnIngresar = new GridBagConstraints();
		gbc_btnIngresar.gridwidth = 2;
		gbc_btnIngresar.insets = new Insets(0, 0, 5, 5);
		gbc_btnIngresar.anchor = GridBagConstraints.NORTH;
		gbc_btnIngresar.gridx = 1;
		gbc_btnIngresar.gridy = 7;
		add(btnIngresar, gbc_btnIngresar);
	}
	
	
	private boolean comprobarCondiciones(){
		
		if (tfUsuario.getText().isEmpty()){
			
			JOptionPane.showMessageDialog(null,"Por favor ingrese usuario","Error" ,JOptionPane.ERROR_MESSAGE);	
			return false;
		}
			
		if (String.valueOf(tfContrasena.getPassword()).isEmpty()){
			
			JOptionPane.showMessageDialog(null,"Por favor ingrese contraseña","Error" ,JOptionPane.ERROR_MESSAGE);	
			return false;
		}
		
		if (String.valueOf(tfConfirmar.getPassword()).isEmpty()){
			
			JOptionPane.showMessageDialog(null,"Por favor confirme contraseña","Error" ,JOptionPane.ERROR_MESSAGE);	
			return false;
		}
		
		
		if ( ! (String.valueOf(tfContrasena.getPassword()).equals(String.valueOf(tfConfirmar.getPassword()))) ){
			
			JOptionPane.showMessageDialog(null,"Las contraseñas no coinciden","Error" ,JOptionPane.ERROR_MESSAGE);	
			return false;
		}
		
		return true;
		
	}
	
	private void limpiar(){
		
		tfUsuario.setText("");
		tfContrasena.setText("");
		tfConfirmar.setText("");
		
	}
	
	private boolean existeUsuario(){
	    if(conector.exists(tfUsuario.getText()))
		    return true;
		else{
		    return false;
		}	
	}
	
	
	public void crearUsuario(){
	    
		Usuario nuevo = new Usuario(tfUsuario.getText(),String.valueOf(tfContrasena.getPassword()));
		System.out.println(conector.set(nuevo.getNombre(), nuevo.getContraseñaEncriptada()));		
		JOptionPane.showMessageDialog(null,"Usuario creado correctamente","Información" ,JOptionPane.INFORMATION_MESSAGE);	
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
		Object evento = e.getSource();
		
		if (evento == btnIngresar){
			
			if (comprobarCondiciones()){
				
				if(!existeUsuario()){
					
					crearUsuario();
					limpiar();
				}
			}
		}
	}
}
