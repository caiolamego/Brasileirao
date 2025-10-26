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
public class TestePartida {
	
	private Time mandante;
    private Time visitante;
    private Partida partida;

	private final int golsMandanteParam;
    private final int golsVisitanteParam;
    private final String resultadoStringEsperado;
    private final int pontosMandanteEsperado;
    private final int pontosVisitanteEsperado;
	
	@Before
	public void setup() {
		mandante = new Time("Mandante");
        visitante = new Time("Visitante");
        partida = new Partida(mandante, visitante);
	}
	
	public TestePartida(int gm, int gv, String esperado, int ptsM, int ptsV) {
        this.golsMandanteParam = gm;
        this.golsVisitanteParam = gv;
        this.resultadoStringEsperado = esperado;
        this.pontosMandanteEsperado = ptsM;
        this.pontosVisitanteEsperado = ptsV;
    }
	
	@Parameters
    public static Collection<Object[]> getParameters() {
        return Arrays.asList(new Object[][] {
            // gm, gv,   placar,  ptsMandante, ptsVisitante
            { 2, 0,  "2 x 0",         3,            0 }, // vitória mandante
            { 0, 2,  "0 x 2",         0,            3 }, // vitória visitante
            { 1, 1,  "1 x 1",         1,            1 }  // empate
        });
    }
	
		
	@Test
	public void testAcumulacaoDePartidas() {
		Time t = new Time("Cruzeiro");
		t.adicionarPartidaJogada(2, 1); 
		t.adicionarPartidaJogada(0, 0); 
		t.adicionarPartidaJogada(0, 2); 
		assertEquals(4, t.getPontos());
		assertEquals(1, t.getVitorias());
		assertEquals(1, t.getEmpates());
		assertEquals(1, t.getDerrotas());
		assertEquals(2, t.getGolsMarcados());
		assertEquals(3, t.getGolsSofridos());
		assertEquals(-1, t.getSaldoDeGols());
		
	}

	@Test
    public void testRegistrarResultadoUnico() {
        partida.registrarResultado(golsMandanteParam, golsVisitanteParam);
        assertEquals(resultadoStringEsperado, partida.getResultado());
    }

	@Test
    public void testProcessarResultadoAtualizaDoisTimes() {
        partida.registrarResultado(golsMandanteParam, golsVisitanteParam);
        partida.processarResultado();

        assertEquals(pontosMandanteEsperado, mandante.getPontos());
        assertEquals(pontosVisitanteEsperado, visitante.getPontos());
    }


}