package Ejercicio1_7;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class LeeXMLyMuestra {

	public static void main(String[] args) {
		try {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			File file = new File("/home/pietrodeocre/eclipse/EjerciciosAD/src/Ejercicio1_7/Empleados.xml");
			Document document = builder.parse(file);
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
		if(nodo != null) {
			System.out.println("Nombre del nodo: "+ nodo.getNodeName());
			System.out.println("Valor del nodo: "+ nodo.getNodeValue());
			NodeList hijos = nodo.getChildNodes();
			for (int i = 0; i < hijos.getLength(); i++) {
				Node nodoNieto = hijos.item(i);
				System.out.println(" "+hijos.item(i).getTextContent());
				recorrerRamaDom(nodoNieto);
			}
		}
	}

}
