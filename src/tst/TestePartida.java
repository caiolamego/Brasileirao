package tst;

import static org.junit.Assert.*;
import org.junit.Test;

import brasileirao.Partida;

public class TestePartida {

    @Test
    public void totalPartidas() {
        int numTimes = 20; 
        Partida partida = new Partida(); 
        int numPartidas = partida.gerarRodada(numTimes).size(); 
        
        assertEquals(10, numPartidas); 
    }
}