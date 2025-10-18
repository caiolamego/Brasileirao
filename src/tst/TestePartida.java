package tst;

import static org.junit.Assert.*;
import org.junit.Test;

import brasileirao.Partida;
import brasileirao.Time;

public class TestePartida {

    @Test
    public void totalPartidas() {
        int numTimes = 20; 
        Partida partida = new Partida(); 
        int numPartidas = partida.gerarRodada(numTimes).size(); 
        
        assertEquals(10, numPartidas); 
    }
    
    @Test
    public void partidaComTimesMandanteVisitante() {
        Time timeA = new Time("Flamengo");
        Time timeB = new Time("Vasco");
        
        Partida partida = new Partida(timeA, timeB);
        
        assertEquals(timeA, partida.getMandante());
        assertEquals(timeB, partida.getVisitante());
    }
}