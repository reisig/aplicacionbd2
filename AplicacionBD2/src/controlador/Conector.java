package controlador;

import org.jasypt.util.text.BasicTextEncryptor;

import modelo.Usuario;
import redis.clients.jedis.Jedis;

public class Conector {
	
	//host del servidor redis
	public static String host = "127.0.0.1";
	
	//puerto del servidor
	public static int puerto = 6379;
	
	//testeando conector
	public static void main(String[] args) {
		
		//usuario de prueba
		Usuario u = new Usuario ("lucho", "lucho123");
		
		//conexion al host localhost
		Jedis jedis = new Jedis(host, puerto);
		jedis.connect();
		
		//insertar un nuevo usuario
		jedis.set(u.getNombre(), u.getContraseña());
		
		//probando contraseñas encriptadas....
		String contraseña = jedis.get("lucho");
		System.out.println("contraseña sin encriptar: "+contraseña);		
		BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
		textEncryptor.setPassword(contraseña);
		String encriptada = textEncryptor.encrypt(contraseña);
		System.out.println("contraseña encriptada: "+encriptada);
		System.out.println("contraseña desencriptada: "+textEncryptor.decrypt(encriptada));
		
		//desconexion de redis
		jedis.disconnect();
		jedis.close();
		
	}

}
