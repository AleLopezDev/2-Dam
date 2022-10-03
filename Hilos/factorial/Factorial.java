package factorial;

public class Factorial {

	public static void main(String[] args) {

		Hilo h1 = new Hilo();
		Hilo h2 = new Hilo();
		
		h1.pasarParamentor(4);
		h2.pasarParamentor(7);
		
		h1.start();
		h2.start();

	}

}
