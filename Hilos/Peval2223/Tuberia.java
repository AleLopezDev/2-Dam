package peval2223;

import java.util.ArrayList;
import java.util.Arrays;

public class Tuberia {

	private static Integer[] numeroNoAñadidos = { 5, 7, 9, 12, 16, 17, 21, 25, 26, 27 };
	private static ArrayList<String> listaCenso = new ArrayList<>();

	boolean estanEnCenso = false;

	public void votar(String nombre) {

		// System.out.println("Ha llegado el votador " + nombre);
		//checkearCenso(nombre);
		
		// mostrarArray();

		// System.out.println("Esta checkeando si esta en el censo ");

	}

	public void checkearCenso(String nombre) {

		System.out.println("El nombre es " + nombre);

		if (Arrays.asList(listaCenso).contains(nombre)) {
			System.out.println("El votador " + nombre + " esta en el censo ");
		}
		System.out.println("No esta");

	}

	public Integer[] getNumeroNoAñadidos() {
		return numeroNoAñadidos;
	}

	public static ArrayList<String> getListaCenso() {
		return listaCenso;
	}

	public boolean isEstanEnCenso() {
		return estanEnCenso;
	}

	public void mostrarArray() {
		for (String i : listaCenso) {
			System.out.println(i);
		}
	}

}
