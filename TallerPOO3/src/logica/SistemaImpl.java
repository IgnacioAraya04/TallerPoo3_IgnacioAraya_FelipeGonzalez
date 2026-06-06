package logica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import dominio.Hechizo;
import dominio.HechizoFactory;
import dominio.Mago;

public class SistemaImpl implements Sistema {
	ArrayList<Mago> listaMagos = new ArrayList<Mago>();
	ArrayList<Hechizo> listaHechizos = new ArrayList<Hechizo>();

	@Override
	public void cargarHechizo(String linea) {

		String[] partes = linea.split(";");
		String[] parteExtra = partes[3].split(",");

		if (parteExtra.length > 1) {
			Hechizo nuevo = HechizoFactory.getHechizo(partes[0], partes[1], Integer.valueOf(partes[2]),
					Integer.valueOf(parteExtra[0]), Integer.valueOf(parteExtra[1]));
			listaHechizos.add(nuevo);
		} else {
			Hechizo nuevo = HechizoFactory.getHechizo(partes[0], partes[1], Integer.valueOf(partes[2]),
					Integer.valueOf(partes[3]));
			listaHechizos.add(nuevo);
		}

	}

	@Override
	public void cargarMago(String linea) {

		String[] partes = linea.split(";");
		ArrayList<Hechizo> hechizosMago = new ArrayList<Hechizo>();
		//esto deaqui quiero probar si funciona bien el split, mas que nada porque lei que se puede romper
		String[] partesHechizos = partes[1].split("\\|"); 
		for (int i = 0; i < partesHechizos.length; i++) {
			for (Hechizo hechizo : listaHechizos) {
				if (hechizo.getNombre().equalsIgnoreCase(partesHechizos[i])) {
					hechizosMago.add(hechizo);

				}
			}
		}
		Mago nuevo = new Mago(partes[0], hechizosMago);
		listaMagos.add(nuevo);

	}

	@Override
	public void agregarTexto(String string, String txt) {
		BufferedWriter escritor;
		try {
			escritor = new BufferedWriter(new FileWriter(txt, true));
			escritor.newLine();
			escritor.write(string);
			escritor.close();
		} catch (IOException e) {
			System.out.println("Algo no se escribio bien...");
		}

	}

	@Override
	public void modificarTexto(String archivo, String original, String modificación) {
		Integer contadorLineas = 0;
		try {
			Scanner scanCont = new Scanner(new File(archivo));
			while (scanCont.hasNextLine()) {
				contadorLineas++;
				scanCont.nextLine();
			}
			scanCont.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			BufferedReader lector = new BufferedReader(new FileReader(archivo));
			String palabras = "";
			String lista = "";
			Integer contador = 0;
			while ((palabras = lector.readLine()) != null) {
				if (contador == contadorLineas - 1) {
					lista += palabras;
				} else {
					lista += palabras + "\r\n";
					contador++;
				}
			}
			lector.close();

			String textoNuevo = lista.replaceAll(original, modificación);
			FileWriter escritor = new FileWriter(archivo);
			escritor.write(textoNuevo);
			escritor.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public void eliminarTexto(String archivo, String original) {
		Integer contadorLineas = 0;
		try {
			Scanner scanCont = new Scanner(new File(archivo));
			while (scanCont.hasNextLine()) {
				contadorLineas++;
				scanCont.nextLine();
			}
			scanCont.close();
		} catch (Exception e) {
			System.out.println("Para romprese aca no deberia ni  para empezar lmao");
		}
		
		BufferedReader lector;
		try {
			lector = new BufferedReader(new FileReader(archivo));


		String palabras = "";
		String lista = "";
		Integer contador = 0;

		while ((palabras = lector.readLine()) != null) {
			if (contador == contadorLineas - 1) {
				lista += palabras;
			} else {
				if (!palabras.equalsIgnoreCase(original)) {
					lista += palabras + "\r\n";
				}
				contador++;
			}
		}
		lector.close();

		FileWriter escritor = new FileWriter(archivo);
		escritor.write(lista);
		escritor.close();
	} catch (Exception e) {
		System.out.println("Para romprese aca no deberia ni abrir para empezar lmao");
	}
	}
		
	

}
