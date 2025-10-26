package tst;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.Before;
import org.junit.Test;

import brasileirao.*; 

public class TesteCampeonato {

    private Campeonato brasileirao;

    @Before
    public void setup() {
        brasileirao = new Campeonato(); 
    }

    @Test
    public void testAdicionarTime() {
        Time g = new Time("Gremio");
        brasileirao.adicionarTime(g);
        assertEquals(1, brasileirao.getTimes().size());
        assertTrue(brasileirao.getTimes().contains(g));
    }

    @Test
    public void testGerarRodadasCom4Times() {
        Time a = new Time("Time A");
        Time b = new Time("Time B");
        Time c = new Time("Time C");
        Time d = new Time("Time D");
        Arrays.asList(a,b,c,d).forEach(brasileirao::adicionarTime);

        brasileirao.gerarRodadas(); 

        assertEquals(6, brasileirao.getRodadas().size());

        Set<String> jogosUnicos = new HashSet<>();
        int totalPartidas = 0;

        for (Rodada r : brasileirao.getRodadas()) {
            assertEquals(2, r.getPartidas().size());
            for (Partida p : r.getPartidas()) {
                totalPartidas++;
                String chave = p.getMandante().getNome() + " x " + p.getVisitante().getNome();
                assertTrue("Jogo duplicado: " + chave, jogosUnicos.add(chave));
            }
        }
        assertEquals(12, totalPartidas);
    }
}
