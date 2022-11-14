public class Usuario {

	private int codigoUsuario;
	private String nombre, apellidos, dni, domicilio, poblacion, provincia, fechaNacimiento;

	public Usuario(int codigoUsuario, String nombre, String apellidos, String dni, String domicilio, String poblacion,
			String provincia, String fechaNacimiento) {
		this.codigoUsuario = codigoUsuario;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.domicilio = domicilio;
		this.poblacion = poblacion;
		this.provincia = provincia;
		this.fechaNacimiento = fechaNacimiento;
	}

}