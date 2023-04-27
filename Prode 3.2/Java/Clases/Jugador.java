package Clases;
import java.util.Arrays;
import java.util.Comparator;

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

	public static void ordenarPorPuntos(Jugador[] jugadores) {
		Arrays.sort(jugadores, new Comparator<Jugador>() {
			@Override
			public int compare(Jugador jugador1, Jugador jugador2) {
				return Integer.compare(jugador2.getpuntos(), jugador1.getpuntos());
			}
		});

		System.out.println("Matriz de jugadores ordenada por puntos:");
		System.out.println("Id");
		System.out.println("Jug." +  "\t" + "Nombre" +"\t" + "Puntos");
		System.out.println("-----------------------------------------------");
		for (Jugador jugador : jugadores) {
			System.out.println(jugador.getIdJ() +  "\t" +"\t" + jugador.getNombre() + "\t  " + jugador.getpuntos());
		}
	}


}
