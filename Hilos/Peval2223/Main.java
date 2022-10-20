package peval2223;

import java.util.Arrays;

public class Main {

	private static Tuberia t = new Tuberia();

	public static void main(String[] args) {

		rellenarArray();

		for (int i = 1; i <= 30; i++) {
			Votador v = new Votador(t);
			v.setName(Integer.toString(i));
			v.start();
		}

	}

	public static void rellenarArray() {

		for (int i = 1; i <= 30; i++) {

			if (!Arrays.asList(t.getNumeroNoAñadidos()).contains(i)) {
				t.getListaCenso().add(Integer.toString(i));
			}
		}

	}

}
