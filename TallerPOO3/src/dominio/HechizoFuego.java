package dominio;

public class HechizoFuego extends Hechizo {

	private int duracionQuemadura;

	public HechizoFuego(String nombre, String tipo, int daño, int dq) {
		super(nombre, tipo, daño);
		this.duracionQuemadura = dq;
		calcularPuntaje();
	}
	
	
	
	public void setEspecial1(int duracionQuemadura) {
		this.duracionQuemadura = duracionQuemadura;
	}



	public void calcularPuntaje() {
		setPuntaje(getDaño()*duracionQuemadura);
	}
	@Override
	public String formatoTxt() {
		return getNombre()+";Fuego;"+getDaño()+";"+duracionQuemadura;
	}
	
	@Override
	public String toString() {
		
		return getNombre() + "| Tipo: "+ getTipo()+"| Daño: "+ getDaño()+"| Duracion de quemadura: "+ duracionQuemadura ;
	}

}
