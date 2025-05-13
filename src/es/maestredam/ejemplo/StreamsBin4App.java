package es.maestredam.ejemplo;
import java.io.*;
import java.util.ArrayList;

public class StreamsBin4App {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        String FICHERO = "personas.dat";
        ArrayList<Persona> personas = new ArrayList<>();

        //Recupero los objetos del fichero y los muestro. ¿Ha cambiado algo?
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FICHERO))){
            int cantidad = ois.readInt();

            for (int i = 0; i < cantidad; i++) {
                personas.add((Persona) ois.readObject());
            }

            for(Persona p : personas){
                System.out.println(p);
            }
        }
        catch(ClassNotFoundException cnf) {
            System.out.println("ClassNotFoundException: Clase errónea");
            throw cnf;
        }
        catch(FileNotFoundException fnf){
            System.out.println("Archivo no encontrado");
        }
        catch(IOException ioe){
            throw ioe;
        }
    }
}

