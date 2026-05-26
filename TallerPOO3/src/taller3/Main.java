package taller3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	static SistemaImpl sistem = new SistemaImpl();
	public static void main(String[] args) {
	cargarHechizos();
	cargarMagos();
		

	}
	
	private static void cargarHechizos() {
		try {
			Scanner scan = new Scanner(new File("Hechizos.txt"));
			while (scan.hasNextLine()) {
				String string = (String) scan.nextLine();
				sistem.cargarHechizo(string);
				
			}
			scan.close();
		} catch (FileNotFoundException e) {

		}
	}
	
	private static void cargarMagos() {
		try {
			Scanner scan = new Scanner(new File("Magos.txt"));
			while (scan.hasNextLine()) {
				String string = (String) scan.nextLine();
				sistem.cargarMago(string);
				
			}
			scan.close();
		} catch (FileNotFoundException e) {

		}
	}

}
