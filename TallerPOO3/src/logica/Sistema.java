package logica;

public interface Sistema {

	 void cargarHechizo(String string);
	 void cargarMago(String string);
	 void agregarTexto(String string, String txt);
	 void modificarTexto(String archivo, String original, String modificación);
	 void eliminarTexto(String archivo, String original);

}
