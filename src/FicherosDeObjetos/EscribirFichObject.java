package FicherosDeObjetos;



import java.io.*;

import com.sun.media.jfxmedia.events.NewFrameEvent;

public class EscribirFichObject {
	public static void main(String[] args) throws IOException {   

		escribeObjeto();      
	}

	private static void escribeObjeto() {
		try {
			Object[] object; // defino el objeto
			object = new Object[10];
			File fichero = new File("FichPersona.dat");//declara el fichero
			FileOutputStream fileout = new FileOutputStream(fichero,true);  //crea el flujo de salida
			//conecta el flujo de bytes al flujo de datos
			ObjectOutputStream dataOS = new ObjectOutputStream(fileout);  
			System.out.println("GRABO LOS DATOS DEL OBJETO.");      
			for (int i=0;i<object.length; i++){ //recorro los arrays    
				Object objecto= object[i]; //creo el objeto	  
				dataOS.writeObject(objecto); //escribo el objeto en el fichero
				System.out.println("GRABO LOS DATOS DEL OBJETO.");  
			}     //cerrar stream de salida
			dataOS.close();
		}catch (IOException e) {
		}
	}
	
	
	
}