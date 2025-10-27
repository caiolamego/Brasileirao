package brasileirao;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        long seed = Long.getLong("seed", new Random().nextLong());
        int maxGols = Integer.getInteger("maxGols", 4);
        boolean randCalendar = Boolean.getBoolean("randCalendar");
        Random rng = new Random(seed);

        // 6 times
        List<String> nomes = new ArrayList<>(Arrays.asList(
            "Cruzeiro", "Botafogo", "Palmeiras", "Bahia", "Flamengo", "Mirassol"
        ));
        if (randCalendar) {
            Collections.shuffle(nomes, new Random(seed ^ 0x9E3779B97F4A7C15L));
        }

        // Campeonato + times
        Campeonato camp = new Campeonato();
        for (String s : nomes) camp.adicionarTime(new Time(s));

        camp.gerarRodadas();

        //validação das rodadas
        int n = camp.getTimes().size();
        int jogosPorRodada = n / 2;
        boolean okRodadas = true, okSemDuplicidadeGlobal = true;
        Set<String> vistos = new HashSet<>();
        int rnum = 1;
        for (Rodada r : camp.getRodadas()) {
            if (r.getPartidas().size() != jogosPorRodada) okRodadas = false;
            Set<Time> usados = new HashSet<>();
            for (Partida p : r.getPartidas()) {
                if (!usados.add(p.getMandante()) || !usados.add(p.getVisitante())) okRodadas = false;
                String chave = p.getMandante().getNome() + " x " + p.getVisitante().getNome();
                if (!vistos.add(chave)) okSemDuplicidadeGlobal = false;
            }
            if (usados.size() != n) okRodadas = false;
            rnum++;
        }

        System.out.println("=== Mini Brasileirão (6 times) ===");
        System.out.println("Seed: " + seed + (randCalendar ? " (calendário embaralhado)" : ""));
        System.out.println("Checks pré-jogo -> Rodadas ok: " + okRodadas + " | Sem duplicidade global: " + okSemDuplicidadeGlobal);

        //registrarResultado + processarResultado
        int rodadaIdx = 1;
        for (Rodada r : camp.getRodadas()) {
            System.out.println("\n=== Rodada " + rodadaIdx++ + " ===");
            for (Partida p : r.getPartidas()) {
                int gm = rng.nextInt(Math.max(1, maxGols)); // 0..maxGols-1
                int gv = rng.nextInt(Math.max(1, maxGols));
                p.registrarResultado(gm, gv);
                p.processarResultado();
                System.out.printf("%s %s %s%n", p.getMandante().getNome(), p.getResultado(), p.getVisitante().getNome());
            }
        }

        //pontuação e stats
        boolean okPontosEStats = true;
        for (Time t : camp.getTimes()) {
            int esperadoP = 3 * t.getVitorias() + t.getEmpates();
            int esperadoSG = t.getGolsMarcados() - t.getGolsSofridos();
            if (t.getPontos() != esperadoP || t.getSaldoDeGols() != esperadoSG) okPontosEStats = false;
        }
        System.out.println("\nChecks pós-jogo -> Pontos/Stats coerentes: " + okPontosEStats);

        //desempate por vitórias
        List<Time> tabela = camp.getClassificacao();
        System.out.println("\n================= TABELA FINAL =================");
        System.out.printf("%-2s %-10s %3s %3s %3s %3s %4s%n", "#", "Time", "Pts", "Vit", "GP", "GC", "SG");
        int pos = 1;
        for (Time t : tabela) {
            System.out.printf("%-2d %-10s %3d %3d %3d %3d %4d%n",
                pos++, t.getNome(), t.getPontos(), t.getVitorias(),
                t.getGolsMarcados(), t.getGolsSofridos(), t.getSaldoDeGols());
        }

        boolean okDesempateVitorias = true;
        for (int i = 0; i < tabela.size() - 1; i++) {
            Time a = tabela.get(i), b = tabela.get(i + 1);
            if (a.getPontos() == b.getPontos() && a.getVitorias() < b.getVitorias()) okDesempateVitorias = false;
        }
        System.out.println("\nCheck desempate por vitórias: " + okDesempateVitorias);
        System.out.println("\nFim.");
    }
}
