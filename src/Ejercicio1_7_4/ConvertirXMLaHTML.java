package Ejercicio1_7_4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class ConvertirXMLaHTML {
	public static void main(String argv[]) throws IOException{ 
		convertirXMLaHMTL(); 	
	}

	private static void convertirXMLaHMTL() {
		String hojaEstilo = "/home/pietrodeocre/git/EjercicioAccesoDatos/src/Ejercicio1_7_4/alumnosPlantilla.xsl";
		String datosAlumnos = "/home/pietrodeocre/git/EjercicioAccesoDatos/src/Ejercicio1_7_4/alumnos.xml";
		File pagHTML = new File("/home/pietrodeocre/git/EjercicioAccesoDatos/src/Ejercicio1_7_4/mipagina.html");
		FileOutputStream os;
		try {
			os = new FileOutputStream(pagHTML);
			Source estilos =new StreamSource(hojaEstilo); //fuente XSL
			Source datos =new StreamSource(datosAlumnos); //fuente XML
			Result result = new StreamResult(os);         //resultado de la transformaci�n
			try{     
				Transformer transformer =  
						TransformerFactory.newInstance().newTransformer(estilos);   
				transformer.transform(datos, result);	//obtiene el HTML
			}
			catch(Exception e){System.err.println("Error: "+e);}
			try {
				os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} //crear fichero HTML
	}
	
}
