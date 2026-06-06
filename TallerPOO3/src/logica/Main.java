package logica;

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
					//1) Top 10 Mejores Hechizos
					System.out.println("\n ----TOP 10 MEJORES SPELLS----");
					System.out.println("");
					ArrayList<Hechizo> topSpells = new ArrayList<Hechizo>(sistem.listaHechizos);
					for(int i = 0;	i<topSpells.size()-1;i++) {
						for(int j = 0;j < topSpells.size() - 1-i;j++) {
							if (topSpells.get(j).getPuntaje() < topSpells.get(j + 1).getPuntaje()) {
								Hechizo temp = topSpells.get(j);
								topSpells.set(j, topSpells.get(j+1));
								topSpells.set(j+1, temp);
							}
						}
					}
					int limiteH = Math.min(10, topSpells.size());
					for (int i = 0; i < limiteH; i++) {
						Hechizo h = topSpells.get(i);
						System.out.println((i+1) + ". " + h.getNombre() + "(Puntaje: " + h.getPuntaje() + ")");
					} System.out.println("\n");
					break;
				case 2:
					// TOP 3 MEJORES MAGOS
					System.out.println("\n --- TOP 3 MEJORES MAGOS ---");
					System.out.println("");
					ArrayList<Mago> topMagos = new ArrayList<>(sistem.listaMagos);
					
					for(int i = 0; i< topMagos.size()-1;i++ ) {
						for(int j = 0; j < topMagos.size() -1-i; j++) {
							if (topMagos.get(j).getPuntajeTotal() < topMagos.get(j + 1).getPuntajeTotal()) {
								Mago magoTemp = topMagos.get(j);
								topMagos.set(j, topMagos.get(j + 1));
								topMagos.set(j + 1, magoTemp);
							}
						}
					}
					int limiteM = Math.min(3, topMagos.size());
					for (int i = 0; i < limiteM; i++) {
						Mago m = topMagos.get(i);
						System.out.println((i+1) + ". " + m.getNombre() + "(puntaje total: " + m.getPuntajeTotal() + ")");
					} System.out.println("\n");
					break;
				case 3:
					//Mostrar todos los Hechizos.
					System.out.println("\n --- TODOS LOS SPELLS ---");
					System.out.println("");
					for(Hechizo h : sistem.listaHechizos) {
						System.out.println("- " + h.getNombre());
					} System.out.println("\n");
					break;
				case 4:
					System.out.println("\n --- TODOS LOS MAGOS ---");
					System.out.println("");
					for(Mago m : sistem.listaMagos) {
						System.out.println("- " + m.getNombre());
					} System.out.println("\n");

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
