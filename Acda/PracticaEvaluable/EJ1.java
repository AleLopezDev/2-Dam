package peval1acda2223;

import java.util.Scanner;
import java.io.*;

// Ruta /home/alex/ficherosAcda/practicaEvaluable

// Ej 3 guardar en un archivos de objetos
// Ej6 
// Controlar todas las excepciones

public class EJ1 {

	static Busqueda bus = new Busqueda();

	public static void main(String[] args) {

		detetectarArchivo();

	}

	// Metodo para detectar si existe Companies.txt en un directorio
	public static void detetectarArchivo() {

		Scanner sc = new Scanner(System.in);

		System.out.println("Introduzca una ruta: ");
		String ruta = sc.next();

		File f = new File(ruta);
		bus.busquedaArchivo(f);
	}

}