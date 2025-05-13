package es.maestredam.jug.views;

import java.util.ArrayList;

import es.maestredam.jug.model.Persona;
import es.maestredam.jug.persistence.Escritor;
import es.maestredam.jug.persistence.Lector;

/**
 * App que crea un objeto Persona y lo guarda en un fichero
 * Despues lo recupera (lo lee) del fichero y lo guarda en otra referencia distinta
 * 
 * utiliza las clases de "persistencia" creadas
 */
public class PersonaConsoleApp {
	
    public static void main(String[] args) {
    	
    	Persona p = new Persona("Ana", true, 2000);
    	
    	//Guardo el objeto
    	Escritor escritor = new Escritor("personas.dam");
    	escritor.escribir(p);
    	
    	//Leo el objeto
    	Lector lector = new Lector("personas.dam");
    	Persona pLeido = lector.leerPrimero();
    	
    	
    	
    	System.out.println(p.getNombre());
    	System.out.println(pLeido.getNombre());
    	
    	Persona n = new Persona("Nico",false,1000);
    	Persona r = new Persona("Juan",true,200);    	
    	
    	//Guardo varios objetos a la lista
    	ArrayList<Persona> listaPersonas = new ArrayList<>();
    	listaPersonas.add(p);
    	listaPersonas.add(n);
    	listaPersonas.add(r);
    	escritor.escribir(listaPersonas);
    	
    	//Recupero los objetos guardados
    	ArrayList<Persona> listaLeida = lector.leer();
    	for(Persona per:listaLeida) {
    		System.out.println(per);
    	}
    	

    	
    	
    }

}
