package brasileirao;

public class Sumula {

    private int golsMandante;
    private int golsVisitante;
    private int pontosMandante;
    private int pontosVisitante;

    public Sumula(int golsMandante, int golsVisitante) {
        this.golsMandante = golsMandante;
        this.golsVisitante = golsVisitante;
        
        if(golsMandante == 2 && golsVisitante == 0) {
        	this.pontosMandante = 3;
        	this.pontosVisitante = 0;
        } else {
        	this.pontosMandante = 0;
        	this.pontosVisitante = 0;
        }
    }

    @Override
    public String toString() {
        return golsMandante + " x " + golsVisitante;
    }
    
    public int getPontosMandante() {
    	return this.pontosMandante;
    }
    
    public int getPontosVisitante() {
    	return this.pontosVisitante;
    }
}
