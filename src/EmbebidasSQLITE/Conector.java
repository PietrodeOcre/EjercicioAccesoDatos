package EmbebidasSQLITE;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conector {
	
	String url = "/home/pietrodeocre/eclipse/EjerciciosAD/ad.db";
	String ficheroDestino = "http://192.168.1.89/ad.db";
	
	
	public static void descargar(String url, String ficheroDestino) throws Exception {
		 
		   URL ficheroUrl = new URL(url);
		   InputStream inputStream = ficheroUrl.openStream();	
		   OutputStream outputStream = new FileOutputStream(ficheroDestino); // path y nombre del nuevo fichero creado
		 
		   byte[] b = new byte[2048];
		   int longitud;
		 
		   while ((longitud = inputStream.read(b)) != -1) {
		      outputStream.write(b, 0, longitud);
		   }
		 
		   inputStream.close();  // Cerramos la conexión entrada
		   outputStream.close(); // Cerramos la conexión salida
		}
    
	Connection conectar;
	
	public void conectar() {
		
		try {
			conectar = DriverManager.getConnection("jdbc:sqlite:"+url);
			if (conectar != null) {
				System.out.println("Conectado");
			}
		}catch (SQLException ex) {
			System.err.println("No se puede conectar a la base de datos \n"+ex.getMessage());
		}
		
	}
	
	public void close() {
		try {
			conectar.close();
		}catch (SQLException ex) {
			Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public void insertarEmpleado(){
        try {
        	Scanner sc = new Scanner(System.in);
            PreparedStatement st = conectar.prepareStatement("insert into Empleados (emp_no,apellido,oficio,dir,fecha_alt,salario,comision,dep_no) values (?,?,?,?,?,?,?,?)");
            System.out.print("Inserta el numero de empleado: ");
            st.setInt(1, sc.nextInt());
            System.out.print("Inserta el apellido: ");
            st.setString(2, sc.next());
            System.out.print("Inserta el oficio: ");
            st.setString(3, sc.next());
            System.out.print("Inserta la dirección: ");
            st.setString(4, sc.next());
            System.out.print("Inserta fecha de alta: ");
            st.setString(5, sc.next());
            System.out.print("Inserta el salario: ");
            st.setFloat(6, sc.nextFloat());
            System.out.print("Inserta la comision: ");
            st.setFloat(7, sc.nextFloat());
            System.out.print("Inserta el departamento: ");
            st.setFloat(8, sc.nextInt());
            st.execute();
            sc.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
	
	public void mostrarEmpleados(){
        ResultSet result = null;
        try {
            PreparedStatement st = conectar.prepareStatement("select * from Empleados");
            result = st.executeQuery();
            //Empleados (emp_no,apellido,oficio,dir,fecha_alt,salario,comision,dep_no)
            while (result.next()) {
                System.out.print("ID: ");
                System.out.println(result.getInt("emp_no"));

                System.out.print("Apellido: ");
                System.out.println(result.getString("apellido"));

                System.out.print("Oficio: ");
                System.out.println(result.getString("oficio"));
                
                System.out.print("Dirección: ");
                System.out.println(result.getString("dir"));
                
                System.out.print("Fecha de alta: ");
                System.out.println(result.getString("fecha_alt"));
                
                System.out.print("Salario: ");
                System.out.println(result.getString("salario"));
                
                System.out.print("Comision: ");
                System.out.println(result.getString("comision"));
                
                System.out.print("Departamento: ");
                System.out.println(result.getString("dep_no"));

                System.out.println("=======================");
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
	
	public void mostrarDepartamentos(){
        ResultSet result = null;
        try {
            PreparedStatement st = conectar.prepareStatement("select * from Departamentos");
            result = st.executeQuery();
            //dept_no,dnombre,loc
            while (result.next()) {
                System.out.print("ID de departamento: ");
                System.out.println(result.getInt("dept_no"));

                System.out.print("Departamento: ");
                System.out.println(result.getString("dnombre"));
                
                System.out.print("Localización: ");
                System.out.println(result.getString("loc"));

                System.out.println("=======================");
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
	
	public void insertarDepartamento(){
        try {
        	Scanner sc = new Scanner(System.in);
            PreparedStatement st = conectar.prepareStatement("insert into Departamentos (dept_no,dnombre,loc) values (?,?,?)");
            //dept_no,dnombre,loc
            System.out.print("Inserta el numero de departamento: ");
            st.setInt(1, sc.nextInt());
            System.out.print("Inserta el nombre: ");
            st.setString(2, sc.next());
            System.out.print("Inserta la dirección: ");
            st.setString(3, sc.next());
            
            st.execute();
            sc.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
	
	public void crearTablaDepartamentos(){
        try {
        	Scanner sc = new Scanner(System.in);
            PreparedStatement st = conectar.prepareStatement("CREATE TABLE Departamentos (dept_no INT,\n" + 
            		"dnombre varchar(50) NOT NULL,\n" + 
            		"loc varchar(50) NOT NULL,\n" + 
            		"PRIMARY KEY (dept_no));");
            st.execute();
            sc.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
	
	public void crearTablaEmpleados(){
        try {
        	Scanner sc = new Scanner(System.in);
            PreparedStatement st = conectar.prepareStatement("CREATE TABLE Empleados (emp_no INT,\n" + 
            		"apellido varchar(50) NOT NULL, \n" + 
            		"oficio varchar(50) NOT NULL, \n" + 
            		"dir varchar(50) NOT NULL,\n" + 
            		"fecha_alt date NOT NULL,\n" + 
            		"salario FLOAT,\n" + 
            		"comision FLOAT,\n" + 
            		"dep_no INT,\n" + 
            		"FOREIGN KEY(dep_no) REFERENCES Departamentos (dept_no),\n" + 
            		"PRIMARY KEY (emp_no));");
            st.execute();
            sc.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
	
	
}
