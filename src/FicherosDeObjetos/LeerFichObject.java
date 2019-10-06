package FicherosDeObjetos;



import java.io.*;

public class LeerFichObject {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		leerObjeto();
	}

	private static void leerObjeto(){
		try {
			Object object; // defino el objeto
			File fichero = new File("FichPersona.dat");
			ObjectInputStream dataIS = new ObjectInputStream(new FileInputStream(fichero));
			int i = 1;
			try {
				while (true) { // lectura del fichero
					object = dataIS.readObject(); // leer una Persona
					System.out.print(i + "=>");
					i++;
					System.out.println(object.toString());
				}
			} catch (EOFException eo) {
				System.out.println("FIN DE LECTURA.");
			} catch (StreamCorruptedException x) {
			}
			dataIS.close(); // cerrar stream de entrada
		}catch(IOException e) {	
		}catch (ClassNotFoundException b) {
		}
	}
	
	
	
}