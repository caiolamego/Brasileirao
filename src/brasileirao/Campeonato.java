package brasileirao;

import java.util.*;

public class Campeonato {

    private final List<Time> times = new ArrayList<>();
    private final List<Rodada> rodadas = new ArrayList<>();

    public void adicionarTime(Time t) {
        times.add(t);
    }

    public List<Time> getTimes() {
        return times;
    }

    public List<Rodada> getRodadas() {
        return rodadas;
    }

    public void gerarRodadas() {
        rodadas.clear();
        int n = times.size();
        if (n <= 0 || n % 2 != 0) {
            throw new IllegalStateException("Numero de times deve ser par e maior que zero.");
        }

        java.util.List<Time> lista = new java.util.ArrayList<>(times);

        int rounds = n - 1;
        int jogosPorRodada = n / 2;

        List<Rodada>turno = gerarTurno(rounds, jogosPorRodada, lista, n);
        
        gerarReturno(turno);

    }

    private List<Rodada> gerarTurno(int rounds, int jogosPorRodada, List<Time>lista, int qtdeTimes) {
        java.util.List<Rodada> turno = new java.util.ArrayList<>(rounds);
        
        for (int r = 0; r < rounds; r++) {
            Rodada rodada = new Rodada();

            for (int i = 0; i < jogosPorRodada; i++) {
                Time mandante = lista.get(i);
                Time visitante = lista.get(qtdeTimes - 1 - i);
                rodada.addPartida(new Partida(mandante, visitante));
            }
            turno.add(rodada);

            java.util.Collections.rotate(lista.subList(1, qtdeTimes), 1);
        }

        return turno;
    }

    private void gerarReturno(List<Rodada>turno) {

        for (Rodada r : turno) {
            Rodada espelho = new Rodada();
            for (Partida p : r.getPartidas()) {
                espelho.addPartida(new Partida(p.getVisitante(), p.getMandante()));
            }
            rodadas.add(r);
            rodadas.add(espelho);
        }
    }

    public List<Time> getClassificacao() {
        List<Time> copia = new ArrayList<>(times);
        copia.sort(new ClassificacaoComparator());
        return copia;
    }

}
