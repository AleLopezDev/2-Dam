
import java.util.Arrays;

public class Main {

	private static Tuberia t = new Tuberia();

	public static void main(String[] args) {

		for (int i = 1; i <= 30; i++) {
			Votador v = new Votador(t);
			v.setName(Integer.toString(i));
			v.start();
		}

	}



}