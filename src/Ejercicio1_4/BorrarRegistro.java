package Ejercicio1_4;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class BorrarRegistro {
	
	public static File fichero = new File("/home/pietrodeocre/eclipse/EjerciciosAD/src/Ejercicio1_3/AleatorioEmple.dat");
	
	private static Integer iD1;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Borramos el registro
		borraRegistro();
		//Mostramos solo los registros eliminados
		mostrarEliminados();

	}
	
	/*
	 * Metodo que borra un empeado 
	 */
	public static void borraRegistro() {
		
		try {
		   //declara el fichero de acceso aleatorio
		   RandomAccessFile file = new RandomAccessFile(fichero, "rw");
		   //
		  
		   int registro = existePersona()  ;//id a modificar
		   StringBuffer buffer = null;//buffer para almacenar apellido
		   long posicion = (registro -1 ) * 36; //(4+20+4+8)  modifico 
		   //posicion=posicion+4+20; //sumo el tama�o de ID+apellido
		   file.seek(posicion); //nos posicionamos 
		   
		   file.writeInt(-1); //uso i+1 para identificar empleado
			buffer = new StringBuffer( iD1.toString() );      
			buffer.setLength(10); //10 caracteres para el apellido
			file.writeChars(buffer.toString());//insertar apellido
			file.writeInt(0);       //insertar departamento
			file.writeDouble(0);//insertar salario
		   file.close();  //cerrar fichero 
		}catch (Exception e) {
			// TODO: handle exception
		}  finally {
			System.out.println("Usuario eliminado.");
		}
		
		
	}
	
	/*
	 * Pregunta el numero de id del empleado y si no 
	 * existe nos lo indica con un mensaje
	 */
	public static int existePersona() {

		Scanner scanner = new Scanner(System.in);
		//mostramos un mensaje para dar a elegir entre el numero de registros
		System.out.println("Escribe un numero de id de empleado de (1 a "+LeerNumeroRegistrosFicheroAleatorio()+"): ");
		int apuntoAID = scanner.nextInt();//Pedimos el dato por teclado
		if((apuntoAID>0) && (apuntoAID<LeerNumeroRegistrosFicheroAleatorio()+1)) {
			iD1 = apuntoAID;//Comprobamos si está dentro del rango de numero de registros
		}else {
			System.out.println("El id no existe.");
			iD1 = null;//Si no lo está provocamos una excepcion que luego controlamos y ponstramos un mensaje
		}
		return iD1; //El metodo devuelve el id que introduce el usuario si es correcto
	}


	/*
	 * Abre el archivo y lee el numero de registros de un fichero 
	 * aleatorio y nos devuelve el numero de registros que contiene
	 */
	public static int LeerNumeroRegistrosFicheroAleatorio() {

		

		int numRegistros = 0;

		try {
			RandomAccessFile file = new RandomAccessFile(fichero, "r");

			int  id, posicion; 

			try {
				posicion = 0;  //para situarnos al principio

				for(;;){  //recorro el fichero

					file.seek(posicion); //nos posicionamos en posicion
					try {
						id = file.readInt();   // obtengo id de empleado

						if(id >0) {

							numRegistros = id;//Obtendo el ultimo id
						}

						//me posiciono para el sig empleado, cada empleado ocupa 36 bytes
						posicion= posicion + 36;	 

					} catch (EOFException o) {

					}

					//Si he recorrido todos los bytes salgo del for	 	  
					if (file.getFilePointer() == file.length())break;

				}
				file.close();//Cerramos el archivo
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}catch (Exception is) {
			is.printStackTrace();
		}

		return numRegistros;//Devuelve el numero del registro que se lee

	}
	
	/*
	 * Metodo que muestra todos los ID de empleados que no existen
	 */
	public static void mostrarEliminados() {
		try {
			System.out.println("");
			System.out.println("Listado de ids eliminados. ");
			
			   //declara el fichero de acceso aleatorio
			   RandomAccessFile file = new RandomAccessFile(fichero, "r");
			   //
			   int  id, dep, posicion;    
			   Double salario;	
			   char apellido[] = new char[10], aux; 

			   posicion = 0;  //para situarnos al principio

			   for(;;){  //recorro el fichero
				file.seek(posicion); //nos posicionamos en posicion
				id = file.readInt();   // obtengo id de empleado	  	  
			      
			      //recorro uno a uno los caracteres del apellido
			      for (int i = 0; i < apellido.length; i++) {         
			         aux = file.readChar(); 
			         apellido[i] = aux;    //los voy guardando en el array
			      }

			      //convierto a String el array
			      String apellidos = new String(apellido); 
				dep = file.readInt();        //obtengo dep
			  	salario = file.readDouble(); //obtengo salario
				  
				if(id == -1) {
			        //System.out.printf("ID: %s, Apellido: %s, Departamento: %d, Salario: %.2f %n",id,   apellidos.trim(), dep, salario);     
					System.out.println("");
				System.out.printf("ID: "+ apellidos.trim());
				
				}
				
			      //me posiciono para el sig empleado, cada empleado ocupa 36 bytes
			      posicion= posicion + 36;	 

				//Si he recorrido todos los bytes salgo del for	 	  
			      if (file.getFilePointer() == file.length())break;
			   
			   }//fin bucle for 
			   file.close();  //cerrar fichero 
			   
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
