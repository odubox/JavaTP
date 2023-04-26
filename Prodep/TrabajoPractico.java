package Prodep;

/**
 *
 * @author Omar
 */
//import Clases.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TrabajoPractico {

     
    // PROGRAMA PRINCIPAL
    public static void main(String[] args) throws IOException {
        
        
        // LECTURA DE ARCHIVO CSV Y GENERACION DE MATRIZ
       String Mpartidos[][] = new String[5][6];
       String Mresultados[][] = new String[6][9];
        int i=0;
        int j=0;
        //
        String resultadoPartidos = "C:\\Dropbox\\Java\\Prode\\Partidos.csv";
        for (String linea: Files.readAllLines(Paths.get(resultadoPartidos))) {
            //System.out.println("i = " + i);
        	j=0;
            for (String lineasStr : linea.split(",")) {
            	//System.out.println("    j = " + j);
            	//System.out.println(linea +  "\n i= " + i + "   -  j= " +j );
            	//System.out.println("i= " + i + "   -  j= " + j );
                linea = lineasStr;
                Mpartidos[i][j] = linea;
                j = j+1;
            }

            i = i+1;

        }   
        
        //System.out.println("i= " + i + "   -  j= " + j );
        
        // Muestra el contenido de la matriz de partidos
        for (int x = 0; x <= i-1; x=x+1) {
            for (int z = 0; z <= j-1; z=z+1) {
                System.out.println("Indice[" + x + "][" + z + "] = " + Mpartidos[x][z]);
            }
        }   
        
        // Carga la matriz Resultados con el nonbre de los equipos y quien gano o empato
        // 1 indica que gano Equipo A
        // 2 indica que gano equipo B
        // 3 indica un empate. Se carga este valor en la posicion [1] de la matriz
 
       int n = i; //cantidad de partidos
       System.out.println("Cant de partidos = " + n);
       
       //hasta aca bien
       
       
       
       
       
       
        for(int w=0; w < n; w=w+1){
            if (Integer.parseInt(Mpartidos[w][1]) > Integer.parseInt(Mpartidos[w][2]))  {      // gano el equipo A

                Mresultados[w][0]=Mpartidos[w][0]; //equipo A
                Mresultados[w][1]="1";              // gano el equipo A
                Mresultados[w][2]=Mpartidos[w][3]; //equipo b
            } else {
                if (Integer.parseInt(Mpartidos[w][1]) < Integer.parseInt(Mpartidos[w][2]))  { // gano el equipo B
                    Mresultados[w][0]=Mpartidos[w][0]; //equipo A
                    Mresultados[w][1]="2";              // gano el equipo B
                    Mresultados[w][2]=Mpartidos[w][3]; //equipo B
                } else  {
                    Mresultados[w][0]=Mpartidos[w][0]; //equipo A
                    Mresultados[w][1]="3";              // Hubo Empate
                    Mresultados[w][2]=Mpartidos[w][3]; //equipo B
                }
            } 
        }
        
        //Muestra la carga de la matriz de Resultados
        for (int x = 0; x <= 2; x=x+1) {
            for (int z = 0; z < n; z=z+1) {
                //System.out.println("Resultado[" + x + "][" + z + "] = " + Mresultados[x][z]);
            }
        } 

       //Muestra los equipos y quien fue ganador
        for (int x = 0; x < n; x=x+1) {
            System.out.print(Mresultados[x][0]  + " vs " + Mresultados[x][2]);
                
                switch (Integer.parseInt(Mresultados[x][1])){
              
                    case 1 -> 
                           System.out.print(" --> Gano " + Mresultados[x][0]);
                    case 2 -> 
                           System.out.print(" --> Gano " + Mresultados[x][2]);
                    default -> 
                           System.out.print(" --> Empate ");             
        }      
                System.out.println(" ");
               }     
        System.out.println("---------------------------------------------"); 
        
        //cargar a la matriz Mpronosticos el archivo Pronosticos.csv
        String Mpronosticos[][] = new String[4][8];
        int f=0;
        String resultadoPronosticos = "C:\\Dropbox\\Java\\Prode\\Pronosticos.csv";
        for (String linea2: Files.readAllLines(Paths.get(resultadoPronosticos))) {
            //System.out.println("Ejemplo: " + linea);
            int g=0;
            for (String lineasStr2 : linea2.split(",")) {
                linea2 = lineasStr2;
                Mpronosticos[f][g] = linea2;
                //System.out.println("Indice[" + f + "][" + g + "] = " + Mpronosticos[f][g]);
                g = g+1;
            }
            f = f+1;
        }
        
        //Muestra la mariz Pronostico
        for (int x = 0; x <= 2; x=x+1) {
            for (int d = 0; d <= 6; d=d+1) {
                //System.out.println("Pronosticos[" + x + "][" + d + "] = " + Mpronosticos[x][d]);
            }
        }
        
        //comparar la matriz de resultados, con la matriz de pronosticos
        System.out.println("---------------------------------------------"); 
       // n = cantidad de partidos
        for (int x = 0; x < n; x=x+1) {
            if (Integer.parseInt(Mresultados[x][1]) == 1){
                if (Mpronosticos[x][1].equals("X")){
                    System.out.println("Acerto: gano " + Mpronosticos[x][0]);
                    System.out.println("---------------------------------------------"); 
                    
                }
                else {
                	System.out.println("NO Acerto: gano " + Mpronosticos[x][0]);
                    System.out.println("---------------------------------------------"); 
                }
            }
            if (Integer.parseInt(Mresultados[x][1]) == 2){
                if (Mpronosticos[x][3].equals("X")){
                    System.out.println("Acerto: gano " + Mpronosticos[x][4]);
                    System.out.println("---------------------------------------------"); 
                }
                else {
                	System.out.println("NO Acerto: gano " + Mpronosticos[x][4]);
                    System.out.println("---------------------------------------------"); 
                }
            }
            if (Integer.parseInt(Mresultados[x][1]) == 3){
                if (Mpronosticos[x][2].equals("X")){
                    System.out.println("Acerto: " + Mpronosticos[x][0] + " vs " + Mpronosticos[x][4] + " hubo empate");
                    System.out.println("---------------------------------------------"); 
                }    
                else {
                	System.out.println("NO Acerto: no empataron");
                    System.out.println("---------------------------------------------"); 
                }
            }    
        }
            
        
            
            
        }
        
        
        }   
 

        
        
      
       
 
