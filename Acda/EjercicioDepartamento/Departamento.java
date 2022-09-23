package ejerciciosdepartamento;
import java.io.Serializable;

public class Departamento implements Serializable {

	private int num;
	private String nombre, loc;

	public Departamento(int num, String nombre, String loc) {

		this.num = num;
		this.nombre = nombre;
		this.loc = loc;

	}

	public Departamento() {

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
