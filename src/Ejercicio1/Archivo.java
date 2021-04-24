package Ejercicio1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeSet;

public class Archivo {

	// Si en la variable ruta recibe solo un nombre de un archivo, entonces crea ese
	// archivo dentro del proyecto
	// Si en ruta recibe una ruta absoluta, entonces lo crea en esa ruta

	private String rutaCargar;
	private String rutaGuardar;

	public String getRutaCargar() {
		return rutaCargar;
	}

	public void setRutaCargar(String rutaCargar) {
		this.rutaCargar = rutaCargar;
	}

	public String getRutaGuardar() {
		return rutaGuardar;
	}

	public void setRutaGuardar(String rutaGuardar) {
		this.rutaGuardar = rutaGuardar;
	}

	public boolean existeCargar() {
		File archivo = new File(rutaCargar);
		if (archivo.exists())
			return true;
		return false;
	}

	public boolean creaArchivoCargar() {
		FileWriter escritura;
		try {
			escritura = new FileWriter(rutaCargar, true);
			escritura.write("");
			escritura.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean existeGuardar() {
		File archivo = new File(rutaGuardar);
		if (archivo.exists())
			return true;
		return false;
	}

	public boolean creaArchivoGuardar() {
		FileWriter escritura;
		try {
			escritura = new FileWriter(rutaGuardar, true);
			escritura.write("");
			escritura.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public void escribe_lineas(String frase) {
		try {
			FileWriter entrada = new FileWriter(rutaCargar, true);
			BufferedWriter miBuffer = new BufferedWriter(entrada);
			miBuffer.write(frase);
			miBuffer.close();
			entrada.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void escribeArchivo(TreeSet<Persona> listaPersonas) {
		System.out.println("Guardando archivo");
		try {
			FileWriter guardar = new FileWriter(rutaGuardar, false);
			BufferedWriter miBuffer = new BufferedWriter(guardar);

			for (Persona item : listaPersonas) {
				miBuffer.write(item.getApellido() + "-" + item.getNombre() + "-" + item.getDni() + "\n");
			}

			miBuffer.close();
			guardar.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public TreeSet<Persona> leeArchivo() {
		System.out.println("Leyendo Archivo de Personas");
		TreeSet<Persona> listaPersonasAux = new TreeSet<Persona>();
		TreeSet<Persona> listaPersonas = new TreeSet<Persona>();
		FileReader entrada;
		String linea = "";
		String[] contenido = null;
		Persona persona = new Persona();

		try {
			entrada = new FileReader(rutaCargar);

			BufferedReader miBuffer = new BufferedReader(entrada);

			while (linea != null) {

				persona = new Persona();

				if (linea != "") {

					contenido = linea.split("\n-");

					for (int i = 0; i < contenido.length; i++) {

						if (contenido[i] != "") {
							persona.setNombre(contenido[i].split("-")[0]);
							persona.setApellido(contenido[i].split("-")[1]);
							persona.setDni(contenido[i].split("-")[2]);
						}
					}
					listaPersonasAux.add(persona);					
				}
				linea = miBuffer.readLine();
			}
			miBuffer.close();
			entrada.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (Persona item : listaPersonasAux) {
			try {
				if (persona.verificarDniInvalido(item.getDni())) {
					listaPersonas.add(item);
				}
			} catch (DniInvalidoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return listaPersonas;
	}
}
