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

}
