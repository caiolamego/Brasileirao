package brasileirao;

import java.util.Comparator;

public class ClassificacaoComparator implements Comparator<Time> {
    @Override
    public int compare(Time t1, Time t2) {
        if (t1.getPontos() != t2.getPontos()) return t2.getPontos() - t1.getPontos();
        if (t1.getVitorias() != t2.getVitorias()) return t2.getVitorias() - t1.getVitorias();
        if (t1.getSaldoDeGols() != t2.getSaldoDeGols()) return t2.getSaldoDeGols() - t1.getSaldoDeGols();
        if (t1.getGolsMarcados() != t2.getGolsMarcados()) return t2.getGolsMarcados() - t1.getGolsMarcados();
        return 0;
    }
}
