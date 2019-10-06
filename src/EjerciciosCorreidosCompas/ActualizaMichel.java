package EjerciciosCorreidosCompas;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ActualizaMichel {
	

	 static File fichero = new File("/./Empleados.dat");
	 static boolean found=false;
	 static int dep, posicion, id, len;
	 static char fila[] = new char[30];
	 static char aux;
	 
	 public static void main(String[] args) {
	  //pasar argumentos
	  int len=args.length;
	  if (len==1){
	   try {
	    BuscaID(args[0]);
	    }catch (Exception e){};
	   }
	  if (len==4){
	   try {
	    BuscaID(args[0]);
	    }catch (Exception e){};
	   if (found){
	    String nuevo=args[0]+args[1]+args[2]+args[3];
	    String ID=args[0];
	    try{
	     ActualizaID(ID,nuevo);
	    }catch (Exception ex){}
	   }
	  }
	  else {System.out.printf("Numero de parametros incorrectos");}
	  }

	 public static void BuscaID(String ID) throws IOException{
	  int registro = Integer.parseInt(ID);
	  found=false;
	  RandomAccessFile file = new RandomAccessFile(fichero, "r");
	  
	  for(int i=0;i<file.length(); i++){
	   posicion = (registro -1 ) * 32;
	   if(posicion >= file.length())   
	    System.out.printf("ID: %d, NO EXISTE EMPLEADO...",ID);
	   else{ 
	    file.seek(posicion); //nos posicionamos 
	    id=file.readInt(); // obtengo id de empleado
	    if (id==Integer.valueOf(ID)){
	     found=true;
	     for (int i1 = 0; i1 < 30; i1++) {
	      aux = file.readChar();//recorro uno a uno los caracteres del apellido 
	      fila[i1] = aux;    //los voy guardando en el array
	    }
	   }    
	   String filac= new String(fila);//convierto a String el array
	   filac=ID+filac;
	   if (found)
	    System.out.println("Datos existentes: "+filac);
	   else
	    System.out.println("Sin datos");
	   }
	  }
	  file.close();  //cerrar fichero 
	 }
	 
	 public static void ActualizaID (String ID, String fila) throws IOException{
	  RandomAccessFile file = new RandomAccessFile(fichero, "rw");
	  if (found){
	   file.seek(posicion);
	   file.writeBytes(fila);
	   /*file.writeInt(id); //uso id para identificar empleado
	   buffer = new StringBuffer( apellido);      
	   buffer.setLength(10); //10 caracteres para el apellido
	   file.writeChars(buffer.toString());//insertar apellido
	   file.writeInt(dep);       //insertar departamento
	   file.writeDouble(salario);//insertar salario*/
	  }else{
	   file.seek(file.length());
	   file.writeBytes(fila);
	  }
	  file.close();  //cerrar fichero 
	 }
	 public static void MuestraID(){
	  
	 }
	
}
