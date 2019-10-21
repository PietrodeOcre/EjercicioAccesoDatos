package LibreriaAD;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class MetodosFicheros {

	/*
	 * metodo para leer un archivo con BufferedReader
	 */
	public static void leerArchivoBufferedReader (String ruta) {
		
		FileInputStream fis = null;
		BufferedReader dais = null;
		String cadenaString = null;

		try {
			
			fis = new FileInputStream(ruta);
			dais = new BufferedReader(new InputStreamReader(fis));

			while((cadenaString = dais.readLine()) != null) {
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				dais.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}finally {
				
			}
		}
		
		System.out.println(cadenaString);
	}
	
	/*
	 * metodo para escribir un String en un archivo con BufferedWriter
	 */
	public static void escribirStringArchivoBufferedWriter (String ruta, String cadenaString) {
		
		FileOutputStream fos = null;
		BufferedWriter daos = null;

		try {
			
			fos = new FileOutputStream(ruta);
			daos = new BufferedWriter(new OutputStreamWriter(fos));

			daos.write(cadenaString);

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				daos.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}finally {
				
			}
		}
		
		System.out.println(cadenaString);
		
	}
	
	
	/*
	 * metodo para escribir un array de String en un archivo con BufferedWriter
	 */
	public static void escribirArrayStringArchivoBufferedWriter (String ruta, String[] cadenaString) {
		
		FileOutputStream fos = null;
		BufferedWriter daos = null;

		try {
			
			fos = new FileOutputStream(ruta);
			daos = new BufferedWriter(new OutputStreamWriter(fos));

			for (String string : cadenaString) {
				daos.write(string);
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				daos.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}finally {
				
			}
		}
		
		System.out.println(cadenaString);
		
	}
	
	/*
	 * metodo para leer un archivo con DataInputStream
	 */
	public static void leerArchivoDataInputStream (String ruta) {
		
		FileInputStream fis = null;
		DataInputStream dais = null;
		String cadenaString = null;

		try {
			
			fis = new FileInputStream(ruta);
			dais = new DataInputStream(fis);

			while(dais.available()>0) {
				cadenaString += dais.readUTF();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				dais.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}finally {
				
			}
		}
		
		System.out.println(cadenaString);
	}
	
	/*
	 * metodo para escribir un String en un archivo con DataOutputStream
	 */
	public static void escribirStringArchivoDataOutputStream (String ruta, String cadenaString) {
		
		FileOutputStream fos = null;
		DataOutputStream daos = null;

		try {
			
			fos = new FileOutputStream(ruta);
			daos = new DataOutputStream(fos);

			daos.writeUTF(cadenaString);

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				daos.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}finally {
				
			}
		}
		
		System.out.println(cadenaString);
		
	}
	
	/*
	 * metodo para escribir un array de String en un archivo con DataOutputStream
	 */
	public static void escribirArrayStringArchivoDataOutputStream (String ruta, String[] cadenaString) {
		
		FileOutputStream fos = null;
		DataOutputStream daos = null;

		try {
			
			fos = new FileOutputStream(ruta);
			daos = new DataOutputStream(fos);
			
			for (String string : cadenaString) {
				daos.writeUTF(string);
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				daos.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}finally {
				
			}
		}
		
		System.out.println(cadenaString);
		
	}
	
	/*
	 * Devuelve lista de directorios de un directorio dado
	 */
	public static List<String> obtieneInfoDirectorios(String nombreDirectorio){
		
		List<String> nombreList = new ArrayList<String>();
		
		File filaFile = new File(nombreDirectorio);
		
		if (filaFile.exists()) {
			File[] listaficheros = filaFile.listFiles();
			for (File file2 : listaficheros) {
				if(file2.isDirectory()) {
					nombreList.add(file2.getName());
				}
				
			}
		}	
		return nombreList;
	}
	
	/*
	 * Devuelve lista de ficheros de un directorio dado
	 */
	public static List<String> obtieneInfoFicheros(String nombreDirectorio){
		
		List<String> nombreList = new ArrayList<String>();
		
		File filaFile = new File(nombreDirectorio);
		
		if (filaFile.exists()) {
			File[] listaficheros = filaFile.listFiles();
			for (File file2 : listaficheros) {
				if(file2.isFile()) {
					nombreList.add(file2.getName());
				}
				
			}
		}	
		return nombreList;
	}
	
	/*
	 * Muestra los ficheros de un directorio dado
	 */
	private static void ficherosEnDirectorio(File ruta) {
		if (ruta.exists() && ruta.isDirectory()) {
			File[] listaficheros = ruta.listFiles();
			for (File file2 : listaficheros) {
				System.out.println(file2.getName());
			}
		}
	}
	
	/*
	 * Retira todo lo que no sea letras minusculas, mayusculas o numeros
	 */
	public static String eliminaCaracteresEspeciales(String str) {
		return str.replaceAll("[^a-zA-Z0-9]", "");
	}
	
	/*
	 * Devuelve un Strin con la ruta desde donde se ejecuta nuestro java
	 */
	private static String directorioActual() {
		File miDir = new File(".");
		String ruta ="";
		try {
			System.out.println("Directorio actual: " + miDir.getCanonicalPath());
			ruta = miDir.getCanonicalPath();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ruta;
	}
	
	/*
	 * Crear un directorio en la ruta que le indiquemos, devuelve la ruta completa a dicho directorio
	 * (Funciona en Linux y Windows)
	 */
	public static String crearDirectorioPruebas(String ruta, String directorio) {
		String rutaFinal= ruta+"/"+directorio;		
		File actual = new File(rutaFinal);		
		actual.mkdir();		
		try {
			rutaFinal = actual.getCanonicalPath();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rutaFinal;
	}
	
	/*
	 * Devuelve una lista con las palabras de un archivo
	 */
	public static List<String> tokenizador(String ruta) {

		FileInputStream fis = null;
		BufferedReader dais = null;
		String cadenaString = null;
		StringTokenizer tokenizador = null;
		String tok = null;
		List<String> tokList = null;
		
		try {
			
			fis = new FileInputStream(ruta);
			dais = new BufferedReader(new InputStreamReader(fis));
			tokList = new ArrayList<String>();

			while ((cadenaString = dais.readLine()) != null) {
				
				tokenizador = new StringTokenizer(cadenaString, " ");
				
				while (tokenizador.hasMoreTokens()) {

					tok = tokenizador.nextToken();

					tokList.add(tok);

				}

			}		

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				dais.close();
			} catch (final IOException e2) {
				e2.printStackTrace();
			}finally {
				
			}
		}
		return tokList;
	}
	
	/*
	 * Devuelve una lista con las palabras sin repeticion de un archivo
	 */
	public static Set<String> palabrasUnicas(String ruta) {

		FileInputStream fis = null;
		BufferedReader dais = null;
		String cadenaString = null;
		StringTokenizer tokenizador = null;
		String tok = null;
		Set<String> tokList = null;
		
		try {
			
			fis = new FileInputStream(ruta);
			dais = new BufferedReader(new InputStreamReader(fis));
			tokList = new HashSet<String>();

			while ((cadenaString = dais.readLine()) != null) {
				
				tokenizador = new StringTokenizer(cadenaString, " ");
				
				while (tokenizador.hasMoreTokens()) {

					tok = tokenizador.nextToken();

					tokList.add(tok);

				}

			}		

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				dais.close();
			} catch (final IOException e2) {
				e2.printStackTrace();
			}finally {
				
			}
		}
		return tokList;
	}
	
	
	/*
	 * Método para leer un archivo con BufferedReader que devuelve un mapa
	 */
	public static Map<String, String> leerArchivoBufferedReaderMap(String ruta) {
		
		FileInputStream fis = null;
		BufferedReader dais = null;
		String cadenaString = null;
		Map<String, String> mapaInicial = null;
		StringTokenizer token = null;

		try {
			
			fis = new FileInputStream(ruta);
			dais = new BufferedReader(new InputStreamReader(fis));
			
			mapaInicial = new TreeMap<String, String>();
			String aux1 = "";
			String aux2 = "";

			while((cadenaString = dais.readLine()) != null) {
				token = new StringTokenizer(cadenaString ," \n");
				while (token.hasMoreTokens()) {
					
						aux1 = token.nextToken();
						aux2 = token.nextToken();
						mapaInicial.put(aux1, aux2);
				}
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				dais.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}finally {
				
			}
		}

		return mapaInicial;
	}
	
	/*
	 * metodo para escribir un mapa de String en un archivo con BufferedWriter
	 */
	public static void escribirArrayStringArchivoBufferedWriter (String ruta, Map<String, String> mapa) {		
		FileOutputStream fos = null;
		BufferedWriter daos = null;
		try {			
			fos = new FileOutputStream(ruta);
			daos = new BufferedWriter(new OutputStreamWriter(fos));
			for (Entry<String, String> entry: mapa.entrySet()) {				
				daos.write(entry.getKey() + " "+ entry.getValue() + "\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				daos.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}finally {
				
			}
		}
		//System.out.println(mapaFinal);
	}
	
	/*
	 * Devuelve la última modificacion de un archivo
	 */
	public static String ultimaHora(File ruta) {
		
	    Date fecha = new Date(ruta.lastModified());
	    Calendar calendario = new GregorianCalendar();
	    calendario.setTime(fecha);
	    
	    String dia = Integer.toString(calendario.get(Calendar.DATE));
	    String mes = Integer.toString(calendario.get(Calendar.MONTH));
	    String annio = Integer.toString(calendario.get(Calendar.YEAR));
	    String hora = Integer.toString(calendario.get(Calendar.HOUR_OF_DAY));
	    String minuto = Integer.toString(calendario.get(Calendar.MINUTE));
	    String segundo = Integer.toString(calendario.get(Calendar.SECOND));
	    
	    
	    String horaString = "última modificación a las "+ hora + " horas y "+ minuto + " minutos";
	    
		return horaString;

	}
	
	
	/*
	 * metodo para leer un archivo con BufferedReader que muestra cadenas con un minimo de caracteres
	 */
	public static void leerBufferedReaderMinimoLetras (String ruta) {
		
		FileInputStream fis = null;
		BufferedReader dais = null;
		String cadenaString = null;
		Map<String, Integer> maxCadena = null;
		try {
			
			fis = new FileInputStream(ruta);
			dais = new BufferedReader(new InputStreamReader(fis));

			StringTokenizer cadenaUni;
			maxCadena = new HashMap<String, Integer>();
			String auxString;
			while((cadenaString = dais.readLine()) != null) {
				
				cadenaUni = new StringTokenizer(cadenaString);
				
				while(cadenaUni.hasMoreElements()) {
					
					auxString = cadenaUni.nextToken();
					
					maxCadena.put(auxString, auxString.length());
				}

			}
	
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				dais.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}finally {
				
			}
		}

		System.out.println(maxCadena);
		
		for (Entry<String, Integer> entrada : maxCadena.entrySet()) {

			if (entrada.getValue() >= 4) {
				System.out.println(entrada.getKey());
			}

		}

	}
	
	
	/*
	 * Separa palabras de un archivo creado con BufferedWriter 
	 * por su primer caracter creando dos listas.
	 */
	public static void lectura(String ruta) {
		
		FileInputStream fis =null;
		BufferedReader dais= null;
		List<String> strList = null;
		String string =null;
		StringTokenizer strTokenizer = null;
		List<String> vocales = null;
		List<String> consonantes = null;

		try {
			
			fis = new FileInputStream(ruta);
			dais = new BufferedReader(new InputStreamReader(fis));
			strList = new ArrayList<String>();
			string = "";
			vocales = new ArrayList<String>();
			consonantes = new ArrayList<String>();
			
			while ((string = dais.readLine())!=null) {
				//string = dais.readLine();
				strList.add(string);

			}
			
			
			for (String string2 : strList) {
				strTokenizer = new StringTokenizer(string2);
				String palabraFichero ="";
				String ini="";
				while(strTokenizer.hasMoreTokens()) {
					ini = strTokenizer.nextToken();
					
					if(ini.charAt(0) == 'a'|| ini.charAt(0) == 'e' || ini.charAt(0) == 'i' || ini.charAt(0) == 'o' || ini.charAt(0) == 'u') {
						vocales.add(ini);
					}else {
						consonantes.add(ini);
					}
	
				}
			}
			
			//String ruta1 = "/home/pietrodeocre/Documentos/gradomedio/GradoSuperior/PROG/Tema11/archivosficheros/vocales.txt";
			//String ruta2 = "/home/pietrodeocre/Documentos/gradomedio/GradoSuperior/PROG/Tema11/archivosficheros/consonantes.txt";
			//escribirNuevosFicheros(ruta1, ruta2, vocales, consonantes);

			System.out.println(vocales);
			System.out.println(consonantes);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				dais.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
		
	}
	
	/*
	 * Metodo para renombrar un archivo le damos un fichero
	 * y nos pregunta el nuevo nombre por consola 
	 */
	private static void renombraArchivo(File fil) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Escribe el nuevo nombre con su extensión: ");
		String nombre = scanner.nextLine();
		File f2 = new File(fil.getParentFile()+"/"+nombre);
		fil.renameTo(f2);
	}
	
	/*
	 * Muestra la informacion de un fichero
	 * dado mediante File
	 */
	private static void infoArchivo(File file) {
		System.out.println("INFORMACIÓN SOBRE EL FICHERO:");  
		  if(file.exists()){
		        System.out.println("Nombre del fichero  : "+file.getName());
		        System.out.println("Ruta                : "+file.getPath());
		        System.out.println("Ruta absoluta       : "+file.getAbsolutePath());
		        System.out.println("Solo ruta de archivo: "+file.getParentFile());
		        System.out.println("Se puede leer       : "+file.canRead());
		        System.out.println("Se puede escribir   : "+file.canWrite());
		        System.out.println("Tamaño              : "+file.length());
				System.out.println("Es un directorio    : "+file.isDirectory()); 
				System.out.println("Es un fichero       : "+file.isFile());
				System.out.println("Nombre del directorio padre: "+file.getParent());
		  }
	}
	
}
