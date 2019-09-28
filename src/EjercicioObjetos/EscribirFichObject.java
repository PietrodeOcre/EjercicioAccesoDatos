package EjercicioObjetos;



import java.io.*;

public class EscribirFichObject {
  public static void main(String[] args) throws IOException {   
   
   Persona2 persona;//defino variable persona
   
   File fichero = new File("/home/pietrodeocre/eclipse/EjerciciosAD/src/Ejercicio1_3/FichPersona.dat");//declara el fichero
   FileOutputStream fileout = new FileOutputStream(fichero,true);  //crea el flujo de salida
    //conecta el flujo de bytes al flujo de datos
   ObjectOutputStream dataOS = new ObjectOutputStream(fileout); 
   
   
   
   String nombres[] = {"Ana","Luis Miguel","Alicia","Pedro","Manuel","Andrés",
                       "Julio","Antonio","María Jesús"};
					   
   int edades[] = {14,15,13,15,16,12,16,14,13};
   System.out.println("GRABO LOS DATOS DE PERSONA.");      
   for (int i=0;i<edades.length; i++){ //recorro los arrays    
      persona= new Persona2(nombres[i],edades[i]); //creo la persona	  
	  dataOS.writeObject(persona); //escribo la persona en el fichero
	  System.out.println("GRABO LOS DATOS DE PERSONA.");  
   }     
   dataOS.close();  //cerrar stream de salida    
   }
}