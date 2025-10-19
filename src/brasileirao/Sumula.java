package brasileirao;

public class Sumula {

    private int golsMandante;
    private int golsVisitante;
    private int pontosMandante;
    private int pontosVisitante;

    public Sumula(int golsMandante, int golsVisitante) {
        this.golsMandante = golsMandante;
        this.golsVisitante = golsVisitante;
        
        if(golsMandante > golsVisitante) {
        	this.pontosMandante = 3;
        	this.pontosVisitante = 0;
        } else if (golsVisitante >  golsMandante) {
        	this.pontosMandante = 0;
        	this.pontosVisitante = 3;
        } else {
        	this.pontosMandante = 1;
        	this.pontosVisitante = 1;
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
