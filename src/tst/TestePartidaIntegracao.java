package tst;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import brasileirao.Partida;
import brasileirao.Time;

public class TestePartidaIntegracao {
	
	private Time mandante;
	private Time visitante;
	private Partida partida;
	
	@Before
	public void setup() {
		mandante = new Time("Mandante");
		visitante = new Time("Visitante");
		partida = new Partida(mandante, visitante);
	}

	@Test
	public void testePartidaPontuacaoVitoriaMandante() {
		partida.registrarResultado(2, 0);
		assertEquals(3, mandante.getPontos());
		assertEquals(0, visitante.getPontos());
	}

}
