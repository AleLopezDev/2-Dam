package ejerciciosempleado;

import java.io.*;
import java.util.Scanner;

/*
 * 
 * Crea un fichero Java que reciba un identificador de un empleado desde
 * teclado y visualice sus datos. Si el empleado no existe debe visualizar el mensaje
 * 
 */

public class Ej09_VisualizarDatos {

	public static void main(String[] args) throws IOException, Exception {
		// TODO Auto-generated method stub
		File f = new File("C:\\Users\\usuario\\Desktop\\AcdaFicheros\\archivo.java");
		Scanner sc = new Scanner(System.in);
		Empleado e;

		// Escritura
		FileOutputStream fw = new FileOutputStream(f);
		ObjectOutputStream escritura = new ObjectOutputStream(fw);

		// Lectura
		FileInputStream fr = new FileInputStream(f);
		ObjectInputStream lectura = new ObjectInputStream(fr);

		escritura.writeObject(new Empleado(22, "juan", 34));
		escritura.writeObject(new Empleado(124, "menisco", 22));

		System.out.println("Escribe el identificador");
		int n = sc.nextInt();

		try {
			while (true) {

				e = (Empleado) lectura.readObject();
				if (e.getIdentificador() == n) {
					System.out.println("Nombre: " + e.getNombre() + " - " + "sueldo: " + e.getSueldo() + " € ");
				}

			}
		} catch (EOFException eo) {
		}

		escritura.close();
		lectura.close();

	}

}
