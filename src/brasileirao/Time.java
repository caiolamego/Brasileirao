package brasileirao;

public class Time {
	
	private String nome;
	private int pontos;
	private int vitorias;
	
	public Time(String nome) {
		this.nome = nome;
		this.pontos = 0;
		this.vitorias = 0;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getPontos() {
		return pontos;
	}
	
	public int getVitorias() {
		return vitorias;
	}

}
