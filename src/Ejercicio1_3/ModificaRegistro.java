package Ejercicio1_3;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class ModificaRegistro {
	
	public static File fichero = new File("/home/pietrodeocre/eclipse/EjerciciosAD/src/Ejercicio1_3/AleatorioEmple.dat");
	

	//Atributo para guardar el ID
	protected static Integer iD1;

	public static void main(String[] args) {  

		modificarSalario();

	}

	
	
	/*
	 * Metodo para podificar un dato del fichero aleatorio
	 */
	public static void modificarSalario() {
		
		RandomAccessFile file = null;
		int registro;
		try {
			
			//declara el fichero de acceso aleatorio
			file = new RandomAccessFile(fichero, "rw");
			//abrimos el archivo aleatorio 


			registro = existePersona()  ;//id a modificar se consigue con un metodo

			//Pedimos datos a modificar por teclado
			Scanner sc = new Scanner(System.in);
			System.out.print("Escribe el departamento: ");
			int departamento = sc.nextInt();
			System.out.println("Escribe el salario: ");
			double salario = sc.nextDouble();


			long posicion = (registro -1 ) * 36; //(4+20+4+8)  modifico salario y dep
			posicion=posicion+4+20; //sumo el tamaño de ID+apellido
			file.seek(posicion); //nos posicionamos 
			file.writeInt(departamento);   //modif departamento
			file.writeDouble(salario);//modif salario

		}catch (IOException e) {
			// TODO: handle exception
		}finally {
			try {
				file.close();//cerrar fichero
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}   
			
			System.out.println("Registro "+iD1+" Modificado.");
		}
	}


	/*
	 * Pregunta el numero de id del empleado y si no 
	 * existe nos lo indica con un mensaje
	 */
	public static int existePersona() {
		//Pedimos el id y lo devolvemos por el metodo, verificando que exista
		Scanner scanner = new Scanner(System.in);
		System.out.println("Escribe un numero de id de empleado de (1 a "+LeerNumeroRegistrosFicheroAleatorio()+"): ");
		int apuntoAID = scanner.nextInt();
		if((apuntoAID>0) && (apuntoAID<LeerNumeroRegistrosFicheroAleatorio()+1)) {
			iD1 = apuntoAID;
		}else {
			System.out.println("El id no existe.");
			iD1 = null;
		}
		return iD1;
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

							numRegistros = id;
						}

						//me posiciono para el sig empleado, cada empleado ocupa 36 bytes
						posicion= posicion + 36;	 

					} catch (EOFException o) {

					}

					//Si he recorrido todos los bytes salgo del for	 	  
					if (file.getFilePointer() == file.length())break;

				}
				file.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}catch (Exception is) {
			is.printStackTrace();
		}

		return numRegistros;

	}

}
