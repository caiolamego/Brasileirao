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
	

//    @Test
//    public void resultadoUmaPartida() {
//        partida.registrarResultado(2, 0);
//        assertEquals("2 x 0", partida.getResultados());
//    }
//    
//    @Test
//    public void resultadoDuasPartidas() {
//    	partida.registrarResultado(2, 0);
//        partida.registrarResultado(3, 0);
//        assertEquals("2 x 0\n3 x 0", partida.getResultados());
//    }
//    
//    @Test
//    public void resultadoTresPartidas() {
//    	partida.registrarResultado(2, 0);
//        partida.registrarResultado(3, 0);
//        partida.registrarResultado(4, 0);
//        assertEquals("2 x 0\n3 x 0\n4 x 0", partida.getResultados());
//    }

}