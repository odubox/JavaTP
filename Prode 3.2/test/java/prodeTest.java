import Clases.CompararResultados;
import Clases.LecturaDeArchivos;
import Prodep.TrabajoPractico32;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class prodeTest {
    private int cr;

    @Test
    public void detCantRondasTest() {
        //Escenario
        int cRondasReales = 3;

        //Proceso
        CompararResultados.iniciaMatrizJugadores(3, 3);
        CompararResultados compara = new CompararResultados();
        LecturaDeArchivos.leePartidos();
        int rondasLeidas = compara.detCantRondas();

        //Verificacion
        assertEquals(cRondasReales, rondasLeidas);
    }

    @Test
    public void leePartidosTest() {
        LecturaDeArchivos.leePartidos();
         //Verificacion
        assertEquals(9, TrabajoPractico32.cantPartidos);
}
    @Test
    public void leePronosticosTest() {
        LecturaDeArchivos.LeePronosticos();
        //Verificacion
        assertEquals(27, TrabajoPractico32.cantPronosticos);
    }
}
