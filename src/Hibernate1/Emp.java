package Hibernate1;

import java.io.Serializable;


public class Emp implements Serializable {
	
	/*
	 * <id column="emp_no" name="emp_no" type="integer"/>
    <id column="apellido" name="apellido" type="string"/>
    <id column="oficio" name="oficio" type="string"/>
    <id column="dir" name="dir" type="string"/>
    <id column="fecha_atl" name="fecha_atl" type="date"/>
    <id column="salario" name="salario" type="float"/>
    <id column="comision" name="comision" type="float"/>
    <id column="dep_no" name="dep_no" type="integer"/>
	 */

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int emp_no;

	private int dep_no;

	private String apellido;

	private String oficio;

	private String dir;

	private float salario;

	private float comision;
	public int getEmp_no() {
		return emp_no;
	}
	public void setEmp_no(int emp_no) {
		this.emp_no = emp_no;
	}
	public int getDep_no() {
		return dep_no;
	}
	public void setDep_no(int dep_no) {
		this.dep_no = dep_no;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getOficio() {
		return oficio;
	}
	public void setOficio(String oficio) {
		this.oficio = oficio;
	}
	public String getDir() {
		return dir;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}
	public float getComision() {
		return comision;
	}
	public void setComision(float comision) {
		this.comision = comision;
	}
	
	public Emp() {
		
	}
	
	public Emp(int emp_no, int dep_no, String apellido, String oficio, String dir, float salario, float comision) {
		super();
		this.emp_no = emp_no;
		this.dep_no = dep_no;
		this.apellido = apellido;
		this.oficio = oficio;
		this.dir = dir;
		this.salario = salario;
		this.comision = comision;
	}
	@Override
	public String toString() {
		return "Empleado [emp_no=" + emp_no + ", dep_no=" + dep_no + ", apellido=" + apellido + ", oficio=" + oficio
				+ ", dir=" + dir + ", salario=" + salario + ", comision=" + comision + "]";
	}
	
	
	public static void main(String[] args) {
		Emp[] list = new Emp[4];
		for (int i = 0; i < list.length; i++) {
			System.out.println(list[i].toString());
		}
		
	}
	
}
