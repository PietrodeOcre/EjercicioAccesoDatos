package FicherosAleatorios;


import java.io.*;
public class LeerFichAleatorio {
  public static void main(String[] args) throws IOException {     
   LeerFichero();
   }

  public static void LeerFichero() throws FileNotFoundException, IOException {
	  File fichero = new File("AleatorioEmple.dat");
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

		  if(id >0)
			  System.out.printf("ID: %s, Apellido: %s, Departamento: %d, Salario: %.2f %n",
					  id,   apellidos.trim(), dep, salario);     

		  //me posiciono para el sig empleado, cada empleado ocupa 36 bytes
		  posicion= posicion + 36;	 

		  //Si he recorrido todos los bytes salgo del for	 	  
		  if (file.getFilePointer() == file.length())break;

	  }//fin bucle for 
	  file.close();  //cerrar fichero 
  }
}
