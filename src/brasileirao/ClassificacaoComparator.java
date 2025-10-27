package brasileirao;

import java.util.Comparator;

public class ClassificacaoComparator implements Comparator<Time> {
    @Override
    public int compare(Time t1, Time t2) {
        if (t1.getPontos() != t2.getPontos()) return t2.getPontos() - t1.getPontos();
        if (t1.getVitorias() != t2.getVitorias()) return t2.getVitorias() - t1.getVitorias();
        if (t1.getSaldoDeGols() != t2.getSaldoDeGols()) return t2.getSaldoDeGols() - t1.getSaldoDeGols();
        return 0;
    }
}
