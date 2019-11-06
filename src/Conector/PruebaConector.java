package Conector;

import java.io.*;
import java.sql.*;

import com.mysql.cj.util.TimeUtil;

public class PruebaConector {

	public static void main(String[] args) throws SQLException, IOException {
		BufferedReader key = new BufferedReader(new InputStreamReader(System.in));
		String user, password;
		String driverJDBC = "com.mysql.cj.jdbc.Driver";
		System.out.println("Usuario");
		user = key.readLine();
		System.out.println("contraseña");
		password = key.readLine();

		try {
			TimeUtil.class.getResourceAsStream(driverJDBC);
			Class.forName(driverJDBC);
			
			Connection conexion = DriverManager.getConnection("jdbc:mysql://192.168.0.104/prueba1?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", user, password);
			//TimeUtil.class.getResourceAsStream(driverJDBC);
			Statement st = conexion.createStatement();
			//st.executeUpdate("DROP TABLE IF EXISTS personal;");
			//st.executeUpdate(
					//"CREATE TABLE personal (`Identificador` int(11) NOT NULL AUTO_INCREMENT, `Nombre` varchar(50) NOT NULL, `Apellidos` varchar(50) NOT NULL, `Telefono` varchar(9) DEFAULT NULL, `Email` varchar(60) DEFAULT NULL, PRIMARY KEY (`Identificador`));");
			//st.executeUpdate(
					//"INSERT INTO personal (`Identificador`, `Nombre`, `Apellidos`, `Telefono`, `Email`) VALUES (1, 'José', 'Martínez López', '968112233', 'jose@martinezlopez.com'), (2, 'María', 'Gómez Muñoz', '911876876', 'maria@gomezoliver.com'), (3, 'Juan', 'Sánchez Fernández', '922111333', 'juan@sanchezfernandez.com'), (4, 'Ana', 'Murcia Rodríguez', '950999888', 'ana@murciarodriguez.com');");
			ResultSet rs = st.executeQuery("SELECT * FROM prueba;");

			if (rs != null) {
				System.out.println("El listado de persona es el siguiente:");

				while (rs.next()) {
					System.out.println("  ID: " + rs.getObject("id"));
					System.out.println("  Nombre: " + rs.getObject("nombre") + ""
							+ " " + rs.getObject("Apellidos"));
					System.out.println("  Edad: " + rs.getObject("edad"));
					System.out.println("- ");
				}
				rs.close();
			}
			st.close();

		} catch (SQLException s) {
			System.out.println("Error: SQL.");
			System.out.println("SQLException: " + s.getMessage());
		} catch (Exception s) {
			System.out.println("Error: Varios.");
			System.out.println("SQLException: " + s.getMessage());
		}
		System.out.println("FIN DE EJECUCIÓN.");
	}

}
