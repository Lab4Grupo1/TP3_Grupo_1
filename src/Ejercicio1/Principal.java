package Ejercicio1;

public class Principal {

	public static void main(String[] args) {

		Archivo archivo = new Archivo();
		archivo.setRutaCargar("Personas.txt");

		if (archivo.existeCargar()) {
			System.out.println("Existe archivo cargar");
		} else {
			System.out.println("No existe archivo cargar, entonces lo creo");
			archivo.creaArchivoCargar();
		}

		archivo.setRutaGuardar("Resultado.txt");

		if (archivo.existeGuardar()) {
			System.out.println("Existe archivo guardar");
		} else {
			System.out.println("No existe archivo guardar, entonces lo creo");
			archivo.creaArchivoGuardar();
		}

		try {
			// LECTURA:
			System.out.println("\n A CONTINUACIÓN LEE LAS LINEAS: ");
			archivo.escribeArchivo(archivo.leeArchivo());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
