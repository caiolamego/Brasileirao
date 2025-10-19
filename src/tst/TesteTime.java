package tst;

import static org.junit.Assert.*;

import org.junit.Test;

import brasileirao.Time;

public class TesteTime {
	
	private Time time;

	@Test
	public void testCriarTime() {
        time = new Time("Flamengo");
        assertEquals("Flamengo", time.getNome());
        assertEquals(0, time.getPontos());
        assertEquals(0, time.getVitorias());
        assertEquals(0, time.getEmpates());
        assertEquals(0, time.getDerrotas());
        assertEquals(0, time.getGolsMarcados());
        assertEquals(0, time.getGolsSofridos());
        assertEquals(0, time.getSaldoDeGols());
    }

}
