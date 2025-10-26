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

    @Test(expected = IllegalStateException.class)
        public void testGerarRodadasComNumeroImparDeTimes() {
            brasileirao.adicionarTime(new Time("A"));
            brasileirao.adicionarTime(new Time("B"));
            brasileirao.adicionarTime(new Time("C")); 
            brasileirao.gerarRodadas(); 
        }

    @Test
        public void testClassificacaoPorPontosEDesempateVitorias() {
            Time a = new Time("Time A"); // 3 pts, 1V
            Time b = new Time("Time B"); // 3 pts, 0V
            brasileirao.adicionarTime(a);
            brasileirao.adicionarTime(b);

            a.adicionarPartidaJogada(1, 0); // vitória -> +3
            b.adicionarPartidaJogada(1, 1); // empate -> +1
            b.adicionarPartidaJogada(0, 0); // +1 (2)
            b.adicionarPartidaJogada(2, 2); // +1 (3) e 0 vitórias

            java.util.List<Time> cls = brasileirao.getClassificacao();

            assertEquals("Time A", cls.get(0).getNome());
            assertEquals("Time B", cls.get(1).getNome());
        }

    @Test
        public void testRodadasSemRepeticaoENComTodosOsTimes_naRodada() {
            Campeonato camp = new Campeonato();
            Time t1 = new Time("A"); Time t2 = new Time("B"); Time t3 = new Time("C");
            Time t4 = new Time("D"); Time t5 = new Time("E"); Time t6 = new Time("F");
            Arrays.asList(t1,t2,t3,t4,t5,t6).forEach(camp::adicionarTime);

            camp.gerarRodadas(); 

            int n = camp.getTimes().size();
            int partidasPorRodada = n / 2;

            for (Rodada r : camp.getRodadas()) {
                assertEquals(partidasPorRodada, r.getPartidas().size());

                java.util.Set<Time> vistos = new java.util.HashSet<>();
                for (Partida p : r.getPartidas()) {
                    assertTrue("time mandante repetido na rodada", vistos.add(p.getMandante()));
                    assertTrue("time visitante repetido na rodada", vistos.add(p.getVisitante()));
                }
                assertEquals("nem todos os times presentes na rodada", n, vistos.size());
            }
        }


}
