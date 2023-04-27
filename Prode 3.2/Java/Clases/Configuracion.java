package Clases;

public class Configuracion {

    // Credenciales credentials
    public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    public static final String DB_URL = "jdbc:mysql://Localhost:3306/tp";
    public static final String USER = "root";
    public static final String PASS = "root";

    // Otras configuraciones
    public static final int puntosSiAcierta = 3;
    public static final int puntosSiNoAcierta= -1;
    public static final int puntosExtrasRonda= 5;

    //SET DE ARCHIVOS 1
    public static final String ArchivoJugador ="Jugadores";
    public static final String ArchivoPartidos ="Partidos";
    public static final String ArchivoPronosticos ="Pronosticos";

    //SET DE ARCHIVOS 2 PARA TEST Y VALIDACIONES
    //public static final String ArchivoPartidos ="Partidos4Rondas";
    //public static final String ArchivoPronosticos ="PronosticosRepetidos";


}
