package practicasTemarioGit;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class EscribirBinario_05 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		ArrayList<Departamento> dep = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		File f = new File("C:\\Users\\usuario\\Desktop\\AcdaFicheros\\Departamentos.dat");
		FileOutputStream fileout = new FileOutputStream(f);
		ObjectOutputStream objectouput = new ObjectOutputStream(fileout);

		for (int i = 0; i < 2; i++) {

			System.out.println("Escribe el numero: ");
			int num = sc.nextInt();

			System.out.println("Escribe el nombre: ");
			String nom = sc.next();

			System.out.println("Escribe la loc");
			String loc = sc.next();

			dep.add(new Departamento(num, nom, loc));
		

		}
		objectouput.writeObject(dep);
	

	}

}
