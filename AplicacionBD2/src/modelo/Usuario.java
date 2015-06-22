package modelo;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

import org.jasypt.util.text.BasicTextEncryptor;


public class Usuario {
	
	//nombre del usuario, debe ser unico
	private String nombre;
	
	//contrase�a se guarda encriptada
	private String contrase�a;
	
	//instanciar como TreeMap o SortedMap
	private Map<Date, Integer> proteinas = new TreeMap<Date, Integer>();
	
	//encriptador de contrase�a
	BasicTextEncryptor encriptador = new BasicTextEncryptor();
	
	public Usuario (String nombre, String contrase�a){
		this.setNombre(nombre);
		this.setContrase�a(contrase�a);
	}
	
	public Usuario (String nombre){
	    
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getContrase�aDesencriptada() {
		return encriptador.decrypt(contrase�a);
	}
	
	public String getContrase�aEncriptada(){
		return contrase�a;
	}
	
	public void setContrase�a(String contrase�a) {
		encriptador.setPassword(contrase�a);
		contrase�a = encriptador.encrypt(contrase�a);
		this.contrase�a = contrase�a;
	}
	
	public Map<Date, Integer> getProteinas() {
		return proteinas;
	}
	
	public void setProteinas(Date fecha, int proteinas) {
		this.proteinas.put(fecha, proteinas);
	}

	public String toString() {
	    	return "Usuario [nombre=" + nombre + ", contrase�a=" + contrase�a + ", proteinas=" + proteinas
	    		+ "]";
	}
}
