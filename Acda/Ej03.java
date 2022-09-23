import java.io.*;
import java.util.Scanner;

// Java no es capaz de borrar directorios con archivos dentro de el

public class Ej03 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		File f = new File("C:\\Users\\usuario\\Desktop\\AcdaFicheros\\pepe");
		// sinRecursividad(f);

		// conRecursividad(f);
		deleteDirectory(f);

	}

	public static void conRecursividad(File f) {

		System.out.println(f.getName());

		File[] entries = f.listFiles();
		if (entries != null) {

			for (File i : entries) {

				System.out.println("Archivo borrado " + i.getName());
				i.delete();
				conRecursividad(i);

			}

			f.delete();
		}

	}

	static public void deleteDirectory(File path) {
		if (path.exists()) {
			File[] files = path.listFiles();
			for (int i = 0; i < files.length; i++) {
				if (files[i].isDirectory()) {
					deleteDirectory(files[i]);
				} else {
					files[i].delete();
				}
			}
		}
	}

	public static void sinRecursividad(File f) {

		File[] archivos = f.listFiles();

		for (File x : archivos) {

		}

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
