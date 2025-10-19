package tst;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import brasileirao.Time;

public class TesteTime {
	
	Time time;
	
	@Before
	public void setup() {
		time = new Time("Flamengo");
	}

	@Test
	public void testeTimeRegistraPontos() {
		time.adicionarPontos(3);
		assertEquals(3, time.getPontos());
	}
	
	@Test
	public void testeTimeRegistraDuasPontuacoes() {
		time.adicionarPontos(3);
		time.adicionarPontos(1);
		assertEquals(4, time.getPontos());
	}
	
	@Test
	public void testeTimeRegistraTresPontuacoes() {
		time.adicionarPontos(3);
		time.adicionarPontos(1);
		time.adicionarPontos(3);
		assertEquals(7, time.getPontos());
	}

}
