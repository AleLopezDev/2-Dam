package peval1acda2223;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EJ2 {

	static Busqueda bus = new Busqueda();

	public static void main(String[] args) throws IOException {

		renombrarArchivo();
	}

	public static void renombrarArchivo() throws IOException {

		Scanner sc = new Scanner(System.in);

		System.out.println("Introduzca una ruta: ");
		String ruta = sc.next();

		File f = new File(ruta);

		boolean existe = bus.busquedaArchivo(f);

		if (existe) {

			String rutaArchivo = bus.devolverRuta();

			// Archivo de lectura
			File f1 = new File(rutaArchivo);

			// Archivos de lectura
			BufferedReader leer = new BufferedReader(new FileReader(rutaArchivo));

			// Archivos de escritura
			File f2 = new File(ruta + File.separator + "Companies.tmp");

			BufferedWriter escribir = new BufferedWriter(new FileWriter(f2));
			System.out.println();

			// Leer de un fichero y escribir en el otro
			String linea;

			while ((linea = leer.readLine()) != null) {
				if (linea.contains("Purchasing")) {

					escribir.write(linea.replace("Purchasing", "Investor"));
				} else {
					escribir.write(linea);
				}
				escribir.newLine();

			}
			
			
			// Arreglar, no funciona en mi windows

			if (!f1.delete()) {
				System.out.println("fallo al renombrar");
			}
			if (!f2.renameTo(f1)) {
				System.out.println("fallo al renombrar");
			}

			leer.close();
			escribir.close();

		}

	}

}