package brasileirao;

public class Time {
	
	private String nome;
	// NOVO CAMPO DELEGADO
    private EstatisticasTime estatisticas;
	
	public Time(String nome) {
		this.nome = nome;
        this.estatisticas = new EstatisticasTime();
	}
	
	public String getNome() {
		return nome;
	}

	public void adicionarPontos(int pontos) {
		this.estatisticas.adicionarPontos(pontos);
	}
	
	public int getPontos() {
		return this.estatisticas.getPontos();
	}

    public int getVitorias() { return this.estatisticas.getVitorias(); }
	public int getEmpates() { return this.estatisticas.getEmpates(); }
	public int getDerrotas() { return this.estatisticas.getDerrotas(); }
	public int getGolsMarcados() { return this.estatisticas.getGolsMarcados(); }
	public int getGolsSofridos() { return this.estatisticas.getGolsSofridos(); }
	public int getSaldoDeGols() { return this.estatisticas.getSaldoDeGols(); }

	public void adicionarPartidaJogada(int golsFeitos, int golsSofridos) {
		new AtualizadorDeEstatisticasPartida(this.estatisticas, golsFeitos, golsSofridos).processar(); 
	}
}