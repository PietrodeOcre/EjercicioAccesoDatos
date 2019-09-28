package EjercicioObjetos;

import java.io.*;
import java.util.Scanner;

import FicherosDeObjetos.Persona;

/*
 * Como es lógico para poder leer el archivo previamente 
 * debe crearse, como requiere implementar Serializable
 * que es una interface para poder ser serializado e insertado
 * en un archivo como un objeto. Si despues de creado se modifica 
 * el archivo de cualquier manera el código de serialización ya no coincide al 
 * leerlo, esto implica que cada vez que se modifique y se quiera leer
 * dicho arhcivo debe ser borrado y creado de nuevo
 * tambien tuve que crear la clase Persona2, de lo contrario no 
 * habia forma de crear el objeto a serializar y de leerlo por tanto
 * como ya tenia una clase Persona en otro package del proyecto 
 * me dio un par de errores, hasta que caí en la cuenta de que esta otra
 * clase puedo cambiarla de nombre y volver a crear el archivo,
 * con lo que al leerlo ya funciona y muestra todos los objetos 
 * insertados en el fichero de objetos.
 * */

public class Ejercicio1 {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Persona2 persona = null; // defino la variable persona
		File fichero = new File("/home/pietrodeocre/eclipse/EjerciciosAD/src/Ejercicio1_3/FichPersona.dat");
		ObjectInputStream dataIS = new ObjectInputStream(new FileInputStream(fichero));
		
		System.out.println("introduce el Id del personal: (de 1 a 9)");
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		
		if((id>0) || (id<9)) {
			imprimeEmpleado(dataIS, id);
		}else {
			System.out.println("El empleado no existe.");
		}
		
	}

	public static void imprimeEmpleado(ObjectInputStream dataIS, int id) throws IOException, ClassNotFoundException {
		Persona2 persona;
		try {
			while (true) { // lectura del fichero
				
				
				persona = (Persona2)dataIS.readObject(); // leer una Persona
				
				if(id == persona.getId()) {
				System.out.print("ID:"+persona.getId() + "=>");
				
				System.out.printf("Nombre: %s, edad: %d %n",
						persona.getNombre(),persona.getEdad());
				}
			}
		} catch (EOFException eo) {
			System.out.println("FIN DE LECTURA.");
		} catch (StreamCorruptedException x) {
			System.out.println(x.getMessage());
		}catch (ClassCastException y) {
			System.out.println(y.getMessage());
		}finally {
			dataIS.close(); // cerrar stream de entrada
		}
	}
	
}
