package File;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MetodosFile {
	
	public static void main(String[] args) {

		//Instanciamos un objeto f de tipo File 
		//para poder hubicar el path absoluto 
		File f = new File("/home/pietrodeocre/Documentos/GradoSuperior/2DAM/AD/Tema1/Ejercicio2/");//Instanciamos un objeto f de tipo File para poder hubicar el path absoluto 
	    
		//metodoFile(f);
		
		
		
	}
	
	/*
	 * metodo para leer un archivo con BufferedReader
	 */
	public static String leerArchivoBufferedReader (String ruta) {
		
		FileInputStream fis = null;
		BufferedReader dais = null;
		String cadenaString = null;
		String cadString = null;
		try {
			
			fis = new FileInputStream(ruta);
			dais = new BufferedReader(new InputStreamReader(fis));

			while((cadenaString = dais.readLine()) != null) {
				cadString = cadenaString.toLowerCase();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				dais.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}finally {
				
			}
		}
		 
		return cadString;
	}
	
	
	
	
	public static void metodoFile(File dir) {
		
		//Obtenemos ruta absoluta
		System.out.println(dir.getAbsolutePath());
		
		//Obtenemos String con el nombre
		System.out.println(dir.getName());
	    
		//Obtenemos el path relativo
		System.out.println(dir.getPath());
		
		//Obtenemos si el archivo o directorio existe
		System.out.println((dir.exists())?"true":"False");
		
		//Obtenemos si el archivo o directorio tiene permisos de escritura
		System.out.println(dir.canWrite());

		//Obtenemos si el archivo o directorio tiene permisos de lectura
		System.out.println((dir.canRead())?"true":"False");
		
		//Obtenemos si es archivo o no
		System.out.println(dir.isFile());
		
		//Obtenemos si es directorio o no
		System.out.println((dir.isDirectory())?"true":"False");
		
		//Obtenemos el tamaño del archivo
		System.out.println(" " +dir.length());
		
		//Obtenemos la fecha de ultima modificacion del archivo
		//En milisegundos desde Enero de 1970
		System.out.println(dir.lastModified());
		
		//Obtenemos el tamaño del archivo
		File direc = new File(dir.getAbsolutePath()+"/directorio");
		System.out.println(" "+direc.mkdir());
		
		
		//Comprobamos que se ha creado
		System.out.println(Arrays.toString(dir.list()));
 		
		//Borramos el directorio creado en el paso anterior
		System.out.println(""+direc.delete());
		
		//Comprobamos que se ha borrado
		System.out.println(Arrays.toString(dir.list()));
		
		

	    
	    
	}
	
}
