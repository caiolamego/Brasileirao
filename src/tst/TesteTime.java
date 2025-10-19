package tst;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import brasileirao.Time;


@RunWith(Parameterized.class)
public class TesteTime {
	
	Time time;
	private int[] pontosAdicionados;
	private int totalPontuacaoEsperada;
	
	@Before
	public void setup() {
		time = new Time("Flamengo");
	}
	
	public TesteTime(int[] pontosAdicionados, int totalPontuacaoEsperada) {
		this.pontosAdicionados = pontosAdicionados;
		this.totalPontuacaoEsperada = totalPontuacaoEsperada;
	}
	
	@Parameters
	public static Collection<Object[]> getParameters(){
		Object[][] params = new Object[][] {
			{new int[]{3}, 3},         // Uma vitoria
            {new int[]{1, 3}, 4},      // Um empate e uma vitoria
            {new int[]{3, 1, 3}, 7},   // Duas vitorias e um empate
            {new int[]{3, 0, 3}, 6},   // Duas vitorias e uma derrota
            {new int[]{}, 0}		
		};
		
		return Arrays.asList(params);
	}
	
	@Test
	public void testeAdicionarPontos() {
		for (int p: pontosAdicionados) {
			time.adicionarPontos(p);
		}
		assertEquals(totalPontuacaoEsperada, time.getPontos());
	}
		

//	@Test
//	public void testeTimeRegistraPontos() {
//		time.adicionarPontos(3);
//		assertEquals(3, time.getPontos());
//	}
//	
//	@Test
//	public void testeTimeRegistraDuasPontuacoes() {
//		time.adicionarPontos(3);
//		time.adicionarPontos(1);
//		assertEquals(4, time.getPontos());
//	}
//	
//	@Test
//	public void testeTimeRegistraTresPontuacoes() {
//		time.adicionarPontos(3);
//		time.adicionarPontos(1);
//		time.adicionarPontos(3);
//		assertEquals(7, time.getPontos());
//	}

}
