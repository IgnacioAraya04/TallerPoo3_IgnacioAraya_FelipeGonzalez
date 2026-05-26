package taller3;

import java.util.ArrayList;

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
		for (int i = 1; i < partes.length; i++) {
			for (Hechizo hechizo : listaHechizos) {
				if (hechizo.getNombre().equalsIgnoreCase(partes[i])) {
					hechizosMago.add(hechizo);
					
				}
			}
		}
		Mago nuevo = new Mago(partes[0], hechizosMago);
		listaMagos.add(nuevo);
		hechizosMago.clear();
	}

}
