import java.io.*;
import java.util.Scanner;

// Java no es capaz de borrar directorios con archivos dentro de el

public class Ej03 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		File f = new File("C:\\Users\\usuario\\Desktop\\AcdaFicheros\\pepe");
		// sinRecursividad(f);

		// conRecursividad(f);
		listDir(f);

	}

	public static void listDir(File dir) {

		File elements[] = dir.listFiles();

		for (File element : elements) {
			if (element.isFile() && !element.equals(".") && !element.equals("..")) {
				System.out.println(element);
			} else if (element.isDirectory()) {
				listDir(element.getAbsoluteFile());
			}

		}
	}

	public static void conRecursividad(File f) {

		System.out.println(f.getName());
		// if (f.isDirectory()) {
		File[] entries = f.listFiles();
		if (entries != null) {

			for (File i : entries) {
				// System.out.println( i);
				System.out.println("Archivo borrado " + i.getName());
				i.delete();
				conRecursividad(i);

			}

			f.delete();
		}
		// }

	}

	public static void sinRecursividad(File f) {

		File[] numero = f.listFiles();
		System.out.println(numero.length);

	}

	/*
	 * private static void sinRecursividad(File f) { String[] archivos = f.list();
	 * 
	 * for (String x : archivos) { File f2 = new File(f.getPath(), x); String[]
	 * archivos2 = f2.list();
	 * 
	 * if (f2.isDirectory()) { for (String i : archivos2) { File f3 = new
	 * File(f2.getPath(), i); f3.delete(); }
	 * 
	 * } f2.delete();
	 * 
	 * } f.delete(); }
	 */

}
