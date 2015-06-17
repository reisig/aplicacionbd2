package controlador;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import modelo.Usuario;

public class Test {
	
	public static void main(String[] args) {
		//usuario de prueba
		Usuario u = new Usuario ("lucho", "lucho123");
		
		//conexion al host localhost
		Conector c = new Conector();
		c.conectar();
		
		//borrar todo, usar con cuidado!!!!!
		c.flushAll();
		
		//insertar un nuevo usuario, solo si este no existe!!
		if(!c.exists(u.getNombre()))
			c.set(u.getNombre(), u.getContraseñaEncriptada());		
		
		//contraseñas encriptadas....
		//BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
		//textEncryptor.setPassword(u.getContraseñaDesencriptada());
		//String desencriptada = textEncryptor.decrypt(u.getContraseñaEncriptada());		
		
		//probando insercion 
		//obtener fecha actual
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		
		//cantidad de proteinas arbitrario
		int cantProteinas = 100;
		
		//insertar los datos al objeto Usuario
		u.setProteinas(date,cantProteinas);
		
		//obtener los datos a partir del usuario
		Map<Date, Integer> map = u.getProteinas();
		
		
		//valores a insertar
		String fecha = df.format(date);		
		String nombre = u.getNombre();
		String proteina = String.valueOf(map.get(date));
		//int proteina = map.get(date);

		//insertar como HashSet
		//clave fecha, campo nombre, valor proteina
		c.hset(fecha, nombre, proteina);
		
		//probando salida
		//obtener proteinas de la fecha x, usuario y
		String salida = c.hget(df.format(date),u.getNombre());
		System.out.println("Proteinas usuario: "+nombre+"; fecha: "+fecha+": "+salida);
		
		//desconexion de redis
		c.desconectar();
		c.close();
	}

}
