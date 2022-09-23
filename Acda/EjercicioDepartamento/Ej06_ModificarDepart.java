package ejerciciosdepartamento;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Ej06_ModificarDepart {

	static Departamento d;

	public static void main(String[] args) throws IOException, Exception {

		Scanner sc = new Scanner(System.in);

		// Archivo principal
		File f = new File("C:\\Users\\usuario\\Desktop\\AcdaFicheros\\Departamentos.dat");

		// lectura

		FileInputStream fr = new FileInputStream(f);
		ObjectInputStream archivoLectura = new ObjectInputStream(fr);

		// Escritura y Nuevo Archivo temporal
		FileOutputStream fw = new FileOutputStream("C:\\Users\\usuario\\Desktop\\AcdaFicheros\\DepartTemp.dat");
		ObjectOutputStream escribir = new ObjectOutputStream(fw);

		System.out.println("Introduce el departamento a modificar : ");
		int id = sc.nextInt();

		try {
			while (true) {
				d = (Departamento) archivoLectura.readObject(); // Lee un departamento del fichero principal

				if (d.getNum() == id) {

					System.out.println("Introduce el nombre nuevo: ");
					String n = sc.next();
					d.setNombre(n);

					System.out.println("Introduce la localizacion nueva: ");
					String loc = sc.next();
					d.setLoc(loc);

				}
				escribir.writeObject(d);

			}
		} catch (EOFException e) {

		}

		archivoLectura.close();
		escribir.close();
		renombrar();
	}

	public static void renombrar() throws IOException, Exception {

		// Lee el archivo temporal
		File f = new File("C:\\Users\\usuario\\Desktop\\AcdaFicheros\\DepartTemp.dat");
		FileInputStream fr = new FileInputStream(f);
		ObjectInputStream archivoLectura = new ObjectInputStream(fr);

		// Escribe sobre el archivo departamento.dat
		FileOutputStream fw = new FileOutputStream("C:\\Users\\usuario\\Desktop\\AcdaFicheros\\Departamentos.dat");
		ObjectOutputStream escribir = new ObjectOutputStream(fw);

		try {
			while (true) {
				d = (Departamento) archivoLectura.readObject(); // Lee un departamento
				escribir.writeObject(d); // Escribe el departamento
			}
		} catch (EOFException e) {
		}

		archivoLectura.close();
		escribir.close();

		f.delete(); // Borramos el archivo temporal
	}
}
