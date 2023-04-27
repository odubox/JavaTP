package Clases;

public class Partido {
		//ATRIBUTOS
		private int idPartido;
        private int ronda;
        private Equipo local;
        private Equipo visitante;
        private int gLocal;
        private int gVisitante;
        
        
        //CONSTRUCTOR VACÍO
        public Partido() {
        }
        
		public Partido(int idPartido, int ronda, Equipo local, Equipo visitante, int gLocal, int gVisitante) {
			super();
			this.idPartido = idPartido;
			this.ronda = ronda;
			this.local = local;
			this.visitante = visitante;
			this.gLocal = gLocal;
			this.gVisitante = gVisitante;
		}
        
		public String getnombreEquipoLocal() {
			
			return local.getNombre();
		}
		
		public String getnombreEquipoVisitante() {
			
			return visitante.getNombre();
		}
		
		public int getIdPartido() {
			return idPartido;
		}


		public void setIdPartido(int idPartido) {
			this.idPartido = idPartido;
		}


		public int getRonda() {
			return ronda;
		}


		public void setRonda(int ronda) {
			this.ronda = ronda;
		}


		public Equipo getLocal() {
			return local;
		}


		public void setLocal(Equipo local) {
			this.local = local;
		}


		public Equipo getVisitante() {
			return visitante;
		}


		public void setVisitante(Equipo visitante) {
			this.visitante = visitante;
		}


		public int getgLocal() {
			return gLocal;
		}


		public void setgLocal(int gLocal) {
			this.gLocal = gLocal;
		}


		public int getgVisitante() {
			return gVisitante;
		}


		public void setgVisitante(int gVisitante) {
			this.gVisitante = gVisitante;
		}


	public static ResultadoEnum getResultadoEnum(int gl, int gv) {
		//DETERMINO RESULTADO DEL PARTIDO
		ResultadoEnum resultadoReal =ResultadoEnum.Empate;
		if (gl > gv) {
			resultadoReal = ResultadoEnum.GanadorLocal;
		}else if (gl < gv) {
			resultadoReal = ResultadoEnum.GanadorVisitante;
		}
		return resultadoReal;
	}





      
    }  

