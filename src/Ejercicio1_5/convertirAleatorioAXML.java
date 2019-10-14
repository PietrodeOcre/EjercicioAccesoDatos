package Ejercicio1_5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class convertirAleatorioAXML {
	
	private Document document;
	
	private PrintWriter fichero(){
		File file;
		PrintWriter printWriter = null;
		try {
			file = new File("/home/pietrodeocre/eclipse/EjerciciosAD/src/Ejercicio1_5/Personas.xml");
			FileWriter fWriter = new FileWriter(file);
			printWriter = new PrintWriter(fWriter);
		}catch (IOException ex) {	
			System.out.println(ex.getMessage());
		}		
		return printWriter;
	}
	
	public static List<PersonaXML> listaPersonas() {	
		
		List<PersonaXML> listado = new ArrayList<PersonaXML>();
		
		listado.add(new PersonaXML("Manuel",36));
		listado.add(new PersonaXML("Pedro",22));
		listado.add(new PersonaXML("Miguel",16));
		listado.add(new PersonaXML("Lorenzo",23));
		listado.add(new PersonaXML("Martin",43));
		listado.add(new PersonaXML("Javier",17));
		listado.add(new PersonaXML("Laura",30));
		
		return listado;
	}
	
	private static void Genera(){
		convertirAleatorioAXML generadorDom = new convertirAleatorioAXML();		
		generadorDom.generarDocument();		
		generadorDom.generarXml();
	}
	
	public convertirAleatorioAXML(){
		try {
			DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factoria.newDocumentBuilder();
			
			document = builder.newDocument();
			document.setXmlVersion("1.0");
		}catch (ParserConfigurationException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void generarDocument() {	
		
		Element raiz = document.createElement("personas");
		document.appendChild(raiz);
		
		for (Iterator<PersonaXML> iterator = listaPersonas().iterator(); iterator.hasNext();) {
			PersonaXML empl = (PersonaXML) iterator.next();
			
			Element element = document.createElement("persona");
			raiz.appendChild(element);
			
			Element id = document.createElement("nombre");
			Text idText = document.createTextNode(empl.getNombre());
			element.appendChild(id);
			id.appendChild(idText);
			Element nombre = document.createElement("edad");
			Text nomText = document.createTextNode(String.valueOf(empl.getEdad()));
			element.appendChild(nombre);
			nombre.appendChild(nomText);
		}
		
			
		
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

	
	
	
	public static void main(String[] args) {
		
		
		Genera();
		
		
		
	}
	
	
	
	
}
