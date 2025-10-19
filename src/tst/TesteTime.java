package tst;

import static org.junit.Assert.*;

import org.junit.Test;

import brasileirao.Time;

public class TesteTime {

	@Test
	public void testeTimeRegistraPontos() {
		Time time = new Time("Flamengo");
		time.adicionarPontos(3);
		assertEquals(3, time.getPontos());
	}

}
