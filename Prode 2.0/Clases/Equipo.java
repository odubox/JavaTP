package Clases;

 public class Equipo {
        //ATRIBUTOS
	 	private int Id;
        private String Nombre;
        private String Descripcion;
        
        public Equipo() {
        }
        
        
		public Equipo(int id, String nombre, String descripcion) {
			Id = id;
			Nombre = nombre;
			Descripcion = descripcion;
		}

		public Equipo(String nombre) {
			Nombre = nombre;
		}

		public int getId() {
			return Id;
		}

		public void setId(int id) {
			Id = id;
		}


		public String getNombre() {
			return Nombre;
		}


		public void setNombre(String nombre) {
			Nombre = nombre;
		}


		public String getDescripcion() {
			return Descripcion;
		}


		public void setDescripcion(String descripcion) {
			Descripcion = descripcion;
		}

   
    }  