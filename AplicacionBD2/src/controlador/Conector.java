package controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

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
	    this.conectar();
	    return this.keys("[aA-zZ]*");
	}
	
	public List getFechas(String nombreUsuario){
	    Set<String> fechas = this.keys("[0-9]*");
	    Set<String> salida = new TreeSet();
	    for (String s : fechas) {
		List<Map> lista = new ArrayList();
		lista.add(this.hgetAll(s));
	    }
	    return null;

	}
}