package es.maestredam.ejemplo;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class EscribeNumerosApp {

	public static void main(String[] args) {

		
		final String FICHERO = "numeros.dat";
		
		double num = 78.36;
		double[] numeros = {78.36, 79.34, 12.12, 44.44, 99.99, 1234.666666};
		
		//Creo objeto FileOutputStream (filtro para codificar el dato), usando un objeto FileOutputStream
		//como "canal" de salida de tipo Binario
		try (
			DataOutputStream dos = new DataOutputStream(
					new FileOutputStream(FICHERO))
			){
			
			
			//Escribo todos los numeros reales
			//dos.writeUTF(cadena);
			//dos.writeInt(entero);
			//dos.writeDouble(num);
			for (double d: numeros) {
				dos.writeDouble(d);
			}
			
			
		}catch (IOException ioe) {
			System.out.println("ERROR E/S: "+ioe);

		}
		
	
	
	
	
	}

}
