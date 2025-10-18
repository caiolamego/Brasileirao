package tst;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import brasileirao.Partida;

public class TestePartida {
	
	Partida partida;
	@Before
	public void setup() {
		partida = new Partida();
	}
	

    @Test
    public void resultadoUmaPartida() {
        partida.registrarResultado(2, 0);
        assertEquals("2 x 0", partida.getResultados());
    }
    
    @Test
    public void resultadoDuasPartidas() {
    	partida.registrarResultado(2, 0);
        partida.registrarResultado(3, 0);
        assertEquals("2 x 0\n3 x 0", partida.getResultados());
    }
    
    @Test
    public void resultadoTresPartidas() {
    	partida.registrarResultado(2, 0);
        partida.registrarResultado(3, 0);
        partida.registrarResultado(4, 0);
        assertEquals("2 x 0\n3 x 0\n4 x 0", partida.getResultados());
    }

}