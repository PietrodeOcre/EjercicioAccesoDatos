package ManuSqlJava;

import java.security.cert.PKIXRevocationChecker.Option;
import java.util.Arrays;
import java.util.Scanner;

public class MenuMain {

	public static void main(String[] args) {

		menu();

	}

	public static void menu() {
		int opt = 0;
		Scanner sc = new Scanner(System.in);
		while (opt != 10) {

			System.out.println("Menú del ejercicio AD_PR4");
			System.out.println("-------------------------");
			System.out.println("");
			System.out.println("Opción 1");
			System.out.println("Opción 2");
			System.out.println("Opción 3");
			System.out.println("Opción 4");
			System.out.println("Opción 10(salir)");
			System.out.println("");
			System.out.println("Elige una opción: ");
			
			opt = sc.nextInt();
			if(opt == 1) {
				LeeXMLyMuestra.leer();
				LeeXMLyMuestra.muestra(LeeXMLyMuestra.getLibroList());
				/*
				 * Esta linea está comentada por que la use para crear la 
				 * tabla de la base de datos antes de ejecutar la segunda instruccion
				 * si va a ejecutar este programa por primera vez debe 
				 * descomentarla.
				 */
				SqlServerCrud.crearTablasLibreria();
				SqlServerCrud.insertarRegistroUnicoCatalogoLibros(LeeXMLyMuestra.getLibroList());
				SqlServerCrud.consultaDatosLibreria();
				
				
			}else if(opt == 2) {
				
				//SqlServerCrud.crearTablasSubasta();
				//SqlServerCrud.insertarDatosSubasta();
				//System.out.println(Arrays.asList(SqlServerCrud.consultaDatosSubasta()));
				CrearSubastasXml.creador(SqlServerCrud.consultaDatosSubasta());
				
				
			}else if(opt == 3) {
				
				ConsultaSubastaXML.consulta();
				
			}else if(opt == 4) {
				
				SqlServerCrud.consulta();
				
			}else {
				System.out.println("Debe elegir una de las opciones del menú!");
			}
			
			
		}
		System.out.println("Programa Terminado....");
		sc.close();
	}

}
