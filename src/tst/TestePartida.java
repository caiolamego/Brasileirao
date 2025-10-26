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
	
	Partida partida;
	
	Object[][] resultados;
	String resultado;
	
	@Before
	public void setup() {
		partida = new Partida();
	}
	
	public TestePartida(Object[][] resultados, String resultado) {
		this.resultados = resultados;
		this.resultado = resultado;
	}
	
	@Parameters
	public static Collection<Object[]> getParameters(){
		Object[][] respostas = new Object[][] {
			{new Object[][] {
				{2, 0},
			}, "2 x 0"},
			{new Object[][] {
				{2, 0}, {3,0},
			}, "2 x 0\n3 x 0"},
			{new Object[][] {
				{2, 0}, {3,0}, {4,0},
			}, "2 x 0\n3 x 0\n4 x 0"},
		};
		return Arrays.asList(respostas);
	}
	
	@Test
	public void testRegistroResultados() {
		for (Object[] o : resultados) {
			partida.registrarResultado((int)o[0], (int)o[1]);
		}
		assertEquals(resultado, partida.getResultados());
	}
		
	@Test
	public void testAdicionarPartidaVitoria() {
		Time t = new Time("Cruzeiro");
		t.adicionarPartidaJogada(2, 0); 
		assertEquals(3, t.getPontos());
		assertEquals(1, t.getVitorias());
		assertEquals(0, t.getEmpates());
		assertEquals(0, t.getDerrotas());
		assertEquals(2, t.getGolsMarcados());
		assertEquals(0, t.getGolsSofridos());
		assertEquals(2, t.getSaldoDeGols());
	}

	@Test
	public void testAdicionarPartidaEmpate() {
		Time t = new Time("Cruzeiro");
		t.adicionarPartidaJogada(1, 1);
		assertEquals(1, t.getPontos());
		assertEquals(0, t.getVitorias());
		assertEquals(1, t.getEmpates());
		assertEquals(0, t.getDerrotas());
		assertEquals(1, t.getGolsMarcados());
		assertEquals(1, t.getGolsSofridos());
		assertEquals(0, t.getSaldoDeGols());
	}

	@Test
	public void testAdicionarPartidaDerrota() {
		Time t = new Time("Cruzeiro");
		t.adicionarPartidaJogada(0, 3);
		assertEquals(0, t.getPontos());
		assertEquals(0, t.getVitorias());
		assertEquals(0, t.getEmpates());
		assertEquals(1, t.getDerrotas());
		assertEquals(0, t.getGolsMarcados());
		assertEquals(3, t.getGolsSofridos());
		assertEquals(-3, t.getSaldoDeGols());
	}


}