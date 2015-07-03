package vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import modelo.Usuario;

import org.jasypt.util.text.BasicTextEncryptor;

import controlador.Conector;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class PanelEditarUsuario extends JPanel implements ActionListener {

	private static final long serialVersionUID = -6330104928514128414L;
	private JPasswordField pfConfirmar;
	private JPasswordField pfContrasenaNueva;
	private JButton btnIngresar;
        private JTextField tfUsuario;
        private Conector conector;
        private JLabel lblContraseaActual;
        private JPasswordField pfContrasenaActual;
        private Usuario user;
	
	public PanelEditarUsuario(Conector c, Usuario user){
		
	    	this.conector = c;
		this.user = user;
		
		
		setVisible(true);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 106, 196, 0, 0};
		gridBagLayout.rowHeights = new int[]{53, 68, 32, 20, 0, 20, 20, 91, 23, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel titulo = new JLabel("Editar Contrase\u00F1a");
		titulo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		GridBagConstraints gbc_titulo = new GridBagConstraints();
		gbc_titulo.fill = GridBagConstraints.VERTICAL;
		gbc_titulo.insets = new Insets(0, 0, 5, 5);
		gbc_titulo.gridwidth = 2;
		gbc_titulo.gridx = 1;
		gbc_titulo.gridy = 1;
		add(titulo, gbc_titulo);
		
		JLabel lblUsuario = new JLabel("Usuario: ");
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.anchor = GridBagConstraints.WEST;
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuario.gridx = 1;
		gbc_lblUsuario.gridy = 3;
		add(lblUsuario, gbc_lblUsuario);
		
		tfUsuario = new JTextField();
		tfUsuario.setEditable(false);
		GridBagConstraints gbc_tfUsuario = new GridBagConstraints();
		gbc_tfUsuario.anchor = GridBagConstraints.NORTH;
		gbc_tfUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_tfUsuario.gridx = 2;
		gbc_tfUsuario.gridy = 3;
		add(tfUsuario, gbc_tfUsuario);
		tfUsuario.setColumns(10);
		
		lblContraseaActual = new JLabel("Contrase\u00F1a Actual:");
		GridBagConstraints gbc_lblContraseaActual = new GridBagConstraints();
		gbc_lblContraseaActual.anchor = GridBagConstraints.WEST;
		gbc_lblContraseaActual.insets = new Insets(0, 0, 5, 5);
		gbc_lblContraseaActual.gridx = 1;
		gbc_lblContraseaActual.gridy = 4;
		add(lblContraseaActual, gbc_lblContraseaActual);
		
		pfContrasenaActual = new JPasswordField();
		GridBagConstraints gbc_pfContrasenaActual = new GridBagConstraints();
		gbc_pfContrasenaActual.insets = new Insets(0, 0, 5, 5);
		gbc_pfContrasenaActual.fill = GridBagConstraints.HORIZONTAL;
		gbc_pfContrasenaActual.gridx = 2;
		gbc_pfContrasenaActual.gridy = 4;
		add(pfContrasenaActual, gbc_pfContrasenaActual);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		GridBagConstraints gbc_lblContrasea = new GridBagConstraints();
		gbc_lblContrasea.anchor = GridBagConstraints.WEST;
		gbc_lblContrasea.insets = new Insets(0, 0, 5, 5);
		gbc_lblContrasea.gridx = 1;
		gbc_lblContrasea.gridy = 5;
		add(lblContrasea, gbc_lblContrasea);
		
		pfContrasenaNueva = new JPasswordField();
		GridBagConstraints gbc_pfContrasenaNueva = new GridBagConstraints();
		gbc_pfContrasenaNueva.anchor = GridBagConstraints.NORTH;
		gbc_pfContrasenaNueva.fill = GridBagConstraints.HORIZONTAL;
		gbc_pfContrasenaNueva.insets = new Insets(0, 0, 5, 5);
		gbc_pfContrasenaNueva.gridx = 2;
		gbc_pfContrasenaNueva.gridy = 5;
		add(pfContrasenaNueva, gbc_pfContrasenaNueva);
		pfContrasenaNueva.setColumns(10);
		
		JLabel lblConfirmarContrasena = new JLabel("Confirmar contase\u00F1a:");
		GridBagConstraints gbc_lblConfirmarContrasena = new GridBagConstraints();
		gbc_lblConfirmarContrasena.anchor = GridBagConstraints.WEST;
		gbc_lblConfirmarContrasena.insets = new Insets(0, 0, 5, 5);
		gbc_lblConfirmarContrasena.gridx = 1;
		gbc_lblConfirmarContrasena.gridy = 6;
		add(lblConfirmarContrasena, gbc_lblConfirmarContrasena);
		
		pfConfirmar = new JPasswordField();
		GridBagConstraints gbc_pfConfirmar = new GridBagConstraints();
		gbc_pfConfirmar.anchor = GridBagConstraints.NORTH;
		gbc_pfConfirmar.fill = GridBagConstraints.HORIZONTAL;
		gbc_pfConfirmar.insets = new Insets(0, 0, 5, 5);
		gbc_pfConfirmar.gridx = 2;
		gbc_pfConfirmar.gridy = 6;
		add(pfConfirmar, gbc_pfConfirmar);
		pfConfirmar.setColumns(10);
		
		btnIngresar = new JButton("Guardar");
		btnIngresar.addActionListener(this);
		GridBagConstraints gbc_btnIngresar = new GridBagConstraints();
		gbc_btnIngresar.gridwidth = 4;
		gbc_btnIngresar.insets = new Insets(0, 0, 5, 0);
		gbc_btnIngresar.gridx = 0;
		gbc_btnIngresar.gridy = 7;
		add(btnIngresar, gbc_btnIngresar);
		
		CargarUsuario();
	}
	
	
	private boolean comprobarCondiciones(){
		
		if (tfUsuario.getText().isEmpty()){
			
			JOptionPane.showMessageDialog(null,"Por favor ingrese usuario","Error" ,JOptionPane.ERROR_MESSAGE);	
			return false;
		}
		
		if(String.valueOf(pfContrasenaActual.getPassword()).isEmpty() ||
		   String.valueOf(pfContrasenaNueva.getPassword()) .isEmpty() ||
		   String.valueOf((pfConfirmar.getPassword()))	   .isEmpty()){
		   
		    JOptionPane.showMessageDialog(null,"Por favor ingrese contraseña","Error" ,JOptionPane.ERROR_MESSAGE);	
			return false;
		}		
		
		if (!String.valueOf(pfContrasenaActual.getPassword()).equals(user.getContraseñaDesencriptada()) || 
			!(String.valueOf(pfContrasenaNueva.getPassword()).equals(String.valueOf(pfConfirmar.getPassword())))){
			
			JOptionPane.showMessageDialog(null,"Las contraseñas no coinciden","Error" ,JOptionPane.ERROR_MESSAGE);	
			return false;
		}
		
		return true;
		
	}
	
	public void limpiar() {
		
		pfContrasenaNueva.setText("");
		pfConfirmar.setText("");
	}
	
	
	public void CargarUsuario(){
		if(user!=null)
		    tfUsuario.setText(user.getNombre());
		
	}
	
	private void EditarContrasena(){
		
		System.out.println(user.getNombre());
		String.valueOf(pfContrasenaNueva.getPassword());
		String password = String.valueOf(pfConfirmar.getPassword());
		
		BasicTextEncryptor enc1 = new BasicTextEncryptor();
		enc1.setPassword(password);
		
		BasicTextEncryptor enc2 = new BasicTextEncryptor();
		String pwdAntigua = conector.get(user.getNombre());
		
		
		System.out.println(conector.getSet(user.getNombre(), enc1.encrypt(password)));
		
		
		JOptionPane.showMessageDialog(null,"Contraseña cambiada correctamente","Información" ,JOptionPane.INFORMATION_MESSAGE);	
	}
	
	public static void main(String[] args) {
	    Usuario u = new Usuario ("Lucho", "lucho");
	    JFrame frame = new JFrame();
	    Conector c = new Conector();
	    c.conectar();
	    frame.getContentPane().add(new PanelEditarUsuario(c, null));
	    frame.setVisible(true);
	    c.desconectar();
	    c.close();
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
