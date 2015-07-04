package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import com.toedter.calendar.JCalendar;

import controlador.Conector;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import modelo.Usuario;

import java.awt.Color;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class PanelProteinas extends JPanel implements ActionListener {
	
	private static final long serialVersionUID = 3294981998759438131L;
	private JTextField tfProteinas;
	private JButton btnIngresar;
	private JCalendar calendar;
	private Usuario usuario;
	private Conector conector;
	
	public PanelProteinas(Conector c, Usuario u) {
		this.conector = c;
		setSize(600,400);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{72, 204, 50, 209, 0, 0};
		gridBagLayout.rowHeights = new int[]{37, 25, 63, 20, 54, 79, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblIngresarProteinas = new JLabel("Ingresar proteinas");
		lblIngresarProteinas.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		GridBagConstraints gbc_lblIngresarProteinas = new GridBagConstraints();
		gbc_lblIngresarProteinas.anchor = GridBagConstraints.NORTH;
		gbc_lblIngresarProteinas.insets = new Insets(0, 0, 5, 5);
		gbc_lblIngresarProteinas.gridwidth = 3;
		gbc_lblIngresarProteinas.gridx = 1;
		gbc_lblIngresarProteinas.gridy = 1;
		add(lblIngresarProteinas, gbc_lblIngresarProteinas);
		
		tfProteinas = new JTextField();
		GridBagConstraints gbc_tfProteinas = new GridBagConstraints();
		gbc_tfProteinas.anchor = GridBagConstraints.NORTHEAST;
		gbc_tfProteinas.insets = new Insets(0, 0, 5, 5);
		gbc_tfProteinas.gridx = 1;
		gbc_tfProteinas.gridy = 3;
		add(tfProteinas, gbc_tfProteinas);
		tfProteinas.setColumns(10);
		
		JLabel lblIngresarProteinas_1 = new JLabel("Ingresar proteinas: ");
		GridBagConstraints gbc_lblIngresarProteinas_1 = new GridBagConstraints();
		gbc_lblIngresarProteinas_1.anchor = GridBagConstraints.WEST;
		gbc_lblIngresarProteinas_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblIngresarProteinas_1.gridx = 1;
		gbc_lblIngresarProteinas_1.gridy = 3;
		add(lblIngresarProteinas_1, gbc_lblIngresarProteinas_1);
		
		calendar = new JCalendar();
		calendar.setBorder(new LineBorder(new Color(192, 192, 192), 3));
		GridBagConstraints gbc_calendar = new GridBagConstraints();
		gbc_calendar.insets = new Insets(0, 0, 5, 5);
		gbc_calendar.fill = GridBagConstraints.BOTH;
		gbc_calendar.gridheight = 3;
		gbc_calendar.gridx = 3;
		gbc_calendar.gridy = 3;
		add(calendar, gbc_calendar);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(this);
		GridBagConstraints gbc_btnIngresar = new GridBagConstraints();
		gbc_btnIngresar.anchor = GridBagConstraints.NORTHEAST;
		gbc_btnIngresar.insets = new Insets(0, 0, 5, 5);
		gbc_btnIngresar.gridx = 1;
		gbc_btnIngresar.gridy = 5;
		add(btnIngresar, gbc_btnIngresar);
		setVisible(true);
	}
	
	private boolean toInt (String entrada){
		
		
		try{	
			Integer.parseInt(entrada); 
	     
		}catch (NumberFormatException e1){
		
			return false;
		}
		
		return true;
	}
	

	private boolean comprobarCondiciones(){
		
	
		if (tfProteinas.getText().isEmpty()){
			
			JOptionPane.showMessageDialog(null,"Por favor ingrese proteinas","Error" ,JOptionPane.ERROR_MESSAGE);			
			return false;
			
		}else{
			
			if (!toInt(tfProteinas.getText())){
				
				JOptionPane.showMessageDialog(null,"Por favor ingrese solo numeros enteros","Error" ,JOptionPane.ERROR_MESSAGE);			
				return false;
			}else{
				
				
				int numero = Integer.parseInt(tfProteinas.getText()); 
				
				if (numero < 0){
					
					JOptionPane.showMessageDialog(null,"Por favor ingrese solo valores positivos","Error" ,JOptionPane.ERROR_MESSAGE);			
					return false;
				}
				
			}
		}
		return true;
	}
	
	public void setUsuario(Usuario u){
	    this.usuario = u;
	}
	

	public void insertarProteinas() throws ParseException{
		
		DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
	
		Date fecha = calendar.getDate();
		if(conector.hset(sdf.format(fecha), usuario.getNombre(),tfProteinas.getText())==1)
		    JOptionPane.showMessageDialog(null, "Insertado Correctamente", 
			    "Éxito", JOptionPane.INFORMATION_MESSAGE);
		else
		    JOptionPane.showMessageDialog(null, "No se pudo insertar, puede que ya exista en el registro.", 
			    	"Error", JOptionPane.ERROR_MESSAGE);

	}
	
	
	public void actionPerformed(ActionEvent e){

		Object evento = e.getSource();
		
		if (evento == btnIngresar){
			
			if (comprobarCondiciones()){
				
				try {
					insertarProteinas();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
}
