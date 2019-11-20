package EmbebidasSQLITE;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
	//declaramos fichero
	File fichero = new File("");
	FileReader fic = new FileReader(fichero); // crear el flujo de entrada
	int i;
	while ((i = fic.read()) != -1) // se va leyendo un carácter
	                System.out.println((char) i);
	fic.close(); // cerramos fichero
	}
	

}
