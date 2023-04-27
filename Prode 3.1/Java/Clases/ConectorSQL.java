package Clases;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ConectorSQL {

    public static void cerrarConexionDB(String nombreDB, Connection conexion, Statement consulta) {
        try {
            if (consulta != null) {//si hay una consulta abierta que la cierre
                consulta.close();
                System.out.println("Cerre la consulta");
            }
        } catch (SQLException se2) {
            Informes.errorDeLectura( nombreDB, conexion, consulta, 3);
        }
        try {
            if (conexion != null){
                conexion.close();
                System.out.println("Cerre la conexion");
            }
        } catch (SQLException se) {
            Informes informe = new Informes();
            informe.errorDeLectura(nombreDB, conexion, consulta, 2);
            //se.printStackTrace();
        }
    }

}

