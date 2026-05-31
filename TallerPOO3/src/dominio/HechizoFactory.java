package dominio;

public class HechizoFactory {
	
	public static Hechizo getHechizo(String nombre, String tipo, int daño, int extra) {
		if (tipo.equalsIgnoreCase("fuego")) {
			return new HechizoFuego(nombre, tipo, daño, extra);
		} else {
			return new HechizoTierra(nombre, tipo, daño, extra);
		}
	}
	
	public static Hechizo getHechizo(String nombre, String tipo, int daño, int extra, int efecto) {
		if (tipo.equalsIgnoreCase("planta")) {
			return new HechizoPlanta(nombre, tipo, daño, extra, efecto);
		} else {
			return new HechizoAgua(nombre, tipo, daño, extra, efecto);
		}
	}
}
