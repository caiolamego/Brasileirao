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
        int n = times.size();
        if (n <= 0 || n % 2 != 0) {
            throw new IllegalStateException("Numero de times deve ser par e maior que zero.");
        }

        // lista com todos os confrontos possíveis
        List<Partida> todas = new ArrayList<>();
        for (Time mandante : times) {
            for (Time visitante : times) {
                if (mandante != visitante) {
                    todas.add(new Partida(mandante, visitante));
                }
            }
        }

        Collections.shuffle(todas); //sorteio

        int numRodadas = (n - 1) * 2;
        int partidasPorRodada = n / 2;

        for (int i = 0; i < numRodadas; i++) {
            Rodada r = new Rodada();
            for (int j = 0; j < partidasPorRodada; j++) {
                r.addPartida(todas.remove(0));
            }
            rodadas.add(r);
        }
    }

    public List<Time> getClassificacao() {
        List<Time> copia = new ArrayList<>(times);
        copia.sort(new ClassificacaoComparator());
        return copia;
    }

}
