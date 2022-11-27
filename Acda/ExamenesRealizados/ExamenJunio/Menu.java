package examenJunio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.Scanner;

/**
 * Clase Menu - Contiene sus atributos y métodos correspondientes Menu para que
 * el usuario seleccione una opción de las disponibles
 * 
 * @author Alejandro Lopez - 2ºDAM
 * @date 16/11/2022
 */
public class Menu {

	private static int opcion = 0;
	private static Scanner sc = new Scanner(System.in);
	private static Tareas tareas;
	private static Connection conexion;
	private static Statement sentencia;

	public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException {

		// Realiza la conexión con la bd mysql
		realizarConexion();

		while (opcion != 9) {

			// imprime lista opciones disponible
			System.out.println(
					"1 - Volcar Base de Datos\n");

			System.out.print("Teclee opción:");
			opcion = sc.nextInt();

			switch (opcion) {

			case 1:
				tareas.volcarBaseDatos();
				break;
			
			case 9:
				cerraConexion();
				break;

			}

		}

	}

	/**
	 * Método que realiza la conexion con la base de datos
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static void realizarConexion() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conexion = DriverManager.getConnection("jdbc:mysql://localhost/hermandades", "root", "");
		sentencia = conexion.createStatement();

		tareas = new Tareas(sentencia);
	}

	/**
	 * Metodo que cierra la conexion con la base de datos
	 */
	public static void cerraConexion() {

		try {
			conexion.close();
			sentencia.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}