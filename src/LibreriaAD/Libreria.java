package LibreriaAD;

import java.io.File;
import java.util.Arrays;

public class Libreria {

	public static void main(String[] args) {
		
		listaFicherosdirectorios();
        
	}

	private static void listaFicherosdirectorios() {
		System.out.println("Ficheros en el directorio actual:");
        File f = new File(".");  //Del directorio actual desde el cual se ejecuta el .jar
        String[] archivos = f.list();
        System.out.println(Arrays.toString(archivos));
	}

}
