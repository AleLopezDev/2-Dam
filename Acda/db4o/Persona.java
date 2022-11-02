package db4o;

public class Persona {

	private String nombre;
	private String ciudad;

	public Persona(String nombre, String ciudad) {
		this.nombre = nombre;
		this.ciudad = ciudad;
	}

	public Persona() {

	}
	


	// GETTERS Y SETTERS
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setCiudad(String dir) {
		this.ciudad = dir;
	}

	public String getCiudad() {
		return ciudad;
	}
}
