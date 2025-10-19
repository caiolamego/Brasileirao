package brasileirao;

public class Time {
	
	private String nome;
	private int pontos;
	
	public Time(String nome) {
		this.nome = nome;
		this.pontos = 0;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void adicionarPontos(int pontos) {
		this.pontos = 3;
	}
	
	public int getPontos() {
		return this.pontos;
	}

}
