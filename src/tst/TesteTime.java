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
	}

}
