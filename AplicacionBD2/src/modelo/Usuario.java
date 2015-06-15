package modelo;
import java.util.Date;
import java.util.Map;

import org.jasypt.util.text.BasicTextEncryptor;


public class Usuario {
	
	//nombre del usuario, debe ser unico
	private String nombre;
	//contrase�a se guarda encriptada
	private String contrase�a;
	//instanciar como TreeMap o SortedMap
	private Map<Date, Integer> calorias;
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getContrase�a() {
		BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
		return textEncryptor.decrypt(contrase�a);
	}
	
	public void setContrase�a(String contrase�a) {
		BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
		this.contrase�a = textEncryptor.encrypt(contrase�a);
	}
	
	public Map<Date, Integer> getCalorias() {
		return calorias;
	}
	
	public void setCalorias(Map<Date, Integer> calorias) {
		this.calorias = calorias;
	}
	
	
}
