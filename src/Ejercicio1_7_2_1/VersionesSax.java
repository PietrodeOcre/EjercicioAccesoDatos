package Ejercicio1_7_2_1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.security.sasl.SaslException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import org.xml.sax.helpers.DefaultHandler;

public class VersionesSax {

	public static void main(String[] args) {
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		try {
			SAXParser saxParser = saxParserFactory.newSAXParser();
			File f = new File("/home/pietrodeocre/eclipse/EjerciciosAD/src/Ejercicio1_7_2_1/alumnos.xml");
			
			VersionHandler defaultHandler = new VersionHandler();
			saxParser.parse(f, defaultHandler);
			
			ArrayList<Alumno> alumnos = defaultHandler.getAlumnos();
			
			for (Alumno alumno : alumnos) {
				System.out.println(alumno);
			}
			
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

}


