package ManuSqlJava;

import java.io.File;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ConsultaSubastaXML {
	
	public static void consulta() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Consulta por número de Lotes y Lugar.");
		System.out.println("");
		System.out.println("Introduce el número de lote o 0: ");
		int numLote = scanner.nextInt();
		
		System.out.println("Introduce el Lugar o 0: ");
		String lugar = scanner.next();
		if(numLote > 0) {
			consulta2(numLote);
		}
		if(!lugar.equals("0")) {
			consulta2(lugar);
		}
		
		
	}

	public static void consulta2(int lote) {

		DocumentBuilderFactory factory =
				DocumentBuilderFactory.newInstance();

		try {	 
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(new File("/home/pietrodeocre/eclipse/EjerciciosAD/src/ManuSqlJava/Subastas.xml"));
			document.getDocumentElement().normalize();

			System.out.printf("Elemento raiz: %s %n", 
					document.getDocumentElement().getNodeName());
			//crea una lista con todos los nodos empleado  
			NodeList subasta = document.getElementsByTagName("Subasta");      
			System.out.printf("Nodos subasta a recorrer: %d %n", 
					subasta.getLength());

			//recorrer la lista  
			for (int i = 0; i < subasta.getLength(); i ++) {
				
				Node emple = subasta.item(i); //obtener un nodo empleado
				if (emple.getNodeType() == Node.ELEMENT_NODE) {//tipo de nodo
					
					//obtener los elementos del nodo           
					Element elemento = (Element) emple;
					
					if(lote == Integer.valueOf(elemento.getElementsByTagName("NLOTES").item(0).getTextContent())) {
						registro(elemento);
					}
				}
			}
		} catch (Exception e) 
		{}

	}
	
	public static void consulta2(String lugar) {

		DocumentBuilderFactory factory =
				DocumentBuilderFactory.newInstance();

		try {	 
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(new File("/home/pietrodeocre/eclipse/EjerciciosAD/src/ManuSqlJava/Subastas.xml"));
			document.getDocumentElement().normalize();

			System.out.printf("Elemento raiz: %s %n", 
					document.getDocumentElement().getNodeName());
			//crea una lista con todos los nodos empleado  
			NodeList subasta = document.getElementsByTagName("Subasta");      
			System.out.printf("Nodos subasta a recorrer: %d %n", 
					subasta.getLength());

			//recorrer la lista  
			for (int i = 0; i < subasta.getLength(); i ++) {
				
				Node emple = subasta.item(i); //obtener un nodo empleado
				if (emple.getNodeType() == Node.ELEMENT_NODE) {//tipo de nodo
					
					//obtener los elementos del nodo           
					Element elemento = (Element) emple;
					
					if(lugar.toUpperCase().equals(elemento.getElementsByTagName("LUGAR").item(0).getTextContent().toUpperCase().trim())) {
						registro(elemento);
					}
				}
			}
		} catch (Exception e) 
		{}

	}

	public static void registro(Element elemento) {
		System.out.println("ID =" +elemento.getElementsByTagName("IDSUBASTA").item(0).getTextContent());
		System.out.println(" * Fecha = "+elemento.getElementsByTagName("FECHA_SUB").item(0).getTextContent());
		System.out.println(" * Director = "+elemento.getElementsByTagName("DIRECTOR_SUB").item(0).getTextContent());
		System.out.println(" * Lugar = "+elemento.getElementsByTagName("LUGAR").item(0).getTextContent());
		System.out.println(" * Número de lotes = "+elemento.getElementsByTagName("NLOTES").item(0).getTextContent());
		System.out.println(" * Número de piezas = "+elemento.getElementsByTagName("NPIEZAS").item(0).getTextContent());
		System.out.println(" * Venta totales = "+elemento.getElementsByTagName("VENTAS_TOTALES").item(0).getTextContent());
	}
	
	
	
}
