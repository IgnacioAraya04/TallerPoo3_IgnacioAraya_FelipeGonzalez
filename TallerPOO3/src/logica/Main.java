package logica;

import java.io.File;
import java.io.FileNotFoundException;
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
		System.out.println("1) Menú administrador.\n" + "2) Menú análisis. \n" + "3) Salir.\n");
		Integer select = Integer.valueOf(scan.nextLine());
		switch (select) {
		case 1:
			MenuAdmin.getMenuAdmin().menuAdmin(scan, sistem);
			return 0;
		case 2:
			menuAnalisis(scan);
			return 0;
		case 3:
			return 3;

		default:
			System.out.println("Seleccionar una de las opciones.");
			return 0;
		}

	}

	private static void menuAnalisis(Scanner scan) {
		boolean salir = false;
		do {
			try {
				System.out.println("Menú Análisis: \n" + "1) Top 10 Mejores Hechizos.\n" + "2) Top 3 Mejores Magos.\n"
						+ "3) Mostrar todos los Hechizos.\n" + "4) Mostrar todos los Magos.\n"
						+ "5) Mostrar todos los Hechizos junto a su puntuación.\n"
						+ "6) Mostrar todos los magos junto a su puntuación.\n" + "7) Salir.");
				Integer selec = Integer.valueOf(scan.nextLine());
				switch (selec) {
				case 1:

					break;
				case 2:

					break;
				case 3:

					break;
				case 4:

					break;
				case 5:

					break;
				case 6:

					break;
				case 7:
					salir = true;
					break;
				default:
					System.out.println("Elegir una de las opciones disponibles\n");
					break;
				}
			} catch (Exception e) {
				System.out.println("Valor inválido");
			}
		} while (!salir);
	}
}
