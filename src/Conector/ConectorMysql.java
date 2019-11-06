package Conector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.cj.jdbc.Driver;;

public class ConectorMysql {

	// Librería de MySQL
	public String driver = "com.mysql.cj.jdbc.Driver";

	// Nombre de la base de datos
	public String database = "prueba1";

	// Host
	public String hostname = "192.168.0.104";

	// Puerto
	public String port = "3306";

	// Ruta de nuestra base de datos (desactivamos el uso de SSL con
	// "?useSSL=false")
	//public String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database;/* + "?useSSL=false";*/
	public String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	// Nombre de usuario
	public String username = "pietro";

	// Clave de usuario
	public String password = "1234";

	public Connection conectarMySQL() {
		Connection conn = null;

		try {
			Class.forName(driver);
			conn = (Connection)DriverManager.getConnection(url, username, password);
			System.out.println("conexion exitosa");
		} catch (ClassNotFoundException | SQLException e) {
			
			System.out.println("SqlException: " + e.getMessage());

		}

		return conn;
	}

}
