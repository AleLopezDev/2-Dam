package productorConsumidor;

public class Main {

	static Tuberia t = new Tuberia(10);

	public static void main(String[] args) {

		Productor p = new Productor(t);
		Consumidor c = new Consumidor(t);
		
		p.start();
		c.start();

	}

}
