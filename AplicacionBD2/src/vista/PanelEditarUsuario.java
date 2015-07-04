package vista;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import modelo.Usuario;

import org.jasypt.util.text.BasicTextEncryptor;

import controlador.Conector;

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
        private JLabel lblNuevoNombre;
        private JTextField textField;
        private JPanel panel;
        private JButton btnComprobarNombre;
        private JLabel lblPuedeDejarEl;
        private JPanel panel_1;
        private JButton btnCancelar;
        private Vista vista;
	
	public PanelEditarUsuario(Conector c, Vista v){
		
	    	this.conector = c;	
	    	this.vista = v;
		
		setVisible(true);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 106, 196, 0};
		gridBagLayout.rowHeights = new int[]{0, 68, 20, 0, 0, 0, 20, 21, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel titulo = new JLabel("Editar Nombre/Contrase\u00F1a");
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
		gbc_lblUsuario.gridy = 2;
		add(lblUsuario, gbc_lblUsuario);
		
		tfUsuario = new JTextField();
		tfUsuario.setEditable(false);
		GridBagConstraints gbc_tfUsuario = new GridBagConstraints();
		gbc_tfUsuario.anchor = GridBagConstraints.NORTH;
		gbc_tfUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_tfUsuario.gridx = 2;
		gbc_tfUsuario.gridy = 2;
		add(tfUsuario, gbc_tfUsuario);
		tfUsuario.setColumns(10);
		
		lblPuedeDejarEl = new JLabel("Nota: Puede dejar el campo en blanco si no desea cambiar el nombre");
		GridBagConstraints gbc_lblPuedeDejarEl = new GridBagConstraints();
		gbc_lblPuedeDejarEl.gridwidth = 2;
		gbc_lblPuedeDejarEl.insets = new Insets(0, 0, 5, 5);
		gbc_lblPuedeDejarEl.gridx = 1;
		gbc_lblPuedeDejarEl.gridy = 3;
		add(lblPuedeDejarEl, gbc_lblPuedeDejarEl);
		
		lblNuevoNombre = new JLabel("Nuevo Nombre:");
		GridBagConstraints gbc_lblNuevoNombre = new GridBagConstraints();
		gbc_lblNuevoNombre.anchor = GridBagConstraints.WEST;
		gbc_lblNuevoNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNuevoNombre.gridx = 1;
		gbc_lblNuevoNombre.gridy = 4;
		add(lblNuevoNombre, gbc_lblNuevoNombre);
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.gridx = 2;
		gbc_panel.gridy = 4;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{196, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 0;
		panel.add(textField, gbc_textField);
		textField.setColumns(10);
		
		btnComprobarNombre = new JButton("Comprobar Nombre");
		btnComprobarNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			    String nombre = textField.getText().toLowerCase();
			    if(!nombre.isEmpty() && !c.exists(nombre))
				JOptionPane.showMessageDialog(null, "El nombre está disponible y puede usarlo", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
			    else if (c.exists(nombre))
				JOptionPane.showMessageDialog(null, "El nombre ingresado ya existe", "Error", JOptionPane.ERROR_MESSAGE);
			}
		});
		GridBagConstraints gbc_btnComprobarNombre = new GridBagConstraints();
		gbc_btnComprobarNombre.gridx = 0;
		gbc_btnComprobarNombre.gridy = 1;
		panel.add(btnComprobarNombre, gbc_btnComprobarNombre);
		
		lblContraseaActual = new JLabel("Contrase\u00F1a Actual:");
		GridBagConstraints gbc_lblContraseaActual = new GridBagConstraints();
		gbc_lblContraseaActual.anchor = GridBagConstraints.WEST;
		gbc_lblContraseaActual.insets = new Insets(0, 0, 5, 5);
		gbc_lblContraseaActual.gridx = 1;
		gbc_lblContraseaActual.gridy = 5;
		add(lblContraseaActual, gbc_lblContraseaActual);
		
		pfContrasenaActual = new JPasswordField();
		GridBagConstraints gbc_pfContrasenaActual = new GridBagConstraints();
		gbc_pfContrasenaActual.insets = new Insets(0, 0, 5, 5);
		gbc_pfContrasenaActual.fill = GridBagConstraints.HORIZONTAL;
		gbc_pfContrasenaActual.gridx = 2;
		gbc_pfContrasenaActual.gridy = 5;
		add(pfContrasenaActual, gbc_pfContrasenaActual);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		GridBagConstraints gbc_lblContrasea = new GridBagConstraints();
		gbc_lblContrasea.anchor = GridBagConstraints.WEST;
		gbc_lblContrasea.insets = new Insets(0, 0, 5, 5);
		gbc_lblContrasea.gridx = 1;
		gbc_lblContrasea.gridy = 6;
		add(lblContrasea, gbc_lblContrasea);
		
		pfContrasenaNueva = new JPasswordField();
		GridBagConstraints gbc_pfContrasenaNueva = new GridBagConstraints();
		gbc_pfContrasenaNueva.anchor = GridBagConstraints.NORTH;
		gbc_pfContrasenaNueva.fill = GridBagConstraints.HORIZONTAL;
		gbc_pfContrasenaNueva.insets = new Insets(0, 0, 5, 5);
		gbc_pfContrasenaNueva.gridx = 2;
		gbc_pfContrasenaNueva.gridy = 6;
		add(pfContrasenaNueva, gbc_pfContrasenaNueva);
		pfContrasenaNueva.setColumns(10);
		
		JLabel lblConfirmarContrasena = new JLabel("Confirmar contase\u00F1a:");
		GridBagConstraints gbc_lblConfirmarContrasena = new GridBagConstraints();
		gbc_lblConfirmarContrasena.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblConfirmarContrasena.insets = new Insets(0, 0, 5, 5);
		gbc_lblConfirmarContrasena.gridx = 1;
		gbc_lblConfirmarContrasena.gridy = 7;
		add(lblConfirmarContrasena, gbc_lblConfirmarContrasena);
		
		pfConfirmar = new JPasswordField();
		GridBagConstraints gbc_pfConfirmar = new GridBagConstraints();
		gbc_pfConfirmar.anchor = GridBagConstraints.NORTH;
		gbc_pfConfirmar.fill = GridBagConstraints.HORIZONTAL;
		gbc_pfConfirmar.insets = new Insets(0, 0, 5, 5);
		gbc_pfConfirmar.gridx = 2;
		gbc_pfConfirmar.gridy = 7;
		add(pfConfirmar, gbc_pfConfirmar);
		pfConfirmar.setColumns(10);
		
		panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridwidth = 2;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 8;
		add(panel_1, gbc_panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnCancelar = new JButton("Cancelar");
		panel_1.add(btnCancelar);
		
		btnIngresar = new JButton("Guardar");
		panel_1.add(btnIngresar);
		btnIngresar.addActionListener(this);
		
		CargarUsuario();
	}
	
	
	private boolean comprobarCondiciones(){
		String pwdActual = String.valueOf(pfContrasenaActual.getPassword());
		String pwdNueva =  String.valueOf(pfContrasenaNueva.getPassword());
		String pwdNuevaConfirmar = String.valueOf(pfConfirmar.getPassword());
		String pwdUsuario = user.getContraseñaDesencriptada();
		
		if( (pwdActual.isEmpty() ||
			pwdNueva .isEmpty() ||
			pwdNuevaConfirmar.isEmpty()) 			
		)  {
		   
		    JOptionPane.showMessageDialog(null,"Por favor ingrese contraseña","Error" ,JOptionPane.ERROR_MESSAGE);	
			return false;
		}		
		
		if ( (!pwdActual.equals(pwdUsuario) ||
		     !pwdNueva.equals(pwdNuevaConfirmar)) 
		   ){
			
			JOptionPane.showMessageDialog(null,"Las contraseñas no coinciden","Error" ,JOptionPane.ERROR_MESSAGE);	
			return false;
		}
		
		return true;
		
	}
	
	public void setUsuario(Usuario user){
		this.user = user;
		tfUsuario.setText(user.getNombre());		
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
		String.valueOf(pfContrasenaNueva.getPassword());
		String password = String.valueOf(pfConfirmar.getPassword());
		
		BasicTextEncryptor enc1 = new BasicTextEncryptor();
		enc1.setPassword(password);

		
		conector.getSet(user.getNombre(), enc1.encrypt(password));
		
		
		JOptionPane.showMessageDialog(null,"Contraseña cambiada correctamente","Información" ,JOptionPane.INFORMATION_MESSAGE);	
	}
	
