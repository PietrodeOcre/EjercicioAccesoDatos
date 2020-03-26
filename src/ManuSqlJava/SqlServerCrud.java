package ManuSqlJava;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.microsoft.sqlserver.jdbc.*;


public class SqlServerCrud {
	
	//Creamos una variable estatica de la clase connect
	static Connection connect;
	
	public static Subasta[] subasta;
	
	/*
	 * Mi instancia de sqlServer está en una máquina virtual 
	 * con windows 10, el cual he configurado con una red nat
	 * y enrutado los puertos a la ip interna del pc anfitrion
	 * por eso puede observarse que uso el 127.0.0.1 con el
	 * puerto por defecto de SqlServer 
	 * Obtenemos un String con el conector 
	 */
	static String connectionUrl = "jdbc:sqlserver://127.0.0.1:1433;" + "database=PEDIDOS;"
		+ "user=sa;" + "password=smaodoo;";

	
	/*public static void main(String[] args) {

		//pruebaConexion();
		
		//crearTablas();
		
		//insertarDatos();
		
		//consultaDatos();
		
		//insertarRegistroUnico();
		
		//borraRegistroPorID();
		
		
	}*/
	
	
	private static void borraRegistroPorIDSubasta() {
		
		System.out.println("Escriba el id del registro a borrar: ");
		Scanner scanner = new Scanner(System.in);
		int id = scanner.nextInt();
		
		String query = "DELETE FROM SUBASTA WHERE IDSUBASTA='"+id+"';";
		String query1 = "select * from SUBASTA where IDSUBASTA = "+id+";";
		try {
			connect = DriverManager.getConnection(connectionUrl);
			if(connect != null) {
				Statement serverStatement = connect.createStatement();
				ResultSet resultSet = serverStatement.executeQuery(query1);
				while(resultSet.next()) {
					System.out.println("Id: " + resultSet.getInt(1) + ", "
							+ "Fecha de subasta: " + resultSet.getString(2) + ", "
							+ "Director: " + resultSet.getString(3) + ", "
							+ "Lugar: " + resultSet.getString(4) + ", " 
							+ "Num. Lote: " + resultSet.getInt(5) + ", "
							+ "Num. Pieza: " + resultSet.getInt(6) + ", "
							+ "Ventas: " + resultSet.getInt(7) + ", ");
				}
				int del = serverStatement.executeUpdate(query);
				System.out.println("Registro borrado");
			}
			
		} catch (SQLException ex) {
			System.out.println("Id no encontrado. Error.");
			ex.printStackTrace();
		} finally {

			try {
				
				connect.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	public static String obtenerFechaFormateada() {
		LocalDate fecha = LocalDate.now();
	    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	    return fecha.format(dtf);
	}

	private static void insertarRegistroUnico() {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Introducción manual de registro: ");
		System.out.println("Escriba el nombre completo: ");
		String nombre = scanner.nextLine();
		
		System.out.println("Escriba el lugar: ");
		String lugar = scanner.next();
		
		System.out.println("Escriba el número de lote: ");
		int lote = scanner.nextInt();
		
		System.out.println("Escriba el número de pieza: ");
		int pieza = scanner.nextInt();
		
		System.out.println("Escriba el precio de venta: ");
		int precio = scanner.nextInt();
		
		int id = consultaUltimoIdSubasta()+1;
		
		String query = "INSERT INTO SUBASTA (IDSUBASTA,FECHA_SUB,DIRECTOR_SUB,LUGAR,NLOTES,NPIEZAS,VENTAS_TOTALES) "
				+ "VALUES ("+id+",'"+obtenerFechaFormateada()+"','"+nombre.toUpperCase()+"','"+lugar.toUpperCase()+"',"+lote+","+pieza+","+precio+");";
		
		try {
			connect = DriverManager.getConnection(connectionUrl);
			if(connect != null) {
				Statement serverStatement = connect.createStatement();
				int rowsAffected = serverStatement.executeUpdate(query);
				System.out.println("Registros afectados: "+ rowsAffected);
			}
			System.out.println("Conectado.");
			System.out.println("Datos insertados");
		} catch (SQLException ex) {
			System.out.println("Tabla No afectada. Error.");
			System.out.println("");
			ex.printStackTrace();
		} finally {

			try {
				
				connect.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static int consultaUltimoIdSubasta() {
		String query = "select * from SUBASTA;";
		int id = 0;
		try {
			connect = DriverManager.getConnection(connectionUrl);
			if(connect != null) {
				Statement serverStatement = connect.createStatement();
				ResultSet resultSet = serverStatement.executeQuery(query);
				while(resultSet.next()) {
					id = resultSet.getInt(1); 
				}
			}
			
		} catch (SQLException ex) {
			System.out.println("Id no encontrado. Error.");
			ex.printStackTrace();
		} finally {

			try {
				
				connect.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return id;
	}

	public static Subasta[] consultaDatosSubasta() {
		String query = "select * from SUBASTA;";
		
		int lon = consultaUltimoIdSubasta();
		int cont = 0;
		subasta = new Subasta[lon];
		
		try {
			connect = DriverManager.getConnection(connectionUrl);
			if(connect != null) {
				Statement serverStatement = connect.createStatement();
				ResultSet resultSet = serverStatement.executeQuery(query);
				while(resultSet.next()) {
					
						subasta[cont] = new Subasta(resultSet.getInt(1),resultSet.getString(2),
							resultSet.getString(3),resultSet.getString(4),
							resultSet.getInt(5),resultSet.getInt(6),
							resultSet.getInt(7));
						System.out.println(cont);					
						cont++;
					
				}
			}
			System.out.println("Conectado.");
		} catch (SQLException ex) {
			System.out.println("Datos No mostrados. Error.");
			ex.printStackTrace();
		} finally {

			try {
				System.out.println("Datos mostrados");
				connect.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return subasta;
	}

	public static void crearTablasSubasta() {
		
		String query = "CREATE TABLE SUBASTA(" + 
				"IDSUBASTA int NOT NULL," + 
				"FECHA_SUB char (10) NULL," + 
				"DIRECTOR_SUB char (30) NULL," + 
				"LUGAR char (30) NULL," + 
				"NLOTES int NULL," + 
				"NPIEZAS int NULL," + 
				"VENTAS_TOTALES int NULL," + 
				"CONSTRAINT PK_SUBASTA PRIMARY KEY (IDSUBASTA));";
		
		try {
			connect = DriverManager.getConnection(connectionUrl);
			if(connect != null) {
				Statement serverStatement = connect.createStatement();
				serverStatement.executeUpdate(query);
			}
			System.out.println("Conectado.");
		} catch (SQLException ex) {
			System.out.println("Tabla No creada. Error.");
			ex.printStackTrace();
		} finally {

			try {
				System.out.println("Tabla creada");
				connect.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	public static void insertarDatosSubasta() {
		
		String query = "INSERT INTO SUBASTA VALUES (1,'01-01-2018','JOSE LUIS RUIZ','MADRID',10,6,34400);" + 
				"INSERT INTO SUBASTA VALUES (2,'01-02-2018','JOSE LUIS RUIZ','MADRID',10,5,34400);" + 
				"INSERT INTO SUBASTA VALUES (3,'01-03-2018','JOSE LUIS RUIZ','SEVILLA',10,5,134400);" + 
				"INSERT INTO SUBASTA VALUES (4,'01-04-2018','JOSE LUIS RUIZ','SEVILLA',10,7,34400);" + 
				"INSERT INTO SUBASTA VALUES (5,'01-05-2018','JOSE LUIS RUIZ','TERUEL',08,5,34400);" + 
				"INSERT INTO SUBASTA VALUES (6,'01-06-2018','JOSE LUIS RUIZ','TERRUEL',10,5,834400);" + 
				"INSERT INTO SUBASTA VALUES (7,'01-07-2018','JOSE LUIS RUIZ','VALENCIA',07,7,34400);" + 
				"INSERT INTO SUBASTA VALUES (8,'01-08-2018','JOSE LUIS RUIZ','VALENCIA',10,5,34400);" + 
				"INSERT INTO SUBASTA VALUES (9,'01-09-2018','JOSE LUIS RUIZ','BARCELONA',10,4,734400);" + 
				"INSERT INTO SUBASTA VALUES (10,'01-10-2018','JOSE LUIS RUIZ','BARCELONA',05,5,934400);";
		
		try {
			connect = DriverManager.getConnection(connectionUrl);
			if(connect != null) {
				Statement serverStatement = connect.createStatement();
				int rowsAffected = serverStatement.executeUpdate(query);
				System.out.println("Registros afectados: "+ rowsAffected);
			}
			System.out.println("Conectado.");
		} catch (SQLException ex) {
			System.out.println("Tabla No afectada. Error.");
			ex.printStackTrace();
		} finally {

			try {
				System.out.println("Datos insertados");
				connect.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public static void pruebaConexion() {

		try {
			connect = DriverManager.getConnection(connectionUrl);

			System.out.println("Conectado.");
		} catch (SQLException ex) {
			System.out.println("error.");
			ex.printStackTrace();
		} finally {

			try {
				connect.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void crearTablasLibreria() {
		
		String query = "CREATE TABLE LIBRERIA(" + 
				"ID char (10) NOT NULL," + 
				"AUTOR char (30) NULL," + 
				"TITULO char (30) NULL," + 
				"GENERO char (30) NULL," + 
				"PRECIO char (30) NULL," + 
				"FECHA char (30) NULL," + 
				"DESCRIPCION char (60) NULL," + 
				"CONSTRAINT PK_LIBRERIA PRIMARY KEY (ID));";
		
		try {
			connect = DriverManager.getConnection(connectionUrl);
			if(connect != null) {
				Statement serverStatement = connect.createStatement();
				serverStatement.executeUpdate(query);
			}
			System.out.println("Conectado.");
		} catch (SQLException ex) {
			System.out.println("Tabla No creada. Error.");
			ex.printStackTrace();
		} finally {

			try {
				System.out.println("Tabla creada");
				connect.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public static void insertarRegistroUnicoCatalogoLibros(Libro[] libroList) {

		/*
		 * int ids = libroList.length; System.out.println(ids);
		 * 
		 * int id = ids+1; System.out.println(id);
		 */

		for (int i = 0; i < libroList.length; i++) {

			String query = "INSERT INTO LIBRERIA (ID,AUTOR,TITULO,GENERO,PRECIO,FECHA,DESCRIPCION) " + "VALUES ('"
					+ libroList[i].getId() + "','" + libroList[i].getAutor() + "','" + libroList[i].getTitulo() + "','"
					+ libroList[i].getGenero() + "','" + libroList[i].getPrecio() + "','" + libroList[i].getFecha()
					+ "','" + libroList[i].getDescripcion() + "');";

			try {
				connect = DriverManager.getConnection(connectionUrl);
				if (connect != null) {
					Statement serverStatement = connect.createStatement();
					int rowsAffected = serverStatement.executeUpdate(query);
					System.out.println("Registros afectados: " + rowsAffected);
				}
				System.out.println("Conectado.");
				System.out.println("Datos insertados");
			} catch (SQLException ex) {
				System.out.println("Tabla No afectada. Error.");
				System.out.println("");
				ex.printStackTrace();
			} finally {

				try {

					connect.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}
	
	public static void consultaDatosLibreria() {
		String query = "select * from LIBRERIA;";
		
		try {
			connect = DriverManager.getConnection(connectionUrl);
			if(connect != null) {
				Statement serverStatement = connect.createStatement();
				ResultSet resultSet = serverStatement.executeQuery(query);
				while(resultSet.next()) {
					
					/*
					 * ID,AUTOR,TITULO,GENERO,PRECIO,FECHA,DESCRIPCION
					 */
					
					System.out.println("ID: " + resultSet.getString(1) + ", "
							+ "AUTOR: " + resultSet.getString(2) + ", "
							+ "TITULO: " + resultSet.getString(3) + ", "
							+ "GENERO: " + resultSet.getString(4) + ", " 
							+ "PRECIO: " + resultSet.getString(5) + ", "
							+ "FECHA: " + resultSet.getString(6) + ", "
							+ "DESCRIPCION: " + resultSet.getString(7) + ", ");
				}
			}
			System.out.println("Conectado.");
		} catch (SQLException ex) {
			System.out.println("Datos No mostrados. Error.");
			ex.printStackTrace();
		} finally {

			try {
				System.out.println("Datos mostrados");
				connect.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void consulta() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Consulta por número de Género y Precio.");
		System.out.println("");
		System.out.println("Introduce el género o 0: ");
		String genero = scanner.next();
		
		System.out.println("Introduce el precio o 0: ");
		String precio = scanner.next();
		if(!genero.equals("0")) {
			consultaGenero(genero);
		}
		if(!precio.equals("0")) {
			consultaPrecio(precio);
		}
		
	}
	
	public static void consultaGenero(String genero) {
		String query = "select * from LIBRERIA where [GENERO]='"+genero+"';";
		
		try {
			connect = DriverManager.getConnection(connectionUrl);
			if(connect != null) {
				Statement serverStatement = connect.createStatement();
				ResultSet resultSet = serverStatement.executeQuery(query);
				while(resultSet.next()) {
					
					/*
					 * ID,AUTOR,TITULO,GENERO,PRECIO,FECHA,DESCRIPCION
					 */
					
					System.out.println("ID: " + resultSet.getString(1) + ", "
							+ "AUTOR: " + resultSet.getString(2) + ", "
							+ "TITULO: " + resultSet.getString(3) + ", "
							+ "GENERO: " + resultSet.getString(4) + ", " 
							+ "PRECIO: " + resultSet.getString(5) + ", "
							+ "FECHA: " + resultSet.getString(6) + ", "
							+ "DESCRIPCION: " + resultSet.getString(7) + ", ");
				}
			}
			System.out.println("Conectado.");
		} catch (SQLException ex) {
			System.out.println("Datos No mostrados. Error.");
			ex.printStackTrace();
		} finally {

			try {
				System.out.println("Datos mostrados");
				connect.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void consultaPrecio(String precio) {
		String query = "select * from LIBRERIA where [PRECIO] ='"+precio+"';";
		
		try {
			connect = DriverManager.getConnection(connectionUrl);
			if(connect != null) {
				Statement serverStatement = connect.createStatement();
				ResultSet resultSet = serverStatement.executeQuery(query);
				while(resultSet.next()) {
					
					/*
					 * ID,AUTOR,TITULO,GENERO,PRECIO,FECHA,DESCRIPCION
					 */
					
					System.out.println("ID: " + resultSet.getString(1) + ", "
							+ "AUTOR: " + resultSet.getString(2) + ", "
							+ "TITULO: " + resultSet.getString(3) + ", "
							+ "GENERO: " + resultSet.getString(4) + ", " 
							+ "PRECIO: " + resultSet.getString(5) + ", "
							+ "FECHA: " + resultSet.getString(6) + ", "
							+ "DESCRIPCION: " + resultSet.getString(7) + ", ");
				}
			}
			System.out.println("Conectado.");
		} catch (SQLException ex) {
			System.out.println("Datos No mostrados. Error.");
			ex.printStackTrace();
		} finally {

			try {
				System.out.println("Datos mostrados");
				connect.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
