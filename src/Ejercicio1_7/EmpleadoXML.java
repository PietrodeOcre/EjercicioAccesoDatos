package Ejercicio1_7;

import java.util.Arrays;

public class EmpleadoXML {
	
	private int id, dep;
	private double salario;
	private String apellido;
	
	public EmpleadoXML(int id, int dep, Double salario, String apellidos) {
		this.id = id;
		this.dep = dep;
		this.salario = salario;
		this.apellido = apellidos;
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

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
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
		return "Empleado [id=" + id + ", dep=" + dep + ", salario=" + salario + ", apellido="
				+ apellido + "]";
	}
	
	

}
