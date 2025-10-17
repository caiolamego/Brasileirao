package tst;

import static org.junit.Assert.*;
import org.junit.Test;
import brasileirao.Time;

public class TesteTime {

    @Test
    public void criarTimeComNome() {
        Time time = new Time("Flamengo");
        assertEquals("Flamengo", time.getNome());
    }
    
    @Test
    public void timeIniciaComPontuacaoZerada() {
        Time time = new Time("Palmeiras");
        assertEquals(0, time.getPontos());
        assertEquals(0, time.getVitorias());
        assertEquals(0, time.getGolsMarcados());
        assertEquals(0, time.getGolsSofridos());
        assertEquals(0, time.getSaldoGols());
    }
}