package Ejercicio1_4;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;



public class ModificarDatoRegistro {
	
	public static File fichero = new File("/home/pietrodeocre/eclipse/EjerciciosAD/src/Ejercicio1_3/AleatorioEmple.dat");
	
	
	public static Integer iD1;
	public static Empleado empleado;
	
	public static void main(String[] args) {
		
		try {
			
			//Leemos los datos iniciales del empleado
			leerEmpleado();
			//Imprimirmos el objeto estatico empleado
			System.out.println(empleado.toString());
			//Modificamos el dato que se pide en el ejercicio
			modificarSalario();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	/*
	 * Este metodo devuelve un objeto Empleado con sus atributos
	 */
	public static Empleado leerEmpleado() throws FileNotFoundException, IOException {
		
		//declara el fichero de acceso aleatorio
		RandomAccessFile file = new RandomAccessFile(fichero, "r");
		
		//declara variables para cada dato
		int  id, dep, posicion;    
		Double salario;	
		char apellido[] = new char[10], aux; 
		try {
			posicion = (existePersona()-1)*36;  //para situarnos al principio

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

				if(id >0) {
					//En lugar de imprimirlo lo guardamos en un objeto de tipo empleado con los mismos atributos    
					empleado = new Empleado(id, dep, salario, apellidos.trim());
					//int id, int dep, double salario, String apellido
					//Se muestra los datos comletos del usuario
				}else {
					System.out.println("El usuario no existe.");
				}

				break;//fin bucle for

			}

		}catch (Exception e) {

		}finally {
			file.close();  //cerrar fichero
			
			
		}
		
		return empleado;
	}
	
	/*
	 * Metodo para podificar un dato(el salario) del fichero aleatorio
	 */
	public static void modificarSalario() {
		
		RandomAccessFile file = null;
		int registro;
		try {
			
			//declara el fichero de acceso aleatorio
			file = new RandomAccessFile(fichero, "rw");
			//abrimos el archivo aleatorio 


			registro = empleado.getId()  ;//id a modificar se consigue con un metodo

			//Pedimos datos a modificar por teclado
			Scanner sc = new Scanner(System.in);
			System.out.println("Escribe el salario: ");
			double salarioNuevo = sc.nextDouble();
			empleado.setSalarioNuevo(salarioNuevo);


			long posicion = (registro -1 ) * 36; //(4+20+4+8)  modifico salario y dep
			posicion=posicion+4+20+4; //sumo el tamaño de ID+apellido+departamento
			file.seek(posicion); //nos posicionamos 
			file.writeDouble(empleado.getSalario()+empleado.getSalarioNuevo());//modif salario

		}catch (IOException e) {
			// TODO: handle exception
		}finally {
			try {
				file.close();//cerrar fichero
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}   
			//imprimimos el nuevo salario del empleado
			System.out.println("El salario actualizado es: "+(empleado.getSalario()+empleado.getSalarioNuevo()));
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

	
}

/*
 * Clase empleado 
 */
class Empleado {

	private int  id, dep;    
	private Double salario;	
	private String apellido;
	
	private Double salarioNuevo;

	public Double getSalarioNuevo() {
		return salarioNuevo;
	}

	public void setSalarioNuevo(Double salarioNuevo) {
		this.salarioNuevo = salarioNuevo;
	}

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

	@Override
	public String toString() {
		
		return "Empleado: "+ apellido + ", antiguo sueldo: "+salario;
	}

	

}

