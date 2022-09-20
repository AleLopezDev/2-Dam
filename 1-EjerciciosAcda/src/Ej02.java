import java.io.*;
import java.util.Scanner;

public class Ej02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("introduce ruta: ");
		String dir = sc.next();

		File f = new File(dir);
		//listarDirectorios(f);
		listarDirectoriosRecursividad(f);
	}

	private static void listarDirectoriosRecursividad(File f) {
		// TODO Auto-generated method stub
		String[] archivos = f.list();
		for (String i : archivos) {

			System.out.println(i);
			File f2 = new File(f.getAbsolutePath(),i);
			
			if(f2.isDirectory()) {
				listarDirectorios(f2);
			}
			
		}

	}

	public static void listarDirectorios(File f) {

		String[] archivos = f.list();

		for (String i : archivos) {

			System.out.println(i);

			File f1 = new File(f.getAbsolutePath(), i);
			String[] archivos2 = f1.list();

			if (f1.isDirectory()) {
				for (String x : archivos2) {
					System.out.println(x);
				}
			}
		}

	}
}
