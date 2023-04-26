package Clases;

import Prodep.TrabajoPractico31;

public class CompararResultados {


    public static int detCantRondas() {

        //DETERMINA LA CANTIDAD DE RONDAS
        int cantRondas = Integer.MIN_VALUE;
        for (int i = 0;
             i < TrabajoPractico31.MisColecciones.matPartidos.length; i++) {
            if (TrabajoPractico31.MisColecciones.matPartidos[i].getRonda() > cantRondas) { // si el valor actual es mayor que el valor máximo actual
                cantRondas = TrabajoPractico31.MisColecciones.matPartidos[i].getRonda(); // actualizamos el valor máximo
            }
        }
        return cantRondas;
    }

    public static void  iniciaMatrizJugadores(int cantJugadores, int cantRondas){
        //SE INICIALIZA LA MATRIZ (sino me da error cuando sumo...uhmmmm...)
        for(int i=0; i<cantJugadores; i++) {
            for(int j=0; j<cantRondas; j++){
                TrabajoPractico31.MisColecciones.matResultadoXronda[i][j] = new ResultadosxRonda(); // Crear la instancia
                TrabajoPractico31.MisColecciones.matResultadoXronda[i][j].setPuntaje(0); // Llamar al método en la instancia creada
            }
        }

           }

    public static void comparar(int cantPronosticos) {
        int ronda;
        int idp;
        int puntos;
        int idj;
        //HAGO EL CICLO PARA CADA PRONOSTICO - Y CON EL IDJ Y EL IDP ACCEDO A LOS DEMAS DATOS
        for (int i = 0; i < cantPronosticos; i++) {

            idj = TrabajoPractico31.MisColecciones.matPronosticos[i].getIdJugador();
            idp = TrabajoPractico31.MisColecciones.matPronosticos[i].getIdPartido();
            ronda= TrabajoPractico31.MisColecciones.matPartidos[idp - 1].getRonda();                         //********* agregue esta linea
            int gl = TrabajoPractico31.MisColecciones.matPartidos[idp - 1].getgLocal();
            int gv = TrabajoPractico31.MisColecciones.matPartidos[idp - 1].getgVisitante();
            String nombreJ = TrabajoPractico31.MisColecciones.matJugadores[idj - 1].getNombre();

            ResultadoEnum resultadoReal = Partido.getResultadoEnum( gl, gv);

              //SE SUMA LOS 3 PRONOSTICOS y SE DETERMINA EL PRONOSTICO
            //EN LA MATRIZ DE PRONOSTICOS, EN VEZ DE PONER UNA "X". SE COLOCA "1" SI GANO EL LOCAL  (1,0,0)
            //"2" SI GANO EL VISITANTE  (0,0,2) , Y "0" SI HUBO EMPATE (0,0,0)
            //ENTONCES AL SUMAR LOS PRONOSTICOS OBTENGO UN "0" o UN "1" o UN "2"
            //LUEGO HAGO EL SWITCH


            int totalPronostico= TrabajoPractico31.MisColecciones.matPronosticos[i].getganoLocal()+
                    TrabajoPractico31.MisColecciones.matPronosticos[i].getganoVisitante()+
                    TrabajoPractico31.MisColecciones.matPronosticos[i].getempato();

            ResultadoEnum sepronostico=null;
            switch (totalPronostico) {
                case 0:
                    sepronostico =ResultadoEnum.Empate;
                    break;
                case 1:
                    sepronostico =ResultadoEnum.GanadorLocal;
                    break;
                case 2:
                    sepronostico =ResultadoEnum.GanadorVisitante;
            }

            //DETERMINO SI ACERTO EL PRONOSTICO Y SUMO
            if (resultadoReal == sepronostico) {
                //SE SUMAn LOS PUNTOS QUE SE DEFINIERON EN CONFIGURACION EN LA FILA IDJ-1 (jugador) Y LA RONDA (ronda -1)
                //SUMO PUNTOS A LA RONDA
                puntos= TrabajoPractico31.MisColecciones.matResultadoXronda[idj - 1][ronda-1].getPuntaje();
                int puntosTotales = puntos + 1;
                TrabajoPractico31.MisColecciones.matResultadoXronda[idj - 1][ronda-1].setPuntaje(puntosTotales);
                //SUMO PUNTOS TOTALES DEL JUGADOR
                puntos= TrabajoPractico31.MisColecciones.matJugadores[idj - 1].getpuntos();
                puntosTotales = puntos + 1;
                TrabajoPractico31.MisColecciones.matJugadores[idj - 1].setpuntos(puntosTotales);
                System.out.print(nombreJ + " pronostico para el partido " + idp + ": "  + sepronostico + " : " + " el resultado real fue: " + resultadoReal +" - SUMA 1 " + " PUNTO");
                System.out.println("");
            }else {
                //SE restan LOS PUNTOS QUE SE DEFINIERON EN CONFIGURACION EN LA FILA IDJ-1 (jugador) Y LA RONDA (ronda -1)
                //RESTO PUNTOS A LA RONDA
                puntos= TrabajoPractico31.MisColecciones.matResultadoXronda[idj - 1][ronda-1].getPuntaje();
                int puntosTotales = puntos + 0;
                TrabajoPractico31.MisColecciones.matResultadoXronda[idj - 1][ronda-1].setPuntaje(puntosTotales);
                //SUMO PUNTOS TOTALES DEL JUGADOR
                puntos= TrabajoPractico31.MisColecciones.matJugadores[idj - 1].getpuntos();
                puntosTotales = puntos + 0;
                TrabajoPractico31.MisColecciones.matJugadores[idj - 1].setpuntos(puntosTotales);
                System.out.print(nombreJ + " pronostico para el partido " + idp + ": "  + sepronostico + " : " + " el resultado real fue: " + resultadoReal);
                System.out.println("");
            }

        }
        System.out.println("");
    }
}