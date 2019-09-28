package Ejercicio1_3;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.RandomAccessFile;
import java.util.Scanner;

import javax.lang.model.element.Element;

import FicherosDeObjetos.Persona;

public class AñadirRegistros {
	public static File fichero = new File("/home/pietrodeocre/eclipse/EjerciciosAD/src/Ejercicio1_3/AleatorioEmple.dat");

	//Atributo para guardar el ID
	protected static Integer iD1;

	public static void main(String[] args) {
		
		//Esta instancia es para poder crear un archivo modelo desde cero
		EscribirAleatorio escribe = new EscribirAleatorio();

		try {
			/*
			 * El try hace las veces de comprobador
			 * por que si ya está creado salta el catch
			 * 
			 */
			escribe.escribirFichero();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("El archivo ya existe");
		}
		
		//Iniciamos el método para insertar un registro al final del fichero
		insertaRegistro();

	}

	/*
	 * Metodo para insertar registros nuevos al final del fichero
	 */
	public static void insertaRegistro() {

		
		//declara el fichero de acceso aleatorio
		RandomAccessFile file;
		try {
			file = new RandomAccessFile(fichero, "rw");

			StringBuffer buffer = null;	//bufer para almacenar apellido 

			int registro = existePersona()  ;//id a modificar se obtiene desde un método

			Empleado empleado = datosRegistro();//Creamos un ObjectOutput empleado mediante un método

			long posicion = (registro -1 ) * 36; //Con esta linea saltamos al ultimo id
			
			try {
				//Accedemos a la ultima posicion
				file.seek(posicion);
				file.writeInt(empleado.getId());   //modif departamento
				String emple = new String(empleado.getApellido());
				buffer = new StringBuffer( emple );      
				buffer.setLength(10); //10 caracteres para el apellido
				file.writeChars(buffer.toString());//insertar apellido
				file.writeInt(empleado.getDep());       //insertar departamento
				file.writeDouble(empleado.getSalario());//insertar salario
				file.close();  //cerrar fichero 

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} //nos posicionamos 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	   finally {
			//Mensaje de registro finalizado
			System.out.println("Registro realizado.");
		}

	}

	/*
	 * Pide datos de nuevo registro
	 */
	public static Empleado datosRegistro() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Escribe los datos del empleado:");
		//System.out.print("Id: ");
		//int id = scanner.nextInt();
		System.out.print("Departamento: ");
		int dep = scanner.nextInt();
		System.out.print("Salario: ");
		int salario = scanner.nextInt();
		System.out.print("Apellido: ");
		String apellido = scanner.next();


		Empleado empleado =  new Empleado(LeerNumeroRegistrosFicheroAleatorio()+1, dep, salario, apellido);

		return empleado;

	}


	/*
	 * Pregunta el numero de id del empleado y si no 
	 * existe nos lo indica con un mensaje
	 */
	public static int existePersona() {

		System.out.println("El nuevo usuario tendrá este ID: "+(LeerNumeroRegistrosFicheroAleatorio()+1));
		int apuntoAID = LeerNumeroRegistrosFicheroAleatorio()+1;

		iD1 = apuntoAID;

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

class Empleado {

	private int  id, dep;    
	private Double salario;	
	private String apellido;

	public Empleado(Empleado empleado) {
		this.id = empleado.getId();
		this.dep = empleado.getDep();
		this.salario = empleado.getSalario();
		this.apellido = empleado.getApellido();

	}

	public Empleado(int id, int dep, double salario, String apellido) {
		this.id = id;
		this.dep = dep;
		this.salario = salario;

		this.apellido = apellido;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDep() {
		return dep;
	}

	public void setDep(int dep) {
		this.dep = dep;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



}



