package es.maestredam.ejemplo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Streams1App {

	public static void main(String[] args) {
		// LECTURA - CARACTERES (la fuente es el TECLADO)
		//Elijo la clase InputStreamReader
		
		int car = '?';
		try {
			// 1) Creo el Stream adecuado:
			InputStreamReader streamTeclado = new InputStreamReader (System.in);
			
			// 2) Creo el Stream adecuado
			car = streamTeclado.read();
			
			// 3) Cierro stream:
			streamTeclado.close();
			
		}catch (IOException ioe) {
			System.out.println("ERROR E/S: "+ioe);
		}
		
		System.out.printf("Has tecleado %c %n",car);
		
//=====================================================================================
		//EJERCICIO: Leer el primer carácter de un fichero de texto
		
		
		try {
			FileReader streamFichero = new FileReader ("prueba");
			
			car = streamFichero.read();
			
			streamFichero.close();
			
		}catch (IOException ioe) {
			System.out.println("ERROR E/S: "+ioe);
		}
		
		System.out.printf("El primer caracter es %c %n",car);
		
		
		
		//EJERCICIO 2: Mostrar en consola todos los 3 primeros caracteres de un fichero de texto	

		StringBuffer sb = new StringBuffer();
		
		try {
			FileReader streamFichero = new FileReader ("prueba");
			
			
			//Leo tres caracteres
			for(int i=0; i<3; i++) {
			car = streamFichero.read();
			
			//Añado el caracter
			sb.append((char)car);
			}
			streamFichero.close();
			
		}catch (IOException ioe) {
			System.out.println("ERROR E/S: "+ioe);
		}
		
		System.out.printf("Los tres primeros carateres son " + sb.toString());
		
		
		
		
//==========================================================================================
		
		//EJERCICIO 3: Mostrar en consola todos los caracteres de un fichero de texto	
		
		final int EOF=-1;
		try {
			FileReader streamFichero = new FileReader ("prueba");
			
			//Leo el fichero completo, mostrando en consola cada caracter
			System.out.printf("%n----------------------%n");
			car = streamFichero.read();
			while (car != EOF) {
				System.out.printf("%c", car);
				car = streamFichero.read();				

			}
			System.out.printf("%n----------------------%n");
			streamFichero.close();
			
		}catch (IOException ioe) {
			System.out.println("ERROR E/S: "+ioe);
		}
		finally {
			// Se ejecuta SIEMPRE (Haya o no excepción)
		}
		
		
		
		int car2 = '?';
		//4) Uso tri-with-resources para que se cierren automaticamnete los "recursos" abiertos, por ej. un fichero
		
		
		try(FileReader streamFichero = new FileReader ("preba")) {
			System.out.println("Fichero abierto");
			
			//Operaciones de lectura
			car2 = streamFichero.read();
			
			
		}catch (FileNotFoundException fnf) {
			System.out.println("ERROR E/S: Fichero no encontrado");
	
		}catch (IOException ioe) {
			System.out.println("ERRO E/S" +ioe);
		}
			
		
		
		System.out.println("Fichero cerrado");
		//System.out.printf("El primer caracter es %c %n", car);
		
		
		
		
		
		
		
		
	}

}
