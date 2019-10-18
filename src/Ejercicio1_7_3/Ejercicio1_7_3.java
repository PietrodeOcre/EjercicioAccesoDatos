package Ejercicio1_7_3;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Ejercicio1_7_3 {
	
	public static void main(String[] args) {
		leer();
	}
	

	public static void leer() {
		try {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			File file = new File("/home/pietrodeocre/eclipse/EjerciciosAD/src/Ejercicio1_7_3/Empleados.xml");
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
	
	public static void recorrerRamaDom(Node nodo) {
		System.out.println("Elemento raiz: "+ 
				nodo.getNodeName());
		//crea una lista con todos los nodos empleado  
		NodeList empleados = ((Document) nodo).getElementsByTagName("empleado");      
		System.out.printf("Nodos empleado a recorrer: %d %n", 
				empleados.getLength());

		//recorrer la lista  
		for (int i = 0; i < empleados.getLength(); i ++) {
			Node emple = empleados.item(i); //obtener un nodo empleado
			if (emple.getNodeType() == Node.ELEMENT_NODE) {//tipo de nodo
				//obtener los elementos del nodo           
				Element elemento = (Element) emple;	
				System.out.println("Apellido = "+elemento.getElementsByTagName("nombre").item(0).getTextContent());
			}
		}
	}
}

