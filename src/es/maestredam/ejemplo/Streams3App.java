package es.maestredam.ejemplo;


import java.io.BufferedReader;

import java.io.BufferedWriter;

import java.io.FileReader;

import java.io.FileWriter;

import java.io.IOException;
import java.time.LocalDateTime;



public class Streams3App {

	public static void main(String[] args) {

		
		// EJEMPLO: BufferedReader

		// Mostrar la primera linea de un fichero de texto.

		final String FICHERO = "prueba";

		try (FileReader fichero = new FileReader(FICHERO);

		BufferedReader br = new BufferedReader(fichero)) {


		// Muestra solo la primera linea ¿y si solo mostrar la 2º linea?

		String linea = br.readLine();

		linea = br.readLine();

		System.out.println("2º"+linea);

		if(linea != null) {

		System.out.println("3º"+linea);

		}else {

		System.out.println("3º NO HAY");

		}

		//EJERCICIO: Contar las palabras de la 2ºlinea

		int cPals=0;

		String [] palabras = linea.split("\\s+");

		cPals = palabras.length;

		System.out.printf("Nº Caracteres %d%n",linea.length());

		System.out.printf("Nº Palabras: %d%n",cPals);

		} catch (IOException ioe) {

		System.out.println("ERROR E/S:" + ioe);

		}

		//EJEMPLO: BufferesWriter

		//Escribir varias lineas de texto

		try(

		BufferedWriter bw = new BufferedWriter(new FileWriter("index.html"))){
			System.out.println("Generando html...");

		bw.write("<ul>");

		bw.newLine();

		bw.write("<li>Item 2</li>");

		bw.newLine();

		bw.write("<ul>");

		bw.newLine();

			System.out.println("[Hecho]");

		}catch(IOException ioe) {

		System.out.println("ERROR E/S:"+ioe);

		}

		//EJERCICIO: Hacer una copia excata del fichero index.html 
		// y añadirle al final un footer con el nº total de lineas 
		// y de caracteres, la fecha actual y vuestro nombre

		
		
		   try (BufferedReader br = new BufferedReader(new FileReader("index.html"));
		             BufferedWriter bw = new BufferedWriter(new FileWriter("index_copia.html"))) {
			   
			   System.out.println("Copiando index.html...");
			   
			   String linea;
			   LocalDateTime fecha = LocalDateTime.now();
	            int totalLineas = 0;
	            int totalCaracteres = 0;

	            while ((linea=br.readLine()) != null) {
	                bw.write(linea);
	                bw.newLine();
	                totalLineas++;
	                totalCaracteres += linea.length();
	            }
	            
	            bw.write("<footer>");
	            bw.newLine();
	            bw.write("<hr>");
	            bw.newLine();
	            bw.write("Total de líneas: " + totalLineas);
	            bw.newLine();
	            bw.write("Total de caracteres: " + totalCaracteres);
	            bw.write("<br> " +fecha);
	            bw.newLine();
	            bw.write("</footer>");
	            
	            System.out.println("[HECHO]");
	            

			}catch(IOException ioe) {

			System.out.println("ERROR E/S:"+ioe);

			}
	            
			   
			   

		
	}

}
