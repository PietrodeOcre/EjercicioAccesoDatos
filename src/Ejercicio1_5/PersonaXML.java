package Ejercicio1_5;

import java.io.Serializable;
public class PersonaXML implements Serializable{
	private String nombre;
	private int edad;
	
	public PersonaXML(String nombre,int edad)	{
	  this.nombre=nombre;
	  this.edad=edad;	
	 }
	public PersonaXML() {
	  this.nombre=null;	  
	 }	
	public void setNombre(String nom){nombre=nom;}
	public void setEdad(int ed){edad=ed;}
	
	public String getNombre(){return nombre;}
	public int getEdad(){return edad;}	
}//fin PersonaXML
