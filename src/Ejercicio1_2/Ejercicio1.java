package Ejercicio1_2;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio1 {

	public static void main(String[] args) throws IOException {
		
		File fichero;
		//declarar fichero
		FileReader fic = null;
		
		try {
			fichero  = new File("/home/pietrodeocre/eclipse/EjerciciosAD/src/Ejercicio1_2/Fichero1.txt");
			fic = new FileReader(fichero); //crear el flujo de entrada
			  
			String cad = "";

			int i;
			while ((i = fic.read()) != -1) { //se va leyendo un caracter
				//System.out.println( (char) i + "==>"+ i);
				System.out.print( (char) i);
				cad = cad + (char)i;
			/*  char b[]= new char[5]; 
    		while ((i = fic.read(b)) != -1)	    
			System.out.println(b); 
			 */
				
			}
			System.out.println("");
			System.out.println(cad);
			
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			fic.close(); //cerrar fichero
		}

	}
}
