package Ejercicio1;

import java.io.FileReader;
import java.util.TreeSet;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			
			Archivo leerArchivo1 = new Archivo();
			leerArchivo1.setRuta("Personas.txt");
			leerArchivo1.setRutaguardar("Resultado.txt");
			
			TreeSet<Persona> listaPersonas = new TreeSet<Persona>();
			leerArchivo1.leeProcesoArchivo(listaPersonas);
			System.out.println("encontr?");
			
		} catch (Exception e) {
			
		}
	}

}
