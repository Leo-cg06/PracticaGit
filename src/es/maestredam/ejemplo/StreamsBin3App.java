package es.maestredam.ejemplo;
import java.io.*;

public class StreamsBin3App {
    public static void main(String[] args) {
        Persona p1 = new Persona("Juan",false,4.3);
        Persona p2 = new Persona("Laura", true, 24.03);
        Persona p3 = new Persona("Pedro", false, 0);
        Persona p4 = new Persona("Luisa",true,12.2);
        final String FICHERO = "personas.dat";

        Persona[] personas = {p1, p2, p3, p4};

        System.out.println("Escribiendo");

        //Uso ObjectOutputStream para guardar los objetos en un fichero
        //ObjectOutputStream es stream de escritura de datos binarios (Objetos)
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FICHERO))){
            oos.writeInt(personas.length);
            for (Persona p : personas) {
                oos.writeObject(p);
            }
            System.out.println("Terminado");
        } catch (FileNotFoundException fnf) {
            System.out.println("Archivo no encontrado");
        } catch (IOException ioe) {
            System.out.println("Error de E/S: " + ioe);;
        }
        for(Persona p : personas){
            p = null;
        }
        //Da prioridad al recolector de basura (opcional en este caso)
        //System.gc();
    }
}

