package ExamenJunio;

public class Main {

	
	static Tuberia t = new Tuberia();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hilo h1 = new Hilo(t);
		Thread t = new Thread(h1);
		t.start();

	}

}
