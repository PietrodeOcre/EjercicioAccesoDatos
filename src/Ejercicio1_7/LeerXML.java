package Ejercicio1_7;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class LeerXML {
	public static void main(String[] args) {

		DocumentBuilderFactory factory =
				DocumentBuilderFactory.newInstance();

		try {	 
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(new File("/home/pietrodeocre/git/EjercicioAccesoDatos/src/Ejercicio1_7/Empleados.xml"));
			document.getDocumentElement().normalize();

			System.out.printf("Elemento raiz: %s %n", 
					document.getDocumentElement().getNodeName());
			//crea una lista con todos los nodos empleado  
			NodeList empleados = document.getElementsByTagName("empleado");      
			System.out.printf("Nodos empleado a recorrer: %d %n", 
					empleados.getLength());

			//recorrer la lista  
			for (int i = 0; i < empleados.getLength(); i ++) {
				Node emple = empleados.item(i); //obtener un nodo empleado
				if (emple.getNodeType() == Node.ELEMENT_NODE) {//tipo de nodo
					//obtener los elementos del nodo           
					Element elemento = (Element) emple;	
					System.out.println("ID =" +elemento.getElementsByTagName("id").item(0).getTextContent());
					System.out.println(" * Apellido = "+elemento.getElementsByTagName("nombre").item(0).getTextContent());
					System.out.println(" * Departamento = "+elemento.getElementsByTagName("dep").item(0).getTextContent());
					System.out.println(" * Salario = "+elemento.getElementsByTagName("salario").item(0).getTextContent());
				}
			}
		} catch (Exception e) 
		{}

	}//fin de main 
}//fin de la clase

