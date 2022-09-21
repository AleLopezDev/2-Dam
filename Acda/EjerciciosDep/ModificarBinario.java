package practicasTemarioGit;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Realiza un programa Java que te permita modificar los datos de
	departamento. El programa lee el número de departamento a modificar, el nuevo
	nombre de departamento y la nueva localidad. Si el departamento no existe visualiza
	un mensaje indicándolo. Visualiza también los datos antiguos del departamento y los
	nuevos datos
 * 
 */

public class ModificarBinario {

	static Scanner sc = new Scanner(System.in);
	static ArrayList<Integer> nDepartamentos = new ArrayList<>();
	static ArrayList<Departamento> dep = new ArrayList<>();
	static File f = new File("C:\\Users\\usuario\\Desktop\\AcdaFicheros\\Departamentos.dat");

	public static void main(String[] args) throws Exception {

		comprobarNumero();

		System.out.println("Introduce el departamento: ");
		int n = sc.nextInt();

		if (nDepartamentos.contains(n)) {
			modificarDep(n);
		}

		imprimirFichero();

	}

	private static void comprobarNumero() throws Exception {

		FileInputStream fInput = new FileInputStream(f);
		ObjectInputStream oInput = new ObjectInputStream(fInput);

		dep = (ArrayList) oInput.readObject();

		for (Departamento e : dep) {
			nDepartamentos.add(e.getNum());
		}

		oInput.close();
	}

	private static void imprimirFichero() throws IOException, Exception {

		FileInputStream fInput = new FileInputStream(f);
		ObjectInputStream oInput = new ObjectInputStream(fInput);

		dep = (ArrayList) oInput.readObject();

		for (Departamento d : dep) {
			System.out.println("Numero:" + d.getNum() + " Nombre:" + d.getNombre() + " Localizacion:" + d.getLoc());
		}
	}

	private static void modificarDep(int n) throws IOException {

		FileOutputStream fOut = new FileOutputStream(f);
		ObjectOutputStream ojOut = new ObjectOutputStream(fOut);

		dep.get(n - 1).setLoc("manolito");
		ojOut.writeObject(dep);

		// Preguntar y comprobar cuando imprimo y terminar el ejercicio que el usuario introduzca loc y nombre
	}

}
