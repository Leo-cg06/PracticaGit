package es.maestredam.ejemplo;

import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class EscribirPersonasApp {

	public static void main(String[] args) {

		
		final String FICHERO = "personas.dat";
		
		String[] nombre = {"Juan","Adrian","Leo","Pedro"};
		boolean[] mayorEdad = {false, true, true, false};
		double[] saldo = {312.32,200.5,175.3,30.31};
		
		
		
		try (
				DataOutputStream dos = new DataOutputStream(
						new FileOutputStream(FICHERO))
				){
			
				//Escribo los datos
				for(String n: nombre) {
					dos.writeUTF(n);
				}
				
				for(boolean m: mayorEdad) {
					dos.writeBoolean(m);
				}
				
				for(double s: saldo) {
					dos.writeDouble(s);
				}
			
			
		}catch (FileNotFoundException fnf) {
			System.out.printf("%s no encontrado",FICHERO);
			
		}catch (EOFException eof) {
				System.out.println("ERROR INESPERADO '?'");
			
		}catch (IOException ioe) {
			System.out.println("ERROR E/S: "+ioe);
		}
	}

}
