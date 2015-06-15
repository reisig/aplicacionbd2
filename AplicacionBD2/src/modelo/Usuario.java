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
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getContraseña() {
		BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
		return textEncryptor.decrypt(contraseña);
	}
	
	public void setContraseña(String contraseña) {
		BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
		this.contraseña = textEncryptor.encrypt(contraseña);
	}
	
	public Map<Date, Integer> getCalorias() {
		return calorias;
	}
	
	public void setCalorias(Map<Date, Integer> calorias) {
		this.calorias = calorias;
	}
	
	
}
