package Prodep;

/*
 *
 * @author Omar, Lorena, Pablo, Sergio
 *
 *  1.(listo) Implementar la lectura de los archivos DB con las "X" y luego tranformarlas a valores numericos
 *  2.Implementar interfaces en el metodo Informes y Lectura de archivos para simplificar codigo
 *  3.Reemplazar las matrices por Colecciones.
 *  4.(listo) Agregar sumar puntos si acerto todos los partidos de la ronda
 *  5.(listo) Colocar como parametro la cantidad de puntos que suma por acierto
 *
 */
import Clases.*;
import java.sql.Connection;
import java.sql.Statement;

public class TrabajoPractico31 {

	// ************************************  DEFINICION DE MATRICES GLOBALES  ***********************************
	public static class MisColecciones {
		public static Partido[] matPartidos = new Partido[100];
		public static Pronostico[] matPronosticos = new Pronostico[100];
		public static Jugador[] matJugadores = new Jugador[100];
		public static ResultadosxRonda[][] matResultadoXronda = new ResultadosxRonda[200][20];
	}
		public static int cantPartidos=0;
		public static int cantPronosticos= 0;
		public static Connection conexion = null;
		public static Statement consulta = null;

    // ************************************  PROGRAMA PRINCIPAL ***********************************
    public static void main(String[] args)  {


		LecturaDeArchivos.leeJugadores();
		LecturaDeArchivos.leePartidos();
		// LECTURA Y VERIFICACION DEL ARCHIVO
		LecturaDeArchivos.LeePronosticos();
		Informes.mostrarPartidosLeidos();
		Informes.mostrarPronosticosLeidos();

		cantPartidos = MisColecciones.matPartidos.length;
		cantPronosticos = MisColecciones.matPronosticos.length;

		boolean vpar = Validaciones.validaGoles(cantPartidos);

		if (vpar ==false) {
			Informes.errorDeLectura(4);
			ConectorSQL.cerrarConexionDB("tp", conexion , consulta);
			System.exit(1);
		}
		//********************************************** METODO COMPARAR 3 ******************************************************
		//SE RECORRE LA MATRIZ  PRONOSTICO SE HACEN LAS COMPARACIONES, Y SE SUMAN LOS PUNTOS

		int cantJugadores = MisColecciones.matJugadores.length;
		//int j = 0, idj, idp, puntos;
		//int matPorRonda[][] = new int[3][cantPartidos];
		//int ronda=1;
		//int rondaActual;
		//int r=0;
		//String pronostico = null;

		int cantRondas = CompararResultados.detCantRondas();
		System.out.println("Cant Rondas " + cantRondas);
		System.out.println("\nVamos a comparar!!");
		System.out.println("-------------------------------------------");

		CompararResultados.iniciaMatrizJugadores(cantJugadores, cantRondas);
		CompararResultados.comparar(cantPronosticos);
		Informes.mostrarResultadosPorRonda(cantJugadores, cantRondas);

	}
}
/*
********************************************************************************************************************
*
*											 FIN PROGRAMA PRINCIPAL
*
*********************************************************************************************************************
*/
