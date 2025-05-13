package es.maestredam.jug.persistence;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import es.maestredam.jug.model.Persona;


public class Lector {
	
	private String filename;
	
	Persona objeto = null;
	
	public Lector(String filename) {
		this.filename = filename;
	}

	
	public Persona leerPrimero() {
		  try(ObjectInputStream fichero = new ObjectInputStream(new FileInputStream(filename))){
			 objeto = (Persona)  fichero.readObject();
			  
			  
		  } catch (FileNotFoundException fnf) {
	            System.out.println("Archivo no encontrado");
	            
		  } catch(ClassNotFoundException cnf) {
                System.out.println("ClassNotFoundException: Clase errónea");     
                
		  }catch (EOFException eof) {
                System.out.println("Fin del archivo alcanzado");

	            
	      } catch (IOException ioe) {
	            System.out.println("Error de E/S: " + ioe);;
	      }
		return objeto;
	}
	
	public ArrayList<Persona> leer(){
		
		ArrayList<Persona> lista = new ArrayList<>();
		Persona objeto = null;
		try(ObjectInputStream fichero =
			new ObjectInputStream(new FileInputStream(filename))){
		
			while(true) {
				objeto = (Persona) fichero.readObject();
                lista.add(objeto);
			}
		
            
	     }catch (FileNotFoundException fnf) {
		            System.out.println("Archivo no encontrado");
		            
	     } catch(ClassNotFoundException cnf) {
             System.out.println("ClassNotFoundException:" +cnf); 
	  
	     }catch (EOFException eof) {
	    	 	System.out.println("EOF");

		            
	     } catch (IOException ioe) {
		            System.out.println("Error de E/S: " + ioe);;
		      }
		return lista;
			
		}
		
	}
	
	
	
	

