package logica;

import java.util.Scanner;

import dominio.Hechizo;
import dominio.Mago;
import jdk.javadoc.doclet.DocletEnvironment.ModuleMode;

public class MenuAdmin {
	private static MenuAdmin instancia;

	private MenuAdmin() {
	}

	public static MenuAdmin getMenuAdmin() {

		if (instancia == null) {
			instancia = new MenuAdmin();
		}
		return instancia;
	}

	public void menuAdmin(Scanner scan, SistemaImpl sistem) {
		boolean salir = false;
		do {
			try {
				System.out.println("Menú administrador: \n" + "1) Agregar Mago.\n" + "2) Modificar Mago.\n"
						+ "3) Eliminar Mago.\n" + "4) Agregar Hechizo.\n" + "5) Modificar Hechizo.\n"
						+ "6) Eliminar Hechizo.\n" + "7) Salir.");
				Integer selec = Integer.valueOf(scan.nextLine());

				switch (selec) {
				case 1:
					agregarMago(scan, sistem);
				case 2:
					modificarMago(scan, sistem);

				case 3:
					eliminarMago(scan, sistem);
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
				}

			} catch (Exception e) {
				System.out.println("Valor inválido");
			}
		} while (!salir);
	}

	private void agregarMago(Scanner scan, SistemaImpl sistem) {
		String nuevoMago = "";
		System.out.println("Nombre del Mago: ");
		nuevoMago += scan.nextLine();
		int num = 1;
		do {
			System.out.println("Seleccionar Hechizo: ");
			for (Hechizo hechizo : sistem.listaHechizos) {
				System.out.println((num++) + hechizo.getNombre());
			}
			int selec1 = Integer.valueOf(scan.nextLine());
			nuevoMago += sistem.listaHechizos.get(selec1 - 1);
			System.out.println("Desea agregar otro Hechizo\n" + "1) Si\n" + "2) No");
			Integer finalizar = Integer.valueOf(scan.nextLine());
			if (finalizar == 1) {
				nuevoMago += "|";
			} else {
				break;
			}
		} while (true);
		sistem.cargarMago(nuevoMago);
		sistem.agregarTexto(nuevoMago, "Magos.txt");
	}

	private void modificarMago(Scanner scan, SistemaImpl sistem) {
		try {
			do {
				System.out.println("Que mago desea modificar?");
				int contador = 1;
				for (Mago mago : sistem.listaMagos) {
					System.out.println((contador++) + mago.print());
				}
				Integer selec = Integer.valueOf(scan.nextLine());

				System.out.println("Desea cambiar el nombre del mago o un hechizo?\n" + "1) Nombre\n" + "2) Hechizo");
				Integer cambio = Integer.valueOf(scan.nextLine());
				String magoOriginal = sistem.listaMagos.get(selec - 1).magoFormatoTxt();
				if (cambio == 1) {
					System.out.println("Cual es el nuevo nombre?");
					String nombreNuevo = scan.nextLine();
					nombreNuevo += ";" + sistem.listaMagos.get(selec - 1).hechizosFormatoTxt();
					sistem.modificarTexto(nombreNuevo, sistem.listaMagos.get(selec - 1).magoFormatoTxt(), nombreNuevo);
					break;
				} else if (cambio == 2) {
					boolean salir = false;
					do {
						System.out.println("Como quieres modificar sus hechizos?\n" + "1) Agregar Hechizo\n"
								+ "2) Eliminar Hechizos\n" + "3) salir");
						Integer modificacionHechizo = Integer.valueOf(scan.nextLine());

						if (modificacionHechizo == 1) {
							System.out.println("Que hechizo desea agregar:");
							int cont = 1;
							for (Hechizo hechizo : sistem.listaHechizos) {
								System.out.println((cont++) + hechizo.getNombre());
							}
							Integer hechizoSelec = Integer.valueOf(scan.nextLine());
							sistem.listaMagos.get(selec - 1)
									.aprenderHechizo(sistem.listaHechizos.get(hechizoSelec - 1));

						} else if (modificacionHechizo == 2) {
							System.out.println("Que hechizo desea eliminar:");
							int cont = 1;
							for (Hechizo hechizo : sistem.listaMagos.get(selec - 1).getListaHechizos()) {
								System.out.println((cont++) + hechizo.getNombre());
							}
							Integer hechizoSelec = Integer.valueOf(scan.nextLine());
							sistem.listaMagos.get(selec - 1).olvidarHechizo(
									sistem.listaMagos.get(selec - 1).getListaHechizos().get(hechizoSelec - 1));
						} else if (modificacionHechizo == 3) {
							salir = true;
						} else {
							System.out.println("Valor incorrecto, ingreselo de nuevo.");
						}

					} while (!salir);
				} else {
					System.out.println("Valor incorrecto, volver a ingresar");
				}
				sistem.modificarTexto("Magos.txt", magoOriginal, sistem.listaMagos.get(selec - 1).magoFormatoTxt());
				break;

			} while (true);
		} catch (Exception e) {
			System.out.println("valor invalido");
		}
	}

	private void eliminarMago(Scanner scan, SistemaImpl sistem) {
		try {
			do {
				System.out.println("Mandar sicario:");
				for (int i = 0; i < sistem.listaMagos.size(); i++) {
					System.out.println((i+1) + ") "+ sistem.listaMagos.get(i).print());
				}
				Integer selec = Integer.valueOf(scan.nextLine());
				sistem.eliminarTexto("Magos.txt",sistem.listaMagos.get(selec - 1).magoFormatoTxt());
				sistem.listaMagos.remove(selec - 1);
				break;
			} while (true);
		} catch (Exception e) {
			System.out.println("Valor ingresado es inválido");
		}
	}

}
