package controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;

public class Conector extends Jedis{
	
	//host del servidor redis
	private static String host = "127.0.0.1";
	
	//puerto del servidor
	private static int puerto = 6379;
	
	public Conector(){
		super(host,puerto);
	}
	
	public void conectar(){
		if(!this.isConnected())
			this.connect();
	}
	
	public void desconectar(){
		if(this.isConnected()){
			this.disconnect();
			this.close();
		}
	}
	
	public Set getUsuarios(){
	    return this.keys("[aA-zZ]*");
	}
	
	public List getFechas(String nombreUsuario){
	    Set<String> fechas = this.keys("[0-9]*");
	    List<String> salida = new ArrayList();
	    for (String s : fechas) {
		if(this.hexists(s, nombreUsuario)){
		    salida.add(s);
		}
	    }
	    return salida;
	}
	
	public String getProteinas(String nombre, String fecha){
	    return this.hget(fecha,nombre);    
	}
}