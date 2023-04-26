package Clases;

 public class Pronostico {
        //ATRIBUTOS
	 private int idJugador;	
	 private int idPartido;
	 private String ganoLocal;
	 private String empato;
	 private String ganoVisitante;
	
	 public Pronostico() {
		super();
	}

	public Pronostico(int IdJugador, int idPartido, String ganoLocal, String empato, String ganoVisitante) {
		this.idJugador = IdJugador;
		this.idPartido = idPartido;
		this.ganoLocal = ganoLocal;
		this.empato = empato;
		this.ganoVisitante = ganoVisitante;
	}

	public int getidJugador() {
		return idJugador;
	}

	public void setidJugador(int idJugador) {
		this.idJugador = idJugador;
	}

	public int getIdPartido() {
		return idPartido;
	}

	public void setIdPartido(int idPartido) {
		this.idPartido = idPartido;
	}

	public String getganoLocal() {
		return ganoLocal;
	}

	public static void  setganoLocal(String ganoLocal) {
		ganoLocal = ganoLocal;
	}

	public String getEmpato() {
		return empato;
	}

	public static void setempato(String empato) {
		empato = empato;
	}

	public String getGanoVisitante() {
		return ganoVisitante;
	}

	public static void setganoVisitante(String ganoVisitante) {
		ganoVisitante = ganoVisitante;
	}
	 
	 	
      
    
    }     