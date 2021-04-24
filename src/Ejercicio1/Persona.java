package Ejercicio1;

public class Persona implements Comparable<Persona> {

	private int Dni;
	private String Nombre;
	private String Apellido;

	// Constructores

	public Persona() {
		this.Nombre = "";
		this.Apellido = "";
		this.Dni = 0;
	}

	public Persona(String apellido, String nombre, int dni) {
		this.Apellido = apellido;
		this.Nombre = nombre;
		this.Dni = dni;
		;
	}

	// gets y sets
	public int getDni() {
		return Dni;
	}

	public void setDni(int dni) {
		this.Dni = dni;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		this.Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		this.Apellido = apellido;
	}

	@Override
	public int compareTo(Persona persona) {

		// ORDENAMIENTO por APELLIDO de A a Z
		if (persona.Apellido.charAt(0) == this.Apellido.charAt(0))
			return 0;

		if (persona.Apellido.charAt(0) < this.Apellido.charAt(0)) {
			return 1;
		}
		return -1;
	}

	@Override
	public String toString() {
		return "Apellido: " + this.Apellido + " " + "Nombre: " + this.Nombre + " " + "Dni: " + this.Dni;
	}

	public boolean verificarDniInvalido(String cadena){
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}

}
