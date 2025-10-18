package brasileirao;

public class Partida {
	
	private int golsMandante;
	private int golsVisitante;
	private String resultado;

	public void registrarResultado(int golsMandante, int golsVisitante) {
		this.golsMandante = golsMandante;
		this.golsVisitante = golsVisitante;	
		this.resultado = golsMandante + " x " + golsVisitante;
	}
	
	public String getResultado() {
		return resultado;
	}

}
