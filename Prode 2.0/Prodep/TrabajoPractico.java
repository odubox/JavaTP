package Prodep;

/**
 *
 * @author Omar
 */
import java.io.IOException;
import Clases.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class TrabajoPractico {

	// ************************************  DEFINICION DE MATRICES GLOBALES  ***********************************
	public static class MisColecciones {
	      static Partido[] matPartidos = new Partido[100];
	      static Pronostico[] matPronosticos = new Pronostico[500];
	      static Jugador[] matJugadores = new Jugador[100];

	      
	}
	       
	
    // ************************************  PROGRAMA PRINCIPAL ***********************************
    public static void main(String[] args)  {



    leeJugadores(args[0] + "\\Jugadores1.csv");
    leePartidos(args[0] + "\\Partidos1.csv");
    LeePronosticos(args[0] + "\\Pronosticos1.csv");
    
    
    
    // *********************  MOSTRAR EL CONTENIDO DE LA MATRIZ DE PARTIDOS QUE SE LEYO ************************
	System.out.println("Estos son los partidos que se jugaron");
	System.out.println("-------------------------------------------");
	int cantPartidos=MisColecciones.matPartidos.length;
	System.out.println("Cant partidos al mostrar " + cantPartidos);
	
    for( int i=0; i<cantPartidos; i++) {
    	
    	int numPartido = MisColecciones.matPartidos[i].getIdPartido();
    	int numRonda = MisColecciones.matPartidos[i].getRonda();
    	String EquipoLocal = MisColecciones.matPartidos[i].getnombreEquipoLocal();
    	String EquipoVisitante = MisColecciones.matPartidos[i].getnombreEquipoVisitante();
    	int golesLocal = MisColecciones.matPartidos[i].getgLocal();
    	int golesVisitante = MisColecciones.matPartidos[i].getgVisitante();
    	
    	
		System.out.println("Partido # " + numPartido + " - (Ronda " + numRonda + "):"   + " : " + EquipoLocal + " vs " + EquipoVisitante
		+ " y el resultado fue " + golesLocal + " a " + golesVisitante);
    }
    
    
    
    // ************************** MOSTRAR EL CONTENIDO DE LA MATRIZ DE PRONOSTICOS QUE SE LEYO***************************

	System.out.println("\nEstos son los Pronosticos que se recibieron");
	System.out.println("-------------------------------------------");
	int cantPronosticos=MisColecciones.matPronosticos.length;
	for( int i=0; i<cantPronosticos; i++) {
	
		int idj =MisColecciones.matPronosticos[i].getidJugador();
		int idp =MisColecciones.matPronosticos[i].getIdPartido();
		String L =MisColecciones.matPronosticos[i].getganoLocal();
		String E =MisColecciones.matPronosticos[i].getEmpato();
		String V =MisColecciones.matPronosticos[i].getGanoVisitante();
		
		String resultadoPartido =L + " " + E + " " + V;
		
		System.out.println("El jugador " + idj + " pronostico que el partido : " +  idp + " daba como resultado: " + resultadoPartido);
	
	}
	 

	
	 //********************************************** METODO COMPARAR 2  ******************************************************

	//DESDE PRONOSTICO 1 HASTA EL ULTIMO
		// BUSCO EL PARTIDO, COMPARO Y SUMO PUNTOS

	cantPartidos = MisColecciones.matPartidos.length;
	cantPronosticos = MisColecciones.matPronosticos.length;
	int cantJugadores = MisColecciones.matJugadores.length;
	System.out.println();
	System.out.println("Cantidad de pronosticos " + cantPronosticos);
	System.out.println("Cantidad de jugadores " + cantJugadores);
	System.out.println("Cantidad de partidos " + cantPartidos);

	int idj = 1;
	int idp = 1;
	int puntos = 0;
	int j1=0;
	int j2=0;


	System.out.println("\nVamos a comparar!!");
	System.out.println("-------------------------------------------");
	
	for (int i = 0; i < cantPronosticos; i++) {

	    idj = MisColecciones.matPronosticos[i].getidJugador();
	    idp = MisColecciones.matPronosticos[i].getIdPartido();
	    int gl = MisColecciones.matPartidos[idp - 1].getgLocal();
	    int gv = MisColecciones.matPartidos[idp - 1].getgVisitante();
		String nombreJ = MisColecciones.matJugadores[idj - 1].getNombre();


		int result = 0;
	    if (gl > gv) {
	        result = 1;
	    } else if (gl < gv) {
	        result = 2;
	    }

	    switch (result) {
	        case 0:
	            if (MisColecciones.matPronosticos[i].getEmpato().equals("X")) {
	                puntos = MisColecciones.matJugadores[idj - 1].getpuntos() + 1;
	                MisColecciones.matJugadores[idj - 1].setpuntos(puntos);
	                puntos=0;
		            if(idj== 1) {
		            	j1=j1+1;
		            }else {
		            	j2=j2+1;
		            }
		        }
    	         break;
	        case 1:

	            if (MisColecciones.matPronosticos[i].getganoLocal().equals("X")) {
	                puntos = MisColecciones.matJugadores[idj - 1].getpuntos() + 1;
	                MisColecciones.matJugadores[idj - 1].setpuntos(puntos);
	                puntos=0;
		            if(idj==1) {
		            	j1=j1+1;
		            }else {
		            	j2=j2+1;
		            }
		        }
 				break;
	        case 2:

	            if (MisColecciones.matPronosticos[i].getGanoVisitante().equals("X")) {
	                puntos = MisColecciones.matJugadores[idj - 1].getpuntos() + 1;
	                MisColecciones.matJugadores[idj - 1].setpuntos(puntos);
	                puntos=0;
		            if(idj==1) {
		            	j1=j1+1;
		            }else {
		            	j2=j2+1;
		            }
		        }
	            break;
	            
	    	}    


	}
	
		
	    // *********************  MOSTRAR EL CONTENIDO DE LA MATRIZ JUGADOR ************************
	    int i =0;
		System.out.println("Estos son los jugadores");
		System.out.println("-------------------------------------------");
		

	    for(i=0; i<cantJugadores; i++) {
	    	idj = MisColecciones.matJugadores[i].getIdJ();
	    	String nombreJ = MisColecciones.matJugadores[i].getNombre();
	    	int puntosGanados = MisColecciones.matJugadores[i].getpuntos();

			System.out.println("Id Jugador " + idj + ":" + nombreJ + " obtuvo: "   + puntosGanados);
	    }
	
    }

    //********************************************** FIN PROGRAMA PRINCIPAL ******************************************************
		
    
  //********************************************** METODO LEER JUGADORES *********************************************************
  	public static void leeJugadores (String ruta)  {
      // LECTURA DE ARCHIVO CSV DE JUGADORES

		Path pathJugadores = Paths.get(ruta);
		List<String> lineasJugadores = null;
		try {
			lineasJugadores= Files.readAllLines(pathJugadores);
		} catch (IOException e) {
			System.out.println("No se pudo leer la linea de Jugadores...");
			System.out.println(e.getMessage());
			System.exit(1);
		}

		int i=0;
		for (String lineaJugador : lineasJugadores) {
				String[] campos = lineaJugador.split(",");
				
				int IdJugador =  Integer.parseInt(campos[0]);
				String nombreJugador =  campos[1];

				
				Jugador jugadores = new Jugador(IdJugador,nombreJugador);
				
				MisColecciones.matJugadores[i]= jugadores;
				i=i+1;
			}

		
		// ***** REDIMENSIONO LA MATRIZ **************
		MisColecciones.matJugadores = Arrays.copyOfRange(MisColecciones.matJugadores, 0, i);
		int cantJugadores =MisColecciones.matJugadores.length;
	 }	
		
	

      	
      	
    //********************************************** METODO LEER PARTIDOS ******************************************************
	public static void leePartidos(String ruta) {
        // LECTURA DE ARCHIVO CSV DE PARTIDOS

		Path pathResultados = Paths.get(ruta);
		List<String> lineasResultados = null;
		try {
			lineasResultados = Files.readAllLines(pathResultados);
		} catch (IOException e) {
			System.out.println("No se pudo leer la linea de Partidos...");
			System.out.println(e.getMessage());
			System.exit(1);
		}
		int i=0;

		for (String lineaResultado : lineasResultados) {
				String[] campos = lineaResultado.split(",");
				
				int Idpartido =  Integer.parseInt(campos[0]);
				int ronda =  Integer.parseInt(campos[1]);
				Equipo equipoLocal = new Equipo(campos[2]);
				Equipo equipoVisitante = new Equipo(campos[3]);
				int gl = Integer.parseInt(campos[4]);
				int gv = Integer.parseInt(campos[5]);
				
				Partido partido = new Partido(Idpartido,ronda,equipoLocal,equipoVisitante,gl,gv);
				MisColecciones.matPartidos[i]= partido;
				i=i+1;
			}
		// ***** REDIMENSIONO LA MATRIZ **************
				MisColecciones.matPartidos = Arrays.copyOfRange(MisColecciones.matPartidos, 0, i);
	 }	

    //**********************************************  METODO LEER PRONOSTICOS ******************************************************

	private static void LeePronosticos(String ruta) {
    // LECTURA DE ARCHIVO CSV DE PRONOSTICOS
	

	Path pathPronosticos = Paths.get(ruta);
	List<String> lineasPronosticos = null;
	try {
		lineasPronosticos = Files.readAllLines(pathPronosticos);
	} catch (IOException e) {
		System.out.println("No se pudo leer la linea de Pronosticos...");
		System.out.println(e.getMessage());
		System.exit(1);
	}

	int i=0;
	for (String lineaPronostico : lineasPronosticos) {
		
		
		String[] campos = lineaPronostico.split(",");
		
		int numJugador =  Integer.parseInt(campos[0]);
		int numPartido =  Integer.parseInt(campos[1]);
		String gl = campos[2];
		String em = campos[3];
		String gv = campos[4];
		
		Pronostico pronostico = new Pronostico(numJugador,numPartido,gl,em,gv);
		MisColecciones.matPronosticos[i]= pronostico;
		i++;
	}
	// ***** REDIMENSIONO LA MATRIZ **************
		MisColecciones.matPronosticos = Arrays.copyOfRange(MisColecciones.matPronosticos, 0, i);
	}
	

}
		
