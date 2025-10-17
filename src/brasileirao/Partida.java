package brasileirao;

import java.util.ArrayList;
import java.util.List;

public class Partida {

    public List<Object> gerarRodada(int numTimes) { 
        List<Object> partidas = new ArrayList<>();
        if (numTimes == 20) {
            for (int i = 0; i < 10; i++) {
                partidas.add(null);
            }
        }
        return partidas;
    }

}
