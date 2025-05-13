package es.mdc;

public class Applicacion {
	public static void main(String[] args) {
        String[] archivos = {
            "index.html",
            "noexiste.",
            "index_copia.html",
            "   "

        };

        for (String archivo : archivos) {
            boolean existe = FUtil.existe(archivo);
            System.out.printf("¿Existe el archivo \"%s\"? %b%n", archivo, existe);
        }
    }
}
