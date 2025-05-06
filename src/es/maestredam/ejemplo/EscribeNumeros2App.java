package es.maestredam.ejemplo;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Aplicación que genera un fichero con N valores
 * El número de valores esta en el int de la cabecera
 * FORMATO int | double | double | ...  | double |
 */

public class EscribeNumeros2App {

	public static void main(String[] args) {


		final String FICHERO = "numeros_v2.dat";
		double[] numeros = {78.36, 79.34, 12.12, 44.44, 99.99, 1234.666666};

		//Creo objeto FileOutputStream (filtro para codificar el dato), usando un objeto FileOutputStream
				//como "canal" de salida de tipo Binario
				try (
					DataOutputStream dos = new DataOutputStream(
							new FileOutputStream(FICHERO))
					){
					
					
					//Escribo primero la cabecera
					int numDatos= numeros.length;
					dos.writeInt(numDatos);
					//Escribo todos los numeros reales
					for (int i=0; i<numDatos; i++) {
						dos.writeDouble(numeros[i]);
					}
					
					
				}catch (IOException ioe) {
					System.out.println("ERROR E/S: "+ioe);

				}

	}

}
