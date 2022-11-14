import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Menu {

	private static int opcion = 0;
	private static Scanner sc = new Scanner(System.in);
	private static Tareas tareas;
	private static Connection conexion;
	private static Statement sentencia;

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// Realiza la conexión con la bd mysq
		realizarConexion();

		while (opcion != 9) {

			System.out.println(
					"1 - Transformar SQL a Neodatis\n2 - Altas de libros\n3 - Bajas de usuarios\n4 - Modificaciones de préstamos\n5 - Prestamos de usuario que han entregado con retraso\n6 - Libros de género determinado\n7 - Prestamos realizados en un periodo de tiempo\n");

			System.out.print("Teclee opción:");
			opcion = sc.nextInt();

			switch (opcion) {

			case 1:
				tareas.transformarNeodatis();
				break;
			case 2:
				tareas.altaLibros();
				break;
			case 3:
				tareas.bajaUsuarios();
				break;
			case 4:
				tareas.modificarPrestamo();
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
			case 9:
				cerraConexion();
				break;

			}

		}

	}

	public static void realizarConexion() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conexion = DriverManager.getConnection("jdbc:mysql://localhost/3peval", "root", "");
		sentencia = conexion.createStatement();

		tareas = new Tareas(sentencia);
	}

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