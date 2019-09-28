package FicherosDeDatosBytes;

import java.io.*;
public class LeerFichData {
  public static void main(String[] args) throws IOException {    
	File fichero = new File("FichData.dat");
	DataInputStream dataIS = new
	                  DataInputStream(new FileInputStream(fichero));

   String n;
   int e;

   try {
    while (true) {
        n = dataIS.readUTF(); //recupera el nombre
        e = dataIS.readInt(); //recupera la edad
        System.out.println("Nombre: " + n + 
        		", edad: " + e);        
    }
    }catch (EOFException eo) {}
	
   dataIS.close();  //cerrar stream   
  }
}
