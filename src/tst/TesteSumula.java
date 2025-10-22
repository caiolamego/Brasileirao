package tst;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import brasileirao.Sumula;

@RunWith(Parameterized.class)
public class TesteSumula {
	
	int golsMandante;
	int golsVisitante;
	int pontosMandanteEsperado;
	int pontosVisitanteEsperado;
	
	Sumula s;
	
	@Before
	public void setup() {
		s = new Sumula(golsMandante, golsVisitante);
	}
	
	public TesteSumula(int golsMandante, int golsVisitante, int pontosMandanteEsperado, int pontosVisitanteEsperado) {
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
            {1, 1, 1, 1}, // Empate
		};
		return Arrays.asList(params);
	}
	
	@Test
	public void testePontuacaoSumula() {
		assertEquals(pontosMandanteEsperado, s.getPontosMandante());
		assertEquals(pontosVisitanteEsperado, s.getPontosVisitante());
	}

}
