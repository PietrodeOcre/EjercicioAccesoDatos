package LibreriaAD;

import java.io.*;

import com.sun.media.jfxmedia.events.NewFrameEvent;

public class ResumenAD {

	public static void main (String[] args) throws IOException {
		escribirFichero();
	}

	private static void escribirFichero() throws IOException {
		File fichero = new File(".");
		FileWriter fic = new FileWriter(fichero); // crear el flujo de salida
		String cadena = "Esto es una prueba de FileWriter";
		char[] cad = cadena.toCharArray(); //convierte un String a un array de caracteres.
		for (int i=0; i<cad.length; i++) {
			fic.write(cad[i]);  //se va escribiendo un carácter
		}
		fic.append('*'); //añadimos al final un *
		fic.close(); // cerramos el fichero
	}

	private static void leerUnaSolaLinea() {
		try {
			BufferedReader fichero = new BufferedReader (new FileReader("LeerFichTexto.txt"));
			String linea;
			while((linea=fichero.readLine())!= null) {
				// lee una línea del fichero 
				System.out.println(linea);
				fichero.close(); 
			}
		}catch (FileNotFoundException fn) { 
			System.out.println("No se encuentra el fichero");
		}
		catch (IOException io) { System.out.println("Error de E/S");}
	}
	
	public static void escribeFicheroPrint() {
		PrintWriter fichero = null;
		try {
			fichero = new PrintWriter(new FileWriter("NomFich"));
			for (int i=1; 1<11; i++) {
				fichero.println("Fila número: "+i);	
			}		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			fichero.close();
		}	
	}
	
	public static void escribeFicheroBinario() {
		try {
			File fichero = new File(".");
			//crea flujo  de salida hacia elf ichero
			FileOutputStream  fileout = new FileOutputStream(fichero);
			int i;
			for (i=1; i<100; i++)//escribe 100bits
				fileout.write(i); //escribe datos en el flujo de salida
			fileout.close(); // cerrar stream de salida
		}catch (IOException e) {			
		}
	}
	
	public static void leerBinario() {
		try {
			File fichero = new File(".");
			//crea flujo  de entrada
			FileInputStream  filein= new FileInputStream(fichero);
			int i;
			//visualizar los datos del fichero
			while ((i=filein.read()) != -1)  //lee dato del flujo de entrada
				System.out.println(i);
			filein.close();  //cerrar stream de entrada
		}catch (IOException e) {
		}
	}
	
	private static void leerObjeto(){
		try {
			Object object; // defino el objeto
			File fichero = new File("FichPersona.dat");
			ObjectInputStream dataIS = new ObjectInputStream(new FileInputStream(fichero));
			int i = 1;
			try {
				while (true) { // lectura del fichero
					object = dataIS.readObject(); // leer una Persona
					System.out.print(i + "=>");
					i++;
					System.out.println(object.toString());
				}
			} catch (EOFException eo) {
				System.out.println("FIN DE LECTURA.");
			} catch (StreamCorruptedException x) {
			}
			dataIS.close(); // cerrar stream de entrada
		}catch(IOException e) {	
		}catch (ClassNotFoundException b) {
		}
	}
	
	private static void escribeObjeto() {
		try {
			Object[] object; // defino el objeto
			object = new Object[10];
			File fichero = new File("FichPersona.dat");//declara el fichero
			FileOutputStream fileout = new FileOutputStream(fichero,true);  //crea el flujo de salida
			//conecta el flujo de bytes al flujo de datos
			ObjectOutputStream dataOS = new ObjectOutputStream(fileout);  
			System.out.println("GRABO LOS DATOS DEL OBJETO.");      
			for (int i=0;i<object.length; i++){ //recorro los arrays    
				Object objecto= object[i]; //creo el objeto	  
				dataOS.writeObject(objecto); //escribo el objeto en el fichero
				System.out.println("GRABO LOS DATOS DEL OBJETO.");  
			}     //cerrar stream de salida
			dataOS.close();
		}catch (IOException e) {
		}
	}
	
	public static void accesoAleatorioEscritura() {
		try {
			File fichero = new File("AleatorioEmple.dat");
			//declara el fichero de acceso aleatorio
			RandomAccessFile file = new RandomAccessFile(fichero, "rw");
			//Metodo que pida los datos
			Object[] objetos = new Object[3];
			Object objeto1 = new Object();
			Object objeto2 = new Object();
			Object objeto3 = new Object();
			objetos[0] = objeto1;
			objetos[1] = objeto2;
			objetos[2] = objeto3;
			StringBuffer buffer = null;//buffer para almacenar apellido
			int n=objetos.length;//numero de elementos del array
			for (int i=0;i<n; i++){ //recorro los arrays          	  
				file.writeInt(i+1); //uso i+1 para identificar empleado
				buffer = new StringBuffer( (StringBuffer)objetos[i] );      
				buffer.setLength(10); //10 caracteres para el apellido
				file.writeChars(buffer.toString());//insertar apellido
				file.writeInt((int)objetos[i]);       //insertar departamento
				file.writeDouble((double)objetos[i]);//insertar salario
			}     //cerrar fichero 
			file.close();
		}catch (IOException e) {
		}		
	}
	
	public static void LeerFichero() {
		try {
			File fichero = new File("AleatorioEmple.dat");
			//declara el fichero de acceso aleatorio
			RandomAccessFile file = new RandomAccessFile(fichero, "r");
			int id, dep, posicion;    
			Double salario;	
			char apellido[] = new char[10], aux; 
			posicion = 0;  //para situarnos al principio
			for(;;){  //recorro el fichero
				file.seek(posicion); //nos posicionamos en posicion
				id = file.readInt();   // obtengo id de empleado	  	  
				//recorro uno a uno los caracteres del apellido
				for (int i = 0; i < apellido.length; i++) {         
					aux = file.readChar(); 
					apellido[i] = aux;//los voy guardando en el array
				}//Si me quiero saltar alguna lectura solo tengo que 
				//usar Seek para posicionarme mas adelante los bits que sean en el registro.
				//convierto a String el array
				String apellidos = new String(apellido); 
				dep = file.readInt();        //obtengo dep
				salario = file.readDouble(); //obtengo salario
				if(id >0) {
					System.out.printf("ID: %s, Apellido: %s, Departamento: %d, Salario: %.2f %n", id, apellidos.trim(), dep, salario);     
					//me posiciono para el sig empleado, cada empleado ocupa 36 bytes
					posicion= posicion + 36;	 
					//Si he recorrido todos los bytes salgo del for	 	  
					if (file.getFilePointer() == file.length())break;
				}//fin bucle for 
				file.close();//cerrar fichero 
			}
		}catch(IOException e) {	
		}  
	}

	
	
	
	
	
	
	
	
	
	
	
}
