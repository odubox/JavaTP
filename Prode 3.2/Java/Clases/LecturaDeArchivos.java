package Clases;

import Prodep.TrabajoPractico32;
import java.sql.*;
import java.util.Arrays;

import static Clases.ConectorSQL.*;
import static Clases.Informes.*;


public class LecturaDeArchivos {

    public static void leeJugadores() {
        //LECTURA DE ARCHIVO JUGADORES DESDE LA BD
        int i = 0;

        try {
            // Abrir la conexión
            TrabajoPractico32.conexion = DriverManager.getConnection(Configuracion.DB_URL, Configuracion.USER, Configuracion.PASS);

            // Ejecutar una consulta
            TrabajoPractico32.consulta = TrabajoPractico32.conexion.createStatement();
            String sql;

            TrabajoPractico32.consulta = TrabajoPractico32.conexion.createStatement();
            //String sql;
            sql = "SELECT * FROM jugadores";

            //En la variable resultado obtendremos las distintas filas que nos devolvió la base
            ResultSet resultado = TrabajoPractico32.consulta.executeQuery(sql);

            // Obtener las distintas filas de la consulta

            while (resultado.next()) {
                // Obtener el valor de cada columna

                int idJ = resultado.getInt("idJugador");
                String Nombre = resultado.getString("nombre");
                Jugador jugadores = new Jugador(idJ, Nombre);
                TrabajoPractico32.MisColecciones.matJugadores[i] = jugadores;
                i++;

            }
            System.out.println("Leidos " + i + " jugadores de la DB");
            // Esto se utiliza para cerrar la conexión con la base de datos
            resultado.close();
            TrabajoPractico32.consulta.close();
            TrabajoPractico32.conexion.close();
        } catch (SQLException se) {
            // Excepción ante problemas de conexión
            //se.printStackTrace();

            errorDeLectura("TP", TrabajoPractico32.conexion, TrabajoPractico32.consulta, 1);
            cerrarConexionDB("tp", TrabajoPractico32.conexion, TrabajoPractico32.consulta);
            System.exit(1);
        }

        //***** REDIMENSIONO LA MATRIZ **************
        TrabajoPractico32.MisColecciones.matJugadores = Arrays.copyOfRange(TrabajoPractico32.MisColecciones.matJugadores, 0, i);
    }

    public static void leePartidos() {
        // LECTURA DE ARCHIVO CSV DE PARTIDOS
        int i = 0;

        try {
            // Abrir la conexión
            TrabajoPractico32.conexion = DriverManager.getConnection(Configuracion.DB_URL, Configuracion.USER, Configuracion.PASS);

            // Ejecutar una consulta
            TrabajoPractico32.consulta = TrabajoPractico32.conexion.createStatement();
            String sql;

            TrabajoPractico32.consulta = TrabajoPractico32.conexion.createStatement();
            //String sql;
            sql = "SELECT * FROM Partidos";

            //En la variable resultado obtendremos las distintas filas que nos devolvió la base
            ResultSet resultado = TrabajoPractico32.consulta.executeQuery(sql);



            // Obtener las distintas filas de la consulta

            while (resultado.next()) {
                // Obtener el valor de cada columna

                int Idpartido =  resultado.getInt("idPartidos");
                int ronda =  resultado.getInt("Idronda");
                Equipo equipoLocal = new Equipo(resultado.getString("EquipoLocal"));
                Equipo equipoVisitante = new Equipo(resultado.getString("EquipoVisitante"));
                int gl =  resultado.getInt("GolesLocal");
                int gv =  resultado.getInt("GolesVisitante");

                Partido partido = new Partido(Idpartido,ronda,equipoLocal,equipoVisitante,gl,gv);
                TrabajoPractico32.MisColecciones.matPartidos[i]= partido;
                i++;
                TrabajoPractico32.cantPartidos = i;
            }
            System.out.println("Leidos " + i + " partidos de la DB");
            // Esto se utiliza para cerrar la conexión con la base de datos
            resultado.close();
            TrabajoPractico32.consulta.close();
            TrabajoPractico32.conexion.close();
        } catch (SQLException se) {
            // Excepción ante problemas de conexión
            //se.printStackTrace();
            errorDeLectura("tp - Partidos", TrabajoPractico32.conexion, TrabajoPractico32.consulta, 1);
            cerrarConexionDB("tp", TrabajoPractico32.conexion, TrabajoPractico32.consulta);
            System.exit(1);
        }
        // ***** REDIMENSIONO LA MATRIZ **************
        TrabajoPractico32.MisColecciones.matPartidos = Arrays.copyOfRange(TrabajoPractico32.MisColecciones.matPartidos, 0, i);
    }


    public static void LeePronosticos() {
        // LECTURA DE ARCHIVO CSV DE PRONOSTICOS
        int i = 0;

        try {
            // Abrir la conexión
            TrabajoPractico32.conexion = DriverManager.getConnection(Configuracion.DB_URL, Configuracion.USER, Configuracion.PASS);

            // Ejecutar una consulta
            TrabajoPractico32.consulta = TrabajoPractico32.conexion.createStatement();
            String sql;

            TrabajoPractico32.consulta = TrabajoPractico32.conexion.createStatement();
            //String sql;
            sql = "SELECT * FROM pronosticos";

            //En la variable resultado obtendremos las distintas filas que nos devolvió la base
            ResultSet resultado = TrabajoPractico32.consulta.executeQuery(sql);

            // Obtener las distintas filas de la consulta

            while (resultado.next()) {
                // Obtener el valor de cada columna

                int numJugador = resultado.getInt("idJugador");
                int numPartido = resultado.getInt("idPartido");
                String gl = resultado.getString("GanoLocal");
                String em = resultado.getString("Empate");
                String gv = resultado.getString("GanoVisitante");

                // SI LA LINEA VALIDAD CUMPLE CON LOS REQUISITOS, ENTONCES SE PROCESA
                int l=0, e=0, v=0;
                if (em.equals("X") ) {
                    e=0;
                }else if (gl.equals("X")){
                    l=1;
                }else{
                    if (gv.equals("X")){
                        v=2;
                    }
                }
                Pronostico  pronostico = new Pronostico(numJugador,numPartido, l, e, v);
                TrabajoPractico32.MisColecciones.matPronosticos[i]= pronostico;

                i = i + 1;
                TrabajoPractico32.cantPronosticos = i;
            }
            System.out.println("Leidos " + i + " pronosticos de la DB");
            // Esto se utiliza para cerrar la conexión con la base de datos
            resultado.close();
            TrabajoPractico32.consulta.close();
            TrabajoPractico32.conexion.close();
        } catch (SQLException se) {
            // Excepción ante problemas de conexión
            //se.printStackTrace();
            errorDeLectura("tp - Pronosticos", TrabajoPractico32.conexion, TrabajoPractico32.consulta, 1);
            cerrarConexionDB("tp", TrabajoPractico32.conexion, TrabajoPractico32.consulta);
            System.exit(1);
        }

        // ***** REDIMENSIONO LA MATRIZ **************
        TrabajoPractico32.MisColecciones.matPronosticos = Arrays.copyOfRange(TrabajoPractico32.MisColecciones.matPronosticos, 0, i);
    }

}


