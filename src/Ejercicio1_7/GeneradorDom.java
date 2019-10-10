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

	public static void main(String[] args) throws DOMException,ParserConfigurationException, IOException, TransformerException {
		
		
		GeneradorDom generadorDom = new GeneradorDom();
		
		generadorDom.generarDocument();
		
		generadorDom.generarXml();
		
		
	}
	
	public GeneradorDom() throws ParserConfigurationException{
		
		DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factoria.newDocumentBuilder();
		document = builder.newDocument();

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

	public void generarXml() throws IOException, TransformerException {
		
		TransformerFactory factoria = TransformerFactory.newInstance();
		Transformer transformer = factoria.newTransformer();
		
		Source source =  new DOMSource(document);
		
		File file = new File("/home/pietrodeocre/eclipse/EjerciciosAD/src/Ejercicio1_7/Empleados.xml");
		
		FileWriter fWriter = new FileWriter(file);
		
		PrintWriter printWriter = new PrintWriter(fWriter);
		
		Result result = new StreamResult(printWriter);
		
		transformer.transform(source, result);
		
	}
	
	
}
