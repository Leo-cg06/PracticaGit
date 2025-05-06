package es.mdc;

import java.io.File;

package es.mdc;

public class TestFUtil {
    public static void main(String[] args) {
        String[] archivos = {
            "index.html",
            "noexiste.",
            "index_copia.html"
            "prueba"

        };

        for (String archivo : archivos) {
            boolean existe = FUtil.existe(archivo);
            System.out.printf("¿Existe el archivo \"%s\"? %b%n", archivo, existe);
        }
    }
}
