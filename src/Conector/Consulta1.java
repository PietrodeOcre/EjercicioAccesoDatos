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
		try {
			sSQL = "select * from prueba;";
		
			//PreparedStatement pstm = conn.prepareStatement(sSQL);
			Statement st = conn.createStatement();
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

			//System.out.println(pstm.executeQuery("select * from prueba;"));
			
			
			
		} catch ( SQLException e) {
			e.printStackTrace();
		}finally {
			
		}
	}

	

}
