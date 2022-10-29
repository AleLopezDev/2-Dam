package peval2223sql;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class Tareas {

	private static ResultSet ultimoNumeroEmpleado, nombreJugador;
	private static Statement sentencia;
	private static int numeroMaxEmpleado;

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/peval2223", "root", "");
		sentencia = conexion.createStatement();

		try {
			insertarNuevosFichajes();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void insertarNuevosFichajes() throws IOException {

		// Cambiar para que el usuario pueda introducir la ruta

		String ruta = "/home/alex/Peval2223SQL/fichajes.txt";
		File f = new File(ruta);

		if (!f.exists()) {
			System.out.println("No existe");
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

}
