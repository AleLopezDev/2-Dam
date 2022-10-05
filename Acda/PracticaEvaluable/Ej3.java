package peval1acda2223;

import java.io.*;

public class Ej3 {

	public static void main(String[] args) throws IOException {

		BufferedReader leer = new BufferedReader(new FileReader("/home/alex/ficherosAcda/practicaEvaluable/Companies.txt"));

		String linea;

		while ((linea = leer.readLine()) != null) {
			String[] lin = linea.split("#");
			System.out.println(lin[0]);
		}

	}

}
