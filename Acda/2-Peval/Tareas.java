
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class Tareas {

	private static Statement sentencia;
	private static int numeroMaxEmpleado;
	private static Scanner sc = new Scanner(System.in);

	public Tareas() {

	}

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/peval2223", "root", "");
		sentencia = conexion.createStatement();

		actualizarPosicion();

	}

	public static void insertarNuevosFichajes() throws IOException {
		ResultSet ultimoNumeroEmpleado, nombreJugador;
		// Cambiar para que el usuario pueda introducir la ruta

		String ruta = "C:\\Users\\usuario\\Documents\\Acda\\fichajes.txt";
		File f = new File(ruta);

		if (!f.exists()) {
			System.out.println("No existe esa ruta, cambiala arriba");
		} else {
			BufferedReader leer = new BufferedReader(new FileReader(f));

			String linea = "";

			while ((linea = leer.readLine()) != null) {

				String[] lin = linea.split(";");

				try {

					nombreJugador = sentencia
							.executeQuery("Select nombre from jugadores where nombre = '" + lin[0] + "'");

					if (nombreJugador.next()) {
						System.out.println("Ya existe el jugador " + lin[0]);
					} else {
						ultimoNumeroEmpleado = sentencia.executeQuery("SELECT MAX(codigo) FROM jugadores");
						ultimoNumeroEmpleado.next();
						numeroMaxEmpleado = ultimoNumeroEmpleado.getInt(1) + 1;
						sentencia.executeUpdate(
								"insert into jugadores values(" + numeroMaxEmpleado + ",'" + lin[0] + "','" + lin[1]
										+ "','" + lin[2] + "'," + lin[3] + ",'" + lin[4] + "','" + lin[5] + "')");
					}
				} catch (SQLIntegrityConstraintViolationException e1) {
					// TODO Auto-generated catch block
					System.out.println("El equipo " + lin[5] + " no existe en la tabla equipos");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}

	}

	// Ejercicio 3
	public static void mostrarDatosJugadores() {
		ResultSet existeCiudad, datosJugadores;

		System.out.println("Introduce la ciudad a mostrar");
		String ciudad = sc.next();

		try {
			existeCiudad = sentencia.executeQuery("Select ciudad from equipos where ciudad like '" + ciudad + "'");

			if (existeCiudad.next()) {
				datosJugadores = sentencia.executeQuery(
						"SELECT jugadores.Nombre,Altura,Peso,Posicion,Nombre_equipo from jugadores,equipos where jugadores.Nombre_equipo = equipos.Nombre and ciudad like'"
								+ ciudad + "'");
				while (datosJugadores.next()) {
					System.out.println(datosJugadores.getString(1) + " - " + datosJugadores.getString(2) + " - "
							+ datosJugadores.getInt(3) + " - " + datosJugadores.getString(4) + " - "
							+ datosJugadores.getString(5));
				}
			} else {
				System.out.println("No existe la ciudad");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Ejercicio 4
	public static void visualizarNumeroPartidos() {
		ResultSet jugador, nombreEquipo, partidosLocal, partidosVisitantes;
		System.out.println("Introduce el nombre del jugador");
		String nombreJugador = sc.nextLine();

		try {
			jugador = sentencia.executeQuery("select Nombre from jugadores WHERE Nombre like '" + nombreJugador + "'");

			// Si existe el nombre del jugador
			if (jugador.next()) {

				partidosLocal = sentencia.executeQuery(
						"select equipo_local, count(temporada),temporada from jugadores,equipos,partidos WHERE partidos.equipo_local = equipos.Nombre and equipos.Nombre = jugadores.Nombre_equipo and jugadores.Nombre = '"
								+ nombreJugador + "' group by temporada");

				while (partidosLocal.next()) {
					System.out.println("Equipo Local:" + partidosLocal.getString(1) + " - " + " Temporada:"
							+ partidosLocal.getString(3) + " - " + " Num partidos:" + partidosLocal.getInt(2));
				}

				partidosLocal.close();

				partidosVisitantes = sentencia.executeQuery(
						"select equipo_visitante, count(temporada),temporada from jugadores,equipos,partidos WHERE partidos.equipo_visitante = equipos.Nombre and equipos.Nombre = jugadores.Nombre_equipo and jugadores.Nombre = '"
								+ nombreJugador + "' group by temporada");

				System.out.println("\n");

				while (partidosVisitantes.next()) {
					System.out.println("Equipo Visitante:" + partidosVisitantes.getString(1) + " - " + " Temporada:"
							+ partidosVisitantes.getString(3) + " - " + " Num partidos:"
							+ partidosVisitantes.getInt(2));
				}

				partidosVisitantes.close();

			} else {
				System.out.println("NO existe el jugador");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Ejercicio 5
	public static void actualizarPosicion() {
		try {
			sentencia.executeUpdate(
					"update jugadores,equipos set jugadores.posicion = 'pivote' where jugadores.Posicion like 'pivot' and jugadores.Nombre_equipo = equipos.Nombre and equipos.Division like 'Pacific' and equipos.Conferencia like 'West'");
			System.out.println("Posicion cambiada con exito");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}