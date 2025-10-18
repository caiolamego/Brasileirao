package brasileirao;

public class Sumula {

    private int golsMandante;
    private int golsVisitante;

    public Sumula(int golsMandante, int golsVisitante) {
        this.golsMandante = golsMandante;
        this.golsVisitante = golsVisitante;
    }

    @Override
    public String toString() {
        return golsMandante + " x " + golsVisitante;
    }
}
