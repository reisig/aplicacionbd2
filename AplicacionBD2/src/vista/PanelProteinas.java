package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import com.toedter.calendar.JCalendar;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class PanelProteinas extends JPanel implements ActionListener {
	
	private static final long serialVersionUID = 3294981998759438131L;
	private JTextField tfProteinas;
	private JButton btnIngresar;
	private JCalendar calendar;
	
	public PanelProteinas() {
		
		setLayout(null);
		setSize(600,400);
		
		JLabel lblIngresarProteinas = new JLabel("Ingresar proteinas");
		lblIngresarProteinas.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblIngresarProteinas.setBounds(190, 37, 192, 25);
		add(lblIngresarProteinas);
		
		calendar = new JCalendar();
		calendar.setBorder(new LineBorder(new Color(192, 192, 192), 3));
		calendar.setBounds(326, 125, 209, 153);
		add(calendar);
		
		JLabel lblIngresarProteinas_1 = new JLabel("Ingresar proteinas: ");
		lblIngresarProteinas_1.setBounds(72, 128, 125, 14);
		add(lblIngresarProteinas_1);
		
		tfProteinas = new JTextField();
		tfProteinas.setBounds(190, 125, 86, 20);
		add(tfProteinas);
		tfProteinas.setColumns(10);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.setBounds(145, 199, 131, 43);
		btnIngresar.addActionListener(this);
		add(btnIngresar);
		setVisible(true);
	}
	
	private boolean toInt (String entrada){
		
		
		try{	
			 @SuppressWarnings("unused")
			int numero = Integer.parseInt(entrada); 
	     
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
	

	public void actionPerformed(ActionEvent e){

		Object evento = e.getSource();
		
		if (evento == btnIngresar){
			
			if (comprobarCondiciones()){
				
				System.out.println(tfProteinas.getText());
				System.out.println(calendar.getDate());
			}
		}
	}
}
