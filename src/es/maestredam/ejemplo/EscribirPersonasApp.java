package es.maestredam.ejemplo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class EscribirPersonasApp {

	public static void main(String[] args) {

		final String FICHERO = "persona.dat";
		
			//Crea 3 objetos persona
			Persona p1 = new Persona("Juan",true,1000);
			Persona p2 = new Persona("Ana",true,2000);
			Persona p3 = new Persona("Daniel",false,0);
			
			
			//Muestro los 3 objetos
			System.out.println(p1);
			System.out.println(p2);
			System.out.println(p3);
			
			//Guarda los tres objetos en un fichero
			//Uso ObjectOutputStream => Stream ESCRITURA datos BINARIOS (que son Objetos)
			// con  FileOutputStream => Datos BINARIOS que son Objetos
			try(ObjectOutputStream ficheroPersonas =
			new ObjectOutputStream(new FileOutputStream(FICHERO))){
				ficheroPersonas.writeObject(p1);
				ficheroPersonas.writeObject(p2);
				ficheroPersonas.writeObject(p3);
				
			
			}catch(IOException ioe) {
			System.out.println("ERROR Escritura:"+ioe);
			}
			//Elimino los objetos de memoria
			p1 = null;
			p2 = null;
			p3 = null;
			//Elimino los objetos en memoria
			System.gc();
			//Recupero los objetos del fichero y los nuestro

			try(ObjectInputStream ficheroPersonas =
			new ObjectInputStream(new FileInputStream(FICHERO))){
			//Devuelve un "Object"
				Persona pleido1 = (Persona) ficheroPersonas.readObject();
				Persona pleido2 = (Persona) ficheroPersonas.readObject();
				Persona pleido3 = (Persona) ficheroPersonas.readObject();
				//Muestra los tres objetos
				System.out.println(pleido1);
				System.out.println(pleido2);
				System.out.println(pleido3);
				
			}catch (FileNotFoundException fnfe) {
			System.out.println("FICHERO NO ENCONTRADO");
			
			}catch (ClassNotFoundException e) {
			System.out.println("ERROR Lectura:"+e);
			}catch(IOException ioe) {
				
			System.out.println("ERROR Escritura:"+ioe);
			}
			

			}

}
