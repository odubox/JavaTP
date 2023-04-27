package Clases;

import Prodep.TrabajoPractico32;

public class CompararResultados {


    public static int detCantRondas() {

        //DETERMINA LA CANTIDAD DE RONDAS
        int cantRondas = Integer.MIN_VALUE;
        for (int i = 0;
                i < TrabajoPractico32.MisColecciones.matPartidos.length; i++) {
            if (TrabajoPractico32.MisColecciones.matPartidos[i].getRonda() > cantRondas) { // si el valor actual es mayor que el valor máximo actual
                cantRondas = TrabajoPractico32.MisColecciones.matPartidos[i].getRonda(); // actualizamos el valor máximo
            }
        }
        return cantRondas;
    }

    public static void  iniciaMatrizJugadores(int cantJugadores, int cantRondas){
        //SE INICIALIZA LA MATRIZ (sino me da error cuando sumo...uhmmmm...)
        for(int i=0; i<cantJugadores; i++) {
            for(int j=0; j<cantRondas; j++){
                TrabajoPractico32.MisColecciones.matResultadoXronda[i][j] = new ResultadosxRonda(); // Crear la instancia
                TrabajoPractico32.MisColecciones.matResultadoXronda[i][j].setPuntaje(0); // Llamar al método en la instancia creada
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

            idj = TrabajoPractico32.MisColecciones.matPronosticos[i].getIdJugador();
            idp = TrabajoPractico32.MisColecciones.matPronosticos[i].getIdPartido();
            ronda= TrabajoPractico32.MisColecciones.matPartidos[idp - 1].getRonda();                         //********* agregue esta linea
            int gl = TrabajoPractico32.MisColecciones.matPartidos[idp - 1].getgLocal();
            int gv = TrabajoPractico32.MisColecciones.matPartidos[idp - 1].getgVisitante();
            String nombreJ = TrabajoPractico32.MisColecciones.matJugadores[idj - 1].getNombre();

            ResultadoEnum resultadoReal = Partido.getResultadoEnum( gl, gv);

              //SE SUMA LOS 3 PRONOSTICOS y SE DETERMINA EL PRONOSTICO
            //EN LA MATRIZ DE PRONOSTICOS, EN VEZ DE PONER UNA "X". SE COLOCA "1" SI GANO EL LOCAL  (1,0,0)
            //"2" SI GANO EL VISITANTE  (0,0,2) , Y "0" SI HUBO EMPATE (0,0,0)
            //ENTONCES AL SUMAR LOS PRONOSTICOS OBTENGO UN "0" o UN "1" o UN "2"
            //LUEGO HAGO EL SWITCH


            int totalPronostico=TrabajoPractico32.MisColecciones.matPronosticos[i].getganoLocal()+
                    TrabajoPractico32.MisColecciones.matPronosticos[i].getganoVisitante()+
                    TrabajoPractico32.MisColecciones.matPronosticos[i].getempato();

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
                puntos= TrabajoPractico32.MisColecciones.matResultadoXronda[idj - 1][ronda-1].getPuntaje();
                int puntosTotales = puntos + Configuracion.puntosSiAcierta;
                TrabajoPractico32.MisColecciones.matResultadoXronda[idj - 1][ronda-1].setPuntaje(puntosTotales);
                //SUMO PUNTOS TOTALES DEL JUGADOR
                puntos= TrabajoPractico32.MisColecciones.matJugadores[idj - 1].getpuntos();
                puntosTotales = puntos + Configuracion.puntosSiAcierta;
                TrabajoPractico32.MisColecciones.matJugadores[idj - 1].setpuntos(puntosTotales);
                System.out.print(nombreJ + " pronostico para el partido " + idp + ": "  + sepronostico + " : " + " el resultado real fue: " + resultadoReal +" - SUMA " + Configuracion.puntosSiAcierta + " PUNTOS");
                System.out.println("");
            }else {
                //SE restan LOS PUNTOS QUE SE DEFINIERON EN CONFIGURACION EN LA FILA IDJ-1 (jugador) Y LA RONDA (ronda -1)
                //RESTO PUNTOS A LA RONDA
                puntos= TrabajoPractico32.MisColecciones.matResultadoXronda[idj - 1][ronda-1].getPuntaje();
                int puntosTotales = puntos + Configuracion.puntosSiNoAcierta;
                TrabajoPractico32.MisColecciones.matResultadoXronda[idj - 1][ronda-1].setPuntaje(puntosTotales);
                //SUMO PUNTOS TOTALES DEL JUGADOR
                puntos= TrabajoPractico32.MisColecciones.matJugadores[idj - 1].getpuntos();
                puntosTotales = puntos + Configuracion.puntosSiNoAcierta;
                TrabajoPractico32.MisColecciones.matJugadores[idj - 1].setpuntos(puntosTotales);
                System.out.print(nombreJ + " pronostico para el partido " + idp + ": "  + sepronostico + " : " + " el resultado real fue: " + resultadoReal +" - RESTA " + Configuracion.puntosSiNoAcierta + " PUNTOS");
                System.out.println("");
            }

        }
        System.out.println("");
    }
}