package brasileirao;

public class EstatisticasTime {

    private int pontos;
    private int vitorias;
    private int empates;
    private int derrotas;
    private int golsMarcados;
    private int golsSofridos;
    private int saldoDeGols;

    public EstatisticasTime() {
        this.pontos = 0;
        this.vitorias = 0;
        this.empates = 0;
        this.derrotas = 0;
        this.golsMarcados = 0;
        this.golsSofridos = 0;
        this.saldoDeGols = 0;
    }

    public int getPontos() { return pontos; }
    public int getVitorias() { return vitorias; }
    public int getEmpates() { return empates; }
    public int getDerrotas() { return derrotas; }
    public int getGolsMarcados() { return golsMarcados; }
    public int getGolsSofridos() { return golsSofridos; }
    public int getSaldoDeGols() { return saldoDeGols; }

    public void adicionarPontos(int pontos) {
        this.pontos += pontos;
    }
    public void setGolsMarcados(int golsMarcados) { this.golsMarcados = golsMarcados; }
    public void setGolsSofridos(int golsSofridos) { this.golsSofridos = golsSofridos; }
    public void setSaldoDeGols(int saldoDeGols) { this.saldoDeGols = saldoDeGols; }
    public void setVitorias(int vitorias) { this.vitorias = vitorias; }
    public void setEmpates(int empates) { this.empates = empates; }
    public void setDerrotas(int derrotas) { this.derrotas = derrotas; }
}