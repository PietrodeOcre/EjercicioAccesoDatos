package ManuSqlJava;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.TreeMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class LeeXMLyMuestra {

	private static Libro[] libroList;
	
	public static void leer() {
		try {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			File file = new File("/home/pietrodeocre/eclipse/EjerciciosAD/src/ManuSqlJava/libreria.xml");
			Document document = builder.parse(file);
			document.getDocumentElement().normalize();
			recorrerRamaDom(document);
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Libro[] recorrerRamaDom(Node nodo) {
		
		System.out.println("Elemento raiz: "+ 
				nodo.getNodeName());
		//crea una lista con todos los nodos empleado  
		NodeList catalogo = ((Document) nodo).getElementsByTagName("libro");      
		System.out.printf("Nodos Libro a recorrer: %d %n", 
				catalogo.getLength());

		libroList = new Libro[catalogo.getLength()];
		
		//recorrer la lista  
		for (int i = 0; i < catalogo.getLength(); i ++) {
			Node libro = catalogo.item(i); //obtener un nodo empleado
			if (libro.getNodeType() == Node.ELEMENT_NODE) {//tipo de nodo
				//obtener los elementos del nodo           
				Element elemento = (Element) libro;	
				
				libroList[i] = new Libro(elemento.getAttribute("id").toString(),
					elemento.getElementsByTagName("autor").item(0).getTextContent(),
					elemento.getElementsByTagName("título").item(0).getTextContent(),
					elemento.getElementsByTagName("género").item(0).getTextContent(),
					elemento.getElementsByTagName("precio").item(0).getTextContent(),
					elemento.getElementsByTagName("fecha").item(0).getTextContent(),
					elemento.getElementsByTagName("descripción").item(0).getTextContent()
						);
				
			}
		}
		return libroList;
	}
	
	public static void muestra(Libro[] libroList) {
		System.out.println(Arrays.asList(libroList));
	}

	public static Libro[] getLibroList() {
		return libroList;
	}

	public static void setLibroList(Libro[] libroList) {
		LeeXMLyMuestra.libroList = libroList;
	}

	
	
}
