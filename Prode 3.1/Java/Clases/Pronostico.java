package Clases;

 public class Pronostico {
        //ATRIBUTOS
	 public int idJugador;
	 public int idPartido;
	 public int ganoLocal;
	 public int empato;
	 public int ganoVisitante;

	 public int idJugador() {
		 return idJugador;
	 }

	 public Pronostico setIdJugador(int idJugador) {
		 this.idJugador = idJugador;
		 return this;
	 }

	 public Pronostico(int idJugador, int idPartido, int ganoLocal, int empato, int ganoVisitante) {
		 this.idJugador = idJugador;
		 this.idPartido = idPartido;
		 this.ganoLocal = ganoLocal;
		 this.empato = empato;
		 this.ganoVisitante = ganoVisitante;
	 }

	 public int getIdPartido() {
		 return idPartido;
	 }

	 public int getIdJugador() {
		 return idJugador;
	 }

	 public int getganoLocal() {
		 return ganoLocal;
	 }

	 public int getempato() {
		 return empato;
	 }

	 public int getganoVisitante() {
		 return ganoVisitante;
	 }

	 public Pronostico setGanoVisitante(int ganoVisitante) {
		 this.ganoVisitante = ganoVisitante;
		 return this;
	 }

	 public Pronostico setEmpato(int empato) {
		 this.empato = empato;
		 return this;
	 }

	 public Pronostico setGanoLocal(int ganoLocal) {
		 this.ganoLocal = ganoLocal;
		 return this;
	 }

	 public Pronostico setIdPartido(int idPartido) {
		 this.idPartido = idPartido;
		 return this;
	 }
 }