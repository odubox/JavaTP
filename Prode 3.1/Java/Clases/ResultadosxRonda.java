package Clases;

public class ResultadosxRonda {
	int idj;
	int ronda;
	int puntaje;
	
	public ResultadosxRonda(int idj, int ronda) {
		super();
		this.idj = idj;
		this.ronda = ronda;
	}

	public ResultadosxRonda() {
		
	}
	public int getIdj() {
		return idj;
	}
	public void setIdj(int idj) {
		this.idj = idj;
	}
	public int getRonda() {
		return ronda;
	}
	public void setRonda(int ronda) {
		this.ronda = ronda;
	}
	public int getPuntaje() {
		return puntaje;
	}
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}


}
