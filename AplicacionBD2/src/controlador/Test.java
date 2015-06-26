package controlador;

import java.awt.EventQueue;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelo.Usuario;
import vista.TestVistaUsuarios;

public class Test {
	
	Conector jedis;
	DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	List<Usuario> listaUsuarios;
	
	public Test(){
	    jedis = new Conector();
	    jedis.conectar();
	}
	
	public void generarUsuarios() throws ParseException{
	    
		Usuario u = null;
		listaUsuarios = new ArrayList();

		for (int i = 1; i <= 100; i++) {
			u = new Usuario("Usuario"+i, "clave"+i);
			System.out.println("SET "+u.getNombre()+","+u.getContraseñaEncriptada()+": "+jedis.set(u.getNombre(), u.getContraseñaEncriptada()));
			for (int j = 0; j < 10; j++) {
				Date fecha = generarFecha();
				int proteinas = (int) (Math.random() * (300 - 100)) + 100;
				u.setProteinas(fecha, proteinas);
				System.out.println("HSET "+u.getNombre()+", "+df.format(fecha)+", "+String.valueOf(u.getProteinas().get(fecha))+": "
									+jedis.hset(df.format(fecha), u.getNombre(), String.valueOf(u.getProteinas().get(fecha))));
				
			}
			listaUsuarios.add(u);
		}	
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
			    	Test test = new Test();
				TestVistaUsuarios frame = new TestVistaUsuarios();
				frame.repaint();
				frame.setVisible(true);
				test.jedis.desconectar();
				test.jedis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	  });
	  
	
	
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