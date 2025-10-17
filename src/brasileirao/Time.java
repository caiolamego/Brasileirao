package brasileirao;

public class Time {
    private String nome;
    private int pontos;
    private int vitorias;
    private int golsMarcados;
    private int golsSofridos;
    
    public Time(String nome) {
        this.nome = nome;
        this.pontos = 0;
        this.vitorias = 0;
        this.golsMarcados = 0;
        this.golsSofridos = 0;
    }
    
    public String getNome() { return nome; }
    public int getPontos() { return pontos; }
    public int getVitorias() { return vitorias; }
    public int getGolsMarcados() { return golsMarcados; }
    public int getGolsSofridos() { return golsSofridos; }
    public int getSaldoGols() { return golsMarcados - golsSofridos; }
}