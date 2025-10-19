package tst;

import static org.junit.Assert.*;

import org.junit.Test;

import brasileirao.Sumula;

public class TesteSumula {

	@Test
	public void testePontosVitoriaMandante() {
		Sumula s = new Sumula(2,0);
		assertEquals(3, s.getPontosMandante());
		assertEquals(0, s.getPontosVisitante());
		
	}
	
	@Test
	public void testePontosVitoriaVisitante() {
		Sumula s = new Sumula(0,2);
		assertEquals(0, s.getPontosMandante());
		assertEquals(3, s.getPontosVisitante());
	}
	
	@Test
	public void testePontosEmpate() {
		Sumula s = new Sumula(3,3);
		assertEquals(1, s.getPontosMandante());
		assertEquals(1, s.getPontosVisitante());
		
	}

}
