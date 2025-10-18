package brasileirao;

import java.util.LinkedList;
import java.util.List;

public class Partida {
	
    private List<Sumula> resultados;

    public Partida() {
        resultados = new LinkedList<>();
    }

    public void registrarResultado(int golsMandante, int golsVisitante) {
        Sumula s = new Sumula(golsMandante, golsVisitante);
        resultados.add(s);
    }
	
    public String getResultados() {
        List<String> todos = new LinkedList<>();
        for (Sumula s : resultados) {
            todos.add(s.toString());
        }
        return String.join("\n", todos);
    }
}
