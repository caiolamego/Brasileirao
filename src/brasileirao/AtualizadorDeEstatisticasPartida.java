package brasileirao;

public class AtualizadorDeEstatisticasPartida {

    private final EstatisticasTime estatisticas;
    private final int golsFeitos;
    private final int golsSofridos;

    public AtualizadorDeEstatisticasPartida(EstatisticasTime estatisticas, int golsFeitos, int golsSofridos) {
        this.estatisticas = estatisticas;
        this.golsFeitos = golsFeitos;
        this.golsSofridos = golsSofridos;
    }

    public void processar() {

        estatisticas.setGolsMarcados(estatisticas.getGolsMarcados() + golsFeitos);
        estatisticas.setGolsSofridos(estatisticas.getGolsSofridos() + golsSofridos);
        estatisticas.setSaldoDeGols(estatisticas.getGolsMarcados() - estatisticas.getGolsSofridos());

        if (golsFeitos > golsSofridos) {
            estatisticas.setVitorias(estatisticas.getVitorias() + 1);
            estatisticas.adicionarPontos(3);
        } else if (golsFeitos == golsSofridos) {
            estatisticas.setEmpates(estatisticas.getEmpates() + 1);
            estatisticas.adicionarPontos(1);
        } else {
            estatisticas.setDerrotas(estatisticas.getDerrotas() + 1);
        }
    }
}