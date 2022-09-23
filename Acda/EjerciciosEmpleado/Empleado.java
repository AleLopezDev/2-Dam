package ejerciciosempleado;
import java.io.Serializable;

public class Empleado implements Serializable {
	int identificador;
	String nombre;
	double sueldo;

	public Empleado(int identificador, String nombre, double sueldo) {
		this.identificador = identificador;
		this.nombre = nombre;
		this.sueldo = sueldo;
	}

	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

}
