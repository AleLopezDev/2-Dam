import java.io.Serializable;

public class DepartamentoS implements Serializable {

	private int num;
	private String nombre, loc;

	public DepartamentoS(int num, String nombre, String loc) {

		this.num = num;
		this.nombre = nombre;
		this.loc = loc;

	}

	public DepartamentoS() {

	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

}
