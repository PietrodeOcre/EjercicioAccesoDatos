package Ejercicio1_7;

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
	public static File leerArchivo() {
		File fichero;
		fichero  = new File("/home/pietrodeocre/git/EjercicioAccesoDatos/src/Ejercicio1_7/AleatorioEmple.dat");
		return fichero;	
	}
	
	private PrintWriter fichero(){
		File file;
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
	
	public static List<EmpleadoXML> extraerDatos(File fichero) {		
		RandomAccessFile file;	
		int  id, dep, posicion=0; //para situarnos al principio del fichero        
		Double salario;
		char apellido[] = new char[10], aux;
		List<EmpleadoXML> empleados = new ArrayList<EmpleadoXML>();
		try {
			file = new RandomAccessFile(fichero, "r");
			for(;;) {
				file.seek(posicion); //nos posicionamos 
				id=file.readInt();   // obtengo id de empleado	  	  
				for (int i = 0; i < apellido.length; i++) {
					aux = file.readChar();
					apellido[i] = aux;    
				}   
				String apellidos = new String(apellido);
				dep = file.readInt();
				salario = file.readDouble();  
				if(id>0) { //id validos a partir de 1
					empleados.add(new EmpleadoXML(id, dep, salario, apellidos.trim()));
				}	
				posicion= posicion + 36; // me posiciono para el sig empleado	  	  
				if (file.getFilePointer() == file.length()) break; 
			}//fin del for que recorre el fichero		
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return empleados;
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
		
		Element raiz = document.createElement("empleados");
		document.appendChild(raiz);
		
		for (Iterator iterator = extraerDatos(leerArchivo()).iterator(); iterator.hasNext();) {
			EmpleadoXML empl = (EmpleadoXML) iterator.next();
			
			Element element = document.createElement("empleado");
			raiz.appendChild(element);
			
			Element id = document.createElement("id");
			Text idText = document.createTextNode(String.valueOf(empl.getId()));
			element.appendChild(id);
			id.appendChild(idText);
			Element nombre = document.createElement("nombre");
			Text nomText = document.createTextNode(empl.getApellido());
			element.appendChild(nombre);
			nombre.appendChild(nomText);
			Element dep = document.createElement("dep");
			Text depText = document.createTextNode(String.valueOf(empl.getDep()));
			element.appendChild(dep);
			dep.appendChild(depText);
			Element sal = document.createElement("salario");
			Text salText = document.createTextNode(String.valueOf(empl.getSalario()));
			element.appendChild(sal);
			sal.appendChild(salText);
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
