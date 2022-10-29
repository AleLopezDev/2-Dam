package peval2223sql;

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

		// Que los puntos no sean negativos, que los equipos no sean iguales, que los
		// partidos no sean nulos
		int pLocal = -1, pVisitante = 0;

		try {
			System.out.println("Introduce el codigo");
			int partido = sc.nextInt();

			sc.nextLine();

			System.out.println("Introduce el equipo local");
			String eLocal = sc.nextLine();

			System.out.println("Introduce el equipo visitante");
			String eVisitante = sc.next();

			while (pLocal < 0) {
				System.out.println("Introduce los puntos del local");
				pLocal = sc.nextInt();
			}
			
			System.out.println("Introduce los puntos del visitante");
			pVisitante = sc.nextInt();

			sc.nextLine();

			System.out.println("Introduce la temporada");
			String temporada = sc.nextLine();

			System.out.println("insert into partidos values(" + partido + ",'" + eLocal + "','" + eVisitante + "',"
					+ pLocal + "," + pVisitante + ",'" + temporada + "')");

		} catch (InputMismatchException e) {
			System.out.println("Introduce correctamente los valores");

		}
		sc.nextLine();

		/*
		 * try { sentencia.executeUpdate("insert into partidos values("+partido + ",'" +
		 * eLocal + "','" + eVisitante + "',"+ pLocal + "," + pVisitante + ",'" +
		 * temporada + "')");
		 * 
		 * 
		 * } catch (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */

	}

}
