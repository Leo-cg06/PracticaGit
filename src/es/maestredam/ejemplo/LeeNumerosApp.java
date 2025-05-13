package es.maestredam.ejemplo;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LeeNumerosApp {
	public static void main(String[] args) {
		

		
		final String FICHERO = "numeros.dat";

		
		System.out.printf("Contenido de %s%n", FICHERO);
		try (
				DataInputStream dis = new DataInputStream(
						new FileInputStream(FICHERO))
				){
		
			//LEO LOS 6 VALORES QUE HE ESCRITO
			//Debo controlar EOFException
			while (true) {	
				double valor = dis.readDouble();			
					System.out.printf("%f%n",valor);
				}
			
		}catch (FileNotFoundException fnf) {
			System.out.printf("%s no encontrado",FICHERO);
			
		}catch (EOFException eof) {
				System.out.println("[FIN]");
			
		}catch (IOException ioe) {
			System.out.println("ERROR E/S: "+ioe);
		}
		
	
	}
}
