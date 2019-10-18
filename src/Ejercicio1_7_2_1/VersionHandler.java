package Ejercicio1_7_2_1;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class VersionHandler extends DefaultHandler{
	
	private ArrayList<Alumno> alumnos = new ArrayList<>();
	private Alumno alumno;
	private StringBuilder buffer = new StringBuilder();
	
	
	
	public ArrayList<Alumno> getAlumnos() {
		return alumnos;
	}

	public void characters(char[] ch, int start, int length) throws SAXException{
		buffer.append(ch, start, length);
	}
	
	public void endElement(String uri, String localName, String qName)throws SAXException{
		switch (qName) {
		case "nombre":
			alumno.setNombre(buffer.toString());
			break;
		case "edad":
			alumno.setEdad(Integer.parseInt(buffer.toString()));
			break;
		}
	}
	
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException{
		switch (qName) {
		case "alumno":
			alumno = new Alumno();
			alumnos.add(alumno);
			break;
		case "nombre":
		case "edad":
			buffer.delete(0, buffer.length());
			break;
		}
	}
	
}
