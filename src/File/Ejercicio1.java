package File;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ejercicio1 {
		//Ejercicio creado por Manuel Javier Corral Gonzalez
	public static void main(String[] args) {
		// Creamos un objeto 
		
		File fil = new File("/home/pietrodeocre/Documentos/GradoSuperior/2DAM/AD/Tema1/Ejercicio2/");
		
		listaDirectorio(fil);
		
		tamanioArchivo(fil,devuelveDirectorio(fil));
		
		System.out.println("");
		
		System.out.println("Contenido del archivo: ");
		
		ArrayList<String> lista = new ArrayList<String>(Arrays.asList(fil.list()));
		
		String rutaString = fil.getAbsolutePath() + "/" + lista.get(0);

		leerArchivoBufferedReader(rutaString);
		
		
	}
	
	//Metodo para devolver ruta de los archivos y directorios de un directorio
	public static List<String> devuelveDirectorio(File fil) {
		
		//Sacamos la información de la lista de archivos que existe en el directorio
		List<String> listadoArchivos = new ArrayList<>(Arrays.asList(fil.list()));
		
		//Devolvemos la lista
		return listadoArchivos;

	}
	
	
	//Metodo para listar archivos y directorios de un directorio
	public static void listaDirectorio(File fil) {
		
		System.out.println("Lista de archivos en el directorio: " + fil.getAbsolutePath() + " : ");
		
		//Mostramos la lista de archivos y drectorios
		System.out.println(Arrays.toString(fil.list()));
		
		System.out.println(" ");
	
	}
	
	//Metodo que nos dice el tamaño del archivo
	public static void tamanioArchivo(File fi, List<String> fil) {
		
		System.out.println("El path y el tamaño de los archivos es: ");
		
		
		
		//Mostramos un string, por cada archivo encontrado en una lista, en el que mostramos el tamaño de un archivo
		for(String string:fil) {
			String holString = fi.getPath()+"/"+string;
			
			System.out.print(holString+": ");
			File arch = new File(holString);
			
			System.out.println(arch.length() +" Bits");
			
		}

	}
	
	
	/*
	 * metodo para leer un archivo con BufferedReader de texto plano
	 */
	public static void leerArchivoBufferedReader (String ruta) {
		
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
		
		System.out.println(cadString);
	}
	

}
