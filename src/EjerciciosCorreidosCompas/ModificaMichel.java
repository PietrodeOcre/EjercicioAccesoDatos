package EjerciciosCorreidosCompas;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ModificaMichel {
		 
		 File fichero;
		 static String Id, cadena;
		 static boolean found = false; // bandera de localizacion
		 static long replacepos;
		 
		 public static void main(String[] args) {
		  String Ide=args[0];
		  ModificaMichel consulta= new ModificaMichel(args);
		   // File fichero = new File(".\\Empleados.txt");
		  if (args.length==1) {
		   try {
		    consulta.fileReady(Ide);
		   } catch (IOException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		   } 
		  } else if (args.length==4){
		   try {
		    consulta.fileReady(Ide);
		   } catch (IOException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		   }
		   if (!found){try {
		    consulta.fileWritey(cadena);
		   } catch (IOException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		   } }
		  }
		  else {   // error de parametros
		   System.out.println("Numero incorrecto de parametros\n "
		     + "Insertar Id de empleado para consultar o"
		     + "Id, Nombre, Departamento y Salario");
		  }
		 }
		 
		 public ModificaMichel(String[] args) {
		  File fichero = new File(".\\Empleados.txt");
		  Id = args[0];
		  cadena=args[0]+args[1]+args[2]+args[3];
		  //declara el fichero de acceso aleatorio
		 }
		 
		 public void fileReady(String Id) throws IOException {    
		  
		  RandomAccessFile file = new RandomAccessFile(fichero, "rw");
		  int registro = 1  ;//id a modificar
		  long posicion = (registro -1) * 31; //(2+pad+9+pad+13+pad+4+salto)
		  //bucle busqueda
		  while (file.length()>posicion){
		   file.seek(posicion); //nos posicionamos
		   char c1 = (char) file.read();
		   file.seek(posicion++); //nos posicionamos
		   char c2 = (char) file.read();
		   String Ident= Integer.toString(c1)+Integer.toString(c2);
		   
		   if (Id==Ident){
		    found = true;
		    file.seek(posicion); //nos posicionamos
		    String mensaje = file.readLine();
		    System.out.println(mensaje);
		    replacepos=posicion;
		   }
		   posicion=posicion+31; //sumo el tamaño de ID+apellido
		   if (found) break;
		  }
		  if (!found){System.out.println("Empleado no encontrado");}
		  // file.BufferedReader();
		  // file.writeInt(40);   //modif departamento
		  // file.writeDouble(4000.87);//modif salario
		  file.close();  //cerrar fichero 
		 }
		 public static void fileWritey(String nuevo) throws IOException {
		  File fichero = new File(".\\Archivo.txt");
		  //creamos flujo de salida
		  //FileWriter fic = new FileWriter(fichero);
		  RandomAccessFile file = new RandomAccessFile(fichero, "rw");
		  file.seek(replacepos); //nos posicionamos
		  file.writeChars(nuevo);
		  //convierte la cadena en array de caracteres para extraerlos de 1 en 1 
		  char[] cad = cadena.toCharArray();
		  for (int i=0; i<cad.length; i++) { 
		   //file.writeChars(cadena.toCharArray()[i]); // escribe un caracter
		  }
		  //fic.append("*");
		  //String prov[] = {"Uno","Dos","Tres"};
		  //for (int i=0; i<prov.length; i++) fic.write(prov[i]);
		  file.close();
		 }

	
	
}
