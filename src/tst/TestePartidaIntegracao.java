package tst;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import brasileirao.Partida;
import brasileirao.Time;


@RunWith(Parameterized.class)
public class TestePartidaIntegracao {
	
	private Time mandante; 
	private Time visitante;
	private Partida partida;
	
	private int golsMandante;
	private int golsVisitante;
	private int pontosMandanteEsperado;
	private int pontosVisitanteEsperado;
	
	@Before
	public void setup() {
		mandante = new Time("Mandante");
		visitante = new Time("Visitante");
		partida = new Partida(mandante, visitante);
	}
	
	public TestePartidaIntegracao(int golsMandante, int golsVisitante, int pontosMandanteEsperado, int pontosVisitanteEsperado ) {
		this.golsMandante = golsMandante;
        this.golsVisitante = golsVisitante;
        this.pontosMandanteEsperado = pontosMandanteEsperado;
        this.pontosVisitanteEsperado = pontosVisitanteEsperado;
	}
	
	@Parameters
	public static Collection<Object[]> getParameters(){
		Object[][] params = new Object[][] {
			{2, 0, 3, 0}, // Vitoria Mandante
            {0, 2, 0, 3}, // Vitoria Visitante
            {3, 3, 1, 1}  // Empate
		};
		return Arrays.asList(params);
	}

	@Test
	public void testePartidaAtualizaPontos() {
		partida.registrarResultado(golsMandante, golsVisitante);
		assertEquals(pontosMandanteEsperado, mandante.getPontos());
		assertEquals(pontosVisitanteEsperado, visitante.getPontos());
	}

}
