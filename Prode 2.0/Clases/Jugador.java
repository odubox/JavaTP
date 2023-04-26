package Clases;

public class Jugador {
	private int idJ;
	private String nombre;
	private int puntos;
	
	public Jugador(int idJ, String nombre) {
		super();
		this.idJ = idJ;
		this.nombre = nombre;
	}

	public int getIdJ() {
		return idJ;
	}
	public void setIdJ(int idJ) {
		this.idJ = idJ;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getpuntos() {
		return puntos;
	}
	public void setpuntos(int puntos) {
		this.puntos = puntos;
	}

	
}
