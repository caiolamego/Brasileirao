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
    public void resultadoPartidas() {
        partida.registrarResultado(2, 0);
        assertEquals("2 x 0", partida.getResultado());
    }

}