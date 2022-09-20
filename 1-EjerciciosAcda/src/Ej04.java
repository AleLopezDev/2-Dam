import java.io.*;
import java.util.Scanner;

//Autor : Alejandro Lopez

public class Ej04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		System.out.println("introduce ruta: ");
		String dir = sc.next();

		File f = new File(dir);
		String[] archivos = f.list();

		for (String i : archivos) {

			System.out.println(i);

		}

	}

}
