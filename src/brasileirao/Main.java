package brasileirao;

import java.util.*;

public class Main {
    private static final int MAX_GOLS = 6;

    public static void main(String[] args) {
        Random rng = new Random();

        List<String> nomes = Arrays.asList(
            "Cruzeiro", "Botafogo", "Palmeiras", "Bahia", "Flamengo", "Mirassol"
        );

        Campeonato camp = new Campeonato();
        for (String s : nomes) camp.adicionarTime(new Time(s));

        camp.gerarRodadas();

        //validação das rodadas 
        int n = camp.getTimes().size();
        int jogosPorRodada = n / 2;
        boolean okRodadas = true, okSemDuplicidadeGlobal = true;
        Set<String> confrontos = new HashSet<>();
        for (Rodada r : camp.getRodadas()) {
            if (r.getPartidas().size() != jogosPorRodada) okRodadas = false;
            Set<Time> usados = new HashSet<>();
            for (Partida p : r.getPartidas()) {
                if (!usados.add(p.getMandante()) || !usados.add(p.getVisitante())) okRodadas = false;
                String chave = p.getMandante().getNome() + " x " + p.getVisitante().getNome();
                if (!confrontos.add(chave)) okSemDuplicidadeGlobal = false;
            }
            if (usados.size() != n) okRodadas = false;
        }

        System.out.println("=== Mini Brasileirão (6 times) ===");
        System.out.println("Rodadas ok: " + okRodadas + " | Sem duplicidade global: " + okSemDuplicidadeGlobal);

        //registrarResultado + processarResultado
        int rodadaNum = 1;
        for (Rodada r : camp.getRodadas()) {
            System.out.println("\n=== Rodada " + (rodadaNum++) + " ===");
            for (Partida p : r.getPartidas()) {
                int gm = rng.nextInt(Math.max(1, MAX_GOLS)); // 0..MAX_GOLS-1
                int gv = rng.nextInt(Math.max(1, MAX_GOLS));
                p.registrarResultado(gm, gv);
                p.processarResultado();
                System.out.printf("%s %s %s%n",
                    p.getMandante().getNome(), p.getResultado(), p.getVisitante().getNome());
            }
        }

        //Pontos e stats 
        boolean okPontosEStats = true;
        for (Time t : camp.getTimes()) {
            int esperadoP = 3 * t.getVitorias() + t.getEmpates();
            int esperadoSG = t.getGolsMarcados() - t.getGolsSofridos();
            if (t.getPontos() != esperadoP || t.getSaldoDeGols() != esperadoSG) okPontosEStats = false;
        }
        System.out.println("\nPontos/Stats coerentes: " + okPontosEStats);

        //Classificação 
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
        System.out.println("\nDesempate por vitórias respeitado: " + okDesempateVitorias);
        System.out.println("\nFim.");
    }
}
