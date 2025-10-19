package brasileirao;

import java.util.LinkedList;
import java.util.List;

public class Partida {
	
    private List<Sumula> resultados;
    private Time mandante;
    private Time visitante;

    public Partida() {
        resultados = new LinkedList<>();
        this.mandante = null;
        this.visitante = null;
    }
    
    public Partida(Time mandante, Time visitante) {
    	this.resultados = new LinkedList<>();
    	this.mandante = mandante;
    	this.visitante = visitante;
    }

    public void registrarResultado(int golsMandante, int golsVisitante) {
        Sumula s = new Sumula(golsMandante, golsVisitante);
        resultados.add(s);
        
        if (mandante != null) {
        	mandante.adicionarPontos(s.getPontosMandante());
        }
        if (visitante != null) {
        	visitante.adicionarPontos(s.getPontosVisitante());
        }
    }
	
    public String getResultados() {
        List<String> todos = new LinkedList<>();
        for (Sumula s : resultados) {
            todos.add(s.toString());
        }
        return String.join("\n", todos);
    }
}
