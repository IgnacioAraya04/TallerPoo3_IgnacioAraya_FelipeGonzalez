package logica;
/* Ignacio Araya Munizaga 21.824.045-3 Ingenieria en tecnologias de la información
 * Felipe Gonzalez Zuleta 21.776.516-1 Ingenieria en tecnologias de la información
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import dominio.Hechizo;
import dominio.Mago;

public class Main {
	static SistemaImpl sistem = new SistemaImpl();

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		cargarHechizos();
		cargarMagos();
		
		Integer salir = 0;

		do {
			salir = menuInicial(scan);
		} while (salir != 3);
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

	private static int menuInicial(Scanner scan) {
		try {
			
		
		
		System.out.println("1) Menú administrador.\n" + "2) Menú análisis. \n" + "3) Salir.\n");
		Integer select = Integer.valueOf(scan.nextLine());
		switch (select) {
		case 1:
			MenuAdmin.getMenuAdmin().menuAdmin(scan, sistem);
			return 0;
		case 2:
			MenuAnalisis.getMenuAnalisis().menuAnalisis(scan, sistem);
			return 0;
		case 3:
			return 3;

		default:
			System.out.println("Seleccionar una de las opciones.");
			return 0;
		}
		} catch (Exception e) {
			System.out.println("Valor incorrecto ingresado, cerrando el programa");
			return 3;
		}
	}


}
