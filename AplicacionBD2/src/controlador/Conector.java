package controlador;

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
	    this.conectar();
	    return this.keys("[aA-zZ]*");
	}
	
	
	
}