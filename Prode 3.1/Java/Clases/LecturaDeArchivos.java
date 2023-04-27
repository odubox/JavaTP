package Clases;

import Prodep.TrabajoPractico31;
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
            TrabajoPractico31.conexion = DriverManager.getConnection(Configuracion.DB_URL, Configuracion.USER, Configuracion.PASS);

            // Ejecutar una consulta
            TrabajoPractico31.consulta = TrabajoPractico31.conexion.createStatement();
            String sql;

            TrabajoPractico31.consulta = TrabajoPractico31.conexion.createStatement();
            //String sql;
            sql = "SELECT * FROM " + Configuracion.ArchivoJugador;

            //En la variable resultado obtendremos las distintas filas que nos devolvió la base
            ResultSet resultado = TrabajoPractico31.consulta.executeQuery(sql);

            // Obtener las distintas filas de la consulta

            while (resultado.next()) {
                // Obtener el valor de cada columna

                int idJ = resultado.getInt("idJugador");
                String Nombre = resultado.getString("nombre");
                Jugador jugadores = new Jugador(idJ, Nombre);
                TrabajoPractico31.MisColecciones.matJugadores[i] = jugadores;
                i++;

            }
            System.out.println("Leidos " + i + " jugadores de la DB");
            // Esto se utiliza para cerrar la conexión con la base de datos
            resultado.close();
            TrabajoPractico31.consulta.close();
            TrabajoPractico31.conexion.close();
        } catch (SQLException se) {
            // Excepción ante problemas de conexión
            //se.printStackTrace();

            Informes.errorDeLectura("TP", TrabajoPractico31.conexion, TrabajoPractico31.consulta, 1);
            cerrarConexionDB("tp", TrabajoPractico31.conexion, TrabajoPractico31.consulta);
            System.exit(1);
        }

        //***** REDIMENSIONO LA MATRIZ **************
        TrabajoPractico31.MisColecciones.matJugadores = Arrays.copyOfRange(TrabajoPractico31.MisColecciones.matJugadores, 0, i);
    }

    public static void leePartidos() {
        // LECTURA DE ARCHIVO CSV DE PARTIDOS
        int i = 0;

        try {
            // Abrir la conexión
            TrabajoPractico31.conexion = DriverManager.getConnection(Configuracion.DB_URL, Configuracion.USER, Configuracion.PASS);

            // Ejecutar una consulta
            TrabajoPractico31.consulta = TrabajoPractico31.conexion.createStatement();
            String sql;

            TrabajoPractico31.consulta = TrabajoPractico31.conexion.createStatement();
            //String sql;
            sql = "SELECT * FROM " + Configuracion.ArchivoPartidos;

            //En la variable resultado obtendremos las distintas filas que nos devolvió la base
            ResultSet resultado = TrabajoPractico31.consulta.executeQuery(sql);



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
                TrabajoPractico31.MisColecciones.matPartidos[i]= partido;
                i++;
                TrabajoPractico31.cantPartidos = i;
            }
            System.out.println("Leidos " + i + " partidos de la DB");
            // Esto se utiliza para cerrar la conexión con la base de datos
            resultado.close();
            TrabajoPractico31.consulta.close();
            TrabajoPractico31.conexion.close();
        } catch (SQLException se) {
            // Excepción ante problemas de conexión
            //se.printStackTrace();
            errorDeLectura("tp - Partidos",TrabajoPractico31.conexion, TrabajoPractico31.consulta, 1);
            cerrarConexionDB("tp", TrabajoPractico31.conexion, TrabajoPractico31.consulta);
            System.exit(1);
        }
        // ***** REDIMENSIONO LA MATRIZ **************
        TrabajoPractico31.MisColecciones.matPartidos = Arrays.copyOfRange(TrabajoPractico31.MisColecciones.matPartidos, 0, i);
    }


    public static void LeePronosticos() {
        // LECTURA DE ARCHIVO CSV DE PRONOSTICOS
        int i = 0;

        try {
            // Abrir la conexión
            TrabajoPractico31.conexion = DriverManager.getConnection(Configuracion.DB_URL, Configuracion.USER, Configuracion.PASS);

            // Ejecutar una consulta
            TrabajoPractico31.consulta = TrabajoPractico31.conexion.createStatement();
            String sql;

            TrabajoPractico31.consulta = TrabajoPractico31.conexion.createStatement();
            //String sql;
            sql = "SELECT * FROM " + Configuracion.ArchivoPronosticos;

            //En la variable resultado obtendremos las distintas filas que nos devolvió la base
            ResultSet resultado = TrabajoPractico31.consulta.executeQuery(sql);

            // Obtener las distintas filas de la consulta

            while (resultado.next()) {
                // Obtener el valor de cada columna

                int numJugador = resultado.getInt("idJugador");
                int numPartido = resultado.getInt("idPartido");
                String gl = resultado.getString("GanoLocal");
                String em = resultado.getString("Empate");
                String gv = resultado.getString("GanoVisitante");

                // valida la linea leida
                if (!Validaciones.validaPronostico(gl, em, gv)){
                    errorDeLectura(5);
                    System.out.println("#Linea: "+ ++i + " del archivo pronosticos repetida una X");
                    ConectorSQL.cerrarConexionDB("tp", TrabajoPractico31.conexion, TrabajoPractico31.consulta);
                    System.exit(1);
                }
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
                TrabajoPractico31.MisColecciones.matPronosticos[i]= pronostico;

                i = i + 1;
                TrabajoPractico31.cantPronosticos = i;
            }
            System.out.println("Leidos " + i + " pronosticos de la DB");
            // Esto se utiliza para cerrar la conexión con la base de datos
            resultado.close();
            TrabajoPractico31.consulta.close();
            TrabajoPractico31.conexion.close();
        } catch (SQLException se) {
            // Excepción ante problemas de conexión
            //se.printStackTrace();
            Informes.errorDeLectura("tp - Pronosticos", TrabajoPractico31.conexion, TrabajoPractico31.consulta, 1);
            cerrarConexionDB("tp", TrabajoPractico31.conexion, TrabajoPractico31.consulta);
            System.exit(1);
        }

        // ***** REDIMENSIONO LA MATRIZ **************
        TrabajoPractico31.MisColecciones.matPronosticos = Arrays.copyOfRange(TrabajoPractico31.MisColecciones.matPronosticos, 0, i);
    }

}


