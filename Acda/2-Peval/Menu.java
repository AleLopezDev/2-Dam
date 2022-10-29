package peval2223sql;

import java.io.IOException;
import java.util.Scanner;

public class Menu {

	private static int opcion = 0;
	private static Scanner sc = new Scanner(System.in);
	
	private static Tareas t = new Tareas();
	private static Ej2 ej2 = new Ej2();
	
	
	public static void main(String[] args) {

		while (opcion != 99) {
			System.out.println(
					"1 - Actualizar tabla jugadores con nuevos fichajes\n2 - Insertar un partido\n3 - Mostrar datos de los jugadores de un equipo\n4 - Visualizar numero de partidos jugados por cada jugador\n5 - Actualizar la posicion de todos los jugadores\n6 - Eliminar datos de un equipo");

			opcion = sc.nextInt();

			switch (opcion) {

			case 1:

				try {
					t.insertarNuevosFichajes();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				break;
			case 2:
				ej2.insertarPartidos();
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;

			}
		}

	}

}
