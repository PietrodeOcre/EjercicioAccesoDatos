package Ejercicio1_7;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class GeneradorDom {
	
	private Document document;

	public static void main(String[] args) {				
		Genera();				
	}

	private static void Genera(){
		GeneradorDom generadorDom = new GeneradorDom();		
		generadorDom.generarDocument();		
		generadorDom.generarXml();
	}
	
	public GeneradorDom(){
		try {
			DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factoria.newDocumentBuilder();
			document = builder.newDocument();
		}catch (ParserConfigurationException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void generarDocument() {		
		Element element = document.createElement("Empleados");
		document.appendChild(element);		
		Element nombre = document.createElement("Nombre");
		element.appendChild(nombre);		
		nombre.setAttribute("id", "Manuel");
		Element edad = document.createElement("Edad");
		nombre.appendChild(edad);
	}

	public void generarXml(){		
		try {
			TransformerFactory factoria = TransformerFactory.newInstance();
			Transformer transformer = factoria.newTransformer();
			Source source =  new DOMSource(document);
			PrintWriter printWriter = fichero();
			Result result = new StreamResult(printWriter);
			transformer.transform(source, result);
		}catch (TransformerException ex) {			
		}				
	}

	private PrintWriter fichero(){
		File file=null;
		PrintWriter printWriter = null;
		try {
			file = new File("/home/pietrodeocre/git/EjercicioAccesoDatos/src/Ejercicio1_7/Empleados.xml");
			FileWriter fWriter = new FileWriter(file);
			printWriter = new PrintWriter(fWriter);
		}catch (IOException ex) {	
			System.out.println(ex.getMessage());
		}		
		return printWriter;
	}
	
	
}
