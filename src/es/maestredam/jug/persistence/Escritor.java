package es.maestredam.jug.persistence;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import es.maestredam.jug.model.Persona;


/**
 * Clase que permkte crear objetos "Escritor". Estos objetos podrán escribir objetos Persona en fichero
 */

public class Escritor {

	private String filename;
	
	public Escritor(String filename) {
		this.filename = filename;
	}
	
	public void escribir(Persona persona) {
		ArrayList<Persona> listaDeUno = new ArrayList<>();
		listaDeUno.add(persona);
		escribir(listaDeUno);
	}
	
	
	/**
	 * Escribe en un fichero en conjunto de objetos dados en lista
	 * 
	 * @param lista lista de objetos
	 */
		
		public void escribir(ArrayList<Persona> lista) {
			
			 try (ObjectOutputStream fichero = new ObjectOutputStream(new FileOutputStream(filename))) {
				 
				//Recorro la lista y escribe cada objeto
	            for (Persona persona : lista) {
	                fichero.writeObject(persona);
	            }
		        System.out.println("Objetos escritos");
		                
		     }catch (FileNotFoundException fnf) {
			            System.out.println("Archivo no encontrado");
			            
		  
		     }catch (EOFException eof) {
		    	 	System.out.println("Fin del archivo alcanzado");

			            
		     } catch (IOException ioe) {
			            System.out.println("Error de E/S: " + ioe);;
			      }
			
		
	
		}
}
