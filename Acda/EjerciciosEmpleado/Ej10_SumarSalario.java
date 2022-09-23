package ejerciciosempleado;

import java.io.*;
import java.util.Scanner;

public class Ej10_SumarSalario {
	static Empleado e;
	static int identificador;
	static Double importeAntiguo;

	public static void main(String[] args) throws IOException, Exception {
		// TODO Auto-generated method stub

		File f = new File("C:\\Users\\usuario\\Desktop\\AcdaFicheros\\archivo.java");
		Scanner sc = new Scanner(System.in);

		// Lectura
		FileInputStream fr = new FileInputStream(f);
		ObjectInputStream lectura = new ObjectInputStream(fr);

		// Escritura
		FileOutputStream fw = new FileOutputStream("C:\\Users\\usuario\\Desktop\\AcdaFicheros\\archivo.tmp");
		ObjectOutputStream escritura = new ObjectOutputStream(fw);

		System.out.println("introduce el identificador: ");
		identificador = sc.nextInt();

		try {

			while (true) {
				e = (Empleado) lectura.readObject(); // Lee un empleado
				if (e.getIdentificador() == identificador) {
					System.out.println("Introduce el importe a añadir: ");
					double importe = sc.nextDouble();
					importeAntiguo = e.getSueldo();
					e.setSueldo(e.getSueldo() + importe);

				}

				escritura.writeObject(e);

			}

		} catch (EOFException eo) {
		}
		imprimirDatos();
		lectura.close();
		escritura.close();
	}

	private static void imprimirDatos() throws Exception {

		File f = new File("C:\\Users\\usuario\\Desktop\\AcdaFicheros\\archivo.tmp");

		// Lee archivo temporal
		FileInputStream fr = new FileInputStream(f);
		ObjectInputStream lectura = new ObjectInputStream(fr);

		// Escribe archivo.java
		FileOutputStream fw = new FileOutputStream("C:\\Users\\usuario\\Desktop\\AcdaFicheros\\archivo.java");
		ObjectOutputStream escritura = new ObjectOutputStream(fw);

		try {
			while (true) {
				e = (Empleado) lectura.readObject();
				escritura.writeObject(e);

				if (e.getIdentificador() == identificador) {
					System.out.println("Nombre: " + e.getNombre() + "\nSueldo: " + e.getSueldo() + "\nSueldo Antiguo: "
							+ importeAntiguo);
				}
			}
		} catch (EOFException eo) {
		}

		f.delete();
		lectura.close();
		escritura.close();
	}

}
