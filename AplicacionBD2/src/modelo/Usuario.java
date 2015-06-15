package modelo;
import java.util.Date;
import java.util.Map;

import org.jasypt.util.text.BasicTextEncryptor;


public class Usuario {
	
	//nombre del usuario, debe ser unico
	private String nombre;
	
	//contraseña se guarda encriptada
	private String contraseña;
	
	//instanciar como TreeMap o SortedMap
	private Map<Date, Integer> calorias;
	
	//encriptador de contraseña
	BasicTextEncryptor encriptador = new BasicTextEncryptor();
	
	public Usuario (String nombre, String contraseña){
		this.setNombre(nombre);
		this.setContraseña(contraseña);
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getContraseña() {
		return encriptador.decrypt(contraseña);
	}
	
	public void setContraseña(String contraseña) {
		encriptador.setPassword(contraseña);
		contraseña = encriptador.encrypt(contraseña);
		this.contraseña = contraseña;
	}
	
	public Map<Date, Integer> getCalorias() {
		return calorias;
	}
	
	public void setCalorias(Map<Date, Integer> calorias) {
		this.calorias = calorias;
	}
}
