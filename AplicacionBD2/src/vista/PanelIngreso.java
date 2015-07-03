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

import modelo.Usuario;

import org.jasypt.util.text.BasicTextEncryptor;

import controlador.Conector;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class PanelIngreso extends JPanel implements ActionListener{
	
	private static final long serialVersionUID = -5330361553046124052L;
	private JTextField tfUsuario;
	private JPasswordField pfContrasena;
	private JButton btnIngresar;
	private Conector conector;
	private Usuario user;


	public PanelIngreso(Conector c, Usuario user) {
	    	
	    	this.conector = c;
	    	this.user = user;
	    
		setVisible(true);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{85, 89, 175, 0, 0};
		gridBagLayout.rowHeights = new int[]{55, 33, 42, 20, 20, 47, 23, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel titulo = new JLabel("Redis Connect");
		titulo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		GridBagConstraints gbc_titulo = new GridBagConstraints();
		gbc_titulo.gridwidth = 2;
		gbc_titulo.fill = GridBagConstraints.VERTICAL;
		gbc_titulo.insets = new Insets(0, 0, 5, 5);
		gbc_titulo.gridx = 1;
		gbc_titulo.gridy = 1;
		add(titulo, gbc_titulo);
		
		JLabel lblUsuario = new JLabel("Usuario: ");
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.fill = GridBagConstraints.HORIZONTAL;
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
		gbc_lblContrasea.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblContrasea.insets = new Insets(0, 0, 5, 5);
		gbc_lblContrasea.gridx = 1;
		gbc_lblContrasea.gridy = 4;
		add(lblContrasea, gbc_lblContrasea);
		
		pfContrasena = new JPasswordField();
		GridBagConstraints gbc_pfContrasena = new GridBagConstraints();
		gbc_pfContrasena.anchor = GridBagConstraints.NORTH;
		gbc_pfContrasena.fill = GridBagConstraints.HORIZONTAL;
		gbc_pfContrasena.insets = new Insets(0, 0, 5, 5);
		gbc_pfContrasena.gridx = 2;
		gbc_pfContrasena.gridy = 4;
		add(pfContrasena, gbc_pfContrasena);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(this);
		GridBagConstraints gbc_btnIngresar = new GridBagConstraints();
		gbc_btnIngresar.gridwidth = 2;
		gbc_btnIngresar.insets = new Insets(0, 0, 5, 5);
		gbc_btnIngresar.anchor = GridBagConstraints.NORTH;
		gbc_btnIngresar.gridx = 1;
		gbc_btnIngresar.gridy = 6;
		add(btnIngresar, gbc_btnIngresar);
	}

	
	private boolean comprobarCondiciones(){
		
		if (tfUsuario.getText().isEmpty()){
			
			JOptionPane.showMessageDialog(null,"Por favor ingrese usuario","Error" ,JOptionPane.ERROR_MESSAGE);	
			return false;
		}
			
		if (String.valueOf(pfContrasena.getPassword()).isEmpty()){
			
			JOptionPane.showMessageDialog(null,"Por favor ingrese contraseña","Error" ,JOptionPane.ERROR_MESSAGE);	
			return false;
		}
		
		return true;
		
	}
	
	private boolean usuarioExiste(String nombre){
		
		if(conector.exists(nombre))
		    return true;
		else{
			 JOptionPane.showMessageDialog(null,"No existe el usuario:  "+nombre,"Error" ,JOptionPane.ERROR_MESSAGE);	
			 return false;
		}
		   
	}
	
	private boolean contraseñaCorrecta(String nombre, String password){
		
	    BasicTextEncryptor encriptador = new BasicTextEncryptor();
	    encriptador.setPassword(password);
	    
	    try{
		encriptador.decrypt(conector.get(nombre));
		JOptionPane.showMessageDialog(null, "Sesión iniciada correctamente.", "Éxito",JOptionPane.INFORMATION_MESSAGE);
		return true;
	    }
	    catch(Exception e){
		JOptionPane.showMessageDialog(null,"Contraseña incorrecta","Error" ,JOptionPane.ERROR_MESSAGE);
		return false;
	    }
	}
	
	
	
	public void actionPerformed(ActionEvent e) {
		
		Object evento = e.getSource();
		
		if (evento == btnIngresar){
			
			if (comprobarCondiciones()){
				
				if(usuarioExiste(tfUsuario.getText())){
					
					if(contraseñaCorrecta(tfUsuario.getText(),String.valueOf(pfContrasena.getPassword()))){
						Vista.user = new Usuario (tfUsuario.getText(), String.valueOf(pfContrasena.getPassword()));
//						System.out
//							.println(Vista.user);
						//tela
					}
				}
			}
		}
	}
}
