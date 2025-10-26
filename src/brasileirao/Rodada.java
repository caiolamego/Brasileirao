package brasileirao;

import java.util.ArrayList;
import java.util.List;

public class Rodada {
    private final List<Partida> partidas = new ArrayList<>();

    public void addPartida(Partida p) {
        partidas.add(p);
    }

    public List<Partida> getPartidas() {
        return partidas;
    }
}
