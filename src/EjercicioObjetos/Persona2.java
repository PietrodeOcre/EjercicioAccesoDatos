package EjercicioObjetos;

import java.io.Serializable;

public class Persona2 implements Serializable{
	
	private static int id1 = 1;
	private int id;
	private String nombre;
	private int edad;

	
	public Persona2(String string, int i) {
		// TODO Auto-generated constructor stub
		this.id = id1++;
		this.nombre=string;
		this.edad = i;
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	

}
