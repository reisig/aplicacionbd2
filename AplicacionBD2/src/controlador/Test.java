package controlador;

import java.awt.EventQueue;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.AbstractListModel;

import org.jasypt.util.text.BasicTextEncryptor;

import vista.TestVistaUsuarios;
import modelo.Usuario;

public class Test {
	
	Conector c;
	DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	static List<Usuario>     usuarios = new LinkedList<Usuario>();
	
	public void generarUsuarios() throws ParseException{
		
		c = new Conector();
		c.conectar();
		c.flushAll();
		Usuario u = null;

		for (int i = 1; i <= 100; i++) {
			u = new Usuario("Usuario"+i, "clave"+i);
			System.out.println("SET "+u.getNombre()+","+u.getContraseñaEncriptada()+": "+c.set(u.getNombre(), u.getContraseñaEncriptada()));
			for (int j = 0; j < 10; j++) {
				Date fecha = generarFecha();
				int proteinas = (int) (Math.random() * (300 - 100)) + 100;
				u.setProteinas(fecha, proteinas);
				System.out.println("HSET "+u.getNombre()+", "+df.format(fecha)+", "+String.valueOf(u.getProteinas().get(fecha))+": "
									+c.hset(df.format(fecha), u.getNombre(), String.valueOf(u.getProteinas().get(fecha))));
				
			}
			usuarios.add(u);
		}
		c.desconectar();
		c.close();		
	}
	
	public Date generarFecha() throws ParseException{
		int dia = (int) (Math.random() * (31 - 1)) + 1;
		int mes = (int) (Math.random() * (12 - 1)) + 1;
		int año = 2015;
		if( dia>28 && mes==2)
			dia=28;
				
		return df.parse(dia+"/"+mes+"/"+año);
	}
	

	
	
	public static void main(String[] args) throws ParseException {
	  
	  
	  
	  EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
			    	Conector c = new Conector();
			    	c.conectar();
			    	c.flushAll();
			    	Test t = new Test();
		                t.generarUsuarios();
				TestVistaUsuarios frame = new TestVistaUsuarios();
				c.disconnect();
				c.close();
				frame.repaint();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
	  
//	  EventQueue.invokeLater(new Runnable() {
//        public void run() {
//            try {
//                MainFrame frame = new MainFrame();
//                Test t = new Test();
//                t.generarUsuarios();
//                String[] nombres = new String[usuarios.size()];
//                for (int i = 0; i < usuarios.size(); i++) {
//                  nombres[i] = usuarios.get(i).getNombre();                 
//                }
//                frame.getListUsuarios().setModel(new AbstractListModel() {
//                  String[] values = nombres;
//                  public int getSize() {
//                    return values.length;
//                  }
//                  public Object getElementAt(int index) {
//                    return values[index];
//                  }
//                });
//                frame.setVisible(true);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    });
		
	  

	    
	
		
		
	
//		//usuario de prueba
//		Usuario u = new Usuario ("lucho", "lucho123");
//		
		//conexion al host localhost
//		Conector c = new Conector();
//		c.conectar();		
		
//		
//		//borrar todo, usar con cuidado!!!!!
//		c.flushAll();
//		
//		//insertar un nuevo usuario, solo si este no existe!!
//		if(!c.exists(u.getNombre()))
//			c.set(u.getNombre(), u.getContraseñaEncriptada());		
//		
//		//contraseñas encriptadas....
//		//BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
//		//textEncryptor.setPassword(u.getContraseñaDesencriptada());
//		//String desencriptada = textEncryptor.decrypt(u.getContraseñaEncriptada());		
//		
//		//probando insercion 
//		//obtener fecha actual
//		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
//		Date date = new Date();
//		
//		//cantidad de proteinas arbitrario
//		int cantProteinas = 100;
//		
//		//insertar los datos al objeto Usuario
//		u.setProteinas(date,cantProteinas);
//		
//		//obtener los datos a partir del usuario
//		Map<Date, Integer> map = u.getProteinas();
//		
//		
//		//valores a insertar
//		String fecha = df.format(date);		
//		String nombre = u.getNombre();
//		String proteina = String.valueOf(map.get(date));
//		//int proteina = map.get(date);
//
//		//insertar como HashSet
//		//clave fecha, campo nombre, valor proteina
//		c.hset(fecha, nombre, proteina);
//		
//		//probando salida
//		//obtener proteinas de la fecha x, usuario y
//		String salida = c.hget(df.format(date),u.getNombre());
//		System.out.println("Proteinas usuario: "+nombre+"; fecha: "+fecha+": "+salida);
//		
//		//desconexion de redis
//		c.desconectar();
//		c.close();
	}
	

}
