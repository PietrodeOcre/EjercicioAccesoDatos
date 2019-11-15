package Conector;

import java.sql.Connection;
import com.mysql.cj.jdbc.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Consulta1 {
	// Instancias la clase que hemos creado anteriormente
	protected static ConectorMysql SQL = new ConectorMysql();
	// Llamas al método que tiene la clase y te devuelve una conexión
	protected static Connection conn = SQL.conectarMySQL();


	// Query que usarás para hacer lo que necesites
	protected static String sSQL;
	// PreparedStatement

	public static void main(String[] args) {
		
		//borrarTablas();
		//crearTabla1();
		//ponerDatosTabla1();
		//crearTabla2();
		//ponerDatosTabla2();
		
		imprimeDatosTablaEmpleados();
		imprimeDatosTablaDepartamentos();
		
	}
	
	/*
	 * Imprime empleados de la tabla Empleados
	 */
	public static void imprimeDatosTablaEmpleados() {
		try {
			//Esta primera conexión es parte de una bateria de pruebas
			//sSQL = "select * from Empleados;";
			//PreparedStatement pstm = conn.prepareStatement(sSQL);
			//System.out.println(pstm.executeQuery("select * from Empleados;"));

			/*
			 * Creamos un objeto Statement con nuestro conector 
			 */
			Statement st = conn.createStatement();
			/*
			 * Creamos el objeto ResultSet para poner la 
			 * query dentro
			 */
			ResultSet rs = st.executeQuery("SELECT * FROM Empleados;");
			/*
			 * Si la respuesta no es null seguimos pidiendo registros hasta que lo sea
			 */
			if (rs != null) {
				System.out.println("El listado de persona es el siguiente:");
				/*
				 * rs nos devolvera registros hasta que termine con todos los de la 
				 * base de datos.
				 */
				while (rs.next()) {
					
					/*
					 * Los especificadores de formato son usados con el 
					 * printf() pero si usas println sin mas no hacen falta
					 * pero pego aqui los importantes por si acaso
					 * 
					 */
					
					 /* Especificador 	Formato
						%b 	Booleano
						%h 	Hashcode
						%s 	Cadena
						%c 	Caracter unicode
						%d 	Entero decimal
						%o 	Entero octal
						%x 	Entero hexadecimal
						%f 	Real decimal
						%e 	Real notación científica
						%g 	Real notación científica o decimal
						%a 	Real hexadecimal con mantisa y exponente
						%t 	Fecha u hora
						%n  Salto de linea
					 */


					/*
					 * Esta es otra forma de imprimirlo, la probe
					 * mientras estaba aun en el error
					 * de que mi base de datos contenia errores cuando 
					 * realmente es que no contenia datos.
					 * 
					 * System.out.printf("Número de Empleado: %d \n"
							+ "Apellido: %s \n"
							+ "Puesto: %s \n"
							+ "Dirección: %s \n"
							+ "Fecha de alta: %s \n"
							+ "Sueldo: %f \n"
							+ "Comisión: %f \n"
							+ "Departamento: %d %n"
							+ "- \n",
			                   rs.getInt(1), rs.getString(2), rs.getString(3),
			                   rs.getString(4), rs.getString(5), rs.getFloat(6)
			                   , rs.getFloat(7), rs.getInt(8));*/
					/*
					 * getObject nos devuelve como objeto lo que se contienen en 
					 * ese registro en concreto de la columna que le indiquemos
					 */
					System.out.println("  Número de Empleado: " + rs.getObject("emp_no"));
					System.out.println("  Apellido: " + rs.getObject("apellido"));
					System.out.println("  Puesto: " + rs.getObject("oficio"));
					System.out.println("  Dirección: " + rs.getObject("dir"));
					System.out.println("  Fecha de alta: " + rs.getObject("fecha_alt"));
					System.out.println("  Sueldo: " + rs.getObject("salario"));
					System.out.println("  Comisión: " + rs.getObject("comision"));
					System.out.println("  Departamento: " + rs.getObject("dep_no"));
					System.out.println("- ");
				}
				//Se debe cerrar el ResultSet
				rs.close();
			}
			//Se debe cerrar el Statement
			st.close();

		} catch ( SQLException e) {
			e.printStackTrace();
		}finally {

		}
	}
	
	/*
	 * Imprime Registros de la tabla Departamentos
	 */
	public static void imprimeDatosTablaDepartamentos() {
		try {
			//sSQL = "select * from Departamentos;";
			//PreparedStatement pstm = conn.prepareStatement(sSQL);
			//System.out.println(pstm.executeQuery("select * from Departamentos;"));

			Statement st = conn.createStatement();

			ResultSet rs = st.executeQuery("SELECT * FROM Departamentos;");

			if (rs != null) {
				System.out.println("El listado de Departamentos es el siguiente:");

				while (rs.next()) {
					System.out.printf("%d, %s, %s %n",
			                   rs.getInt(1), rs.getString(2), rs.getString(3));

				}
				rs.close();
			}
			st.close();

		} catch ( SQLException e) {
			e.printStackTrace();
		}finally {

		}
	}

	/*
	 * Crea la tabla de Empleados
	 */
	public static void crearTabla1() {
		/*
		 * Se instancia un Stetement 
		 */
		Statement st;
		try {
			st = conn.createStatement();
			/*
			 * El Statement puede mandar a ejecutar una query
			 * del tipo que sea, INSERT, SELCET, UPDATE, DROP, etc
			 */
			st.executeUpdate("CREATE TABLE Empleados (emp_no INT,"
					+ " apellido varchar(50) NOT NULL, "
					+ " oficio varchar(50) NOT NULL, "
					+ " dir varchar(50) NOT NULL, "
					+ " fecha_alt date NOT NULL, "
					+ " salario FLOAT, "
					+ " comision FLOAT, "
					+ " dep_no INT, "
					+ " FOREIGN KEY(dep_no) REFERENCES Departamentos (dept_no),"
					+ "PRIMARY KEY (emp_no));");	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * Crea la tabla de Departamentos
	 */
	public static void crearTabla2() {
		Statement st;
		try {
			st = conn.createStatement();
			st.executeUpdate("CREATE TABLE Departamentos (dept_no INT,"
					+ " dnombre varchar(50) NOT NULL, "
					+ " loc varchar(50) NOT NULL, "
					+ "PRIMARY KEY (dept_no));");	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * Inserta datos en tabla Empleados
	 */
	public static void ponerDatosTabla1() {
		Statement st;
		try {
			st = conn.createStatement();
			st.executeUpdate("INSERT INTO Empleados (emp_no,apellido,oficio,dir,fecha_alt,salario,comision,dep_no) VALUES" + 
					"(7369,'SANCHEZ','EMPLEADO',7902,'1990-12-17 00:00:00',1040,0,20)," + 
					"(7499,'ARROYO','VENDEDOR',7698,'1990-02-20 00:00:00',1500,3.9,30)," + 
					"(7521,'SALA','VENDEDOR',7698,'1991-02-22 00:00:00',1625,6.5,30)," + 
					"(7566,'JIMENEZ','DIRECTOR',7839,'1991-04-02 00:00:00',2900,0.0,20)," + 
					"(7654,'MARTIN','VENDEDOR',7698,'1991-09-29 00:00:00',1600,1.2,30)," + 
					"(7698,'NEGRO','DIRECTOR',7839,'1991-05-01 00:00:00',3005,0.0,30)," + 
					"(7782,'CEREZO','DIRECTOR',7839,'1991-06-09 00:00:00',2885,0.0,10)," + 
					"(7788,'GIL','ANALISTA',7566,'1991-11-09 00:00:00',3000,0.0,20)," + 
					"(7839,'REY','PRESIDENTE',7698,'1991-11-17 00:00:00',4100,0.0,10)," + 
					"(7844,'TOVAR','VENDEDOR',7698,'1991-09-08 00:00:00',1350,2.5,30)," + 
					"(7876,'ALONSO','EMPLEADO',7788,'1991-09-23 00:00:00',1430,0.0,20)," + 
					"(7900,'JUMENO','EMPLEADO',7698,'1991-12-03 00:00:00',1335,0.0,30)," + 
					"(7902,'FERNÁNDEZ','ANALISTA',7566,'1991-12-03 00:00:00',3000,0.0,20)," + 
					"(7934,'MUÑOZ','EMPLEADO',7782,'1992-01-23 00:00:00',1690,0.0,10);");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * Inserta datos en tabla Departamentos
	 */
	public static void ponerDatosTabla2() {
		Statement st;
		try {
			st = conn.createStatement();
			st.executeUpdate("INSERT INTO Departamentos (dept_no,dnombre,loc) VALUES" +
					"(10,'CONTABILIDAD','SEVILLA'),"+
					"(20,'INVESTIGACIÓN','MADRID'),"+
					"(21,'INFORMATICA','TALAVERA'),"+
					"(22,'INFORMATICA','TALAVERA'),"+
					"(30,'VENTAS','BARCELONA'),"+
					"(40,'PRODUCCIÓN','BILBAO');"
					);	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * Borra las dos tablas
	 */
	public static void borrarTablas() {
		Statement st;
		try {
			st = conn.createStatement();
			st.executeUpdate("DROP TABLE IF EXISTS Empleados;");		
			st.executeUpdate("DROP TABLE IF EXISTS Departamentos;");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
