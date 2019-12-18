package Hibernate1;

import javax.persistence.Entity;

@Entity
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Empleado[] empleados = new Empleado[4];
		
		for (int i = 0; i < empleados.length; i++) {
			System.out.println(empleados[i]);
		}

	}
	
	

}
