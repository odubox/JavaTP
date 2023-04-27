package Clases;

import Prodep.TrabajoPractico32;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Validaciones {
    public static boolean validaGoles(int cp) {
        boolean ok=true;
        for (int i = 0; i < cp; i++) {
            int idp = TrabajoPractico32.MisColecciones.matPronosticos[i].getIdPartido();
            int gl = TrabajoPractico32.MisColecciones.matPartidos[idp - 1].getgLocal();
            int gv = TrabajoPractico32.MisColecciones.matPartidos[idp - 1].getgVisitante();

            if (gl < 0 || gv <0){
                ok= false;
            }
        }
            return ok;
    }
    public static boolean validaPronostico(String a, String b, String c) {
        boolean ok=true;
        if(a.equals("X")){
            if (!b.equals("") || !c.equals("")){
                ok=false;
            }
        }
        if(b.equals("X")){
            if (!a.equals("") || !c.equals("")){
                ok=false;
            }
        }
        if(c.equals("X")){
            if (!b.equals("") || !a.equals("")){
                ok=false;
            }
        }
        return ok;
    }

/*
        // ---------- VALIDAR DATOS DE GOLES -----------------------------------------------------------------------------------

        for (String linea : Files.readAllLines(Paths.get(args[1]))) {
            String[] campos = linea.split(";");
            String controlDatos = (campos[4]);
            if (esNumero(controlDatos)) {
                System.out.println(controlDatos + "   \t\tEste dato es correcto.");
            } else {
                System.out.println(controlDatos + "   \t*\tEste dato es incorrecto.");
            }
        }

        System.out.println("\n----------------------------------------");
        System.out.println("\nValidación de datos. Goles equipo Visitante.\n");

        for (String linea : Files.readAllLines(Paths.get(args[1]))) {
            String[] campos = linea.split(";");
            String controlDatos = (campos[5]);
            if (esNumero(controlDatos)) {
                System.out.println(controlDatos + "   \t\tEste dato es correcto.");
            } else {
                System.out.println(controlDatos + "   \t*\tEste dato es incorrec2to.");
            }
        }
    */
}