
import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ej2 {
	static Statement sentencia;
	static Scanner sc = new Scanner(System.in);

	public Ej2() {

	}

	public static void Main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/peval2223", "root", "");
			sentencia = conexion.createStatement();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		insertarPartidos();

	}

	public static void insertarPartidos() {

		// Que los campos no esten vacios, que los
		// partidos no sean nulos, por ultimo insertar
		String eLocal = "", eVisitante = "", temporada = "";
		int pLocal = -1, pVisitante = 0;

		try {
			System.out.println("Introduce el codigo");
			int partido = sc.nextInt();

			while (eLocal.equalsIgnoreCase(eVisitante) ) {
				sc.nextLine();
				System.out.println("Introduce el equipo local");
				eLocal = sc.next();

				System.out.println("Introduce el equipo visitante");
				eVisitante = sc.next();
			}

			while (pLocal < 0 || pVisitante < 0) {
				System.out.println("Introduce los puntos del local");
				pLocal = sc.nextInt();

				System.out.println("Introduce los puntos del visitante");
				pVisitante = sc.nextInt();
			}

			sc.nextLine();

			while (temporada == "") {
				System.out.println("Introduce la temporada");
				temporada = sc.nextLine();
			}

			System.out.println("insert into partidos values(" + partido + ",'" + eLocal + "','" + eVisitante + "',"
					+ pLocal + "," + pVisitante + ",'" + temporada + "')");

		} catch (InputMismatchException e) {
			System.out.println("Introduce correctamente los valores");
		}
		sc.nextLine();

	}

}