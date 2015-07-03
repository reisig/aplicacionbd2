package vista;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.swing.AbstractListModel;

import modelo.Strings;
import controlador.Conector;

public class ListasVista {
    
    private Conector conector;
    
    public ListasVista(Conector c) {
	this.conector = c;
    }
    
    public listaDeUsuarios getListaUsuarios(){
	return new listaDeUsuarios();
    }
    
    public listaDeFechas getListaFechas(String nombre){
	return new listaDeFechas(nombre);
    }
    
    public listaDeProteinas getListaProteinas (String nombre, String fecha){
	return new listaDeProteinas(nombre, fecha);
    }
    
    
    class listaDeUsuarios extends AbstractListModel{

	    private static final long serialVersionUID = -7516169186834814283L;
	    private List<String> lista = new ArrayList();
        
            public listaDeUsuarios(){
        	try{
        	    conector = new Conector();
        	    conector.conectar();
        	    lista.addAll(conector.getUsuarios());
        	    conector.desconectar();
        	    conector.close();
        	    Collections.sort(lista, Strings.getNaturalComparator());
        	}catch(Exception e){
        	    System.out.println("Debe estar conectado a la base de datos Redis!!!");
        	}
            }
        
	    public Object getElementAt(int index) {
		return lista.get(index);
	    }

	    public int getSize() {
		return lista.size();
	    }            
    }
    
    class listaDeFechas extends AbstractListModel{
                   
	    private static final long serialVersionUID = -4052141478947131221L;
	    private List<Date> lista = new ArrayList();
        
            public listaDeFechas(String nombreUsuario){
            	try{
            	    conector = new Conector();
            	    conector.conectar();
            	    lista.addAll(conector.getFechas(nombreUsuario));
            	    conector.desconectar();
            	    conector.close();
            	    Collections.sort(lista, new Comparator<Date>(){
        			public int compare(Date o1, Date o2) {
        			    return o1.compareTo(o2);
        			}
            	    });
            	    while(lista.size()>5){
            		lista.remove(0);
            	    }
            	}catch(Exception e){
            	    System.out.println("Debe estar conectado a la base de datos Redis!!!");
            	}
            }            

	    public Object getElementAt(int index) {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		return df.format(lista.get(index));
	    }

	    public int getSize() {
		return lista.size();
	    }           
        
    }
    
    class listaDeProteinas extends AbstractListModel{
        
	    private static final long serialVersionUID = -4052141478947131221L;
	    private List<String> lista = new ArrayList();
        
            public listaDeProteinas(String nombreUsuario, String fecha){
        	try{
        	    conector = new Conector();
        	    conector.conectar();
        	    lista.add(conector.getProteinas(nombreUsuario, fecha));
        	    conector.desconectar();
        	    conector.close();
        	    Collections.sort(lista, Strings.getNaturalComparator());
        	}catch(Exception e){
        	    e.printStackTrace();
        	}
            }            

	    public Object getElementAt(int index) {
		return lista.get(index);
	    }

	    public int getSize() {
		return lista.size();
	    }            
    }

}
