package serieNumeros;

public class Hilo extends Thread {

	public void run() {
		for (int i = 0; i < 40; i++) {
			System.out.println(i + " " + getName());
			try {
				Hilo.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
