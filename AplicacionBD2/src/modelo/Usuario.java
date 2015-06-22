package modelo;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

import org.jasypt.util.text.BasicTextEncryptor;


public class Usuario {
	
	//nombre del usuario, debe ser unico
	private String nombre;
	
	//contraseña se guarda encriptada
	private String contraseña;
	
	//instanciar como TreeMap o SortedMap
	private Map<Date, Integer> proteinas = new TreeMap<Date, Integer>();
	
	//encriptador de contraseña
	BasicTextEncryptor encriptador = new BasicTextEncryptor();
	
	public Usuario (String nombre, String contraseña){
		this.setNombre(nombre);
		this.setContraseña(contraseña);
	}
	
	public Usuario (String nombre){
	    
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getContraseñaDesencriptada() {
		return encriptador.decrypt(contraseña);
	}
	
	public String getContraseñaEncriptada(){
		return contraseña;
	}
	
	public void setContraseña(String contraseña) {
		encriptador.setPassword(contraseña);
		contraseña = encriptador.encrypt(contraseña);
		this.contraseña = contraseña;
	}
	
	public Map<Date, Integer> getProteinas() {
		return proteinas;
	}
	
	public void setProteinas(Date fecha, int proteinas) {
		this.proteinas.put(fecha, proteinas);
	}

	public String toString() {
	    	return "Usuario [nombre=" + nombre + ", contraseña=" + contraseña + ", proteinas=" + proteinas
	    		+ "]";
	}
}
