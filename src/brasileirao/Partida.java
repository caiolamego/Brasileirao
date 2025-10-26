package brasileirao;

public class Partida {
	
    private Time mandante;
    private Time visitante;
    private int golsMandante;
    private int golsVisitante;
    private boolean resultadoRegistrado;


    public Partida() {
        this(null, null);
    }

    public Partida(Time mandante, Time visitante) {
    	this.mandante = mandante;
    	this.visitante = visitante;
        this.golsMandante = 0;
        this.golsVisitante = 0;
        this.resultadoRegistrado = false;
    }

    public Time getMandante() { return mandante; }
    public Time getVisitante() { return visitante; }

    public void registrarResultado(int golsMandante, int golsVisitante) {
        this.golsMandante = golsMandante;
        this.golsVisitante = golsVisitante;
        this.resultadoRegistrado = true;
    }

    public void processarResultado() {
        if (!resultadoRegistrado) {
            throw new IllegalStateException("Resultado ainda não foi registrado.");
        }
        if (mandante != null) {
            mandante.adicionarPartidaJogada(golsMandante, golsVisitante);
        }
        if (visitante != null) {
            visitante.adicionarPartidaJogada(golsVisitante, golsMandante);
        }
    }
	
    public String getResultado() {
        return golsMandante + " x " + golsVisitante;
    }

}
