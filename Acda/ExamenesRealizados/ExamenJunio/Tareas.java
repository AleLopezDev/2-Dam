package examenJunio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

public class Tareas {

	Statement sentencia;

	public Tareas(Statement sentencia) {
		this.sentencia = sentencia;
	}

	public void volcarBaseDatos() {

		File f = new File("/home/alex/nuevosHermanos.txt");

		try {
			BufferedReader leer = new BufferedReader(new FileReader(f));

			String linea = "";

			while ((linea = leer.readLine()) != null) {

				String[] lin = linea.split("#");

				// sentencia.executeUpdate(
				// "insert into hermandades values(" + lin[0] + ',' + lin[1] + ',' + lin[2] +
				// ',' + lin[4] + ")");

				System.out.println("insert into hermanos values('" + lin[0] + "','" + lin[1] + "','" + lin[2] + ",'"
						+ lin[3] + "'," + (int) (Math.random() * ((2022 - 1930) + 1) + 1930) + "," + lin[4] + ")"); // Continuar

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
