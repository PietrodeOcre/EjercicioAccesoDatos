package ManuSqlJava;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class CrearSubastasXml {
	public static void main(String args[]) throws IOException{
		
		creador(SqlServerCrud.consultaDatosSubasta());  	
	}

	public static void creador(Subasta[] subasta) throws TransformerFactoryConfigurationError {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		try{
			DocumentBuilder builder = factory.newDocumentBuilder();
			DOMImplementation implementation = builder.getDOMImplementation();
			Document document = implementation.createDocument(null, "Subastas", null);
			document.setXmlVersion("1.0"); 
			System.out.println(subasta.length);
			for(int i = subasta.length-1; i>0; i--) {
				System.out.println(i);
				Element raiz = document.createElement("Subasta"); //nodo empleado
				document.getDocumentElement().appendChild(raiz); 
				
				CrearElemento("IDSUBASTA",new Integer(subasta[i].getIdSubasta()).toString(), raiz, document); 
				//                       
				CrearElemento("FECHA_SUB",subasta[i].getFecha_Sub(), raiz, document); 
					//
				CrearElemento("DIRECTOR_SUB",subasta[i].getDirector_Sub(), raiz, document); 
					//
				CrearElemento("LUGAR",subasta[i].getLugar(), raiz, document); 
					//
				CrearElemento("NLOTES",new Integer(subasta[i].getnLotes()).toString(), raiz, document);
				CrearElemento("NPIEZAS",new Integer(subasta[i].getnPiezas()).toString(), raiz, document);
				CrearElemento("VENTAS_TOTALES",new Integer(subasta[i].getVentaTotal()).toString(), raiz, document);
			}	

			Source source = new DOMSource(document);
			Result result = new StreamResult(new java.io.File("/home/pietrodeocre/eclipse/EjerciciosAD/src/ManuSqlJava/Subastas.xml"));        
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.transform(source, result);
			System.out.println("Archivo creado.");
		}catch(Exception e){
			System.err.println("Error: " + e);
		}
		
	}

	//Inserción de los datos del empleado
	static void  CrearElemento(String datoEmple, String valor, Element raiz, Document document){
		Element elem = document.createElement(datoEmple); 
		Text text = document.createTextNode(valor); //damos valor
		raiz.appendChild(elem); //pegamos el elemento hijo a la raiz
		elem.appendChild(text); //pegamos el valor		 	
	}
}
