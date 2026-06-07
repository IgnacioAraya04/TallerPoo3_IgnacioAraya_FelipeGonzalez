package dominio;

import java.util.ArrayList;

public class Mago {
	
	private String nombre;
	private ArrayList<Hechizo> listaHechizos;
	
	public Mago(String nombre, ArrayList<Hechizo> listaHechizos) {
		super();
		this.nombre = nombre;
		this.listaHechizos = listaHechizos;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public ArrayList<Hechizo> getListaHechizos() {
		return listaHechizos;
	}
	
	public void olvidarHechizo(Hechizo hechizo) {
		listaHechizos.remove(hechizo);
	}
	public void aprenderHechizo(Hechizo hechizo) {
		listaHechizos.add(hechizo);
	}
	
	public String print() {
		String mago = "" ;
		mago += nombre + " Hechizos: ";
		for (int i = 0; i < listaHechizos.size(); i++) {
			if (i == 0) {
				mago +=   listaHechizos.get(i).getNombre();
			} else {
				mago += "|" + listaHechizos.get(i).getNombre();
			}
		}
		return mago;
	}
	public String hechizosFormatoTxt() {
		String hechizos = "" ;
		for (int i = 0; i < listaHechizos.size(); i++) {
			if (i == 0) {
				hechizos +=   listaHechizos.get(i).getNombre();
			} else {
				hechizos += "|" + listaHechizos.get(i).getNombre();
			}
		}
		return hechizos;
	}
	
	public String regexTxt() {
		String mago = "" ;
		mago += nombre+";" ;
		for (int i = 0; i < listaHechizos.size(); i++) {
			if (i == 0) {
				mago +=   listaHechizos.get(i).getNombre();
			} else {
				mago += "\\|" + listaHechizos.get(i).getNombre();
			}
		}
		return mago;
	}
	
	
	public String magoFormatoTxt() {
		String mago = "" ;
		mago += nombre+";" ;
		for (int i = 0; i < listaHechizos.size(); i++) {
			if (i == 0) {
				mago +=   listaHechizos.get(i).getNombre();
			} else {
				mago += "|" + listaHechizos.get(i).getNombre();
			}
		}
		return mago;
	}
	
	//para sumar el puntaje total de puntaje del mago:
	public int getPuntajeTotal() {
		int total = 0;
		for(Hechizo hechizo : listaHechizos) {
			total += hechizo.getPuntaje();
			
		}
		return total;
		
		
		
	}

}