//	public static void main(String[] args) {
//	    Usuario u = new Usuario ("Lucho", "lucho");
//	    JFrame frame = new JFrame();
//	    Conector c = new Conector();
//	    c.conectar();
//	    PanelEditarUsuario p = new PanelEditarUsuario(c);
//	    p.setUsuario(u);
//	    frame.getContentPane().add(p);
//	    frame.setVisible(true);
//	    c.desconectar();
//	    c.close();
//	}
	
	
	public void actionPerformed(ActionEvent e) {
		
		Object evento = e.getSource();
		
		if (evento == btnIngresar){
		    	String nombreNuevo = textField.getText();
		    	if (!nombreNuevo.isEmpty() && !Character.isDigit(nombreNuevo.charAt(0)) && !conector.exists(nombreNuevo)) {
			    String nombreActual = user.getNombre();
			    List<Date> fechas = conector.getFechas(nombreActual);
			    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			    for (Date d : fechas) {
				String s = df.format(d);
				String proteinas = conector.hget(s, nombreActual);
				conector.hset(s, nombreNuevo, proteinas);
				conector.hdel(s, nombreActual);
			    }
			
			    conector.del(nombreActual);
			    conector.set(nombreNuevo, user.getContraseñaEncriptada());
			    user.setNombre(nombreNuevo);
			    JOptionPane.showMessageDialog(null, 
				    "Nombre modificado correctamente", 
				    "Mensaje", 
				    JOptionPane.INFORMATION_MESSAGE);
			    vista.cerrarSesion();
			    Vista.cl.show(vista.contentPane, "PanelInicio");
			}else{
			    JOptionPane.showMessageDialog(null, 
				    "Por favor verifique las condiciones: "
				    + "El nombre usuario no debe existir, "
				    + "tampoco puede comenzar con un numero", 
				    "Error", 
				    JOptionPane.ERROR_MESSAGE);
			}
			if (comprobarCondiciones()){
				
				EditarContrasena();		
				limpiar();
				CargarUsuario();
			}
		}
	}
}
