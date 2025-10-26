package brasileirao;

public class Time {
	
	private String nome;
	private int pontos;
	private int vitorias;
	private int empates;
	private int derrotas;
	private int golsMarcados;
	private int golsSofridos;
	private int saldoDeGols;
	
	public Time(String nome) {
		this.nome = nome;
		this.pontos = 0;
		this.vitorias = 0;
		this.empates = 0;
		this.derrotas = 0;
		this.golsMarcados = 0;
		this.golsSofridos = 0;
		this.saldoDeGols = 0;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void adicionarPontos(int pontos) {
		this.pontos += pontos;
	}
	
	public int getPontos() {
		return this.pontos;
	}

	public int getVitorias() { return vitorias; }
	public int getEmpates() { return empates; }
	public int getDerrotas() { return derrotas; }
	public int getGolsMarcados() { return golsMarcados; }
	public int getGolsSofridos() { return golsSofridos; }
	public int getSaldoDeGols() { return saldoDeGols; }

	public void adicionarPartidaJogada(int golsFeitos, int golsSofridos) {
		this.golsMarcados += golsFeitos;
		this.golsSofridos += golsSofridos;
		this.saldoDeGols = this.golsMarcados - this.golsSofridos;

		if (golsFeitos > golsSofridos) {
			this.vitorias++;
			this.pontos += 3;
		} else if (golsFeitos == golsSofridos) {
			this.empates++;
			this.pontos += 1;
		} else {
			this.derrotas++;
		}
	}

}
