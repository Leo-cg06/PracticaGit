package es.maestredam.ejemplo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public abstract class Stream2App {

	public static void main(String[] args) {
		//EJERCICIO 1: Copia completa de un fichero
		// 				FileReader => "Canal" de lectura para texto
		//				FileWriter => "Canal" de escritura para texto
		
		 	
		int car = '?';
		
		try(FileReader streamFicheroL = new FileReader ("prueba");
			//De esta manera, si no existe lo crea y si existe lo sobrescribe
			//(Hay un constructor para añadir por el final si existe)
			FileWriter streamFicheroE = new FileWriter ("prueba_copia")){
				
			System.out.println("Fichero abierto");
			System.out.println("Copiando...");
			car = streamFicheroL.read();
			
			while (car != -1) {
                streamFicheroE.write(car);
                car = streamFicheroL.read();
            }


			
		}catch (FileNotFoundException fnf) {
			System.out.println("ERROR E/S: Fichero no encontrado");
	

		}catch (IOException ioe) {
			System.out.println("ERROR E/S");
		}
		System.out.println("FIN");		
		
		
		
		
		
		
		//EJERCICIO 2: Copia completa de un fichero de texto
		//				Transformando a mayúsculas lo que esté en minúsculas y al revés.
		//          -o- Transformando el caracter en el siguiente, es decir,
		// 				A se transforma B, B en C, 0 en 1....
		
		
		int car2 = '?';
		
		try(FileReader entrada = new FileReader ("prueba");
			FileWriter salida = new FileWriter ("prueba_cifrada")){
				
			System.out.println("Fichero abierto");
			System.out.println("Cifrando...");
			car2 = entrada.read();
			
			while (car2 != -1) {
				if(Character.isAlphabetic(car2)) {
					salida.write((car2+1));
				}
                car2 = entrada.read();
            }

		}catch (FileNotFoundException fnf) {
			System.out.println("ERROR E/S: Fichero no encontrado");
	
		}catch (IOException ioe) {
			System.out.println("ERRO E/S" +ioe);
		}
		
	}

}
