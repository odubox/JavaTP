package Clases;

import Prodep.TrabajoPractico32;

import java.sql.Connection;
import java.sql.Statement;

public class Informes {

    public static void mostrarPartidosLeidos() {
        System.out.println("");
        System.out.println("Estos son los partidos que se jugaron");
        System.out.println("-------------------------------------");
        int cantPartidos = TrabajoPractico32.MisColecciones.matPartidos.length;


        for (int i = 0; i < cantPartidos; i++) {

            int numPartido = TrabajoPractico32.MisColecciones.matPartidos[i].getIdPartido();
            int numRonda = TrabajoPractico32.MisColecciones.matPartidos[i].getRonda();
            String EquipoLocal = TrabajoPractico32.MisColecciones.matPartidos[i].getnombreEquipoLocal();
            String EquipoVisitante = TrabajoPractico32.MisColecciones.matPartidos[i].getnombreEquipoVisitante();
            int golesLocal = TrabajoPractico32.MisColecciones.matPartidos[i].getgLocal();
            int golesVisitante = TrabajoPractico32.MisColecciones.matPartidos[i].getgVisitante();


            System.out.println("Partido # " + numPartido + " - (Ronda " + numRonda + "):" + " : " + EquipoLocal + " vs " + EquipoVisitante
                    + " y el resultado fue " + golesLocal + " a " + golesVisitante);
        }
    }

    public static void mostrarPronosticosLeidos() {

        System.out.println("\nEstos son los Pronosticos que se recibieron");
        System.out.println("-------------------------------------------");
        int cantPronosticos = TrabajoPractico32.MisColecciones.matPronosticos.length;
        for (int i = 0; i < cantPronosticos; i++) {

            int idj = TrabajoPractico32.MisColecciones.matPronosticos[i].getIdJugador();
            int idp = TrabajoPractico32.MisColecciones.matPronosticos[i].getIdPartido();
            int L = TrabajoPractico32.MisColecciones.matPronosticos[i].getganoLocal();
            int E = TrabajoPractico32.MisColecciones.matPronosticos[i].getempato();
            int V = TrabajoPractico32.MisColecciones.matPronosticos[i].getganoVisitante();

            String resultadoPartido = L + " " + E + " " + V;

            System.out.println("El jugador " + idj + " pronostico que el partido : " + idp + " daba como resultado: " + resultadoPartido);

        }
    }

    public static void mostrarResultadosPorRonda(int cantJugadores, int cantRondas) {
        int j;
        int i = 0;
        //System.out.println("Estos son los jugadores");
        //System.out.println("-------------------------------------------");

        for (i = 0; i < cantJugadores; i++) {
            for (j = 0; j < cantRondas; j++) {
                String nombreJ = TrabajoPractico32.MisColecciones.matJugadores[i].getNombre();
                int puntosGanadosRonda = TrabajoPractico32.MisColecciones.matResultadoXronda[i][j].getPuntaje();
                int puntosGanadosTotal = TrabajoPractico32.MisColecciones.matJugadores[i].getpuntos();

                int siGanoTodasRondas = cantRondas * Configuracion.puntosSiAcierta;
                if (puntosGanadosRonda == siGanoTodasRondas) {
                    System.out.println(nombreJ + " obtuvo " + puntosGanadosRonda + " puntos en la ronda " + (j + 1) + " y suma " + Configuracion.puntosExtrasRonda + " puntos extras por haber ganado toda la ronda ");
                    puntosGanadosTotal =puntosGanadosTotal + Configuracion.puntosExtrasRonda;
                    TrabajoPractico32.MisColecciones.matJugadores[i].setpuntos(puntosGanadosTotal);
                } else {
                    System.out.println(nombreJ + " obtuvo " + puntosGanadosRonda + " puntos en la ronda " + (j + 1));
                }


            }
            System.out.println("");

        }
        Jugador.ordenarPorPuntos(TrabajoPractico32.MisColecciones.matJugadores);
    }

        public static void errorDeLectura(String nombreDB, Connection conexion, Statement consulta, int tipoerror) {
            String leyendaError=null;
        switch (tipoerror){
            case 1: {
                leyendaError = " de conexion con la base de datos ";
                break;
            }
            case 2:{
                leyendaError = " con las consultas en la tabla ";
                break;
            }
            case 3:{
                leyendaError = " al cerrar la base de datos ";
            }
        }
        System.out.println("Se ha producido un error" + leyendaError   + nombreDB + " - Tipo Error: " + tipoerror);
        System.out.println("No se podrá continuar con la ejecución del programa");
        System.out.println("Cierre de conexiones a las bases de datos que intentaron abrirse");
    }

    public static void errorDeLectura(int tipoerror){  //sobrecarga en el caso de no ser producido por SQL

        String leyendaError=null;
        switch (tipoerror){
            case 4: {
                leyendaError = " al validar los datos leidos ";
                break;
            }
            case 5: {
                leyendaError = " Al validar el archivo de pronosticos ";
                break;
            }
        }
        System.out.println("Se ha producido un error" + leyendaError   +  " - Tipo Error: " + tipoerror);
        System.out.println("No se podrá continuar con la ejecución del programa");
        System.out.println("Cierre de conexiones y consultas");
    }

}


